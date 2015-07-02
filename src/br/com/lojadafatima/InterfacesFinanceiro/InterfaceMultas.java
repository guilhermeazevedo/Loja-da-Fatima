package br.com.lojadafatima.InterfacesFinanceiro;

import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.MensagensUsuario;
import br.com.lojadafatima.Financeiro.ClasseMulta;
import br.com.lojadafatima.Usuario.ClasseTelasUsuario;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Guilherme Azevedo
 */
public class InterfaceMultas extends javax.swing.JDialog {

    MaskFormatter percent;
    GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();
    ClasseMulta multa = new ClasseMulta();
    private java.awt.Frame primeiratela;
    private ClasseTelasUsuario telasusuario = new ClasseTelasUsuario();
    MensagensUsuario msg = new MensagensUsuario();
    
    public InterfaceMultas(java.awt.Frame telaorigem, boolean modal, ClasseTelasUsuario usuario) {
        super (telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setTelasusuario(usuario);
        analisausuario();
        valida.validacamposCancelar(jPanel1, jPanel1);
        multa.getultimamulta();
        SpDiasAlerta.setValue(multa.getDiasalerta());
        SpDiasAcresc.setValue(multa.getDiasacresc());
        TfPercMulta.setValue(BigDecimal.valueOf(multa.getPercent()));
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
        SpDiasAlerta = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SpDiasAcresc = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BtAlterar = new javax.swing.JButton();
        BtGravar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        TfPercMulta = new JNumberField.JNumberField(2);
        ;
        jPanel2 = new javax.swing.JPanel();
        LbNotificacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("O Usuário será ALERTADO sobre o vencimento de uma conta, após ");

        SpDiasAlerta.setToolTipText("");

        jLabel2.setText("dias úteis passados da data de vencimento da conta.");

        jLabel3.setText("O Sistema fará a APLICAÇÃO DA PORCENTAGEM DE ACRÉSCIMO DA CONTA, após ");

        jLabel4.setText("dias úteis passados da data de vencimento da conta.");

        jLabel5.setText("A PORCENTAGEM DE ACRÉSCIMO DA CONTA (porcentagem da multa), é de ");

        jLabel6.setText("%   sobre o valor da conta.");

        BtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/editar.png"))); // NOI18N
        BtAlterar.setText("Alterar");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SpDiasAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SpDiasAcresc, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TfPercMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(SpDiasAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(SpDiasAcresc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(TfPercMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed
        valida.validacamposCadastrar(jPanel1, jPanel1);
    }//GEN-LAST:event_BtAlterarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed
        valida.validacamposCancelar(jPanel1, jPanel1);
        multa.getultimamulta();
        SpDiasAlerta.setValue(multa.getDiasalerta());
        SpDiasAcresc.setValue(multa.getDiasacresc());
        TfPercMulta.setValue(BigDecimal.valueOf(multa.getPercent()));
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGravarActionPerformed
        if(camposobrigatoriospreenchidos()){
            if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja gravar as alterações dos dados de multa?", "Deseja gravar?",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                enviardados();
                multa.incluir();
                BtCancelarActionPerformed(evt);
            }
        }
    }//GEN-LAST:event_BtGravarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtGravar;
    private javax.swing.JLabel LbNotificacao;
    private javax.swing.JSpinner SpDiasAcresc;
    private javax.swing.JSpinner SpDiasAlerta;
    private JNumberField.JNumberField TfPercMulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public void analisausuario(){
//        getTelasusuario().getTela().setCodigo(9);
//        if(!getTelasusuario().eadmintela()){
//            BtAlterar.setVisible(false);
//            BtCancelar.setVisible(false);
//            BtGravar.setVisible(false);
//        }
    }
    
    public boolean camposobrigatoriospreenchidos(){
        if(Integer.parseInt(SpDiasAlerta.getValue().toString()) < 0){
            msg.CampoObrigatorioNaoPreenchido(LbNotificacao, "Não é permitido um número negativo de dias!");
            SpDiasAlerta.setValue(0);
            SpDiasAlerta.grabFocus();
            return false;
        }
        if(Integer.parseInt(SpDiasAcresc.getValue().toString()) < 0){
            msg.CampoNaoPreenchido(LbNotificacao, "Não é permitido um número negativo de dias!");
            SpDiasAcresc.setValue(0);
            SpDiasAcresc.grabFocus();
            return false;
        }
        if(Integer.parseInt(SpDiasAlerta.getValue().toString()) > Integer.parseInt(SpDiasAcresc.getValue().toString())){
            msg.CampoNaoPreenchido(LbNotificacao, "O número de dias para o aviso ao usuário deve ser\nmenor que o dia de acréscimo do valor!");
            return false;
        }
        return true;
    }
    
    public void enviardados(){
        multa.setDiasalerta(Integer.parseInt(SpDiasAlerta.getValue().toString()));
        multa.setDiasacresc(Integer.parseInt(SpDiasAcresc.getValue().toString()));
        multa.setPercent(Float.parseFloat(TfPercMulta.getValue().toString()));
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
