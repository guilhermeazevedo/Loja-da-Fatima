package br.com.lojadafatima.CompraVendaOperacoes;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import br.com.lojadafatima.Financeiro.ClasseCondicaoPagamento;
import br.com.lojadafatima.Pessoa.ClasseFuncionario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClasseCompraVenda {

    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private String descricao;
    private ClasseOperacoes operacao = new ClasseOperacoes();
    private int codigopessoa;
    private ClasseFuncionario funcionario = new ClasseFuncionario();
    private ClasseCondicaoPagamento condicao = new ClasseCondicaoPagamento();
    private String data;

    public void incluir() {
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("COMPRA_VENDA", "CD_COMPRA_VENDA", "CD_OPERACAO", getOperacao().getCodigo()));
        if (getCondicao().getCodigo() != 0) {
            conn.incluirSQL("INSERT INTO bancoloja.\"COMPRA_VENDA\"(\n"
                    + "            \"CD_COMPRA_VENDA\", \"CD_OPERACAO\", \"DS_COMPRA_VENDA\", \"CD_PESSOA\", \n"
                    + "            \"CD_FUNCIONARIO\", \"CD_CONDICAO_PGTO\", \"DT_COMPRA_VENDA\")\n"
                    + " VALUES (" + getCodigo() + ", " + getOperacao().getCodigo() + ", '" + getDescricao().toUpperCase() + "', " + getCodigopessoa() + ", \n"
                    + "         " + getFuncionario().getCodigo() + ", " + getCondicao().getCodigo() + ", '" + getData() + "')");
        } else {
            conn.incluirSQL("INSERT INTO bancoloja.\"COMPRA_VENDA\"(\n"
                    + "            \"CD_COMPRA_VENDA\", \"CD_OPERACAO\", \"DS_COMPRA_VENDA\", \"CD_PESSOA\", \n"
                    + "            \"CD_FUNCIONARIO\", \"DT_COMPRA_VENDA\")\n"
                    + " VALUES (" + getCodigo() + ", " + getOperacao().getCodigo() + ", '" + getDescricao().toUpperCase() + "', " + getCodigopessoa() + ", \n"
                    + "         " + getFuncionario().getCodigo() + ", '" + getData() + "')");
        }
    }

    public void cancelarcompravenda() {
        conn.atualizarSQL("UPDATE bancoloja.\"COMPRA_VENDA\" SET \"DS_COMPRA_VENDA\" = (\"DS_COMPRA_VENDA\" || ' - CANCELADO DIA ' || TO_CHAR(CURRENT_DATE, 'DD/MM/YYYY'))\n"
                + "WHERE \"CD_COMPRA_VENDA\" = " + getCodigo() + " AND \"CD_OPERACAO\" = " + getOperacao().getCodigo());
    }

    public ResultSet numerocomprasclientesmaiscompram() {
        conn.executeSQL("SELECT CASE WHEN \"P\".\"TP_PESSOA\" = 'F' \n"
                + "THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\") \n"
                + "ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"NOME\", \n"
                + "CASE WHEN \"P\".\"TP_PESSOA\" = 'F' \n"
                + "THEN (SELECT \"NR_CPF\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\"= \"P\".\"CD_PESSOA\") \n"
                + "ELSE (SELECT \"NR_CNPJ\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"CPFCNPJ\",\n"
                + "COUNT(\"CV\".\"CD_PESSOA\") AS \"NR\"\n"
                + "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n"
                + "JOIN bancoloja.\"COMPRA_VENDA\" \"CV\"\n"
                + "ON \"CV\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n"
                + "WHERE \"C\".\"SITUACAO\" = 'A' AND \"CV\".\"DS_COMPRA_VENDA\" NOT LIKE '% - CANCELADO DIA %' AND \"CV\".\"CD_OPERACAO\" = 2\n"
                + "GROUP BY \"NOME\", \"CPFCNPJ\"\n"
                + "ORDER BY \"NR\" DESC");
        return conn.resultset;
    }

    public ResultSet numerocomprasclientesmenoscompram() {
        conn.executeSQL("SELECT CASE WHEN \"P\".\"TP_PESSOA\" = 'F' \n"
                + "THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\") \n"
                + "ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"NOME\", \n"
                + "CASE WHEN \"P\".\"TP_PESSOA\" = 'F' \n"
                + "THEN (SELECT \"NR_CPF\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\"= \"P\".\"CD_PESSOA\") \n"
                + "ELSE (SELECT \"NR_CNPJ\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"CPFCNPJ\",\n"
                + "COUNT(\"CV\".\"CD_PESSOA\") AS \"NR\"\n"
                + "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n"
                + "JOIN bancoloja.\"COMPRA_VENDA\" \"CV\"\n"
                + "ON \"CV\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n"
                + "WHERE \"C\".\"SITUACAO\" = 'A' AND \"CV\".\"DS_COMPRA_VENDA\" NOT LIKE '% - CANCELADO DIA %' AND \"CV\".\"CD_OPERACAO\" = 2\n"
                + "GROUP BY \"NOME\", \"CPFCNPJ\"\n"
                + "ORDER BY \"NR\" ASC");
        return conn.resultset;
    }

    public ResultSet numerovendasfornecedoresmaisvendem() {
        conn.executeSQL("SELECT \"PJ\".\"NM_FANTASIA\", \"PJ\".\"NR_CNPJ\", COUNT(\"CV\".\"CD_PESSOA\") AS \"NR\"\n"
                + "FROM bancoloja.\"CAD_FORNECEDOR\" \"F\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA_JURIDICA\" \"PJ\" ON \"F\".\"CD_PESSOA_JUR\" = \"PJ\".\"CD_PESSOA_JUR\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"P\".\"CD_PESSOA\" = \"F\".\"CD_PESSOA_JUR\"\n"
                + "JOIN bancoloja.\"COMPRA_VENDA\" \"CV\" ON \"P\".\"CD_PESSOA\" = \"CV\".\"CD_PESSOA\"\n"
                + "WHERE \"P\".\"SITUACAO\" = 'A' AND \"CV\".\"CD_OPERACAO\" = 1 AND \"CV\".\"DS_COMPRA_VENDA\" NOT LIKE '% - CANCELADO DIA %'\n"
                + "GROUP BY \"PJ\".\"NM_FANTASIA\", \"PJ\".\"NR_CNPJ\"\n"
                + "ORDER BY \"NR\" DESC");
        return conn.resultset;
    }

    public ResultSet numerovendasfornecedoresmenosvendem() {
        conn.executeSQL("SELECT \"PJ\".\"NM_FANTASIA\", \"PJ\".\"NR_CNPJ\", COUNT(\"CV\".\"CD_PESSOA\") AS \"NR\"\n"
                + "FROM bancoloja.\"CAD_FORNECEDOR\" \"F\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA_JURIDICA\" \"PJ\" ON \"F\".\"CD_PESSOA_JUR\" = \"PJ\".\"CD_PESSOA_JUR\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"P\".\"CD_PESSOA\" = \"F\".\"CD_PESSOA_JUR\"\n"
                + "JOIN bancoloja.\"COMPRA_VENDA\" \"CV\" ON \"P\".\"CD_PESSOA\" = \"CV\".\"CD_PESSOA\"\n"
                + "WHERE \"P\".\"SITUACAO\" = 'A' AND \"CV\".\"CD_OPERACAO\" = 1 AND \"CV\".\"DS_COMPRA_VENDA\" NOT LIKE '% - CANCELADO DIA %'\n"
                + "GROUP BY \"PJ\".\"NM_FANTASIA\", \"PJ\".\"NR_CNPJ\"\n"
                + "ORDER BY \"NR\" ASC");
        return conn.resultset;
    }

    public ResultSet operacoesfuncionariomesatual() {
        conn.executeSQL("SELECT \"CV\".\"CD_COMPRA_VENDA\",\n"
                + "(SELECT \"DS_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\" WHERE \"CD_OPERACAO\" = \"CV\".\"CD_OPERACAO\"),\n"
                + "\"CV\".\"DS_COMPRA_VENDA\",\n"
                + "TO_CHAR(\"CV\".\"DT_COMPRA_VENDA\", 'DD/MM/YYYY HH24:MI:SS')\n"
                + "FROM bancoloja.\"COMPRA_VENDA\" \"CV\"\n"
                + "WHERE \"CV\".\"CD_FUNCIONARIO\" = " + getFuncionario().getCodigo() + " AND \"CV\".\"CD_OPERACAO\" = " + getOperacao().getCodigo() + " AND \"CV\".\"DS_COMPRA_VENDA\" NOT LIKE '% - CANCELADO DIA %' AND\n"
                + "DATE_PART('MONTH', \"CV\".\"DT_COMPRA_VENDA\") = DATE_PART('MONTH', CURRENT_DATE) AND\n"
                + "DATE_PART('YEAR', \"CV\".\"DT_COMPRA_VENDA\") = DATE_PART('YEAR', CURRENT_DATE) ORDER BY \"CV\".\"CD_COMPRA_VENDA\" DESC");
        return conn.resultset;
    }

    public ResultSet operacoesfuncionariomesanterior() {
        conn.executeSQL("SELECT DATE_PART('MONTH', CURRENT_DATE)");
        int meshj;
        try {
            conn.resultset.first();
            meshj = conn.resultset.getInt(1);
        } catch (SQLException ex) {
            meshj = 0;
        }
        if (meshj == 1) {
            conn.executeSQL("SELECT \"CV\".\"CD_COMPRA_VENDA\",\n"
                    + "(SELECT \"DS_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\" WHERE \"CD_OPERACAO\" = \"CV\".\"CD_OPERACAO\"),\n"
                    + "\"CV\".\"DS_COMPRA_VENDA\",\n"
                    + "TO_CHAR(\"CV\".\"DT_COMPRA_VENDA\", 'DD/MM/YYYY HH24:MI:SS')\n"
                    + "FROM bancoloja.\"COMPRA_VENDA\" \"CV\"\n"
                    + "WHERE \"CV\".\"CD_FUNCIONARIO\" = " + getFuncionario().getCodigo() + " AND \"CV\".\"CD_OPERACAO\" = " + getOperacao().getCodigo() + " AND \"CV\".\"DS_COMPRA_VENDA\" NOT LIKE '% - CANCELADO DIA %' AND\n"
                    + "DATE_PART('MONTH', \"CV\".\"DT_COMPRA_VENDA\") = DATE_PART('MONTH', CURRENT_DATE - 31) AND\n"
                    + "DATE_PART('YEAR', \"CV\".\"DT_COMPRA_VENDA\") = (DATE_PART('YEAR', CURRENT_DATE) - 1) ORDER BY \"CV\".\"CD_COMPRA_VENDA\" DESC");
        } else {
            conn.executeSQL("SELECT \"CV\".\"CD_COMPRA_VENDA\",\n"
                    + "(SELECT \"DS_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\" WHERE \"CD_OPERACAO\" = \"CV\".\"CD_OPERACAO\"),\n"
                    + "\"CV\".\"DS_COMPRA_VENDA\",\n"
                    + "TO_CHAR(\"CV\".\"DT_COMPRA_VENDA\", 'DD/MM/YYYY HH24:MI:SS')\n"
                    + "FROM bancoloja.\"COMPRA_VENDA\" \"CV\"\n"
                    + "WHERE \"CV\".\"CD_FUNCIONARIO\" = " + getFuncionario().getCodigo() + " AND \"CV\".\"CD_OPERACAO\" = " + getOperacao().getCodigo() + " AND \"CV\".\"DS_COMPRA_VENDA\" NOT LIKE '% - CANCELADO DIA %' AND\n"
                    + "DATE_PART('MONTH', \"CV\".\"DT_COMPRA_VENDA\") = (DATE_PART('MONTH', CURRENT_DATE) - 1) AND\n"
                    + "DATE_PART('YEAR', \"CV\".\"DT_COMPRA_VENDA\") = DATE_PART('YEAR', CURRENT_DATE) ORDER BY \"CV\".\"CD_COMPRA_VENDA\" DESC");
        }
        return conn.resultset;
    }

    public ResultSet operacoesfuncionarioano() {
        conn.executeSQL("SELECT \"CV\".\"CD_COMPRA_VENDA\",\n"
                + "(SELECT \"DS_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\" WHERE \"CD_OPERACAO\" = \"CV\".\"CD_OPERACAO\"),\n"
                + "\"CV\".\"DS_COMPRA_VENDA\",\n"
                + "TO_CHAR(\"CV\".\"DT_COMPRA_VENDA\", 'DD/MM/YYYY HH24:MI:SS')\n"
                + "FROM bancoloja.\"COMPRA_VENDA\" \"CV\"\n"
                + "WHERE \"CV\".\"CD_FUNCIONARIO\" = " + getFuncionario().getCodigo() + " AND \"CV\".\"CD_OPERACAO\" = " + getOperacao().getCodigo() + " AND \"CV\".\"DS_COMPRA_VENDA\" NOT LIKE '% - CANCELADO DIA %' AND\n"
                + "DATE_PART('YEAR', \"CV\".\"DT_COMPRA_VENDA\") = DATE_PART('YEAR', CURRENT_DATE) ORDER BY \"CV\".\"CD_COMPRA_VENDA\" DESC");
        return conn.resultset;
    }

    public ResultSet operacoesfuncionariosempre() {
        conn.executeSQL("SELECT \"CV\".\"CD_COMPRA_VENDA\",\n"
                + "(SELECT \"DS_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\" WHERE \"CD_OPERACAO\" = \"CV\".\"CD_OPERACAO\"),\n"
                + "\"CV\".\"DS_COMPRA_VENDA\",\n"
                + "TO_CHAR(\"CV\".\"DT_COMPRA_VENDA\", 'DD/MM/YYYY HH24:MI:SS')\n"
                + "FROM bancoloja.\"COMPRA_VENDA\" \"CV\"\n"
                + "WHERE \"CV\".\"CD_FUNCIONARIO\" = " + getFuncionario().getCodigo() + " AND \"CV\".\"CD_OPERACAO\" = " + getOperacao().getCodigo() + "\n AND \"CV\".\"DS_COMPRA_VENDA\" NOT LIKE '% - CANCELADO DIA %' ORDER BY \"CV\".\"CD_COMPRA_VENDA\" DESC");
        return conn.resultset;
    }

    public ResultSet operacoesdeestoque() {
        conn.executeSQL("SELECT \"CV\".\"CD_COMPRA_VENDA\",\n"
                + "(SELECT \"DS_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\" WHERE \"CD_OPERACAO\" = \"CV\".\"CD_OPERACAO\"),\n"
                + "\"CV\".\"DS_COMPRA_VENDA\",\n"
                + "TO_CHAR(\"CV\".\"DT_COMPRA_VENDA\", 'DD/MM/YYYY HH24:MI:SS')\n"
                + "FROM bancoloja.\"COMPRA_VENDA\" \"CV\"\n"
                + "WHERE \"CV\".\"CD_OPERACAO\" IN (SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\" WHERE (\"IN_ESTOQUE\" = 'S' OR \"CV\".\"CD_OPERACAO\" = 3) AND \"IN_FINANCEIRO\" = 'N')\n"
                + "ORDER BY \"CV\".\"DT_COMPRA_VENDA\" DESC");
        return conn.resultset;
    }

    public void retornainformacoescompravenda() {
        conn.executeSQL("SELECT \"CV\".\"DS_COMPRA_VENDA\", TO_CHAR(\"CV\".\"DT_COMPRA_VENDA\", 'DD/MM/YYYY HH24:MI:SS'),\n"
                + "(SELECT \"DS_CONDICAO_PGTO\" FROM bancoloja.\"CAD_CONDICAO_PGTO\" WHERE \"CD_CONDICAO_PGTO\" = \"CV\".\"CD_CONDICAO_PGTO\"),\n"
                + "\"CV\".\"CD_PESSOA\", \"CV\".\"CD_FUNCIONARIO\"\n"
                + "FROM bancoloja.\"COMPRA_VENDA\" \"CV\"\n"
                + "WHERE \"CV\".\"CD_COMPRA_VENDA\" = " + getCodigo() + " AND \"CV\".\"CD_OPERACAO\" = " + getOperacao().getCodigo());
        try {
            conn.resultset.first();
            setDescricao(conn.resultset.getString(1));
            setData(conn.resultset.getString(2));
            getCondicao().setCondicaodepgto(conn.resultset.getString(3));
            setCodigopessoa(conn.resultset.getInt(4));
            getFuncionario().setCodigo(conn.resultset.getInt(5));
        } catch (SQLException ex) {
            setDescricao("");
            setData("");
            getCondicao().setCondicaodepgto("");
            setCodigopessoa(0);
            getFuncionario().setCodigo(0);
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public int getCodigopessoa() {
        return codigopessoa;
    }

    public void setCodigopessoa(int codigopessoa) {
        this.codigopessoa = codigopessoa;
    }

    public ClasseFuncionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(ClasseFuncionario funcionario) {
        this.funcionario = funcionario;
    }

    public ClasseCondicaoPagamento getCondicao() {
        return condicao;
    }

    public void setCondicao(ClasseCondicaoPagamento condicao) {
        this.condicao = condicao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
