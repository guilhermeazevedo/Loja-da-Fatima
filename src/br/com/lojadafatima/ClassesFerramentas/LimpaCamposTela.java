/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.ClassesFerramentas;

import JNumberField.JNumberField;
import java.awt.Component;
import java.awt.Container;
import java.math.BigDecimal;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class LimpaCamposTela {
    
    public void Limpar(Container container){
        Component components[] = container.getComponents();
        for(Component component : components){
            if(component instanceof JTextField){
                JTextField field = (JTextField) component;
                field.setText("");
            }
            
            if(component instanceof JCheckBox){
                JCheckBox field = (JCheckBox) component;
                field.setSelected(false);
            }
            
            if(component instanceof JTextArea){
                JTextArea field = (JTextArea) component;
                field.setText("");
            }
            
            if(component instanceof JFormattedTextField){
                JFormattedTextField field = (JFormattedTextField) component;
                field.setValue(null);
            }
            
            if(component instanceof JNumberField){
                JNumberField field = (JNumberField) component;
                field.setValue(BigDecimal.valueOf(0));
            }
        }
    }
    public void Limpar(JTable table){
        DefaultTableModel tabela = (DefaultTableModel) table.getModel();
        tabela.setNumRows(0);
    }
    
}
