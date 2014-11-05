package br.com.lojadafatima.Produto;

import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import br.com.lojadafatima.Pessoa.ClasseFornecedor;
import java.sql.ResultSet;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClasseFornecedoresProduto {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private ClasseFornecedor fornecedor = new ClasseFornecedor();
    private ClasseProduto produto = new ClasseProduto();
    
    public void incluirfornecedor(){
        conn.executeSQL("INSERT INTO bancoloja.\"CAD_FORNECEDORES_PRODUTO\"(\n" +
                        "\"CD_FORNECEDOR\", \"CD_PRODUTO\")\n" +
                        "VALUES ("+getFornecedor().getCodigo()+", "+getProduto().getCodigo()+")");
    }
    
    public void excluirfornecedores(){
        conn.executeSQL("DELETE FROM bancoloja.\"CAD_FORNECEDORES_PRODUTO\"\n" +
                        "WHERE \"CD_PRODUTO\" = "+getProduto().getCodigo());
    }
    
    public ResultSet retornafornecedoresproduto(){
        conn.executeSQL("SELECT \"CD_FORNECEDOR\"\n" +
                        "FROM bancoloja.\"CAD_FORNECEDORES_PRODUTO\"\n" +
                        "WHERE \"CD_PRODUTO\" = "+getProduto().getCodigo()+"");
        return conn.resultset;
    }

    public ClasseFornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(ClasseFornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public ClasseProduto getProduto() {
        return produto;
    }

    public void setProduto(ClasseProduto produto) {
        this.produto = produto;
    }

}
