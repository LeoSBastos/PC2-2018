package br.com.prog2.heranca2;

public class Zoologico {
    Animal[] jaula = new Animal[10];

    public void comparar(){
        for (Animal i : jaula) {
            i.emiteSom();
            if(i instanceof Cachorro || i instanceof Cavalo) {
                ((Cavalo) i).correr();
            }
        }
    }

}
