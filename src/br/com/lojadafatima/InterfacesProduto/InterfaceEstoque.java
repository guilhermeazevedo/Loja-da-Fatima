/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojadafatima.InterfacesProduto;

import br.com.lojadafatima.ClassesFerramentas.ClasseDatas;
import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ClassesFerramentas.GerenciadorCamposBotoes;
import br.com.lojadafatima.ClassesFerramentas.LimpaCamposTela;
import br.com.lojadafatima.ClassesFerramentas.NaoPermiteAspasSimples;
import br.com.lojadafatima.ClassesFerramentas.PermiteApenasNumeros;
import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.CompraVendaOperacoes.ClasseProdutosCompraVenda;
import br.com.lojadafatima.Produto.ClasseMvtoEstoque;
import br.com.lojadafatima.Usuario.ClasseTelasUsuario;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author hp
 */
public class InterfaceEstoque extends javax.swing.JDialog {

    private java.awt.Frame primeiratela;
    Preenche preenche = new Preenche();
    ClasseMvtoEstoque mvtoestoque = new ClasseMvtoEstoque();
    GerenciadorCamposBotoes valida = new GerenciadorCamposBotoes();
    private ClasseTelasUsuario telasusuario = new ClasseTelasUsuario();

    public InterfaceEstoque(java.awt.Frame telaorigem, boolean modal, ClasseTelasUsuario usuario) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setTelasusuario(usuario);
        analisausuario();
        CbPesqProdutoActionPerformed(null);
        int[] tam = new int[5];
        tam[0] = 80;
        tam[1] = 200;
        tam[2] = 100;
        tam[3] = 100;
        tam[4] = 80;
        preenche.FormataJtable(TbProdutos, tam);
        preenche.FormataJtable(TbAjuste, tam);
        TbAjuste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TbProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        PnPesqEstoque = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CbPesqProduto = new javax.swing.JComboBox();
        TfPesqProduto = new javax.swing.JTextField();
        BtPesqProduto = new javax.swing.JButton();
        BtRelatorioProdutos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbProdutos = new javax.swing.JTable();
        PnAjusteEstoque = new javax.swing.JPanel();
        TfQuantEstoqueSistema = new JNumberField.JNumberField(2);
        ;
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TfQuantEstoqueFisico = new JNumberField.JNumberField(2);
        ;
        TfDsProduto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BtAjustar = new javax.swing.JButton();
        BtIniciar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbAjuste = new javax.swing.JTable();
        BtEncerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estoque de Produtos - Software Loja da Fátima");
        setResizable(false);

        jLabel1.setText("Pesquisar por:");

        CbPesqProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos os Produtos", "Código do Produto", "Descrição do Produto", "Produtos Abaixo da Quantidade Mínima", "Produtos Disponíveis" }));
        CbPesqProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPesqProdutoActionPerformed(evt);
            }
        });

        BtPesqProduto.setText("Pesquisar");
        BtPesqProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPesqProdutoActionPerformed(evt);
            }
        });

        BtRelatorioProdutos.setText("Imprimir Relatório");

        TbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código do Produto", "Descrição do Produto", "Quant. Mínima de Estoque", "Quant. Estoque Atual", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TbProdutos);

        javax.swing.GroupLayout PnPesqEstoqueLayout = new javax.swing.GroupLayout(PnPesqEstoque);
        PnPesqEstoque.setLayout(PnPesqEstoqueLayout);
        PnPesqEstoqueLayout.setHorizontalGroup(
            PnPesqEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnPesqEstoqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnPesqEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1)
                    .addGroup(PnPesqEstoqueLayout.createSequentialGroup()
                        .addComponent(CbPesqProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TfPesqProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtPesqProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtRelatorioProdutos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnPesqEstoqueLayout.setVerticalGroup(
            PnPesqEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnPesqEstoqueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnPesqEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbPesqProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfPesqProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtPesqProduto)
                    .addComponent(BtRelatorioProdutos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pesquisa de Estoque", PnPesqEstoque);

        TfQuantEstoqueSistema.setEditable(false);

        jLabel2.setText("Quant. em Estoque no Sistema");

        jLabel3.setText("Quant. em Estoque Fisicamente");

        TfQuantEstoqueFisico.setEditable(false);

        TfDsProduto.setEditable(false);

        jLabel4.setText("Descricao do Produto");

        BtAjustar.setText("Ajustar");
        BtAjustar.setEnabled(false);
        BtAjustar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAjustarActionPerformed(evt);
            }
        });

        BtIniciar.setText("Iniciar");
        BtIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIniciarActionPerformed(evt);
            }
        });

        TbAjuste.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição do Produto", "Quant. Mínima de Estoque", "Quant. Estoque Atual", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbAjuste.getTableHeader().setReorderingAllowed(false);
        TbAjuste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TbAjusteMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(TbAjuste);

        BtEncerrar.setText("Encerrar");
        BtEncerrar.setEnabled(false);
        BtEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEncerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnAjusteEstoqueLayout = new javax.swing.GroupLayout(PnAjusteEstoque);
        PnAjusteEstoque.setLayout(PnAjusteEstoqueLayout);
        PnAjusteEstoqueLayout.setHorizontalGroup(
            PnAjusteEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnAjusteEstoqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnAjusteEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                    .addGroup(PnAjusteEstoqueLayout.createSequentialGroup()
                        .addGroup(PnAjusteEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnAjusteEstoqueLayout.createSequentialGroup()
                                .addGroup(PnAjusteEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(TfQuantEstoqueSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(PnAjusteEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(PnAjusteEstoqueLayout.createSequentialGroup()
                                        .addComponent(TfQuantEstoqueFisico, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtAjustar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(TfDsProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PnAjusteEstoqueLayout.createSequentialGroup()
                                .addComponent(BtIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtEncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        PnAjusteEstoqueLayout.setVerticalGroup(
            PnAjusteEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnAjusteEstoqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnAjusteEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtIniciar)
                    .addComponent(BtEncerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TfDsProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnAjusteEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnAjusteEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfQuantEstoqueSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfQuantEstoqueFisico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAjustar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ajuste de Estoque", PnAjusteEstoque);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CbPesqProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPesqProdutoActionPerformed
        switch (CbPesqProduto.getSelectedIndex()) {
            case 0: {
                TfPesqProduto.setEnabled(false);
                break;
            }
            case 1: {
                TfPesqProduto.setEnabled(true);
                TfPesqProduto.setDocument(new PermiteApenasNumeros());
                break;
            }
            case 2: {
                TfPesqProduto.setEnabled(true);
                TfPesqProduto.setDocument(new NaoPermiteAspasSimples());
                break;
            }
            case 3: {
                TfPesqProduto.setEnabled(false);
                break;
            }
            case 4: {
                TfPesqProduto.setEnabled(false);
                break;
            }
        }
    }//GEN-LAST:event_CbPesqProdutoActionPerformed

    private void BtPesqProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPesqProdutoActionPerformed
        switch (CbPesqProduto.getSelectedIndex()) {
            case 0: {
                preenche.PreencherJtable(TbProdutos, mvtoestoque.consultaestoquetodososprodutos());
                break;
            }
            case 1: {
                if (!TfPesqProduto.getText().equals("")) {
                    mvtoestoque.getProduto().setCodigo(Integer.parseInt(TfPesqProduto.getText()));
                    preenche.PreencherJtable(TbProdutos, mvtoestoque.consultaestoqueporcodigo());
                } else {
                    JOptionPane.showMessageDialog(null, "Digite o codigo do produto para consulta!", "Digite o codigo", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }
            case 2: {
                if (!TfPesqProduto.getText().equals("")) {
                    mvtoestoque.getProduto().setDescricao(TfPesqProduto.getText().toUpperCase());
                    preenche.PreencherJtable(TbProdutos, mvtoestoque.consultaestoquepordescricao());
                } else {
                    JOptionPane.showMessageDialog(null, "Digite a descricao do produto para consulta!", "Digite a descricao", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }
            case 3: {
                preenche.PreencherJtable(TbProdutos, mvtoestoque.consultaestoquebaixo());
                break;
            }
            case 4: {
                preenche.PreencherJtable(TbProdutos, mvtoestoque.consultaestoquedisponivel());
                break;
            }
        }
    }//GEN-LAST:event_BtPesqProdutoActionPerformed

    private void BtIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIniciarActionPerformed
        mvtoestoque.getCompravenda().getFuncionario().setCodigo(0);
        final InterfacePerguntaFuncionarioAjusteEstoque tela = new InterfacePerguntaFuncionarioAjusteEstoque(getPrimeiratela(), true, mvtoestoque.getCompravenda().getFuncionario(), getTelasusuario());
        tela.setVisible(true);
        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                if (mvtoestoque.getCompravenda().getFuncionario().getCodigo() != 0) {
                    mvtoestoque.getCompravenda().getCondicao().setCodigo(0);
                    mvtoestoque.getCompravenda().getOperacao().setCodigo(3);
                    ClasseDatas datas = new ClasseDatas();
                    mvtoestoque.getCompravenda().setData(datas.retornadataehora());
                    mvtoestoque.getCompravenda().setCodigopessoa(0);
                    GeraCodigos geracodigos = new GeraCodigos();
                    mvtoestoque.getCompravenda().setDescricao("AJUSTE DE ESTOQUE NRO. " + geracodigos.gerasequencia("COMPRA_VENDA", "CD_COMPRA_VENDA", "CD_OPERACAO", 3) + ", REALIZADO DIA: " + mvtoestoque.getCompravenda().getData());
                    mvtoestoque.getCompravenda().incluir();
                    preenche.PreencherJtable(TbAjuste, mvtoestoque.consultaestoquetodososprodutos());
                    BtEncerrar.setEnabled(true);
                    BtIniciar.setEnabled(false);
                    TfQuantEstoqueFisico.setEditable(true);
                }
            }
        });
    }//GEN-LAST:event_BtIniciarActionPerformed

    private void TbAjusteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbAjusteMouseReleased
        if (TbAjuste.getSelectedRow() > -1) {
            TfDsProduto.setText(TbAjuste.getValueAt(TbAjuste.getSelectedRow(), 1).toString());
            TfQuantEstoqueSistema.setText(TbAjuste.getValueAt(TbAjuste.getSelectedRow(), 3).toString());
            BtAjustar.setEnabled(true);
        }
    }//GEN-LAST:event_TbAjusteMouseReleased

    private void BtEncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEncerrarActionPerformed
        preenche.PreencherJtable(TbAjuste, mvtoestoque.consultaestoquetodososprodutos());
        BtEncerrar.setEnabled(false);
        BtIniciar.setEnabled(true);
        TfQuantEstoqueFisico.setEditable(false);
        LimpaCamposTela limpa = new LimpaCamposTela();
        limpa.Limpar(TbAjuste);
        if (TbProdutos.getRowCount() > 0) {
            BtPesqProdutoActionPerformed(evt);
        }
    }//GEN-LAST:event_BtEncerrarActionPerformed

    private void BtAjustarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAjustarActionPerformed
        if (TfQuantEstoqueFisico.getValue() != BigDecimal.valueOf(0)) {
            mvtoestoque.setTpmvto("A");
            mvtoestoque.getProduto().setCodigo(Integer.parseInt(TbAjuste.getValueAt(TbAjuste.getSelectedRow(), 0).toString()));
            mvtoestoque.setQtatual(Float.parseFloat(TfQuantEstoqueFisico.getValue().toString()));
            mvtoestoque.setDtmvto(mvtoestoque.getCompravenda().getData());
            mvtoestoque.setQtmvto(0);
            mvtoestoque.incluirmvto();
            ClasseProdutosCompraVenda prodcompravenda = new ClasseProdutosCompraVenda();
            prodcompravenda.setCompravenda(mvtoestoque.getCompravenda());
            prodcompravenda.getForneproduto().setProduto(mvtoestoque.getProduto());
            prodcompravenda.setQuantidade(Float.parseFloat(TfQuantEstoqueFisico.getValue().toString()));
            prodcompravenda.incluirprodutocompravenda();
            BtAjustar.setEnabled(false);
            preenche.PreencherJtable(TbAjuste, mvtoestoque.consultaestoquetodososprodutos());
            TfDsProduto.setText("");
            TfQuantEstoqueFisico.setText("");
            TfQuantEstoqueSistema.setText("");
        } else {
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente zerar o estoque deste produto?", "Zerar estoque", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                mvtoestoque.setTpmvto("A");
                mvtoestoque.getProduto().setCodigo(Integer.parseInt(TbAjuste.getValueAt(TbAjuste.getSelectedRow(), 0).toString()));
                mvtoestoque.setQtatual(Float.parseFloat(TfQuantEstoqueFisico.getValue().toString()));
                mvtoestoque.setDtmvto(mvtoestoque.getCompravenda().getData());
                mvtoestoque.setQtmvto(0);
                mvtoestoque.incluirmvto();
                BtAjustar.setEnabled(false);
                preenche.PreencherJtable(TbAjuste, mvtoestoque.consultaestoquetodososprodutos());
                TfDsProduto.setText("");
                TfQuantEstoqueFisico.setText("");
                TfQuantEstoqueSistema.setText("");
            }
        }
    }//GEN-LAST:event_BtAjustarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAjustar;
    private javax.swing.JButton BtEncerrar;
    private javax.swing.JButton BtIniciar;
    private javax.swing.JButton BtPesqProduto;
    private javax.swing.JButton BtRelatorioProdutos;
    private javax.swing.JComboBox CbPesqProduto;
    private javax.swing.JPanel PnAjusteEstoque;
    private javax.swing.JPanel PnPesqEstoque;
    private javax.swing.JTable TbAjuste;
    private javax.swing.JTable TbProdutos;
    private javax.swing.JTextField TfDsProduto;
    private javax.swing.JTextField TfPesqProduto;
    private JNumberField.JNumberField TfQuantEstoqueFisico;
    private JNumberField.JNumberField TfQuantEstoqueSistema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    public void analisausuario(){
        getTelasusuario().getTela().setCodigo(14);
        if(!getTelasusuario().eadmintela()){
            BtIniciar.setVisible(false);
            BtEncerrar.setVisible(false);
            BtAjustar.setVisible(false);
            BtRelatorioProdutos.setVisible(false);
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
