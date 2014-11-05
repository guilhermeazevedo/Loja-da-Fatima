package br.com.lojadafatima.Produto;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.CompraVendaOperacoes.ClasseCompraVenda;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class ClasseMvtoEstoque {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private ClasseProduto produto = new ClasseProduto();
    private ClasseCompraVenda compravenda = new ClasseCompraVenda();
    private String tpmvto;
    private String dtmvto;
    private float qtantes;
    private float qtmvto;
    private float qtatual;
    
    public void incluirmvto(){
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("MOV_ESTOQUE", "CD_MVTO", "CD_PRODUTO", getProduto().getCodigo()));
        setQtantes(retornaestoqueatual());
        if(getTpmvto().equals("E")){
            setQtatual(getQtantes() + getQtmvto());
        }else{
            setQtatual(getQtantes() - getQtmvto());
        }
        conn.executeSQL("INSERT INTO bancoloja.\"MOV_ESTOQUE\"(\n" +
                        "            \"CD_MVTO\", \"CD_PRODUTO\", \"CD_COMPRA_VENDA\", \"CD_OPERACAO\", \"TP_MVTO\", \n" +
                        "            \"DT_MVTO\", \"QT_ANTES\", \"QT_MVTO\", \"QT_ATUAL\")\n" +
                        "VALUES ("+getCodigo()+", "+getProduto().getCodigo()+", "+getCompravenda().getCodigo()+", "+getCompravenda().getOperacao().getCodigo()+", '"+getTpmvto()+"', \n" +
                        "        '"+getDtmvto()+"', "+getQtantes()+", "+getQtmvto()+", "+getQtatual()+")");
    }
    
    public float retornaestoqueatual(){
        conn.executeSQL("SELECT \"QT_ATUAL\" FROM bancoloja.\"MOV_ESTOQUE\"\n" +
                        "WHERE \"CD_PRODUTO\" = "+getProduto().getCodigo()+"\n" +
                        "AND \"CD_MVTO\" = (SELECT MAX(\"CD_MVTO\") FROM bancoloja.\"MOV_ESTOQUE\" WHERE \"CD_PRODUTO\" = "+getProduto().getCodigo()+")");
        try{
            conn.resultset.first();
            return conn.resultset.getFloat(1);
        }catch(SQLException ex){
            return 0;
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ClasseProduto getProduto() {
        return produto;
    }

    public void setProduto(ClasseProduto produto) {
        this.produto = produto;
    }

    public ClasseCompraVenda getCompravenda() {
        return compravenda;
    }

    public void setCompravenda(ClasseCompraVenda compravenda) {
        this.compravenda = compravenda;
    }

    public String getTpmvto() {
        return tpmvto;
    }

    public void setTpmvto(String tpmvto) {
        this.tpmvto = tpmvto;
    }

    public String getDtmvto() {
        return dtmvto;
    }

    public void setDtmvto(String dtmvto) {
        this.dtmvto = dtmvto;
    }

    public float getQtantes() {
        return qtantes;
    }

    public void setQtantes(float qtantes) {
        this.qtantes = qtantes;
    }

    public float getQtmvto() {
        return qtmvto;
    }

    public void setQtmvto(float qtmvto) {
        this.qtmvto = qtmvto;
    }

    public float getQtatual() {
        return qtatual;
    }

    public void setQtatual(float qtatual) {
        this.qtatual = qtatual;
    }
    
}
