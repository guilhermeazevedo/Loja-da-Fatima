package br.com.lojadafatima.InterfacesOperacoes;

import br.com.lojadafatima.ClassesFerramentas.ClasseDatas;
import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.Financeiro.ClasseParcelas;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Guilherme Azevedo
 */
public class InterfaceAjusteDatasEPrecos extends javax.swing.JDialog {

    private java.awt.Frame primeiratela;
    private ClasseParcelas parcelas = new ClasseParcelas();
    Preenche preenche = new Preenche();
    MaskFormatter data;

    public InterfaceAjusteDatasEPrecos(java.awt.Frame telaorigem, boolean modal, ClasseParcelas parc) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        setParcelas(parc);
        initComponents();
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        int[] tam = new int[3];
        tam[0] = 150;
        tam[1] = 300;
        tam[2] = 300;
        preenche.FormataJtable(TbParcelas, tam);

        preenche.PreencherJtable(TbParcelas, getParcelas().buscaparcelasajuste());
        DecimalFormat df = new DecimalFormat("0.00");
        TfValorTotal.setValue(BigDecimal.valueOf(getParcelas().getConta().getTotal()));
        TbParcelas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TbParcelas = new javax.swing.JTable();
        BtFinalizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TfValorTotal = new JNumberField.JNumberField();
        jLabel3 = new javax.swing.JLabel();
        TfNrParcela = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        try{
            data = new MaskFormatter("##/##/####");
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Nao foi possivel localizar");
        }
        TfDtVencimento = new JFormattedTextField(data);
        jLabel5 = new javax.swing.JLabel();
        TfValor = new JNumberField.JNumberField();
        BtAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajuste de Datas e Preços de Parcelas - Software Loja da Fátima");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ajuste as datas e preços da melhor forma (caso você feche esta janela, as datas das parcelas e preços serão mantidos):");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        TbParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nrº Parcela", "Data de Vencimento", "Valor da Parcela (R$)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbParcelas.getTableHeader().setReorderingAllowed(false);
        TbParcelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TbParcelasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TbParcelas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 670, 218));

        BtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/sucesso2.png"))); // NOI18N
        BtFinalizar.setText("Finalizar");
        BtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtFinalizarActionPerformed(evt);
            }
        });
        jPanel1.add(BtFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 311, 104, 40));

        jLabel2.setText("Valor Total:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 314, -1, -1));

        TfValorTotal.setEditable(false);
        jPanel1.add(TfValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 311, 100, -1));

        jLabel3.setText("Nrº da Parcela");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 255, -1, -1));

        TfNrParcela.setEditable(false);
        jPanel1.add(TfNrParcela, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 277, 104, -1));

        jLabel4.setText("Data de Vencimento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 255, -1, -1));

        TfDtVencimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TfDtVencimentoFocusLost(evt);
            }
        });
        jPanel1.add(TfDtVencimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 277, 118, -1));

        jLabel5.setText("Valor da Parcela");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 255, -1, -1));
        jPanel1.add(TfValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 277, 112, -1));

        BtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/editar.png"))); // NOI18N
        BtAlterar.setText("Alterar data e/ou valor desta parcela");
        BtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(BtAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 275, -1, -1));

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

    private void BtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtFinalizarActionPerformed
        if (valortotalcorreto()) {
            if (datascorretas()) {
                if (JOptionPane.showConfirmDialog(null, "Tem certeza que as datas e valores estão corretos?", "Confirmar datas e valores", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    for (int i = 0; i < TbParcelas.getRowCount(); i++) {
                        getParcelas().setCodigo(Integer.parseInt(TbParcelas.getValueAt(i, 0).toString()));
                        getParcelas().setDtpagar(TbParcelas.getValueAt(i, 1).toString());
                        TfValor.setText(TbParcelas.getValueAt(i, 2).toString());
                        getParcelas().setVlpagar(Float.parseFloat(TfValor.getValue().toString()));
                        getParcelas().atualizarparcela();
                    }
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifique se as datas estão digitadas corretamente!", "Datas digitadas incorretamente", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifique se os valores estão digitados corretamente e se estão de acordo com o total da operação!", "Valores diferentes", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtFinalizarActionPerformed

    private void TbParcelasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbParcelasMouseReleased
        if(TbParcelas.getSelectedRow() > -1){
            TfNrParcela.setText(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 0).toString());
            TfDtVencimento.setText(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 1).toString());
            TfValor.setText(TbParcelas.getValueAt(TbParcelas.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_TbParcelasMouseReleased

    private void TfDtVencimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TfDtVencimentoFocusLost
        GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();
        ClasseDatas datas = new ClasseDatas();
        if(valida.CampoTotalmentePreenchido(TfDtVencimento.getText())){
            if(!datas.validadatas(TfDtVencimento.getText())){
                TfDtVencimento.setValue(null);
            }
        }
    }//GEN-LAST:event_TfDtVencimentoFocusLost

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed
        if(!TfDtVencimento.getText().equals("  /  /    ")){
            TbParcelas.setValueAt(TfDtVencimento.getText(), TbParcelas.getSelectedRow(), 1);
            TbParcelas.setValueAt(TfValor.getText(), TbParcelas.getSelectedRow(), 2);
            TfNrParcela.setText("");
            TfDtVencimento.setValue(null);
            TfValor.setText("0");
        }else{
            JOptionPane.showMessageDialog(null, "Digite a data de vencimento da parcela!", "Digite a data de vencimento", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtAlterarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(JOptionPane.showConfirmDialog(null, "Voce está prestes a fechar esta janela.\nCaso você feche essa janela, todas as alteraões feitas\nnos valores e datas das parcelas serão ignoradas.\n\nDeseja realmente fechar esta janela?", "Deseja fechar esta janela?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtFinalizar;
    private javax.swing.JTable TbParcelas;
    private javax.swing.JFormattedTextField TfDtVencimento;
    private javax.swing.JTextField TfNrParcela;
    private JNumberField.JNumberField TfValor;
    private JNumberField.JNumberField TfValorTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public boolean valortotalcorreto() {
        float totalparcelas = 0;
        for (int i = 0; i < TbParcelas.getRowCount(); i++) {
            TfValor.setText(TbParcelas.getValueAt(i, 2).toString());
            if (CampoValorCorreto(TfValor.getValue().toString())) {
                totalparcelas = totalparcelas + Float.parseFloat(TfValor.getValue().toString());
            } else {
                return false;
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        totalparcelas = Float.parseFloat(df.format(totalparcelas).replace(",", "."));
        if (totalparcelas == getParcelas().getConta().getTotal()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean datascorretas() {
        ClasseDatas datas = new ClasseDatas();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        Date date1 = null, date2 = null;
        String data1, data2;
        for (int i = 0; i < TbParcelas.getRowCount(); i++) {
            if (i == 0) {
                data1 = datas.retornadataatual();
                data2 = TbParcelas.getValueAt(i, 1).toString();
            } else {
                data1 = TbParcelas.getValueAt(i - 1, 1).toString();
                data2 = TbParcelas.getValueAt(i, 1).toString();
            }
            try {
                date1 = format.parse(data1);
                date2 = format.parse(data2);
            } catch (ParseException ex) {
                return false;
            }
            if (date1.after(date2)) {
                return false;
            }
        }
        return true;
    }

    public boolean CampoValorCorreto(String str) {
        try {
            float n = Float.parseFloat(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public java.awt.Frame getPrimeiratela() {
        return primeiratela;
    }

    public void setPrimeiratela(java.awt.Frame primeiratela) {
        this.primeiratela = primeiratela;
    }

    public ClasseParcelas getParcelas() {
        return parcelas;
    }

    public void setParcelas(ClasseParcelas parcelas) {
        this.parcelas = parcelas;
    }
}
