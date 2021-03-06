package br.com.lojadafatima.InterfacesOperacoes;

import br.com.lojadafatima.ClassesFerramentas.ClasseDatas;
import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.LimpaCamposTela;
import br.com.lojadafatima.ClassesFerramentas.MensagensUsuario;
import br.com.lojadafatima.ClassesFerramentas.NaoPermiteAspasSimples;
import br.com.lojadafatima.ClassesFerramentas.PermiteApenasNumeros;
import br.com.lojadafatima.CompraVendaOperacoes.ClasseOperacoes;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import br.com.lojadafatima.Financeiro.ClasseContasPagarReceber;
import br.com.lojadafatima.Financeiro.ClasseParcelas;
import br.com.lojadafatima.InterfaceConsultaSimples.ConsulSimplesCliente;
import br.com.lojadafatima.InterfaceConsultaSimples.ConsulSimplesCondicaoPgto;
import br.com.lojadafatima.InterfaceConsultaSimples.ConsulSimplesFornecedor;
import br.com.lojadafatima.InterfacesFinanceiro.InterfaceCondicaoPagto;
import br.com.lojadafatima.InterfacesPessoa.InterfaceCliente;
import br.com.lojadafatima.InterfacesPessoa.InterfaceFornecedor;
import br.com.lojadafatima.Pessoa.ClasseCliente;
import br.com.lojadafatima.Pessoa.ClasseFornecedor;
import br.com.lojadafatima.Usuario.ClasseTelasUsuario;
import java.math.BigDecimal;
import java.util.HashMap;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author hp
 */
public class InterfaceOperacaoFinanceiro extends javax.swing.JDialog {

    ClasseParcelas parcelas = new ClasseParcelas();
    GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();
    LimpaCamposTela limpar = new LimpaCamposTela();
    MaskFormatter data, valor;
    ClasseDatas datas = new ClasseDatas();
    private java.awt.Frame primeiratela;
    ClasseCliente cliente = new ClasseCliente();
    ClasseFornecedor fornecedor = new ClasseFornecedor();
    private ClasseTelasUsuario telasusuario = new ClasseTelasUsuario();
    MensagensUsuario msg = new MensagensUsuario();

