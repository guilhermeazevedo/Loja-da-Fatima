/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.DadosPessoa;

import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;

/**
 *
 * @author hp
 */
public class ClasseEndereco {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigopessoa;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private ClasseCidade cidade = new ClasseCidade();
    
    public void incluir(){
        conn.executeSQL("INSERT INTO bancoloja.\"CAD_ENDERECO\"(\n" +
                        "\"CD_PESSOA\", \"DS_LOGRADOURO\", \"NR_NUMERO\", \"NM_BAIRRO\", \"DS_CEP\", \"CD_CIDADE\")\n" +
                        "VALUES ("+getCodigopessoa()+", '"+getLogradouro().toUpperCase()+"', '"+getNumero()+"', '"+getBairro().toUpperCase()+"', '"+getCep()+"', '"+getCidade().getCodigo()+"');");
    }
    
    public void alterar(){
        conn.executeSQL("UPDATE bancoloja.\"CAD_ENDERECO\"\n" +
                        "SET \"DS_LOGRADOURO\"='"+getLogradouro().toUpperCase()+"', \"NR_NUMERO\"='"+getNumero()+"', \"NM_BAIRRO\"='"+getBairro().toUpperCase()+"', \"DS_CEP\"='"+getCep()+"', \"CD_CIDADE\"="+getCidade().getCodigo()+"\n" +
                        "WHERE \"CD_PESSOA\" = "+getCodigopessoa()+"");
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public ClasseCidade getCidade() {
        return cidade;
    }

    public void setCidade(ClasseCidade cidade) {
        this.cidade = cidade;
    }

    public int getCodigopessoa() {
        return codigopessoa;
    }

    public void setCodigopessoa(int codigopessoa) {
        this.codigopessoa = codigopessoa;
    }
    
}
