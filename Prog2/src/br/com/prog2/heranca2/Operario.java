package br.com.prog2.heranca2;

public class Operario extends Empregado {
    private Double valorProducao;
    private Double comissao;

    public Operario() {
        super();
    }

    public Double getValorProducao() {
        return valorProducao;
    }

    public void setValorProducao(Double valorProducao) {
        this.valorProducao = valorProducao;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    @Override
    public void calcularSalario() {
        super.calcularSalario();
        salarioFinal += (valorProducao * comissao / 100);
    }
}