    public InterfaceOperacaoFinanceiro(java.awt.Frame telaorigem, boolean modal, ClasseOperacoes ope, ClasseTelasUsuario usuario) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setTelasusuario(usuario);
        parcelas.getConta().setOperacao(ope);
        TfCodCondicaoPgto.setDocument(new PermiteApenasNumeros());
        TfDescOperacao.setDocument(new NaoPermiteAspasSimples());
        valida.validacamposCancelar(jPanel1, PnBotoes);
        analisausuario();
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TfCodigo = new javax.swing.JTextField();
        try{
            data = new MaskFormatter("##/##/####");
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Nao foi possivel montar mascara no campo de Data");
        }
        TfData = new JFormattedTextField(data);
        jLabel2 = new javax.swing.JLabel();
        TfDescOperacao = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TfCodCondicaoPgto = new javax.swing.JTextField();
        BtPesqCondicaoPgto = new javax.swing.JButton();
        TfCondicaoPgto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        BtCadCondicaoPgto = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        TfValorTotal = new JNumberField.JNumberField();
        PnBotoes = new javax.swing.JPanel();
        BtGravar = new javax.swing.JButton();
        BtIncluir = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        TfCodPessoa = new javax.swing.JTextField();
        LbCodPessoa = new javax.swing.JLabel();
        CbPessoa = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        LbNomePessoa = new javax.swing.JLabel();
        BtPesqPessoa = new javax.swing.JButton();
        TfPessoa = new javax.swing.JTextField();
        BtCadPessoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        LbNotificacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Operação de Financeiro - Software Loja da Fátima");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Código");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        TfCodigo.setEditable(false);
        jPanel1.add(TfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 80, -1));

        TfData.setEditable(false);
        jPanel1.add(TfData, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 31, 79, -1));

        jLabel2.setText("Data");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 11, -1, -1));

        TfDescOperacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfDescOperacaoKeyTyped(evt);
            }
        });
        jPanel1.add(TfDescOperacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 31, 412, -1));

        jLabel18.setText("Descrição da Operação");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 11, -1, -1));

        jLabel7.setText("Cód. Condição de Pagamento");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 159, -1, -1));

        TfCodCondicaoPgto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TfCodCondicaoPgtoFocusLost(evt);
            }
        });
        TfCodCondicaoPgto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TfCodCondicaoPgtoKeyReleased(evt);
            }
        });
        jPanel1.add(TfCodCondicaoPgto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 87, -1));

        BtPesqCondicaoPgto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/buscar.png"))); // NOI18N
        BtPesqCondicaoPgto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPesqCondicaoPgtoActionPerformed(evt);
            }
        });
        jPanel1.add(BtPesqCondicaoPgto, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 179, -1, -1));

        TfCondicaoPgto.setEditable(false);
        jPanel1.add(TfCondicaoPgto, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 180, 230, -1));

        jLabel8.setText("Condição de Pagamento");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 159, -1, -1));

        BtCadCondicaoPgto.setText("Cadastrar Condição de Pagamento");
        BtCadCondicaoPgto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCadCondicaoPgtoActionPerformed(evt);
            }
        });
        jPanel1.add(BtCadCondicaoPgto, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 179, -1, -1));

        jLabel16.setText("Valor Total da Operação");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        TfValorTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfValorTotalKeyTyped(evt);
            }
        });
        jPanel1.add(TfValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 100, -1));

        BtGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/salvar.png"))); // NOI18N
        BtGravar.setText("Gravar");
        BtGravar.setName("Gravar"); // NOI18N
        BtGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGravarActionPerformed(evt);
            }
        });

        BtIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/adicionar.png"))); // NOI18N
        BtIncluir.setText("Nova Operação");
        BtIncluir.setName("Incluir"); // NOI18N
        BtIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIncluirActionPerformed(evt);
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

        javax.swing.GroupLayout PnBotoesLayout = new javax.swing.GroupLayout(PnBotoes);
        PnBotoes.setLayout(PnBotoesLayout);
        PnBotoesLayout.setHorizontalGroup(
            PnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnBotoesLayout.createSequentialGroup()
                .addComponent(BtIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PnBotoesLayout.setVerticalGroup(
            PnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(BtCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BtGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(PnBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 261, 583, -1));

        TfCodPessoa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TfCodPessoaFocusLost(evt);
            }
        });
        TfCodPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TfCodPessoaKeyReleased(evt);
            }
        });
        jPanel1.add(TfCodPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 124, 87, -1));

        LbCodPessoa.setText("Cód. Pessoa");
        jPanel1.add(LbCodPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 103, -1, -1));

        CbPessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cliente", "Fornecedor" }));
        CbPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPessoaActionPerformed(evt);
            }
        });
        jPanel1.add(CbPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 77, 184, -1));

        jLabel5.setText("Quem está envolvido nesta operação?");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 57, -1, -1));

        LbNomePessoa.setText("Nome/Nome Fantasia");
        jPanel1.add(LbNomePessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 103, -1, -1));

        BtPesqPessoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/buscar.png"))); // NOI18N
        BtPesqPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPesqPessoaActionPerformed(evt);
            }
        });
        jPanel1.add(BtPesqPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 123, -1, -1));

        TfPessoa.setEditable(false);
        jPanel1.add(TfPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 124, 230, -1));

        BtCadPessoa.setText("Cadastrar Cliente");
        BtCadPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCadPessoaActionPerformed(evt);
            }
        });
        jPanel1.add(BtCadPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 123, 199, -1));

        LbNotificacao.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(LbNotificacao)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LbNotificacao)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 305, 583, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TfDescOperacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfDescOperacaoKeyTyped
        valida.limitemaximo(evt, TfDescOperacao.getText(), 50);
    }//GEN-LAST:event_TfDescOperacaoKeyTyped

    private void TfCodCondicaoPgtoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCodCondicaoPgtoKeyReleased
        if (!TfCodCondicaoPgto.getText().equals("")) {
            parcelas.getConta().getCompravenda().getCondicao().setCodigo(Integer.parseInt(TfCodCondicaoPgto.getText()));
            TfCondicaoPgto.setText(parcelas.getConta().getCompravenda().getCondicao().retornadescricaocondicao());
        } else {
            TfCondicaoPgto.setText("");
        }
    }//GEN-LAST:event_TfCodCondicaoPgtoKeyReleased

    private void BtPesqCondicaoPgtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPesqCondicaoPgtoActionPerformed
        final ConsulSimplesCondicaoPgto tela = new ConsulSimplesCondicaoPgto(getPrimeiratela(), true, parcelas.getConta().getCompravenda().getCondicao());
        tela.setVisible(true);
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                if (parcelas.getConta().getCompravenda().getCondicao().getCodigo() == 0) {
                    TfCodCondicaoPgto.setText("");
                } else {
                    TfCodCondicaoPgto.setText("" + parcelas.getConta().getCompravenda().getCondicao().getCodigo());
                }
                TfCodCondicaoPgtoKeyReleased(null);
            }
        });
    }//GEN-LAST:event_BtPesqCondicaoPgtoActionPerformed

    private void BtCadCondicaoPgtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCadCondicaoPgtoActionPerformed
        final InterfaceCondicaoPagto tela = new InterfaceCondicaoPagto(getPrimeiratela(), true, getTelasusuario());
        tela.setVisible(true);
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {

            }
        });
    }//GEN-LAST:event_BtCadCondicaoPgtoActionPerformed

    private void BtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGravarActionPerformed
        if (camposobrigatoriospreenchidos()) {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Gravar esta operação e de que todas as informações estao corretas?", "Deseja gravar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                enviardados();
                parcelas.getConta().incluir();

                parcelas.gerarparcelas();

                final InterfaceAjusteDatasEPrecos tela = new InterfaceAjusteDatasEPrecos(getPrimeiratela(), true, parcelas);
                tela.setVisible(true);
                tela.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosed(java.awt.event.WindowEvent evt) {
                        HashMap filtro = new HashMap();
                        filtro.put("CD_OPERACAO", parcelas.getConta().getOperacao().getCodigo());
                        filtro.put("CD_CONTA", parcelas.getConta().getCodigo());
                        filtro.put("DS_NOTA", "EXTRATO DE COMPRA");
                        if(CbPessoa.getSelectedItem().toString().equals("Fornecedor")) filtro.put("TP_PESSOA", "Fornecedor:");
                        else                                                           filtro.put("TP_PESSOA", "Cliente:");
                        ConexaoPostgre conexao = new ConexaoPostgre();
                        JDialog dialog = new JDialog(new javax.swing.JFrame(), "Visualização - Software Loja da Fátima", true);
                        dialog.setSize(1000, 700);
                        dialog.setLocationRelativeTo(null);
                        try {
                            JasperPrint print = JasperFillManager.fillReport("relatorios\\notaoperacaofinanceiro.jasper", filtro, conexao.conecta());
                            
                            JasperViewer viewer = new JasperViewer(print, true);
                            dialog.getContentPane().add(viewer.getContentPane());
                            dialog.setVisible(true);
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                });

                limpar.Limpar(jPanel1);
                valida.validacamposCancelar(jPanel1, PnBotoes);
            }
        }
    }//GEN-LAST:event_BtGravarActionPerformed

    private void BtIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIncluirActionPerformed
        TfData.setText(datas.retornadataatual());
        GeraCodigos geracodigos = new GeraCodigos();
        TfDescOperacao.setText(parcelas.getConta().getOperacao().getDescricao());
        TfCodigo.setText("" + geracodigos.gerasequencia("CONTAS_PAGAR_RECEBER", "CD_CONTA", "CD_OPERACAO", parcelas.getConta().getOperacao().getCodigo()));
        valida.validacamposCadastrar(jPanel1, PnBotoes);
    }//GEN-LAST:event_BtIncluirActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar esta operação?\n"
            + "(Caso sim, TODOS os dados digitados serão limpos da tela)", "Deseja cancelar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        limpar.Limpar(jPanel1);
        valida.validacamposCancelar(jPanel1, PnBotoes);
        }
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void TfCodPessoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCodPessoaKeyReleased
        if (CbPessoa.getSelectedItem().toString().equals("Cliente")) {
            if (!TfCodPessoa.getText().equals("")) {
                cliente.setCodigo(Integer.parseInt(TfCodPessoa.getText()));
                if (cliente.eativo()) {
                    TfPessoa.setText(cliente.retornanomecliente());
                } else {
                    TfPessoa.setText("");
                }
            } else {
                TfPessoa.setText("");
            }
        } else {
            if (!TfCodPessoa.getText().equals("")) {
                fornecedor.setCodigo(Integer.parseInt(TfCodPessoa.getText()));
                if (fornecedor.efornecedorativo()) {
                    fornecedor.getPessoajur().getPessoa().setCodigo(fornecedor.retornacodigopessoafornecedor());
                    TfPessoa.setText(fornecedor.getPessoajur().retornanomeporCodigo());
                } else {
                    TfPessoa.setText("");
                }
            } else {
                TfPessoa.setText("");
            }
        }
    }//GEN-LAST:event_TfCodPessoaKeyReleased

    private void CbPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPessoaActionPerformed
        if (CbPessoa.getSelectedItem().toString().equals("Cliente")) {
            LbCodPessoa.setText("Cód. Cliente");
            LbNomePessoa.setText("Cliente");
            BtCadPessoa.setText("Cadastrar Cliente");
        } else {
            LbCodPessoa.setText("Cód. Fornecedor");
            LbNomePessoa.setText("Fornecedor");
            BtCadPessoa.setText("Cadastrar Fornecedor");
        }
        analisausuario();
        TfCodPessoaKeyReleased(null);
    }//GEN-LAST:event_CbPessoaActionPerformed

    private void BtPesqPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPesqPessoaActionPerformed
        if (CbPessoa.getSelectedItem().toString().equals("Cliente")) {
            final ConsulSimplesCliente tela = new ConsulSimplesCliente(getPrimeiratela(), true, cliente);
            tela.setVisible(true);
            tela.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if (cliente.getCodigo() != 0) {
                        TfCodPessoa.setText("" + cliente.getCodigo());
                        TfCodPessoaKeyReleased(null);
                    } else {
                        TfCodPessoa.setText("");
                        TfPessoa.setText("");
                    }
                }
            });
        } else {
            final ConsulSimplesFornecedor tela = new ConsulSimplesFornecedor(getPrimeiratela(), true, fornecedor);
            tela.setVisible(true);
            tela.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    if (fornecedor.getCodigo() != 0) {
                        TfCodPessoa.setText("" + fornecedor.getCodigo());
                        TfCodPessoaKeyReleased(null);
                    } else {
                        TfCodPessoa.setText("");
                        TfPessoa.setText("");
                    }
                }
            });
        }
    }//GEN-LAST:event_BtPesqPessoaActionPerformed

    private void BtCadPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCadPessoaActionPerformed
        if (CbPessoa.getSelectedItem().toString().equals("Cliente")) {
            final InterfaceCliente tela = new InterfaceCliente(getPrimeiratela(), true, getTelasusuario());
            tela.setVisible(true);
            tela.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent evt) {

                }
            });
        } else {
            final InterfaceFornecedor tela = new InterfaceFornecedor(getPrimeiratela(), true, getTelasusuario());
            tela.setVisible(true);
            tela.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent evt) {

                }
            });
        }
    }//GEN-LAST:event_BtCadPessoaActionPerformed

    private void TfValorTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfValorTotalKeyTyped
        valida.limitemaximo(evt, TfValorTotal.getText(), 13);
    }//GEN-LAST:event_TfValorTotalKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(PnBotoes.isVisible() && BtGravar.isEnabled()){
            if(JOptionPane.showConfirmDialog(null, "Você está prestes a fechar esta janela.\nAo fechar esta janela tudo que voce digitou será esquecido!", "Tem certeza que deseja fechar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                dispose();
            }
        }else{
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void TfCodCondicaoPgtoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TfCodCondicaoPgtoFocusLost
        if(TfCondicaoPgto.getText().equals("")){
            TfCodCondicaoPgto.setText("");
        }
    }//GEN-LAST:event_TfCodCondicaoPgtoFocusLost

    private void TfCodPessoaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TfCodPessoaFocusLost
        if(TfPessoa.getText().equals("")){
            TfCodPessoa.setText("");
        }else{
            if (parcelas.getConta().getOperacao().getTpfinanceiro().equals("E")) {
                ClasseContasPagarReceber contas = new ClasseContasPagarReceber();
                if(CbPessoa.getSelectedItem().toString().equals("Fornecedor")){
                    ClasseFornecedor forn2 = new ClasseFornecedor();
                    forn2.setCodigo(Integer.parseInt(TfCodPessoa.getText()));
                    contas.setCodigopessoa(forn2.retornacodigopessoafornecedor());
                }else{
                    ClasseCliente cliente2 = new ClasseCliente();
                    cliente2.setCodigo(Integer.parseInt(TfCodPessoa.getText()));
                    contas.setCodigopessoa(cliente2.retornacodigopessoacliente());
                }
                if (contas.epessoainadimplente()) {
                    if (JOptionPane.showConfirmDialog(null, "Existem contas à receber em aberto ou vencidas desta pessoa, deseja continuar?", "Pessoa inadimplente", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                        TfCodPessoa.setText("");
                        TfCodPessoaKeyReleased(null);
                    }
                }
            }
        }
    }//GEN-LAST:event_TfCodPessoaFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCadCondicaoPgto;
    private javax.swing.JButton BtCadPessoa;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtGravar;
    private javax.swing.JButton BtIncluir;
    private javax.swing.JButton BtPesqCondicaoPgto;
    private javax.swing.JButton BtPesqPessoa;
    private javax.swing.JComboBox CbPessoa;
    private javax.swing.JLabel LbCodPessoa;
    private javax.swing.JLabel LbNomePessoa;
    private javax.swing.JLabel LbNotificacao;
    private javax.swing.JPanel PnBotoes;
    private javax.swing.JTextField TfCodCondicaoPgto;
    private javax.swing.JTextField TfCodPessoa;
    private javax.swing.JTextField TfCodigo;
    private javax.swing.JTextField TfCondicaoPgto;
    private javax.swing.JFormattedTextField TfData;
    private javax.swing.JTextField TfDescOperacao;
    private javax.swing.JTextField TfPessoa;
    private JNumberField.JNumberField TfValorTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public void analisausuario(){
        if(CbPessoa.getSelectedItem().toString().equals("Cliente")){
            getTelasusuario().getTela().setCodigo(1);
            if(!getTelasusuario().eadmintela()){
                BtCadPessoa.setVisible(false);
            }else{
                BtCadPessoa.setVisible(true);
            }
        }else{
            getTelasusuario().getTela().setCodigo(2);
            if(!getTelasusuario().eadmintela()){
                BtCadPessoa.setVisible(false);
            }else{
                BtCadPessoa.setVisible(true);
            }
        }
        
        getTelasusuario().getTela().setCodigo(6);
        if(!getTelasusuario().eadmintela()){
            BtCadCondicaoPgto.setVisible(false);
        }
    }
    
    public boolean camposobrigatoriospreenchidos(){
        if(TfDescOperacao.getText().equals("")){
            msg.CampoObrigatorioNaoPreenchido(LbNotificacao, "Digite a descrição desta operação!");
            TfDescOperacao.grabFocus();
            return false;
        }
        if(TfCodCondicaoPgto.getText().equals("") || TfCondicaoPgto.getText().equals("")){
            msg.CampoObrigatorioNaoPreenchido(LbNotificacao, "Digite a condição de pagamento escolhida!");
            TfCodCondicaoPgto.grabFocus();
            return false;
        }
        if(TfValorTotal.getValue() == BigDecimal.valueOf(0)){
            msg.CampoObrigatorioNaoPreenchido(LbNotificacao, "Digite o valor total desta operação!");
            TfValorTotal.grabFocus();
            return false;
        }
        if(parcelas.getConta().getOperacao().getTpfinanceiro().equals("E") && (TfCodPessoa.getText().equals("") || TfPessoa.getText().equals(""))){
            msg.CampoObrigatorioNaoPreenchido(LbNotificacao, "Digite a Pessoa que fará parte desta conta!");
            TfCodPessoa.grabFocus();
            return false;
        }
        return true;
    }
    
    public void enviardados() {
        parcelas.getConta().getCompravenda().setCodigo(0);
        parcelas.getConta().getCondicao().setCodigo(Integer.parseInt(TfCodCondicaoPgto.getText()));
        parcelas.getConta().setDescricao(parcelas.getConta().getOperacao().getDescricao() + " NRO. "+TfCodigo.getText()+" - "+TfDescOperacao.getText());
        parcelas.getConta().setDtconta(TfData.getText());
        parcelas.getConta().setTotal(Float.parseFloat(TfValorTotal.getValue().toString()));
        if (CbPessoa.getSelectedItem().toString().equals("Cliente")) {
            if(!TfCodPessoa.getText().equals("") && !TfPessoa.getText().equals("")){
                cliente.setCodigo(Integer.parseInt(TfCodPessoa.getText()));
                parcelas.getConta().setCodigopessoa(cliente.retornacodigopessoacliente());
            }else{
                parcelas.getConta().setCodigopessoa(0);
            }
        } else {
            if(!TfCodPessoa.getText().equals("") && !TfPessoa.getText().equals("")){
                fornecedor.setCodigo(Integer.parseInt(TfCodPessoa.getText()));
                parcelas.getConta().setCodigopessoa(fornecedor.retornacodigopessoafornecedor());
            }else{
                parcelas.getConta().setCodigopessoa(0);
            }
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
