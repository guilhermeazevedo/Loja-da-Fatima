/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojadafatima.InterfacesFinanceiro;

import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.LimpaCamposTela;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.CompraVendaOperacoes.ClasseProdutosCompraVenda;
import br.com.lojadafatima.Financeiro.ClasseMvtoCaixa;
import br.com.lojadafatima.Financeiro.ClasseParcelas;
import br.com.lojadafatima.InterfaceConsultaSimples.ConsulSimplesDetalhesOperacao;
import br.com.lojadafatima.Usuario.ClasseTelasUsuario;
import java.math.BigDecimal;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author hp
 */
public class InterfaceContasPagar extends javax.swing.JDialog {

    private java.awt.Frame primeiratela;
    Preenche preenche = new Preenche();
    LimpaCamposTela limpar = new LimpaCamposTela();
    ClasseParcelas parcelas = new ClasseParcelas();
    GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();
    private ClasseTelasUsuario telasusuario = new ClasseTelasUsuario();

    /**
     * Creates new form InterfaceContasPagar
     */
    public InterfaceContasPagar(java.awt.Frame telaorigem, boolean modal, ClasseTelasUsuario usuario) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setTelasusuario(usuario);
        analisausuario();
        int[] tam2 = new int[7];
        tam2[0] = 70;
        tam2[1] = 70;
        tam2[2] = 70;
        tam2[3] = 70;
        tam2[4] = 70;
        tam2[5] = 70;
        tam2[6] = 70;
        preenche.FormataJtable(TbContas, tam2);

        int[] tam3 = new int[8];
        tam3[0] = 20;
        tam3[1] = 70;
        tam3[2] = 70;
        tam3[3] = 70;
        tam3[4] = 70;
        tam3[5] = 70;
        tam3[6] = 70;
        tam3[7] = 70;
        preenche.FormataJtable(TbParcelas, tam3);
        preenche.PreencheJComboBox(CbFormaPgto, parcelas.getFormapgto().retornaformapgtocombobox());
        CbPesqContasActionPerformed(null);
        TbContas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TbParcelas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        PopDetalhes = new javax.swing.JPopupMenu();
        ItMnDetalhes = new javax.swing.JMenuItem();
        ItMnCancelar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        CbPesqContas = new javax.swing.JComboBox();
        BtGerarRelatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbContas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbParcelas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        TfValor = new JNumberField.JNumberField();
        jLabel3 = new javax.swing.JLabel();
        CbFormaPgto = new javax.swing.JComboBox();
        BtCadFormaPgto = new javax.swing.JButton();
        BtPagar = new javax.swing.JButton();

