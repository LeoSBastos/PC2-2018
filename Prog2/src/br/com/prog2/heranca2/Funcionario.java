package br.com.prog2.heranca2;

public class Funcionario {
    private String nome;
    private int condigoFuncional;
    private String instituicao;
    private String grauEscolariedade;
    private String cargo;
    private Double salarioBase = 1000.0;
    private Double salarioFinal;
    private Double comissao;

    public Funcionario(){
    }
    public Funcionario(String nome,int condigoFuncional){
        this.nome=nome;
        this.condigoFuncional=condigoFuncional;
    }
    public Funcionario(String nome,int condigoFuncional,String grauEscolariedade,String instituicao){
        this.nome=nome;
        this.condigoFuncional=condigoFuncional;
        this.grauEscolariedade=grauEscolariedade;
        this.instituicao=instituicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCondigoFuncional() {
        return condigoFuncional;
    }

    public void setCondigoFuncional(int condigoFuncional) {
        this.condigoFuncional = condigoFuncional;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getGrauEscolariedade() {
        return grauEscolariedade;
    }

    public void setGrauEscolariedade(String grauEscolariedade) {
        this.grauEscolariedade = grauEscolariedade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public void setSalarioFinal(Double salarioFinal) {
        this.salarioFinal = salarioFinal;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public void calculaSalario() {
        switch (grauEscolariedade) {
            case "Basico":
                salarioFinal = (salarioBase * 1.1)+comissao;
                break;
            case "Medio":
                salarioFinal = (salarioBase * 1.5)+comissao;
                break;
            case "Superior":
                salarioFinal = (salarioBase * 2)+comissao;
                break;
            default:
                salarioFinal = salarioBase+comissao;
                break;
        }
    }

    public void calculaComissao(){
        switch (cargo) {
            case "Gerente":
                comissao = 1500.0;
                break;
            case "Supervisor":
                comissao = 600.0;
                break;
            case "Vendedor":
                comissao= 250.0;
                break;
        }
    }

    @Override
    public String toString() {
        return "Nome:" + nome +
                "\nComissao:" + comissao +
                "\nSalario Final: " + salarioFinal;
    }
}
