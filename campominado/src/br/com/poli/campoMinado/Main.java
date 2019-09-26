package br.com.poli.campoMinado;

public class Main {

	public static void main(String[] args) {
		
		//TESTES 
		
		CampoMinado c1 = new CampoMinado(Dificuldade.FACIL , "Lucas"); //CRIAR CAMPOMINADO FACIL
		
		System.out.println(c1.getJogador().getNome()); //CHECAR SE JOGADOR 1 FOI PREENCHIDO
		
		CampoMinado c2 = new CampoMinado(Dificuldade.DIFICIL , "Arthur"); //CRIAR CAMPOMINADO DIFICIL
		 
		System.out.println(c2.getJogador().getNome()); //CHECAR SE JOGADOR 2 FOI PREENCHIDO

	}

}
