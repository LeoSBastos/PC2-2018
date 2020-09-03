package br.com.prog2.heranca2;

public class Cavalo extends Animal{
    public Cavalo() {
        super();
    }

    @Override
    public String emiteSom() {
        return super.emiteSom()+"Relincho";
    }

    public String correr(){
        return "Correndo";
    }
}
