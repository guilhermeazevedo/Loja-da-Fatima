package br.com.lojadafatima.Usuario;

import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClasseTelasUsuario {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private ClasseUsuario usuario = new ClasseUsuario();
    private ClasseTelas tela = new ClasseTelas();
    private String admin;
    
    public ResultSet retornatelasusuario(){
        conn.executeSQL("SELECT \"TU\".\"CD_TELA\", \"T\".\"NM_TELA\", \"TU\".\"IN_ADM_TELA\"\n" +
                        "FROM bancoloja.\"CAD_TELAS_USUARIO\" \"TU\"\n" +
                        "JOIN bancoloja.\"CAD_TELA\" \"T\" ON \"T\".\"CD_TELA\" = \"TU\".\"CD_TELA\"\n" +
                        "WHERE \"TU\".\"CD_USUARIO\" = "+getUsuario().getCodigo());
        return conn.resultset;
    }
    
    public void incluirtelausuario(){
        conn.executeSQL("INSERT INTO bancoloja.\"CAD_TELAS_USUARIO\"(\n" +
                        "\"CD_USUARIO\", \"CD_TELA\", \"IN_ADM_TELA\")\n" +
                        "VALUES ("+getUsuario().getCodigo()+", "+getTela().getCodigo()+", '"+getAdmin()+"')");
    }
    
    public void deletartelasusuario(){
        conn.executeSQL("DELETE FROM bancoloja.\"CAD_TELAS_USUARIO\"\n" +
                       "WHERE \"CD_USUARIO\" = "+getUsuario().getCodigo());
    }
    
    public boolean eadmintela(){
        conn.executeSQL("SELECT \"IN_ADM_TELA\" FROM bancoloja.\"CAD_TELAS_USUARIO\"\n" +
                        "WHERE \"CD_USUARIO\" = "+getUsuario().getCodigo()+" AND \"CD_TELA\" = "+getTela().getCodigo());
        try {
            conn.resultset.first();
            if(conn.resultset.getString(1).equals("S")){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    public ClasseUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(ClasseUsuario usuario) {
        this.usuario = usuario;
    }

    public ClasseTelas getTela() {
        return tela;
    }

    public void setTela(ClasseTelas tela) {
        this.tela = tela;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
    
}
