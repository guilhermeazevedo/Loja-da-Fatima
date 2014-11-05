package br.com.lojadafatima.Produto;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import br.com.lojadafatima.Pessoa.ClasseFornecedor;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class ClasseProduto {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private String descricao;
    private float valor;
    private float estoquemin;
    private String situacao;
    
    public void incluir(){
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_PRODUTO", "CD_PRODUTO"));
        conn.incluirSQL("INSERT INTO bancoloja.\"CAD_PRODUTO\"(\n" +
                        "\"CD_PRODUTO\", \"DS_PRODUTO\", \"VL_PRODUTO\", \"QT_ESTOQUE_MIN\", \"SITUACAO\")\n" +
                        "VALUES ("+getCodigo()+", '"+getDescricao().toUpperCase()+"', "+getValor()+", "+getEstoquemin()+", 'A')");
    }
    
    public void alterar(){
        conn.atualizarSQL("UPDATE bancoloja.\"CAD_PRODUTO\"\n" +
                          "SET \"DS_PRODUTO\"= '"+getDescricao().toUpperCase()+"', \"VL_PRODUTO\"="+getValor()+", \"QT_ESTOQUE_MIN\"="+getEstoquemin()+"\n" +
                          "WHERE \"CD_PRODUTO\" = "+getCodigo()+"");
    }
    
    public void excluir(){
        conn.deleteSQL("UPDATE bancoloja.\"CAD_PRODUTO\"\n" +
                       "SET \"SITUACAO\"='I'\n" +
                       "WHERE \"CD_PRODUTO\"="+getCodigo()+";");
    }
    
    public ResultSet consultageral(){
        conn.executeSQL("SELECT \"P\".\"CD_PRODUTO\", \"P\".\"DS_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\", \"P\".\"VL_PRODUTO\", \"P\".\"QT_ESTOQUE_MIN\"\n" +
                        "FROM bancoloja.\"CAD_PRODUTO\" \"P\"\n" +
                        "JOIN bancoloja.\"CAD_CARACTERISTICAS_PRODUTO\" \"CP\" ON \"P\".\"CD_PRODUTO\" = \"CP\".\"CD_PRODUTO\"\n" +
                        "JOIN bancoloja.\"CAD_TIPO_PRODUTO\" \"TP\" ON \"CP\".\"CD_TIPO_PRODUTO\" = \"TP\".\"CD_TIPO_PRODUTO\"\n" +
                        "WHERE \"P\".\"SITUACAO\" = 'A'\n" +
                        "GROUP BY \"P\".\"CD_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\"\n" +
                        "ORDER BY \"P\".\"CD_PRODUTO\"");
        return conn.resultset;
    }
    
    public ResultSet consultacodigo(){
        conn.executeSQL("SELECT \"P\".\"CD_PRODUTO\", \"P\".\"DS_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\", \"P\".\"VL_PRODUTO\", \"P\".\"QT_ESTOQUE_MIN\"\n" +
                        "FROM bancoloja.\"CAD_PRODUTO\" \"P\"\n" +
                        "JOIN bancoloja.\"CAD_CARACTERISTICAS_PRODUTO\" \"CP\" ON \"P\".\"CD_PRODUTO\" = \"CP\".\"CD_PRODUTO\"\n" +
                        "JOIN bancoloja.\"CAD_TIPO_PRODUTO\" \"TP\" ON \"CP\".\"CD_TIPO_PRODUTO\" = \"TP\".\"CD_TIPO_PRODUTO\"\n" +
                        "WHERE \"P\".\"SITUACAO\" = 'A' AND \"P\".\"CD_PRODUTO\" = "+getCodigo()+"\n" +
                        "GROUP BY \"P\".\"CD_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\"\n" +
                        "ORDER BY \"P\".\"CD_PRODUTO\"");
        return conn.resultset;
    }
    
    public ResultSet consultadescricao(){
        conn.executeSQL("SELECT \"P\".\"CD_PRODUTO\", \"P\".\"DS_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\", \"P\".\"VL_PRODUTO\", \"P\".\"QT_ESTOQUE_MIN\"\n" +
                        "FROM bancoloja.\"CAD_PRODUTO\" \"P\"\n" +
                        "JOIN bancoloja.\"CAD_CARACTERISTICAS_PRODUTO\" \"CP\" ON \"P\".\"CD_PRODUTO\" = \"CP\".\"CD_PRODUTO\"\n" +
                        "JOIN bancoloja.\"CAD_TIPO_PRODUTO\" \"TP\" ON \"CP\".\"CD_TIPO_PRODUTO\" = \"TP\".\"CD_TIPO_PRODUTO\"\n" +
                        "WHERE \"P\".\"SITUACAO\" = 'A' AND \"P\".\"DS_PRODUTO\" LIKE '%"+getDescricao().toUpperCase()+"%'\n" +
                        "GROUP BY \"P\".\"CD_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\"\n" +
                        "ORDER BY \"P\".\"CD_PRODUTO\"");
        return conn.resultset;
    }
    
    public void retornaproduto(){
        conn.executeSQL("SELECT \"DS_PRODUTO\", \"VL_PRODUTO\", \"QT_ESTOQUE_MIN\"\n" +
                        "FROM bancoloja.\"CAD_PRODUTO\"\n" +
                        "WHERE \"CD_PRODUTO\" = "+getCodigo()+"");
        try{
            conn.resultset.first();
            setDescricao(conn.resultset.getString(1));
            setValor(conn.resultset.getFloat(2));
            setEstoquemin(conn.resultset.getFloat(3));
        }catch(SQLException ex){
            
        }
    }
    
    public boolean eprodutoativo(){
        conn.executeSQL("SELECT \"SITUACAO\"\n" +
                        "FROM bancoloja.\"CAD_PRODUTO\"\n" +
                        "WHERE \"CD_PRODUTO\" = "+getCodigo());
        try{
            conn.resultset.first();
            if(conn.resultset.getString(1).equals("A")){
                return true;
            }
        } catch(SQLException ex){
            
        }
        return false;
    }
    
    public String retornadescricaoproduto(){
        conn.executeSQL("SELECT \"DS_PRODUTO\"\n" +
                        "FROM bancoloja.\"CAD_PRODUTO\"\n" +
                        "WHERE \"CD_PRODUTO\" = "+getCodigo());
        try{
            conn.resultset.first();
            return conn.resultset.getString(1);
        } catch(SQLException ex){
            
        }
        return "";
    }
    
    public float retornavalorunitarioproduto(){
        conn.executeSQL("SELECT \"VL_PRODUTO\"\n" +
                        "FROM bancoloja.\"CAD_PRODUTO\"\n" +
                        "WHERE \"CD_PRODUTO\" = "+getCodigo());
        try{
            conn.resultset.first();
            return conn.resultset.getFloat(1);
        } catch(SQLException ex){
            
        }
        return 0;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
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
    
}
