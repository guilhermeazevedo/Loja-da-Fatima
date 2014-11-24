/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.InterfacesProduto;

import br.com.lojadafatima.ClassesFerramentas.PermiteApenasNumeros;
import br.com.lojadafatima.InterfaceConsultaSimples.ConsulSimplesFuncionario;
import br.com.lojadafatima.InterfacesPessoa.InterfaceFuncionario;
import br.com.lojadafatima.Pessoa.ClasseFuncionario;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class InterfacePerguntaFuncionarioAjusteEstoque extends javax.swing.JDialog {

    private ClasseFuncionario funcionario = new ClasseFuncionario();
    private java.awt.Frame primeiratela;
    
    public InterfacePerguntaFuncionarioAjusteEstoque(java.awt.Frame telaorigem, boolean modal, ClasseFuncionario func) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setFuncionario(func);
        TfCodFuncionario4.setDocument(new PermiteApenasNumeros());
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
        jLabel3 = new javax.swing.JLabel();
        TfCodFuncionario4 = new javax.swing.JTextField();
        BtPesqFuncionario = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        TfFuncionario = new javax.swing.JTextField();
        BtCadFuncionario = new javax.swing.JButton();
        BtSelecionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecionar Funcionário - Software Loja da Fátima");
        setResizable(false);

        jLabel3.setText("Cód. Funcionário");

        TfCodFuncionario4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TfCodFuncionario4KeyReleased(evt);
            }
        });

        BtPesqFuncionario.setText("Pesquisar");
        BtPesqFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPesqFuncionarioActionPerformed(evt);
            }
        });

        jLabel4.setText("Funcionário");

        TfFuncionario.setEditable(false);

        BtCadFuncionario.setText("Cadastrar Funcionário");
        BtCadFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCadFuncionarioActionPerformed(evt);
            }
        });

        BtSelecionar.setText("Selecionar");
        BtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSelecionarActionPerformed(evt);
            }
        });

        BtCancelar.setText("Cancelar");
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TfCodFuncionario4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtPesqFuncionario))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtCadFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfCodFuncionario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtPesqFuncionario)
                    .addComponent(TfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCadFuncionario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TfCodFuncionario4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCodFuncionario4KeyReleased
        if (!TfCodFuncionario4.getText().equals("")) {
            getFuncionario().setCodigo(Integer.parseInt(TfCodFuncionario4.getText()));
            if (getFuncionario().efuncionarioativo()) {
                getFuncionario().getPessoafis().getPessoa().setCodigo(getFuncionario().retornacodigopessoafuncionario());
                TfFuncionario.setText(getFuncionario().getPessoafis().retornanomeporCodigo());
            } else {
                TfFuncionario.setText("");
            }
        } else {
            TfFuncionario.setText("");
        }
    }//GEN-LAST:event_TfCodFuncionario4KeyReleased

    private void BtPesqFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPesqFuncionarioActionPerformed
        final ConsulSimplesFuncionario tela = new ConsulSimplesFuncionario(getPrimeiratela(), true, getFuncionario());
        tela.setVisible(true);
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                if (getFuncionario().getCodigo() != 0) {
                    TfCodFuncionario4.setText("" + getFuncionario().getCodigo());
                    TfCodFuncionario4KeyReleased(null);
                } else {
                    TfCodFuncionario4.setText("");
                    TfFuncionario.setText("");
                }
            }
        });
    }//GEN-LAST:event_BtPesqFuncionarioActionPerformed

    private void BtCadFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCadFuncionarioActionPerformed
        final InterfaceFuncionario tela = new InterfaceFuncionario(getPrimeiratela(), true);
        tela.setVisible(true);
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {

            }
        });
    }//GEN-LAST:event_BtCadFuncionarioActionPerformed

    private void BtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSelecionarActionPerformed
        if(!TfCodFuncionario4.getText().equals("")){
            getFuncionario().setCodigo(Integer.parseInt(TfCodFuncionario4.getText()));
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Digite o codigo do funcionario!", "Digite o codigo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtSelecionarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed
        getFuncionario().setCodigo(0);
        dispose();
    }//GEN-LAST:event_BtCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCadFuncionario;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtPesqFuncionario;
    private javax.swing.JButton BtSelecionar;
    private javax.swing.JTextField TfCodFuncionario;
    private javax.swing.JTextField TfCodFuncionario1;
    private javax.swing.JTextField TfCodFuncionario2;
    private javax.swing.JTextField TfCodFuncionario3;
    private javax.swing.JTextField TfCodFuncionario4;
    private javax.swing.JTextField TfFuncionario;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public ClasseFuncionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(ClasseFuncionario funcionario) {
        this.funcionario = funcionario;
    }

    public java.awt.Frame getPrimeiratela() {
        return primeiratela;
    }

    public void setPrimeiratela(java.awt.Frame primeiratela) {
        this.primeiratela = primeiratela;
    }
}
