/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojadafatima.InterfacesOperacoes;

import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.LimpaCamposTela;
import br.com.lojadafatima.ClassesFerramentas.NaoPermiteAspasSimples;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.CompraVendaOperacoes.ClasseOperacoes;
import br.com.lojadafatima.Usuario.ClasseTelasUsuario;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author hp
 */
public class InterfaceOperacoes extends javax.swing.JDialog {

    GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();
    ClasseOperacoes operacao = new ClasseOperacoes();
    Preenche preenche = new Preenche();
    LimpaCamposTela limpar = new LimpaCamposTela();
    private java.awt.Frame primeiratela;
    private ClasseTelasUsuario telasusuario = new ClasseTelasUsuario();

    public InterfaceOperacoes(java.awt.Frame telaorigem, boolean modal, ClasseTelasUsuario usuario) {
        super (telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setTelasusuario(usuario);
        analisausuario();
        ChkEstoqueActionPerformed(null);
        ChkFinanceiroActionPerformed(null);
        int[] tam = new int[2];
        tam[0] = 70;
        tam[1] = 200;
        preenche.FormataJtable(TbOperacoes, tam);
        preenche.PreencherJtable(TbOperacoes, operacao.consultaoperacoes());
        TbOperacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TfOperacao.setDocument(new NaoPermiteAspasSimples());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TfOperacao = new javax.swing.JTextField();
        ChkEstoque = new javax.swing.JCheckBox();
        RbEntEstoque = new javax.swing.JRadioButton();
        RbSaiEstoque = new javax.swing.JRadioButton();
        ChkFinanceiro = new javax.swing.JCheckBox();
        RbEntFinanceiro = new javax.swing.JRadioButton();
        RbSaiFinanceiro = new javax.swing.JRadioButton();
        BtGravar = new javax.swing.JButton();
        BtLimpar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbOperacoes = new javax.swing.JTable();

        jMenuItem1.setText("Carregar dados");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Codigo");

        TfCodigo.setEnabled(false);

        jLabel2.setText("Operacao");

        TfOperacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfOperacaoKeyTyped(evt);
            }
        });

        ChkEstoque.setText("Modifica estoques de produtos");
        ChkEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkEstoqueActionPerformed(evt);
            }
        });

        buttonGroup1.add(RbEntEstoque);
        RbEntEstoque.setSelected(true);
        RbEntEstoque.setText("Entrada no estoque");

        buttonGroup1.add(RbSaiEstoque);
        RbSaiEstoque.setText("Saida no estoque");

        ChkFinanceiro.setText("Modifica valores financeiros");
        ChkFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkFinanceiroActionPerformed(evt);
            }
        });

        buttonGroup2.add(RbEntFinanceiro);
        RbEntFinanceiro.setSelected(true);
        RbEntFinanceiro.setText("Entrada");

        buttonGroup2.add(RbSaiFinanceiro);
        RbSaiFinanceiro.setText("Saida");

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

        jLabel3.setText("Operacoes cadastradas:");

        TbOperacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Operacao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbOperacoes.setComponentPopupMenu(jPopupMenu1);
        TbOperacoes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TbOperacoes);
        if (TbOperacoes.getColumnModel().getColumnCount() > 0) {
            TbOperacoes.getColumnModel().getColumn(0).setResizable(false);
            TbOperacoes.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TfOperacao))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ChkEstoque)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RbSaiEstoque)
                                            .addComponent(RbEntEstoque))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ChkFinanceiro)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RbSaiFinanceiro)
                                            .addComponent(RbEntFinanceiro)))))
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChkEstoque)
                    .addComponent(ChkFinanceiro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbEntEstoque)
                    .addComponent(RbEntFinanceiro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbSaiEstoque)
                    .addComponent(RbSaiFinanceiro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ChkEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkEstoqueActionPerformed
        if (ChkEstoque.isSelected()) {
            RbEntEstoque.setEnabled(true);
            RbSaiEstoque.setEnabled(true);
        } else {
            RbEntEstoque.setEnabled(false);
            RbSaiEstoque.setEnabled(false);
        }
    }//GEN-LAST:event_ChkEstoqueActionPerformed

    private void ChkFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkFinanceiroActionPerformed
        if (ChkFinanceiro.isSelected()) {
            RbEntFinanceiro.setEnabled(true);
            RbSaiFinanceiro.setEnabled(true);
        } else {
            RbEntFinanceiro.setEnabled(false);
            RbSaiFinanceiro.setEnabled(false);
        }
    }//GEN-LAST:event_ChkFinanceiroActionPerformed

    private void TfOperacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfOperacaoKeyTyped
        valida.limitemaximo(evt, TfOperacao.getText(), 50);
    }//GEN-LAST:event_TfOperacaoKeyTyped

    private void BtLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLimparActionPerformed
        limpar.Limpar(jPanel1);
    }//GEN-LAST:event_BtLimparActionPerformed

    private void BtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGravarActionPerformed
        if (!TfOperacao.getText().equals("")) {
            if (!ChkEstoque.isSelected() && !ChkFinanceiro.isSelected()) {
                JOptionPane.showMessageDialog(null, "A operacao deve fazer alguma modificacao no sistema!", "Campos obrigatorios", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (JOptionPane.showConfirmDialog(null, "Deseja realmente gravar os dados desta operacao?", "Deseja gravar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    enviardados();
                    if (TfCodigo.getText().equals("")) {
                        operacao.incluir();
                    } else {
                        operacao.setCodigo(Integer.parseInt(TfCodigo.getText()));
                        operacao.alterar();
                    }
                    limpar.Limpar(jPanel1);
                    preenche.PreencherJtable(TbOperacoes, operacao.consultaoperacoes());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digite um \"nome\" para a operacao!", "Campos obrigatorios", JOptionPane.INFORMATION_MESSAGE);
            TfOperacao.grabFocus();
        }
    }//GEN-LAST:event_BtGravarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(TbOperacoes.getSelectedRow() > 3){
            operacao.setCodigo(Integer.parseInt(TbOperacoes.getValueAt(TbOperacoes.getSelectedRow(), 0).toString()));
            operacao.retornaoperacao();
            TfCodigo.setText(""+operacao.getCodigo());
            TfOperacao.setText(operacao.getDescricao());
            if(operacao.getInestoque().equals("S")){
                ChkEstoque.setSelected(true);
                if(operacao.getTpestoque().equals("E")){
                    RbEntEstoque.setSelected(true);
                }else{
                    RbSaiEstoque.setSelected(true);
                }
            }else{
                ChkEstoque.setSelected(false);
            }
            if(operacao.getInfinanceiro().equals("S")){
                ChkFinanceiro.setSelected(true);
                if(operacao.getTpfinanceiro().equals("E")){
                    RbEntFinanceiro.setSelected(true);
                }else{
                    RbSaiFinanceiro.setSelected(true);
                }
            }else{
                ChkFinanceiro.setSelected(false);
            }
            ChkEstoqueActionPerformed(evt);
            ChkFinanceiroActionPerformed(evt);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtGravar;
    private javax.swing.JButton BtLimpar;
    private javax.swing.JCheckBox ChkEstoque;
    private javax.swing.JCheckBox ChkFinanceiro;
    private javax.swing.JRadioButton RbEntEstoque;
    private javax.swing.JRadioButton RbEntFinanceiro;
    private javax.swing.JRadioButton RbSaiEstoque;
    private javax.swing.JRadioButton RbSaiFinanceiro;
    private javax.swing.JTable TbOperacoes;
    private javax.swing.JTextField TfCodigo;
    private javax.swing.JTextField TfOperacao;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void analisausuario(){
        getTelasusuario().getTela().setCodigo(10);
        if(!getTelasusuario().eadmintela()){
            BtGravar.setVisible(false);
        }
    }
    
    public void enviardados() {
        operacao.setDescricao(TfOperacao.getText());
        if (ChkEstoque.isSelected()) {
            operacao.setInestoque("S");
            if (RbEntEstoque.isSelected()) {
                operacao.setTpestoque("E");
            } else {
                operacao.setTpestoque("S");
            }
        } else {
            operacao.setInestoque("N");
            operacao.setTpestoque("N");
        }

        if (ChkFinanceiro.isSelected()) {
            operacao.setInfinanceiro("S");
            if (RbEntFinanceiro.isSelected()) {
                operacao.setTpfinanceiro("E");
            } else {
                operacao.setTpfinanceiro("S");
            }
        } else {
            operacao.setInfinanceiro("N");
            operacao.setTpfinanceiro("N");
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
