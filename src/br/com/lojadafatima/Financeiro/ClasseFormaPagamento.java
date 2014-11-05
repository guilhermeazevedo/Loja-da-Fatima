/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.Financeiro;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class ClasseFormaPagamento {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private String formapgto;
    
    public void incluir(){
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_FORMA_PGTO", "CD_FORMA_PGTO"));
        conn.incluirSQL("INSERT INTO bancoloja.\"CAD_FORMA_PGTO\"(\n" +
                        "\"CD_FORMA_PGTO\", \"DS_FORMA_PGTO\")\n" +
                        "VALUES ("+getCodigo()+", '"+getFormapgto().toUpperCase()+"')");
    }
    
    public void alterar(){
        conn.atualizarSQL("UPDATE bancoloja.\"CAD_FORMA_PGTO\"\n" +
                          "SET \"DS_FORMA_PGTO\"='"+getFormapgto().toUpperCase()+"'\n" +
                          "WHERE \"CD_FORMA_PGTO\"="+getCodigo()+"");
    }
    
    public ResultSet retornaformapgtojtable(){
        conn.executeSQL("SELECT \"CD_FORMA_PGTO\", \"DS_FORMA_PGTO\"\n" +
                        "FROM bancoloja.\"CAD_FORMA_PGTO\"");
        return conn.resultset;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFormapgto() {
        return formapgto;
    }

    public void setFormapgto(String formapgto) {
        this.formapgto = formapgto;
    }
    
}
