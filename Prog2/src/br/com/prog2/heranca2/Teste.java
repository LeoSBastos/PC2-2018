package br.com.prog2.heranca2;

public class Teste {
    public static void main(String[] args) {
        Fornecedor p1 = new Fornecedor();
        Empregado p2 = new Empregado();
        Administrador p3 = new Administrador();
        Operario p4 = new Operario();
        Vendedor p5 = new Vendedor();

        Cachorro a1 = new Cachorro();
        Cavalo a2 = new Cavalo();
        Preguica a3 = new Preguica();
        Veterinario v1 = new Veterinario();

        Funcionario[] empresa = new Funcionario[10];

        p1.setNome("Pedro");
        p1.setValorCredito(1000.0);
        p1.setValorDivida(500.0);
        System.out.println(p1.getNome()+": "+p1.getSaldo());

        p2.setNome("Alice");
        p2.setImposto(15.0);
        p2.setSalarioBase(900.0);
        p2.calcularSalario();
        System.out.println(p2.getNome()+": "+p2.getSalarioFinal());

        p3.setNome("Luiz");
        p3.setImposto(15.0);
        p3.setSalarioBase(1200.0);
        p3.setAjudaDeCusto(300.0);
        p3.calcularSalario();
        System.out.println(p3.getNome()+": "+p3.getSalarioFinal());

        p4.setNome("Matheus");
        p4.setImposto(15.0);
        p4.setSalarioBase(1200.0);
        p4.setValorProducao(1000.0);
        p4.setComissao(5.0);
        p4.calcularSalario();
        System.out.println(p4.getNome()+": "+p4.getSalarioFinal());

        p5.setNome("Gabriel");
        p5.setImposto(15.0);
        p5.setSalarioBase(900.0);
        p5.setValorVendas(5000.0);
        p5.setComissao(10.0);
        p5.calcularSalario();
        System.out.println(p5.getNome()+": "+p5.getSalarioFinal());



        a1.setNome("Rex");
        System.out.println("Nome: "+a1.getNome()+"\n"+a1.emiteSom());
        v1.examinar(a1);

        a2.setNome("Pé de Pano");
        System.out.println("Nome: "+a1.getNome()+"\n"+a1.emiteSom());
        v1.examinar(a2);

        a3.setNome("Eu");
        System.out.println("Nome: "+a1.getNome()+"\n"+a1.emiteSom());
        v1.examinar(a3);

        for (int i = 0;i<empresa.length;i++) {
            empresa[i].setNome("Funcionario"+i);
            if (i<4){
                empresa[i].setGrauEscolariedade("Basico");
            }
            else if(i<8){
                empresa[i].setGrauEscolariedade("Medio");
            }
            else{
                empresa[i].setGrauEscolariedade("Superior");
            }
        }

        for(Funcionario i:empresa){
            i.calculaSalario();
        }

        Double salarioBasico = 0.0;
        Double salarioMedio = 0.0;
        Double salarioSuperior = 0.0;

        for(Funcionario i:empresa){
            switch (i.getGrauEscolariedade()){
                case "Basico":
                    salarioBasico+=i.getSalarioFinal();
                    break;
                case "Medio":
                    salarioMedio+=i.getSalarioFinal();
                    break;
                case "Superior":
                    salarioSuperior+=i.getSalarioFinal();
                    break;
            }
        }

        Double salarioTotal = salarioBasico + salarioMedio + salarioSuperior;
        System.out.println("Despesa Total da Empresa: "+salarioTotal);
        System.out.println("Despesa do Ensino Basico da Empresa: "+salarioBasico);
        System.out.println("Despesa do Ensino Medio da Empresa: "+salarioMedio);
        System.out.println("Despesa do Ensino Superior da Empresa: "+salarioSuperior);

        for (int i = 0;i<empresa.length;i++) {
            if (i<7){
                empresa[i].setCargo("Vendedor");
            }
            else if(i<9){
                empresa[i].setCargo("Supervisor");
            }
            else{
                empresa[i].setCargo("Gerente");
            }
        }

        salarioTotal = 0.0;

        for(Funcionario i:empresa) {
            i.calculaComissao();
            i.calculaSalario();
        }

        for (Funcionario i:empresa) {
            salarioTotal+=i.getSalarioFinal();
        }

        System.out.println("Despesa Total da Empresa: "+salarioTotal);

    }
}
