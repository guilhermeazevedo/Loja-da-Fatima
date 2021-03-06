package br.com.lojadafatima.CompraVendaOperacoes;

import br.com.lojadafatima.ClassesFerramentas.ClasseDatas;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import br.com.lojadafatima.Produto.ClasseFornecedoresProduto;
import br.com.lojadafatima.Produto.ClasseMvtoEstoque;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClasseProdutosCompraVenda {

    ConexaoPostgre conn = new ConexaoPostgre();
    private ClasseCompraVenda compravenda = new ClasseCompraVenda();
    private ClasseFornecedoresProduto forneproduto = new ClasseFornecedoresProduto();
    private float quantidade;
    private float valorunit;
    private float valorprodut;
    private String promocao;
    private float desconto;

    public void incluirprodutocompravenda() {
        conn.executeSQL("INSERT INTO bancoloja.\"PRODUTOS_COMPRA_VENDA\"(\n"
                + "            \"CD_COMPRA_VENDA\", \"CD_OPERACAO\", \"CD_PRODUTO\", \"QT_PRODUTO\", \"VL_PRODUTO_UNITARIO\", \"VL_PRODUTO\", \"IN_PROMOCAO\", \"PE_DESCONTO\")\n"
                + "VALUES (" + getCompravenda().getCodigo() + ", " + getCompravenda().getOperacao().getCodigo() + ", " + getForneproduto().getProduto().getCodigo() + ", " + getQuantidade() + ", " + getValorunit() + ", " + getValorprodut() + ", '"+getPromocao()+"', "+getDesconto()+")");
    }

    public ResultSet produtoscompravenda() {
        conn.executeSQL("SELECT \"PCV\".\"CD_PRODUTO\", \"P\".\"DS_PRODUTO\", \"PCV\".\"QT_PRODUTO\", \"PCV\".\"VL_PRODUTO_UNITARIO\", TO_CHAR(\"PE_DESCONTO\", '999990D99%'), \"PCV\".\"VL_PRODUTO\", CASE WHEN \"PCV\".\"IN_PROMOCAO\" = 'S' THEN 'SIM' ELSE 'NÃO' END\n"
                + "FROM bancoloja.\"PRODUTOS_COMPRA_VENDA\" \"PCV\"\n"
                + "JOIN bancoloja.\"CAD_PRODUTO\" \"P\"\n"
                + "ON \"P\".\"CD_PRODUTO\" = \"PCV\".\"CD_PRODUTO\"\n"
                + "WHERE \"PCV\".\"CD_COMPRA_VENDA\" = " + getCompravenda().getCodigo() + " AND \"PCV\".\"CD_OPERACAO\" = " + getCompravenda().getOperacao().getCodigo());
        return conn.resultset;
    }
    
    public ResultSet produtoscompravendaest() {
        conn.executeSQL("SELECT \"PCV\".\"CD_PRODUTO\", \"P\".\"DS_PRODUTO\", \"PCV\".\"QT_PRODUTO\"\n"
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

    public boolean estoquedisponiveldetodososprodutos() {
        conn.executeSQL("SELECT \"CD_PRODUTO\", \"QT_PRODUTO\" FROM bancoloja.\"PRODUTOS_COMPRA_VENDA\"\n" +
                        "WHERE \"CD_COMPRA_VENDA\" = "+getCompravenda().getCodigo()+" AND \"CD_OPERACAO\" = "+getCompravenda().getOperacao().getCodigo());
        ClasseMvtoEstoque estoque = new ClasseMvtoEstoque();
        ResultSet rs = conn.resultset;
        try {
            while(rs.next()){
                estoque.getProduto().setCodigo(rs.getInt(1));
                if(estoque.retornaestoqueatual() < rs.getFloat(2)){
                    return false;
                }
            }
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

    public String getPromocao() {
        return promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

}
