package br.com.prog2.trabalho4;

import java.text.NumberFormat;
import java.util.Locale;

public class ContraCheque {
	Double DSR = 0.167;
	Double ACT = 0.021;
	Double INSS, IRPF, adnot, baseIRPF, descontodependentes, FGTS, sb, rb, sl, vlha, SVC;
	
	Integer nh, qhn, dependentes;
	

	public void calculaSB(){
		this.sb = this.vlha * this.nh * 4.5;
	}
	
	public void calculaADNOT(){
		this.adnot = (vlha*qhn*0.2);
	}
	
	public void calculaRB(){
		this.rb = this.sb + (this.sb*this.DSR) + (this.sb*this.ACT) + this.adnot;
	}
	
	public void calculaINSS() {
		if (rb <= 1693.72) {
			this.INSS = rb * 0.08;
		} 
		else if (rb <= 2882.90) {
			this.INSS = rb * 0.09;
		} 
		else if (rb <= 5645.80) {
			this.INSS = rb * 0.11;
		}
		else this.INSS = 621.04;
	}
	
	public void calculaFGTS(){
		this.FGTS = this.rb * 0.08;
	}
	
	public void calculaDescontoDependentes(){
		this.descontodependentes = this.dependentes * 189.59;
	}
	
	public void calculaIRPF(){
		this.baseIRPF = this.rb-this.INSS-this.descontodependentes;
		if(this.baseIRPF<=1903.98){
			this.IRPF=0.0;
		}
		else if(this.baseIRPF<=2826.85){
			this.IRPF=(this.baseIRPF*0.075)-142.80;
		}
		else if(this.baseIRPF<=3751.05){
			this.IRPF=(this.baseIRPF*0.15)-354.80;
		}
		else if(this.baseIRPF<=4664.68){
			this.IRPF=(this.baseIRPF*0.225)-636.13;
		}
		else this.IRPF=(this.baseIRPF*0.275)-869.36;
	}
	
	public void calculaSVC(){
		this.SVC = this.sb * 0.002;
	}
	
	public void calculaLiquido(){
		this.sl =this.rb-this.INSS-this.IRPF-this.SVC;
	}
	
	public void toCalcular(){
		calculaSB();
		calculaADNOT();
		calculaRB();
		calculaINSS();
		calculaFGTS();
		calculaDescontoDependentes();
		calculaIRPF();
		calculaSVC();
		calculaLiquido();
	}
	
	public String toFormatar(double v){
		Locale n = new Locale("pt","BR");
		NumberFormat nf = NumberFormat.getCurrencyInstance(n);
		return nf.format(v);
	}
	
	public String porcentagem(double v){
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(1);
		return nf.format(v);
	}
	
	public String toString(){
		return "DSR: "+porcentagem(this.DSR)+"\nACT: "+porcentagem(this.ACT)+"\nSalario Base: "+toFormatar(this.sb)+"\nAdicional Noturno: "+toFormatar(this.adnot)+"\nDesconto do INSS: "+toFormatar(this.INSS)+"\nDesconto do IRPF: "+toFormatar(this.IRPF)+"\nDesconto de Seguro de Vida (SVC): "+toFormatar(this.SVC)+"\nSalario Bruto: "+toFormatar(this.rb)+"\nSalario base para INSS: "+toFormatar(this.rb)+"\nSalário Base para FGTS: "+toFormatar(this.rb)+"\nSalário Base para IRPF: "+toFormatar(this.baseIRPF)+"\nValor do FGTS: "+toFormatar(this.FGTS)+"\nSalário líquido: "+toFormatar(this.sl);
	}
	
	
}
