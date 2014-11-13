package br.com.lojadafatima.CompraVendaOperacoes;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class ClasseOperacoes {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private String descricao;
    private String infinanceiro;
    private String tpfinanceiro;
    private String inestoque;
    private String tpestoque;
    
    public void incluir(){
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_OPERACOES", "CD_OPERACAO"));
        conn.incluirSQL("INSERT INTO bancoloja.\"CAD_OPERACOES\"(\n" +
                        "\"CD_OPERACAO\", \"DS_OPERACAO\", \"IN_FINANCEIRO\", \"TP_FINANCEIRO\", \"IN_ESTOQUE\", \"TP_ESTOQUE\")\n" +
                        "VALUES ("+getCodigo()+", '"+getDescricao().toUpperCase()+"', '"+getInfinanceiro()+"', '"+getTpfinanceiro()+"', '"+getInestoque()+"', '"+getTpestoque()+"')");
    }
    
    public void alterar(){
        conn.atualizarSQL("UPDATE bancoloja.\"CAD_OPERACOES\"\n" +
                          "SET \"DS_OPERACAO\"='"+getDescricao().toUpperCase()+"', \"IN_FINANCEIRO\"='"+getInfinanceiro()+"', \"TP_FINANCEIRO\"='"+getTpfinanceiro()+"', \"IN_ESTOQUE\"='"+getInestoque()+"', \"TP_ESTOQUE\"='"+getTpestoque()+"'\n" +
                          "WHERE \"CD_OPERACAO\"= "+getCodigo());
    }
    
    public ResultSet consultaoperacoes(){
        conn.executeSQL("SELECT \"CD_OPERACAO\", \"DS_OPERACAO\"\n" +
                        "FROM bancoloja.\"CAD_OPERACOES\"");
        return conn.resultset;
    }
    
    public void retornaoperacao(){
        conn.executeSQL("SELECT \"DS_OPERACAO\", \"IN_FINANCEIRO\", \"TP_FINANCEIRO\", \"IN_ESTOQUE\", \"TP_ESTOQUE\"\n" +
                        "FROM bancoloja.\"CAD_OPERACOES\"\n" +
                        "WHERE \"CD_OPERACAO\" = "+getCodigo());
        try{
            conn.resultset.first();
            setDescricao(conn.resultset.getString(1));
            setInfinanceiro(conn.resultset.getString(2));
            setTpfinanceiro(conn.resultset.getString(3));
            setInestoque(conn.resultset.getString(4));
            setTpestoque(conn.resultset.getString(5));
        }catch(SQLException ex){
            setDescricao("");
            setInestoque("N");
            setInfinanceiro("N");
        }
    }
    
    public ResultSet retornaoperacoescombobox(){
        conn.executeSQL("SELECT \"DS_OPERACAO\"\n" +
                        "FROM bancoloja.\"CAD_OPERACOES\"");
        return conn.resultset;
    }
    
    public int retornacodigooperacao(){
        conn.executeSQL("SELECT \"CD_OPERACAO\"\n" +
                        "FROM bancoloja.\"CAD_OPERACOES\"\n" +
                        "WHERE \"DS_OPERACAO\" = '"+getDescricao()+"'");
        try{
            conn.resultset.first();
            return conn.resultset.getInt(1);
        }catch(SQLException ex){
            return 0;
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

    public String getInfinanceiro() {
        return infinanceiro;
    }

    public void setInfinanceiro(String infinanceiro) {
        this.infinanceiro = infinanceiro;
    }

    public String getTpfinanceiro() {
        return tpfinanceiro;
    }

    public void setTpfinanceiro(String tpfinanceiro) {
        this.tpfinanceiro = tpfinanceiro;
    }

    public String getInestoque() {
        return inestoque;
    }

    public void setInestoque(String inestoque) {
        this.inestoque = inestoque;
    }

    public String getTpestoque() {
        return tpestoque;
    }

    public void setTpestoque(String tpestoque) {
        this.tpestoque = tpestoque;
    }
    
}
