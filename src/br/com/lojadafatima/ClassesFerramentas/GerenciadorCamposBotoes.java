package br.com.lojadafatima.ClassesFerramentas;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Guilherme Azevedo
 */
public class GerenciadorCamposBotoes {

    public void validacamposCadastrar(Container container, Container containerbot) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JComboBox) {
                JComboBox field = (JComboBox) component;
                field.setEnabled(true);
            }
            
            if (component instanceof JCheckBox) {
                JCheckBox field = (JCheckBox) component;
                field.setEnabled(true);
            }
            
            if (component instanceof JSpinner) {
                JSpinner field = (JSpinner) component;
                field.setEnabled(true);
            }

            if (component instanceof JTextField) {
                JTextField field = (JTextField) component;
                field.setEnabled(true);
            }

            if (component instanceof JTable) {
                JTable field = (JTable) component;
                field.setEnabled(true);
            }

            if (component instanceof JTextArea) {
                JTextArea field = (JTextArea) component;
                field.setEnabled(true);
            }

            if (component instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) component;
                if (field.isEditable()) {
                    field.setEnabled(true);
                }
            }

            if (component instanceof JButton) {
                JButton field = (JButton) component;
                field.setEnabled(true);
            }

            if (component instanceof JRadioButton) {
                JRadioButton field = (JRadioButton) component;
                field.setEnabled(true);
            }

            if (component instanceof JPasswordField) {
                JPasswordField field = (JPasswordField) component;
                field.setEnabled(true);
            }
        }
        Component components1[] = containerbot.getComponents();
        for (Component component1 : components1) {
            if (component1 instanceof JButton) {
                JButton field = (JButton) component1;
                String nome = field.getName();
                if ("Incluir".equals(nome) | "Alterar".equals(nome) | "Excluir".equals(nome)) {
                    field.setEnabled(false);
                } else {
                    field.setEnabled(true);
                }
            }
        }
    }

    public void validacamposCancelar(Container container, Container containerbot) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JComboBox) {
                JComboBox field = (JComboBox) component;
                field.setEnabled(false);
            }
            
            if (component instanceof JCheckBox) {
                JCheckBox field = (JCheckBox) component;
                field.setEnabled(false);
                field.setSelected(false);
            }
            
            if (component instanceof JSpinner) {
                JSpinner field = (JSpinner) component;
                field.setEnabled(false);
            }

            if (component instanceof JTextField) {
                JTextField field = (JTextField) component;
                field.setEnabled(false);
            }

            if (component instanceof JTable) {
                JTable field = (JTable) component;
                field.setEnabled(false);
            }

            if (component instanceof JTextArea) {
                JTextArea field = (JTextArea) component;
                field.setEnabled(false);
            }

            if (component instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) component;
                if (field.isEditable()) {
                    field.setEnabled(false);
                }
            }

            if (component instanceof JButton) {
                JButton field = (JButton) component;
                field.setEnabled(false);
            }

            if (component instanceof JRadioButton) {
                JRadioButton field = (JRadioButton) component;
                field.setEnabled(false);
            }

            if (component instanceof JPasswordField) {
                JPasswordField field = (JPasswordField) component;
                field.setEnabled(false);
            }
        }
        Component components1[] = containerbot.getComponents();
        for (Component component1 : components1) {
            if (component1 instanceof JButton) {
                JButton field = (JButton) component1;
                String nome = field.getName();
                if ("Incluir".equals(nome) | "Alterar".equals(nome) | "Excluir".equals(nome)) {
                    field.setEnabled(true);
                } else {
                    field.setEnabled(false);
                }
            }
        }
    }

    public void FocusLostDeCamposFormatados(JFormattedTextField field) {
        field.setFocusLostBehavior(JFormattedTextField.PERSIST);
    }

    public boolean CampoTotalmentePreenchido(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals(" ")) {
                return false;
            }
        }
        return true;
    }

    public void limitemaximo(KeyEvent evt, String str, int max) {
        if (str.length() >= max) {
            evt.consume();
        }
    }
}
