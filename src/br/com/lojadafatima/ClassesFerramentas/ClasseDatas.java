package br.com.lojadafatima.ClassesFerramentas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author hp
 */
public class ClasseDatas {
    
    SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
    
    public String retornaratartual() {
        Date data = new Date();
        String dia = "" + data.getDate();
        String mes = "" + String.valueOf(data.getMonth() + 1);
        String ano = "" + (1900 + data.getYear());
        if (Integer.parseInt(mes) <= 9) {
            mes = "0" + mes;
        }
        if (Integer.parseInt(dia) <= 9) {
            dia = "0" + dia;
        }
        return dia + "/" + mes + "/" + ano;
    }
    
    public String retornasoma(String data, int dias){
        
        Calendar calendar = Calendar.getInstance();
        
        if(data.equals("")){
            Date date = new Date();
            calendar.setTime(date);
        } else{
            Date xy = new Date(data);
            calendar.setTime(xy);
        }
        calendar.add(Calendar.DATE, dias);
        if(ediautil(sd.format(calendar.getTime()))){
            return sd.format(calendar.getTime());
        } else {
            retornasoma(sd.format(calendar.getTime()), 1);
        }
        return sd.format(calendar.getTime());
    }
    
    public String formatadata(String data){
        if(data == null){
            return "  /  /    ";
        }
        data = data.substring(3,5) + "/" + data.substring(0,2) + "/" + data.substring(6,10);
        return data;
    }
    
    public boolean ediautil(String str){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(str);
            if(date.getDay() == 6 || date.getDay() == 0 || eferiado(date)){
                return false;
            }else{
                return true;
            }
        } catch (ParseException ex) {
            return false;
        }
    }
    
    public boolean validadatas(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(str);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    
    public boolean eferiado(Date data){
        switch(data.getMonth()){
            case 0:{
                switch(data.getDate()){
                    case 0:{
                        return true;
                    }
                }
            }
//            case 1:{
//                switch(data.getDate()){
//                    
//                }
//            }
//            case 2:{
//                switch(data.getDate()){
//                    
//                }
//            }
            case 3:{
                switch(data.getDate()){
                    case 21:{
                        return true;
                    }
                }
            }
            case 4:{
                switch(data.getDate()){
                    case 1:{
                        return true;
                    }  
                }
            }
            case 5:{
                switch(data.getDate()){
                    case 19:{
                        return true;
                    }
                }
            }
//            case 6:{
//                switch(data.getDate()){
//                    
//                }
//            }
//            case 7:{
//                switch(data.getDate()){
//                    
//                }
//            }
            case 8:{
                switch(data.getDate()){
                    case 7:{
                        return true;
                    }
                }
            }
            case 9:{
                switch(data.getDate()){
                    case 12:{
                        return true;
                    }
                }
            }
            case 10:{
                switch(data.getDate()){
                    case 2:{
                        return true;
                    }
                    case 15:{
                        return true;
                    }
                    case 30:{
                        return true;
                    }
                }
            }
            case 11:{
                switch(data.getDate()){
                    case 25:{
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public String retornadataehora(){
        Date data = new Date();
        String dia = "" + data.getDate();
        String mes = "" + String.valueOf(data.getMonth() + 1);
        String ano = "" + (1900 + data.getYear());
        if (Integer.parseInt(mes) <= 9) {
            mes = "0" + mes;
        }
        if (Integer.parseInt(dia) <= 9) {
            dia = "0" + dia;
        }
        return dia + "/" + mes + "/" + ano + " "+data.getHours()+":"+data.getMinutes()+":"+data.getSeconds();
    }
    
}
