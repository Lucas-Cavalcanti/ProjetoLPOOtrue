package br.com.poli.campoMinado;

public class Main {

	public static void main(String[] args) {
		
		//TESTES 
		
		CampoMinado c1 = new CampoMinado(Dificuldade.FACIL , "Lucas"); //CRIAR CAMPO MINADO COM MAPA FACIL
		System.out.println("JOGO COM MAPA FÁCIL");
		System.out.println("Nome do jogador: " + c1.getJogador().getNome()); //CHECAR SE JOGADOR 1 FOI PREENCHIDO
		c1.iniciarJogo();
		c1.getMapa().imprimeTela(true); //IMPRIME O MAPA DESCOBERTO
		System.out.println();
		System.out.println();
		
		System.out.println("----------------------------------------------");
		
		CampoMinado c2 = new CampoMinado(Dificuldade.MEDIO , "Joao"); //CRIAR CAMPO MINADO COM MAPA MEDIO
		System.out.println("MAPA MÉDIO");
		System.out.println("Nome do jogador: " + c2.getJogador().getNome()); //CHECAR SE JOGADOR 2 FOI PREENCHIDO
		c2.iniciarJogo();
		c2.getMapa().imprimeTela(true); //IMPRIME O MAPA DESCOBERTO
		System.out.println();
		System.out.println();
		
		System.out.println("----------------------------------------------");
		
		CampoMinado c3 = new CampoMinado(Dificuldade.DIFICIL , "Arthur"); //CRIAR CAMPO MINADO COM MAPA DIFICIL
		System.out.println("MAPA DIFÍCIL");
		System.out.println("Nome do jogador: " + c3.getJogador().getNome()); //CHECAR SE JOGADOR 3 FOI PREENCHIDO
		c3.iniciarJogo();
		c3.getMapa().imprimeTela(true); //IMPRIME O MAPA DESCOBERTO

	}
	
}