        jMenuItem1.setText("Estornar parcela");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        ItMnDetalhes.setText("Detalhes...");
        ItMnDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItMnDetalhesActionPerformed(evt);
            }
        });
        PopDetalhes.add(ItMnDetalhes);

        ItMnCancelar.setText("Cancelar operação");
        ItMnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItMnCancelarActionPerformed(evt);
            }
        });
        PopDetalhes.add(ItMnCancelar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contas à Pagar - Software Loja da Fátima");
        setResizable(false);

        jLabel7.setText("Buscar Contas:");

        CbPesqContas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas as Contas Abertas e Vencidas", "Todas as Contas Abertas", "Todas as Contas Vencidas", "Todas as Contas do Mes", "Todas as Contas do Mes Anterior", "Todas as Contas Do Ano Atual", "Todas as Contas" }));
        CbPesqContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPesqContasActionPerformed(evt);
            }
        });

        BtGerarRelatorio.setText("Gerar Relatorio");
        BtGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGerarRelatorioActionPerformed(evt);
            }
        });

        TbContas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo da Conta", "Operacao", "Pessoa", "Condicao de Pagamento", "Data", "Valor Total (R$)", "Situacao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbContas.setComponentPopupMenu(PopDetalhes);
        TbContas.getTableHeader().setReorderingAllowed(false);
        TbContas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TbContasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TbContas);

        jLabel1.setText("Parcelas da Conta:");

        TbParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nrº Parcela", "Valor a Pagar (R$)", "Valor Pago (R$)", "Forma de pagamento", "Data a Pagar", "Data Pago", "Situacao", "Reparcela da Parcela Nro."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
        jScrollPane2.setViewportView(TbParcelas);

        jLabel2.setText("Valor a Pagar");

        TfValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfValorKeyTyped(evt);
            }
        });

        jLabel3.setText("Forma de Pagamento");

        BtCadFormaPgto.setText("Cadastrar Forma de Pagamento");
        BtCadFormaPgto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCadFormaPgtoActionPerformed(evt);
            }
        });

        BtPagar.setText("Pagar");
        BtPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CbPesqContas, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtGerarRelatorio))
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CbFormaPgto, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtCadFormaPgto))
                                    .addComponent(BtPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 121, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtGerarRelatorio)
                    .addComponent(CbPesqContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbFormaPgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCadFormaPgto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGerarRelatorioActionPerformed

    }//GEN-LAST:event_BtGerarRelatorioActionPerformed

    private void TfValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfValorKeyTyped
        valida.limitemaximo(evt, TfValor.getText(), 13);
    }//GEN-LAST:event_TfValorKeyTyped

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
        int linha = TbParcelas.getSelectedRow();
        if (linha > -1) {
            if (linha == 0) {
                if (TbParcelas.getValueAt(linha, 6).toString().equals("PAGA")) {
                    TfValor.setEnabled(false);
                } else {
                    TfValor.setEnabled(true);
                    TfValor.setText(TbParcelas.getValueAt(linha, 1).toString());
                }
            } else {
                if (TbParcelas.getValueAt((linha - 1), 6).toString().equals("PAGA") && !TbParcelas.getValueAt(linha, 6).toString().equals("PAGA")) {
                    TfValor.setEnabled(true);
                    TfValor.setText(TbParcelas.getValueAt(linha, 1).toString());
                } else {
                    TfValor.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_TbParcelasMouseReleased

    private void BtCadFormaPgtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCadFormaPgtoActionPerformed
        final InterfaceFormaPagto tela = new InterfaceFormaPagto(getPrimeiratela(), true, getTelasusuario());
        tela.setVisible(true);
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                preenche.PreencheJComboBox(CbFormaPgto, parcelas.getFormapgto().retornaformapgtocombobox());
            }
        });
    }//GEN-LAST:event_BtCadFormaPgtoActionPerformed

    private void BtPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPagarActionPerformed
        if (TbParcelas.getSelectedRow() > -1 && TfValor.getValue() != BigDecimal.valueOf(0) && TfValor.isEnabled()) {
            if (CbFormaPgto.getSelectedItem() != null) {
                if (Float.parseFloat(TfValor.getValue().toString()) == Float.parseFloat(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 1).toString())) {
                    if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar o pagamento desta parcela?", "Deseja pagar esta parcela?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        ClasseMvtoCaixa mvtocaixa = new ClasseMvtoCaixa();
                        if (mvtocaixa.retornacaixaatual() > Float.parseFloat(TfValor.getValue().toString())) {
                            parcelas.setCodigo(Integer.parseInt(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 0).toString()));
                            parcelas.setVlpago(Float.parseFloat(TfValor.getValue().toString()));
                            parcelas.getFormapgto().setFormapgto(CbFormaPgto.getSelectedItem().toString());
                            parcelas.getFormapgto().setCodigo(parcelas.getFormapgto().retornacodigo());
                            parcelas.pagaparcela();
                            mvtocaixa.setParcela(parcelas);
                            mvtocaixa.setTpmvto("S");
                            mvtocaixa.setVlmvto(Float.parseFloat(TfValor.getValue().toString()));
                            mvtocaixa.setDsmvto("PAGAMENTO DA PARCELA NRO. " + mvtocaixa.getParcela().getCodigo() + " - " + parcelas.getConta().retornadescricaodaconta());
                            mvtocaixa.incluir();
                            TbContasMouseReleased(null);
                        } else {
                            JOptionPane.showMessageDialog(null, "Impossivel realizar o pagamento desta parcela.\nO saldo do caixa e menor que o valor a ser pago!", "Saldo do caixa insuficiente", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else if (Float.parseFloat(TfValor.getValue().toString()) > Float.parseFloat(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 1).toString())) {
                    if (JOptionPane.showConfirmDialog(null, "Este valor e maior que o valor da parcela.\nVoce alega ter recebido acrescimo no valor desta parcela e por isso esta pagando um valor maior?", "Voce recebeu acrescimo no valor da parcela?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        ClasseMvtoCaixa mvtocaixa = new ClasseMvtoCaixa();
                        if (mvtocaixa.retornacaixaatual() > Float.parseFloat(TfValor.getValue().toString())) {
                            parcelas.setCodigo(Integer.parseInt(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 0).toString()));
                            parcelas.setVlpago(Float.parseFloat(TfValor.getValue().toString()));
                            parcelas.getFormapgto().setFormapgto(CbFormaPgto.getSelectedItem().toString());
                            parcelas.getFormapgto().setCodigo(parcelas.getFormapgto().retornacodigo());
                            parcelas.pagaparcela();
                            mvtocaixa.setParcela(parcelas);
                            mvtocaixa.setTpmvto("S");
                            mvtocaixa.setVlmvto(Float.parseFloat(TfValor.getValue().toString()));
                            mvtocaixa.setDsmvto("PAGAMENTO DA PARCELA NRO. " + mvtocaixa.getParcela().getCodigo() + " COM ACRESCIMO NO VALOR DA PARCELA - " + parcelas.getConta().retornadescricaodaconta());
                            mvtocaixa.incluir();
                            TbContasMouseReleased(null);
                        } else {
                            JOptionPane.showMessageDialog(null, "Impossivel realizar o pagamento desta parcela.\nO saldo do caixa e menor que o valor a ser pago!", "Saldo do caixa insuficiente", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else if (JOptionPane.showConfirmDialog(null, "Este valor e menor que o valor da parcela.\nVoce alega ter recebido desconto nesta parcela e por isso esta pagando um valor menor?", "Voce recebeu desconto nesta parcela?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    ClasseMvtoCaixa mvtocaixa = new ClasseMvtoCaixa();
                    if (mvtocaixa.retornacaixaatual() > Float.parseFloat(TfValor.getValue().toString())) {
                        parcelas.setCodigo(Integer.parseInt(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 0).toString()));
                        parcelas.setVlpago(Float.parseFloat(TfValor.getValue().toString()));
                        parcelas.getFormapgto().setFormapgto(CbFormaPgto.getSelectedItem().toString());
                        parcelas.getFormapgto().setCodigo(parcelas.getFormapgto().retornacodigo());
                        parcelas.pagaparcela();
                        mvtocaixa.setParcela(parcelas);
                        mvtocaixa.setTpmvto("S");
                        mvtocaixa.setVlmvto(Float.parseFloat(TfValor.getValue().toString()));
                        mvtocaixa.setDsmvto("PAGAMENTO DA PARCELA NRO. " + mvtocaixa.getParcela().getCodigo() + " COM DESCONTO NO VALOR DA PARCELA - " + parcelas.getConta().retornadescricaodaconta());
                        mvtocaixa.incluir();
                        TbContasMouseReleased(null);
                    } else {
                        JOptionPane.showMessageDialog(null, "Impossivel realizar o pagamento desta parcela.\nO saldo do caixa e menor que o valor a ser pago!", "Saldo do caixa insuficiente", JOptionPane.INFORMATION_MESSAGE);
                    }
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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (TbParcelas.getSelectedRow() > -1) {
            if (TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 6).toString().equals("PAGA")) {
                if (Integer.parseInt(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 0).toString()) != parcelas.retornanumeroultimaparcelavalida()) {
                    if (!TbParcelas.getValueAt(TbParcelas.getSelectedRow() + 1, 5).toString().equals("PAGA")) {
                        if (JOptionPane.showConfirmDialog(null, "Deseja realmente estornar esta parcela?\n"
                                + "(Fazendo isso voce estara retirando do caixa o valor pago nesta parcela)", "Deseja extornar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            parcelas.setCodigo(Integer.parseInt(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 0).toString()));
                            parcelas.setVlpagar(Float.parseFloat(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 2).toString()));
                            parcelas.estornarparcela();
                            parcelas.setVlpagar(Float.parseFloat(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 2).toString()));
                            ClasseMvtoCaixa mvtocaixa = new ClasseMvtoCaixa();
                            mvtocaixa.setParcela(parcelas);
                            mvtocaixa.setTpmvto("E");
                            mvtocaixa.setVlmvto(parcelas.getVlpagar());
                            mvtocaixa.setDsmvto("ESTORNO DA PARCELA NRO. " + mvtocaixa.getParcela().getCodigo() + " - " + parcelas.getConta().retornadescricaodaconta());
                            mvtocaixa.incluir();
                            TbContasMouseReleased(null);
                        }
                    }
                } else {
                    if (JOptionPane.showConfirmDialog(null, "Deseja realmente estornar esta parcela?\n"
                            + "(Fazendo isso voce estara retirando do caixa o valor pago nesta parcela)", "Deseja extornar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        parcelas.setCodigo(Integer.parseInt(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 0).toString()));
                        parcelas.setVlpagar(Float.parseFloat(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 2).toString()));
                        parcelas.estornarparcela();
                        parcelas.setVlpagar(Float.parseFloat(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 2).toString()));
                        ClasseMvtoCaixa mvtocaixa = new ClasseMvtoCaixa();
                        mvtocaixa.setParcela(parcelas);
                        mvtocaixa.setTpmvto("E");
                        mvtocaixa.setVlmvto(parcelas.getVlpagar());
                        mvtocaixa.setDsmvto("ESTORNO DA PARCELA NRO. " + mvtocaixa.getParcela().getCodigo() + " - " + parcelas.getConta().retornadescricaodaconta());
                        mvtocaixa.incluir();
                        TbContasMouseReleased(null);
                    }
                }
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void CbPesqContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPesqContasActionPerformed
        limpar.Limpar(TbContas);
        limpar.Limpar(TbParcelas);
        switch (CbPesqContas.getSelectedIndex()) {
            case 0: {
                preenche.PreencherJtable(TbContas, parcelas.getConta().contaspagarabertasevencidas());
                break;
            }
            case 1: {
                preenche.PreencherJtable(TbContas, parcelas.getConta().contaspagaraberta());
                break;
            }
            case 2: {
                preenche.PreencherJtable(TbContas, parcelas.getConta().contaspagarvencidas());
                break;
            }
            case 3: {
                preenche.PreencherJtable(TbContas, parcelas.getConta().contaspagardomes());
                break;
            }
            case 4: {
                preenche.PreencherJtable(TbContas, parcelas.getConta().contaspagardomesanterior());
                break;
            }
            case 5: {
                preenche.PreencherJtable(TbContas, parcelas.getConta().contaspagardoano());
                break;
            }
            case 6: {
                preenche.PreencherJtable(TbContas, parcelas.getConta().todascontaspagar());
                break;
            }
        }
    }//GEN-LAST:event_CbPesqContasActionPerformed

    private void ItMnDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItMnDetalhesActionPerformed
        if (TbContas.getSelectedRow() > -1) {
            final ConsulSimplesDetalhesOperacao tela = new ConsulSimplesDetalhesOperacao(getPrimeiratela(), true, parcelas);
            tela.setVisible(true);
            tela.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    
                }
            });
        }
    }//GEN-LAST:event_ItMnDetalhesActionPerformed

    private void ItMnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItMnCancelarActionPerformed
        if (!parcelapaga()) {
            if (JOptionPane.showConfirmDialog(null, "Voce esta prestes a cancelar esta conta.\nCaso haja produtos envolvidos nessa operacao, a situacao do estoque sera revertido!\n\nTem certeza que deseja cancelar?", "Deseja cancelar operacao?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                parcelas.getConta().retornainformacoesconta();
                if (parcelas.getConta().getCompravenda().getCodigo() != 0) {
                    parcelas.getConta().getCompravenda().getOperacao().retornaoperacao();
                    ClasseProdutosCompraVenda prodcompravenda = new ClasseProdutosCompraVenda();
                    prodcompravenda.setCompravenda(parcelas.getConta().getCompravenda());
                    if (prodcompravenda.getCompravenda().getOperacao().getTpestoque().equals("E")) {
                        if (!prodcompravenda.houveretiradadosprodutosenvolvidos()) {
                            parcelas.getConta().cancelarconta();
                            prodcompravenda.getCompravenda().cancelarcompravenda();
                            prodcompravenda.reverterestoqueprodutos();
                            CbPesqContasActionPerformed(evt);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nao e possivel realizar o cancelamento desta operacao!\nOs produtos que entraram no estoque tem registro de saida.", "Cancelamento de operacao nao permitido", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        parcelas.getConta().cancelarconta();
                        prodcompravenda.getCompravenda().cancelarcompravenda();
                        prodcompravenda.reverterestoqueprodutos();
                        CbPesqContasActionPerformed(evt);
                    }
                } else {
                    parcelas.getConta().cancelarconta();
                    CbPesqContasActionPerformed(evt);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Faca estorno de todas as parcelas desta conta para que o cancelamento seja realizado!", "Existem parcelas pagas", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ItMnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCadFormaPgto;
    private javax.swing.JButton BtGerarRelatorio;
    private javax.swing.JButton BtPagar;
    private javax.swing.JComboBox CbFormaPgto;
    private javax.swing.JComboBox CbPesqContas;
    private javax.swing.JMenuItem ItMnCancelar;
    private javax.swing.JMenuItem ItMnDetalhes;
    private javax.swing.JPopupMenu PopDetalhes;
    private javax.swing.JTable TbContas;
    private javax.swing.JTable TbParcelas;
    private JNumberField.JNumberField TfValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public void analisausuario() {
        getTelasusuario().getTela().setCodigo(18);
        if (!getTelasusuario().eadmintela()) {
            BtPagar.setVisible(false);
        }

        getTelasusuario().getTela().setCodigo(7);
        if (!getTelasusuario().eadmintela()) {
            BtCadFormaPgto.setVisible(false);
        }
    }

    public boolean parcelapaga() {
        for (int i = 0; i < TbParcelas.getRowCount(); i++) {
            if (TbParcelas.getValueAt(i, 6).toString().equals("PAGA")) {
                return true;
            }
        }
        return false;
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
