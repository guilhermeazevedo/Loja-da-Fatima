package br.com.lojadafatima.InterfacesPessoa;

import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.LimpaCamposTela;
import br.com.lojadafatima.ClassesFerramentas.MensagensUsuario;
import br.com.lojadafatima.ClassesFerramentas.NaoPermiteAspasSimples;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.DadosPessoa.ClasseEstado;
import br.com.lojadafatima.Usuario.ClasseTelasUsuario;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Guilherme Azevedo
 */
public class InterfaceEstado extends javax.swing.JDialog {

    MaskFormatter sigla;
    Preenche preenche = new Preenche();
    ClasseEstado estado = new ClasseEstado();
    LimpaCamposTela limpar = new LimpaCamposTela();
    private java.awt.Frame primeiratela;
    private ClasseTelasUsuario telasusuario = new ClasseTelasUsuario();
    GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();
    MensagensUsuario msg = new MensagensUsuario();

    public InterfaceEstado(java.awt.Frame telaorigem, boolean modal, ClasseTelasUsuario usuario) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();

        setTelasusuario(usuario);
        analisausuario();
        int[] tam = new int[3];
        tam[0] = 50;
        tam[1] = 200;
        tam[2] = 50;
        preenche.FormataJtable(TbEstados, tam);
        preenche.PreencherJtable(TbEstados, estado.buscarestadosjtable());
        TbEstados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TfEstado.setDocument(new NaoPermiteAspasSimples());
        msg.Limpar(LbNotificacao);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TfEstado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BtGravar = new javax.swing.JButton();
        BtLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbEstados = new javax.swing.JTable();
        try{
            sigla = new MaskFormatter("UU");
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Nao foi possivel localizar");
        }
        TfSigla = new JFormattedTextField(sigla);
        jPanel2 = new javax.swing.JPanel();
        LbNotificacao = new javax.swing.JLabel();

        MnItAlterar.setText("Alterar Estado");
        MnItAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnItAlterarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnItAlterar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estados - Software Loja da Fátima");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Código");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        TfCodigo.setEditable(false);
        jPanel1.add(TfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 36, 100, -1));

        jLabel2.setText("Estado*");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 11, -1, -1));

        TfEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfEstadoKeyTyped(evt);
            }
        });
        jPanel1.add(TfEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 36, 200, -1));

        jLabel3.setText("Sigla*");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 11, -1, -1));

        BtGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/salvar.png"))); // NOI18N
        BtGravar.setText("Gravar");
        BtGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGravarActionPerformed(evt);
            }
        });
        jPanel1.add(BtGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 74, 89, -1));

        BtLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/deletar.png"))); // NOI18N
        BtLimpar.setText("Limpar");
        BtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtLimparActionPerformed(evt);
            }
        });
        jPanel1.add(BtLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 74, 85, -1));

        TbEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Estado", "Sigla"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbEstados.setComponentPopupMenu(jPopupMenu1);
        TbEstados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TbEstados);
        if (TbEstados.getColumnModel().getColumnCount() > 0) {
            TbEstados.getColumnModel().getColumn(0).setResizable(false);
            TbEstados.getColumnModel().getColumn(1).setResizable(false);
            TbEstados.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 103, 384, 161));

        TfSigla.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TfSiglaFocusLost(evt);
            }
        });
        jPanel1.add(TfSigla, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 36, 60, -1));

        LbNotificacao.setText("  ");

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
            .addComponent(LbNotificacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 384, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TfSiglaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TfSiglaFocusLost
        TfSigla.setFocusLostBehavior(JFormattedTextField.PERSIST);
    }//GEN-LAST:event_TfSiglaFocusLost

    private void MnItAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnItAlterarActionPerformed
        int index = TbEstados.getSelectedRow();
        if (index > -1) {
            BtLimparActionPerformed(evt);
            TfCodigo.setText(TbEstados.getValueAt(index, 0).toString());
            TfEstado.setText(TbEstados.getValueAt(index, 1).toString());
            TfSigla.setText(TbEstados.getValueAt(index, 2).toString());
            msg.StatusEditar(LbNotificacao, "Editando informações...");
        }
    }//GEN-LAST:event_MnItAlterarActionPerformed

    private void BtLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLimparActionPerformed
        limpar.Limpar(jPanel1);
        msg.Limpar(LbNotificacao);
    }//GEN-LAST:event_BtLimparActionPerformed

    private void BtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGravarActionPerformed
        if (!TfEstado.getText().equals("")) {
            if (!TfSigla.getText().equals("  ")) {
                int opcao;
                estado.setEstado(TfEstado.getText());
                estado.setSigla(TfSigla.getText());
                if (TfCodigo.getText().equals("")) {
                    opcao = JOptionPane.showConfirmDialog(rootPane, "Incluir novo Estado?", "Confirmar", JOptionPane.YES_NO_OPTION);
                    if (opcao == JOptionPane.YES_OPTION) {
                        if (estado.incluir()){
                            msg.Sucesso(LbNotificacao, "Dados do Estado gravados com sucesso!");
                        }
                        limpar.Limpar(TbEstados);
                        limpar.Limpar(jPanel1);
                    }
                } else {
                    estado.setCodigo(Integer.parseInt(TfCodigo.getText()));
                    opcao = JOptionPane.showConfirmDialog(rootPane, "Alterar dados do Estado?", "Confirmar", JOptionPane.YES_NO_OPTION);
                    if (opcao == JOptionPane.YES_OPTION) {
                        if (estado.alterar()){
                            msg.Sucesso(LbNotificacao, "Dados do Estado alterados com sucesso!");
                        }
                        limpar.Limpar(TbEstados);
                        limpar.Limpar(jPanel1);
                    }
                }
                preenche.PreencherJtable(TbEstados, estado.buscarestadosjtable());
            } else {
                msg.CampoObrigatorioNaoPreenchido(LbNotificacao, "Digite a Sigla!");
                TfSigla.grabFocus();
            }
        } else {
            msg.CampoObrigatorioNaoPreenchido(LbNotificacao, "Digite o Nome do Estado!");
            TfEstado.grabFocus();
        }
    }//GEN-LAST:event_BtGravarActionPerformed

    private void TfEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfEstadoKeyTyped
        valida.limitemaximo(evt, TfEstado.getText(), 40);
    }//GEN-LAST:event_TfEstadoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtGravar;
    private javax.swing.JButton BtLimpar;
    private javax.swing.JLabel LbNotificacao;
    private javax.swing.JMenuItem MnItAlterar;
    private javax.swing.JTable TbEstados;
    private javax.swing.JTextField TfCodigo;
    private javax.swing.JTextField TfEstado;
    private javax.swing.JFormattedTextField TfSigla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

   
    public void analisausuario(){
        getTelasusuario().getTela().setCodigo(4);
        if(!getTelasusuario().eadmintela()){
            BtGravar.setVisible(false);
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
