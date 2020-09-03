package br.com.prog2.aula03;


public class Monitoramento {
    public static void main(String[] args) {

        Veiculo v1 = new Veiculo();
        Veiculo v2 = new Veiculo();
    
        v1.placa = "JIB9089";

        System.out.println("Veiculo 1, incialmente");
        System.out.println(v1.toString());
        
        
        v1.hora = "09:00";
        
        
        v1.acelerar(70);

        System.out.println("Veiculo 1, depois");
        System.out.println(v1.toString());
        v1.parar();

        v2.placa = "VSFELOY";

        System.out.println("Veiculo 2, incialmente");
        System.out.println(v2.toString());

        v2.hora = "09:00";
        
        
        v2.acelerar(90);
        v2.frear(10);

        System.out.println("Veiculo 2, depois");
        System.out.println(v2.toString()); 
        v2.parar();
    }
}
