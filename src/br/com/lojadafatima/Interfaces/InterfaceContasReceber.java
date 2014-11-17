/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojadafatima.Interfaces;

import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.LimpaCamposTela;
import br.com.lojadafatima.ClassesFerramentas.NaoPermiteAspasSimples;
import br.com.lojadafatima.ClassesFerramentas.PermiteApenasNumeros;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.DadosPessoa.ClassePessoaFisica;
import br.com.lojadafatima.DadosPessoa.ClassePessoaJuridica;
import br.com.lojadafatima.Financeiro.ClasseMvtoCaixa;
import br.com.lojadafatima.Financeiro.ClasseParcelas;
import br.com.lojadafatima.Pessoa.ClasseCliente;
import java.math.BigDecimal;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author hp
 */
public class InterfaceContasReceber extends javax.swing.JDialog {

    private java.awt.Frame primeiratela;
    ClasseParcelas parcelas = new ClasseParcelas();
    Preenche preenche = new Preenche();
    LimpaCamposTela limpar = new LimpaCamposTela();
    GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();

    /**
     * Creates new form InterfaceContasReceber
     */
    public InterfaceContasReceber(java.awt.Frame telaorigem, boolean modal) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        int[] tam = new int[2];
        tam[0] = 200;
        tam[1] = 100;
        preenche.FormataJtable(TbPessoas, tam);

        int[] tam2 = new int[7];
        tam2[0] = 70;
        tam2[1] = 70;
        tam2[2] = 70;
        tam2[3] = 70;
        tam2[4] = 70;
        tam2[5] = 70;
        tam2[6] = 70;
        preenche.FormataJtable(TbContas, tam2);

        int[] tam3 = new int[7];
        tam3[0] = 20;
        tam3[1] = 70;
        tam3[2] = 70;
        tam3[3] = 70;
        tam3[4] = 70;
        tam3[5] = 70;
        tam3[6] = 70;
        preenche.FormataJtable(TbParcelas, tam3);

        preenche.PreencheJComboBox(CbFormaPgto, parcelas.getFormapgto().retornaformapgtocombobox());
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
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbPessoas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        CbPesqPessoa = new javax.swing.JComboBox();
        BtPesqPessoa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbContas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TbParcelas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CbFormaPgto = new javax.swing.JComboBox();
        BtPagar = new javax.swing.JButton();
        TfValor = new JNumberField.JNumberField();
        BtCadFormaPgto = new javax.swing.JButton();

        jMenuItem1.setText("Extornar parcela");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contas à Receber - Software Loja da Fátima");
        setResizable(false);

        TbPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome/Nome Fantasia", "CPF/CNPJ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbPessoas.getTableHeader().setReorderingAllowed(false);
        TbPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TbPessoasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TbPessoas);

        jLabel3.setText("Buscar Pessoas");

        CbPesqPessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pessoas com Contas em Aberto", "Pessoas com Contas Vencidas", "Listar apenas Clientes com Contas em Aberto", "Listar apenas Clientes com Contas Vencidas", "Listar todos os Clientes" }));
        CbPesqPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPesqPessoaActionPerformed(evt);
            }
        });

        BtPesqPessoa.setText("Pesquisar");
        BtPesqPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPesqPessoaActionPerformed(evt);
            }
        });

        jLabel1.setText("Contas da Pessoa:");

        TbContas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código da Conta", "Operacao", "Pessoa", "Condicao de Pagamento", "Data", "Valor Total", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbContas.getTableHeader().setReorderingAllowed(false);
        TbContas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TbContasMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(TbContas);
        if (TbContas.getColumnModel().getColumnCount() > 0) {
            TbContas.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel2.setText("Parcelas da Conta:");

        TbParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Parcela", "Valor à Pagar(R$)", "Valor Pago(R$)", "Data à Pagar", "Data Pago", "Situação", "Reparcela da Parcela Numero"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbParcelas.setComponentPopupMenu(jPopupMenu1);
        TbParcelas.getTableHeader().setReorderingAllowed(false);
        TbParcelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TbParcelasMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(TbParcelas);
        if (TbParcelas.getColumnModel().getColumnCount() > 0) {
            TbParcelas.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel4.setText("Valor à Pagar");

        jLabel6.setText("Forma de Pagamento");

        BtPagar.setText("Pagar");
        BtPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPagarActionPerformed(evt);
            }
        });

        TfValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfValorKeyTyped(evt);
            }
        });

        BtCadFormaPgto.setText("Cadastrar Forma de Pagamento");
        BtCadFormaPgto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCadFormaPgtoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CbPesqPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtPesqPessoa))
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CbFormaPgto, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtCadFormaPgto))
                                    .addComponent(BtPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbPesqPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtPesqPessoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbFormaPgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCadFormaPgto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CbPesqPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPesqPessoaActionPerformed

    }//GEN-LAST:event_CbPesqPessoaActionPerformed

    private void BtPesqPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPesqPessoaActionPerformed
        limpar.Limpar(TbPessoas);
        limpar.Limpar(TbContas);
        limpar.Limpar(TbParcelas);
        switch (CbPesqPessoa.getSelectedIndex()) {
            case 0: {
                preenche.PreencherJtable(TbPessoas, parcelas.getConta().contasreceberaberto());
                break;
            }
            case 1: {
                preenche.PreencherJtable(TbPessoas, parcelas.getConta().contasrecebervencidas());
                break;
            }
            case 2: {
                preenche.PreencherJtable(TbPessoas, parcelas.getConta().contasreceberclientesaberto());
                break;
            }
            case 3: {
                preenche.PreencherJtable(TbPessoas, parcelas.getConta().contasreceberclientesvencido());
                break;
            }
            case 4: {
                preenche.PreencherJtable(TbPessoas, parcelas.getConta().listarclientes());
                break;
            }
        }
    }//GEN-LAST:event_BtPesqPessoaActionPerformed

    private void TfValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfValorKeyTyped
        valida.limitemaximo(evt, TfValor.getText(), 13);
    }//GEN-LAST:event_TfValorKeyTyped

    private void TbPessoasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbPessoasMouseReleased
        if (TbPessoas.getSelectedRow() > -1) {
            limpar.Limpar(TbParcelas);
            limpar.Limpar(TbContas);
            ClassePessoaFisica fisica = new ClassePessoaFisica();
            ClassePessoaJuridica juridica = new ClassePessoaJuridica();
            fisica.setNome(TbPessoas.getValueAt(TbPessoas.getSelectedRow(), 0).toString());
            juridica.setNomefantasia(TbPessoas.getValueAt(TbPessoas.getSelectedRow(), 0).toString());
            if (fisica.epessoafisica()) {
                parcelas.getConta().setCodigopessoa(fisica.getPessoa().getCodigo());
            } else if (juridica.epessoajuridica()) {
                parcelas.getConta().setCodigopessoa(juridica.getPessoa().getCodigo());
            }
            preenche.PreencherJtable(TbContas, parcelas.getConta().contaspessoa());
        }
    }//GEN-LAST:event_TbPessoasMouseReleased

    private void TbContasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbContasMouseReleased
        if (TbContas.getSelectedRow() > -1) {
            limpar.Limpar(TbParcelas);
            parcelas.getConta().setCodigo(Integer.parseInt(TbContas.getValueAt(TbContas.getSelectedRow(), 0).toString()));
            parcelas.getConta().getOperacao().setDescricao(TbContas.getValueAt(TbContas.getSelectedRow(), 1).toString());
            parcelas.getConta().getOperacao().setCodigo(parcelas.getConta().getOperacao().retornacodigooperacao());
            preenche.PreencherJtable(TbParcelas, parcelas.retornaparcelas());
        }
    }//GEN-LAST:event_TbContasMouseReleased

    private void TbParcelasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbParcelasMouseReleased
        if (TbParcelas.getSelectedRow() > -1) {
            if (TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 5).toString().equals("PAGA")) {
                TfValor.setEnabled(false);
            } else {
                TfValor.setEnabled(true);
                TfValor.setText(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 1).toString());
            }
        }
    }//GEN-LAST:event_TbParcelasMouseReleased

    private void BtPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPagarActionPerformed
        if (TbParcelas.getSelectedRow() > -1 && TfValor.getValue() != BigDecimal.valueOf(0)) {
            if (CbFormaPgto.getSelectedItem() != null) {
                if (Float.parseFloat(TfValor.getValue().toString()) == Float.parseFloat(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 1).toString())) {
                    if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar o pagamento desta parcela?", "Deseja pagar esta parcela?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        parcelas.setCodigo(Integer.parseInt(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 0).toString()));
                        parcelas.setVlpago(Float.parseFloat(TfValor.getValue().toString()));
                        parcelas.getFormapgto().setFormapgto(CbFormaPgto.getSelectedItem().toString());
                        parcelas.getFormapgto().setCodigo(parcelas.getFormapgto().retornacodigo());
                        parcelas.pagaparcela();
                        ClasseMvtoCaixa mvtocaixa = new ClasseMvtoCaixa();
                        mvtocaixa.setParcela(parcelas);
                        mvtocaixa.setTpmvto("E");
                        mvtocaixa.setVlmvto(Float.parseFloat(TfValor.getValue().toString()));
                        mvtocaixa.setDsmvto("PAGAMENTO DA PARCELA NRO. "+mvtocaixa.getParcela().getCodigo()+" - "+parcelas.getConta().retornadescricaodaconta());
                        mvtocaixa.incluir();
                        TbContasMouseReleased(null);
                    }
                } else if (Float.parseFloat(TfValor.getValue().toString()) > Float.parseFloat(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 1).toString())) {
                    JOptionPane.showMessageDialog(null, "O valor digitado e maior que o valor da parcela!\nPor favor, digite um valor igual ou menor que o valor da parcela.", "Valor digitado incorretamente", JOptionPane.INFORMATION_MESSAGE);
                } else if (JOptionPane.showConfirmDialog(null, "Tem certeza que este e o valor correto?\n(Caso for pago essa quantia, seja gerado uma parcela a mais para\nesta conta com o valor restante a ser pago pela pessoa)", "Deseja gerar uma reparcela?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    parcelas.setCodigo(Integer.parseInt(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 0).toString()));
                    parcelas.setVlpago(Float.parseFloat(TfValor.getValue().toString()));
                    parcelas.getFormapgto().setFormapgto(CbFormaPgto.getSelectedItem().toString());
                    parcelas.getFormapgto().setCodigo(parcelas.getFormapgto().retornacodigo());
                    parcelas.pagaparcela();
                    ClasseMvtoCaixa mvtocaixa = new ClasseMvtoCaixa();
                    mvtocaixa.setParcela(parcelas);
                    mvtocaixa.setTpmvto("E");
                    mvtocaixa.setVlmvto(Float.parseFloat(TfValor.getValue().toString()));
                    mvtocaixa.setDsmvto("PAGAMENTO PARCIAL DA PARCELA NRO. "+mvtocaixa.getParcela().getCodigo()+" - "+parcelas.getConta().retornadescricaodaconta());
                    mvtocaixa.incluir();
                    parcelas.setVlpagar(Float.parseFloat(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 1).toString()) - Float.parseFloat(TfValor.getValue().toString()));
                    parcelas.gerarreparcela();
                    TbContasMouseReleased(null);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione ou insira a Forma de Pagamento escolhida pela pessoa!", "Campos obrigatorios", JOptionPane.INFORMATION_MESSAGE);
                CbFormaPgto.grabFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione a Parcela que sera paga e o valor correto a ser pago!", "Campos obrigatorios", JOptionPane.INFORMATION_MESSAGE);
            TfValor.grabFocus();
        }
    }//GEN-LAST:event_BtPagarActionPerformed

    private void BtCadFormaPgtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCadFormaPgtoActionPerformed
        final InterfaceFormaPagto tela = new InterfaceFormaPagto(getPrimeiratela(), true);
        tela.setVisible(true);
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                preenche.PreencheJComboBox(CbFormaPgto, parcelas.getFormapgto().retornaformapgtocombobox());
            }
        });
    }//GEN-LAST:event_BtCadFormaPgtoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(TbParcelas.getSelectedRow() > -1){
            if(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 5).toString().equals("PAGA")){
                if(JOptionPane.showConfirmDialog(null, "Deseja realmente extornar esta parcela?\n"
                                                     + "(Fazendo isso voce estara retirando do caixa o valor pago nesta parcela)", "Deseja extornar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    parcelas.setCodigo(Integer.parseInt(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 0).toString()));
                    parcelas.setVlpagar(Float.parseFloat(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 2).toString()));
                    parcelas.extornarparcela();
                    ClasseMvtoCaixa mvtocaixa = new ClasseMvtoCaixa();
                    mvtocaixa.setParcela(parcelas);
                    mvtocaixa.setTpmvto("S");
                    mvtocaixa.setVlmvto(parcelas.getVlpagar());
                    mvtocaixa.setDsmvto("EXTORNO DA PARCELA NRO. "+mvtocaixa.getParcela().getCodigo()+" - "+parcelas.getConta().retornadescricaodaconta());
                    mvtocaixa.incluir();
                    TbContasMouseReleased(null);
                }
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCadFormaPgto;
    private javax.swing.JButton BtPagar;
    private javax.swing.JButton BtPesqPessoa;
    private javax.swing.JComboBox CbFormaPgto;
    private javax.swing.JComboBox CbPesqPessoa;
    private javax.swing.JTable TbContas;
    private javax.swing.JTable TbParcelas;
    private javax.swing.JTable TbPessoas;
    private JNumberField.JNumberField TfValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    public java.awt.Frame getPrimeiratela() {
        return primeiratela;
    }

    public void setPrimeiratela(java.awt.Frame primeiratela) {
        this.primeiratela = primeiratela;
    }
}
