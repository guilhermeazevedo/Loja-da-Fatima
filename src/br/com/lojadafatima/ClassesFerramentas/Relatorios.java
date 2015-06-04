package br.com.lojadafatima.ClassesFerramentas;

import br.com.lojadafatima.ConexaoBDpostgre.ConexaoPostgre;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Leonardo
 */
public class Relatorios {
    
    ConexaoPostgre conexao = new ConexaoPostgre();

    public void gerarRelatorio(ResultSet rs, String caminho, Map parametros) {
        try {
            JRResultSetDataSource jrds = new JRResultSetDataSource(rs);
            String report = caminho;
            ConexaoPostgre cone = new ConexaoPostgre();
            JasperPrint jp = JasperFillManager.fillReport(report, parametros, cone.conecta());
            
//            PrinterJob job = PrinterJob.getPrinterJob();
//            PrintService service = job.getPrintService();
//            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
//            pras.add(MediaSizeName.ISO_A4);
//            JRPrintServiceExporter exporter = new JRPrintServiceExporter();
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
//            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,pras);
//            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, service.getAttributes());
//            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
//            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.TRUE);
//            exporter.exportReport();
            
            JasperViewer jv = new JasperViewer(jp, true);
            JDialog rel = new JDialog(new javax.swing.JFrame(), "Visualização de Relatório - Software Loja da Fátima", true);
            rel.setSize(1000, 700);
            rel.setLocationRelativeTo(null);
            rel.getContentPane().add(jv.getContentPane());
            rel.setVisible(true);
            rel.setResizable(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar documento");
        }
    }
    
    public void iniciarSplash(final ResultSet rs, final String caminho, final Map parametros){
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                   gerarRelatorio(rs, caminho, parametros); 
            }
        });
        thread.start(); 
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                SplashRelatorio splash = new SplashRelatorio();
                splash.setVisible(true);
                thread.join();
                splash.dispose();
                } 
                catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        });
        t.start();
    }
}
