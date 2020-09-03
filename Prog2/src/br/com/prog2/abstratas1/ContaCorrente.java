package br.com.prog2.abstratas1;

public class ContaCorrente extends ContaBancaria implements Imprimivel{
    private Double taxadeoperacao;

    public Double getTaxadeoperacao() {
        return taxadeoperacao;
    }

    public void setTaxadeoperacao(Double taxadeoperacao) {
        this.taxadeoperacao = taxadeoperacao;
    }

    public void transferir(Double valor,ContaBancaria c){
        sacar(valor);
        c.depositar(valor);
    }

    @Override
    public void sacar(Double valor) {
        if (saldo > 0.0 && saldo > (valor + taxadeoperacao)){
            saldo -= (valor + taxadeoperacao);
        }
    }

    @Override
    public void depositar(Double valor) {
        saldo += valor;
    }

    @Override
    public void mostrarDados() {
        System.out.println("Numero da conta: "+numeroConta+
                "\nSaldo: "+saldo+
                "\nTaxa de Operação: "+taxadeoperacao);
    }
}
