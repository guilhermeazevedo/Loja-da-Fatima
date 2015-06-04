/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.InterfacesFinanceiro;

import br.com.lojadafatima.ClassesFerramentas.ClasseDatas;
import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.ClassesFerramentas.Relatorios;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import br.com.lojadafatima.Financeiro.ClasseMvtoCaixa;
import br.com.lojadafatima.Usuario.ClasseTelasUsuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author hp
 */
public class InterfaceMovimentacaoCaixa extends javax.swing.JDialog {

    private java.awt.Frame primeiratela;
    Preenche preenche = new Preenche();
    ClasseMvtoCaixa mvtocaixa = new ClasseMvtoCaixa();
    private ClasseTelasUsuario telasusuario = new ClasseTelasUsuario();
    GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();
    ClasseDatas datas = new ClasseDatas();
    MaskFormatter data;
    
    public InterfaceMovimentacaoCaixa(java.awt.Frame telaorigem, boolean modal, ClasseTelasUsuario usuario) {
        super (telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setTelasusuario(usuario);
        analisausuario();
        int[] tam = new int[7];
        tam[0] = 80;
        tam[1] = 500;
        tam[2] = 180;
        tam[3] = 100;
        tam[4] = 100;
        tam[5] = 80;
        tam[6] = 100;
        preenche.FormataJtable(TbMvtoCaixa, tam);
        TbMvtoCaixa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TfDtInicial.setText(datas.retornaratartual());
        TfDtFinal.setText(datas.retornaratartual());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        BtGerarRelatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbMvtoCaixa = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        try{
            data = new MaskFormatter("##/##/####");
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Nao foi possivel localizar");
        }
        TfDtInicial = new JFormattedTextField(data);
        try{
            data = new MaskFormatter("##/##/####");
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Nao foi possivel localizar");
        }
        TfDtFinal = new JFormattedTextField(data);
        jLabel3 = new javax.swing.JLabel();
        RbEntSai = new javax.swing.JRadioButton();
        RbEntradas = new javax.swing.JRadioButton();
        RbSaidas = new javax.swing.JRadioButton();
        BtSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimento de Caixa - Software Loja da Fátima");
        setResizable(false);

        BtGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/imprimir.png"))); // NOI18N
        BtGerarRelatorio.setText("Gerar Relatório");
        BtGerarRelatorio.setEnabled(false);
        BtGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGerarRelatorioActionPerformed(evt);
            }
        });

        TbMvtoCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nrº da Movimentação", "Referente a/Motivo do Mvto.", "Data e Hora", "Quant. Antes", "Quant. Movimentado", "Tipo", "Saldo após Mvto."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbMvtoCaixa.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TbMvtoCaixa);

        jLabel2.setText("Período:");

        TfDtInicial.setName("DT_NASC"); // NOI18N
        TfDtInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TfDtInicialFocusLost(evt);
            }
        });

        TfDtFinal.setName("DT_NASC"); // NOI18N
        TfDtFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TfDtFinalFocusLost(evt);
            }
        });

        jLabel3.setText("a");

        buttonGroup1.add(RbEntSai);
        RbEntSai.setSelected(true);
        RbEntSai.setText("Entradas e Saídas");

        buttonGroup1.add(RbEntradas);
        RbEntradas.setText("Entradas");

        buttonGroup1.add(RbSaidas);
        RbSaidas.setText("Saídas");

        BtSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/sucesso2.png"))); // NOI18N
        BtSelecionar.setText("Selecionar");
        BtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TfDtInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TfDtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtGerarRelatorio))
                    .addComponent(RbEntSai)
                    .addComponent(RbEntradas)
                    .addComponent(RbSaidas)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1055, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TfDtInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfDtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtSelecionar)
                    .addComponent(BtGerarRelatorio)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RbEntSai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RbEntradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RbSaidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGerarRelatorioActionPerformed
        if(datas.validadatas(TfDtInicial.getText()) && datas.validadatas(TfDtFinal.getText()) && datascorretas() && TbMvtoCaixa.getRowCount() > 0){
            HashMap par = new HashMap();
        
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                par.put("DT_INICIAL", format.parse(TfDtInicial.getText()));
                par.put("DT_FINAL", format.parse(TfDtFinal.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(InterfaceMovimentacaoCaixa.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(RbEntSai.isSelected()) par.put("TIPO_MVTO", "");
            if(RbEntradas.isSelected()) par.put("TIPO_MVTO", "S");
            if(RbSaidas.isSelected()) par.put("TIPO_MVTO", "E");

            String desc = "";
            if(RbEntSai.isSelected()) desc += "Entradas e saídas que aconteceram no Caixa ";
            if(RbEntradas.isSelected()) desc += "Entradas que aconteceram no Caixa ";
            if(RbSaidas.isSelected()) desc += "Saídas que aconteceram no Caixa ";
            
            if(TfDtInicial.getText().equals(TfDtFinal.getText())) desc += "no dia "+TfDtInicial.getText();
            else                                                  desc += "do dia "+TfDtInicial.getText()+" ao "+TfDtFinal.getText();
            par.put("DS_RELATORIO", desc);
            ConexaoPostgre conexao = new ConexaoPostgre();
            JDialog dialog = new JDialog(new javax.swing.JFrame(), "Visualização - Software Loja da Fátima", true);
                        dialog.setSize(1000, 700);
            dialog.setLocationRelativeTo(null);
            try {
                JasperPrint print = JasperFillManager.fillReport("relatorios\\mvtocaixadia.jasper", par, conexao.conecta());
                            
                JasperViewer viewer = new JasperViewer(print, true);
                dialog.getContentPane().add(viewer.getContentPane());
                dialog.setVisible(true);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_BtGerarRelatorioActionPerformed

    private void TfDtInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TfDtInicialFocusLost
        if (valida.CampoTotalmentePreenchido(TfDtInicial.getText())) {
            if (datas.validadatas(TfDtInicial.getText())) {

            } else {
                TfDtInicial.setValue(null);
            }
        }
    }//GEN-LAST:event_TfDtInicialFocusLost

    private void TfDtFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TfDtFinalFocusLost
        if (valida.CampoTotalmentePreenchido(TfDtFinal.getText())) {
            if (datas.validadatas(TfDtFinal.getText())) {

            } else {
                TfDtFinal.setValue(null);
            }
        }
    }//GEN-LAST:event_TfDtFinalFocusLost

    private void BtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSelecionarActionPerformed
        if(datas.validadatas(TfDtInicial.getText()) && datas.validadatas(TfDtFinal.getText()) && datascorretas()){
            if(RbEntSai.isSelected()) preenche.PreencherJtable(TbMvtoCaixa, mvtocaixa.mvtocaixa(TfDtInicial.getText(), TfDtFinal.getText(), ""));
            if(RbEntradas.isSelected()) preenche.PreencherJtable(TbMvtoCaixa, mvtocaixa.mvtocaixa(TfDtInicial.getText(), TfDtFinal.getText(), "S"));
            if(RbSaidas.isSelected()) preenche.PreencherJtable(TbMvtoCaixa, mvtocaixa.mvtocaixa(TfDtInicial.getText(), TfDtFinal.getText(), "E"));
            BtGerarRelatorio.setEnabled(true);
        }
    }//GEN-LAST:event_BtSelecionarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtGerarRelatorio;
    private javax.swing.JButton BtSelecionar;
    private javax.swing.JRadioButton RbEntSai;
    private javax.swing.JRadioButton RbEntradas;
    private javax.swing.JRadioButton RbSaidas;
    private javax.swing.JTable TbMvtoCaixa;
    private javax.swing.JFormattedTextField TfDtFinal;
    private javax.swing.JFormattedTextField TfDtInicial;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void analisausuario(){
//        getTelasusuario().getTela().setCodigo(19);
//        if(!getTelasusuario().eadmintela()){
//            BtGerarRelatorio.setVisible(false);
//        }
    }
    
    public boolean datascorretas() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        Date date1 = null, date2 = null;
        String data1, data2;
        data1 = TfDtInicial.getText();
        data2 = TfDtFinal.getText();           
        try {
            date1 = format.parse(data1);
            date2 = format.parse(data2);
        } catch (ParseException ex) {
            return false;
        }
        if (date1.after(date2)) {
            return false;
        }
        
        return true;
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
