/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojadafatima.InterfacesProduto;

import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.LimpaCamposTela;
import br.com.lojadafatima.ClassesFerramentas.NaoPermiteAspasSimples;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.Produto.ClasseTipoProduto;
import br.com.lojadafatima.Usuario.ClasseTelasUsuario;
import java.math.BigDecimal;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class InterfaceTipoProduto extends javax.swing.JDialog {

    private java.awt.Frame primeiratela;
    Preenche preenche = new Preenche();
    LimpaCamposTela limpa = new LimpaCamposTela();
    ClasseTipoProduto tipoproduto = new ClasseTipoProduto();
    GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();
    private ClasseTelasUsuario telasusuario = new ClasseTelasUsuario();

    public InterfaceTipoProduto(java.awt.Frame telaorigem, boolean modal, ClasseTelasUsuario usuario) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setTelasusuario(usuario);
        analisausuario();

        int[] tam = new int[3];
        tam[0] = 50;
        tam[1] = 200;
        tam[2] = 50;
        preenche.FormataJtable(TbConsulta, tam);
        preenche.PreencherJtable(TbConsulta, tipoproduto.buscartiposproduto());
        preenche.FormataJtable(TbCarcTipoProduto, tam);

        valida.validacamposCancelar(jPanel1, PnBotoes);
        TbConsulta.setEnabled(true);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        TbCarcTipoProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TbConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TfTipoProduto.setDocument(new NaoPermiteAspasSimples());
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
        MnItCarregarDados = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TfTipoProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbCaracteristicas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbCarcTipoProduto = new javax.swing.JTable();
        PnBotoes = new javax.swing.JPanel();
        BtIncluir = new javax.swing.JButton();
        BtAlterar = new javax.swing.JButton();
        BtGravar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TbConsulta = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        BtCadTabela = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        TfPercentLucro = new JNumberField.JNumberField(2);
        ;
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        LbNotificacoes = new javax.swing.JLabel();

        MnItCarregarDados.setText("Carregar dados");
        MnItCarregarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnItCarregarDadosActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnItCarregarDados);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tipo de Produto - Software Loja da Fátima");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Código");

        TfCodigo.setEditable(false);

        jLabel2.setText("Tipo de Produto*");

        TfTipoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfTipoProdutoKeyTyped(evt);
            }
        });

        TbCaracteristicas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Código", "Característica"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbCaracteristicas.getTableHeader().setReorderingAllowed(false);
        TbCaracteristicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TbCaracteristicasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TbCaracteristicas);
        if (TbCaracteristicas.getColumnModel().getColumnCount() > 0) {
            TbCaracteristicas.getColumnModel().getColumn(0).setResizable(false);
            TbCaracteristicas.getColumnModel().getColumn(1).setResizable(false);
            TbCaracteristicas.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel3.setText("Características cadastradas:");

        jLabel4.setText("Características do Tipo de Produto*:");

        TbCarcTipoProduto.setModel(new javax.swing.table.DefaultTableModel(
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
        TbCarcTipoProduto.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TbCarcTipoProduto);
        if (TbCarcTipoProduto.getColumnModel().getColumnCount() > 0) {
            TbCarcTipoProduto.getColumnModel().getColumn(0).setResizable(false);
            TbCarcTipoProduto.getColumnModel().getColumn(1).setResizable(false);
        }

        BtIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/adicionar.png"))); // NOI18N
        BtIncluir.setText("Novo Tipo de Produto");
        BtIncluir.setName("Incluir"); // NOI18N
        BtIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIncluirActionPerformed(evt);
            }
        });

        BtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/editar.png"))); // NOI18N
        BtAlterar.setText("Alterar Dados");
        BtAlterar.setName("Alterar"); // NOI18N
        BtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarActionPerformed(evt);
            }
        });

        BtGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/salvar.png"))); // NOI18N
        BtGravar.setText("Gravar");
        BtGravar.setName("Gravar"); // NOI18N
        BtGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGravarActionPerformed(evt);
            }
        });

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/cancelar.png"))); // NOI18N
        BtCancelar.setText("Cancelar");
        BtCancelar.setName("Cancelar"); // NOI18N
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });

        BtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/lixeira.png"))); // NOI18N
        BtExcluir.setText("Excluir");
        BtExcluir.setName("Excluir"); // NOI18N
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnBotoesLayout = new javax.swing.GroupLayout(PnBotoes);
        PnBotoes.setLayout(PnBotoesLayout);
        PnBotoesLayout.setHorizontalGroup(
            PnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(PnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnBotoesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(BtIncluir)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(BtAlterar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        PnBotoesLayout.setVerticalGroup(
            PnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BtExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addGroup(PnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnBotoesLayout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addGroup(PnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BtIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(BtAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(1, 1, 1))
                .addComponent(BtCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        jLabel5.setText("Tipos de Produto Cadastrados:");

        TbConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo de Produto", "Percentual de lucro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbConsulta.setComponentPopupMenu(jPopupMenu1);
        TbConsulta.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TbConsulta);
        if (TbConsulta.getColumnModel().getColumnCount() > 0) {
            TbConsulta.getColumnModel().getColumn(0).setResizable(false);
            TbConsulta.getColumnModel().getColumn(1).setResizable(false);
        }

        BtCadTabela.setText("Cadastrar Característica");
        BtCadTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCadTabelaActionPerformed(evt);
            }
        });

        jLabel6.setText("Percentual de lucro");

        TfPercentLucro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfPercentLucroKeyTyped(evt);
            }
        });

        jCheckBox1.setText("É Serviço");

        LbNotificacoes.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(LbNotificacoes)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LbNotificacoes)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TfTipoProduto))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfPercentLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtCadTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(PnBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfPercentLucro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtCadTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIncluirActionPerformed
        valida.validacamposCadastrar(jPanel1, PnBotoes);
        limpa.Limpar(TbCarcTipoProduto);
        limpa.Limpar(jPanel1);

        int[] tam2 = new int[3];
        tam2[0] = 30;
        tam2[1] = 50;
        tam2[2] = 200;
        preenche.FormataJtable(TbCaracteristicas, tam2);
        preenche.PreencheJtableSEL(TbCaracteristicas, tipoproduto.getTabela().buscartabelascomboolean());
        TbConsulta.setEnabled(false);
    }//GEN-LAST:event_BtIncluirActionPerformed

    private void MnItCarregarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnItCarregarDadosActionPerformed
        int index = TbConsulta.getSelectedRow();
        if (index > -1) {
            TfCodigo.setText(TbConsulta.getValueAt(index, 0).toString());
            tipoproduto.setCodigo(Integer.parseInt(TbConsulta.getValueAt(index, 0).toString()));
            TfTipoProduto.setText(TbConsulta.getValueAt(index, 1).toString());
            TfPercentLucro.setValue(BigDecimal.valueOf(tipoproduto.retornapercentuallucro()));
            preenche.PreencherJtable(TbCarcTipoProduto, tipoproduto.buscartabelasdotipoproduto());
        }
    }//GEN-LAST:event_MnItCarregarDadosActionPerformed

    private void BtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGravarActionPerformed
        if (!TfTipoProduto.getText().equals("")) {
            if (TbCarcTipoProduto.getRowCount() >= 1) {
                if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja gravar os dados deste tipo de produto?", "Deseja gravar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    tipoproduto.setTipoproduto(TfTipoProduto.getText());
                    tipoproduto.setPercentlucro(Float.parseFloat(TfPercentLucro.getValue().toString()));
                    if (TfCodigo.getText().equals("")) {
                        tipoproduto.incluir();
                        for (int i = 0; i < TbCarcTipoProduto.getRowCount(); i++) {
                            tipoproduto.getTabela().setCodigo(Integer.parseInt(TbCarcTipoProduto.getValueAt(i, 0).toString()));
                            tipoproduto.incluirtabela();
                        }
                    } else {
                        tipoproduto.setCodigo(Integer.parseInt(TfCodigo.getText()));
                        tipoproduto.alterar();
                        tipoproduto.excluirtabelastipoproduto();
                        for (int i = 0; i < TbCarcTipoProduto.getRowCount(); i++) {
                            tipoproduto.getTabela().setCodigo(Integer.parseInt(TbCarcTipoProduto.getValueAt(i, 0).toString()));
                            tipoproduto.incluirtabela();
                        }
                    }
                    preenche.PreencherJtable(TbConsulta, tipoproduto.buscartiposproduto());
                    valida.validacamposCancelar(jPanel1, PnBotoes);
                    TbConsulta.setEnabled(true);
                    limpa.Limpar(jPanel1);
                    limpa.Limpar(TbCaracteristicas);
                    limpa.Limpar(TbCarcTipoProduto);
                } else {
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Insira Caracteristicas no Tipo de Produto!", "Campos Obrigatorios", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Digite o nome do Tipo de Produto!", "Campos Obrigatorios", JOptionPane.INFORMATION_MESSAGE);
            TfTipoProduto.grabFocus();
        }
    }//GEN-LAST:event_BtGravarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed
        limpa.Limpar(TbCaracteristicas);
        limpa.Limpar(TbCarcTipoProduto);
        limpa.Limpar(jPanel1);
        valida.validacamposCancelar(jPanel1, PnBotoes);
        TbConsulta.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed
        if (!TfCodigo.getText().equals("")) {
            tipoproduto.setCodigo(Integer.parseInt(TfCodigo.getText()));
            if (!tipoproduto.tipoprodutocomproduto()) {
                valida.validacamposCadastrar(jPanel1, PnBotoes);

                int[] tam2 = new int[3];
                tam2[0] = 30;
                tam2[1] = 50;
                tam2[2] = 200;
                preenche.FormataJtable(TbCaracteristicas, tam2);
                preenche.PreencheJtableSEL(TbCaracteristicas, tipoproduto.getTabela().buscartabelascomboolean());
                for (int i = 0; i < TbCarcTipoProduto.getRowCount(); i++) {
                    for (int j = 0; j < TbCaracteristicas.getRowCount(); j++) {
                        if (Integer.parseInt(TbCaracteristicas.getValueAt(j, 1).toString()) == Integer.parseInt(TbCarcTipoProduto.getValueAt(i, 0).toString())) {
                            TbCaracteristicas.setValueAt((true), j, 0);
                        }
                    }
                }
                TbConsulta.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Nao e possivel alterar os dados deste tipo de produto.\n"
                        + "Ja existem produtos cadastrados no sistema utilizando este tipo de produto!", "Operacao interrompida", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um Tipo de Produto na tabela abaixo para realizar alteracoes!", "Campos Obrigatorios", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtAlterarActionPerformed

    private void TfTipoProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfTipoProdutoKeyTyped
        valida.limitemaximo(evt, TfTipoProduto.getText(), 70);
    }//GEN-LAST:event_TfTipoProdutoKeyTyped

    private void BtCadTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCadTabelaActionPerformed
        final InterfaceTabelas tela = new InterfaceTabelas(getPrimeiratela(), true, getTelasusuario());
        tela.setVisible(true);
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                preenche.PreencheJtableSEL(TbCaracteristicas, tipoproduto.getTabela().buscartabelascomboolean());
                for (int i = 0; i < TbCarcTipoProduto.getRowCount(); i++) {
                    for (int j = 0; j < TbCaracteristicas.getRowCount(); j++) {
                        if (Integer.parseInt(TbCaracteristicas.getValueAt(j, 1).toString()) == Integer.parseInt(TbCarcTipoProduto.getValueAt(i, 0).toString())) {
                            TbCaracteristicas.setValueAt((true), j, 0);
                        }
                    }
                }
            }
        });
    }//GEN-LAST:event_BtCadTabelaActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed
        if (!TfCodigo.getText().equals("")) {
            tipoproduto.setCodigo(Integer.parseInt(TfCodigo.getText()));
            if (!tipoproduto.tipoprodutocomproduto()) {
                if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja EXCLUIR os dados deste tipo de produto?", "Deseja excluir?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    tipoproduto.excluir();
                    preenche.PreencherJtable(TbConsulta, tipoproduto.buscartiposproduto());
                    valida.validacamposCancelar(jPanel1, PnBotoes);
                    TbConsulta.setEnabled(true);
                    limpa.Limpar(jPanel1);
                    limpa.Limpar(TbCaracteristicas);
                    limpa.Limpar(TbCarcTipoProduto);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nao e possivel excluir os dados deste tipo de produto.\n"
                        + "Ja existem produtos cadastrados no sistema utilizando este tipo de produto!", "Operacao interrompida", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um Tipo de Produto na tabela abaixo para realizar alteracoes!", "Campos Obrigatorios", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void TbCaracteristicasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbCaracteristicasMouseReleased
        if (TbCaracteristicas.getSelectedRow() > -1) {
            DefaultTableModel tabela = (DefaultTableModel) TbCarcTipoProduto.getModel();
            boolean sel = (Boolean) TbCaracteristicas.getValueAt(TbCaracteristicas.getSelectedRow(), 0);
            if (sel) {
                boolean inclui = true;
                for (int i = 0; i < tabela.getRowCount(); i++) {
                    if (Integer.parseInt(tabela.getValueAt(i, 0).toString()) == Integer.parseInt(TbCaracteristicas.getValueAt(TbCaracteristicas.getSelectedRow(), 1).toString())) {
                        inclui = false;
                    }
                }
                if (inclui) {
                    int linhas = tabela.getRowCount();
                    tabela.setNumRows(linhas + 1);
                    tabela.setValueAt(TbCaracteristicas.getValueAt(TbCaracteristicas.getSelectedRow(), 1), linhas, 0);
                    tabela.setValueAt(TbCaracteristicas.getValueAt(TbCaracteristicas.getSelectedRow(), 2), linhas, 1);
                }
            } else {
                for (int i = 0; i < tabela.getRowCount(); i++) {
                    if (Integer.parseInt(tabela.getValueAt(i, 0).toString()) == Integer.parseInt(TbCaracteristicas.getValueAt(TbCaracteristicas.getSelectedRow(), 1).toString())) {
                        tabela.removeRow(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_TbCaracteristicasMouseReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(PnBotoes.isVisible() && BtGravar.isEnabled()){
            if(JOptionPane.showConfirmDialog(null, "Voce esta prestes a fechar esta janela.\nAo fechar esta janela tudo que voce digitou sera esquecido!", "Tem certeza que deseja fechar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                dispose();
            }
        }else{
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void TfPercentLucroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfPercentLucroKeyTyped
        valida.limitemaximo(evt, TfPercentLucro.getText(), 10);
    }//GEN-LAST:event_TfPercentLucroKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCadTabela;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtGravar;
    private javax.swing.JButton BtIncluir;
    private javax.swing.JLabel LbNotificacoes;
    private javax.swing.JMenuItem MnItCarregarDados;
    private javax.swing.JPanel PnBotoes;
    private javax.swing.JTable TbCaracteristicas;
    private javax.swing.JTable TbCarcTipoProduto;
    private javax.swing.JTable TbConsulta;
    private javax.swing.JTextField TfCodigo;
    private JNumberField.JNumberField TfPercentLucro;
    private javax.swing.JTextField TfTipoProduto;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public void analisausuario(){
//        getTelasusuario().getTela().setCodigo(12);
//        if(!getTelasusuario().eadmintela()){
//            PnBotoes.setVisible(false);
//        }
//        
//        getTelasusuario().getTela().setCodigo(13);
//        if(!getTelasusuario().eadmintela()){
//            BtCadTabela.setVisible(false);
//        }
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
