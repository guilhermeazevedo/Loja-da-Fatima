package br.com.lojadafatima.InterfaceConsultaSimples;

import br.com.lojadafatima.ClassesFerramentas.MensagensUsuario;
import br.com.lojadafatima.ClassesFerramentas.NaoPermiteAspasSimples;
import br.com.lojadafatima.ClassesFerramentas.PermiteApenasNumeros;
import br.com.lojadafatima.ClassesFerramentas.PermiteNumerosPontoBarra;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.Pessoa.ClasseFornecedor;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Guilherme Azevedo
 */
public class ConsulSimplesFornecedor extends javax.swing.JDialog {
    
    private java.awt.Frame primeiratela;
    Preenche preenche = new Preenche();
    private ClasseFornecedor fornecedor = new ClasseFornecedor();
    MensagensUsuario msg = new MensagensUsuario();
    
   public ConsulSimplesFornecedor(java.awt.Frame telaorigem, boolean modal, ClasseFornecedor forn) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setFornecedor(forn);
        TbPesquisa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CbPesquisa = new javax.swing.JComboBox();
        TfPesquisa = new javax.swing.JTextField();
        BtPesquisa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbPesquisa = new javax.swing.JTable();
        BtSelecionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        LbNotificacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Rápida de Fornecedor - Software Loja da Fátima");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CbPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos os Fornecedores", "Código", "Nome Fantasia", "CNPJ" }));
        CbPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPesquisaActionPerformed(evt);
            }
        });
        jPanel1.add(CbPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        TfPesquisa.setEnabled(false);
        jPanel1.add(TfPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 11, 313, -1));

        BtPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/buscar.png"))); // NOI18N
        BtPesquisa.setText("Pesquisar");
        BtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPesquisaActionPerformed(evt);
            }
        });
        jPanel1.add(BtPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 11, -1, 20));

        TbPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Fantasia", "CNPJ", "Data do Cadastro"
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 37, 575, 155));

        BtSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/sucesso2.png"))); // NOI18N
        BtSelecionar.setText("Selecionar");
        BtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSelecionarActionPerformed(evt);
            }
        });
        jPanel1.add(BtSelecionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 201, 111, 45));

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/cancelar.png"))); // NOI18N
        BtCancelar.setText("Cancelar");
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(BtCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 201, 104, 45));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 252, 575, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                TfPesquisa.setDocument(new PermiteNumerosPontoBarra());
                break;
            }
        }
    }//GEN-LAST:event_CbPesquisaActionPerformed

    private void BtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPesquisaActionPerformed
        int[] parametro = new int[4];
        parametro[0] = 70;
        parametro[1] = 200;
        parametro[2] = 100;
        parametro[3] = 70;
        preenche.FormataJtable(TbPesquisa, parametro);

        switch (CbPesquisa.getSelectedIndex()) {
            case 0: {
                preenche.PreencherJtable(TbPesquisa, fornecedor.consultageral());
                break;
            }
            case 1: {
                if (TfPesquisa.getText().equals("")) {
                    msg.CampoNaoPreenchido(LbNotificacao, "Digite o código do fornecedor que deseja consultar!");
                    TfPesquisa.grabFocus();
                } else {
                    fornecedor.setCodigo(Integer.parseInt(TfPesquisa.getText()));
                    preenche.PreencherJtable(TbPesquisa, fornecedor.consultacodigo());
                }
                break;
            }
            case 2:{
                if (TfPesquisa.getText().equals("")) {
                    msg.CampoNaoPreenchido(LbNotificacao, "Digite o nome fantasia do fornecedor que deseja consultar!");
                    TfPesquisa.grabFocus();
                } else {
                    fornecedor.getPessoajur().setNomefantasia(TfPesquisa.getText());
                    preenche.PreencherJtable(TbPesquisa, fornecedor.consultanomefantasia());
                }
                break;
            }
            case 3:{
                if (TfPesquisa.getText().equals("")) {
                    msg.CampoNaoPreenchido(LbNotificacao, "Digite o CNPJ do fornecedor que deseja consultar!");
                    TfPesquisa.grabFocus();
                } else {
                    fornecedor.getPessoajur().setCnpj(TfPesquisa.getText());
                    preenche.PreencherJtable(TbPesquisa, fornecedor.consultaCNPJ());
                }
                break;
            }
        }
    }//GEN-LAST:event_BtPesquisaActionPerformed

    private void BtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSelecionarActionPerformed
        if(TbPesquisa.getSelectedRow() > -1){
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um fornecedor para retornar para a tela anterior!", "A pesquisa não retornou valores", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtSelecionarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed
        getFornecedor().setCodigo(0);
        dispose();
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void TbPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbPesquisaMouseClicked
        if(TbPesquisa.getSelectedRow() > -1)
        getFornecedor().setCodigo(Integer.parseInt(TbPesquisa.getValueAt(TbPesquisa.getSelectedRow(), 0).toString()));
    }//GEN-LAST:event_TbPesquisaMouseClicked


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

    public java.awt.Frame getPrimeiratela() {
        return primeiratela;
    }

    public void setPrimeiratela(java.awt.Frame primeiratela) {
        this.primeiratela = primeiratela;
    }

    public ClasseFornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(ClasseFornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

}
