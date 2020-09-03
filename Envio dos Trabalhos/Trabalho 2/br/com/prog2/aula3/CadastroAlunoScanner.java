package br.com.prog2.aula3;

import java.util.Scanner;

import br.com.prog2.util.DataPadraoBrasil;

public class CadastroAlunoScanner{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do aluno: ");
        String nome = sc.nextLine();
        System.out.println("Digite a matricula do aluno: ");
        int matricula = sc.nextInt();   
        
        System.out.println("Digite o dia do nascimento: ");
        String dia = sc.next();
        System.out.println("Digite o mes do nascimento: ");
        String mes = sc.next();
        System.out.println("Digite o ano do nascimento: ");
        String ano = sc.next();
        sc.close();

        DataPadraoBrasil dataDeNascimento = new DataPadraoBrasil(dia, mes, ano);
        Aluno aluno = new Aluno(matricula,nome,dataDeNascimento);

        System.out.println("Aluno: "+aluno.nome+ "\nMatricula:"+aluno.matricula+"\nData de nascimento: "+dataDeNascimento.toString());
        
    }
}