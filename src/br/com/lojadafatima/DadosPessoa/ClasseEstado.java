package br.com.lojadafatima.DadosPessoa;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author guilhermeazevedo
 */
public class ClasseEstado {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private String estado;
    private String sigla;
    
    public ResultSet buscarestadosjtable(){
        conn.executeSQL("SELECT \"CD_UF\", \"NM_UF\", \"DS_SIGLA\" FROM bancoloja.\"CAD_UF\"\n" +
                        "ORDER BY \"CD_UF\"");
        return conn.resultset;
    }
    
    public ResultSet buscarestadosjcombobox(){
        conn.executeSQL("SELECT \"NM_UF\" FROM bancoloja.\"CAD_UF\"\n" +
                        "ORDER BY \"NM_UF\"");
        return conn.resultset;
    }
    
    public void incluir(){
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_UF", "CD_UF"));
        if(getCodigo() != 0)
        conn.incluirSQL("INSERT INTO bancoloja.\"CAD_UF\"(\"CD_UF\", \"NM_UF\", \"DS_SIGLA\")\n" +
                        "VALUES ( "+getCodigo()+", '"+getEstado().toUpperCase()+"', '"+getSigla().toUpperCase()+"');");
    }
    
    public void alterar(){
        conn.atualizarSQL("UPDATE bancoloja.\"CAD_UF\"\n" +
                        "SET \"NM_UF\"= '"+getEstado().toUpperCase()+"', \"DS_SIGLA\"= '"+getSigla().toUpperCase()+"'\n" +
                        "WHERE \"CD_UF\" = "+getCodigo()+";");
    }
    
    public int retornacodigo(){
        conn.executeSQL("SELECT \"CD_UF\" FROM bancoloja.\"CAD_UF\"\n" +
                        "WHERE \"NM_UF\" = '"+getEstado()+"'");
        try{
            conn.resultset.first();
            return conn.resultset.getInt(1);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            return 0;
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
}
