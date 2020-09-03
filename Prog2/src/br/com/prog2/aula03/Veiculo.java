package br.com.prog2.aula03;

import java.util.Date;
import br.com.prog2.util.Util;

public class Veiculo {
	String placa;
	Double velocidade;
	String hora;
	Date dataEvento;
	

	
	public Veiculo() {
		this.velocidade = 0.0;
		this.hora = "00:00";
		this.dataEvento = new Date();
	}
	
	public void acelerar(Integer add) {
		this.velocidade = velocidade + add;
		
	
	}
	public void frear(Integer sub) {
		this.velocidade = velocidade - sub;

	}
	public void parar() {
		this.velocidade = 0.0;
	}
	public String toString(){

		return "Placa: " +placa+
			   "\nVelocidade: "+velocidade+
			   "\nData: "+Util.formataData(dataEvento)+
			   "\nHora: "+hora;
	}
}