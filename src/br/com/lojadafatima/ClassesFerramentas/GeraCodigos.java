/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.ClassesFerramentas;

import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class GeraCodigos {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    
    public int gerasequencia(String tabela, String atributo){
        conn.executeSQL("SELECT COALESCE(MAX(\""+atributo+"\"), 0) + 1 AS \"ULTIMO\" FROM bancoloja.\""+tabela+"\"");
        try{
            conn.resultset.first();
            return conn.resultset.getInt(1);
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao gerar sequencia \n o erro passado foi "+ex);
            return 0;
        }
    }
    
    public int gerasequencia(String tabela, String atributo, String atributowhere, int valorwhere){
        conn.executeSQL("SELECT COALESCE(MAX(\""+atributo+"\"), 0) + 1 AS \"ULTIMO\"\n" +
                        "FROM bancoloja.\""+tabela+"\"\n" +
                        "WHERE \""+atributowhere+"\" = "+valorwhere+"");
        try{
            conn.resultset.first();
            return conn.resultset.getInt(1);
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao gerar sequencia \n o erro passado foi "+ex);
            return 0;
        }
    }
    
}
