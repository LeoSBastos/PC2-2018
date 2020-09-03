package br.com.prog2.abstratas1;

public class Teste {
    public static void main(String[] args) {

        ContaCorrente c1 = new ContaCorrente();
        ContaPoupanca c2 = new ContaPoupanca();


        c1.setTaxadeoperacao(2.5);
        c1.depositar(100.0);
        c1.sacar(80.0);

        c2.setLimite(50.0);
        c2.depositar(100.0);
        c2.sacar(125.0);

        Relatorio a = new Relatorio();

        a.gerarRelatorio(c1);
        a.gerarRelatorio(c2);
    }
}
