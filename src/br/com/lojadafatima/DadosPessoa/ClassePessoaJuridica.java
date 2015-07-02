package br.com.lojadafatima.DadosPessoa;

import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClassePessoaJuridica {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private ClassePessoa pessoa = new ClassePessoa();
    private String nomefantasia;
    private String razaosocial;
    private String cnpj;
    private String datafund;
    
    public void incluir(){
        conn.executeSQL("INSERT INTO bancoloja.\"CAD_PESSOA_JURIDICA\"(\n" +
                        "\"CD_PESSOA_JUR\", \"NM_FANTASIA\", \"DS_RAZAO_SOCIAL\", \"NR_CNPJ\", \"DT_FUNDACAO\")\n" +
                        "VALUES ("+getPessoa().getCodigo()+", '"+getNomefantasia().toUpperCase()+"', '"+getRazaosocial().toUpperCase()+"', '"+getCnpj()+"', '"+getDatafund()+"');");
    }
    
    public void alterar(){
        conn.atualizarSQL("UPDATE bancoloja.\"CAD_PESSOA_JURIDICA\"\n" +
                          "SET \"NM_FANTASIA\"='"+getNomefantasia().toUpperCase()+"', \"DS_RAZAO_SOCIAL\"='"+getRazaosocial().toUpperCase()+"', \"NR_CNPJ\"='"+getCnpj()+"', \"DT_FUNDACAO\"='"+getDatafund()+"'\n" +
                          "WHERE \"CD_PESSOA_JUR\"="+getPessoa().getCodigo()+"");
    }
    
    public boolean CNPJvalido(){
        String digitosverificadores = getCnpj().substring(16, 18);
        
        String resultado;
        int somatorio = 0, resto;
        int multiplicador = 6;
        for(int i = 0; i < 15; i++){
            String aux = getCnpj().substring(i, i+1);
            if(!aux.equals(".") && !aux.equals("/")){
                multiplicador = multiplicador - 1;
                if(multiplicador == 1){
                    multiplicador = 9;
                }
                somatorio = somatorio + (Integer.parseInt(aux)*multiplicador);
            }
        }
        resto = somatorio % 11;
        if(resto < 2)
            resultado = "0";
        else
            resultado = ""+(11 - resto)+"";
        somatorio = 0;
        multiplicador = 7;
        for(int i = 0; i < 15; i++){
            String aux = getCnpj().substring(i, i+1);
            if(!aux.equals(".") && !aux.equals("/")){
                multiplicador = multiplicador - 1;
                if(multiplicador == 1){
                    multiplicador = 9;
                }
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
    
    public boolean CNPJnumerosiguais(){
        if(getCnpj().equals("00.000.000/0000-00")||
           getCnpj().equals("11.111.111/1111-11")||
           getCnpj().equals("22.222.222/2222-22")||
           getCnpj().equals("33.333.333/3333-33")||
           getCnpj().equals("44.444.444/4444-44")||
           getCnpj().equals("55.555.555/5555-55")||
           getCnpj().equals("66.666.666/6666-66")||
           getCnpj().equals("77.777.777/7777-77")||
           getCnpj().equals("88.888.888/8888-88")||
           getCnpj().equals("99.999.999/9999-99")){
            return true;
        } else
            return false;
    }
    
    public boolean CNPJexistente(){
        conn.executeSQL("SELECT \"CD_PESSOA_JUR\"\n"
                + "FROM bancoloja.\"CAD_PESSOA_JURIDICA\"\n"
                + "WHERE \"NR_CNPJ\" = '" + getCnpj() + "'");
        try {
            conn.resultset.first();
            conn.resultset.getInt(1);
            return true;
        } catch (SQLException ex) {

        }
        return false;
    }
    
    public String retornanomeporCNPJ(){
        conn.executeSQL("SELECT \"NM_FANTASIA\"\n" +
                        "FROM bancoloja.\"CAD_PESSOA_JURIDICA\"\n" +
                        "WHERE \"NR_CNPJ\" = '"+getCnpj()+"'");
        try{
            conn.resultset.first();
            return conn.resultset.getString(1);
        }catch(SQLException ex){
            
        }
        return "";
    }
    
    public void retornapessoajuridica() {
        conn.executeSQL("SELECT TO_CHAR(\"P\".\"DT_CADASTRO\",'DD/MM/YYYY'), \"PJ\".\"NM_FANTASIA\", \"PJ\".\"DS_RAZAO_SOCIAL\", \"PJ\".\"NR_CNPJ\", TO_CHAR(\"PJ\".\"DT_FUNDACAO\",'DD/MM/YYYY'),\n"
                + "       \"E\".\"DS_LOGRADOURO\", \"E\".\"NR_NUMERO\", \"E\".\"NM_BAIRRO\", \"E\".\"DS_CEP\", \"C\".\"NM_CIDADE\", \"U\".\"NM_UF\"\n"
                + "FROM bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "JOIN bancoloja.\"CAD_PESSOA_JURIDICA\" \"PJ\" ON \"P\".\"CD_PESSOA\" = \"PJ\".\"CD_PESSOA_JUR\"\n"
                + "JOIN bancoloja.\"CAD_ENDERECO\" \"E\" ON \"P\".\"CD_PESSOA\" = \"E\".\"CD_PESSOA\"\n"
                + "JOIN bancoloja.\"CAD_CIDADE\" \"C\" ON \"E\".\"CD_CIDADE\" = \"C\".\"CD_CIDADE\"\n"
                + "JOIN bancoloja.\"CAD_UF\" \"U\" ON \"C\".\"CD_UF\" = \"U\".\"CD_UF\"\n"
                + "WHERE \"P\".\"CD_PESSOA\" = "+getPessoa().getCodigo()+"");
        try {
            conn.resultset.first();
            getPessoa().setDatacadastro(conn.resultset.getString(1));
            setNomefantasia(conn.resultset.getString(2));
            setRazaosocial(conn.resultset.getString(3));
            setCnpj(conn.resultset.getString(4));
            setDatafund(conn.resultset.getString(5));
            if(getDatafund().equals("01/01/0001"))
                setDatafund("  /  /    ");
            getPessoa().getEndereco().setLogradouro(conn.resultset.getString(6));
            getPessoa().getEndereco().setNumero(conn.resultset.getString(7));
            getPessoa().getEndereco().setBairro(conn.resultset.getString(8));
            getPessoa().getEndereco().setCep(conn.resultset.getString(9));
            getPessoa().getEndereco().getCidade().setCidade(conn.resultset.getString(10));
            getPessoa().getEndereco().getCidade().getEstado().setEstado(conn.resultset.getString(11));
        } catch (SQLException ex) {
        }
    }
    
    public String retornanomeporCodigo(){
        conn.executeSQL("SELECT \"NM_FANTASIA\"\n" +
                        "FROM bancoloja.\"CAD_PESSOA_JURIDICA\"\n" +
                        "WHERE \"CD_PESSOA_JUR\" = "+getPessoa().getCodigo());
        try{
            conn.resultset.first();
            return conn.resultset.getString(1);
        }catch(SQLException ex){
            
        }
        return "";
    }
    
    public boolean epessoajuridica(){
        conn.executeSQL("SELECT \"CD_PESSOA_JUR\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\"\n" +
                        "WHERE \"NM_FANTASIA\" = '"+getNomefantasia()+"'");
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

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDatafund() {
        return datafund;
    }

    public void setDatafund(String datafund) {
        this.datafund = datafund;
    }
    
}
