package br.com.poli.campoMinado;

public class Main {

	public static void main(String[] args) {
		
		//TESTES 
		
		CampoMinado c1 = new CampoMinado(Dificuldade.FACIL , "Lucas"); //CRIAR CAMPO MINADO FACIL
		System.out.println();
		System.out.println("Nome do jogador: " + c1.getJogador().getNome()); //CHECAR SE JOGADOR 1 FOI PREENCHIDO
		System.out.println();
		System.out.println("Mapa encoberto:");
		c1.getMapa().escolherPosicao(0,0);
		System.out.println("Mapa aberto:");
		c1.getMapa().imprimeTela(true);
		System.out.println();
		
		
		System.out.println("----------------------------------------------");
		
		CampoMinado c2 = new CampoMinado(Dificuldade.MEDIO , "Joao"); //CRIAR CAMPO MINADO DIFICIL
		System.out.println();
		System.out.println("Nome do jogador: " + c2.getJogador().getNome()); //CHECAR SE JOGADOR 2 FOI PREENCHIDO
		System.out.println();
		System.out.println("Mapa encoberto:");
		c2.getMapa().escolherPosicao(0,0);
		System.out.println("Mapa aberto:");
		c2.getMapa().imprimeTela(true);
		System.out.println();
		System.out.println();
		
		System.out.println("----------------------------------------------");
		
		CampoMinado c3 = new CampoMinado(Dificuldade.DIFICIL , "Arthur"); //CRIAR CAMPO MINADO DIFICIL
		System.out.println();
		System.out.println("Nome do jogador: " + c2.getJogador().getNome()); //CHECAR SE JOGADOR 3 FOI PREENCHIDO
		System.out.println();
		System.out.println("Mapa encoberto:");
		c3.getMapa().escolherPosicao(0,0);
		System.out.println("Mapa aberto:");
		c3.getMapa().imprimeTela(true);
		System.out.println();

	}
	
}


