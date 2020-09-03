package br.com.prog2.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static String formataData(Date dataAFormatar){
        SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = f.format(dataAFormatar);
        return dataFormatada;
    }
}
