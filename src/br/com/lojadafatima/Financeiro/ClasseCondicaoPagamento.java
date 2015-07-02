package br.com.lojadafatima.Financeiro;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClasseCondicaoPagamento {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private String condicaodepgto;
    private int nrparcelas;
    private int intervalodias;
    private String entrada;
    
    public boolean incluir(){
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_CONDICAO_PGTO", "CD_CONDICAO_PGTO"));
        conn.incluirSQL("INSERT INTO bancoloja.\"CAD_CONDICAO_PGTO\"(\n" +
                        "\"CD_CONDICAO_PGTO\", \"DS_CONDICAO_PGTO\", \"NR_VEZES_PGTO\", \"NR_INTERVALO_DIAS\", \"IN_ENTRADA\")\n" +
                        "VALUES ("+getCodigo()+", '"+getCondicaodepgto().toUpperCase()+"', "+getNrparcelas()+", "+getIntervalodias()+", '"+getEntrada()+"')");
        if (conn.retorno == 1) return true;
        else                   return false;
    }
    
    public boolean alterar(){
        conn.atualizarSQL("UPDATE bancoloja.\"CAD_CONDICAO_PGTO\"\n" +
                          "SET \"DS_CONDICAO_PGTO\"='"+getCondicaodepgto().toUpperCase()+"', \"NR_VEZES_PGTO\"="+getNrparcelas()+", \"NR_INTERVALO_DIAS\"="+getIntervalodias()+", \"IN_ENTRADA\"='"+getEntrada()+"'\n" +
                          "WHERE \"CD_CONDICAO_PGTO\" = "+getCodigo());
        if (conn.retorno == 1) return true;
        else                   return false;
    }
    
    public ResultSet retornacondicoespagamentojtable(){
        conn.executeSQL("SELECT \"CD_CONDICAO_PGTO\", \"DS_CONDICAO_PGTO\", \"NR_VEZES_PGTO\", \"NR_INTERVALO_DIAS\",\n" +
                        "CASE WHEN \"IN_ENTRADA\" = 'S' THEN 'COM ENTRADA'\n" +
                        "     ELSE 'SEM ENTRADA' END AS \"SITUACAO\"\n" +
                        "FROM bancoloja.\"CAD_CONDICAO_PGTO\" ORDER BY \"CD_CONDICAO_PGTO\"");
        return conn.resultset;
    }
    
    public String retornadescricaocondicao(){
        conn.executeSQL("SELECT \"DS_CONDICAO_PGTO\"\n" +
                        "FROM bancoloja.\"CAD_CONDICAO_PGTO\"\n" +
                        "WHERE \"CD_CONDICAO_PGTO\" = "+getCodigo());
        try{
            conn.resultset.first();
            return conn.resultset.getString(1);
        }catch(SQLException ex){
            return "";
        }
    }
    
    public void retornacondicao(){
        conn.executeSQL("SELECT \"NR_VEZES_PGTO\", \"NR_INTERVALO_DIAS\", \"IN_ENTRADA\"\n" +
                        "FROM bancoloja.\"CAD_CONDICAO_PGTO\"\n" +
                        "WHERE \"CD_CONDICAO_PGTO\" = "+getCodigo());
        try{
            conn.resultset.first();
            setNrparcelas(conn.resultset.getInt(1));
            setIntervalodias(conn.resultset.getInt(2));
            setEntrada(conn.resultset.getString(3));
        } catch(SQLException ex){
            
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCondicaodepgto() {
        return condicaodepgto;
    }

    public void setCondicaodepgto(String condicaodepgto) {
        this.condicaodepgto = condicaodepgto;
    }

    public int getNrparcelas() {
        return nrparcelas;
    }

    public void setNrparcelas(int nrparcelas) {
        this.nrparcelas = nrparcelas;
    }

    public int getIntervalodias() {
        return intervalodias;
    }

    public void setIntervalodias(int intervalodias) {
        this.intervalodias = intervalodias;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }
    
}
