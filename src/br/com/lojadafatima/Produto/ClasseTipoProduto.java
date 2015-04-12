/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojadafatima.Produto;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class ClasseTipoProduto {

    private int codigo;
    private String tipoproduto;
    private float percentlucro;
    private ClasseTabelas tabela = new ClasseTabelas();
    ConexaoPostgre conn = new ConexaoPostgre();

    public ResultSet buscartiposproduto() {
        conn.executeSQL("SELECT \"CD_TIPO_PRODUTO\", \"DS_TIPO_PRODUTO\", \"PE_LUCRO_PRODUTO\"\n"
                + "FROM bancoloja.\"CAD_TIPO_PRODUTO\" "
                + "ORDER BY \"CD_TIPO_PRODUTO\";");
        return getTabela().conn.resultset;
    }

    public void incluir() {
        GeraCodigos geracodigo = new GeraCodigos();
        setCodigo(geracodigo.gerasequencia("CAD_TIPO_PRODUTO", "CD_TIPO_PRODUTO"));
        conn.incluirSQL("INSERT INTO bancoloja.\"CAD_TIPO_PRODUTO\"(\n"
                + "\"CD_TIPO_PRODUTO\", \"DS_TIPO_PRODUTO\", \"PE_LUCRO_PRODUTO\")\n"
                + "VALUES (" + getCodigo() + ", '" + getTipoproduto().toUpperCase() + "', "+getPercentlucro()+");");
    }

    public void incluirtabela() {
        conn.executeSQL("INSERT INTO bancoloja.\"CAD_TABELAS_TIPO_PRODUTO\"(\n"
                + "\"CD_TIPO_PRODUTO\", \"CD_TABELA\")\n"
                + "VALUES (" + getCodigo() + ", " + getTabela().getCodigo() + ")");
    }

    public void excluir() {
        excluirtabelastipoproduto();
        conn.deleteSQL("DELETE FROM bancoloja.\"CAD_TIPO_PRODUTO\"\n"
                + "WHERE \"CD_TIPO_PRODUTO\" = " + getCodigo() + "");
    }

    public void excluirtabelastipoproduto() {
        conn.executeSQL("DELETE FROM bancoloja.\"CAD_TABELAS_TIPO_PRODUTO\"\n"
                + "WHERE \"CD_TIPO_PRODUTO\" = " + getCodigo() + "");
    }

    public void alterar() {
        getTabela().conn.atualizarSQL("UPDATE bancoloja.\"CAD_TIPO_PRODUTO\"\n"
                + "SET \"DS_TIPO_PRODUTO\"='" + getTipoproduto().toUpperCase() + "', \"PE_LUCRO_PRODUTO\"="+getPercentlucro()+"\n"
                + "WHERE \"CD_TIPO_PRODUTO\"=" + getCodigo() + ";");
    }

    public ResultSet buscartipoprodutocombobox() {
        conn.executeSQL("SELECT \"DS_TIPO_PRODUTO\" FROM bancoloja.\"CAD_TIPO_PRODUTO\" ORDER BY \"DS_TIPO_PRODUTO\"");
        return conn.resultset;
    }

    public int retornacodigo() {
        getTabela().conn.executeSQL("SELECT \"CD_TIPO_PRODUTO\" FROM bancoloja.\"CAD_TIPO_PRODUTO\"\n"
                + "WHERE \"DS_TIPO_PRODUTO\" = '" + getTipoproduto().toUpperCase() + "'");
        try {
            getTabela().conn.resultset.first();
            return getTabela().conn.resultset.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex);
            return 0;
        }
    }

    public ResultSet buscartabelasdotipoproduto() {
        conn.executeSQL("SELECT \"T\".\"CD_TABELA\", \"T\".\"DS_TABELA\"\n"
                + "FROM bancoloja.\"CAD_TABELAS_TIPO_PRODUTO\" AS \"TT\"\n"
                + "JOIN bancoloja.\"CAD_TABELAS\" AS \"T\" ON\n"
                + "\"T\".\"CD_TABELA\" = \"TT\".\"CD_TABELA\""
                + "WHERE \"TT\".\"CD_TIPO_PRODUTO\" = " + getCodigo());
        return conn.resultset;
    }

    public boolean tipoprodutocomproduto() {
        conn.executeSQL("SELECT \"CD_PRODUTO\"\n"
                + "FROM bancoloja.\"CAD_CARACTERISTICAS_PRODUTO\"\n"
                + "WHERE \"CD_TIPO_PRODUTO\" = " + getCodigo() + "");
        try {
            conn.resultset.first();
            conn.resultset.getInt(1);
            return true;
        } catch (SQLException ex) {

        }
        return false;
    }

    public float retornapercentuallucro() {
        conn.executeSQL("SELECT \"PE_LUCRO_PRODUTO\" FROM bancoloja.\"CAD_TIPO_PRODUTO\"\n"
                + "WHERE \"CD_TIPO_PRODUTO\" = " + getCodigo());
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

    public String getTipoproduto() {
        return tipoproduto;
    }

    public void setTipoproduto(String tipoproduto) {
        this.tipoproduto = tipoproduto;
    }

    public ClasseTabelas getTabela() {
        return tabela;
    }

    public void setTabela(ClasseTabelas tabela) {
        this.tabela = tabela;
    }

    public float getPercentlucro() {
        return percentlucro;
    }

    public void setPercentlucro(float percentlucro) {
        this.percentlucro = percentlucro;
    }

}
