package br.com.prog2.trabalhosala1;

public class Servico {
	private Integer codigo;
	private String descricao;
	private Double precoHora;
	private Integer qtdeHora;
	
	public Double valorServico (){
		return precoHora*qtdeHora;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPrecoHora() {
		return precoHora;
	}

	public void setPrecoHora(Double precoHora) {
		this.precoHora = precoHora;
	}

	public Integer getQtdeHora() {
		return qtdeHora;
	}

	public void setQtdeHora(Integer qtdeHora) {
		this.qtdeHora = qtdeHora;
	}
	
	public String toString (Servico s) {
		return codigo + " " + descricao + " " + precoHora + " " +
				qtdeHora + " " + s.valorServico();
	}
}
