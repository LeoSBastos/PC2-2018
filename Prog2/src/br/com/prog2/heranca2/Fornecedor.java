package br.com.prog2.heranca2;

public class Fornecedor extends Pessoa{
    private Double valorCredito;
    private Double valorDivida;

    public Fornecedor(){
        super();
    }

    public void setValorCredito(Double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public void setValorDivida(Double valorDivida) {
        this.valorDivida = valorDivida;
    }

    public Double getValorCredito() {
        return valorCredito;
    }

    public Double getValorDivida() {
        return valorDivida;
    }

    public Double getSaldo(){
        return valorCredito-valorDivida;
    }
}
