package br.com.lojadafatima.InterfacesFinanceiro;

import br.com.lojadafatima.ClassesFerramentas.ClasseDatas;
import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import br.com.lojadafatima.Financeiro.ClasseMvtoCaixa;
import br.com.lojadafatima.Pessoa.ClasseFuncionario;
import br.com.lojadafatima.Usuario.ClasseTelasUsuario;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
 * @author Guilherme Azevedo
 */
public class InterfacePagamentoFuncionarios extends javax.swing.JDialog {

    ClasseMvtoCaixa mvtocaixa = new ClasseMvtoCaixa();
    MaskFormatter data;
    Preenche preenche = new Preenche();
    ClasseDatas datas = new ClasseDatas();
    private java.awt.Frame primeiratela;
    private ClasseTelasUsuario telasusuario = new ClasseTelasUsuario();
    GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();

    public InterfacePagamentoFuncionarios(java.awt.Frame telaorigem, boolean modal, ClasseTelasUsuario usuario) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setTelasusuario(usuario);
        analisausuario();
        int[] tam = new int[5];
        tam[0] = 70;
        tam[1] = 150;
        tam[2] = 100;
        tam[3] = 80;
        tam[4] = 80;
        preenche.FormataJtable(TbFuncionariosCad, tam);

        int[] tam2 = new int[4];
        tam2[0] = 70;
        tam2[1] = 300;
        tam2[2] = 200;
        tam2[3] = 70;
        preenche.FormataJtable(TbPesquisa, tam2);

        int[] tam3 = new int[3];
        tam3[0] = 200;
        tam3[1] = 80;
        tam3[2] = 80;
        preenche.FormataJtable(TbPagamentos, tam3);

        preenche.PreencherJtable(TbPesquisa, mvtocaixa.getParcela().getConta().getCompravenda().getFuncionario().consultageral());
        preenche.PreencherJtable(TbFuncionariosCad, mvtocaixa.getParcela().getConta().getCompravenda().getFuncionario().consultatodososfuncionarios());
        preenchercomboanos();
        TbFuncionariosCad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TbPagamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        PnRealizaPgto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbFuncionariosCad = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TfSalario = new JNumberField.JNumberField();
        BtPagar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        CbMes = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        CbAno = new javax.swing.JComboBox();
        try{
            data = new MaskFormatter("##/##/####");
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Nao foi possivel localizar");
        }
        TfDtInicial = new JFormattedTextField(data);
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        try{
            data = new MaskFormatter("##/##/####");
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Nao foi possivel localizar");
        }
        TfDtFinal = new JFormattedTextField(data);
        BtCalcComissao = new javax.swing.JButton();
        PnPesqPgto = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbPesquisa = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TbPagamentos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pagamento de Salários a Funcionários - Software Loja da Fátima");
        setResizable(false);

        PnRealizaPgto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TbFuncionariosCad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Função", "Salário", "Comissão (%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbFuncionariosCad.getTableHeader().setReorderingAllowed(false);
        TbFuncionariosCad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TbFuncionariosCadMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TbFuncionariosCad);

