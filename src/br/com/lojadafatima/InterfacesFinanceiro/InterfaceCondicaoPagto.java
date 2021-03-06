package br.com.lojadafatima.InterfacesFinanceiro;

import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.LimpaCamposTela;
import br.com.lojadafatima.ClassesFerramentas.MensagensUsuario;
import br.com.lojadafatima.ClassesFerramentas.NaoPermiteAspasSimples;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.Financeiro.ClasseCondicaoPagamento;
import br.com.lojadafatima.Usuario.ClasseTelasUsuario;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Guilherme Azevedo
 */
public class InterfaceCondicaoPagto extends javax.swing.JDialog {

    private java.awt.Frame primeiratela;
    Preenche preenche = new Preenche();
    ClasseCondicaoPagamento condicao = new ClasseCondicaoPagamento();
    LimpaCamposTela limpar = new LimpaCamposTela();
    GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();
    private ClasseTelasUsuario telasusuario = new ClasseTelasUsuario();
    MensagensUsuario msg = new MensagensUsuario();

    public InterfaceCondicaoPagto(java.awt.Frame telaorigem, boolean modal, ClasseTelasUsuario usuario) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setTelasusuario(usuario);
        analisausuario();
        int[] tam = new int[5];
        tam[0] = 50;
        tam[1] = 100;
        tam[2] = 50;
        tam[3] = 50;
        tam[4] = 70;
        preenche.FormataJtable(TbConsulta, tam);
        TbConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        preenche.PreencherJtable(TbConsulta, condicao.retornacondicoespagamentojtable());
        TfCondicaoPgto.setDocument(new NaoPermiteAspasSimples());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RgComSemEntrada = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TfCondicaoPgto = new javax.swing.JTextField();
        BtGravar = new javax.swing.JButton();
        BtLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbConsulta = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SpNrParcelas = new javax.swing.JSpinner();
        SpIntervalo = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        RbComEntrada = new javax.swing.JRadioButton();
        RbSemEntrada = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        LbNotificacao = new javax.swing.JLabel();

