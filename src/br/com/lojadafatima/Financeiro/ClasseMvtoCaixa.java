/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.Financeiro;

import br.com.lojadafatima.ClassesFerramentas.ClasseDatas;
import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class ClasseMvtoCaixa {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private String tpmvto;
    private ClasseParcelas parcela = new ClasseParcelas();
    private String datamvto;
    private float vlantes;
    private float vlmvto;
    private float vlatual;
    
    public void incluir(){
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("MOV_CAIXA", "CD_MVTO"));
        ClasseDatas datas = new ClasseDatas();
        setDatamvto(datas.retornadataehora());
        setVlantes(retornacaixaatual());
        if(getTpmvto().equals("E")){
            setVlatual(getVlantes() + getVlmvto());
        }else{
            setVlatual(getVlantes() - getVlmvto());
        }
        conn.executeSQL("INSERT INTO bancoloja.\"MOV_CAIXA\"(\n" +
                        "            \"CD_MVTO\", \"TP_MVTO\", \"CD_PARCELA\", \"CD_CONTA\", \"CD_OPERACAO\", \n" +
                        "            \"DT_MVTO\", \"VL_ANTES\", \"VL_MVTO\", \"VL_ATUAL\")\n" +
                        "    VALUES ("+getCodigo()+", '"+getTpmvto()+"', "+getParcela().getCodigo()+", "+getParcela().getConta().getCodigo()+", "+getParcela().getConta().getOperacao().getCodigo()+", \n" +
                        "            '"+getDatamvto()+"', "+getVlantes()+", "+getVlmvto()+", "+getVlatual()+");");
    }
    
    public float retornacaixaatual(){
        conn.executeSQL("SELECT \"VL_ATUAL\" FROM bancoloja.\"MOV_CAIXA\"\n" +
                        "WHERE \"CD_MVTO\" = (SELECT MAX(\"CD_MVTO\") FROM bancoloja.\"MOV_CAIXA\")");
        try {
            conn.resultset.first();
            return conn.resultset.getFloat(1);
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
}
