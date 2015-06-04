/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojadafatima.Financeiro;

import br.com.lojadafatima.ClassesFerramentas.ClasseDatas;
import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
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
        conn.executeSQL("SELECT \"DS_MVTO\", \"VL_MVTO\"\n"
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

    public ResultSet mvtocaixadia() {
        conn.executeSQL("SELECT \"CD_MVTO\",\n"
                + "       \"DS_MVTO\",\n"
                + "       TO_CHAR(\"DT_MVTO\", 'DD/MM/YYYY ÀS HH24:MI:SS'),\n"
                + "       \"VL_ANTES\",\n"
                + "       \"VL_ATUAL\",\n"
                + "       \"VL_MVTO\",\n"
                + "       CASE WHEN \"TP_MVTO\" = 'E' THEN 'ENTRADA'\n"
                + "       ELSE 'SAIDA' END AS \"TIPO\"\n"
                + "FROM bancoloja.\"MOV_CAIXA\"\n"
                + "WHERE DATE_PART('DAY', \"DT_MVTO\") = DATE_PART('DAY', CURRENT_DATE)\n"
                + "AND   DATE_PART('MONTH', \"DT_MVTO\") = DATE_PART('MONTH', CURRENT_DATE)\n"
                + "ORDER BY \"CD_MVTO\"");
        return conn.resultset;
    }

    public ResultSet mvtocaixadiaanterior() {
        conn.executeSQL("SELECT DATE_PART('DAY', CURRENT_DATE)");
        int diahj;
        try {
            conn.resultset.first();
            diahj = conn.resultset.getInt(1);
        } catch (SQLException ex) {
            diahj = 0;
        }
        if (diahj == 1) {
            conn.executeSQL("SELECT \"CD_MVTO\",\n"
                    + "       \"DS_MVTO\",\n"
                    + "       TO_CHAR(\"DT_MVTO\", 'DD/MM/YYYY ÀS HH24:MI:SS'),\n"
                    + "       \"VL_ANTES\",\n"
                    + "       \"VL_ATUAL\",\n"
                    + "       \"VL_MVTO\",\n"
                    + "       CASE WHEN \"TP_MVTO\" = 'E' THEN 'ENTRADA'\n"
                    + "       ELSE 'SAIDA' END AS \"TIPO\"\n"
                    + "FROM bancoloja.\"MOV_CAIXA\"\n"
                    + "WHERE DATE_PART('DAY', \"DT_MVTO\") = DATE_PART('DAY', (CURRENT_DATE - 1))\n"
                    + "AND   DATE_PART('MONTH', \"DT_MVTO\") = (DATE_PART('MONTH', CURRENT_DATE) - 1)\n"
                    + "ORDER BY \"CD_MVTO\"");
        } else {
            conn.executeSQL("SELECT \"CD_MVTO\",\n"
                    + "       \"DS_MVTO\",\n"
                    + "       TO_CHAR(\"DT_MVTO\", 'DD/MM/YYYY ÀS HH24:MI:SS'),\n"
                    + "       \"VL_ANTES\",\n"
                    + "       \"VL_ATUAL\",\n"
                    + "       \"VL_MVTO\",\n"
                    + "       CASE WHEN \"TP_MVTO\" = 'E' THEN 'ENTRADA'\n"
                    + "       ELSE 'SAIDA' END AS \"TIPO\"\n"
                    + "FROM bancoloja.\"MOV_CAIXA\"\n"
                    + "WHERE DATE_PART('DAY', \"DT_MVTO\") = DATE_PART('DAY', (CURRENT_DATE - 1))\n"
                    + "AND   DATE_PART('MONTH', \"DT_MVTO\") = DATE_PART('MONTH', CURRENT_DATE)\n"
                    + "ORDER BY \"CD_MVTO\"");
        }
        return conn.resultset;
    }

    public ResultSet mvtocaixames() {
        conn.executeSQL("SELECT \"CD_MVTO\",\n"
                + "       \"DS_MVTO\",\n"
                + "       TO_CHAR(\"DT_MVTO\", 'DD/MM/YYYY ÀS HH24:MI:SS'),\n"
                + "       \"VL_ANTES\",\n"
                + "       \"VL_ATUAL\",\n"
                + "       \"VL_MVTO\",\n"
                + "       CASE WHEN \"TP_MVTO\" = 'E' THEN 'ENTRADA'\n"
                + "       ELSE 'SAIDA' END AS \"TIPO\"\n"
                + "FROM bancoloja.\"MOV_CAIXA\"\n"
                + "WHERE DATE_PART('MONTH', \"DT_MVTO\") = DATE_PART('MONTH', CURRENT_DATE)\n"
                + "AND   DATE_PART('YEAR', \"DT_MVTO\") = DATE_PART('YEAR', CURRENT_DATE)\n"
                + "ORDER BY \"CD_MVTO\"");
        return conn.resultset;
    }

    public ResultSet mvtocaixamesanterior() {
        conn.executeSQL("SELECT DATE_PART('MONTH', CURRENT_DATE)");
        int meshj;
        try {
            conn.resultset.first();
            meshj = conn.resultset.getInt(1);
        } catch (SQLException ex) {
            meshj = 0;
        }
        if (meshj == 1) {
            conn.executeSQL("SELECT \"CD_MVTO\",\n"
                    + "       \"DS_MVTO\",\n"
                    + "       TO_CHAR(\"DT_MVTO\", 'DD/MM/YYYY ÀS HH24:MI:SS'),\n"
                    + "       \"VL_ANTES\",\n"
                    + "       \"VL_ATUAL\",\n"
                    + "       \"VL_MVTO\",\n"
                    + "       CASE WHEN \"TP_MVTO\" = 'E' THEN 'ENTRADA'\n"
                    + "       ELSE 'SAIDA' END AS \"TIPO\"\n"
                    + "FROM bancoloja.\"MOV_CAIXA\"\n"
                    + "WHERE DATE_PART('MONTH', \"DT_MVTO\") = DATE_PART('MONTH', CURRENT_DATE - 31)\n"
                    + "AND   DATE_PART('YEAR', \"DT_MVTO\") = (DATE_PART('YEAR', CURRENT_DATE) - 1)\n"
                    + "ORDER BY \"CD_MVTO\"");
        } else {
            conn.executeSQL("SELECT \"CD_MVTO\",\n"
                    + "       \"DS_MVTO\",\n"
                    + "       TO_CHAR(\"DT_MVTO\", 'DD/MM/YYYY ÀS HH24:MI:SS'),\n"
                    + "       \"VL_ANTES\",\n"
                    + "       \"VL_ATUAL\",\n"
                    + "       \"VL_MVTO\",\n"
                    + "       CASE WHEN \"TP_MVTO\" = 'E' THEN 'ENTRADA'\n"
                    + "       ELSE 'SAIDA' END AS \"TIPO\"\n"
                    + "FROM bancoloja.\"MOV_CAIXA\"\n"
                    + "WHERE DATE_PART('MONTH', \"DT_MVTO\") = (DATE_PART('MONTH', CURRENT_DATE) - 1)\n"
                    + "AND   DATE_PART('YEAR', \"DT_MVTO\") = DATE_PART('YEAR', CURRENT_DATE)\n"
                    + "ORDER BY \"CD_MVTO\"");
        }
        return conn.resultset;
    }

    public ResultSet mvtocaixaentradasdia() {
        conn.executeSQL("SELECT \"CD_MVTO\",\n"
                + "       \"DS_MVTO\",\n"
                + "       TO_CHAR(\"DT_MVTO\", 'DD/MM/YYYY ÀS HH24:MI:SS'),\n"
                + "       \"VL_ANTES\",\n"
                + "       \"VL_ATUAL\",\n"
                + "       \"VL_MVTO\",\n"
                + "       CASE WHEN \"TP_MVTO\" = 'E' THEN 'ENTRADA'\n"
                + "       ELSE 'SAIDA' END AS \"TIPO\"\n"
                + "       FROM bancoloja.\"MOV_CAIXA\"\n"
                + "       WHERE DATE_PART('DAY', \"DT_MVTO\") = DATE_PART('DAY', CURRENT_DATE)\n"
                + "       AND   DATE_PART('MONTH', \"DT_MVTO\") = DATE_PART('MONTH', CURRENT_DATE)\n"
                + "       AND \"TP_MVTO\" = 'E'\n"
                + "       ORDER BY \"CD_MVTO\"");
        return conn.resultset;
    }

    public ResultSet mvtocaixasaidasdia() {
        conn.executeSQL("SELECT \"CD_MVTO\",\n"
                + "       \"DS_MVTO\",\n"
                + "       TO_CHAR(\"DT_MVTO\", 'DD/MM/YYYY ÀS HH24:MI:SS'),\n"
                + "       \"VL_ANTES\",\n"
                + "       \"VL_ATUAL\",\n"
                + "       \"VL_MVTO\",\n"
                + "       CASE WHEN \"TP_MVTO\" = 'E' THEN 'ENTRADA'\n"
                + "       ELSE 'SAIDA' END AS \"TIPO\"\n"
                + "       FROM bancoloja.\"MOV_CAIXA\"\n"
                + "       WHERE DATE_PART('DAY', \"DT_MVTO\") = DATE_PART('DAY', CURRENT_DATE)\n"
                + "       AND   DATE_PART('MONTH', \"DT_MVTO\") = DATE_PART('MONTH', CURRENT_DATE)\n"
                + "       AND \"TP_MVTO\" = 'S'\n"
                + "       ORDER BY \"CD_MVTO\"");
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
