package br.com.lojadafatima.ClassesFerramentas;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Guilherme Azevedo
 */
public class MensagensUsuario {
    Timer timer = new Timer();
    
    public void Sucesso(final JLabel lb, String msg){
        lb.setIcon(new ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/sucesso.png")));
        lb.setText(msg);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Limpar(lb);
            }
        }, 3000);
    }
    
    public void Adicionado(final JLabel lb, String msg){
        lb.setIcon(new ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/sucesso2.png")));
        lb.setText(msg);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Limpar(lb);
            }
        }, 3000);
    }
    
    public void Removido(final JLabel lb, String msg){
        lb.setIcon(new ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/deletar.png")));
        lb.setText(msg);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Limpar(lb);
            }
        }, 3000);
    }
    
    public void CampoObrigatorioNaoPreenchido(final JLabel lb, String msg){
        lb.setIcon(new ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/erro.png")));
        lb.setText(msg);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Limpar(lb);
            }
        }, 3000);
    }
    
    public void CampoNaoPreenchido(final JLabel lb, String msg){
        lb.setIcon(new ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/advertencia.png")));
        lb.setText(msg);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Limpar(lb);
            }
        }, 3000);
    }
    
    public void StatusNovo(final JLabel lb, String msg){
        lb.setIcon(new ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/adicionar.png")));
        lb.setText(msg);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Limpar(lb);
            }
        }, 3000);
    }
    
    public void StatusEditar(final JLabel lb, String msg){
        lb.setIcon(new ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/editar.png")));
        lb.setText(msg);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Limpar(lb);
            }
        }, 3000);
    }
    
    public void StatusBusca(final JLabel lb, String msg){
        lb.setIcon(new ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/buscar.png")));
        lb.setText(msg);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Limpar(lb);
            }
        }, 3000);
    }
    
    public void StatusExcluido(final JLabel lb, String msg){
        lb.setIcon(new ImageIcon(getClass().getResource("/br/com/lojadafatima/Icones/sucesso.png")));
        lb.setText(msg);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Limpar(lb);
            }
        }, 3000);
    }
    
    public void Limpar(JLabel lb){
        lb.setIcon(null);
        lb.setText(" ");
    }

}
