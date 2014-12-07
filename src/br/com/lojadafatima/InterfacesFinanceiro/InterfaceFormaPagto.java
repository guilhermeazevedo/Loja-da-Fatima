/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.InterfacesFinanceiro;

import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.LimpaCamposTela;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.Financeiro.ClasseFormaPagamento;
import br.com.lojadafatima.Usuario.ClasseTelasUsuario;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class InterfaceFormaPagto extends javax.swing.JDialog {

    private java.awt.Frame primeiratela;
    Preenche preenche = new Preenche();
    ClasseFormaPagamento forma = new ClasseFormaPagamento();
    LimpaCamposTela limpa = new LimpaCamposTela();
    GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();
    private ClasseTelasUsuario telasusario = new ClasseTelasUsuario();
    
    public InterfaceFormaPagto(java.awt.Frame telaorigem, boolean modal, ClasseTelasUsuario usuario) {
        super (telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setTelasusario(usuario);
        analisarusuario();
        int[] tam = new int[2];
        tam[0] = 50;
        tam[1] = 200;
        preenche.FormataJtable(TbConsulta, tam);
        preenche.PreencherJtable(TbConsulta, forma.retornaformapgtojtable());
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
        jLabel1 = new javax.swing.JLabel();
        TfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TfForma = new javax.swing.JTextField();
        BtGravar = new javax.swing.JButton();
        BtLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbConsulta = new javax.swing.JTable();

        jMenuItem1.setText("Carregar dados");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Forma de Pagamento - Software Loja da Fátima");
        setResizable(false);

        jLabel1.setText("Código");

        TfCodigo.setEditable(false);

        jLabel2.setText("Descrição da forma de pagamento");

        TfForma.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TfFormaFocusLost(evt);
            }
        });
        TfForma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TfFormaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfFormaKeyTyped(evt);
            }
        });

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

        TbConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Condição"
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
        jScrollPane1.setViewportView(TbConsulta);
        if (TbConsulta.getColumnModel().getColumnCount() > 0) {
            TbConsulta.getColumnModel().getColumn(0).setResizable(false);
            TbConsulta.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfForma, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(TfForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtGravar)
                    .addComponent(BtLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGravarActionPerformed
        if(!TfForma.getText().equals("")){
            forma.setFormapgto(TfForma.getText());
            if(TfCodigo.getText().equals("")){
                forma.incluir();
            }else{
                forma.setCodigo(Integer.parseInt(TfCodigo.getText()));
                forma.alterar();
            }
            limpa.Limpar(jPanel1);
            preenche.PreencherJtable(TbConsulta, forma.retornaformapgtojtable());
        }else{
            JOptionPane.showMessageDialog(null, "Digite a descricao da forma de pagamento!", "Campo obrigatorios", JOptionPane.INFORMATION_MESSAGE);
            TfForma.grabFocus();
        }
    }//GEN-LAST:event_BtGravarActionPerformed

    private void BtLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLimparActionPerformed
        limpa.Limpar(jPanel1);
    }//GEN-LAST:event_BtLimparActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(TbConsulta.getSelectedRow() > 0){
            TfCodigo.setText(TbConsulta.getValueAt(TbConsulta.getSelectedRow(), 0).toString());
            TfForma.setText(TbConsulta.getValueAt(TbConsulta.getSelectedRow(), 1).toString());
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void TfFormaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TfFormaFocusLost
        
    }//GEN-LAST:event_TfFormaFocusLost

    private void TfFormaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfFormaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfFormaKeyPressed

    private void TfFormaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfFormaKeyTyped
        valida.limitemaximo(evt, TfForma.getText(), 50);
    }//GEN-LAST:event_TfFormaKeyTyped

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtGravar;
    private javax.swing.JButton BtLimpar;
    private javax.swing.JTable TbConsulta;
    private javax.swing.JTextField TfCodigo;
    private javax.swing.JTextField TfForma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void analisarusuario(){
        getTelasusario().getTela().setCodigo(7);
        if(!getTelasusario().eadmintela()){
            BtGravar.setVisible(false);
        }
    }
    
    public java.awt.Frame getPrimeiratela() {
        return primeiratela;
    }

    public void setPrimeiratela(java.awt.Frame primeiratela) {
        this.primeiratela = primeiratela;
    }

    public ClasseTelasUsuario getTelasusario() {
        return telasusario;
    }

    public void setTelasusario(ClasseTelasUsuario telasusario) {
        this.telasusario = telasusario;
    }
}