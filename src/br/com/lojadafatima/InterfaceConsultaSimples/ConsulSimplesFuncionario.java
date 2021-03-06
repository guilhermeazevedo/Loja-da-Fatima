package br.com.lojadafatima.InterfaceConsultaSimples;

import br.com.lojadafatima.ClassesFerramentas.MensagensUsuario;
import br.com.lojadafatima.ClassesFerramentas.NaoPermiteAspasSimples;
import br.com.lojadafatima.ClassesFerramentas.PermiteApenasNumeros;
import br.com.lojadafatima.ClassesFerramentas.PermiteNumerosPontoBarra;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.Pessoa.ClasseFuncionario;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Guilherme Azevedo
 */
public class ConsulSimplesFuncionario extends javax.swing.JDialog {

    Preenche preenche = new Preenche();
    private ClasseFuncionario funcionario = new ClasseFuncionario();
    private java.awt.Frame primeiratela;
    MensagensUsuario msg = new MensagensUsuario();
    
    public ConsulSimplesFuncionario(java.awt.Frame telaorigem, boolean modal, ClasseFuncionario func) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setFuncionario(func);
        TbPesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        CbPesquisa = new javax.swing.JComboBox();
        TfPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbPesquisa = new javax.swing.JTable();
        BtPesquisa = new javax.swing.JButton();
        BtSelecionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        LbNotificacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Rápida de Funcionário - Software Loja da Fátima");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CbPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos os Funcionários", "Código", "Nome", "Função", "CPF" }));
        CbPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPesquisaActionPerformed(evt);
            }
        });
        jPanel1.add(CbPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 160, -1));

        TfPesquisa.setEnabled(false);
        jPanel1.add(TfPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 11, 287, -1));

        TbPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Função", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbPesquisa.getTableHeader().setReorderingAllowed(false);
        TbPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbPesquisaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbPesquisa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 42, 570, 184));

        BtPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/buscar.png"))); // NOI18N
        BtPesquisa.setText("Pesquisar");
        BtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPesquisaActionPerformed(evt);
            }
        });
        jPanel1.add(BtPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 11, 109, -1));

        BtSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/sucesso2.png"))); // NOI18N
        BtSelecionar.setText("Selecionar");
        BtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSelecionarActionPerformed(evt);
            }
        });
        jPanel1.add(BtSelecionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 238, -1, 42));

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/cancelar.png"))); // NOI18N
        BtCancelar.setText("Cancelar");
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(BtCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 238, -1, 42));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CbPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPesquisaActionPerformed
        switch (CbPesquisa.getSelectedIndex()) {
            case 0: {
                TfPesquisa.setEnabled(false);
                TfPesquisa.setDocument(new NaoPermiteAspasSimples());
                break;
            }
            case 1: {
                TfPesquisa.setEnabled(true);
                TfPesquisa.setDocument(new PermiteApenasNumeros());
                break;
            }
            case 2: {
                TfPesquisa.setEnabled(true);
                TfPesquisa.setDocument(new NaoPermiteAspasSimples());
                break;
            }
            case 3: {
                TfPesquisa.setEnabled(true);
                TfPesquisa.setDocument(new NaoPermiteAspasSimples());
                break;
            }
            case 4: {
                TfPesquisa.setEnabled(true);
                TfPesquisa.setDocument(new PermiteNumerosPontoBarra());
                break;
            }
        }
    }//GEN-LAST:event_CbPesquisaActionPerformed

    private void BtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPesquisaActionPerformed
        int[] parametro = new int[4];
        parametro[0] = 70;
        parametro[1] = 300;
        parametro[2] = 200;
        parametro[3] = 70;
        preenche.FormataJtable(TbPesquisa, parametro);

        switch (CbPesquisa.getSelectedIndex()) {
            case 0: {
                preenche.PreencherJtable(TbPesquisa, funcionario.consultageral());
                break;
            }
            case 1: {
                if (TfPesquisa.getText().equals("")) {
                    msg.CampoNaoPreenchido(LbNotificacao, "Digite o código do funcionário que deseja consultar!");
                    TfPesquisa.grabFocus();
                } else {
                    funcionario.setCodigo(Integer.parseInt(TfPesquisa.getText()));
                    preenche.PreencherJtable(TbPesquisa, funcionario.consultacodigo());
                }
                break;
            }
            case 2: {
                if (TfPesquisa.getText().equals("")) {
                    msg.CampoNaoPreenchido(LbNotificacao, "Digite o nome do funcionário que deseja consultar!");
                    TfPesquisa.grabFocus();
                } else {
                    funcionario.getPessoafis().setNome(TfPesquisa.getText());
                    preenche.PreencherJtable(TbPesquisa, funcionario.consultanome());
                }
                break;
            }
            case 3: {
                if (TfPesquisa.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite a função do funcionário que deseja consultar!", "Digite a função", JOptionPane.INFORMATION_MESSAGE);
                    TfPesquisa.grabFocus();
                } else {
                    funcionario.setFuncao(TfPesquisa.getText());
                    preenche.PreencherJtable(TbPesquisa, funcionario.consultafuncao());
                }
                break;
            }
            case 4: {
                if (TfPesquisa.getText().equals("")) {
                    msg.CampoNaoPreenchido(LbNotificacao, "Digite o CPF do funcionário que deseja consultar!");
                    TfPesquisa.grabFocus();
                } else {
                    funcionario.getPessoafis().setCpf(TfPesquisa.getText());
                    preenche.PreencherJtable(TbPesquisa, funcionario.consultaCPF());
                }
                break;
            }
        }
    }//GEN-LAST:event_BtPesquisaActionPerformed

    private void TbPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbPesquisaMouseClicked
        if(TbPesquisa.getSelectedRow() > -1){
            funcionario.setCodigo(Integer.parseInt(TbPesquisa.getValueAt(TbPesquisa.getSelectedRow(), 0).toString()));
        }
    }//GEN-LAST:event_TbPesquisaMouseClicked

    private void BtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSelecionarActionPerformed
        if(TbPesquisa.getSelectedRow() > -1){
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um funcionário na tabela para retornar a janela anterior!", "Selecione um funcionário", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtSelecionarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed
        funcionario.setCodigo(0);
        dispose();
    }//GEN-LAST:event_BtCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtPesquisa;
    private javax.swing.JButton BtSelecionar;
    private javax.swing.JComboBox CbPesquisa;
    private javax.swing.JLabel LbNotificacao;
    private javax.swing.JTable TbPesquisa;
    private javax.swing.JTextField TfPesquisa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
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
