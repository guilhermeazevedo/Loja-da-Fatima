package br.com.lojadafatima.DadosPessoa;

import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClasseEmail {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigopessoa;
    private int codigo;
    private String email;
    private String tipoemail;
    
    public void incluir(){
        conn.executeSQL("INSERT INTO bancoloja.\"CAD_EMAIL\"(\n" +
                        "\"CD_EMAIL\", \"CD_PESSOA\", \"TP_EMAIL\", \"DS_EMAIL\")\n" +
                        "VALUES ("+getCodigo()+", "+getCodigopessoa()+", '"+getTipoemail()+"', '"+getEmail()+"');");
    }
    
    public ResultSet retornaemailspessoa(){
        conn.executeSQL("SELECT \"CD_PESSOA\", \"DS_EMAIL\", \"TP_EMAIL\"\n" +
                        "FROM bancoloja.\"CAD_EMAIL\"\n" +
                        "WHERE \"CD_PESSOA\" = "+getCodigopessoa()+"");
        return conn.resultset;
    }
    
    public void deletaremails(){
        conn.executeSQL("DELETE FROM bancoloja.\"CAD_EMAIL\"\n" +
                        "WHERE \"CD_PESSOA\" = "+getCodigopessoa()+"");
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoemail() {
        return tipoemail;
    }

    public void setTipoemail(String tipoemail) {
        this.tipoemail = tipoemail;
    }

    public int getCodigopessoa() {
        return codigopessoa;
    }

    public void setCodigopessoa(int codigopessoa) {
        this.codigopessoa = codigopessoa;
    }
    
}
