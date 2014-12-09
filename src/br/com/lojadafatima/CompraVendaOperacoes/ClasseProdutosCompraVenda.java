package br.com.lojadafatima.CompraVendaOperacoes;

import br.com.lojadafatima.ClassesFerramentas.ClasseDatas;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import br.com.lojadafatima.Produto.ClasseFornecedoresProduto;
import br.com.lojadafatima.Produto.ClasseMvtoEstoque;
import br.com.lojadafatima.Produto.ClasseProduto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class ClasseProdutosCompraVenda {

    ConexaoPostgre conn = new ConexaoPostgre();
    private ClasseCompraVenda compravenda = new ClasseCompraVenda();
    private ClasseFornecedoresProduto forneproduto = new ClasseFornecedoresProduto();
    private float quantidade;
    private float valorunit;
    private float valorprodut;

    public void incluirprodutocompravenda() {
        conn.executeSQL("INSERT INTO bancoloja.\"PRODUTOS_COMPRA_VENDA\"(\n"
                + "            \"CD_COMPRA_VENDA\", \"CD_OPERACAO\", \"CD_PRODUTO\", \"QT_PRODUTO\", \"VL_PRODUTO_UNITARIO\", \"VL_PRODUTO\")\n"
                + "VALUES (" + getCompravenda().getCodigo() + ", " + getCompravenda().getOperacao().getCodigo() + ", " + getForneproduto().getProduto().getCodigo() + ", " + getQuantidade() + ", " + getValorunit() + ", " + getValorprodut() + ")");
    }

    public ResultSet produtoscompravenda() {
        conn.executeSQL("SELECT \"PCV\".\"CD_PRODUTO\", \"P\".\"DS_PRODUTO\", \"PCV\".\"QT_PRODUTO\", \"PCV\".\"VL_PRODUTO_UNITARIO\", \"PCV\".\"VL_PRODUTO\"\n"
                + "FROM bancoloja.\"PRODUTOS_COMPRA_VENDA\" \"PCV\"\n"
                + "JOIN bancoloja.\"CAD_PRODUTO\" \"P\"\n"
                + "ON \"P\".\"CD_PRODUTO\" = \"PCV\".\"CD_PRODUTO\"\n"
                + "WHERE \"PCV\".\"CD_COMPRA_VENDA\" = " + getCompravenda().getCodigo() + " AND \"PCV\".\"CD_OPERACAO\" = " + getCompravenda().getOperacao().getCodigo());
        return conn.resultset;
    }

    public void reverterestoqueprodutos() {
        ResultSet rs = produtoscompravenda();
        ClasseMvtoEstoque est = new ClasseMvtoEstoque();
        if(getCompravenda().getOperacao().getTpestoque().equals("E")){
            est.setTpmvto("S");
        }else if(getCompravenda().getOperacao().getTpestoque().equals("S")){
            est.setTpmvto("E");
        }
        est.setCompravenda(getCompravenda());
        ClasseDatas datas = new ClasseDatas();
        est.setDtmvto(datas.retornadataehora());
        try {
            while(rs.next()){
                est.setQtmvto(rs.getFloat(3));
                est.getProduto().setCodigo(rs.getInt(1));
                est.incluirmvto();
            }
        } catch (SQLException ex) {
            
        }
    }

    public boolean houveretiradadosprodutosenvolvidos() {
        conn.executeSQL("SELECT \"CV\".\"CD_COMPRA_VENDA\"\n"
                + "FROM bancoloja.\"COMPRA_VENDA\" \"CV\"\n"
                + "JOIN bancoloja.\"PRODUTOS_COMPRA_VENDA\" \"PCV\"\n"
                + "ON \"CV\".\"CD_COMPRA_VENDA\" = \"PCV\".\"CD_COMPRA_VENDA\" AND \"CV\".\"CD_OPERACAO\" = \"PCV\".\"CD_OPERACAO\"\n"
                + "WHERE \"CV\".\"CD_OPERACAO\" IN (SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\" WHERE \"TP_ESTOQUE\" = 'S') AND\n"
                + "      \"PCV\".\"CD_PRODUTO\" IN (SELECT \"CD_PRODUTO\" FROM bancoloja.\"PRODUTOS_COMPRA_VENDA\" WHERE \"CD_COMPRA_VENDA\" = " + getCompravenda().getCodigo() + " AND \"CD_OPERACAO\" = " + getCompravenda().getOperacao().getCodigo() + ") AND\n"
                + "      \"CV\".\"DT_COMPRA_VENDA\" > (SELECT \"DT_COMPRA_VENDA\" FROM bancoloja.\"COMPRA_VENDA\" WHERE \"CD_COMPRA_VENDA\" = " + getCompravenda().getCodigo() + " AND \"CD_OPERACAO\" = " + getCompravenda().getOperacao().getCodigo() + ") AND\n"
                + "      \"CV\".\"DS_COMPRA_VENDA\" NOT LIKE '% - CANCELADO DIA %'");
        try {
            conn.resultset.first();
            conn.resultset.getString(1);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public ClasseCompraVenda getCompravenda() {
        return compravenda;
    }

    public void setCompravenda(ClasseCompraVenda compravenda) {
        this.compravenda = compravenda;
    }

    public ClasseFornecedoresProduto getForneproduto() {
        return forneproduto;
    }

    public void setForneproduto(ClasseFornecedoresProduto fornecproduto) {
        this.forneproduto = fornecproduto;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorunit() {
        return valorunit;
    }

    public void setValorunit(float valorunit) {
        this.valorunit = valorunit;
    }

    public float getValorprodut() {
        return valorprodut;
    }

    public void setValorprodut(float valorprodut) {
        this.valorprodut = valorprodut;
    }

}
