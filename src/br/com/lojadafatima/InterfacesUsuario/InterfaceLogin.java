package br.com.lojadafatima.InterfacesUsuario;

import br.com.lojadafatima.Usuario.ClasseUsuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme Azevedo
 */
public class InterfaceLogin extends javax.swing.JFrame {

    public ClasseUsuario usuario = new ClasseUsuario();
    private static boolean sedispose = true;

    public InterfaceLogin() {
        initComponents();
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
        LbBemVindo = new javax.swing.JLabel();
        LbLogin = new javax.swing.JLabel();
        TfLogin = new javax.swing.JTextField();
        LbSenha = new javax.swing.JLabel();
        TfSenha = new javax.swing.JPasswordField();
        BtEntrar = new javax.swing.JButton();
        BtFechar = new javax.swing.JButton();
        LbDica = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bem-vindo! - Loja da Fátima");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LbBemVindo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LbBemVindo.setText("Bem-Vindo(a)! Digite seu Login e Senha");
        jPanel1.add(LbBemVindo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        LbLogin.setText("Login:");
        jPanel1.add(LbLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 49, -1, -1));
        jPanel1.add(TfLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 46, 145, -1));

        LbSenha.setText("Senha:");
        jPanel1.add(LbSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        jPanel1.add(TfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 77, 145, -1));

        BtEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/trocar_usuario.png"))); // NOI18N
        BtEntrar.setText("Entrar");
        BtEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(BtEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 132, 86, -1));

        BtFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/cancelar.png"))); // NOI18N
        BtFechar.setText("Fechar");
        BtFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtFecharActionPerformed(evt);
            }
        });
        jPanel1.add(BtFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 132, -1, -1));

        LbDica.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        LbDica.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        LbDica.setText("Exibir dica de senha");
        LbDica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LbDica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbDicaMouseClicked(evt);
            }
        });
        jPanel1.add(LbDica, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 103, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEntrarActionPerformed
        if (!TfLogin.getText().equals("")) {
            if (!TfSenha.getText().equals("")) {
                usuario.setLogin(TfLogin.getText());
                usuario.setSenha(TfSenha.getText());
                if (usuario.realizalogin()) {
                    final InterfacePrincipal tela = new InterfacePrincipal(this, true, usuario);
                    setSedispose(true);
                    tela.setVisible(true);
                    tela.addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosed(java.awt.event.WindowEvent evt) {
                            if (isSedispose()) {
                                System.exit(0);
                            } else {
                                TfLogin.setText("");
                                TfSenha.setText("");
                                TfLogin.grabFocus();
                            }
                        }
                    });
                } else{
                    JOptionPane.showMessageDialog(rootPane, "Login ou Senha inválidos", "Tente novamente", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Digite sua Senha", "Campos Obrigatórios", JOptionPane.INFORMATION_MESSAGE);
                TfSenha.grabFocus();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Digite seu Login", "Campos Obrigatórios", JOptionPane.INFORMATION_MESSAGE);
            TfLogin.grabFocus();
        }
    }//GEN-LAST:event_BtEntrarActionPerformed

    private void BtFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtFecharActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtFecharActionPerformed

    private void LbDicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbDicaMouseClicked
        if(!TfLogin.getText().equals("")){
            usuario.setLogin(TfLogin.getText());
            JOptionPane.showMessageDialog(rootPane, usuario.mostrardica(), "Dica de Senha", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(rootPane, "Digite seu Login", "Campos Obrigatórios", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_LbDicaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtEntrar;
    private javax.swing.JButton BtFechar;
    private javax.swing.JLabel LbBemVindo;
    private javax.swing.JLabel LbDica;
    private javax.swing.JLabel LbLogin;
    private javax.swing.JLabel LbSenha;
    private javax.swing.JTextField TfLogin;
    private javax.swing.JPasswordField TfSenha;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
    public boolean isSedispose() {
        return sedispose;
    }

    public void setSedispose(boolean sedispose) {
        this.sedispose = sedispose;
    }
}
