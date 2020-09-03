package br.com.prog2.heranca2;

public class Animal {
    protected String nome;
    protected int idade;

    public Animal(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String emiteSom(){
        return "Som do Animal: ";
    }
}