        jMenuItem1.setText("Carregar dados");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Condição de Pagamento - Software Loja da Fatima");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Código");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        TfCodigo.setEditable(false);
        jPanel1.add(TfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 100, -1));

        jLabel2.setText("Descrição da condição de pagamento");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 11, -1, -1));

        TfCondicaoPgto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfCondicaoPgtoKeyTyped(evt);
            }
        });
        jPanel1.add(TfCondicaoPgto, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 31, 200, -1));

        BtGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/salvar.png"))); // NOI18N
        BtGravar.setText("Gravar");
        BtGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGravarActionPerformed(evt);
            }
        });
        jPanel1.add(BtGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 172, 89, -1));

        BtLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/deletar.png"))); // NOI18N
        BtLimpar.setText("Limpar");
        BtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtLimparActionPerformed(evt);
            }
        });
        jPanel1.add(BtLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 172, 85, -1));

        TbConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Nrº de Parcelas", "Intervalo de Dias", "Entrada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 203, 318, 161));

        jLabel3.setText("Número de parcelas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 57, -1, -1));

        jLabel4.setText("Intervalo de dias entre as parcelas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 57, -1, -1));
        jPanel1.add(SpNrParcelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 77, 74, -1));
        jPanel1.add(SpIntervalo, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 77, 98, -1));

        jLabel5.setText("Entrada:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 103, -1, -1));

        RgComSemEntrada.add(RbComEntrada);
        RbComEntrada.setSelected(true);
        RbComEntrada.setText("Pagamento COM Entrada");
        jPanel1.add(RbComEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 119, -1, -1));

        RgComSemEntrada.add(RbSemEntrada);
        RbSemEntrada.setText("Pagamento SEM Entrada");
        RbSemEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbSemEntradaActionPerformed(evt);
            }
        });
        jPanel1.add(RbSemEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 142, -1, -1));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 318, -1));

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

    private void RbSemEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbSemEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbSemEntradaActionPerformed

    private void BtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGravarActionPerformed
        if (camposobrigatoriospreenchidos()) {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja gravar os dados desta condição de pagamento?", "Deseja gravar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                enviardados();
                if (TfCodigo.getText().equals("")) {
                    if(condicao.incluir()){
                        msg.Sucesso(LbNotificacao, "Dados da Condição de Pagamento gravados com sucesso!");
                    }
                } else {
                    condicao.setCodigo(Integer.parseInt(TfCodigo.getText()));
                    if(condicao.alterar()){
                        msg.Sucesso(LbNotificacao, "Dados da Condição de Pagamento alterados com sucesso!");
                    }
                }
                limpar.Limpar(jPanel1);
                SpIntervalo.setValue(0);
                SpNrParcelas.setValue(0);
                preenche.PreencherJtable(TbConsulta, condicao.retornacondicoespagamentojtable());
            }
        }
    }//GEN-LAST:event_BtGravarActionPerformed

    private void BtLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLimparActionPerformed
        limpar.Limpar(jPanel1);
        SpIntervalo.setValue(0);
        SpNrParcelas.setValue(0);
    }//GEN-LAST:event_BtLimparActionPerformed

    private void TfCondicaoPgtoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCondicaoPgtoKeyTyped
        valida.limitemaximo(evt, TfCondicaoPgto.getText(), 50);
    }//GEN-LAST:event_TfCondicaoPgtoKeyTyped

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (TbConsulta.getSelectedRow() > 0) {
            TfCodigo.setText(TbConsulta.getValueAt(TbConsulta.getSelectedRow(), 0).toString());
            TfCondicaoPgto.setText(TbConsulta.getValueAt(TbConsulta.getSelectedRow(), 1).toString());
            SpNrParcelas.setValue(Integer.parseInt(TbConsulta.getValueAt(TbConsulta.getSelectedRow(), 2).toString()));
            SpIntervalo.setValue(Integer.parseInt(TbConsulta.getValueAt(TbConsulta.getSelectedRow(), 3).toString()));
            if (TbConsulta.getValueAt(TbConsulta.getSelectedRow(), 4).toString().equals("COM ENTRADA")) {
                RbComEntrada.setSelected(true);
            } else {
                RbSemEntrada.setSelected(true);
            }
            msg.StatusEditar(LbNotificacao, "Editando informações...");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtGravar;
    private javax.swing.JButton BtLimpar;
    private javax.swing.JLabel LbNotificacao;
    private javax.swing.JRadioButton RbComEntrada;
    private javax.swing.JRadioButton RbSemEntrada;
    private javax.swing.ButtonGroup RgComSemEntrada;
    private javax.swing.JSpinner SpIntervalo;
    private javax.swing.JSpinner SpNrParcelas;
    private javax.swing.JTable TbConsulta;
    private javax.swing.JTextField TfCodigo;
    private javax.swing.JTextField TfCondicaoPgto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void analisausuario(){
        getTelasusuario().getTela().setCodigo(6);
        if(!getTelasusuario().eadmintela()){
            BtGravar.setVisible(false);
        }
    }
    
    public boolean camposobrigatoriospreenchidos() {
        if (TfCondicaoPgto.getText().equals("")) {
            msg.CampoObrigatorioNaoPreenchido(LbNotificacao, "Digite uma descrição para a condição de pagamento!");
            TfCondicaoPgto.grabFocus();
            return false;
        }
        if (Integer.parseInt(SpNrParcelas.getValue().toString()) <= 0) {
            msg.CampoObrigatorioNaoPreenchido(LbNotificacao, "O número de parcelas deve ser maior que 0!");
            SpNrParcelas.grabFocus();;
            return false;
        }
        if (Integer.parseInt(SpIntervalo.getValue().toString()) <= 0) {
            msg.CampoObrigatorioNaoPreenchido(LbNotificacao, "O número do intervalo de dias deve ser maior que 0!");
            SpNrParcelas.grabFocus();;
            return false;
        }
        return true;
    }

    public void enviardados() {
        condicao.setCondicaodepgto(TfCondicaoPgto.getText());
        condicao.setNrparcelas(Integer.parseInt(SpNrParcelas.getValue().toString()));
        condicao.setIntervalodias(Integer.parseInt(SpIntervalo.getValue().toString()));
        if (RbSemEntrada.isSelected()) {
            condicao.setEntrada("N");
        } else {
            condicao.setEntrada("S");
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
