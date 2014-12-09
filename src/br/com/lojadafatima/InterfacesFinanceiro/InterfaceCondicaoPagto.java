package br.com.lojadafatima.InterfacesFinanceiro;

import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.LimpaCamposTela;
import br.com.lojadafatima.ClassesFerramentas.NaoPermiteAspasSimples;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.Financeiro.ClasseCondicaoPagamento;
import br.com.lojadafatima.Usuario.ClasseTelasUsuario;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author hp
 */
public class InterfaceCondicaoPagto extends javax.swing.JDialog {

    private java.awt.Frame primeiratela;
    Preenche preenche = new Preenche();
    ClasseCondicaoPagamento condicao = new ClasseCondicaoPagamento();
    LimpaCamposTela limpar = new LimpaCamposTela();
    GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();
    private ClasseTelasUsuario telasusuario = new ClasseTelasUsuario();

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

        jLabel1.setText("Código");

        TfCodigo.setEditable(false);

        jLabel2.setText("Descrição da condição de pagamento*");

        TfCondicaoPgto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfCondicaoPgtoKeyTyped(evt);
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

        jLabel3.setText("Número de parcelas*");

        jLabel4.setText("Intervalo de dias entre as parcelas*");

        jLabel5.setText("Entrada:");

        RgComSemEntrada.add(RbComEntrada);
        RbComEntrada.setSelected(true);
        RbComEntrada.setText("Pagamento COM Entrada");

        RgComSemEntrada.add(RbSemEntrada);
        RbSemEntrada.setText("Pagamento SEM Entrada");
        RbSemEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbSemEntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(SpNrParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SpIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TfCondicaoPgto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)))
                    .addComponent(RbComEntrada)
                    .addComponent(RbSemEntrada)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(TfCondicaoPgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpNrParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RbComEntrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RbSemEntrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtGravar)
                    .addComponent(BtLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void RbSemEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbSemEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RbSemEntradaActionPerformed

    private void BtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGravarActionPerformed
        if (camposobrigatoriospreenchidos()) {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja gravar os dados desta condição de pagamento?", "Deseja gravar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                enviardados();
                if (TfCodigo.getText().equals("")) {
                    condicao.incluir();
                    limpar.Limpar(jPanel1);
                    SpIntervalo.setValue(0);
                    SpNrParcelas.setValue(0);
                    preenche.PreencherJtable(TbConsulta, condicao.retornacondicoespagamentojtable());
                } else {
                    condicao.setCodigo(Integer.parseInt(TfCodigo.getText()));
                    condicao.alterar();
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
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtGravar;
    private javax.swing.JButton BtLimpar;
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
            JOptionPane.showMessageDialog(null, "Digite uma descrição para a condição de pagamento!", "Campos obrigatórios", JOptionPane.INFORMATION_MESSAGE);
            TfCondicaoPgto.grabFocus();
            return false;
        }
        if (Integer.parseInt(SpNrParcelas.getValue().toString()) <= 0) {
            JOptionPane.showMessageDialog(null, "O número de parcelas deve ser maior que 0!", "Campos obrigatórios", JOptionPane.INFORMATION_MESSAGE);
            SpNrParcelas.grabFocus();;
            return false;
        }
        if (Integer.parseInt(SpIntervalo.getValue().toString()) <= 0) {
            JOptionPane.showMessageDialog(null, "O número do intervalo de dias deve ser maior que 0!", "Campos obrigatórios", JOptionPane.INFORMATION_MESSAGE);
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
