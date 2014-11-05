/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.ClassesFerramentas;

import java.awt.Component;
import java.awt.Container;
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
            
            if(component instanceof JTextArea){
                JTextArea field = (JTextArea) component;
                field.setText("");
            }
            
            if(component instanceof JFormattedTextField){
                JFormattedTextField field = (JFormattedTextField) component;
                field.setValue(null);
            }
        }
    }
    public void Limpar(JTable table){
        DefaultTableModel tabela = (DefaultTableModel) table.getModel();
        tabela.setNumRows(0);
    }
    
}
