package br.com.lojadafatima.Produto;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClasseValores {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private String valor;
    private int codigoTabela;
    
    public boolean incluir(){
        GeraCodigos geracodigo = new GeraCodigos();
        setCodigo(geracodigo.gerasequencia("CAD_VALORES_TABELA", "CD_VALOR", "CD_TABELA", getCodigoTabela()));
        conn.incluirSQL("INSERT INTO bancoloja.\"CAD_VALORES_TABELA\"(\n" +
                        "\"CD_VALOR\", \"CD_TABELA\", \"DS_VALOR\")\n" +
                        "VALUES ("+getCodigo()+", "+getCodigoTabela()+", '"+getValor().toUpperCase()+"');");
        if (conn.retorno == 1) return true;
        else                   return false;
    }
    
    public boolean alterar(){
        conn.atualizarSQL("UPDATE bancoloja.\"CAD_VALORES_TABELA\"\n" +
                          "SET \"DS_VALOR\"='"+getValor().toUpperCase()+"'\n" +
                          "WHERE \"CD_VALOR\"= "+getCodigo()+" AND \"CD_TABELA\"= "+getCodigoTabela()+" ;");
        if (conn.retorno == 1) return true;
        else                   return false;
    }
    
    public String retornavalor(){
        conn.executeSQL("SELECT \"DS_VALOR\"\n" +
                        "FROM bancoloja.\"CAD_VALORES_TABELA\"\n" +
                        "WHERE \"CD_VALOR\" = "+getCodigo()+" AND \"CD_TABELA\" = "+getCodigoTabela()+"");
        try{
            conn.resultset.first();
            return conn.resultset.getString(1);
        }catch(SQLException ex){
            return "";
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getCodigoTabela() {
        return codigoTabela;
    }

    public void setCodigoTabela(int codigoTabela) {
        this.codigoTabela = codigoTabela;
    }

}
