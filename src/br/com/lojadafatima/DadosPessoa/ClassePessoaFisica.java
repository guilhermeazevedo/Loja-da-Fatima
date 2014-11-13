/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.DadosPessoa;

import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class ClassePessoaFisica {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private ClassePessoa pessoa = new ClassePessoa();
    private String nome;
    private String rg;
    private String cpf;
    private String sexo;
    private String datanasc;
    
    public void incluir(){
        conn.executeSQL("INSERT INTO bancoloja.\"CAD_PESSOA_FISICA\"(\n" +
                        "\"CD_PESSOA_FIS\", \"NM_PESSOA\", \"NR_RG\", \"NR_CPF\", \"DS_SEXO\", \"DT_NASCIMENTO\")\n" +
                        "VALUES ("+getPessoa().getCodigo()+", '"+getNome().toUpperCase()+"', '"+getRg()+"', '"+getCpf()+"', '"+getSexo()+"', '"+getDatanasc()+"');");
    }
    
    public void alterar(){
        conn.atualizarSQL("UPDATE bancoloja.\"CAD_PESSOA_FISICA\"\n" +
                          "SET \"NM_PESSOA\"='"+getNome().toUpperCase()+"', \"NR_RG\"='"+getRg()+"', \"NR_CPF\"='"+getCpf()+"', \"DS_SEXO\"='"+getSexo()+"', \"DT_NASCIMENTO\"='"+getDatanasc()+"'\n" +
                          "WHERE \"CD_PESSOA_FIS\"="+getPessoa().getCodigo()+"");
    }
    
    public String retornanomeporCPF(){
        conn.executeSQL("SELECT \"NM_PESSOA\"\n" +
                        "FROM bancoloja.\"CAD_PESSOA_FISICA\"\n" +
                        "WHERE \"NR_CPF\" = '"+getCpf()+"'");
        try{
            conn.resultset.first();
            return conn.resultset.getString(1);
        }catch(SQLException ex){
            
        }
        return "";
    }
    
    public String retornanomeporCodigo(){
        conn.executeSQL("SELECT \"NM_PESSOA\"\n" +
                        "FROM bancoloja.\"CAD_PESSOA_FISICA\"\n" +
                        "WHERE \"CD_PESSOA_FIS\" = "+getPessoa().getCodigo());
        try{
            conn.resultset.first();
            return conn.resultset.getString(1);
        }catch(SQLException ex){
            
        }
        return "";
    }
    
    public boolean CPFexistente() {
        conn.executeSQL("SELECT \"CD_PESSOA_FIS\"\n"
                + "FROM bancoloja.\"CAD_PESSOA_FISICA\"\n"
                + "WHERE \"NR_CPF\" = '" + getCpf() + "'");
        try {
            conn.resultset.first();
            conn.resultset.getInt(1);
            return true;
        } catch (SQLException ex) {

        }
        return false;
    }
    
    public boolean CPFvalido(){
        String digitosverificadores = getCpf().substring(12, 14);
        
        String resultado;
        int somatorio = 0, resto;
        int multiplicador = 11;
        for(int i = 0; i < 11; i++){
            String aux = getCpf().substring(i, i+1);
            if(!aux.equals(".")){
                multiplicador = multiplicador - 1;
                somatorio = somatorio + (Integer.parseInt(aux)*multiplicador);
            }
        }
        resto = somatorio % 11;
        if(resto < 2)
            resultado = "0";
        else
            resultado = ""+(11 - resto)+"";
        somatorio = 0;
        multiplicador = 12;
        for(int i = 0; i < 11; i++){
            String aux = getCpf().substring(i, i+1);
            if(!aux.equals(".")){
                multiplicador = multiplicador - 1;
                somatorio = somatorio + (Integer.parseInt(aux)*multiplicador);
            }
        }
        multiplicador = multiplicador - 1;
        somatorio = somatorio + (Integer.parseInt(resultado)*multiplicador);
        resto = somatorio % 11;
        if(resto < 2)
            resultado = resultado + "0";
        else
            resultado = resultado + ""+(11 - resto)+"";
        if(resultado.equals(digitosverificadores))
            return true;
        else
            return false;
    }
    
    public boolean CPFnumerosiguais(){
        if(getCpf().equals("000.000.000-00")||
           getCpf().equals("111.111.111-11")||
           getCpf().equals("222.222.222-22")||
           getCpf().equals("333.333.333-33")||
           getCpf().equals("444.444.444-44")||
           getCpf().equals("555.555.555-55")||
           getCpf().equals("666.666.666-66")||
           getCpf().equals("777.777.777-77")||
           getCpf().equals("888.888.888-88")||
           getCpf().equals("999.999.999-99")||
           getCpf().equals("123.456.789-09")){
            return true;
        } else
            return false;
    }
    
    public void retornapessoafisica() {
        conn.executeSQL("SELECT TO_CHAR(\"P\".\"DT_CADASTRO\",'DD/MM/YYYY'), \"PF\".\"NM_PESSOA\", \"PF\".\"NR_CPF\", \"PF\".\"NR_RG\", \"PF\".\"DS_SEXO\", TO_CHAR(\"PF\".\"DT_NASCIMENTO\",'DD/MM/YYYY'),\n"
                + "       \"E\".\"DS_LOGRADOURO\", \"E\".\"NR_NUMERO\", \"E\".\"NM_BAIRRO\", \"E\".\"DS_CEP\", \"C\".\"NM_CIDADE\", \"U\".\"NM_UF\"\n"
                + "FROM bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA_FISICA\" \"PF\" ON \"P\".\"CD_PESSOA\" = \"PF\".\"CD_PESSOA_FIS\"\n"
                + "JOIN bancoloja.\"CAD_ENDERECO\" \"E\" ON \"P\".\"CD_PESSOA\" = \"E\".\"CD_PESSOA\"\n"
                + "JOIN bancoloja.\"CAD_CIDADE\" \"C\" ON \"E\".\"CD_CIDADE\" = \"C\".\"CD_CIDADE\"\n"
                + "JOIN bancoloja.\"CAD_UF\" \"U\" ON \"C\".\"CD_UF\" = \"U\".\"CD_UF\"\n"
                + "WHERE \"P\".\"CD_PESSOA\" = " + getPessoa().getCodigo() + "");
        try {
            conn.resultset.first();
            getPessoa().setDatacadastro(conn.resultset.getString(1));
            setNome(conn.resultset.getString(2));
            setCpf(conn.resultset.getString(3));
            setRg(conn.resultset.getString(4));
            setSexo(conn.resultset.getString(5));
            setDatanasc(conn.resultset.getString(6));
            getPessoa().getEndereco().setLogradouro(conn.resultset.getString(7));
            getPessoa().getEndereco().setNumero(conn.resultset.getString(8));
            getPessoa().getEndereco().setBairro(conn.resultset.getString(9));
            getPessoa().getEndereco().setCep(conn.resultset.getString(10));
            getPessoa().getEndereco().getCidade().setCidade(conn.resultset.getString(11));
            getPessoa().getEndereco().getCidade().getEstado().setEstado(conn.resultset.getString(12));
        } catch (SQLException ex) {
            
        }
    }
    
    public boolean epessoafisica(){
        conn.executeSQL("SELECT \"CD_PESSOA_FIS\" FROM bancoloja.\"CAD_PESSOA_FISICA\"\n" +
                        "WHERE \"NM_PESSOA\" = '"+getNome()+"'");
        try {
            conn.resultset.first();
            getPessoa().setCodigo(conn.resultset.getInt(1));
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public ClassePessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(ClassePessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }
    
}
