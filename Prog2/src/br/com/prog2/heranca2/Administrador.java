package br.com.prog2.heranca2;

public class Administrador extends Empregado{
    private Double ajudaDeCusto;


    public Administrador() {
        super();
    }

    public Double getAjudaDeCusto() {
        return ajudaDeCusto;
    }

    public void setAjudaDeCusto(Double ajudaDeCusto) {
        this.ajudaDeCusto = ajudaDeCusto;
    }

    @Override
    public void calcularSalario() {
        super.calcularSalario();
        salarioFinal += ajudaDeCusto;
    }
}
