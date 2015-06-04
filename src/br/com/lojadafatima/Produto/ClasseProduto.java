package br.com.lojadafatima.Produto;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import br.com.lojadafatima.Pessoa.ClasseFornecedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class ClasseProduto {

    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private String descricao;
    private float estoquemin;
    private String situacao;
    private ClasseTipoProduto tiposervico = new ClasseTipoProduto();

    public boolean incluir() {
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_PRODUTO", "CD_PRODUTO"));
        if (getTiposervico().getCodigo() == 0) {
            conn.incluirSQL("INSERT INTO bancoloja.\"CAD_PRODUTO\"(\n"
                + "\"CD_PRODUTO\", \"DS_PRODUTO\", \"QT_ESTOQUE_MIN\", \"SITUACAO\", \"CD_TIPO_SERVICO\")\n"
                + "VALUES (" + getCodigo() + ", '" + getDescricao().toUpperCase() + "', " + getEstoquemin() + ", 'A', NULL)");
        } else {
            conn.incluirSQL("INSERT INTO bancoloja.\"CAD_PRODUTO\"(\n"
                + "\"CD_PRODUTO\", \"DS_PRODUTO\", \"QT_ESTOQUE_MIN\", \"SITUACAO\", \"CD_TIPO_SERVICO\")\n"
                + "VALUES (" + getCodigo() + ", '" + getDescricao().toUpperCase() + "', " + getEstoquemin() + ", 'A', "+getTiposervico().getCodigo()+")");
        }
        if (conn.retorno == 1) return true;
        else                   return false;
    }

    public boolean alterar() {
        conn.atualizarSQL("UPDATE bancoloja.\"CAD_PRODUTO\"\n"
                + "SET \"DS_PRODUTO\"= '" + getDescricao().toUpperCase() + "', \"QT_ESTOQUE_MIN\"=" + getEstoquemin() + "\n"
                + "WHERE \"CD_PRODUTO\" = " + getCodigo() + "");
        if (conn.retorno == 1) return true;
        else                   return false;
    }

    public boolean excluir() {
        conn.deleteSQL("UPDATE bancoloja.\"CAD_PRODUTO\"\n"
                + "SET \"SITUACAO\"='I'\n"
                + "WHERE \"CD_PRODUTO\"=" + getCodigo() + ";");
        if (conn.retorno == 1) return true;
        else                   return false;
    }

    public ResultSet consultageral(boolean pesqproduto) {
        if (pesqproduto) conn.executeSQL("SELECT \"P\".\"CD_PRODUTO\", \"P\".\"DS_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\", \"P\".\"QT_ESTOQUE_MIN\"\n"
                                       + "FROM bancoloja.\"CAD_PRODUTO\" \"P\"\n"
                                       + "JOIN bancoloja.\"CAD_CARACTERISTICAS_PRODUTO\" \"CP\" ON \"P\".\"CD_PRODUTO\" = \"CP\".\"CD_PRODUTO\"\n"
                                       + "JOIN bancoloja.\"CAD_TIPO_PRODUTO\" \"TP\" ON \"CP\".\"CD_TIPO_PRODUTO\" = \"TP\".\"CD_TIPO_PRODUTO\"\n"
                                       + "WHERE \"P\".\"SITUACAO\" = 'A'\n"
                                       + "GROUP BY \"P\".\"CD_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\"\n"
                                       + "ORDER BY \"P\".\"CD_PRODUTO\"");
        else conn.executeSQL("SELECT \"P\".\"CD_PRODUTO\", \"P\".\"DS_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\", \"P\".\"QT_ESTOQUE_MIN\"\n" +
                             "FROM bancoloja.\"CAD_PRODUTO\" \"P\"\n" +
                             "JOIN bancoloja.\"CAD_TIPO_PRODUTO\" \"TP\" ON \"P\".\"CD_TIPO_SERVICO\" = \"TP\".\"CD_TIPO_PRODUTO\"\n" +
                             "WHERE \"P\".\"SITUACAO\" = 'A'\n" +
                             "ORDER BY \"P\".\"CD_PRODUTO\"");
        return conn.resultset;
    }

    public ResultSet consultacodigo(boolean pesqproduto) {
        if(pesqproduto) conn.executeSQL("SELECT \"P\".\"CD_PRODUTO\", \"P\".\"DS_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\", \"P\".\"QT_ESTOQUE_MIN\"\n"
                                      + "FROM bancoloja.\"CAD_PRODUTO\" \"P\"\n"
                                      + "JOIN bancoloja.\"CAD_CARACTERISTICAS_PRODUTO\" \"CP\" ON \"P\".\"CD_PRODUTO\" = \"CP\".\"CD_PRODUTO\"\n"
                                      + "JOIN bancoloja.\"CAD_TIPO_PRODUTO\" \"TP\" ON \"CP\".\"CD_TIPO_PRODUTO\" = \"TP\".\"CD_TIPO_PRODUTO\"\n"
                                      + "WHERE \"P\".\"SITUACAO\" = 'A' AND \"P\".\"CD_PRODUTO\" = " + getCodigo() + "\n"
                                      + "GROUP BY \"P\".\"CD_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\"\n"
                                      + "ORDER BY \"P\".\"CD_PRODUTO\"");
        else conn.executeSQL("SELECT \"P\".\"CD_PRODUTO\", \"P\".\"DS_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\", \"P\".\"QT_ESTOQUE_MIN\"\n" +
                             "FROM bancoloja.\"CAD_PRODUTO\" \"P\"\n" +
                             "JOIN bancoloja.\"CAD_TIPO_PRODUTO\" \"TP\" ON \"P\".\"CD_TIPO_SERVICO\" = \"TP\".\"CD_TIPO_PRODUTO\"\n" +
                             "WHERE \"P\".\"SITUACAO\" = 'A' AND \"P\".\"CD_PRODUTO\" = "+getCodigo()+"\n" +
                             "ORDER BY \"P\".\"CD_PRODUTO\"");
        return conn.resultset;
    }

    public ResultSet consultadescricao(boolean pesqproduto) {
        if (pesqproduto) conn.executeSQL("SELECT \"P\".\"CD_PRODUTO\", \"P\".\"DS_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\", \"P\".\"QT_ESTOQUE_MIN\"\n"
                                       + "FROM bancoloja.\"CAD_PRODUTO\" \"P\"\n"
                                       + "JOIN bancoloja.\"CAD_CARACTERISTICAS_PRODUTO\" \"CP\" ON \"P\".\"CD_PRODUTO\" = \"CP\".\"CD_PRODUTO\"\n"
                                       + "JOIN bancoloja.\"CAD_TIPO_PRODUTO\" \"TP\" ON \"CP\".\"CD_TIPO_PRODUTO\" = \"TP\".\"CD_TIPO_PRODUTO\"\n"
                                       + "WHERE \"P\".\"SITUACAO\" = 'A' AND \"P\".\"DS_PRODUTO\" LIKE '%" + getDescricao().toUpperCase() + "%'\n"
                                       + "GROUP BY \"P\".\"CD_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\"\n"
                                       + "ORDER BY \"P\".\"CD_PRODUTO\"");
        else conn.executeSQL("SELECT \"P\".\"CD_PRODUTO\", \"P\".\"DS_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\", \"P\".\"QT_ESTOQUE_MIN\"\n" +
                             "FROM bancoloja.\"CAD_PRODUTO\" \"P\"\n" +
                             "JOIN bancoloja.\"CAD_TIPO_PRODUTO\" \"TP\" ON \"P\".\"CD_TIPO_SERVICO\" = \"TP\".\"CD_TIPO_PRODUTO\"\n" +
                             "WHERE \"P\".\"SITUACAO\" = 'A' AND \"P\".\"DS_PRODUTO\" LIKE '%"+getDescricao().toUpperCase()+"%'\n" +
                             "ORDER BY \"P\".\"CD_PRODUTO\"");
        return conn.resultset;
    }

    public void retornaproduto() {
        conn.executeSQL("SELECT \"DS_PRODUTO\", \"QT_ESTOQUE_MIN\", \"CD_TIPO_SERVICO\"\n"
                + "FROM bancoloja.\"CAD_PRODUTO\"\n"
                + "WHERE \"CD_PRODUTO\" = " + getCodigo() + "");
        try {
            conn.resultset.first();
            setDescricao(conn.resultset.getString(1));
            setEstoquemin(conn.resultset.getFloat(2));
            if (conn.resultset.getString(3) != null){
                getTiposervico().setCodigo(conn.resultset.getInt(3));
            }else {
                getTiposervico().setCodigo(0);
            }
        } catch (SQLException ex) {

        }
    }

    public boolean eprodutoativo() {
        conn.executeSQL("SELECT \"SITUACAO\"\n"
                + "FROM bancoloja.\"CAD_PRODUTO\"\n"
                + "WHERE \"CD_PRODUTO\" = " + getCodigo());
        try {
            conn.resultset.first();
            if (conn.resultset.getString(1).equals("A")) {
                return true;
            }
        } catch (SQLException ex) {

        }
        return false;
    }

    public String retornadescricaoproduto() {
        conn.executeSQL("SELECT \"DS_PRODUTO\"\n"
                + "FROM bancoloja.\"CAD_PRODUTO\"\n"
                + "WHERE \"CD_PRODUTO\" = " + getCodigo());
        try {
            conn.resultset.first();
            return conn.resultset.getString(1);
        } catch (SQLException ex) {

        }
        return "";
    }

    public float mediavalordecompraproduto() {
        conn.executeSQL("SELECT AVG(\"PCV\".\"VL_PRODUTO_UNITARIO\")\n"
                + "FROM bancoloja.\"PRODUTOS_COMPRA_VENDA\" \"PCV\"\n"
                + "JOIN bancoloja.\"COMPRA_VENDA\" \"CV\" ON \"CV\".\"CD_COMPRA_VENDA\" = \"PCV\".\"CD_COMPRA_VENDA\" AND \"PCV\".\"CD_OPERACAO\" = \"CV\".\"CD_OPERACAO\"\n"
                + "WHERE \"PCV\".\"CD_PRODUTO\" = " + getCodigo() + " AND \"PCV\".\"CD_OPERACAO\" = 1 AND\n"
                + "\"CV\".\"DS_COMPRA_VENDA\" NOT LIKE '% - CANCELADO DIA %' AND\n"
                + "\"PCV\".\"IN_PROMOCAO\" <> 'S'\n"
                + "GROUP BY \"PCV\".\"CD_PRODUTO\"");
        try {
            conn.resultset.first();
            return conn.resultset.getFloat(1);
        } catch (SQLException ex) {
            return 0;
        }
    }

    public float retornapercentuallucro() {
        conn.executeSQL("SELECT \"TP\".\"PE_LUCRO_PRODUTO\"\n"
                + "FROM bancoloja.\"CAD_TIPO_PRODUTO\" \"TP\"\n"
                + "JOIN bancoloja.\"CAD_CARACTERISTICAS_PRODUTO\" \"CP\" ON \"CP\".\"CD_TIPO_PRODUTO\" = \"TP\".\"CD_TIPO_PRODUTO\"\n"
                + "WHERE \"CP\".\"CD_PRODUTO\" = " + getCodigo());
        try {
            conn.resultset.first();
            return conn.resultset.getFloat(1);
        } catch (SQLException ex) {
            return 0;
        }
    }
    
    public boolean eservico(){
        conn.executeSQL("SELECT \"TP\".\"IN_SERVICO\"\n" +
                        "FROM bancoloja.\"CAD_TIPO_PRODUTO\" \"TP\"\n" +
                        "JOIN bancoloja.\"CAD_CARACTERISTICAS_PRODUTO\" \"CP\" ON \"TP\".\"CD_TIPO_PRODUTO\" = \"CP\".\"CD_TIPO_PRODUTO\"\n" +
                        "WHERE \"CP\".\"CD_PRODUTO\" = "+getCodigo());
        try{
            conn.resultset.first();
            if (conn.resultset.getString(1).equals("S")) return true;
            else                                         return false;
        }catch(SQLException ex){
            return true;
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

    public float getEstoquemin() {
        return estoquemin;
    }

    public void setEstoquemin(float estoquemin) {
        this.estoquemin = estoquemin;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public ClasseTipoProduto getTiposervico() {
        return tiposervico;
    }

    public void setTiposervico(ClasseTipoProduto tiposervico) {
        this.tiposervico = tiposervico;
    }

}
