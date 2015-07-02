package br.com.lojadafatima.Financeiro;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.CompraVendaOperacoes.ClasseCompraVenda;
import br.com.lojadafatima.CompraVendaOperacoes.ClasseOperacoes;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClasseContasPagarReceber {

    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private ClasseCompraVenda compravenda = new ClasseCompraVenda();
    private String descricao;
    private int codigopessoa;
    private ClasseOperacoes operacao = new ClasseOperacoes();
    private ClasseCondicaoPagamento condicao = new ClasseCondicaoPagamento();
    private ClasseMulta multa = new ClasseMulta();
    private float total;
    private String dtconta;
    private String situacao;

    public void incluir() {
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CONTAS_PAGAR_RECEBER", "CD_CONTA", "CD_OPERACAO", getOperacao().getCodigo()));
        getMulta().getultimamulta();
        if (getCompravenda().getCodigo() == 0) {
            conn.executeSQL("INSERT INTO bancoloja.\"CONTAS_PAGAR_RECEBER\"(\n"
                    + "            \"CD_CONTA\", \"CD_OPERACAO\", \"CD_PESSOA\",\n"
                    + "            \"DS_CONTA\", \"CD_CONDICAO_PGTO\", \"CD_MULTA\", \"VL_TOTAL\", \"DT_CONTA\", \"SITUACAO\")\n"
                    + "VALUES (" + getCodigo() + ", " + getOperacao().getCodigo() + ", " + getCodigopessoa() + ",\n"
                    + "        '" + getDescricao() + "', " + getCondicao().getCodigo() + ", " + getMulta().getCodigo() + ", " + getTotal() + ", '" + getDtconta() + "', 'A')");
        } else {
            conn.executeSQL("INSERT INTO bancoloja.\"CONTAS_PAGAR_RECEBER\"(\n"
                    + "            \"CD_CONTA\", \"CD_OPERACAO\", \"CD_COMPRA_VENDA\", \"CD_OPERACAO_COMPRA_VENDA\", \"CD_PESSOA\",\n"
                    + "            \"DS_CONTA\", \"CD_CONDICAO_PGTO\", \"CD_MULTA\", \"VL_TOTAL\", \"DT_CONTA\", \"SITUACAO\")\n"
                    + "VALUES (" + getCodigo() + ", " + getOperacao().getCodigo() + ", " + getCompravenda().getCodigo() + ", " + getCompravenda().getOperacao().getCodigo() + ", " + getCodigopessoa() + ",\n"
                    + "        '" + getDescricao() + "', " + getCondicao().getCodigo() + ", " + getMulta().getCodigo() + ", " + getTotal() + ", '" + getDtconta() + "', 'A')");
        }
    }

    public void cancelarconta() {
        conn.executeSQL("UPDATE bancoloja.\"CONTAS_PAGAR_RECEBER\" SET \"SITUACAO\" = 'C',\n"
                + "                                           \"DS_CONTA\" = (\"DS_CONTA\" || ' - CANCELADA DIA ' || TO_CHAR(CURRENT_DATE, 'DD/MM/YYYY'))\n"
                + "WHERE \"CD_CONTA\" = " + getCodigo() + " AND \"CD_OPERACAO\" = " + getOperacao().getCodigo());
    }
    
    public ResultSet retornatodasaspessoa(){
        conn.executeSQL("(SELECT CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n" +
                        "            THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\")\n" +
                        "            ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\")\n" +
                        "            END AS \"NOME\",\n" +
                        "            'CLIENTE' AS \"TIPO\"\n" +
                        "FROM bancoloja.\"CAD_PESSOA\" \"P\"\n" +
                        "WHERE \"P\".\"CD_PESSOA\" IN (SELECT \"CD_PESSOA\" FROM bancoloja.\"CAD_CLIENTE\"))\n" +
                        "UNION\n" +
                        "(SELECT CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n" +
                        "            THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\")\n" +
                        "            ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\")\n" +
                        "            END AS \"NOME\",\n" +
                        "            'FORNECEDOR' AS \"TIPO\"\n" +
                        "FROM bancoloja.\"CAD_PESSOA\" \"P\"\n" +
                        "WHERE \"P\".\"CD_PESSOA\" IN (SELECT \"CD_PESSOA_JUR\" FROM bancoloja.\"CAD_FORNECEDOR\"))\n" +
                        "ORDER BY \"NOME\"");
        return conn.resultset;
    }
    
    public ResultSet retornafornecedor(int cdfornecedor){
        conn.executeSQL("SELECT CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n" +
                        "            THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\")\n" +
                        "            ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\")\n" +
                        "            END AS \"NOME\",\n" +
                        "            'FORNECEDOR' AS \"TIPO\"\n" +
                        "FROM bancoloja.\"CAD_PESSOA\" \"P\"\n" +
                        "WHERE \"P\".\"CD_PESSOA\" IN (SELECT \"CD_PESSOA_JUR\" FROM bancoloja.\"CAD_FORNECEDOR\"\n" +
                        "                              WHERE \"CD_PESSOA_JUR\" = "+cdfornecedor+")");
        return conn.resultset;
    }
    
    public ResultSet retornatodososfornecedor(){
        conn.executeSQL("SELECT CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n" +
                        "            THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\")\n" +
                        "            ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\")\n" +
                        "            END AS \"NOME\",\n" +
                        "            'FORNECEDOR' AS \"TIPO\"\n" +
                        "FROM bancoloja.\"CAD_PESSOA\" \"P\"\n" +
                        "WHERE \"P\".\"CD_PESSOA\" IN (SELECT \"CD_PESSOA_JUR\" FROM bancoloja.\"CAD_FORNECEDOR\")");
        return conn.resultset;
    }
    
    public ResultSet retornacliente(int cdcliente){
        conn.executeSQL("SELECT CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n" +
                        "            THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\")\n" +
                        "            ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\")\n" +
                        "            END AS \"NOME\",\n" +
                        "            'CLIENTE' AS \"TIPO\"\n" +
                        "FROM bancoloja.\"CAD_PESSOA\" \"P\"\n" +
                        "WHERE \"P\".\"CD_PESSOA\" IN (SELECT \"CD_PESSOA\" FROM bancoloja.\"CAD_CLIENTE\"\n" +
                        "                              WHERE \"CD_CLIENTE\" = "+cdcliente+")");
        return conn.resultset;
    }
    
    public ResultSet retornatodososcliente(){
        conn.executeSQL("SELECT CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n" +
                        "            THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\")\n" +
                        "            ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\")\n" +
                        "            END AS \"NOME\",\n" +
                        "            'CLIENTE' AS \"TIPO\"\n" +
                        "FROM bancoloja.\"CAD_PESSOA\" \"P\"\n" +
                        "WHERE \"P\".\"CD_PESSOA\" IN (SELECT \"CD_PESSOA\" FROM bancoloja.\"CAD_CLIENTE\")");
        return conn.resultset;
    }

    public ResultSet retornacontas(String tp1, String tp2, String tp3, String data_ini, String data_fim, int operacao, String tpconta){
        String sql = "SELECT \"C\".\"CD_CONTA\" AS \"CONTA\",\n" +
                     "      (SELECT \"DS_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n" +
                     "       WHERE \"CD_OPERACAO\" = \"C\".\"CD_OPERACAO\"),\n" +
                     "      CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n" +
                     "           THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"C\".\"CD_PESSOA\")\n" +
                     "           ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\") END AS \"NOME\",\n" +
                     "      (SELECT \"DS_CONDICAO_PGTO\" FROM bancoloja.\"CAD_CONDICAO_PGTO\"\n" +
                     "       WHERE \"CD_CONDICAO_PGTO\" = \"C\".\"CD_CONDICAO_PGTO\") AS \"CONDICAO\",\n" +
                     "     TO_CHAR(\"C\".\"DT_CONTA\", 'DD/MM/YYYY'),\n" +
                     "      \"C\".\"VL_TOTAL\",\n" +
                     "      CASE WHEN \"C\".\"SITUACAO\" = 'A'\n" +
                     "           THEN 'ABERTA'\n" +
                     "           ELSE CASE WHEN \"C\".\"SITUACAO\" = 'V'\n" +
                     "                     THEN 'VENCIDA'\n" +
                     "                     ELSE 'PAGA' END END AS \"SITUACAO\"\n" +
                     "      FROM bancoloja.\"CONTAS_PAGAR_RECEBER\" \"C\"\n" +
                     "      JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n" +
                     "      ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\""+
                     "WHERE \"C\".\"SITUACAO\" <> 'C' " + 
                     "    AND  ((\"C\".\"SITUACAO\" = '"+tp1+"') OR (\"C\".\"SITUACAO\" = '"+tp2+"') OR (\"C\".\"SITUACAO\" = '"+tp3+"'))";
        if (!data_ini.equals("") && !data_fim.equals("")){
            sql = sql + " AND (('"+data_ini+"' <= ANY(SELECT \"P\".\"DT_PAGAR\" FROM bancoloja.\"PARCELAS\" \"P\" WHERE \"P\".\"DT_PAGAR\" IS NOT NULL AND \"P\".\"CD_CONTA\" = \"C\".\"CD_CONTA\" AND \"P\".\"CD_OPERACAO\" = \"C\".\"CD_OPERACAO\" AND \"P\".\"DT_PAGAR\" IS NOT NULL)) AND\n" +
                        "           ('"+data_fim+"' >= ANY(SELECT \"P\".\"DT_PAGAR\" FROM bancoloja.\"PARCELAS\" \"P\" WHERE \"P\".\"DT_PAGAR\" IS NOT NULL AND \"P\".\"CD_CONTA\" = \"C\".\"CD_CONTA\" AND \"P\".\"CD_OPERACAO\" = \"C\".\"CD_OPERACAO\" AND \"P\".\"DT_PAGAR\" IS NOT NULL))) ";
        }
        if (operacao != 0) sql = sql + " AND \"C\".\"CD_OPERACAO\" = "+ operacao;
        if (getCodigopessoa() != 0) sql = sql + " AND \"C\".\"CD_PESSOA\" = "+getCodigopessoa();
        sql = sql + " AND \"C\".\"SITUACAO\" != 'C' AND "+
                    " \"C\".\"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n" +
                    " WHERE \"TP_FINANCEIRO\" = '"+tpconta+"'))\n" +
                    " ORDER BY \"CONTA\" DESC";
        conn.executeSQL(sql);
        return conn.resultset;
    }

    public void contapaga() {
        conn.executeSQL("UPDATE bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "   SET \"SITUACAO\" = 'P'\n"
                + " WHERE \"CD_CONTA\" = " + getCodigo() + " AND \"CD_OPERACAO\" = " + getOperacao().getCodigo());
    }

    public void contavencida() {
        conn.executeSQL("UPDATE bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "   SET \"SITUACAO\" = 'V'\n"
                + " WHERE \"CD_CONTA\" = " + getCodigo() + " AND \"CD_OPERACAO\" = " + getOperacao().getCodigo());
    }

    public void contaaberta() {
        conn.executeSQL("UPDATE bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "   SET \"SITUACAO\" = 'A'\n"
                + " WHERE \"CD_CONTA\" = " + getCodigo() + " AND \"CD_OPERACAO\" = " + getOperacao().getCodigo());
    }

    public String retornadescricaodaconta() {
        conn.executeSQL("SELECT \"DS_CONTA\" FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "WHERE \"CD_CONTA\" = " + getCodigo() + " AND \"CD_OPERACAO\" = " + getOperacao().getCodigo());
        try {
            conn.resultset.first();
            return conn.resultset.getString(1);
        } catch (SQLException ex) {
            return "";
        }
    }

    public ResultSet retornatodasascontasabertas() {
        conn.executeSQL("SELECT \"CD_CONTA\", \"CD_OPERACAO\"\n"
                + "FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "WHERE \"SITUACAO\" = 'A'");
        return conn.resultset;
    }

    public void buscamultaconta() {
        conn.executeSQL("SELECT \"CD_MULTA\"\n"
                + "FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "WHERE \"CD_CONTA\" = " + getCodigo() + " AND \"CD_OPERACAO\" = " + getOperacao().getCodigo());
        try {
            conn.resultset.first();
            getMulta().setCodigo(conn.resultset.getInt(1));
            getMulta().retornamultacodigo();
        } catch (SQLException ex) {
        }
    }

    public int retornanumerocontasreceberabertas() {
        conn.executeSQL("SELECT COUNT(1) FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n" +
                        "WHERE \"SITUACAO\" = 'A' AND \"CD_OPERACAO\" IN (SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\" WHERE \"TP_FINANCEIRO\" = 'E')");
        try{
            conn.resultset.first();
            return conn.resultset.getInt(1);
        } catch(SQLException ex){
            return 0;
        }
    }

    public int retornanumerocontasrecebervencidas() {
        conn.executeSQL("SELECT COUNT(1) FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n" +
                        "WHERE \"SITUACAO\" = 'V' AND \"CD_OPERACAO\" IN (SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\" WHERE \"TP_FINANCEIRO\" = 'E')");
        try{
            conn.resultset.first();
            return conn.resultset.getInt(1);
        } catch(SQLException ex){
            return 0;
        }
    }

    public int retornanumerocontaspagarabertas() {
        conn.executeSQL("SELECT COUNT(1) FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n" +
                        "WHERE \"SITUACAO\" = 'A' AND \"CD_OPERACAO\" IN (SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\" WHERE \"TP_FINANCEIRO\" = 'S')");
        try{
            conn.resultset.first();
            return conn.resultset.getInt(1);
        } catch(SQLException ex){
            return 0;
        }
    }

    public int retornanumerocontaspagarvencidas() {
        conn.executeSQL("SELECT COUNT(1) FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n" +
                        "WHERE \"SITUACAO\" = 'V' AND \"CD_OPERACAO\" IN (SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\" WHERE \"TP_FINANCEIRO\" = 'S')");
        try{
            conn.resultset.first();
            return conn.resultset.getInt(1);
        } catch(SQLException ex){
            return 0;
        }
    }

    public boolean epessoainadimplente() {
        conn.executeSQL("SELECT * FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "WHERE \"CD_OPERACAO\" IN (SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\" WHERE \"TP_FINANCEIRO\" = 'E') AND\n"
                + "      ((\"SITUACAO\" = 'A') OR (\"SITUACAO\" = 'V')) AND\n"
                + "      \"CD_PESSOA\" = " + getCodigopessoa());
        try {
            conn.resultset.first();
            conn.resultset.getString(1);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public void retornainformacoesconta() {
        String sql = "SELECT TO_CHAR(\"C\".\"DT_CONTA\", 'DD/MM/YYYY'),\n"
                + "(SELECT \"DS_CONDICAO_PGTO\" FROM bancoloja.\"CAD_CONDICAO_PGTO\" WHERE \"CD_CONDICAO_PGTO\" = \"C\".\"CD_CONDICAO_PGTO\"),\n"
                + "(SELECT \"CD_FUNCIONARIO\" FROM bancoloja.\"COMPRA_VENDA\" WHERE \"CD_COMPRA_VENDA\" = \"C\".\"CD_COMPRA_VENDA\" AND \"CD_OPERACAO\" = \"C\".\"CD_OPERACAO_COMPRA_VENDA\"),\n"
                + "\"C\".\"CD_PESSOA\",\n"
                + "CASE WHEN \"C\".\"SITUACAO\" = 'A' THEN 'ABERTA'\n"
                + "ELSE CASE WHEN \"C\".\"SITUACAO\" = 'V' THEN 'VENCIDA'\n"
                + "ELSE CASE WHEN \"C\".\"SITUACAO\" = 'P' THEN 'PAGA' END END END,\n"
                + "\"C\".\"VL_TOTAL\",\n"
                + "\"C\".\"CD_COMPRA_VENDA\",\n"
                + "\"C\".\"CD_OPERACAO_COMPRA_VENDA\""
                + "FROM bancoloja.\"CONTAS_PAGAR_RECEBER\" \"C\"\n"
                + "WHERE \"CD_CONTA\" = " + getCodigo() + " AND \"CD_OPERACAO\" = " + getOperacao().getCodigo();
        conn.executeSQL(sql);
        try {
            conn.resultset.first();
            setDtconta(conn.resultset.getString(1));
            getCondicao().setCondicaodepgto(conn.resultset.getString(2));
            setCodigopessoa(conn.resultset.getInt(4));
            setSituacao(conn.resultset.getString(5));
            setTotal(conn.resultset.getFloat(6));
            getCompravenda().getFuncionario().setCodigo(conn.resultset.getInt(3));
            getCompravenda().setCodigo(conn.resultset.getInt(7));
            getCompravenda().getOperacao().setCodigo(conn.resultset.getInt(8));
        } catch (SQLException ex) {
            setDtconta("  /  /    ");
            getCondicao().setCondicaodepgto("");
            setCodigopessoa(0);
            setSituacao("");
            setTotal(0);
            getCompravenda().getFuncionario().setCodigo(0);
            getCompravenda().setCodigo(0);
            getCompravenda().getOperacao().setCodigo(0);
        }
    }

    public void buscarcontacompravenda() {
        conn.executeSQL("SELECT \"C\".\"CD_CONTA\", \"C\".\"CD_OPERACAO\"\n"
                + "FROM bancoloja.\"CONTAS_PAGAR_RECEBER\" \"C\"\n"
                + "JOIN bancoloja.\"COMPRA_VENDA\" \"CV\" ON \"CV\".\"CD_COMPRA_VENDA\" = \"C\".\"CD_COMPRA_VENDA\" AND \"CV\".\"CD_OPERACAO\" = \"C\".\"CD_OPERACAO_COMPRA_VENDA\"\n"
                + "WHERE \"CV\".\"CD_COMPRA_VENDA\" = "+getCompravenda().getCodigo()+" AND \"CV\".\"CD_OPERACAO\" = "+getCompravenda().getOperacao().getCodigo());
        try {
            conn.resultset.first();
            setCodigo(conn.resultset.getInt(1));
            getOperacao().setCodigo(conn.resultset.getInt(2));
        } catch (SQLException ex) {
            setCodigo(0);
            getOperacao().setCodigo(0);
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ClasseCompraVenda getCompravenda() {
        return compravenda;
    }

    public void setCompravenda(ClasseCompraVenda compravenda) {
        this.compravenda = compravenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ClasseOperacoes getOperacao() {
        return operacao;
    }

    public void setOperacao(ClasseOperacoes operacao) {
        this.operacao = operacao;
    }

    public ClasseCondicaoPagamento getCondicao() {
        return condicao;
    }

    public void setCondicao(ClasseCondicaoPagamento condicao) {
        this.condicao = condicao;
    }

    public ClasseMulta getMulta() {
        return multa;
    }

    public void setMulta(ClasseMulta multa) {
        this.multa = multa;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getDtconta() {
        return dtconta;
    }

    public void setDtconta(String dtconta) {
        this.dtconta = dtconta;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getCodigopessoa() {
        return codigopessoa;
    }

    public void setCodigopessoa(int codigopessoa) {
        this.codigopessoa = codigopessoa;
    }

}
