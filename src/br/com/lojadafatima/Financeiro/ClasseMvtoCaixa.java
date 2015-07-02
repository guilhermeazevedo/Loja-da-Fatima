package br.com.lojadafatima.Financeiro;

import br.com.lojadafatima.ClassesFerramentas.ClasseDatas;
import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClasseMvtoCaixa {

    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private String dsmvto;
    private String tpmvto;
    private ClasseParcelas parcela = new ClasseParcelas();
    private String datamvto;
    private float vlantes;
    private float vlmvto;
    private float vlatual;

    public void incluir() {
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("MOV_CAIXA", "CD_MVTO"));
        ClasseDatas datas = new ClasseDatas();
        setDatamvto(datas.retornadataehora());
        setVlantes(retornacaixaatual());
        if (getTpmvto().equals("E")) {
            setVlatual(getVlantes() + getVlmvto());
        } else {
            setVlatual(getVlantes() - getVlmvto());
        }
        conn.executeSQL("INSERT INTO bancoloja.\"MOV_CAIXA\"(\n"
                + "            \"CD_MVTO\", \"DS_MVTO\", \"TP_MVTO\", \"CD_PARCELA\", \"CD_CONTA\", \"CD_OPERACAO\", \n"
                + "            \"DT_MVTO\", \"VL_ANTES\", \"VL_MVTO\", \"VL_ATUAL\")\n"
                + "    VALUES (" + getCodigo() + ", '" + getDsmvto() + "', '" + getTpmvto() + "', " + getParcela().getCodigo() + ", " + getParcela().getConta().getCodigo() + ", " + getParcela().getConta().getOperacao().getCodigo() + ", \n"
                + "            '" + getDatamvto() + "', " + getVlantes() + ", " + getVlmvto() + ", " + getVlatual() + ");");
    }

    public float retornacaixaatual() {
        conn.executeSQL("SELECT \"VL_ATUAL\" FROM bancoloja.\"MOV_CAIXA\"\n"
                + "WHERE \"CD_MVTO\" = (SELECT MAX(\"CD_MVTO\") FROM bancoloja.\"MOV_CAIXA\")");
        try {
            conn.resultset.first();
            return conn.resultset.getFloat(1);
        } catch (SQLException ex) {
            return 0;
        }
    }

    public ResultSet retornahistoricopagamentossalario() {
        conn.executeSQL("SELECT \"DS_MVTO\", \"VL_MVTO\", TO_CHAR(\"DT_MVTO\", 'DD/MM/YYYY - HH24:MI:SS')\n"
                + "FROM bancoloja.\"MOV_CAIXA\"\n"
                + "WHERE \"DS_MVTO\" LIKE 'PAGAMENTO DE SALARIO AO FUNCIONARIO " + getParcela().getConta().getCompravenda().getFuncionario().getPessoafis().getNome() + "%'");
        return conn.resultset;
    }
    
    public boolean pagamentodomesrealizado(String mesano){
        conn.executeSQL("SELECT \"DS_MVTO\"\n" +
                        "FROM bancoloja.\"MOV_CAIXA\"\n" +
                        "WHERE \"DS_MVTO\" LIKE '%"+ getParcela().getConta().getCompravenda().getFuncionario().getPessoafis().getNome() +", REFERENTE AO TRABALHO DO MES "+mesano+"'");
        try {
            conn.resultset.first();
            conn.resultset.getString(1);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public ResultSet mvtocaixa(String data_ini, String data_fim, String tipo_mvto){
        conn.executeSQL("SELECT \"CD_MVTO\",\n" +
                        "       \"DS_MVTO\",\n" +
                        "       TO_CHAR(\"DT_MVTO\", 'DD/MM/YYYY ÀS HH24:MI:SS'),\n" +
                        "       \"VL_ANTES\",\n" +
                        "       \"VL_MVTO\",\n" +
                        "       CASE WHEN \"TP_MVTO\" = 'E' THEN 'ENTRADA'\n" +
                        "       ELSE 'SAIDA' END AS \"TIPO\",\n" +
                        "       \"VL_ATUAL\"\n" +
                        "FROM bancoloja.\"MOV_CAIXA\"\n" +
                        "WHERE DATE(\"DT_MVTO\") BETWEEN '"+data_ini+"' AND '"+data_fim+"' AND\n" +
                        "      \"TP_MVTO\" <> '"+tipo_mvto+"'\n" +
                        "ORDER BY \"DT_MVTO\"");
        return conn.resultset;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTpmvto() {
        return tpmvto;
    }

    public void setTpmvto(String tpmvto) {
        this.tpmvto = tpmvto;
    }

    public ClasseParcelas getParcela() {
        return parcela;
    }

    public void setParcela(ClasseParcelas parcela) {
        this.parcela = parcela;
    }

    public String getDatamvto() {
        return datamvto;
    }

    public void setDatamvto(String datamvto) {
        this.datamvto = datamvto;
    }

    public float getVlantes() {
        return vlantes;
    }

    public void setVlantes(float vlantes) {
        this.vlantes = vlantes;
    }

    public float getVlmvto() {
        return vlmvto;
    }

    public void setVlmvto(float vlmvto) {
        this.vlmvto = vlmvto;
    }

    public float getVlatual() {
        return vlatual;
    }

    public void setVlatual(float vlatual) {
        this.vlatual = vlatual;
    }

    public String getDsmvto() {
        return dsmvto;
    }

    public void setDsmvto(String dsmvto) {
        this.dsmvto = dsmvto;
    }
}
