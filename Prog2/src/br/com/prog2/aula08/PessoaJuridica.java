package br.com.prog2.aula08;

import java.time.LocalDate;

public class PessoaJuridica extends Cliente {
	private String cnpj;
	private String sexo;
	private LocalDate dataDeNascimento;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public PessoaJuridica(Integer codigo, String nome, String endereco, String uf, String cep, String cnpj, String sexo,
			LocalDate dataDeNascimento) {
		super(codigo, nome, endereco, uf, cep);
		this.cnpj = cnpj;
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

}
