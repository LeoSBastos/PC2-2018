package br.com.prog2.heranca2;

public class Preguica extends Animal{
    public Preguica() {
        super();
    }

    @Override
    public String emiteSom() {
        return super.emiteSom()+"Preguiçoso demais para fazer um som coerente";
    }
    public String sobeArvore(){
        return "Subindo";
    }
}
