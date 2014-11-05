/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojadafatima.Pessoa;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import br.com.lojadafatima.DadosPessoa.ClassePessoaFisica;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class ClasseFuncionario {

    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private ClassePessoaFisica pessoafis = new ClassePessoaFisica();
    private String funcao;
    private float salario;
    private float comissao;

    public void incluir() {
        getPessoafis().getPessoa().incluir();
        getPessoafis().incluir();
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_FUNCIONARIO", "CD_FUNCIONARIO"));
        conn.executeSQL("INSERT INTO bancoloja.\"CAD_FUNCIONARIO\"(\n"
                + "\"CD_FUNCIONARIO\", \"CD_PESSOA_FIS\", \"DS_FUNCAO\", \"VL_SALARIO\", \"PE_COMISSAO\")\n"
                + "VALUES (" + getCodigo() + ", " + getPessoafis().getPessoa().getCodigo() + ", '" + getFuncao().toUpperCase() + "', " + getSalario() + ", " + getComissao() + ");");
    }

    public void alterar() {
        getPessoafis().alterar();
        getPessoafis().getPessoa().getEndereco().setCodigopessoa(getPessoafis().getPessoa().getCodigo());
        getPessoafis().getPessoa().getEndereco().alterar();
        conn.executeSQL("UPDATE bancoloja.\"CAD_FUNCIONARIO\"\n"
                + "SET \"DS_FUNCAO\"='" + getFuncao().toUpperCase() + "', \"VL_SALARIO\"=" + getSalario() + ", \"PE_COMISSAO\"=" + getComissao() + "\n"
                + "WHERE \"CD_FUNCIONARIO\" = " + getCodigo() + "");
    }

    public void excluir() {
        getPessoafis().getPessoa().setCodigo(retornacodigopessoafuncionario());
        getPessoafis().getPessoa().excluir();
    }

    public int retornacodigopessoafuncionario() {
        conn.executeSQL("SELECT \"P\".\"CD_PESSOA\"\n"
                + "FROM bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "JOIN bancoloja.\"CAD_FUNCIONARIO\" \"F\" ON \"F\".\"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\"\n"
                + "WHERE \"F\".\"CD_FUNCIONARIO\" = " + getCodigo() + "");
        try {
            conn.resultset.first();
            return conn.resultset.getInt(1);
        } catch (SQLException ex) {

        }
        return 0;
    }

    public boolean efuncionario() {
        conn.executeSQL("SELECT \"F\".\"CD_FUNCIONARIO\"\n"
                + "FROM bancoloja.\"CAD_FUNCIONARIO\" \"F\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA_FISICA\" \"PF\" ON \"PF\".\"CD_PESSOA_FIS\" = \"F\".\"CD_PESSOA_FIS\"\n"
                + "WHERE \"PF\".\"NR_CPF\" = '" + getPessoafis().getCpf() + "' ");
        try {
            conn.resultset.first();
            setCodigo(conn.resultset.getInt(1));
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }
    
    public boolean efuncionarioativo(){
        conn.executeSQL("SELECT \"P\".\"SITUACAO\"\n" +
                        "FROM bancoloja.\"CAD_FUNCIONARIO\" \"F\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"P\".\"CD_PESSOA\" = \"F\".\"CD_PESSOA_FIS\"\n" +
                        "WHERE \"F\".\"CD_FUNCIONARIO\" = "+getCodigo());
        try {
            conn.resultset.first();
            if(conn.resultset.getString(1).equals("A"))
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }

    public void importardadosnovofuncionario() {
        conn.executeSQL("SELECT \"P\".\"CD_PESSOA\"\n"
                + "FROM bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA_FISICA\" \"PF\" ON \"P\".\"CD_PESSOA\" = \"PF\".\"CD_PESSOA_FIS\"\n"
                + "WHERE \"PF\".\"NR_CPF\" = '" + getPessoafis().getCpf() + "'");
        try {
            conn.resultset.first();
            getPessoafis().getPessoa().setCodigo(conn.resultset.getInt(1));
        } catch (SQLException ex) {
            getPessoafis().getPessoa().setCodigo(0);
        }
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_FUNCIONARIO", "CD_FUNCIONARIO"));
        conn.executeSQL("INSERT INTO bancoloja.\"CAD_FUNCIONARIO\"(\n"
                + "\"CD_FUNCIONARIO\", \"CD_PESSOA_FIS\", \"DS_FUNCAO\", \"VL_SALARIO\", \"PE_COMISSAO\")\n"
                + "VALUES (" + getCodigo() + ", " + getPessoafis().getPessoa().getCodigo() + ", '" + getFuncao().toUpperCase() + "', " + getSalario() + ", " + getComissao() + ");");
    }

    public ResultSet consultageral() {
        conn.executeSQL("SELECT \"F\".\"CD_FUNCIONARIO\", \"PF\".\"NM_PESSOA\", \"F\".\"DS_FUNCAO\", \"PF\".\"NR_CPF\"\n"
                + "FROM bancoloja.\"CAD_FUNCIONARIO\" \"F\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA_FISICA\" \"PF\" ON \"PF\".\"CD_PESSOA_FIS\" = \"F\".\"CD_PESSOA_FIS\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"F\".\"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\"\n"
                + "WHERE \"P\".\"SITUACAO\" = 'A'");
        return conn.resultset;
    }

    public ResultSet consultacodigo() {
        conn.executeSQL("SELECT \"F\".\"CD_FUNCIONARIO\", \"PF\".\"NM_PESSOA\", \"F\".\"DS_FUNCAO\", \"PF\".\"NR_CPF\"\n"
                + "FROM bancoloja.\"CAD_FUNCIONARIO\" \"F\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA_FISICA\" \"PF\" ON \"PF\".\"CD_PESSOA_FIS\" = \"F\".\"CD_PESSOA_FIS\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"F\".\"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\"\n"
                + "WHERE \"P\".\"SITUACAO\" = 'A' AND \"F\".\"CD_FUNCIONARIO\" = " + getCodigo() + "");
        return conn.resultset;
    }

    public ResultSet consultanome() {
        conn.executeSQL("SELECT \"F\".\"CD_FUNCIONARIO\", \"PF\".\"NM_PESSOA\", \"F\".\"DS_FUNCAO\", \"PF\".\"NR_CPF\"\n"
                + "FROM bancoloja.\"CAD_FUNCIONARIO\" \"F\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA_FISICA\" \"PF\" ON \"PF\".\"CD_PESSOA_FIS\" = \"F\".\"CD_PESSOA_FIS\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"F\".\"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\"\n"
                + "WHERE \"P\".\"SITUACAO\" = 'A' AND \"PF\".\"NM_PESSOA\" LIKE '%" + getPessoafis().getNome().toUpperCase() + "%'");
        return conn.resultset;
    }

    public ResultSet consultafuncao() {
        conn.executeSQL("SELECT \"F\".\"CD_FUNCIONARIO\", \"PF\".\"NM_PESSOA\", \"F\".\"DS_FUNCAO\", \"PF\".\"NR_CPF\"\n"
                + "FROM bancoloja.\"CAD_FUNCIONARIO\" \"F\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA_FISICA\" \"PF\" ON \"PF\".\"CD_PESSOA_FIS\" = \"F\".\"CD_PESSOA_FIS\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"F\".\"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\"\n"
                + "WHERE \"P\".\"SITUACAO\" = 'A' AND \"F\".\"DS_FUNCAO\" LIKE '%" + getFuncao().toUpperCase() + "%'");
        return conn.resultset;
    }

    public ResultSet consultaCPF() {
        conn.executeSQL("SELECT \"F\".\"CD_FUNCIONARIO\", \"PF\".\"NM_PESSOA\", \"F\".\"DS_FUNCAO\", \"PF\".\"NR_CPF\"\n"
                + "FROM bancoloja.\"CAD_FUNCIONARIO\" \"F\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA_FISICA\" \"PF\" ON \"PF\".\"CD_PESSOA_FIS\" = \"F\".\"CD_PESSOA_FIS\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"F\".\"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\"\n"
                + "WHERE \"P\".\"SITUACAO\" = 'A' AND \"PF\".\"NR_CPF\" LIKE '%" + getPessoafis().getCpf() + "%'");
        return conn.resultset;
    }

    public void retornafuncionario() {
        conn.executeSQL("SELECT \"DS_FUNCAO\", \"VL_SALARIO\", \"PE_COMISSAO\"\n"
                + "FROM bancoloja.\"CAD_FUNCIONARIO\"\n"
                + "WHERE \"CD_FUNCIONARIO\" = " + getCodigo() + "");
        try {
            conn.resultset.first();
            setFuncao(conn.resultset.getString(1));
            setSalario(conn.resultset.getFloat(2));
            setComissao(conn.resultset.getFloat(3));
        }catch(SQLException ex){
            
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ClassePessoaFisica getPessoafis() {
        return pessoafis;
    }

    public void setPessoafis(ClassePessoaFisica pessoafis) {
        this.pessoafis = pessoafis;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

}
