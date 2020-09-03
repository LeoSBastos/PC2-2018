package br.com.prog2.abstratas1;

public class ContaPoupanca extends ContaBancaria implements Imprimivel{
    private Double limite;

    @Override
    public void sacar(Double valor) {
        if(saldo>limite&&(saldo-valor)>limite) {
            saldo-=valor;
        }
    }

    @Override
    public void depositar(Double valor) {
        saldo+=valor;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    @Override
    public void mostrarDados() {
        System.out.println("Numero da conta: "+numeroConta+
                "\nSaldo: "+saldo+
                "\nLimite: "+limite);
    }
}