        PnRealizaPgto.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 738, 251));

        jLabel1.setText("Funcionários cadastrados:");
        PnRealizaPgto.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel2.setText("Salário:");
        PnRealizaPgto.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 319, -1, -1));
        PnRealizaPgto.add(TfSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 341, 133, -1));

        BtPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/dinheiro.png"))); // NOI18N
        BtPagar.setText("Pagar Salário");
        BtPagar.setEnabled(false);
        BtPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPagarActionPerformed(evt);
            }
        });
        PnRealizaPgto.add(BtPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 339, -1, -1));

        jLabel3.setText("Referente ao mês");
        PnRealizaPgto.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 378, -1, -1));

        CbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        PnRealizaPgto.add(CbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 375, 68, -1));

        jLabel4.setText("do ano");
        PnRealizaPgto.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 378, -1, -1));

        PnRealizaPgto.add(CbAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 375, 77, -1));

        TfDtInicial.setEditable(false);
        TfDtInicial.setName("DT_NASC"); // NOI18N
        TfDtInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TfDtInicialFocusLost(evt);
            }
        });
        PnRealizaPgto.add(TfDtInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 290, 116, -1));

        jLabel7.setText("Aplicar comissão com base nas vendas realizadas no período do dia:");
        PnRealizaPgto.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 293, -1, -1));

        jLabel8.setText("a");
        PnRealizaPgto.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 293, -1, -1));

        TfDtFinal.setEditable(false);
        TfDtFinal.setName("DT_NASC"); // NOI18N
        TfDtFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TfDtFinalFocusLost(evt);
            }
        });
        PnRealizaPgto.add(TfDtFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 290, 116, -1));

        BtCalcComissao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/sucesso2.png"))); // NOI18N
        BtCalcComissao.setText("Calcular Comissão");
        BtCalcComissao.setEnabled(false);
        BtCalcComissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCalcComissaoActionPerformed(evt);
            }
        });
        PnRealizaPgto.add(BtCalcComissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 288, 157, -1));

        jTabbedPane1.addTab("Realizar Pagamento", PnRealizaPgto);

        PnPesqPgto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TbPesquisaMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(TbPesquisa);

        PnPesqPgto.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 738, 147));

        jLabel5.setText("Funcionários cadastrados:");
        PnPesqPgto.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel6.setText("Salários já pagos:");
        PnPesqPgto.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 189, -1, -1));

        TbPagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Valor Pago ao Funcionário (R$)", "Data de Realização do Pagamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbPagamentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TbPagamentos);

        PnPesqPgto.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 209, 738, 186));

        jTabbedPane1.addTab("Histórico de Pagamentos", PnPesqPgto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TbFuncionariosCadMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbFuncionariosCadMouseReleased
        if (TbFuncionariosCad.getSelectedRow() > -1) {
            mvtocaixa.getParcela().getConta().getCompravenda().getFuncionario().setCodigo(Integer.parseInt(TbFuncionariosCad.getValueAt(TbFuncionariosCad.getSelectedRow(), 0).toString()));
            mvtocaixa.getParcela().getConta().getCompravenda().getFuncionario().setSalario(Float.parseFloat(TbFuncionariosCad.getValueAt(TbFuncionariosCad.getSelectedRow(), 3).toString()));
            mvtocaixa.getParcela().getConta().getCompravenda().getFuncionario().setComissao(Float.parseFloat(TbFuncionariosCad.getValueAt(TbFuncionariosCad.getSelectedRow(), 4).toString()));
            TfSalario.setValue(BigDecimal.valueOf(Float.parseFloat(TbFuncionariosCad.getValueAt(TbFuncionariosCad.getSelectedRow(), 3).toString())));
            TfDtInicial.setEditable(true);
            TfDtFinal.setEditable(true);
            BtCalcComissao.setEnabled(true);
            BtPagar.setEnabled(true);
        }
    }//GEN-LAST:event_TbFuncionariosCadMouseReleased

    private void BtPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPagarActionPerformed
        mvtocaixa.getParcela().getConta().getCompravenda().getFuncionario().getPessoafis().setNome(TbFuncionariosCad.getValueAt(TbFuncionariosCad.getSelectedRow(), 1).toString());
        if (!mvtocaixa.pagamentodomesrealizado(CbMes.getSelectedItem().toString() + "/" + CbAno.getSelectedItem().toString())) {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar o pagamento deste funcionário?\n"
                    + "Funcionário: " + TbFuncionariosCad.getValueAt(TbFuncionariosCad.getSelectedRow(), 1).toString() + "\n"
                    + "Salário: " + TfSalario.getText() + "\n"
                    + "Rerente a: " + CbMes.getSelectedItem().toString() + "/" + CbAno.getSelectedItem().toString(), "Realizar pagamento?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if(mvtocaixa.retornacaixaatual() >= Float.parseFloat(TfSalario.getValue().toString())){
                    ClasseFuncionario func = new ClasseFuncionario();
                    func.getPessoafis().setNome(TbFuncionariosCad.getValueAt(TbFuncionariosCad.getSelectedRow(), 1).toString());
                    if(func.getPessoafis().epessoafisica()) mvtocaixa.getParcela().getConta().setCodigopessoa(func.getPessoafis().getPessoa().getCodigo());
                    mvtocaixa.getParcela().getConta().getCompravenda().setCodigo(0);
                    mvtocaixa.getParcela().getConta().getOperacao().setCodigo(4);
                    mvtocaixa.getParcela().getConta().setDescricao("PAGAMENTO DE SALARIO AO FUNCIONARIO " + TbFuncionariosCad.getValueAt(TbFuncionariosCad.getSelectedRow(), 1).toString() + ", REFERENTE AO MÊS " + CbMes.getSelectedItem().toString() + "/" + CbAno.getSelectedItem().toString());
                    mvtocaixa.getParcela().getConta().setDtconta(datas.retornadataatual());
                    mvtocaixa.getParcela().getConta().setTotal(Float.parseFloat(TfSalario.getValue().toString()));
                    mvtocaixa.getParcela().getConta().getCondicao().setCodigo(1);
                    mvtocaixa.getParcela().getConta().incluir();
                    mvtocaixa.getParcela().gerarparcelas();
                    mvtocaixa.getParcela().setCodigo(1);
                    mvtocaixa.getParcela().getFormapgto().setCodigo(1);
                    mvtocaixa.getParcela().setDtpago(datas.retornadataatual());
                    mvtocaixa.getParcela().setVlpago(Float.parseFloat(TfSalario.getValue().toString()));
                    mvtocaixa.getParcela().pagaparcela();
                    mvtocaixa.setTpmvto("S");
                    mvtocaixa.setVlmvto(Float.parseFloat(TfSalario.getValue().toString()));
                    mvtocaixa.setDsmvto(mvtocaixa.getParcela().getConta().getDescricao());
                    mvtocaixa.incluir();
                    HashMap filtro = new HashMap();
                    filtro.put("CD_OPERACAO", mvtocaixa.getParcela().getConta().getOperacao().getCodigo());
                    filtro.put("CD_CONTA", mvtocaixa.getParcela().getConta().getCodigo());
                    filtro.put("DS_RELATORIO", "PAGAMENTO DE FUNCIONÁRIO");
                    ConexaoPostgre conexao = new ConexaoPostgre();
                    JDialog dialog = new JDialog(new javax.swing.JFrame(), "Visualização - Software Loja da Fátima", true);
                    dialog.setSize(1000, 700);
                    dialog.setLocationRelativeTo(null);
                    try {
                        JasperPrint print = JasperFillManager.fillReport("relatorios\\parcelapaga.jasper", filtro, conexao.conecta());

                        JasperViewer viewer = new JasperViewer(print, true);
                        dialog.getContentPane().add(viewer.getContentPane());
                        dialog.setVisible(true);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    BtPagar.setEnabled(false);
                    TfSalario.setText("");
                } else{
                    JOptionPane.showMessageDialog(null, "Impossível realizar o pagamento deste funcionário.\nO saldo do caixa é menor que o valor a ser pago!", "Saldo do caixa insuficiente", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "O pagamento referente a este mês e ano já foi realizado!", "Pagamento já realizado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtPagarActionPerformed

    private void TbPesquisaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbPesquisaMouseReleased
        if (TbPesquisa.getSelectedRow() > -1) {
            mvtocaixa.getParcela().getConta().getCompravenda().getFuncionario().getPessoafis().setNome(TbPesquisa.getValueAt(TbPesquisa.getSelectedRow(), 1).toString());
            preenche.PreencherJtable(TbPagamentos, mvtocaixa.retornahistoricopagamentossalario());
        }
    }//GEN-LAST:event_TbPesquisaMouseReleased

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

    private void BtCalcComissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCalcComissaoActionPerformed
        if (datascorretas()) {
            TfSalario.setValue(BigDecimal.valueOf(mvtocaixa.getParcela().getConta().getCompravenda().getFuncionario().retornasalariomaiscomissao(TfDtInicial.getText(), TfDtFinal.getText())));
            BtPagar.setEnabled(true);
        }
    }//GEN-LAST:event_BtCalcComissaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCalcComissao;
    private javax.swing.JButton BtPagar;
    private javax.swing.JComboBox CbAno;
    private javax.swing.JComboBox CbMes;
    private javax.swing.JPanel PnPesqPgto;
    private javax.swing.JPanel PnRealizaPgto;
    private javax.swing.JTable TbFuncionariosCad;
    private javax.swing.JTable TbPagamentos;
    private javax.swing.JTable TbPesquisa;
    private javax.swing.JFormattedTextField TfDtFinal;
    private javax.swing.JFormattedTextField TfDtInicial;
    private JNumberField.JNumberField TfSalario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    public void analisausuario() {
        getTelasusuario().getTela().setCodigo(20);
        if (!getTelasusuario().eadmintela()) {
            BtPagar.setVisible(false);
        }
    }

    public void preenchercomboanos() {
        CbAno.addItem(datas.anoatual());
        for (int i = 1; i <= (datas.anoatual() - 2014); i++) {
            CbAno.addItem(datas.anoatual() - i);
        }
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
