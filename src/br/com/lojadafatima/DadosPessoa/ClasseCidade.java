package br.com.lojadafatima.DadosPessoa;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class ClasseCidade {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private String cidade;
    private ClasseEstado estado = new ClasseEstado();
    
    public ResultSet buscarcidadesjtable(){
        conn.executeSQL("SELECT \"C\".\"CD_CIDADE\", \"C\".\"NM_CIDADE\", \"E\".\"NM_UF\"\n" +
                        "FROM bancoloja.\"CAD_CIDADE\" AS \"C\"\n" +
                        "JOIN bancoloja.\"CAD_UF\" AS \"E\" ON\n" +
                        "\"C\".\"CD_UF\" = \"E\".\"CD_UF\"");
        return conn.resultset;
    }
    
    public void incluir(){
        GeraCodigos geracodigo = new GeraCodigos();
        setCodigo(geracodigo.gerasequencia("CAD_CIDADE", "CD_CIDADE"));
        getEstado().setCodigo(getEstado().retornacodigo());
        conn.incluirSQL("INSERT INTO bancoloja.\"CAD_CIDADE\"(\n" +
                        "\"CD_CIDADE\", \"CD_UF\", \"NM_CIDADE\")\n" +
                        "VALUES ( "+getCodigo()+" , "+getEstado().getCodigo()+", '"+getCidade().toUpperCase()+"');");
    }
    
    public void alterar(){
        getEstado().setCodigo(getEstado().retornacodigo());
        conn.atualizarSQL("UPDATE bancoloja.\"CAD_CIDADE\"\n" +
                          "SET \"CD_UF\"="+getEstado().getCodigo()+", \"NM_CIDADE\"='"+getCidade().toUpperCase()+"'\n" +
                          "WHERE \"CD_CIDADE\"='"+getCodigo()+"';");
    }
    
    public ResultSet buscarcidadesporestado(){
        conn.executeSQL("SELECT \"C\".\"NM_CIDADE\"\n" +
                        "FROM bancoloja.\"CAD_CIDADE\" AS \"C\"\n" +
                        "JOIN bancoloja.\"CAD_UF\" AS \"U\"\n" +
                        "ON \"U\".\"CD_UF\" = \"C\".\"CD_UF\"\n" +
                        "WHERE \"U\".\"NM_UF\" = '"+getEstado().getEstado()+"'\n" +
                        "ORDER BY \"C\".\"NM_CIDADE\"");
        return conn.resultset;
    }
    
    public int retornacodigo(){
        conn.executeSQL("SELECT \"CD_CIDADE\"\n" +
                        "FROM bancoloja.\"CAD_CIDADE\"\n" +
                        "WHERE \"NM_CIDADE\" = '"+getCidade()+"'");
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public ClasseEstado getEstado() {
        return estado;
    }
    
    public void setEstado(ClasseEstado estado) {
        this.estado = estado;
    }
    
}
