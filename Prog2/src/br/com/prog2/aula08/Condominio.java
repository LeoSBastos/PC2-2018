package br.com.prog2.aula08;

import java.time.LocalDate;

public class Condominio {

	public static void main(String[] args) {
		Proprietario p = new Proprietario();
		Inquilino i = new Inquilino();
		
		p.setNome("Man� Joaquim");
		LocalDate dataDeNascimento = LocalDate.of(1965, 11, 10);
		p.setDataNascimento(dataDeNascimento);
		p.setNumeroFilho(3);
		p.setQtdeApartamento(4);
		double taxaP = p.calcularTaxaDeposito(5);
		System.out.println("Propriet�rio: "+p.getNome());
		System.out.println("Taxa: "+taxaP);
		
		i.setNome("Margarida");
		dataDeNascimento = LocalDate.of(1954, 3, 1);
		i.setNumeroFilho(0);
		i.setTempoContrato(12);
		double taxaI = i.calcularTaxaDeposito(5);
		System.out.println("Inquilino: "+i.getNome());
		System.out.println("Taxa: "+taxaI);
	}

}
