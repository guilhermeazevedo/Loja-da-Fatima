/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.Usuario;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class ClasseUsuario {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    
    private int codigo;
    private String login;
    private String senha;
    private String dica;
    
    public boolean realizalogin(){
        
        conn.executeSQL("SELECT \"CD_USUARIO\", \"DS_LOGIN\", \"DS_SENHA\" FROM bancoloja.\"CAD_USUARIO\"\n" +
                        "WHERE \"DS_LOGIN\" = '"+getLogin()+"'");
        try{
            conn.resultset.first();
            if(conn.resultset.getString(3).equals(getSenha())){
                setCodigo(conn.resultset.getInt(1));
                return true;
            }
            else{
                return false;
            }
        }catch(SQLException ex){
            return false;
        } catch(Exception ex){
            return false;
        }
    }
    
    public String mostrardica(){
        conn.executeSQL("SELECT \"DS_DICA\" FROM bancoloja.\"CAD_USUARIO\"\n" 
                       +"WHERE \"DS_LOGIN\" = '"+getLogin()+"'");
        try{
            conn.resultset.first();
            return conn.resultset.getString(1);
        } catch(SQLException ex){
            return "Este Login é inexistente!";
        }
    }
    
    public void incluir(){
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_USUARIO", "CD_USUARIO"));
        conn.incluirSQL("INSERT INTO bancoloja.\"CAD_USUARIO\"(\n" +
                        "\"CD_USUARIO\", \"DS_LOGIN\", \"DS_SENHA\", \"DS_DICA\")\n" +
                        "VALUES ("+getCodigo()+", '"+getLogin()+"', '"+getSenha()+"', '"+getDica()+"')");
    }
    
    public void alterar(){
        conn.atualizarSQL("UPDATE bancoloja.\"CAD_USUARIO\"\n" +
                          "SET \"DS_LOGIN\"='"+getLogin()+"', \"DS_SENHA\"='"+getSenha()+"', \"DS_DICA\"='"+getDica()+"'\n" +
                          "WHERE \"CD_USUARIO\"="+getCodigo()+"");
    }
    
    public ResultSet consultausuarios(){
        conn.executeSQL("SELECT \"CD_USUARIO\", \"DS_LOGIN\"\n" +
                        "FROM bancoloja.\"CAD_USUARIO\"");
        return conn.resultset;
    }
    
    public void excluir(){
        conn.deleteSQL("DELETE FROM bancoloja.\"CAD_USUARIO\"\n" +
                        "WHERE \"CD_USUARIO\" = "+getCodigo());
    }
    
    public void retornausuario(){
        conn.executeSQL("SELECT \"DS_LOGIN\", \"DS_SENHA\", \"DS_DICA\"\n" +
                        "FROM bancoloja.\"CAD_USUARIO\"\n" +
                        "WHERE \"CD_USUARIO\" = "+getCodigo());
        try{
            conn.resultset.first();
            setLogin(conn.resultset.getString(1));
            setSenha(conn.resultset.getString(2));
            setDica(conn.resultset.getString(3));
        } catch(SQLException ex){
            setLogin("");
            setSenha("");
            setDica("");
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }
    
}
