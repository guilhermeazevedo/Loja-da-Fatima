/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.Usuario;

import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class ClasseTelas {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private String nometela;
    
    public ResultSet retornatelascadastradas(){
        conn.executeSQL("SELECT FALSE, \"NM_TELA\",\"CD_TELA\"\n" +
                        "FROM bancoloja.\"CAD_TELA\" ORDER BY \"NM_TELA\"");
        return conn.resultset;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNometela() {
        return nometela;
    }

    public void setNometela(String nometela) {
        this.nometela = nometela;
    }
    
}
