package br.com.lojadafatima.InterfaceConsultaSimples;

import br.com.lojadafatima.ClassesFerramentas.NaoPermiteAspasSimples;
import br.com.lojadafatima.ClassesFerramentas.PermiteApenasNumeros;
import br.com.lojadafatima.ClassesFerramentas.PermiteNumerosPontoBarra;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.Pessoa.ClasseFornecedor;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class ConsulSimplesFornecedor extends javax.swing.JDialog {
    
    private java.awt.Frame primeiratela;
    Preenche preenche = new Preenche();
    private ClasseFornecedor fornecedor = new ClasseFornecedor();
    
   public ConsulSimplesFornecedor(java.awt.Frame telaorigem, boolean modal, ClasseFornecedor forn) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setFornecedor(forn);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Rápida de Fornecedor - Software Loja da Fátima");
        setResizable(false);

        CbPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos os Fornecedores", "Código", "Nome Fantasia", "CNPJ" }));
        CbPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPesquisaActionPerformed(evt);
            }
        });

        TfPesquisa.setEnabled(false);

        BtPesquisa.setText("Pesquisar");
        BtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPesquisaActionPerformed(evt);
            }
        });

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(155, Short.MAX_VALUE)
                        .addComponent(TfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(CbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 414, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE)))
        );

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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    JOptionPane.showMessageDialog(null, "Digite o Codigo do fornecedor que deseja consultar!", "Digite o codigo", JOptionPane.INFORMATION_MESSAGE);
                    TfPesquisa.grabFocus();
                } else {
                    fornecedor.setCodigo(Integer.parseInt(TfPesquisa.getText()));
                    preenche.PreencherJtable(TbPesquisa, fornecedor.consultacodigo());
                }
                break;
            }
            case 2:{
                if (TfPesquisa.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite o Nome fantasia do fornecedor que deseja consultar!", "Digite o nome fantasia", JOptionPane.INFORMATION_MESSAGE);
                    TfPesquisa.grabFocus();
                } else {
                    fornecedor.getPessoajur().setNomefantasia(TfPesquisa.getText());
                    preenche.PreencherJtable(TbPesquisa, fornecedor.consultanomefantasia());
                }
                break;
            }
            case 3:{
                if (TfPesquisa.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite o CNPJ do fornecedor que deseja consultar!", "Digite o CNPJ", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Selecione um fornecedor para retornar para a tela anterior!", "A pesquisa nao retornou valores", JOptionPane.INFORMATION_MESSAGE);
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
    private javax.swing.JTable TbPesquisa;
    private javax.swing.JTextField TfPesquisa;
    private javax.swing.JPanel jPanel1;
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
