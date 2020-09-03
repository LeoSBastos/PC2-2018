package br.com.prog2.aula04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.prog2.util.DataPadraoBrasil;

public class CadastraAlunoBuff {
    public static void main(String[] args) throws IOException{
    InputStreamReader ir = new InputStreamReader(System.in);
    BufferedReader bf = new BufferedReader(ir);

    
    System.out.println("Digite a matrícula do aluno: ");
    String matricula = bf.readLine();
    System.out.println("Digite o nome do Aluno");
    String nome = bf.readLine();
    
    System.out.println("Digite o dia do nascimento: ");
    String dia = bf.readLine();
    System.out.println("Digite o mês do nascimento: ");
    String mes = bf.readLine();
    System.out.println("Digite o ano do nascimento: ");
    String ano = bf.readLine();
    
    bf.close();
    ir.close();
   
    DataPadraoBrasil dataDeNascimento = new DataPadraoBrasil(dia, mes, ano);
    Aluno aluno = new Aluno(Integer.parseInt(matricula),nome,dataDeNascimento);
    System.out.println("Aluno: "+aluno.nome+ "\nMatricula:"+aluno.matricula+"\nData de nascimento: "+dataDeNascimento.toString());
}
}