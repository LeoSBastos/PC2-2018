package br.com.prog2.trabalho3;

import java.text.NumberFormat;
import java.util.Locale;

public class Salario {
	Double salariobruto;
	Double INSS;
	Integer dependentes;
	Double descontodependentes;
	Double IRPF;
	Double salarioliquido;

	public Salario(Double salariobruto, Integer dependentes) {
		this.salariobruto = salariobruto;
		this.dependentes = dependentes;
	}

	public void calculaINSS() {
		if (salariobruto <= 1693.72) {
			this.INSS = salariobruto * 0.08;
		} 
		else if (salariobruto <= 2882.90) {
			this.INSS = salariobruto * 0.09;
		} 
		else if (salariobruto <= 5645.80) {
			this.INSS = salariobruto * 0.11;
		}
		else this.INSS = 621.04;
	}
	
	public void calculaDescontoDependentes(){
		this.descontodependentes = dependentes * 189.59;
	}
	
	public void calculaIRPF(){
		Double baseIRPF = salariobruto-INSS-descontodependentes;
		if(baseIRPF<=1903.98){
			this.IRPF=0.0;
		}
		else if(baseIRPF<=2826.85){
			this.IRPF=(baseIRPF*0.075)-142.80;
		}
		else if(baseIRPF<=3751.05){
			this.IRPF=(baseIRPF*0.15)-354.80;
		}
		else if(baseIRPF<=4664.68){
			this.IRPF=(baseIRPF*0.225)-636.13;
		}
		else this.IRPF=(baseIRPF*0.275)-869.36;
	}
	
	public void calculaLiquido(){
		this.salarioliquido=salariobruto-INSS-IRPF;
	}
	
	public String formataDinheiro(double v){
		Locale n = new Locale("pt","BR");
		NumberFormat nf = NumberFormat.getCurrencyInstance(n);
		return nf.format(v);
	}

	public String toString() {
		return "INSS: " +formataDinheiro(INSS)+ ", Deducao com dependentes: " +formataDinheiro(descontodependentes)+ ", IRPF: " +formataDinheiro(IRPF) + ", Liquido: "
				+formataDinheiro(salarioliquido);
	}
}
