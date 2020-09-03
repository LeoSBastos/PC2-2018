package br.com.prog2.aula08;

public class Teste {

	public static void main(String[] args) {
		Bicicleta b = new Bicicleta(1,0);
		Carro c = new Carro(1,0);
		System.out.println(b.iniciando());
		b.aumentarVelocidade(5);
		b.trocarMarcha(2);
		b.aplicarFrenagem(2);
		System.out.println("Estado da bicicleta");
		b.mostraEstado();
		System.out.println(Veiculo.finalizando());
		System.out.println(c.iniciando());
		c.aumentarVelocidade(60);
		c.trocarMarcha(2);
		c.aplicarFrenagem(15);
		System.out.println("Estado do carro");
		c.mostraEstado();
		System.out.println(Veiculo.finalizando());
	}
	
}
