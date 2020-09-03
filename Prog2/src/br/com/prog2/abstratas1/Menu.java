package br.com.prog2.abstratas1;

import javax.swing.JOptionPane;
import java.util.Random;

public class Menu {

    public static void menu1(Banco a) {
        String aux = JOptionPane.showInputDialog("Bem vindo ao menu." +
                "\n1-Criar Conta" +
                "\n2-Selecionar conta" +
                "\n3-Remover conta" +
                "\n4-Gerar relatorio" +
                "\n5-Finalizar" +
                "\nDigite sua opcao");

        switch (aux) {
            case "1":
                Random r = new Random();
                String op = JOptionPane.showInputDialog("Digite 1 para Conta Corrente e 2 para Conta Poupanca");
                if (op.equals("1")) {
                    ContaCorrente cc = new ContaCorrente();
                    cc.numeroConta = r.nextInt(100);
                    a.inserir(cc);
                }
                if(op.equals("2")){
                    ContaPoupanca cp = new ContaPoupanca();
                    cp.numeroConta = r.nextInt(100);
                    a.inserir(cp);
                }
                break;
            case "2":
                int a1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da sua conta: "));
                ContaBancaria a2 = a.procurarConta(a1);
                if (a2 != null) {
                    menu2(a, a2);
                }
                break;
            case "3":
                a1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da sua conta: "));
                a2 = a.procurarConta(a1);
                if (a2 != null) {
                    a.remover(a2);
                    System.out.println("Sucesso!");
                }
                else{
                    System.out.println("Conta não existe!");
                }
                break;
            case "4":
                a.mostrarDados();
                break;
            case "5":
                System.exit(1);
            break;
        }

}

    public static void menu2(Banco a, ContaBancaria i) {
        String aux = JOptionPane.showInputDialog("Bem vindo ao menu." +
                "\na-Depositar" +
                "\nb-Sacar" +
                "\nc-Transferir" +
                "\nd-Gerar relatorio" +
                "\ne-Retornar ao menu anterior" +
                "\nDigite sua opcao");

        switch (aux) {
            case "a":
                Double a1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da operação"));
                i.depositar(a1);
                break;
            case "b":
                a1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da operação"));
                i.sacar(a1);
                break;
            case "c":
                int ncaux = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta na qual você deseja transefir"));
                ContaBancaria caux = a.procurarConta(ncaux);
                a1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da operação"));
                ((ContaCorrente) i).transferir(a1,caux);
                break;
            case "d":
                Relatorio r = new Relatorio();
                r.gerarRelatorio(i);
                break;
            case "e":
                menu1(a);
                break;
        }
    }

    public static void main(String[] args) {
        Banco a = new Banco();
        menu1(a);
    }
}
