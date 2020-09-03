package br.com.prog2.heranca2;

public class Vendedor extends Empregado{
    private Double valorVendas;
    private Double comissao;

    public Vendedor() {
        super();
    }

    public Double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(Double valorVendas) {
        this.valorVendas = valorVendas;
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
        salarioFinal += (valorVendas*comissao/100);

    }
}
