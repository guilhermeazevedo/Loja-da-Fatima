package br.com.lojadafatima.CompraVendaOperacoes;

import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import br.com.lojadafatima.Produto.ClasseFornecedoresProduto;
import br.com.lojadafatima.Produto.ClasseProduto;

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
    
    public void incluirprodutocompravenda(){
        conn.executeSQL("INSERT INTO bancoloja.\"PRODUTOS_COMPRA_VENDA\"(\n" +
                        "            \"CD_COMPRA_VENDA\", \"CD_OPERACAO\", \"CD_PRODUTO\", \"QT_PRODUTO\", \"VL_PRODUTO_UNITARIO\", \"VL_PRODUTO\")\n" +
                        "VALUES ("+getCompravenda().getCodigo()+", "+getCompravenda().getOperacao().getCodigo()+", "+getForneproduto().getProduto().getCodigo()+", "+getQuantidade()+", "+getValorunit()+", "+getValorprodut()+")");
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
