package br.com.prog2.aula4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDataFormat {
	public static String formataData(Date dataAFormatar){
        SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = f.format(dataAFormatar);
        return dataFormatada;
    }
}
