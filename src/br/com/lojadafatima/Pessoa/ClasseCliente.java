/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.Pessoa;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import br.com.lojadafatima.DadosPessoa.ClassePessoa;
import br.com.lojadafatima.DadosPessoa.ClassePessoaFisica;
import br.com.lojadafatima.DadosPessoa.ClassePessoaJuridica;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class ClasseCliente {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private ClassePessoa pessoa = new ClassePessoa();
    
    public boolean incluirclientefisico(ClassePessoaFisica fisica){
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_CLIENTE", "CD_CLIENTE"));
        fisica.getPessoa().incluir();
        fisica.incluir();
        conn.incluirSQL("INSERT INTO bancoloja.\"CAD_CLIENTE\"(\n" +
                        "\"CD_CLIENTE\", \"CD_PESSOA\", \"SITUACAO\")\n" +
                        "VALUES ("+getCodigo()+", "+fisica.getPessoa().getCodigo()+", 'A');");
        if (conn.retorno == 1) return true;
        else                   return false;
    }
    
    public boolean incluirclientejuridico(ClassePessoaJuridica juridica){
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_CLIENTE", "CD_CLIENTE"));
        juridica.getPessoa().incluir();
        juridica.incluir();
        conn.incluirSQL("INSERT INTO bancoloja.\"CAD_CLIENTE\"(\n" +
                        "\"CD_CLIENTE\", \"CD_PESSOA\", \"SITUACAO\")\n" +
                        "VALUES ("+getCodigo()+", "+juridica.getPessoa().getCodigo()+", 'A');");
        if (conn.retorno == 1) return true;
        else                   return false;
    }
    
    public boolean alterarclientefisico(ClassePessoaFisica fisica){
        fisica.alterar();
        fisica.getPessoa().getEndereco().setCodigopessoa(fisica.getPessoa().getCodigo());
        fisica.getPessoa().getEndereco().alterar();
        if (conn.retorno == 1) return true;
        else                   return false;
    }
    
    public boolean alterarclientejuridico(ClassePessoaJuridica juridica){
        juridica.alterar();
        juridica.getPessoa().getEndereco().setCodigopessoa(juridica.getPessoa().getCodigo());
        juridica.getPessoa().getEndereco().alterar();
        if (conn.retorno == 1) return true;
        else                   return false;
    }
    
    public boolean excluir(){
        conn.deleteSQL("UPDATE bancoloja.\"CAD_CLIENTE\"\n" +
                       "SET \"SITUACAO\" = 'I'\n" +
                       "WHERE \"CD_CLIENTE\" = "+getCodigo()+"");
        if (conn.retorno == 1) return true;
        else                   return false;
    }
    
    public void recuperar(){
        conn.executeSQL("UPDATE bancoloja.\"CAD_CLIENTE\"\n" +
                       "SET \"SITUACAO\" = 'A'\n" +
                       "WHERE \"CD_CLIENTE\" = "+getCodigo()+"");
    }
    
    public ResultSet consultageral(){
        conn.executeSQL("SELECT \"C\".\"CD_CLIENTE\",\n" +
                        "CASE WHEN \"P\".\"TP_PESSOA\" = 'F' \n" +
                        "THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\") \n" +
                        "ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"NOME\", \n" +
                        "CASE WHEN \"P\".\"TP_PESSOA\" = 'F' \n" +
                        "THEN (SELECT \"NR_CPF\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\"= \"P\".\"CD_PESSOA\") \n" +
                        "ELSE (SELECT \"NR_CNPJ\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"CPFCNPJ\", \n" +
                        "TO_CHAR(\"P\".\"DT_CADASTRO\", 'DD/MM/YYYY') AS DT_CADASTRO \n" +
                        "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n" +
                        "ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n" +
                        "WHERE \"C\".\"SITUACAO\" = 'A'\n" +
                        "ORDER BY \"NOME\"");
        return conn.resultset;
    }
    
    public ResultSet consultageralpessoafisica(){
        conn.executeSQL("SELECT \"C\".\"CD_CLIENTE\", \"PF\".\"NM_PESSOA\", \"PF\".\"NR_CPF\", TO_CHAR(\"P\".\"DT_CADASTRO\", 'DD/MM/YYYY')\n" +
                        "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA_FISICA\" \"PF\" ON \"C\".\"CD_PESSOA\" = \"PF\".\"CD_PESSOA_FIS\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n" +
                        "WHERE \"C\".\"SITUACAO\" = 'A'\n" +
                        "ORDER BY \"PF\".\"NM_PESSOA\"");
        return conn.resultset;
    }
    
    public ResultSet consultageralpessoajuridica(){
        conn.executeSQL("SELECT \"C\".\"CD_CLIENTE\", \"PJ\".\"NM_FANTASIA\", \"PJ\".\"NR_CNPJ\", TO_CHAR(\"P\".\"DT_CADASTRO\", 'DD/MM/YYYY')\n" +
                        "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA_JURIDICA\" \"PJ\" ON \"C\".\"CD_PESSOA\" = \"PJ\".\"CD_PESSOA_JUR\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n" +
                        "WHERE \"C\".\"SITUACAO\" = 'A'\n" +
                        "ORDER BY \"PJ\".\"NM_FANTASIA\"");
        return conn.resultset;
    }
    
    public ResultSet consultacodigo(){
        conn.executeSQL("SELECT \"C\".\"CD_CLIENTE\",\n" +
                        "CASE WHEN \"P\".\"TP_PESSOA\" = 'F' \n" +
                        "THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\") \n" +
                        "ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"NOME\", \n" +
                        "CASE WHEN \"P\".\"TP_PESSOA\" = 'F' \n" +
                        "THEN (SELECT \"NR_CPF\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\"= \"P\".\"CD_PESSOA\") \n" +
                        "ELSE (SELECT \"NR_CNPJ\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"CPFCNPJ\", \n" +
                        "TO_CHAR(\"P\".\"DT_CADASTRO\", 'DD/MM/YYYY') AS DT_CADASTRO \n" +
                        "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n" +
                        "ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n" +
                        "WHERE \"C\".\"SITUACAO\" = 'A' AND \"C\".\"CD_CLIENTE\" = "+getCodigo()+"\n" +
                        "ORDER BY \"NOME\"");
        return conn.resultset;
    }
    
    public ResultSet consultadescricaogeral(String desc){
        conn.executeSQL("SELECT \"C\".\"CD_CLIENTE\",\n" +
                        "CASE WHEN \"P\".\"TP_PESSOA\" = 'F' \n" +
                        "THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\") \n" +
                        "ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"NOME\", \n" +
                        "CASE WHEN \"P\".\"TP_PESSOA\" = 'F' \n" +
                        "THEN (SELECT \"NR_CPF\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\"= \"P\".\"CD_PESSOA\") \n" +
                        "ELSE (SELECT \"NR_CNPJ\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"CPFCNPJ\", \n" +
                        "TO_CHAR(\"P\".\"DT_CADASTRO\", 'DD/MM/YYYY') AS DT_CADASTRO \n" +
                        "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n" +
                        "ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n" +
                        "WHERE \"C\".\"SITUACAO\" = 'A' AND CASE WHEN \"P\".\"TP_PESSOA\" = 'F' \n" +
                        "                               THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\") \n" +
                        "                               ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END LIKE '%"+desc+"%'\n" +
                        "ORDER BY \"NOME\"");
        return conn.resultset;
    }
    
    public ResultSet consultadescricaofisica(String desc){
        conn.executeSQL("SELECT \"C\".\"CD_CLIENTE\", \"PF\".\"NM_PESSOA\", \"PF\".\"NR_CPF\", TO_CHAR(\"P\".\"DT_CADASTRO\", 'DD/MM/YYYY')\n" +
                        "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA_FISICA\" \"PF\" ON \"C\".\"CD_PESSOA\" = \"PF\".\"CD_PESSOA_FIS\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n" +
                        "WHERE \"C\".\"SITUACAO\" = 'A' AND \"PF\".\"NM_PESSOA\" LIKE '%"+desc+"%'\n" +
                        "ORDER BY \"PF\".\"NM_PESSOA\"");
        return conn.resultset;
    }
    
    public ResultSet consultadescricaojuridica(String desc){
        conn.executeSQL("SELECT \"C\".\"CD_CLIENTE\", \"PJ\".\"NM_FANTASIA\", \"PJ\".\"NR_CNPJ\", TO_CHAR(\"P\".\"DT_CADASTRO\", 'DD/MM/YYYY')\n" +
                        "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA_JURIDICA\" \"PJ\" ON \"C\".\"CD_PESSOA\" = \"PJ\".\"CD_PESSOA_JUR\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n" +
                        "WHERE \"C\".\"SITUACAO\" = 'A' AND \"PJ\".\"NM_FANTASIA\" LIKE '%"+desc+"%'\n" +
                        "ORDER BY \"PJ\".\"NM_FANTASIA\"");
        return conn.resultset;
    }
    
    public ResultSet consultaCPFouCNPJ(String desc){
        conn.executeSQL("SELECT \"C\".\"CD_CLIENTE\",\n" +
                        "CASE WHEN \"P\".\"TP_PESSOA\" = 'F' \n" +
                        "THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\") \n" +
                        "ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"NOME\", \n" +
                        "CASE WHEN \"P\".\"TP_PESSOA\" = 'F' \n" +
                        "THEN (SELECT \"NR_CPF\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\"= \"P\".\"CD_PESSOA\") \n" +
                        "ELSE (SELECT \"NR_CNPJ\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"CPFCNPJ\", \n" +
                        "TO_CHAR(\"P\".\"DT_CADASTRO\", 'DD/MM/YYYY') AS DT_CADASTRO \n" +
                        "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n" +
                        "ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n" +
                        "WHERE \"C\".\"SITUACAO\" = 'A' AND CASE WHEN \"P\".\"TP_PESSOA\" = 'F' \n" +
                        "                               THEN (SELECT \"NR_CPF\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\"= \"P\".\"CD_PESSOA\") \n" +
                        "                               ELSE (SELECT \"NR_CNPJ\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END = '"+desc+"'\n" +
                        "ORDER BY \"NOME\"");
        return conn.resultset;
    }
    
    public ResultSet consultaCPF(String desc){
        conn.executeSQL("SELECT \"C\".\"CD_CLIENTE\", \"PF\".\"NM_PESSOA\", \"PF\".\"NR_CPF\", TO_CHAR(\"P\".\"DT_CADASTRO\", 'DD/MM/YYYY')\n" +
                        "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA_FISICA\" \"PF\" ON \"C\".\"CD_PESSOA\" = \"PF\".\"CD_PESSOA_FIS\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n" +
                        "WHERE \"C\".\"SITUACAO\" = 'A' AND \"PF\".\"NR_CPF\" = '"+desc+"'\n" +
                        "ORDER BY \"PF\".\"NM_PESSOA\"");
        return conn.resultset;
    }
    
    public ResultSet consultaCNPJ(String desc){
        conn.executeSQL("SELECT \"C\".\"CD_CLIENTE\", \"PJ\".\"NM_JURIDICA\", \"PJ\".\"NR_CNPJ\", TO_CHAR(\"P\".\"DT_CADASTRO\", 'DD/MM/YYYY')\n" +
                        "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA_JURIDICA\" \"PJ\" ON \"C\".\"CD_PESSOA\" = \"PJ\".\"CD_PESSOA_JUR\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n" +
                        "WHERE \"C\".\"SITUACAO\" = 'A' AND \"PJ\".\"NR_CNPJ\" = '"+desc+"'\n" +
                        "ORDER BY \"PJ\".\"NM_JURIDICA\"");
        return conn.resultset;
    }
    
    public String retornatipocliente(){
        conn.executeSQL("SELECT \"P\".\"TP_PESSOA\"\n" +
                        "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n" +
                        "WHERE \"C\".\"CD_CLIENTE\" = "+getCodigo()+"");
        try{
            conn.resultset.first();
            return conn.resultset.getString(1);
        }catch(SQLException ex){
            return "0";
        }
    }
    
    public String retornanomecliente(){
        conn.executeSQL("SELECT CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n" +
"       THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\")\n" +
"       ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"NOME\"\n" +
"       FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n" +
"       JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n" +
"       ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n" +
"       WHERE \"C\".\"SITUACAO\" = 'A' AND \"C\".\"CD_CLIENTE\" = "+getCodigo());
        try{
            conn.resultset.first();
            return conn.resultset.getString(1);
        }catch(SQLException ex){
            return "";
        }
    }
    
    public int retornacodigopessoacliente(){
        conn.executeSQL("SELECT \"P\".\"CD_PESSOA\"\n" +
                        "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA\" \"P\" ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n" +
                        "WHERE \"C\".\"CD_CLIENTE\" = "+getCodigo()+"");
        try{
            conn.resultset.first();
            return conn.resultset.getInt(1);
        }catch(SQLException ex){
            return 0;
        }
    }
    
    public boolean eclienteCPF(String cpf) {
        conn.executeSQL("SELECT \"C\".\"CD_CLIENTE\"\n"
                + "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA_FISICA\" \"PF\" ON \"PF\".\"CD_PESSOA_FIS\" = \"C\".\"CD_PESSOA\"\n"
                + "WHERE \"PF\".\"NR_CPF\" = '" + cpf + "'");
        try {
            conn.resultset.first();
            setCodigo(conn.resultset.getInt(1));
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }
    
    public boolean eativo(){
        conn.executeSQL("SELECT \"SITUACAO\"\n" +
                        "FROM bancoloja.\"CAD_CLIENTE\"\n" +
                        "WHERE \"CD_CLIENTE\" = "+getCodigo());
        try{
            conn.resultset.first();
            if(conn.resultset.getString(1).equals("A"))
                return true;
            else
                return false;
        } catch(SQLException ex){
            
        }
        return false;
    }
    
    public boolean eclienteCNPJ(String cnpj) {
        conn.executeSQL("SELECT \"C\".\"CD_CLIENTE\"\n"
                + "FROM bancoloja.\"CAD_CLIENTE\" \"C\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA_JURIDICA\" \"PJ\" ON \"PJ\".\"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\"\n"
                + "WHERE \"PJ\".\"NR_CNPJ\" = '" + cnpj + "'");
        try {
            conn.resultset.first();
            setCodigo(conn.resultset.getInt(1));
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }
    
    public void importardadosnovoclienteCPF(String cpf){
        conn.executeSQL("SELECT \"P\".\"CD_PESSOA\"\n" +
                        "FROM bancoloja.\"CAD_PESSOA\" \"P\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA_FISICA\" \"PF\" ON \"P\".\"CD_PESSOA\" = \"PF\".\"CD_PESSOA_FIS\"\n" +
                        "WHERE \"PF\".\"NR_CPF\" = '"+cpf+"'");
        try{
            conn.resultset.first();
            getPessoa().setCodigo(conn.resultset.getInt(1));
        }catch(SQLException ex){
            getPessoa().setCodigo(0);
        }
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_CLIENTE", "CD_CLIENTE"));
        conn.executeSQL("INSERT INTO bancoloja.\"CAD_CLIENTE\"(\n" +
                        "\"CD_CLIENTE\", \"CD_PESSOA\", \"SITUACAO\")\n" +
                        "VALUES ("+getCodigo()+", "+getPessoa().getCodigo()+", 'A');");
    }
    
    public void importardadosnovoclienteCNPJ(String cnpj){
        conn.executeSQL("SELECT \"P\".\"CD_PESSOA\"\n" +
                        "FROM bancoloja.\"CAD_PESSOA\" \"P\"\n" +
                        "JOIN bancoloja.\"CAD_PESSOA_JURIDICA\" \"PJ\" ON \"P\".\"CD_PESSOA\" = \"PJ\".\"CD_PESSOA_JUR\"\n" +
                        "WHERE \"PJ\".\"NR_CNPJ\" = '"+cnpj+"'");
        try{
            conn.resultset.first();
            getPessoa().setCodigo(conn.resultset.getInt(1));
        }catch(SQLException ex){
            getPessoa().setCodigo(0);
        }
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_CLIENTE", "CD_CLIENTE"));
        conn.executeSQL("INSERT INTO bancoloja.\"CAD_CLIENTE\"(\n" +
                        "\"CD_CLIENTE\", \"CD_PESSOA\", \"SITUACAO\")\n" +
                        "VALUES ("+getCodigo()+", "+getPessoa().getCodigo()+", 'A');");
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ClassePessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(ClassePessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
