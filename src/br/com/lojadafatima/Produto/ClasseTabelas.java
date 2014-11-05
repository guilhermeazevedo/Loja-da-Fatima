/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.Produto;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class ClasseTabelas {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private String tabela;
    private ClasseValores valor = new ClasseValores();
    
    public ResultSet buscartabelas(){
        conn.executeSQL("SELECT \"CD_TABELA\", \"DS_TABELA\"\n" +
                        "FROM bancoloja.\"CAD_TABELAS\"\n" +
                        "ORDER BY \"CD_TABELA\";");
        return conn.resultset;
    }
    
    public void incluir(){
        GeraCodigos geracodigo = new GeraCodigos();
        setCodigo(geracodigo.gerasequencia("CAD_TABELAS", "CD_TABELA"));
        conn.incluirSQL("INSERT INTO bancoloja.\"CAD_TABELAS\"(\n" +
                        "\"CD_TABELA\", \"DS_TABELA\")\n" +
                        "VALUES ("+getCodigo()+", '"+getTabela().toUpperCase()+"');");
    }
    
    public void alterar(){
        conn.atualizarSQL("UPDATE bancoloja.\"CAD_TABELAS\"\n" +
                          "SET \"DS_TABELA\"= '"+getTabela().toUpperCase()+"' \n" +
                          "WHERE \"CD_TABELA\"="+getCodigo()+";");
    }
    
    public ResultSet buscartabelascomboolean(){
        conn.executeSQL("SELECT FALSE, \"CD_TABELA\", \"DS_TABELA\"\n" +
                        "FROM bancoloja.\"CAD_TABELAS\"\n" +
                        "ORDER BY \"CD_TABELA\";");
        return conn.resultset;
    }
    
    public ResultSet buscarvalorestabela(){
        conn.executeSQL("SELECT \"CD_VALOR\", \"DS_VALOR\"\n" +
                        "FROM bancoloja.\"CAD_VALORES_TABELA\"\n" +
                        "WHERE \"CD_TABELA\" = "+getCodigo()+" "
                      + "ORDER BY \"CD_VALOR\";");
        return conn.resultset;
    }
    
    public String retornatabela(){
        conn.executeSQL("SELECT \"DS_TABELA\"\n" +
                        "FROM bancoloja.\"CAD_TABELAS\"\n" +
                        "WHERE \"CD_TABELA\" = "+getCodigo()+"");
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

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public ClasseValores getValor() {
        return valor;
    }

    public void setValor(ClasseValores valor) {
        this.valor = valor;
    }
    
}
