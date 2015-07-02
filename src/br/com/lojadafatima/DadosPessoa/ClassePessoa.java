package br.com.lojadafatima.DadosPessoa;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClassePessoa {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private String datacadastro;
    private String tipopessoa;
    private String situacao;
    private ClasseTelefone telefone = new ClasseTelefone();
    private ClasseEndereco endereco = new ClasseEndereco();
    private ClasseEmail email = new ClasseEmail();
    
    public void incluir(){
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_PESSOA", "CD_PESSOA"));
        conn.executeSQL("INSERT INTO bancoloja.\"CAD_PESSOA\"(\n" +
                        "\"CD_PESSOA\", \"DT_CADASTRO\", \"TP_PESSOA\", \"SITUACAO\")\n" +
                        "VALUES ("+getCodigo()+", '"+getDatacadastro()+"', '"+getTipopessoa()+"', 'A');");
        getEndereco().setCodigopessoa(getCodigo());
        getEndereco().incluir();
    }
    
    public void excluir(){
        conn.deleteSQL("UPDATE bancoloja.\"CAD_PESSOA\"\n" +
                       "SET \"SITUACAO\" = 'I'\n" +
                       "WHERE \"CD_PESSOA\" = "+getCodigo()+"");
    }
    
    public void recuperar(){
        conn.executeSQL("UPDATE bancoloja.\"CAD_PESSOA\"\n" +
                       "SET \"SITUACAO\" = 'A'\n" +
                       "WHERE \"CD_PESSOA\" = "+getCodigo()+"");
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(String datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getTipopessoa() {
        return tipopessoa;
    }

    public void setTipopessoa(String tipopessoa) {
        this.tipopessoa = tipopessoa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public ClasseTelefone getTelefone() {
        return telefone;
    }

    public void setTelefone(ClasseTelefone telefone) {
        this.telefone = telefone;
    }

    public ClasseEndereco getEndereco() {
        return endereco;
    }

    public void setEndereco(ClasseEndereco endereco) {
        this.endereco = endereco;
    }

    public ClasseEmail getEmail() {
        return email;
    }

    public void setEmail(ClasseEmail email) {
        this.email = email;
    }
    
}
