package br.com.lojadafatima.InterfaceConsultaSimples;

import br.com.lojadafatima.ClassesFerramentas.Preenche;
import br.com.lojadafatima.CompraVendaOperacoes.ClasseProdutosCompraVenda;
import br.com.lojadafatima.DadosPessoa.ClassePessoaFisica;
import br.com.lojadafatima.DadosPessoa.ClassePessoaJuridica;
import br.com.lojadafatima.Financeiro.ClasseParcelas;
import java.math.BigDecimal;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Guilherme Azevedo
 */
public class ConsulSimplesDetalhesOperacao extends javax.swing.JDialog {

    private java.awt.Frame primeiratela;
    private ClasseProdutosCompraVenda prodcompravenda = new ClasseProdutosCompraVenda();
    Preenche preenche = new Preenche();
    
    public ConsulSimplesDetalhesOperacao(java.awt.Frame telaorigem, boolean modal, ClasseProdutosCompraVenda prod) {
        super(telaorigem, modal);
        setPrimeiratela(telaorigem);
        initComponents();
        setProdcompravenda(prod);
        preencheinformacoes();
        TbParcelas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        PnInformacoes = new javax.swing.JPanel();
        TfSituacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TfValorTotal = new JNumberField.JNumberField();
        TfDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TfCondicao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TfPessoa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TfFuncionario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TfCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TfData = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TfDsOperacao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PnProdutos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbProdutos = new javax.swing.JTable();
        PnParcelas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbParcelas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalhes da Operação - Software Loja da Fátima");
        setResizable(false);

        PnInformacoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TfSituacao.setEditable(false);
        PnInformacoes.add(TfSituacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 261, 215, -1));

        jLabel8.setText("Situação");
        PnInformacoes.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 241, -1, -1));

        jLabel9.setText("Valor Total");
        PnInformacoes.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 241, -1, -1));

        TfValorTotal.setEditable(false);
        PnInformacoes.add(TfValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 261, 138, -1));

        TfDescricao.setEditable(false);
        PnInformacoes.add(TfDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 215, 667, -1));

        jLabel5.setText("Descrição");
        PnInformacoes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 195, -1, -1));

        TfCondicao.setEditable(false);
        PnInformacoes.add(TfCondicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 77, 344, -1));

        jLabel7.setText("Condição de Pagamento");
        PnInformacoes.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 57, -1, -1));

        TfPessoa.setEditable(false);
        PnInformacoes.add(TfPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 169, 667, -1));

        jLabel3.setText("Pessoa");
        PnInformacoes.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 149, -1, -1));

        TfFuncionario.setEditable(false);
        PnInformacoes.add(TfFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 667, -1));

        jLabel1.setText("Funcionário");
        PnInformacoes.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 103, -1, -1));

        TfCodigo.setEditable(false);
        PnInformacoes.add(TfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 100, -1));

        jLabel6.setText("Código");
        PnInformacoes.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        TfData.setEditable(false);
        PnInformacoes.add(TfData, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 31, 187, -1));

        jLabel2.setText("Data e Hora");
        PnInformacoes.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 11, -1, -1));

        TfDsOperacao.setEditable(false);
        PnInformacoes.add(TfDsOperacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 77, 305, -1));

        jLabel4.setText("Operação");
        PnInformacoes.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 57, -1, -1));

        jTabbedPane1.addTab("Informações", PnInformacoes);

        PnProdutos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód. Produto", "Produto", "Quantidade", "Valor Unitário (R$)", "Desconto", "Valor (R$)", "Promoção"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbProdutos.setEnabled(false);
        TbProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TbProdutos);

        PnProdutos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 667, 275));

        jTabbedPane1.addTab("Produtos", PnProdutos);

        PnParcelas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TbParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nrº Parcela", "Valor a pagar (R$)", "Valor pago (R$)", "Forma de Pagamento", "Data a pagar", "Data pago", "Situação", "Reparcela referente a parcela"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbParcelas.setEnabled(false);
        TbParcelas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TbParcelas);

        PnParcelas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 667, 278));

        jTabbedPane1.addTab("Parcelas", PnParcelas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnInformacoes;
    private javax.swing.JPanel PnParcelas;
    private javax.swing.JPanel PnProdutos;
    private javax.swing.JTable TbParcelas;
    private javax.swing.JTable TbProdutos;
    private javax.swing.JTextField TfCodigo;
    private javax.swing.JTextField TfCondicao;
    private javax.swing.JTextField TfData;
    private javax.swing.JTextField TfDescricao;
    private javax.swing.JTextField TfDsOperacao;
    private javax.swing.JTextField TfFuncionario;
    private javax.swing.JTextField TfPessoa;
    private javax.swing.JTextField TfSituacao;
    private JNumberField.JNumberField TfValorTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    public void preencheinformacoes(){
        TfCodigo.setText(""+getProdcompravenda().getCompravenda().getCodigo());
        TfDsOperacao.setText(getProdcompravenda().getCompravenda().getOperacao().getDescricao());
        getProdcompravenda().getCompravenda().retornainformacoescompravenda();
        TfDescricao.setText(getProdcompravenda().getCompravenda().getDescricao());
        TfData.setText(getProdcompravenda().getCompravenda().getData());
        TfCondicao.setText(getProdcompravenda().getCompravenda().getCondicao().getCondicaodepgto());
        ClassePessoaFisica fisica = new ClassePessoaFisica();
        fisica.getPessoa().setCodigo(getProdcompravenda().getCompravenda().getCodigopessoa());
        fisica.setNome(fisica.retornanomeporCodigo());
        if(fisica.epessoafisica()){
            TfPessoa.setText(fisica.retornanomeporCodigo());
        }else{
            ClassePessoaJuridica juridica = new ClassePessoaJuridica();
            juridica.getPessoa().setCodigo(getProdcompravenda().getCompravenda().getCodigopessoa());
            TfPessoa.setText(juridica.retornanomeporCodigo());
        }
        fisica.getPessoa().setCodigo(getProdcompravenda().getCompravenda().getFuncionario().retornacodigopessoafuncionario());
        TfFuncionario.setText(fisica.retornanomeporCodigo());
        preenche.PreencherJtable(TbProdutos, getProdcompravenda().produtoscompravenda());
        
        ClasseParcelas parcelas = new ClasseParcelas();
        parcelas.getConta().setCompravenda(getProdcompravenda().getCompravenda());
        parcelas.getConta().buscarcontacompravenda();
        parcelas.getConta().retornainformacoesconta();
        TfSituacao.setText(parcelas.getConta().getSituacao());
        TfValorTotal.setValue(BigDecimal.valueOf(parcelas.getConta().getTotal()));
        preenche.PreencherJtable(TbParcelas, parcelas.retornaparcelas());
    }
    
    public java.awt.Frame getPrimeiratela() {
        return primeiratela;
    }

    public void setPrimeiratela(java.awt.Frame primeiratela) {
        this.primeiratela = primeiratela;
    }

    public ClasseProdutosCompraVenda getProdcompravenda() {
        return prodcompravenda;
    }

    public void setProdcompravenda(ClasseProdutosCompraVenda prodcompravenda) {
        this.prodcompravenda = prodcompravenda;
    }
}
