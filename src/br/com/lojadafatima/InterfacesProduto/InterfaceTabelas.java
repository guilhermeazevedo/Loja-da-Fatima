/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojadafatima.InterfacesProduto;

import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.LimpaCamposTela;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.Produto.ClasseTabelas;
import br.com.lojadafatima.Produto.ClasseValores;
import br.com.lojadafatima.Usuario.ClasseTelasUsuario;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class InterfaceTabelas extends javax.swing.JDialog {

    private java.awt.Frame primeiratela;
    Preenche preenche = new Preenche();
    LimpaCamposTela limpar = new LimpaCamposTela();
    ClasseTabelas tabela = new ClasseTabelas();
    GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();
    private ClasseTelasUsuario telasusuario = new ClasseTelasUsuario();

    public InterfaceTabelas(java.awt.Frame telaorigem, boolean modal, ClasseTelasUsuario usuario) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        
        setTelasusuario(usuario);
        analisausuario();

        int[] tam = new int[2];
        tam[0] = 50;
        tam[1] = 200;
        preenche.FormataJtable(TbTabelas, tam);
        preenche.PreencherJtable(TbTabelas, tabela.buscartabelas());
        preenche.FormataJtable(TbTabelas2, tam);
        preenche.PreencherJtable(TbTabelas2, tabela.buscartabelas());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        MnItAlterar = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        MnItAlterarValor = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PnTabelas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TfCodigoCaract = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TfTabela = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbTabelas = new javax.swing.JTable();
        BtGravar = new javax.swing.JButton();
        BtLimpar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        PnValores = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbTabelas2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        TfCodigoEspecific = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TfValor = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TbValores = new javax.swing.JTable();
        BtGravar1 = new javax.swing.JButton();
        BtLimpar1 = new javax.swing.JButton();

        MnItAlterar.setText("Alterar Caracteristica");
        MnItAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnItAlterarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnItAlterar);

        MnItAlterarValor.setText("Alterar Especificacao");
        MnItAlterarValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnItAlterarValorActionPerformed(evt);
            }
        });
        jPopupMenu2.add(MnItAlterarValor);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabelas e Características dos Produtos - Software Loja da Fátima");
        setResizable(false);

        jLabel1.setText("Código");

        TfCodigoCaract.setEditable(false);

        jLabel2.setText("Característica*");

        TfTabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfTabelaKeyTyped(evt);
            }
        });

        TbTabelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Característica"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbTabelas.setComponentPopupMenu(jPopupMenu1);
        TbTabelas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TbTabelas);
        if (TbTabelas.getColumnModel().getColumnCount() > 0) {
            TbTabelas.getColumnModel().getColumn(0).setResizable(false);
            TbTabelas.getColumnModel().getColumn(1).setResizable(false);
        }

        BtGravar.setText("Gravar");
        BtGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGravarActionPerformed(evt);
            }
        });

        BtLimpar.setText("Limpar");
        BtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtLimparActionPerformed(evt);
            }
        });

        jLabel3.setText("Lista de todas as caracterísitcas cadastradas:");

        javax.swing.GroupLayout PnTabelasLayout = new javax.swing.GroupLayout(PnTabelas);
        PnTabelas.setLayout(PnTabelasLayout);
        PnTabelasLayout.setHorizontalGroup(
            PnTabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnTabelasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnTabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnTabelasLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2))
                    .addGroup(PnTabelasLayout.createSequentialGroup()
                        .addGroup(PnTabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BtGravar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(TfCodigoCaract, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PnTabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnTabelasLayout.setVerticalGroup(
            PnTabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnTabelasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnTabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnTabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfCodigoCaract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnTabelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtGravar)
                    .addComponent(BtLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tabelas", PnTabelas);

        jLabel4.setText("Características:");

        TbTabelas2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Característica"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbTabelas2.getTableHeader().setReorderingAllowed(false);
        TbTabelas2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbTabelas2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbTabelas2);
        if (TbTabelas2.getColumnModel().getColumnCount() > 0) {
            TbTabelas2.getColumnModel().getColumn(0).setResizable(false);
            TbTabelas2.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel5.setText("Código");

        TfCodigoEspecific.setEditable(false);

        jLabel6.setText("Especificação*");

        TfValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfValorKeyTyped(evt);
            }
        });

        TbValores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Especificação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbValores.setComponentPopupMenu(jPopupMenu2);
        TbValores.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TbValores);
        if (TbValores.getColumnModel().getColumnCount() > 0) {
            TbValores.getColumnModel().getColumn(0).setResizable(false);
            TbValores.getColumnModel().getColumn(1).setResizable(false);
        }

        BtGravar1.setText("Gravar");
        BtGravar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGravar1ActionPerformed(evt);
            }
        });

        BtLimpar1.setText("Limpar");
        BtLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtLimpar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnValoresLayout = new javax.swing.GroupLayout(PnValores);
        PnValores.setLayout(PnValoresLayout);
        PnValoresLayout.setHorizontalGroup(
            PnValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnValoresLayout.createSequentialGroup()
                        .addGroup(PnValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PnValoresLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel6)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PnValoresLayout.createSequentialGroup()
                        .addGroup(PnValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PnValoresLayout.createSequentialGroup()
                                    .addComponent(TfCodigoEspecific, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TfValor))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PnValoresLayout.createSequentialGroup()
                                .addComponent(BtGravar1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(BtLimpar1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PnValoresLayout.setVerticalGroup(
            PnValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfCodigoEspecific, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtGravar1)
                    .addComponent(BtLimpar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Valores", PnValores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLimparActionPerformed
        limpar.Limpar(PnTabelas);
    }//GEN-LAST:event_BtLimparActionPerformed

    private void MnItAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnItAlterarActionPerformed
        int index = TbTabelas.getSelectedRow();
        if (index > -1) {
            BtLimparActionPerformed(evt);
            TfCodigoCaract.setText(TbTabelas.getValueAt(index, 0).toString());
            TfTabela.setText(TbTabelas.getValueAt(index, 1).toString());
        }
    }//GEN-LAST:event_MnItAlterarActionPerformed

    private void BtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGravarActionPerformed
        if (!TfTabela.getText().equals("")) {
            int opcao;
            tabela.setTabela(TfTabela.getText());
            if (TfCodigoCaract.getText().equals("")) {
                opcao = JOptionPane.showConfirmDialog(rootPane, "Incluir nova Caracteristica?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    tabela.incluir();
                }
            } else {
                tabela.setCodigo(Integer.parseInt(TfCodigoCaract.getText()));
                opcao = JOptionPane.showConfirmDialog(rootPane, "Alterar dados de Caracteristica?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    tabela.alterar();
                }
            }
            limpar.Limpar(PnTabelas);
            limpar.Limpar(TbTabelas);
            preenche.PreencherJtable(TbTabelas, tabela.buscartabelas());
            limpar.Limpar(TbTabelas2);
            preenche.PreencherJtable(TbTabelas2, tabela.buscartabelas());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Digite o Nome da Caracteristica", "Campos Obrigatorios", JOptionPane.INFORMATION_MESSAGE);
            TfTabela.grabFocus();
        }
    }//GEN-LAST:event_BtGravarActionPerformed

    private void TbTabelas2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbTabelas2MouseClicked
        int index = TbTabelas2.getSelectedRow();
        int[] tam = new int[2];
        tam[0] = 50;
        tam[1] = 200;
        preenche.FormataJtable(TbValores, tam);
        tabela.setCodigo(Integer.parseInt(TbTabelas2.getValueAt(index, 0).toString()));
        preenche.PreencherJtable(TbValores, tabela.buscarvalorestabela());
    }//GEN-LAST:event_TbTabelas2MouseClicked

    private void BtLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLimpar1ActionPerformed
        limpar.Limpar(PnValores);
    }//GEN-LAST:event_BtLimpar1ActionPerformed

    private void BtGravar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGravar1ActionPerformed
        if (!TfValor.getText().equals("")) {
            if (TbTabelas2.getSelectedRow() > -1) {
                int opcao;
                tabela.getValor().setValor(TfValor.getText());
                int index = TbTabelas2.getSelectedRow();
                if (TfCodigoEspecific.getText().equals("")) {
                    opcao = JOptionPane.showConfirmDialog(rootPane, "Incluir nova Especificacao?", "Confirmar", JOptionPane.YES_NO_OPTION);
                    if (opcao == JOptionPane.YES_OPTION) {
                        tabela.getValor().setCodigoTabela(Integer.parseInt(TbTabelas2.getValueAt(index, 0).toString()));
                        tabela.getValor().incluir();
                    }
                } else {
                    tabela.getValor().setCodigo(Integer.parseInt(TfCodigoEspecific.getText()));
                    opcao = JOptionPane.showConfirmDialog(rootPane, "Alterar dados de Especificacao?", "Confirmar", JOptionPane.YES_NO_OPTION);
                    if (opcao == JOptionPane.YES_OPTION) {
                        tabela.getValor().setCodigoTabela(Integer.parseInt(TbTabelas2.getValueAt(index, 0).toString()));
                        tabela.getValor().alterar();
                    }
                }
                limpar.Limpar(PnValores);
                limpar.Limpar(TbValores);
                tabela.setCodigo(Integer.parseInt(TbTabelas2.getValueAt(index, 0).toString()));
                preenche.PreencherJtable(TbValores, tabela.buscarvalorestabela());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione a caracteristica que esta especificacao pertence!", "Campos Obrigatorios", JOptionPane.INFORMATION_MESSAGE);
                TbTabelas2.grabFocus();
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Digite o Nome da Especificacao!", "Campos Obrigatorios", JOptionPane.INFORMATION_MESSAGE);
            TfTabela.grabFocus();
        }
    }//GEN-LAST:event_BtGravar1ActionPerformed

    private void MnItAlterarValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnItAlterarValorActionPerformed
        int index = TbValores.getSelectedRow();
        if (index > -1) {
            BtLimpar1ActionPerformed(evt);
            TfCodigoEspecific.setText(TbValores.getValueAt(index, 0).toString());
            TfValor.setText(TbValores.getValueAt(index, 1).toString());
        }
    }//GEN-LAST:event_MnItAlterarValorActionPerformed

    private void TfTabelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfTabelaKeyTyped
        valida.limitemaximo(evt, TfTabela.getText(), 50);
    }//GEN-LAST:event_TfTabelaKeyTyped

    private void TfValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfValorKeyTyped
        valida.limitemaximo(evt, TfValor.getText(), 50);
    }//GEN-LAST:event_TfValorKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtGravar;
    private javax.swing.JButton BtGravar1;
    private javax.swing.JButton BtLimpar;
    private javax.swing.JButton BtLimpar1;
    private javax.swing.JMenuItem MnItAlterar;
    private javax.swing.JMenuItem MnItAlterarValor;
    private javax.swing.JPanel PnTabelas;
    private javax.swing.JPanel PnValores;
    private javax.swing.JTable TbTabelas;
    private javax.swing.JTable TbTabelas2;
    private javax.swing.JTable TbValores;
    private javax.swing.JTextField TfCodigoCaract;
    private javax.swing.JTextField TfCodigoEspecific;
    private javax.swing.JTextField TfTabela;
    private javax.swing.JTextField TfValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    public void analisausuario(){
        getTelasusuario().getTela().setCodigo(13);
        if(!getTelasusuario().eadmintela()){
            BtGravar.setVisible(false);
            BtGravar1.setVisible(false);
        }
    }
    
    public java.awt.Frame getPrimeiratela() {
        return primeiratela;
    }

    public void setPrimeiratela(java.awt.Frame primeiratela) {
        this.primeiratela = primeiratela;
    }

    public ClasseTelasUsuario getTelasusuario() {
        return telasusuario;
    }

    public void setTelasusuario(ClasseTelasUsuario telasusuario) {
        this.telasusuario = telasusuario;
    }
}
