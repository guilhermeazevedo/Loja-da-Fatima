package br.com.lojadafatima.Financeiro;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.CompraVendaOperacoes.ClasseCompraVenda;
import br.com.lojadafatima.CompraVendaOperacoes.ClasseOperacoes;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClasseContasPagarReceber {

    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private ClasseCompraVenda compravenda = new ClasseCompraVenda();
    private String descricao;
    private ClasseOperacoes operacao = new ClasseOperacoes();
    private ClasseCondicaoPagamento condicao = new ClasseCondicaoPagamento();
    private ClasseMulta multa = new ClasseMulta();
    private float total;
    private String dtconta;
    private String situacao;

    public void incluir() {
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CONTAS_PAGAR_RECEBER", "CD_CONTA", "CD_OPERACAO", getOperacao().getCodigo()));
        getMulta().getultimamulta();
        if (getCompravenda().getCodigo() == 0) {
            conn.executeSQL("INSERT INTO bancoloja.\"CONTAS_PAGAR_RECEBER\"(\n"
                    + "            \"CD_CONTA\", \"CD_OPERACAO\", \n"
                    + "            \"DS_CONTA\", \"CD_CONDICAO_PGTO\", \"CD_MULTA\", \"VL_TOTAL\", \"DT_CONTA\", \"SITUACAO\")\n"
                    + "VALUES (" + getCodigo() + ", " + getOperacao().getCodigo() + ", \n"
                    + "        '" + getDescricao() + "', " + getCondicao().getCodigo() + ", " + getMulta().getCodigo() + ", "+getTotal()+", '"+getDtconta()+"', 'A')");
        } else {
            conn.executeSQL("INSERT INTO bancoloja.\"CONTAS_PAGAR_RECEBER\"(\n"
                    + "            \"CD_CONTA\", \"CD_OPERACAO\", \"CD_COMPRA_VENDA\", \"CD_OPERACAO_COMPRA_VENDA\", \n"
                    + "            \"DS_CONTA\", \"CD_CONDICAO_PGTO\", \"CD_MULTA\", \"VL_TOTAL\", \"DT_CONTA\", \"SITUACAO\")\n"
                    + "VALUES (" + getCodigo() + ", " + getOperacao().getCodigo() + ", " + getCompravenda().getCodigo() + ", " + getCompravenda().getOperacao().getCodigo() + ", \n"
                    + "        '" + getDescricao() + "', " + getCondicao().getCodigo() + ", " + getMulta().getCodigo() + ", "+getTotal()+", '"+getDtconta()+"', 'A')");
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ClasseCompraVenda getCompravenda() {
        return compravenda;
    }

    public void setCompravenda(ClasseCompraVenda compravenda) {
        this.compravenda = compravenda;
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

    public ClasseCondicaoPagamento getCondicao() {
        return condicao;
    }

    public void setCondicao(ClasseCondicaoPagamento condicao) {
        this.condicao = condicao;
    }

    public ClasseMulta getMulta() {
        return multa;
    }

    public void setMulta(ClasseMulta multa) {
        this.multa = multa;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getDtconta() {
        return dtconta;
    }

    public void setDtconta(String dtconta) {
        this.dtconta = dtconta;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

}
