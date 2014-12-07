package br.com.lojadafatima.Financeiro;

import br.com.lojadafatima.ClassesFerramentas.ClasseDatas;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

    public void gerarparcelas() {
        getConta().getCondicao().retornacondicao();
        int intervalo = getConta().getCondicao().getIntervalodias();
        float vlparcela = getConta().getTotal() / getConta().getCondicao().getNrparcelas();
        int parcelainteira = (int) vlparcela;
        int parteinteiro = ((int) vlparcela * getConta().getCondicao().getNrparcelas());
        float diferparcela = (getConta().getTotal() - parteinteiro);
        setVlpagar(parcelainteira);

        ClasseDatas datas = new ClasseDatas();

        for (int i = 1; i <= getConta().getCondicao().getNrparcelas(); i++) {
            setCodigo(i);
            if (getCodigo() == 1) {
                setVlpagar(parcelainteira + diferparcela);
            } else {
                setVlpagar(parcelainteira);
            }

            if (getConta().getCondicao().getEntrada().equals("N")) {
                setDtpagar(datas.retornasoma("", getConta().getCondicao().getIntervalodias()));
                conn.executeSQL("INSERT INTO bancoloja.\"PARCELAS\"(\n"
                        + "            \"CD_PARCELA\", \"CD_CONTA\", \"CD_OPERACAO\", \"DT_PAGAR\", \"VL_PAGAR\")\n"
                        + "VALUES (" + getCodigo() + ", " + getConta().getCodigo() + ", " + getConta().getOperacao().getCodigo() + ", '" + getDtpagar() + "', " + getVlpagar() + ")");
                getConta().getCondicao().setIntervalodias(getConta().getCondicao().getIntervalodias() + intervalo);
            } else if (getConta().getCondicao().getEntrada().equals("S") && getCodigo() == 1) {
                setDtpagar(datas.retornasoma("", 0));
                conn.executeSQL("INSERT INTO bancoloja.\"PARCELAS\"(\n"
                        + "            \"CD_PARCELA\", \"CD_CONTA\", \"CD_OPERACAO\", \"DT_PAGAR\", \"VL_PAGAR\")\n"
                        + "VALUES (" + getCodigo() + ", " + getConta().getCodigo() + ", " + getConta().getOperacao().getCodigo() + ", '" + getDtpagar() + "', " + getVlpagar() + ")");
                getConta().getCondicao().setEntrada("N");
            }
        }
    }

    public ResultSet buscaparcelasajuste() {
        conn.executeSQL("SELECT \"CD_PARCELA\", TO_CHAR(\"DT_PAGAR\", 'DD/MM/YYYY'), TO_CHAR(\"VL_PAGAR\", 'R$9999999D99')\n"
                + "FROM bancoloja.\"PARCELAS\"\n"
                + "WHERE \"CD_CONTA\" = " + getConta().getCodigo() + " AND \"CD_OPERACAO\" = " + getConta().getOperacao().getCodigo());
        return conn.resultset;
    }

    public void atualizarparcela() {
        conn.executeSQL("UPDATE bancoloja.\"PARCELAS\"\n"
                + "SET \"DT_PAGAR\" = '" + getDtpagar() + "', \"VL_PAGAR\" = " + getVlpagar() + "\n"
                + "WHERE \"CD_PARCELA\" = " + getCodigo() + " AND \"CD_CONTA\" = " + getConta().getCodigo() + " AND \"CD_OPERACAO\" = " + getConta().getOperacao().getCodigo());
    }

    public void acrescentarparcela() {
        setVlpagar(getVlpagar() + ((getVlpagar() * getConta().getMulta().getPercent()) / 100));
        conn.executeSQL("UPDATE bancoloja.\"PARCELAS\"\n"
                + "SET \"VL_PAGAR\" = " + getVlpagar() + ", \"IN_APLICACAO_MULTA\" = 'S'\n"
                + "WHERE \"CD_PARCELA\" = " + getCodigo() + " AND \"CD_CONTA\" = " + getConta().getCodigo() + " AND \"CD_OPERACAO\" = " + getConta().getOperacao().getCodigo());
    }

    public ResultSet retornaparcelas() {
        conn.executeSQL("SELECT \"CD_PARCELA\", \"VL_PAGAR\", \"VL_PAGO\", TO_CHAR(\"DT_PAGAR\", 'DD/MM/YYYY'), TO_CHAR(\"DT_PAGO\", 'DD/MM/YYYY'),\n"
                + "                               CASE WHEN \"DT_PAGO\" IS NOT NULL THEN 'PAGA'\n"
                + "                               ELSE CASE WHEN \"DT_PAGAR\" < (SELECT CURRENT_DATE) THEN 'VENCIDO'\n"
                + "                               ELSE 'A PAGAR' END END,\n"
                + "\"CD_PARCELA_REPARCELA\""
                + "                        FROM bancoloja.\"PARCELAS\"\n"
                + "WHERE \"CD_CONTA\" = " + getConta().getCodigo() + " AND \"CD_OPERACAO\" = " + getConta().getOperacao().getCodigo() + "\n"
                + "ORDER BY \"CD_PARCELA\"");
        return conn.resultset;
    }

    public void pagaparcela() {
        ClasseDatas datas = new ClasseDatas();
        setDtpago(datas.retornaratartual());
        conn.atualizarSQL("UPDATE bancoloja.\"PARCELAS\"\n"
                + "   SET \"CD_FORMA_PGTO\"= " + getFormapgto().getCodigo() + ", \"DT_PAGO\"= '" + getDtpago() + "', \"VL_PAGO\"= " + getVlpago() + "\n"
                + " WHERE \"CD_PARCELA\" = " + getCodigo() + " AND \"CD_CONTA\" = " + getConta().getCodigo() + " AND \"CD_OPERACAO\" = " + getConta().getOperacao().getCodigo());
        atualizasituacaoconta();
    }

    public void atualizasituacaoconta() {
        ResultSet rs = retornaparcelas();
        boolean vencida = false, paga = true;
        try {
            while (rs.next()) {
                if (rs.getString(6).equals("VENCIDO")) {
                    vencida = true;
                }
                if (rs.getString(6).equals("A PAGAR")) {
                    paga = false;
                }
            }
            if (vencida) {
                getConta().contavencida();
            } else if (paga) {
                getConta().contapaga();
            } else {
                getConta().contaaberta();
            }
        } catch (SQLException ex) {
        }
    }

    public void atualizaparcelasecontas() {
        ResultSet rs = getConta().retornatodasascontasabertas();
        try {
            while (rs.next()) {
                getConta().setCodigo(rs.getInt(1));
                getConta().getOperacao().setCodigo(rs.getInt(2));
                atualizasituacaoconta();
            }
        } catch (SQLException ex) {

        }
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        ClasseDatas datas = new ClasseDatas();
        Date date1 = null, date2 = null;
        String data1, data2;
        ResultSet rsp = retornaparcelasnaopagas();
        try {
            while (rsp.next()) {
                data1 = ""; data2 = "";
                setCodigo(rsp.getInt(1));
                getConta().setCodigo(rsp.getInt(2));
                getConta().getOperacao().setCodigo(rsp.getInt(3));
                setVlpagar(rsp.getFloat(4));
                getConta().buscamultaconta();
                data1 = datas.retornaratartual();
                data2 = datas.retornasoma(rsp.getString(5), getConta().getMulta().getDiasacresc());
                try {
                    date1 = format.parse(data1);
                    date2 = format.parse(data2);
                    if (!date1.before(date2)) {
                        acrescentarparcela();
                    }
                } catch (ParseException ex) {
                }
            }
        } catch (SQLException ex) {

        }
    }

    public ResultSet retornaparcelasnaopagas() {
        conn.executeSQL("SELECT \"CD_PARCELA\", \"CD_CONTA\", \"CD_OPERACAO\", \"VL_PAGAR\", TO_CHAR(\"DT_PAGAR\", 'DD/MM/YYYY')\n"
                + "FROM bancoloja.\"PARCELAS\"\n"
                + "WHERE \"DT_PAGO\" IS NULL AND \"IN_APLICACAO_MULTA\" IS NULL\n"
                + "AND \"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                       WHERE \"TP_FINANCEIRO\" = 'E'))");
        return conn.resultset;
    }

    public void gerarreparcela() {
        setDtpagar(proximadatapagar());
        setCodigoreparcela(getCodigo());
        conn.executeSQL("INSERT INTO bancoloja.\"PARCELAS\"(\n"
                + "            \"CD_PARCELA\", \"CD_CONTA\", \"CD_OPERACAO\", \"DT_PAGAR\", \n"
                + "            \"VL_PAGAR\", \"CD_PARCELA_REPARCELA\", \"CD_CONTA_REPARCELA\", \n"
                + "            \"CD_OPERACAO_REPARCELA\")\n"
                + "    VALUES (" + (retornanumeroultimaparcela() + 1) + ", " + getConta().getCodigo() + ", " + getConta().getOperacao().getCodigo() + ", '" + getDtpagar() + "', \n"
                + "            " + getVlpagar() + ", " + getCodigoreparcela() + ", " + getConta().getCodigo() + ", \n"
                + "            " + getConta().getOperacao().getCodigo() + ")");
    }

    public void extornarparcela() {
        setDtpagar(proximadatapagar());
        conn.executeSQL("UPDATE bancoloja.\"PARCELAS\"\n"
                + "   SET \"CD_FORMA_PGTO\" = NULL, \"DT_PAGO\" = NULL, \"DT_PAGAR\" = '" + getDtpagar() + "', \"VL_PAGAR\" = " + getVlpagar() + ", \"VL_PAGO\" = NULL\n"
                + " WHERE \"CD_PARCELA\" = " + getCodigo() + " AND \"CD_CONTA\" = " + getConta().getCodigo() + " AND \"CD_OPERACAO\" = " + getConta().getOperacao().getCodigo());
        atualizasituacaoconta();
    }

    public String proximadatapagar() {
        conn.executeSQL("SELECT \"CD_CONDICAO_PGTO\" FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "WHERE \"CD_CONTA\" = " + getConta().getCodigo() + " AND \"CD_OPERACAO\" = " + getConta().getOperacao().getCodigo());
        try {
            conn.resultset.first();
            getConta().getCondicao().setCodigo(conn.resultset.getInt(1));
            getConta().getCondicao().retornacondicao();
        } catch (SQLException ex) {
        }
        ClasseDatas datas = new ClasseDatas();
        conn.executeSQL("SELECT TO_CHAR(MAX(\"DT_PAGAR\"), 'DD/MM/YYYY') FROM bancoloja.\"PARCELAS\"\n" +
                        "WHERE \"CD_CONTA\" = "+getConta().getCodigo()+" AND \"CD_OPERACAO\" = " + getConta().getOperacao().getCodigo());
        try {
            conn.resultset.first();
            return datas.retornasoma(conn.resultset.getString(1), getConta().getCondicao().getIntervalodias());
        } catch (SQLException ex) {
            return "";
        }
    }

    public int retornanumeroultimaparcela() {
        conn.executeSQL("SELECT MAX(\"CD_PARCELA\") FROM bancoloja.\"PARCELAS\"\n"
                + "WHERE \"CD_CONTA\" = " + getConta().getCodigo() + " AND \"CD_OPERACAO\" = " + getConta().getOperacao().getCodigo());
        try {
            conn.resultset.first();
            return conn.resultset.getInt(1);
        } catch (SQLException ex) {
            return 0;
        }
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
