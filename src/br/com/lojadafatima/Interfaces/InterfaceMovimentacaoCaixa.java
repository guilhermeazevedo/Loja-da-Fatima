/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lojadafatima.Interfaces;

import br.com.lojadafatima.ClassesFerramentas.ClasseDatas;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.ClassesFerramentas.Relatorios;
import br.com.lojadafatima.Financeiro.ClasseMvtoCaixa;
import java.util.HashMap;

/**
 *
 * @author hp
 */
public class InterfaceMovimentacaoCaixa extends javax.swing.JDialog {

    private java.awt.Frame primeiratela;
    Preenche preenche = new Preenche();
    ClasseMvtoCaixa mvtocaixa = new ClasseMvtoCaixa();
    
    public InterfaceMovimentacaoCaixa(java.awt.Frame telaorigem, boolean modal) {
        super (telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        int[] tam = new int[7];
        tam[0] = 80;
        tam[1] = 500;
        tam[2] = 180;
        tam[3] = 100;
        tam[4] = 100;
        tam[5] = 100;
        tam[6] = 80;
        preenche.FormataJtable(TbMvtoCaixa, tam);
        CbMvtoCaixaActionPerformed(null);
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
        CbMvtoCaixa = new javax.swing.JComboBox();
        BtGerarRelatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbMvtoCaixa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimento de Caixa - Software Loja da Fátima");
        setResizable(false);

        jLabel1.setText("Movimentacao de Caixa referente");

        CbMvtoCaixa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ao Dia de Hoje", "à Ontem", "ao Mês Atual", "ao Mês Anterior", "todas as Entradas do Dia", "todas as Saídas do Dia" }));
        CbMvtoCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbMvtoCaixaActionPerformed(evt);
            }
        });

        BtGerarRelatorio.setText("Gerar Relatório");
        BtGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGerarRelatorioActionPerformed(evt);
            }
        });

        TbMvtoCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº da Movimentacao", "Referente a", "Data e Hora", "Quant. Antes", "Saldo", "Quant. Movimentado", "Tipo"
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
        if (TbMvtoCaixa.getColumnModel().getColumnCount() > 0) {
            TbMvtoCaixa.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1215, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CbMvtoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtGerarRelatorio)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbMvtoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtGerarRelatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGerarRelatorioActionPerformed
        Relatorios relatorio = new Relatorios();
        switch(CbMvtoCaixa.getSelectedIndex()){
            case 0:{
                relatorio.iniciarSplash(mvtocaixa.mvtocaixadia(), "relatorios\\mvtocaixadia.jasper", new HashMap());
                break;
            }
            case 1:{
                ClasseDatas datas = new ClasseDatas();
                if(datas.diaatual() == 1){
                    relatorio.iniciarSplash(mvtocaixa.mvtocaixadiaanterior(), "relatorios\\mvtocaixadiaanteriordia1.jasper", new HashMap());
                }else{
                    relatorio.iniciarSplash(mvtocaixa.mvtocaixadiaanterior(), "relatorios\\mvtocaixadiaanterior.jasper", new HashMap());
                }
                break;
            }
            case 2:{
                relatorio.iniciarSplash(mvtocaixa.mvtocaixames(), "relatorios\\mvtocaixames.jasper", new HashMap());
                break;
            }
            case 3:{
                ClasseDatas datas = new ClasseDatas();
                if(datas.mesatual() == 0){
                    relatorio.iniciarSplash(mvtocaixa.mvtocaixamesanterior(), "relatorios\\mvtocaixamesanteriorjaneiro.jasper", new HashMap());
                }else{
                    relatorio.iniciarSplash(mvtocaixa.mvtocaixamesanterior(), "relatorios\\mvtocaixamesanterior.jasper", new HashMap());
                }
                break;
            }
            case 4:{
                relatorio.iniciarSplash(mvtocaixa.mvtocaixaentradasdia(), "relatorios\\mvtoentradasdia.jasper", new HashMap());
                break;
            }
            case 5:{
                relatorio.iniciarSplash(mvtocaixa.mvtocaixasaidasdia(), "relatorios\\mvtosaidasdia.jasper", new HashMap());
                break;
            }
        }
    }//GEN-LAST:event_BtGerarRelatorioActionPerformed

    private void CbMvtoCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbMvtoCaixaActionPerformed
        switch(CbMvtoCaixa.getSelectedIndex()){
            case 0:{
                preenche.PreencherJtable(TbMvtoCaixa, mvtocaixa.mvtocaixadia());
                break;
            }
            case 1:{
                preenche.PreencherJtable(TbMvtoCaixa, mvtocaixa.mvtocaixadiaanterior());
                break;
            }
            case 2:{
                preenche.PreencherJtable(TbMvtoCaixa, mvtocaixa.mvtocaixames());
                break;
            }
            case 3:{
                preenche.PreencherJtable(TbMvtoCaixa, mvtocaixa.mvtocaixamesanterior());
                break;
            }
            case 4:{
                preenche.PreencherJtable(TbMvtoCaixa, mvtocaixa.mvtocaixaentradasdia());
                break;
            }
            case 5:{
                preenche.PreencherJtable(TbMvtoCaixa, mvtocaixa.mvtocaixasaidasdia());
                break;
            }
        }
    }//GEN-LAST:event_CbMvtoCaixaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtGerarRelatorio;
    private javax.swing.JComboBox CbMvtoCaixa;
    private javax.swing.JTable TbMvtoCaixa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public java.awt.Frame getPrimeiratela() {
        return primeiratela;
    }

    public void setPrimeiratela(java.awt.Frame primeiratela) {
        this.primeiratela = primeiratela;
    }
}
