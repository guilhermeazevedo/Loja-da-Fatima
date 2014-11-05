/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.ClassesFerramentas;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.text.SimpleAttributeSet;

/**
 *
 * @author Guilherme Azevedo
 */
public class JQuantidadeField extends JFormattedTextField{        
    private static final long serialVersionUID = -5712106034509737967L;    
    private static final SimpleAttributeSet nullAttribute = new SimpleAttributeSet();    
    private int maxLength;    
    
    public JQuantidadeField(int maxLength) {            
        this.maxLength = maxLength;    
            
        this.setDocument((Document) new FormataQuantidadeDocument());    
        this.setHorizontalAlignment(JTextField.RIGHT);            
        this.setText("0,000"); //qtd    
        this.addFocusListener(new FocusAdapter() {    
            public void focusGained(FocusEvent e) {    
                selectAll();    
            }    
        });    
               
        this.addCaretListener(new CaretListener() {    
            @Override    
            public void caretUpdate(CaretEvent e) {    
                if (e.getDot() != getText().length() ) {    
                    getCaret().setDot(getText().length());    
            }                    
            }    
        });            
            
    }    
        
    private final class FormataQuantidadeDocument extends PlainDocument{    
        private static final long serialVersionUID = -3802846632709128803L;    
            
        public void insertString(int offs, String str, AttributeSet a) {    
            try{    
                String original = getText(0,getLength());    
                if(original.length() < maxLength){    
                    StringBuffer mascara = new StringBuffer();    
                        
                    if(a != nullAttribute){                            
                        remove(-1, getLength());                        
                        mascara.append(original+str.replaceAll("[^0-9]", ""));    
                            
                        for(int x = 0; x < mascara.length(); x++){    
                            if(!Character.isDigit(mascara.charAt(x))){    
                                mascara.deleteCharAt(x);    
                            }    
                        }    
                        Long n = new Long(mascara.toString());    
                        mascara.replace(0, mascara.length(), n.toString());    
                        
                        //verifica casas antes da virgula + a virgula    
                        if(mascara.length() < 4){     
                            if(mascara.length() == 1){                            
                                mascara.insert(0, "00");    
                                mascara.insert(0, ",");     
                                mascara.insert(0, "0");                            
                            }else if(mascara.length() == 2){                            
                                mascara.insert(0, "0");    
                                mascara.insert(0, ",");                             
                                mascara.insert(0, "0");                            
                            }else if(mascara.length() == 3){                                                    
                                mascara.insert(0, ",");     
                                mascara.insert(0, "0");                            
                            }                                     
                        }else{    
                            //adiciona virgula    
                            mascara.insert(mascara.length()-3, ",");      
                        }    
                        
                        if(mascara.length() > 7){                        
                            mascara.insert(mascara.length()-7, ".");    
                            if(mascara.length() > 11){    
                                mascara.insert(mascara.length()-11, ".");    
                                if(mascara.length() > 15){    
                                    mascara.insert(mascara.length()-15, ".");    
                                }    
                            }                        
                        }                        
                        super.insertString(0, mascara.toString(), a);                        
                    }else{    
                        if (original.length() == 0){    
                            super.insertString(0, "0,000", a);    
                        }                        
                    }    
                }                    
            }catch(Exception e){    
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);    
            }    
        }    
            
        public void remove(int offs, int len) throws BadLocationException{    
            if(len == getLength()){    
                super.remove(0, len);    
                if(offs != -1){    
                    insertString(0, "", nullAttribute);                        
                }    
            }else{    
                String original = getText(0, getLength()).substring(0, offs) + getText(0, getLength()).substring(offs+len);    
            super.remove(0, getLength());    
            insertString(0,original,null);    
            }    
        }    
    }    
        
}
