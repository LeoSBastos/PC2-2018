package br.com.prog2.abstratas1;

public abstract class ContaBancaria implements Imprimivel {
    protected int numeroConta;
    protected Double saldo;

    public abstract void sacar(Double valor);
    public abstract void depositar(Double valor);

    @Override
    public void mostrarDados() {
        
    }
}
