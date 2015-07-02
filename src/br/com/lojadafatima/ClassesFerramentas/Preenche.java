package br.com.lojadafatima.ClassesFerramentas;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guilherme Azevedo
 */
public class Preenche {

    public void PreencherJtable(JTable tabela, ResultSet resultado) {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        try {
            int colunas = resultado.getMetaData().getColumnCount();

            while (resultado.next()) {
                Object[] row = new Object[colunas];
                for (int i = 0; i != colunas; i++) {
                    row[i] = resultado.getString(i + 1);
                }
                modelo.addRow(row);
            }
            if (!resultado.first()) {

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar na tabela. Verifique com o desenvolvedor", "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException ex){
            modelo.setNumRows(0);
        }
    }

    public void PreencheJtableSEL(JTable tabela, ResultSet resultado) {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        try {
            int colunas = resultado.getMetaData().getColumnCount();

            while (resultado.next()) {
                Object[] row = new Object[colunas];
                for (int i = 0; i != colunas; i++) {
                    if (i == 0) {
                        row[i] = (false);
                    } else {
                        row[i] = resultado.getString(i + 1);
                    }
                }
                modelo.addRow(row);
            }
            if (!resultado.first()) {
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar na tabela. Verifique com o desenvolvedor", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void FormataJtable(JTable tabela, int valores[]) {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        if (modelo.getColumnCount() == valores.length) {
            for (int x = 0; x < valores.length; x++) {
                tabela.getColumnModel().getColumn(x).setPreferredWidth(valores[x]);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao espaçar as colunas da tabela. Verifique com o desenvolvedor", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void PreencheJComboBox(JComboBox combo, ResultSet resultado) {
        combo.removeAllItems();
        try {
            while (resultado.next()) {
                if(combo.getSelectedItem() == null){
                    combo.addItem(resultado.getString(1));
                } else{
                    if(combo.getSelectedItem().toString().equals(resultado.getString(1))){
                        break;
                    } else{
                        combo.addItem(resultado.getString(1));
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher as informações da ComboBox. Verifique com o desenvolvedor\n\nERRO: " + ex);
        }
    }

    public void PreencheJTableEmailOuTelefone(JTextField field, JComboBox combo, JTable table) {

        if (!field.getText().equals("")) {
            DefaultTableModel tabela = (DefaultTableModel) table.getModel();

            int totlinha = table.getRowCount(), i = 0, conta = 0;
            boolean incluir = true;
            for (i = 1; i <= totlinha; i++) {
                String aux = (String) table.getValueAt(conta, 1);
                String aux2 = (String) table.getValueAt(conta, 2);
                if (field.getText().equals(aux) && combo.getSelectedItem().equals(aux2)) {
                    JOptionPane.showMessageDialog(null, "Você já adicionou essas informações na tabela!", "Você já incluiu essas informações", JOptionPane.OK_OPTION);
                    incluir = false;
                }
                conta = conta + 1;
            }
            int x = table.getRowCount();
            if (incluir) {
                tabela.setNumRows(x + 1);
                tabela.setValueAt((false), x, 0);
                tabela.setValueAt(field.getText(), x, 1);
                tabela.setValueAt(combo.getSelectedItem(), x, 2);
                field.setText("");
                field.grabFocus();
            }
        }
    }

    public void RemoveDaJTableEmailOuTelefone(JTable table) {
        DefaultTableModel tabela = (DefaultTableModel) table.getModel();
        int totlinha = table.getRowCount();
        boolean excluiu = false;
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja remover as linhas selecionadas?", "Remover", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            for (int i = totlinha - 1; i >= 0; i--) {
                Boolean selecionado = (Boolean) table.getValueAt(i, 0);
                if (selecionado == true) {
                    excluiu = true;
                    tabela.removeRow(i);
                }
            }
            if (!excluiu == true) {
                JOptionPane.showMessageDialog(null, "Não existem linhas selecionadas para remossão!\n\n"
                                                  + "Para remover, selecione as linhas que deseja antes de clicar no botão Remover", "Não existem linhas para remossão", JOptionPane.OK_OPTION);
            }
        }
    }

}
