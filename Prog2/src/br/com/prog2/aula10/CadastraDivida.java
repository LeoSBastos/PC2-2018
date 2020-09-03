package br.com.prog2.aula10;

import java.time.LocalDate;
import java.util.ArrayList;

public class CadastraDivida {

	public static void main(String[] args) {
		ArrayList<Divida> arr = new ArrayList<>();
		
		LocalDate data1;
		LocalDate data2;
		LocalDate data3;
		Divida d1 = new Divida();
		Divida d2 = new Divida();
		Divida d3 = new Divida();
		
		data1 = LocalDate.of(2015, 01, 29);
		data2 = LocalDate.of(1997, 02, 07);
		data3 = LocalDate.of(2011, 10, 07);
		
		d1.setCodigo(1);
		d1.setDataContato(data1);
		d1.setValor(540.00);
		
		d2.setCodigo(2);
		d2.setDataContato(data2);
		d2.setValor(935.00);
		
		d3.setCodigo(3);
		d3.setDataContato(data3);
		d3.setValor(840.00);
		
		arr.add(d1);
		arr.add(d2);
		arr.add(d3);
		
		for(int i = 0; i<arr.size();i++){
			System.out.println(arr.get(i));
		}
	}

}
