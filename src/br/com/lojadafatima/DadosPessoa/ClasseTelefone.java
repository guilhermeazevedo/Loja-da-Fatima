/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.DadosPessoa;

import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class ClasseTelefone {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private int codigopessoa;
    private String nrtelefone;
    private String tipotelefone;
    
    public void incluir(){
        conn.executeSQL("INSERT INTO bancoloja.\"CAD_TELEFONE\"(\n" +
                        "\"CD_TELEFONE\", \"CD_PESSOA\", \"TP_TELEFONE\", \"NR_TELEFONE\")\n" +
                        "VALUES ("+getCodigo()+", "+getCodigopessoa()+", '"+getTipotelefone()+"', '"+getNrtelefone()+"');");
    }
    
    public ResultSet retornatelefonespessoa(){
        conn.executeSQL("SELECT \"CD_PESSOA\", \"NR_TELEFONE\", \"TP_TELEFONE\"\n" +
                        "FROM bancoloja.\"CAD_TELEFONE\"\n" +
                        "WHERE \"CD_PESSOA\" = "+getCodigopessoa()+"");
        return conn.resultset;
    }
    
    public void deletartelefones(){
        conn.executeSQL("DELETE FROM bancoloja.\"CAD_TELEFONE\"\n" +
                        "WHERE \"CD_PESSOA\" = "+getCodigopessoa()+"");
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNrtelefone() {
        return nrtelefone;
    }

    public void setNrtelefone(String nrtelefone) {
        this.nrtelefone = nrtelefone;
    }

    public String getTipotelefone() {
        return tipotelefone;
    }

    public void setTipotelefone(String tipotelefone) {
        this.tipotelefone = tipotelefone;
    }

    public int getCodigopessoa() {
        return codigopessoa;
    }

    public void setCodigopessoa(int codigopessoa) {
        this.codigopessoa = codigopessoa;
    }
    
}
