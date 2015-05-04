/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.Produto;

import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClasseEspecificacaoProduto {
    
    private ClasseTipoProduto tipoproduto = new ClasseTipoProduto();
    private ClasseProduto produto = new ClasseProduto();
    ConexaoPostgre conn = new ConexaoPostgre();
    
    public void incluirespecific(){
        if(getTipoproduto().getTabela().getCodigo() != 0 && getTipoproduto().getTabela().getValor().getCodigo() != 0){
            conn.executeSQL("INSERT INTO bancoloja.\"CAD_CARACTERISTICAS_PRODUTO\"(\n" +
                            "\"CD_PRODUTO\", \"CD_TIPO_PRODUTO\", \"CD_TABELA\", \"CD_VALOR\")\n" +
                            "VALUES ("+getProduto().getCodigo()+", "+getTipoproduto().getCodigo()+", "+getTipoproduto().getTabela().getCodigo()+", "+getTipoproduto().getTabela().getValor().getCodigo()+")");
        } else {
            conn.executeSQL("INSERT INTO bancoloja.\"CAD_CARACTERISTICAS_PRODUTO\"(\n" +
                            "\"CD_PRODUTO\", \"CD_TIPO_PRODUTO\", \"CD_TABELA\", \"CD_VALOR\")\n" +
                            "VALUES ("+getProduto().getCodigo()+", "+getTipoproduto().getCodigo()+", NULL, NULL)");
        }
    }
    
    public void alterarespecific(){
        conn.executeSQL("UPDATE bancoloja.\"CAD_CARACTERISTICAS_PRODUTO\"\n" +
                        "SET \"CD_VALOR\" = "+getTipoproduto().getTabela().getValor().getCodigo()+"\n" +
                        "WHERE \"CD_PRODUTO\"="+getProduto().getCodigo()+" AND \"CD_TIPO_PRODUTO\"="+getTipoproduto().getCodigo()+" AND \"CD_TABELA\"="+getTipoproduto().getTabela().getCodigo()+"");
    }
    
    public ResultSet consultatipoproduto(){
        conn.executeSQL("SELECT \"P\".\"CD_PRODUTO\", \"P\".\"DS_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\", \"P\".\"QT_ESTOQUE_MIN\"\n" +
                        "FROM bancoloja.\"CAD_PRODUTO\" \"P\"\n" +
                        "JOIN bancoloja.\"CAD_CARACTERISTICAS_PRODUTO\" \"CP\" ON \"P\".\"CD_PRODUTO\" = \"CP\".\"CD_PRODUTO\"\n" +
                        "JOIN bancoloja.\"CAD_TIPO_PRODUTO\" \"TP\" ON \"CP\".\"CD_TIPO_PRODUTO\" = \"TP\".\"CD_TIPO_PRODUTO\"\n" +
                        "WHERE \"P\".\"SITUACAO\" = 'A' AND \"TP\".\"CD_TIPO_PRODUTO\" = "+getTipoproduto().getCodigo()+"\n" +
                        "GROUP BY \"P\".\"CD_PRODUTO\", \"TP\".\"DS_TIPO_PRODUTO\"\n" +
                        "ORDER BY \"P\".\"CD_PRODUTO\"");
        return conn.resultset;
    }
    
    public void retornaproduto(){
        getProduto().retornaproduto();
        conn.executeSQL("SELECT \"TP\".\"DS_TIPO_PRODUTO\"\n" +
                        "FROM bancoloja.\"CAD_TIPO_PRODUTO\" \"TP\"\n" +
                        "JOIN bancoloja.\"CAD_CARACTERISTICAS_PRODUTO\" \"CP\" ON \"CP\".\"CD_TIPO_PRODUTO\" = \"TP\".\"CD_TIPO_PRODUTO\"\n" +
                        "WHERE \"CP\".\"CD_PRODUTO\" = "+getProduto().getCodigo()+"");
        try{
            conn.resultset.first();
            getTipoproduto().setTipoproduto(conn.resultset.getString(1));
        }catch(SQLException ex){
            
        }
    }
    
    public ResultSet retornacaracproduto(){
        conn.executeSQL("SELECT \"CD_TABELA\", \"CD_VALOR\"\n" +
                        "FROM bancoloja.\"CAD_CARACTERISTICAS_PRODUTO\"\n" +
                        "WHERE \"CD_PRODUTO\" = "+getProduto().getCodigo()+"");
        return conn.resultset;
    }

    public ClasseTipoProduto getTipoproduto() {
        return tipoproduto;
    }

    public void setTipoproduto(ClasseTipoProduto tipoproduto) {
        this.tipoproduto = tipoproduto;
    }

    public ClasseProduto getProduto() {
        return produto;
    }

    public void setProduto(ClasseProduto produto) {
        this.produto = produto;
    }

}
