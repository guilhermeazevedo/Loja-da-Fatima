package br.com.lojadafatima.InterfaceConsultaSimples;

import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.Financeiro.ClasseCondicaoPagamento;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author hp
 */
public class ConsulSimplesCondicaoPgto extends javax.swing.JDialog {

    Preenche preenche = new Preenche();
    private ClasseCondicaoPagamento condicao = new ClasseCondicaoPagamento();
    private java.awt.Frame primeiratela;
    
    public ConsulSimplesCondicaoPgto(java.awt.Frame telaorigem, boolean modal, ClasseCondicaoPagamento cond) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setCondicao(cond);
        int[] tam = new int[5];
        tam[0] = 50;
        tam[1] = 100;
        tam[2] = 50;
        tam[3] = 50;
        tam[4] = 70;
        preenche.FormataJtable(TbConsulta, tam);
        TbConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        preenche.PreencherJtable(TbConsulta, condicao.retornacondicoespagamentojtable());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TbConsulta = new javax.swing.JTable();
        BtSelecionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Rápida de Condição de Pagamento - Software Loja da Fátima");

        TbConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Nrº de parcelas", "Intervalo de dias", "Entrada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbConsulta.getTableHeader().setReorderingAllowed(false);
        TbConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbConsulta);

        BtSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/sucesso2.png"))); // NOI18N
        BtSelecionar.setText("Selecionar");
        BtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSelecionarActionPerformed(evt);
            }
        });

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/cancelar.png"))); // NOI18N
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed
        getCondicao().setCodigo(0);
        dispose();
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSelecionarActionPerformed
        if(TbConsulta.getSelectedRow() > -1){
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma condição de pagamento da tabela para retornar para janela anterior!", "Selecione uma condição de pagamento",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtSelecionarActionPerformed

    private void TbConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbConsultaMouseClicked
        if(TbConsulta.getSelectedRow() > -1){
            getCondicao().setCodigo(Integer.parseInt(TbConsulta.getValueAt(TbConsulta.getSelectedRow(), 0).toString()));
        }
    }//GEN-LAST:event_TbConsultaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtSelecionar;
    private javax.swing.JTable TbConsulta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public ClasseCondicaoPagamento getCondicao() {
        return condicao;
    }

    public void setCondicao(ClasseCondicaoPagamento condicao) {
        this.condicao = condicao;
    }

    public java.awt.Frame getPrimeiratela() {
        return primeiratela;
    }

    public void setPrimeiratela(java.awt.Frame primeiratela) {
        this.primeiratela = primeiratela;
    }
    
}
