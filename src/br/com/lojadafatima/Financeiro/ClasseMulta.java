package br.com.lojadafatima.Financeiro;

import br.com.lojadafatima.ClassesFerramentas.GeraCodigos;
import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class ClasseMulta {
    
    ConexaoPostgre conn = new ConexaoPostgre();
    private int codigo;
    private int diasalerta;
    private int diasacresc;
    private float percent;
    
    public void getultimamulta(){
        conn.executeSQL("SELECT \"CD_MULTA\", \"NR_DIAS_AVISO\", \"NR_DIAS_ACRESCIMO\", \"PC_ACRESCIMO\" FROM bancoloja.\"CAD_MULTAS\"\n" +
                        "WHERE \"CD_MULTA\" = (SELECT MAX(\"CD_MULTA\") FROM bancoloja.\"CAD_MULTAS\")");
        try{
            conn.resultset.first();
            setCodigo(conn.resultset.getInt(1));
            setDiasalerta(conn.resultset.getInt(2));
            setDiasacresc(conn.resultset.getInt(3));
            setPercent(Float.parseFloat(conn.resultset.getString(4)));
        }catch(SQLException ex){
            setCodigo(0);
            setDiasalerta(0);
            setDiasacresc(0);
            setPercent(0);
        }
    }
    
    public void incluir(){
        GeraCodigos geracodigos = new GeraCodigos();
        setCodigo(geracodigos.gerasequencia("CAD_MULTAS", "CD_MULTA"));
        conn.incluirSQL("INSERT INTO bancoloja.\"CAD_MULTAS\"(\n" +
                        "\"CD_MULTA\", \"NR_DIAS_AVISO\", \"NR_DIAS_ACRESCIMO\", \"PC_ACRESCIMO\")\n" +
                        "VALUES ("+getCodigo()+", "+getDiasalerta()+", "+getDiasacresc()+", "+getPercent()+");");
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDiasalerta() {
        return diasalerta;
    }

    public void setDiasalerta(int diasalerta) {
        this.diasalerta = diasalerta;
    }

    public int getDiasacresc() {
        return diasacresc;
    }

    public void setDiasacresc(int diasacresc) {
        this.diasacresc = diasacresc;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
    
}
