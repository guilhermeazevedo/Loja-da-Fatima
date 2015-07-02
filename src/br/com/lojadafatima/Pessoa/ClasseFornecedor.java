package br.com.lojadafatima.Pessoa;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import br.com.lojadafatima.DadosPessoa.ClassePessoaJuridica;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClasseFornecedor {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private ClassePessoaJuridica pessoajur = new ClassePessoaJuridica();
    
    public boolean incluir(){
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_FORNECEDOR", "CD_FORNECEDOR"));
        getPessoajur().getPessoa().incluir();
        getPessoajur().incluir();
        conn.incluirSQL("INSERT INTO bancoloja.\"CAD_FORNECEDOR\"(\n" +
                        "\"CD_FORNECEDOR\", \"CD_PESSOA_JUR\")\n" +
                        "VALUES ("+getCodigo()+", "+getPessoajur().getPessoa().getCodigo()+");");
        if (conn.retorno == 1) return true;
        else                   return false;
    }
    
    public boolean alterar(){
        getPessoajur().alterar();
        getPessoajur().getPessoa().getEndereco().setCodigopessoa(getPessoajur().getPessoa().getCodigo());
        getPessoajur().getPessoa().getEndereco().alterar();
        if (conn.retorno == 1) return true;
        else                   return false;
    }
    
    public boolean excluir(){
        getPessoajur().getPessoa().setCodigo(retornacodigopessoafornecedor());
        getPessoajur().getPessoa().excluir();
        if (conn.retorno == 1) return true;
        else                   return false;
    }
    
    public void importardadosnovofornecedor(){
        conn.executeSQL("SELECT \"P\".\"CD_PESSOA\"\n" +
                        "FROM bancoloja.\"CAD_PESSOA\" \"P\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA_JURIDICA\" \"PJ\" ON \"P\".\"CD_PESSOA\" = \"PJ\".\"CD_PESSOA_JUR\"\n" +
                        "WHERE \"PJ\".\"NR_CNPJ\" = '"+getPessoajur().getCnpj()+"'");
        try{
            conn.resultset.first();
            getPessoajur().getPessoa().setCodigo(conn.resultset.getInt(1));
        }catch(SQLException ex){
            getPessoajur().getPessoa().setCodigo(0);
        }
        GeraCodigos geracodigos = new GeraCodigos();
        getPessoajur().getPessoa().recuperar();
        setCodigo(geracodigos.gerasequencia("CAD_FORNECEDOR", "CD_FORNECEDOR"));
        conn.executeSQL("INSERT INTO bancoloja.\"CAD_FORNECEDOR\"(\n" +
                        "\"CD_FORNECEDOR\", \"CD_PESSOA_JUR\")\n" +
                        "VALUES ("+getCodigo()+", "+getPessoajur().getPessoa().getCodigo()+");");
    }
    
    public int retornacodigopessoafornecedor(){
        conn.executeSQL("SELECT \"P\".\"CD_PESSOA\"\n" +
                        "FROM bancoloja.\"CAD_PESSOA\" \"P\"\n" +
                        "JOIN bancoloja.\"CAD_FORNECEDOR\" \"F\" ON \"P\".\"CD_PESSOA\" = \"F\".\"CD_PESSOA_JUR\"\n" +
                        "WHERE \"F\".\"CD_FORNECEDOR\" = "+getCodigo()+"");
        try{
            conn.resultset.first();
            return conn.resultset.getInt(1);
        }catch(SQLException ex){
            
        }
        return 0;
    }
    
    public ResultSet consultageral(){
        conn.executeSQL("SELECT \"F\".\"CD_FORNECEDOR\", \"PJ\".\"NM_FANTASIA\", \"PJ\".\"NR_CNPJ\", TO_CHAR(\"P\".\"DT_CADASTRO\", 'DD/MM/YYYY')\n" +
                        "FROM bancoloja.\"CAD_FORNECEDOR\" \"F\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA_JURIDICA\" \"PJ\" ON \"F\".\"CD_PESSOA_JUR\" = \"PJ\".\"CD_PESSOA_JUR\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"P\".\"CD_PESSOA\" = \"F\".\"CD_PESSOA_JUR\"\n" +
                        "WHERE \"P\".\"SITUACAO\" = 'A'");
        return conn.resultset;
    }
    
    public ResultSet consultacodigo(){
        conn.executeSQL("SELECT \"F\".\"CD_FORNECEDOR\", \"PJ\".\"NM_FANTASIA\", \"PJ\".\"NR_CNPJ\", TO_CHAR(\"P\".\"DT_CADASTRO\", 'DD/MM/YYYY')\n" +
                        "FROM bancoloja.\"CAD_FORNECEDOR\" \"F\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA_JURIDICA\" \"PJ\" ON \"F\".\"CD_PESSOA_JUR\" = \"PJ\".\"CD_PESSOA_JUR\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"P\".\"CD_PESSOA\" = \"F\".\"CD_PESSOA_JUR\"\n" +
                        "WHERE \"P\".\"SITUACAO\" = 'A' AND \"F\".\"CD_FORNECEDOR\" = "+getCodigo()+"");
        return conn.resultset;
    }
    
    public ResultSet consultanomefantasia(){
        conn.executeSQL("SELECT \"F\".\"CD_FORNECEDOR\", \"PJ\".\"NM_FANTASIA\", \"PJ\".\"NR_CNPJ\", TO_CHAR(\"P\".\"DT_CADASTRO\", 'DD/MM/YYYY')\n" +
                        "FROM bancoloja.\"CAD_FORNECEDOR\" \"F\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA_JURIDICA\" \"PJ\" ON \"F\".\"CD_PESSOA_JUR\" = \"PJ\".\"CD_PESSOA_JUR\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"P\".\"CD_PESSOA\" = \"F\".\"CD_PESSOA_JUR\"\n" +
                        "WHERE \"P\".\"SITUACAO\" = 'A' AND \"PJ\".\"NM_FANTASIA\" LIKE '%"+getPessoajur().getNomefantasia()+"%'");
        return conn.resultset;
    }
    
    public ResultSet consultaCNPJ(){
        conn.executeSQL("SELECT \"F\".\"CD_FORNECEDOR\", \"PJ\".\"NM_FANTASIA\", \"PJ\".\"NR_CNPJ\", TO_CHAR(\"P\".\"DT_CADASTRO\", 'DD/MM/YYYY')\n" +
                        "FROM bancoloja.\"CAD_FORNECEDOR\" \"F\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA_JURIDICA\" \"PJ\" ON \"F\".\"CD_PESSOA_JUR\" = \"PJ\".\"CD_PESSOA_JUR\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"P\".\"CD_PESSOA\" = \"F\".\"CD_PESSOA_JUR\"\n" +
                        "WHERE \"P\".\"SITUACAO\" = 'A' AND \"PJ\".\"NR_CNPJ\" = '"+getPessoajur().getCnpj()+"'");
        return conn.resultset;
    }
    
    public boolean efornecedor(){
        conn.executeSQL("SELECT \"F\".\"CD_FORNECEDOR\"\n" +
                        "FROM bancoloja.\"CAD_FORNECEDOR\" \"F\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA_JURIDICA\" \"PJ\" ON \"PJ\".\"CD_PESSOA_JUR\" = \"F\".\"CD_PESSOA_JUR\"\n" +
                        "WHERE \"PJ\".\"NR_CNPJ\" = '"+getPessoajur().getCnpj()+"'");
        try {
            conn.resultset.first();
            setCodigo(conn.resultset.getInt(1));
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }
    
    public boolean efornecedorativo(){
        conn.executeSQL("SELECT \"P\".\"SITUACAO\"\n" +
                        "FROM bancoloja.\"CAD_FORNECEDOR\" \"F\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"P\".\"CD_PESSOA\" = \"F\".\"CD_PESSOA_JUR\"\n" +
                        "WHERE \"F\".\"CD_FORNECEDOR\" = "+getCodigo());
        try {
            conn.resultset.first();
            if(conn.resultset.getString(1).equals("A"))
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ClassePessoaJuridica getPessoajur() {
        return pessoajur;
    }

    public void setPessoajur(ClassePessoaJuridica pessoajur) {
        this.pessoajur = pessoajur;
    }
    
}
