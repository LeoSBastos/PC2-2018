package br.com.prog2.venda;

public class PontoDeVenda{
    public static void main(String[] args) {
        
        
        Venda v1 = new Venda(12345678,35.0);
        Venda v2 = new Venda(11111111,199.99);
        
        v1.calculaDesconto(10.0);
        v2.calculaDesconto(10.0);

        System.out.println("Dados da venda 1: ");
        System.out.println(v1.toString());
        System.out.println("Dados da venda 2: ");
        System.out.println(v2.toString());
    }
}