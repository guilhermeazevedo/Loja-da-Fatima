/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojadafatima.InterfacesUsuario;

import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.LimpaCamposTela;
import br.com.lojadafatima.ClassesFerramentas.NaoPermiteAspasSimples;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.ClassesFerramentas.TeclasPermitidas;
import br.com.lojadafatima.Usuario.ClasseTelasUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class InterfaceUsuario extends javax.swing.JDialog {

    private java.awt.Frame primeiratela;
    GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();
    LimpaCamposTela limpa = new LimpaCamposTela();
    Preenche preenche = new Preenche();
    ClasseTelasUsuario telasusuario = new ClasseTelasUsuario();

    public InterfaceUsuario(java.awt.Frame telaorigem, boolean modal, ClasseTelasUsuario usuario) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        analisausuario(usuario);
        TfLogin.setDocument(new TeclasPermitidas());
        TfSenha.setDocument(new TeclasPermitidas());
        TfConfirmSenha.setDocument(new TeclasPermitidas());
        TfDica.setDocument(new NaoPermiteAspasSimples());

        int[] tam = new int[2];
        tam[0] = 30;
        tam[1] = 200;
        preenche.FormataJtable(TbConsulta, tam);

        int[] tam2 = new int[3];
        tam2[0] = 100;
        tam2[1] = 200;
        tam2[2] = 70;
        preenche.FormataJtable(TbInterfaces, tam2);
        preenche.FormataJtable(TbPermitidas, tam2);

        preenche.PreencherJtable(TbConsulta, telasusuario.getUsuario().consultausuarios());
        valida.validacamposCancelar(PnLogin, PnBotoes);
        valida.validacamposCancelar(PnTelas, PnBotoes);
        TbConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        TabbedMultas = new javax.swing.JTabbedPane();
        PnCadastro = new javax.swing.JPanel();
        PnBotoes = new javax.swing.JPanel();
        BtGravar = new javax.swing.JButton();
        BtAlterar = new javax.swing.JButton();
        BtIncluir = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        TabbedCadastro = new javax.swing.JTabbedPane();
        PnLogin = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        TfCodigo = new javax.swing.JTextField();
        TfLogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TfSenha = new javax.swing.JPasswordField();
        TfConfirmSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        TfDica = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PnTelas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbInterfaces = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbPermitidas = new javax.swing.JTable();
        PnConsulta = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TbConsulta = new javax.swing.JTable();

        jMenuItem1.setText("Carregar dados");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuário - Software Loja da Fátima");
        setResizable(false);

        BtGravar.setText("Gravar");
        BtGravar.setName("Gravar"); // NOI18N
        BtGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGravarActionPerformed(evt);
            }
        });

        BtAlterar.setText("Alterar");
        BtAlterar.setName("Alterar"); // NOI18N
        BtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarActionPerformed(evt);
            }
        });

        BtIncluir.setText("Novo");
        BtIncluir.setName("Incluir"); // NOI18N
        BtIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIncluirActionPerformed(evt);
            }
        });

        BtExcluir.setText("Excluir");
        BtExcluir.setName("Excluir"); // NOI18N
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });

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
                .addComponent(BtIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnBotoesLayout.setVerticalGroup(
            PnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(BtAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BtExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BtGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BtCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel6.setText("Código");

        TfCodigo.setEditable(false);

        TfLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfLoginKeyTyped(evt);
            }
        });

        jLabel1.setText("Login*");

        jLabel2.setText("Senha* (máximo 15 caracteres)");

        TfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfSenhaKeyTyped(evt);
            }
        });

        TfConfirmSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfConfirmSenhaKeyTyped(evt);
            }
        });

        jLabel3.setText("Confirmação de Senha*");

        TfDica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfDicaKeyTyped(evt);
            }
        });

        jLabel4.setText("Dica de Senha* (máximo 80 caracteres)");

        javax.swing.GroupLayout PnLoginLayout = new javax.swing.GroupLayout(PnLogin);
        PnLogin.setLayout(PnLoginLayout);
        PnLoginLayout.setHorizontalGroup(
            PnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TfDica)
                    .addGroup(PnLoginLayout.createSequentialGroup()
                        .addGroup(PnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(TfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(TfLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(TfSenha)
                            .addComponent(TfConfirmSenha))
                        .addGap(0, 140, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PnLoginLayout.setVerticalGroup(
            PnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TfConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TfDica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        TabbedCadastro.addTab("Login", PnLogin);

        TbInterfaces.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Permitir", "Tela", "Cod. Tela"
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
        TbInterfaces.getTableHeader().setReorderingAllowed(false);
        TbInterfaces.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbInterfacesMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TbInterfacesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TbInterfaces);
        if (TbInterfaces.getColumnModel().getColumnCount() > 0) {
            TbInterfaces.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel7.setText("Telas existentes:");

        jLabel8.setText("Telas permitidas:");

        TbPermitidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Acesso Total", "Tela", "Cod. Tela"
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
        TbPermitidas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TbPermitidas);
        if (TbPermitidas.getColumnModel().getColumnCount() > 0) {
            TbPermitidas.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout PnTelasLayout = new javax.swing.GroupLayout(PnTelas);
        PnTelas.setLayout(PnTelasLayout);
        PnTelasLayout.setHorizontalGroup(
            PnTelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnTelasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnTelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(PnTelasLayout.createSequentialGroup()
                        .addGroup(PnTelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PnTelasLayout.setVerticalGroup(
            PnTelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnTelasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        TabbedCadastro.addTab("Telas e Interfaces", PnTelas);

        javax.swing.GroupLayout PnCadastroLayout = new javax.swing.GroupLayout(PnCadastro);
        PnCadastro.setLayout(PnCadastroLayout);
        PnCadastroLayout.setHorizontalGroup(
            PnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnCadastroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TabbedCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(PnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PnBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnCadastroLayout.setVerticalGroup(
            PnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabbedCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabbedMultas.addTab("Cadastro", PnCadastro);

        TbConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Usuario", "Login Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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

        javax.swing.GroupLayout PnConsultaLayout = new javax.swing.GroupLayout(PnConsulta);
        PnConsulta.setLayout(PnConsultaLayout);
        PnConsultaLayout.setHorizontalGroup(
            PnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );
        PnConsultaLayout.setVerticalGroup(
            PnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        TabbedMultas.addTab("Consulta", PnConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedMultas, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedMultas)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed
        if (TfCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione um Usuario na aba \"Consulta\" e carregue os dados para que esta operacao seja realizada!");
            TabbedMultas.setSelectedIndex(1);
            TbConsulta.grabFocus();
        } else {
            valida.validacamposCadastrar(PnLogin, PnBotoes);
            valida.validacamposCadastrar(PnTelas, PnBotoes);
        }
    }//GEN-LAST:event_BtAlterarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar esta operacao?\n(Caso queira, TODOS os dados da tela serao limpos)", "Deseja cancelar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            limpa.Limpar(PnLogin);
            limpa.Limpar(TbInterfaces);
            limpa.Limpar(TbPermitidas);
            valida.validacamposCancelar(PnLogin, PnBotoes);
            valida.validacamposCancelar(PnTelas, PnBotoes);
        }
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void TfLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfLoginKeyTyped
        valida.limitemaximo(evt, TfLogin.getText(), 30);
    }//GEN-LAST:event_TfLoginKeyTyped

    private void TfSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfSenhaKeyTyped
        valida.limitemaximo(evt, TfSenha.getText(), 15);
    }//GEN-LAST:event_TfSenhaKeyTyped

    private void TfConfirmSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfConfirmSenhaKeyTyped
        valida.limitemaximo(evt, TfConfirmSenha.getText(), 15);
    }//GEN-LAST:event_TfConfirmSenhaKeyTyped

    private void TfDicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfDicaKeyTyped
        valida.limitemaximo(evt, TfDica.getText(), 80);
    }//GEN-LAST:event_TfDicaKeyTyped

    private void BtIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIncluirActionPerformed
        limpa.Limpar(PnLogin);
        limpa.Limpar(TbInterfaces);
        limpa.Limpar(TbPermitidas);
        valida.validacamposCadastrar(PnLogin, PnBotoes);
        valida.validacamposCadastrar(PnTelas, PnBotoes);
        preenche.PreencheJtableSEL(TbInterfaces, telasusuario.getTela().retornatelascadastradas());
    }//GEN-LAST:event_BtIncluirActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed
        if (TfCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione um Usuario na aba \"Consulta\" e carregue os dados para que esta operacao seja realizada!");
            TabbedMultas.setSelectedIndex(1);
            TbConsulta.grabFocus();
        } else {
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir TODOS os dados deste usuario?", "Deseja excluir?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                telasusuario.getUsuario().setCodigo(Integer.parseInt(TfCodigo.getText()));
                telasusuario.deletartelasusuario();
                telasusuario.getUsuario().excluir();
                limpa.Limpar(PnLogin);
                limpa.Limpar(TbInterfaces);
                limpa.Limpar(TbPermitidas);
                valida.validacamposCancelar(PnLogin, PnBotoes);
                valida.validacamposCancelar(PnTelas, PnBotoes);
                preenche.PreencherJtable(TbConsulta, telasusuario.getUsuario().consultausuarios());
            }
        }
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGravarActionPerformed
        if (camposobrigatoriospreenchidos()) {
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente gravar os dados deste usuario?", "Deseja gravar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                enviardados();
                if (TfCodigo.getText().equals("")) {
                    telasusuario.getUsuario().incluir();
                    incluirtelasusuario();
                } else {
                    telasusuario.getUsuario().setCodigo(Integer.parseInt(TfCodigo.getText()));
                    telasusuario.getUsuario().alterar();
                    telasusuario.deletartelasusuario();
                    incluirtelasusuario();
                }
                limpa.Limpar(PnLogin);
                limpa.Limpar(TbInterfaces);
                limpa.Limpar(TbPermitidas);
                valida.validacamposCancelar(PnLogin, PnBotoes);
                valida.validacamposCancelar(PnTelas, PnBotoes);
                preenche.PreencherJtable(TbConsulta, telasusuario.getUsuario().consultausuarios());
            }
        }
    }//GEN-LAST:event_BtGravarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (TbConsulta.getSelectedRow() > -1) {
            limpa.Limpar(PnLogin);
            limpa.Limpar(TbInterfaces);
            limpa.Limpar(TbPermitidas);
            preenche.PreencheJtableSEL(TbInterfaces, telasusuario.getTela().retornatelascadastradas());
            telasusuario.getUsuario().setCodigo(Integer.parseInt(TbConsulta.getValueAt(TbConsulta.getSelectedRow(), 0).toString()));
            telasusuario.getUsuario().retornausuario();
            TfCodigo.setText("" + telasusuario.getUsuario().getCodigo());
            TfLogin.setText(telasusuario.getUsuario().getLogin());
            TfSenha.setText(telasusuario.getUsuario().getSenha());
            TfConfirmSenha.setText("");
            TfDica.setText(telasusuario.getUsuario().getDica());
            ResultSet rs = telasusuario.retornatelasusuario();
            limpa.Limpar(TbPermitidas);
            DefaultTableModel tabela = (DefaultTableModel) TbPermitidas.getModel();
            try {
                while (rs.next()) {
                    int linha = tabela.getRowCount();
                    tabela.setNumRows(linha + 1);
                    if (rs.getString(3).equals("S")) {
                        tabela.setValueAt((true), linha, 0);
                    } else {
                        tabela.setValueAt((false), linha, 0);
                    }
                    tabela.setValueAt(rs.getString(2), linha, 1);
                    tabela.setValueAt(rs.getString(1), linha, 2);
                }
            } catch (SQLException ex) {

            }
            for (int i = 0; i < TbPermitidas.getRowCount(); i++) {
                for (int j = 0; j < TbInterfaces.getRowCount(); j++) {
                    int cod1 = Integer.parseInt(TbPermitidas.getValueAt(i, 2).toString());
                    int cod2 = Integer.parseInt(TbInterfaces.getValueAt(j, 2).toString());
                    if (cod1 == cod2) {
                        TbInterfaces.setValueAt((true), j, 0);
                    }
                }
            }
            TabbedMultas.setSelectedIndex(0);
            TabbedCadastro.setSelectedIndex(0);
            valida.validacamposCancelar(PnLogin, PnBotoes);
            valida.validacamposCancelar(PnTelas, PnBotoes);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void TbInterfacesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbInterfacesMouseClicked

    }//GEN-LAST:event_TbInterfacesMouseClicked

    private void TbInterfacesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbInterfacesMouseReleased
        if (TbInterfaces.getSelectedRow() > -1) {
            DefaultTableModel tabela = (DefaultTableModel) TbPermitidas.getModel();
            boolean sel = (Boolean) TbInterfaces.getValueAt(TbInterfaces.getSelectedRow(), 0);
            if (sel) {
                boolean inclui = true;
                for (int i = 0; i < tabela.getRowCount(); i++) {
                    if (Integer.parseInt(tabela.getValueAt(i, 2).toString()) == Integer.parseInt(TbInterfaces.getValueAt(TbInterfaces.getSelectedRow(), 2).toString())) {
                        inclui = false;
                    }
                }
                if (inclui) {
                    int linhas = tabela.getRowCount();
                    tabela.setNumRows(linhas + 1);
                    tabela.setValueAt((false), linhas, 0);
                    tabela.setValueAt(TbInterfaces.getValueAt(TbInterfaces.getSelectedRow(), 1), linhas, 1);
                    tabela.setValueAt(TbInterfaces.getValueAt(TbInterfaces.getSelectedRow(), 2), linhas, 2);
                }
            } else {
                for (int i = 0; i < tabela.getRowCount(); i++) {
                    if (Integer.parseInt(tabela.getValueAt(i, 2).toString()) == Integer.parseInt(TbInterfaces.getValueAt(TbInterfaces.getSelectedRow(), 2).toString())) {
                        tabela.removeRow(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_TbInterfacesMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtGravar;
    private javax.swing.JButton BtIncluir;
    private javax.swing.JPanel PnBotoes;
    private javax.swing.JPanel PnCadastro;
    private javax.swing.JPanel PnConsulta;
    private javax.swing.JPanel PnLogin;
    private javax.swing.JPanel PnTelas;
    private javax.swing.JTabbedPane TabbedCadastro;
    private javax.swing.JTabbedPane TabbedMultas;
    private javax.swing.JTable TbConsulta;
    private javax.swing.JTable TbInterfaces;
    private javax.swing.JTable TbPermitidas;
    private javax.swing.JTextField TfCodigo;
    private javax.swing.JPasswordField TfConfirmSenha;
    private javax.swing.JTextField TfDica;
    private javax.swing.JTextField TfLogin;
    private javax.swing.JPasswordField TfSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    public void analisausuario(ClasseTelasUsuario usuario){
        usuario.getTela().setCodigo(8);
        if(!usuario.eadmintela()){
            PnBotoes.setVisible(false);
        }
    }
    
    public boolean camposobrigatoriospreenchidos() {
        if (TfLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o Login que o usuario utilizara!", "Campos obrigatorios", JOptionPane.INFORMATION_MESSAGE);
            TabbedCadastro.setSelectedIndex(0);
            TfLogin.grabFocus();
            return false;
        }
        if (TfSenha.getText().equals("") || TfSenha.getText().length() < 5) {
            JOptionPane.showMessageDialog(null, "O campo Senha deve ter no minimo 4 caracteres!", "Campos obrigatorios", JOptionPane.INFORMATION_MESSAGE);
            TabbedCadastro.setSelectedIndex(0);
            TfSenha.grabFocus();
            return false;
        }
        if (!TfSenha.getText().equals(TfConfirmSenha.getText())) {
            JOptionPane.showMessageDialog(null, "A Confirmaacao de Senha esta diferente da Senha que voce digitou!", "Campos obrigatorios", JOptionPane.INFORMATION_MESSAGE);
            TabbedCadastro.setSelectedIndex(0);
            TfConfirmSenha.grabFocus();
            return false;
        }
        if (TfDica.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite uma dica de senha, para o caso do usuario esquece-la", "Campos obrigatorios", JOptionPane.INFORMATION_MESSAGE);
            TabbedCadastro.setSelectedIndex(0);
            TfDica.grabFocus();
            return false;
        }
        if (TbPermitidas.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(null, "Inclua as tela do sistema permitidas ao usuario!", "Campos obigatorios", JOptionPane.INFORMATION_MESSAGE);
            TabbedCadastro.setSelectedIndex(1);
            return false;
        }
        return true;
    }

    public void enviardados() {
        telasusuario.getUsuario().setLogin(TfLogin.getText());
        telasusuario.getUsuario().setSenha(TfSenha.getText());
        telasusuario.getUsuario().setDica(TfDica.getText());
    }

    public void incluirtelasusuario() {
        for (int i = 0; i < TbPermitidas.getRowCount(); i++) {
            boolean sel = (Boolean) TbPermitidas.getValueAt(i, 0);
            if (sel) {
                telasusuario.setAdmin("S");
            } else {
                telasusuario.setAdmin("N");
            }
            telasusuario.getTela().setCodigo(Integer.parseInt(TbPermitidas.getValueAt(i, 2).toString()));
            telasusuario.incluirtelausuario();
        }
    }

    public java.awt.Frame getPrimeiratela() {
        return primeiratela;
    }

    public void setPrimeiratela(java.awt.Frame primeiratela) {
        this.primeiratela = primeiratela;
    }
}
