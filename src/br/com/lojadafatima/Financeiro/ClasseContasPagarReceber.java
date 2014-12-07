package br.com.lojadafatima.Financeiro;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.CompraVendaOperacoes.ClasseCompraVenda;
import br.com.lojadafatima.CompraVendaOperacoes.ClasseOperacoes;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme Azevedo
 */
public class ClasseContasPagarReceber {

    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private ClasseCompraVenda compravenda = new ClasseCompraVenda();
    private String descricao;
    private int codigopessoa;
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
                    + "            \"CD_CONTA\", \"CD_OPERACAO\", \"CD_PESSOA\",\n"
                    + "            \"DS_CONTA\", \"CD_CONDICAO_PGTO\", \"CD_MULTA\", \"VL_TOTAL\", \"DT_CONTA\", \"SITUACAO\")\n"
                    + "VALUES (" + getCodigo() + ", " + getOperacao().getCodigo() + ", " + getCodigopessoa() + ",\n"
                    + "        '" + getDescricao() + "', " + getCondicao().getCodigo() + ", " + getMulta().getCodigo() + ", " + getTotal() + ", '" + getDtconta() + "', 'A')");
        } else {
            conn.executeSQL("INSERT INTO bancoloja.\"CONTAS_PAGAR_RECEBER\"(\n"
                    + "            \"CD_CONTA\", \"CD_OPERACAO\", \"CD_COMPRA_VENDA\", \"CD_OPERACAO_COMPRA_VENDA\", \"CD_PESSOA\",\n"
                    + "            \"DS_CONTA\", \"CD_CONDICAO_PGTO\", \"CD_MULTA\", \"VL_TOTAL\", \"DT_CONTA\", \"SITUACAO\")\n"
                    + "VALUES (" + getCodigo() + ", " + getOperacao().getCodigo() + ", " + getCompravenda().getCodigo() + ", " + getCompravenda().getOperacao().getCodigo() + ", " + getCodigopessoa() + ",\n"
                    + "        '" + getDescricao() + "', " + getCondicao().getCodigo() + ", " + getMulta().getCodigo() + ", " + getTotal() + ", '" + getDtconta() + "', 'A')");
        }
    }

    public ResultSet contasreceberabertasevencidas() {
        conn.executeSQL("SELECT CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "       THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\")\n"
                + "       ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"NOME\",\n"
                + "       CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "       THEN (SELECT \"NR_CPF\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\"= \"P\".\"CD_PESSOA\")\n"
                + "       ELSE (SELECT \"NR_CNPJ\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"CPFCNPJ\"\n"
                + "       FROM bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "       WHERE \"P\".\"CD_PESSOA\" IN ((SELECT \"CD_PESSOA\" FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "                                  WHERE \"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                                           WHERE \"TP_FINANCEIRO\" = 'E'))\n"
                + "                                  AND \"SITUACAO\" = 'V'))\n"
                + "       OR    \"P\".\"CD_PESSOA\" IN ((SELECT \"CD_PESSOA\" FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "                                  WHERE \"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                                           WHERE \"TP_FINANCEIRO\" = 'E'))\n"
                + "                                  AND \"SITUACAO\" = 'A'))\n"
                + "       ORDER BY \"NOME\"");
        return conn.resultset;
    }

    public ResultSet contasreceberaberto() {
        conn.executeSQL("SELECT CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "       THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\")\n"
                + "       ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"NOME\",\n"
                + "       CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "       THEN (SELECT \"NR_CPF\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\"= \"P\".\"CD_PESSOA\")\n"
                + "       ELSE (SELECT \"NR_CNPJ\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"CPFCNPJ\"\n"
                + "       FROM bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "       WHERE \"P\".\"CD_PESSOA\" IN ((SELECT \"CD_PESSOA\" FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "                                  WHERE \"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                                           WHERE \"TP_FINANCEIRO\" = 'E'))\n"
                + "                                  AND \"SITUACAO\" = 'A'))\n"
                + "       ORDER BY \"NOME\"");
        return conn.resultset;
    }

    public ResultSet contasrecebervencidas() {
        conn.executeSQL("SELECT CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "       THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"P\".\"CD_PESSOA\")\n"
                + "       ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"NOME\",\n"
                + "       CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "       THEN (SELECT \"NR_CPF\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\"= \"P\".\"CD_PESSOA\")\n"
                + "       ELSE (SELECT \"NR_CNPJ\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"P\".\"CD_PESSOA\") END AS \"CPFCNPJ\"\n"
                + "       FROM bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "       WHERE \"P\".\"CD_PESSOA\" IN ((SELECT \"CD_PESSOA\" FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "                                  WHERE \"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                                           WHERE \"TP_FINANCEIRO\" = 'E'))\n"
                + "                                  AND \"SITUACAO\" = 'V'))\n"
                + "       ORDER BY \"NOME\"");
        return conn.resultset;
    }

    public ResultSet contasreceberclientesaberto() {
        conn.executeSQL("SELECT CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "                               THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"C\".\"CD_PESSOA\")\n"
                + "                               ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\") END AS \"NOME\",\n"
                + "                               CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "                               THEN (SELECT \"NR_CPF\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\"= \"C\".\"CD_PESSOA\")\n"
                + "                               ELSE (SELECT \"NR_CNPJ\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\") END AS \"CPFCNPJ\"\n"
                + "                               FROM bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "                               JOIN bancoloja.\"CAD_CLIENTE\" \"C\" ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n"
                + "                               WHERE \"C\".\"CD_PESSOA\" IN ((SELECT \"CD_PESSOA\" FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "                                                          WHERE \"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                                                                   WHERE \"TP_FINANCEIRO\" = 'E'))\n"
                + "                                                          AND \"SITUACAO\" = 'A'))\n"
                + "                               ORDER BY \"NOME\"");
        return conn.resultset;
    }

    public ResultSet contasreceberclientesvencido() {
        conn.executeSQL("SELECT CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "                               THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"C\".\"CD_PESSOA\")\n"
                + "                               ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\") END AS \"NOME\",\n"
                + "                               CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "                               THEN (SELECT \"NR_CPF\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\"= \"C\".\"CD_PESSOA\")\n"
                + "                               ELSE (SELECT \"NR_CNPJ\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\") END AS \"CPFCNPJ\"\n"
                + "                               FROM bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "                               JOIN bancoloja.\"CAD_CLIENTE\" \"C\" ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n"
                + "                               WHERE \"C\".\"CD_PESSOA\" IN ((SELECT \"CD_PESSOA\" FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "                                                          WHERE \"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                                                                   WHERE \"TP_FINANCEIRO\" = 'E'))\n"
                + "                                                          AND \"SITUACAO\" = 'V'))\n"
                + "                               ORDER BY \"NOME\"");
        return conn.resultset;
    }

    public ResultSet listarclientes() {
        conn.executeSQL("SELECT CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "       THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"C\".\"CD_PESSOA\")\n"
                + "       ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\") END AS \"NOME\",\n"
                + "       CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "       THEN (SELECT \"NR_CPF\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\"= \"C\".\"CD_PESSOA\")\n"
                + "       ELSE (SELECT \"NR_CNPJ\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\") END AS \"CPFCNPJ\"\n"
                + "       FROM bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "       JOIN bancoloja.\"CAD_CLIENTE\" \"C\" ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n"
                + "       WHERE \"C\".\"SITUACAO\" = 'A'\n"
                + "       ORDER BY \"NOME\"");
        return conn.resultset;
    }

    public ResultSet contaspessoa() {
        conn.executeSQL("SELECT \"C\".\"CD_CONTA\" AS \"CONTA\",\n"
                + "                               (SELECT \"DS_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                WHERE \"CD_OPERACAO\" = \"C\".\"CD_OPERACAO\"),\n"
                + "                               CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "                               THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"C\".\"CD_PESSOA\")\n"
                + "                               ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\") END AS \"NOME\",\n"
                + "                               (SELECT \"DS_CONDICAO_PGTO\" FROM bancoloja.\"CAD_CONDICAO_PGTO\"\n"
                + "                               WHERE \"CD_CONDICAO_PGTO\" = \"C\".\"CD_CONDICAO_PGTO\") AS \"CONDICAO\",\n"
                + "                               TO_CHAR(\"C\".\"DT_CONTA\", 'DD/MM/YYYY'),\n"
                + "                               \"C\".\"VL_TOTAL\",\n"
                + "                               CASE WHEN \"C\".\"SITUACAO\" = 'A'\n"
                + "                               THEN 'ABERTA'\n"
                + "                               ELSE CASE WHEN \"C\".\"SITUACAO\" = 'V'\n"
                + "                               THEN 'VENCIDA'\n"
                + "                               ELSE 'PAGA' END END AS \"SITUACAO\"\n"
                + "                               FROM bancoloja.\"CONTAS_PAGAR_RECEBER\" \"C\"\n"
                + "                               JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "                               ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n"
                + "                               WHERE \"C\".\"CD_PESSOA\" = " + getCodigopessoa() + "\n"
                + "                               AND \"C\".\"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                                          WHERE \"TP_FINANCEIRO\" = 'E'))\n"
                + "                               ORDER BY \"CONTA\" DESC");
        return conn.resultset;
    }

    public ResultSet contaspagarabertasevencidas() {
        conn.executeSQL("SELECT \"C\".\"CD_CONTA\" AS \"CONTA\",\n"
                + "                       (SELECT \"DS_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                        WHERE \"CD_OPERACAO\" = \"C\".\"CD_OPERACAO\"),\n"
                + "                       CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "                       THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"C\".\"CD_PESSOA\")\n"
                + "                       ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\") END AS \"NOME\",\n"
                + "                       (SELECT \"DS_CONDICAO_PGTO\" FROM bancoloja.\"CAD_CONDICAO_PGTO\"\n"
                + "                        WHERE \"CD_CONDICAO_PGTO\" = \"C\".\"CD_CONDICAO_PGTO\") AS \"CONDICAO\",\n"
                + "                       TO_CHAR(\"C\".\"DT_CONTA\", 'DD/MM/YYYY'),\n"
                + "                       \"C\".\"VL_TOTAL\",\n"
                + "                       CASE WHEN \"C\".\"SITUACAO\" = 'A'\n"
                + "                       THEN 'ABERTA'\n"
                + "                       ELSE CASE WHEN \"C\".\"SITUACAO\" = 'V'\n"
                + "                       THEN 'VENCIDA'\n"
                + "                       ELSE 'PAGA' END END AS \"SITUACAO\"\n"
                + "                       FROM bancoloja.\"CONTAS_PAGAR_RECEBER\" \"C\"\n"
                + "                       JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "                       ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n"
                + "                       WHERE (\"C\".\"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                                    WHERE \"TP_FINANCEIRO\" = 'S'))\n"
                + "                              AND \"C\".\"SITUACAO\" = 'V')\n"
                + "                       OR (\"C\".\"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                                    WHERE \"TP_FINANCEIRO\" = 'S'))\n"
                + "                              AND \"C\".\"SITUACAO\" = 'A')\n"
                + "                       ORDER BY \"CONTA\" DESC");
        return conn.resultset;
    }

    public ResultSet contaspagaraberta() {
        conn.executeSQL("SELECT \"C\".\"CD_CONTA\" AS \"CONTA\",\n"
                + "       (SELECT \"DS_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "        WHERE \"CD_OPERACAO\" = \"C\".\"CD_OPERACAO\"),\n"
                + "       CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "       THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"C\".\"CD_PESSOA\")\n"
                + "       ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\") END AS \"NOME\",\n"
                + "       (SELECT \"DS_CONDICAO_PGTO\" FROM bancoloja.\"CAD_CONDICAO_PGTO\"\n"
                + "        WHERE \"CD_CONDICAO_PGTO\" = \"C\".\"CD_CONDICAO_PGTO\") AS \"CONDICAO\",\n"
                + "       TO_CHAR(\"C\".\"DT_CONTA\", 'DD/MM/YYYY'),\n"
                + "       \"C\".\"VL_TOTAL\",\n"
                + "       CASE WHEN \"C\".\"SITUACAO\" = 'A'\n"
                + "       THEN 'ABERTA'\n"
                + "       ELSE CASE WHEN \"C\".\"SITUACAO\" = 'V'\n"
                + "       THEN 'VENCIDA'\n"
                + "       ELSE 'PAGA' END END AS \"SITUACAO\"\n"
                + "       FROM bancoloja.\"CONTAS_PAGAR_RECEBER\" \"C\"\n"
                + "       JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "       ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n"
                + "       WHERE \"C\".\"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                    WHERE \"TP_FINANCEIRO\" = 'S'))\n"
                + "       AND \"C\".\"SITUACAO\" = 'A'\n"
                + "       ORDER BY \"CONTA\" DESC");
        return conn.resultset;
    }

    public ResultSet contaspagarvencidas() {
        conn.executeSQL("SELECT \"C\".\"CD_CONTA\" AS \"CONTA\",\n"
                + "       (SELECT \"DS_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "        WHERE \"CD_OPERACAO\" = \"C\".\"CD_OPERACAO\"),\n"
                + "       CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "       THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"C\".\"CD_PESSOA\")\n"
                + "       ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\") END AS \"NOME\",\n"
                + "       (SELECT \"DS_CONDICAO_PGTO\" FROM bancoloja.\"CAD_CONDICAO_PGTO\"\n"
                + "        WHERE \"CD_CONDICAO_PGTO\" = \"C\".\"CD_CONDICAO_PGTO\") AS \"CONDICAO\",\n"
                + "       TO_CHAR(\"C\".\"DT_CONTA\", 'DD/MM/YYYY'),\n"
                + "       \"C\".\"VL_TOTAL\",\n"
                + "       CASE WHEN \"C\".\"SITUACAO\" = 'A'\n"
                + "       THEN 'ABERTA'\n"
                + "       ELSE CASE WHEN \"C\".\"SITUACAO\" = 'V'\n"
                + "       THEN 'VENCIDA'\n"
                + "       ELSE 'PAGA' END END AS \"SITUACAO\"\n"
                + "       FROM bancoloja.\"CONTAS_PAGAR_RECEBER\" \"C\"\n"
                + "       JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "       ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n"
                + "       WHERE \"C\".\"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                    WHERE \"TP_FINANCEIRO\" = 'S'))\n"
                + "       AND \"C\".\"SITUACAO\" = 'V'\n"
                + "       ORDER BY \"CONTA\" DESC");
        return conn.resultset;
    }

    public ResultSet contaspagardomes() {
        conn.executeSQL("SELECT \"C\".\"CD_CONTA\" AS \"CONTA\",\n"
                + "       (SELECT \"DS_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "        WHERE \"CD_OPERACAO\" = \"C\".\"CD_OPERACAO\"),\n"
                + "       CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "       THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"C\".\"CD_PESSOA\")\n"
                + "       ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\") END AS \"NOME\",\n"
                + "       (SELECT \"DS_CONDICAO_PGTO\" FROM bancoloja.\"CAD_CONDICAO_PGTO\"\n"
                + "        WHERE \"CD_CONDICAO_PGTO\" = \"C\".\"CD_CONDICAO_PGTO\") AS \"CONDICAO\",\n"
                + "       TO_CHAR(\"C\".\"DT_CONTA\", 'DD/MM/YYYY'),\n"
                + "       \"C\".\"VL_TOTAL\",\n"
                + "       CASE WHEN \"C\".\"SITUACAO\" = 'A'\n"
                + "       THEN 'ABERTA'\n"
                + "       ELSE CASE WHEN \"C\".\"SITUACAO\" = 'V'\n"
                + "       THEN 'VENCIDA'\n"
                + "       ELSE 'PAGA' END END AS \"SITUACAO\"\n"
                + "       FROM bancoloja.\"CONTAS_PAGAR_RECEBER\" \"C\"\n"
                + "       JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "       ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n"
                + "       WHERE \"C\".\"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                    WHERE \"TP_FINANCEIRO\" = 'S'))\n"
                + "       AND DATE_PART('MONTH', \"C\".\"DT_CONTA\") = DATE_PART('MONTH', CURRENT_DATE)\n"
                + "       ORDER BY \"CONTA\" DESC");
        return conn.resultset;
    }

    public ResultSet contaspagardomesanterior() {
        conn.executeSQL("SELECT \"C\".\"CD_CONTA\" AS \"CONTA\",\n"
                + "       (SELECT \"DS_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "        WHERE \"CD_OPERACAO\" = \"C\".\"CD_OPERACAO\"),\n"
                + "       CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "       THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"C\".\"CD_PESSOA\")\n"
                + "       ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\") END AS \"NOME\",\n"
                + "       (SELECT \"DS_CONDICAO_PGTO\" FROM bancoloja.\"CAD_CONDICAO_PGTO\"\n"
                + "        WHERE \"CD_CONDICAO_PGTO\" = \"C\".\"CD_CONDICAO_PGTO\") AS \"CONDICAO\",\n"
                + "       TO_CHAR(\"C\".\"DT_CONTA\", 'DD/MM/YYYY'),\n"
                + "       \"C\".\"VL_TOTAL\",\n"
                + "       CASE WHEN \"C\".\"SITUACAO\" = 'A'\n"
                + "       THEN 'ABERTA'\n"
                + "       ELSE CASE WHEN \"C\".\"SITUACAO\" = 'V'\n"
                + "       THEN 'VENCIDA'\n"
                + "       ELSE 'PAGA' END END AS \"SITUACAO\"\n"
                + "       FROM bancoloja.\"CONTAS_PAGAR_RECEBER\" \"C\"\n"
                + "       JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "       ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n"
                + "       WHERE \"C\".\"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                    WHERE \"TP_FINANCEIRO\" = 'S'))\n"
                + "       AND DATE_PART('MONTH', \"C\".\"DT_CONTA\") = (DATE_PART('MONTH', CURRENT_DATE) - 1)\n"
                + "       ORDER BY \"CONTA\" DESC");
        return conn.resultset;
    }

    public ResultSet contaspagardoano() {
        conn.executeSQL("SELECT \"C\".\"CD_CONTA\" AS \"CONTA\",\n"
                + "       (SELECT \"DS_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "        WHERE \"CD_OPERACAO\" = \"C\".\"CD_OPERACAO\"),\n"
                + "       CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "       THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"C\".\"CD_PESSOA\")\n"
                + "       ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\") END AS \"NOME\",\n"
                + "       (SELECT \"DS_CONDICAO_PGTO\" FROM bancoloja.\"CAD_CONDICAO_PGTO\"\n"
                + "        WHERE \"CD_CONDICAO_PGTO\" = \"C\".\"CD_CONDICAO_PGTO\") AS \"CONDICAO\",\n"
                + "       TO_CHAR(\"C\".\"DT_CONTA\", 'DD/MM/YYYY'),\n"
                + "       \"C\".\"VL_TOTAL\",\n"
                + "       CASE WHEN \"C\".\"SITUACAO\" = 'A'\n"
                + "       THEN 'ABERTA'\n"
                + "       ELSE CASE WHEN \"C\".\"SITUACAO\" = 'V'\n"
                + "       THEN 'VENCIDA'\n"
                + "       ELSE 'PAGA' END END AS \"SITUACAO\"\n"
                + "       FROM bancoloja.\"CONTAS_PAGAR_RECEBER\" \"C\"\n"
                + "       JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "       ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n"
                + "       WHERE \"C\".\"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                    WHERE \"TP_FINANCEIRO\" = 'S'))\n"
                + "       AND DATE_PART('YEAR', \"C\".\"DT_CONTA\") = DATE_PART('YEAR', CURRENT_DATE)\n"
                + "       ORDER BY \"CONTA\" DESC");
        return conn.resultset;
    }

    public ResultSet todascontaspagar() {
        conn.executeSQL("SELECT \"C\".\"CD_CONTA\" AS \"CONTA\",\n"
                + "       (SELECT \"DS_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "        WHERE \"CD_OPERACAO\" = \"C\".\"CD_OPERACAO\"),\n"
                + "       CASE WHEN \"P\".\"TP_PESSOA\" = 'F'\n"
                + "       THEN (SELECT \"NM_PESSOA\" FROM bancoloja.\"CAD_PESSOA_FISICA\" WHERE \"CD_PESSOA_FIS\" = \"C\".\"CD_PESSOA\")\n"
                + "       ELSE (SELECT \"NM_FANTASIA\" FROM bancoloja.\"CAD_PESSOA_JURIDICA\" WHERE \"CD_PESSOA_JUR\" = \"C\".\"CD_PESSOA\") END AS \"NOME\",\n"
                + "       (SELECT \"DS_CONDICAO_PGTO\" FROM bancoloja.\"CAD_CONDICAO_PGTO\"\n"
                + "        WHERE \"CD_CONDICAO_PGTO\" = \"C\".\"CD_CONDICAO_PGTO\") AS \"CONDICAO\",\n"
                + "       TO_CHAR(\"C\".\"DT_CONTA\", 'DD/MM/YYYY'),\n"
                + "       \"C\".\"VL_TOTAL\",\n"
                + "       CASE WHEN \"C\".\"SITUACAO\" = 'A'\n"
                + "       THEN 'ABERTA'\n"
                + "       ELSE CASE WHEN \"C\".\"SITUACAO\" = 'V'\n"
                + "       THEN 'VENCIDA'\n"
                + "       ELSE 'PAGA' END END AS \"SITUACAO\"\n"
                + "       FROM bancoloja.\"CONTAS_PAGAR_RECEBER\" \"C\"\n"
                + "       JOIN bancoloja.\"CAD_PESSOA\" \"P\"\n"
                + "       ON \"C\".\"CD_PESSOA\" = \"P\".\"CD_PESSOA\"\n"
                + "       WHERE \"C\".\"CD_OPERACAO\" IN ((SELECT \"CD_OPERACAO\" FROM bancoloja.\"CAD_OPERACOES\"\n"
                + "                                    WHERE \"TP_FINANCEIRO\" = 'S'))\n"
                + "       ORDER BY \"CONTA\" DESC");
        return conn.resultset;
    }

    public void contapaga() {
        conn.executeSQL("UPDATE bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "   SET \"SITUACAO\" = 'P'\n"
                + " WHERE \"CD_CONTA\" = " + getCodigo() + " AND \"CD_OPERACAO\" = " + getOperacao().getCodigo());
    }

    public void contavencida() {
        conn.executeSQL("UPDATE bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "   SET \"SITUACAO\" = 'V'\n"
                + " WHERE \"CD_CONTA\" = " + getCodigo() + " AND \"CD_OPERACAO\" = " + getOperacao().getCodigo());
    }

    public void contaaberta() {
        conn.executeSQL("UPDATE bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "   SET \"SITUACAO\" = 'A'\n"
                + " WHERE \"CD_CONTA\" = " + getCodigo() + " AND \"CD_OPERACAO\" = " + getOperacao().getCodigo());
    }

    public String retornadescricaodaconta() {
        conn.executeSQL("SELECT \"DS_CONTA\" FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "WHERE \"CD_CONTA\" = " + getCodigo() + " AND \"CD_OPERACAO\" = " + getOperacao().getCodigo());
        try {
            conn.resultset.first();
            return conn.resultset.getString(1);
        } catch (SQLException ex) {
            return "";
        }
    }

    public ResultSet retornatodasascontasabertas() {
        conn.executeSQL("SELECT \"CD_CONTA\", \"CD_OPERACAO\"\n"
                + "FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "WHERE \"SITUACAO\" = 'A'");
        return conn.resultset;
    }

    public void buscamultaconta() {
        conn.executeSQL("SELECT \"CD_MULTA\"\n"
                + "FROM bancoloja.\"CONTAS_PAGAR_RECEBER\"\n"
                + "WHERE \"CD_CONTA\" = " + getCodigo() + " AND \"CD_OPERACAO\" = " + getOperacao().getCodigo());
        try {
            conn.resultset.first();
            getMulta().setCodigo(conn.resultset.getInt(1));
            getMulta().retornamultacodigo();
        } catch (SQLException ex) {
        }
    }

    public int retornanumerocontasreceberabertas() {
        ResultSet rs = contasreceberaberto();
        int cont = 0;
        try {
            while (rs.next()) {
                cont = cont + 1;
            }
            return cont;
        } catch (SQLException ex) {
            return 0;
        }
    }

    public int retornanumerocontasrecebervencidas() {
        ResultSet rs = contasrecebervencidas();
        int cont = 0;
        try {
            while (rs.next()) {
                cont = cont + 1;
            }
            return cont;
        } catch (SQLException ex) {
            return 0;
        }
    }

    public int retornanumerocontaspagarabertas() {
        ResultSet rs = contaspagaraberta();
        int cont = 0;
        try {
            while (rs.next()) {
                cont = cont + 1;
            }
            return cont;
        } catch (SQLException ex) {
            return 0;
        }
    }

    public int retornanumerocontaspagarvencidas() {
        ResultSet rs = contaspagarvencidas();
        int cont = 0;
        try {
            while (rs.next()) {
                cont = cont + 1;
            }
            return cont;
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

    public int getCodigopessoa() {
        return codigopessoa;
    }

    public void setCodigopessoa(int codigopessoa) {
        this.codigopessoa = codigopessoa;
    }

}
