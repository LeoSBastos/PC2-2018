package br.com.prog2.aula08;

public interface Veiculo {
	void trocarMarcha(int marcha);
	void aumentarVelocidade(int velocidade);
	void aplicarFrenagem(int intensidade);
	
	default String iniciando(){
		return "Iniciando movimento";
	}
	
	static String finalizando(){
		return "Finalizando movimento";
	}
}
