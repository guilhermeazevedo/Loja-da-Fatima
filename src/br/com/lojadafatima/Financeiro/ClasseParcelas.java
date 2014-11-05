package br.com.lojadafatima.Financeiro;

import br.com.lojadafatima.ClassesFerramentas.ClasseDatas;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClasseParcelas {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private ClasseContasPagarReceber conta = new ClasseContasPagarReceber();
    private ClasseFormaPagamento formapgto = new ClasseFormaPagamento();
    private String dtpagar;
    private String dtpago;
    private float vlpagar;
    private float vlpago;
    private int codigoreparcela;
    private int cdcontareparcela;
    
    public void gerarparcelas(){
        getConta().getCondicao().retornacondicao();
        int intervalo = getConta().getCondicao().getIntervalodias();
        float vlparcela = getConta().getTotal() / getConta().getCondicao().getNrparcelas();
        int parcelainteira = (int) vlparcela;
        int parteinteiro = ((int) vlparcela * getConta().getCondicao().getNrparcelas());
        float diferparcela = (getConta().getTotal() - parteinteiro);
        setVlpagar(parcelainteira);
        
        ClasseDatas datas = new ClasseDatas();
        
        for(int i = 1; i <= getConta().getCondicao().getNrparcelas(); i++){
            setCodigo(i);
            if(getCodigo() == 1){
                setVlpagar(parcelainteira + diferparcela);
            } else{
                setVlpagar(parcelainteira);
            }
            
            if(getConta().getCondicao().getEntrada().equals("N")){
                setDtpagar(datas.retornasoma("", getConta().getCondicao().getIntervalodias()));
                conn.executeSQL("INSERT INTO bancoloja.\"PARCELAS\"(\n" +
                                "            \"CD_PARCELA\", \"CD_CONTA\", \"CD_OPERACAO\", \"DT_PAGAR\", \"VL_PAGAR\")\n" +
                                "VALUES ("+getCodigo()+", "+getConta().getCodigo()+", "+getConta().getOperacao().getCodigo()+", '"+getDtpagar()+"', "+getVlpagar()+")");
                getConta().getCondicao().setIntervalodias(getConta().getCondicao().getIntervalodias() + intervalo);
            } else if(getConta().getCondicao().getEntrada().equals("S") && getCodigo() == 1){
                setDtpagar(datas.retornasoma("", 0));
                conn.executeSQL("INSERT INTO bancoloja.\"PARCELAS\"(\n" +
                                "            \"CD_PARCELA\", \"CD_CONTA\", \"CD_OPERACAO\", \"DT_PAGAR\", \"VL_PAGAR\")\n" +
                                "VALUES ("+getCodigo()+", "+getConta().getCodigo()+", "+getConta().getOperacao().getCodigo()+", '"+getDtpagar()+"', "+getVlpagar()+")");
                getConta().getCondicao().setEntrada("N");
            }
        }
    }
    
    public ResultSet buscaparcelasajuste(){
        conn.executeSQL("SELECT \"CD_PARCELA\", TO_CHAR(\"DT_PAGAR\", 'DD/MM/YYYY'), \"VL_PAGAR\"\n" +
                        "FROM bancoloja.\"PARCELAS\"\n" +
                        "WHERE \"CD_CONTA\" = "+getConta().getCodigo()+" AND \"CD_OPERACAO\" = "+getConta().getOperacao().getCodigo());
        return conn.resultset;
    }
    
    public void atualizarparcela(){
        conn.executeSQL("UPDATE bancoloja.\"PARCELAS\"\n" +
                        "SET \"DT_PAGAR\" = '"+getDtpagar()+"', \"VL_PAGAR\" = "+getVlpagar()+"\n" +
                        "WHERE \"CD_PARCELA\" = "+getCodigo()+" AND \"CD_CONTA\" = "+getConta().getCodigo()+" AND \"CD_OPERACAO\" = "+getConta().getOperacao().getCodigo());
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ClasseContasPagarReceber getConta() {
        return conta;
    }

    public void setConta(ClasseContasPagarReceber conta) {
        this.conta = conta;
    }

    public ClasseFormaPagamento getFormapgto() {
        return formapgto;
    }

    public void setFormapgto(ClasseFormaPagamento formapgto) {
        this.formapgto = formapgto;
    }

    public String getDtpagar() {
        return dtpagar;
    }

    public void setDtpagar(String dtpagar) {
        this.dtpagar = dtpagar;
    }

    public String getDtpago() {
        return dtpago;
    }

    public void setDtpago(String dtpago) {
        this.dtpago = dtpago;
    }

    public float getVlpagar() {
        return vlpagar;
    }

    public void setVlpagar(float vlpagar) {
        this.vlpagar = vlpagar;
    }

    public float getVlpago() {
        return vlpago;
    }

    public void setVlpago(float vlpago) {
        this.vlpago = vlpago;
    }

    public int getCodigoreparcela() {
        return codigoreparcela;
    }

    public void setCodigoreparcela(int codigoreparcela) {
        this.codigoreparcela = codigoreparcela;
    }

    public int getCdcontareparcela() {
        return cdcontareparcela;
    }

    public void setCdcontareparcela(int cdcontareparcela) {
        this.cdcontareparcela = cdcontareparcela;
    }

}
