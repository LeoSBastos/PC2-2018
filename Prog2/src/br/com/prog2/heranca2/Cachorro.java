package br.com.prog2.heranca2;

public class Cachorro extends Animal{

    public Cachorro() {
        super();
    }

    @Override
    public String emiteSom() {
        return super.emiteSom()+"Au Au";
    }

    public String correr(){
        return "Correndo";
    }
}
