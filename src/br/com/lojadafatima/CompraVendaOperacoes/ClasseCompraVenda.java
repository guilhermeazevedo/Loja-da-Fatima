package br.com.lojadafatima.CompraVendaOperacoes;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import br.com.lojadafatima.Financeiro.ClasseCondicaoPagamento;
import br.com.lojadafatima.Financeiro.ClasseMulta;
import br.com.lojadafatima.Pessoa.ClasseFuncionario;

/**
 *
 * @author hp
 */
public class ClasseCompraVenda {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private String descricao;
    private ClasseOperacoes operacao = new ClasseOperacoes();
    private int codigopessoa;
    private ClasseFuncionario funcionario = new ClasseFuncionario();
    private ClasseCondicaoPagamento condicao = new ClasseCondicaoPagamento();
    private String data;
    
    public void incluir(){
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("COMPRA_VENDA", "CD_COMPRA_VENDA", "CD_OPERACAO", getOperacao().getCodigo()));
        conn.incluirSQL("INSERT INTO bancoloja.\"COMPRA_VENDA\"(\n" +
                        "            \"CD_COMPRA_VENDA\", \"CD_OPERACAO\", \"DS_COMPRA_VENDA\", \"CD_PESSOA\", \n" +
                        "            \"CD_FUNCIONARIO\", \"CD_CONDICAO_PGTO\", \"DT_COMPRA_VENDA\")\n" +
                        " VALUES ("+getCodigo()+", "+getOperacao().getCodigo()+", '"+getDescricao().toUpperCase()+"', "+getCodigopessoa()+", \n" +
                        "         "+getFuncionario().getCodigo()+", "+getCondicao().getCodigo()+", '"+getData()+"')");
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ClasseOperacoes getOperacao() {
        return operacao;
    }

    public void setOperacao(ClasseOperacoes operacao) {
        this.operacao = operacao;
    }

    public int getCodigopessoa() {
        return codigopessoa;
    }

    public void setCodigopessoa(int codigopessoa) {
        this.codigopessoa = codigopessoa;
    }

    public ClasseFuncionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(ClasseFuncionario funcionario) {
        this.funcionario = funcionario;
    }

    public ClasseCondicaoPagamento getCondicao() {
        return condicao;
    }

    public void setCondicao(ClasseCondicaoPagamento condicao) {
        this.condicao = condicao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
