package br.com.lojadafatima.ClassesFerramentas;

import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme Azevedo
 */
public class GeraCodigos {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    
    public int gerasequencia(String tabela, String atributo){
        conn.executeSQL("SELECT COALESCE(MAX(\""+atributo+"\"), 0) + 1 AS \"ULTIMO\" FROM bancoloja.\""+tabela+"\"");
        try{
            conn.resultset.first();
            return conn.resultset.getInt(1);
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao gerar sequência do código!\nO erro passado foi: "+ex, "O sistema não conseguiu gerar o próximo código", JOptionPane.YES_OPTION);
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
            JOptionPane.showMessageDialog(null, "Erro ao gerar sequência do código!\nO erro passado foi: "+ex, "O sistema não conseguiu gerar o próximo código", JOptionPane.YES_OPTION);
            return 0;
        }
    }
    
}
