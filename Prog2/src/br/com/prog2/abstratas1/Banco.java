package br.com.prog2.abstratas1;

import java.util.ArrayList;

public class Banco implements Imprimivel {
	ArrayList<ContaBancaria> banco = new ArrayList<ContaBancaria>();

	public void inserir(ContaBancaria c) {
		banco.add(c);
	}

	public void remover(ContaBancaria c) {
		banco.remove(c);
	}

	public ContaBancaria procurarConta(int i) {
		for (ContaBancaria aux : banco) {
			if (aux.numeroConta == i) {
				return aux;
			}
		}
		return null;
	}

	@Override
	public void mostrarDados() {
		for (ContaBancaria aux : banco) {
			if (aux instanceof ContaCorrente) {
				System.out.println("Numero da conta: " + aux.numeroConta + "\nSaldo: " + aux.saldo + "\nTaxa de Operação: "
						+ ((ContaCorrente) aux).getTaxadeoperacao());

			} else {
				System.out.println("Numero da conta: " + aux.numeroConta + "\nSaldo: " + aux.saldo + "\nLimite: "
						+ ((ContaPoupanca) aux).getLimite());
			}
		}
	}
}
