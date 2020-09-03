package br.com.prog2.heranca2;

public class Empregado extends Pessoa {
    protected int codigoSetor;
    protected Double salarioBase;
    protected Double imposto;
    protected Double salarioFinal;

    public Empregado() {
        super();
    }

    public int getCodigoSetor() {
        return codigoSetor;
    }

    public void setCodigoSetor(int codigoSetor) {
        this.codigoSetor = codigoSetor;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Double getSalarioFinal() {
        return salarioFinal;
    }

    public Double getImposto() {
        return imposto;
    }

    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }

    public void calcularSalario(){
        salarioFinal = salarioBase*(1-(imposto/100));
    }
}
