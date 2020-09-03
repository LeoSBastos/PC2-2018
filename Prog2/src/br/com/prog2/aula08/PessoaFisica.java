package br.com.prog2.aula08;

import java.time.LocalDate;

public class PessoaFisica extends Cliente {
	private String cpf;
	private String rg;
	private String sexo;
	private LocalDate dataDeNascimento;
	public PessoaFisica(Integer codigo, String nome, String endereco, String uf, String cep, String cpf, String rg,
			String sexo, LocalDate dataDeNascimento) {
		super(codigo, nome, endereco, uf, cep);
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.dataDeNascimento = dataDeNascimento;
	}
	@Override
	public void inserir() {
		System.out.println("Inserido");
	}
	@Override
	public void alterar() {
		System.out.println("Alterado");
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
}
