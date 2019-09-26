package br.com.poli.campoMinado;

public class Main {

	public static void main(String[] args) {
		
		CampoMinado c1 = new CampoMinado(Dificuldade.FACIL , "Lucas"); //CRIAR CAMPOMINADO
		System.out.println(c1.getJogador().getNome());
		
		CampoMinado c2 = new CampoMinado(Dificuldade.DIFICIL , "Arthur"); 
		 //CHECAR SE JOGADOR FOI PREENCHIDO
		System.out.println(c2.getJogador().getNome());

	}

}
