package br.com.poli.campoMinado;

import br.com.poli.campoMinado.mapa.*;

public class Main {

	public static void main(String[] args) {
		
		//TESTES 
		
		CampoMinado c1 = new CampoMinado(Dificuldade.FACIL , "Lucas"); //CRIAR CAMPO MINADO FACIL
		
		System.out.println(c1.getJogador().getNome()); //CHECAR SE JOGADOR 1 FOI PREENCHIDO
		
		CampoMinado c2 = new CampoMinado(Dificuldade.MEDIO , "Joao"); //CRIAR CAMPO MINADO DIFICIL
		
		System.out.println(c2.getJogador().getNome()); //CHECAR SE JOGADOR 2 FOI PREENCHIDO
		
		CampoMinado c3 = new CampoMinado(Dificuldade.DIFICIL , "Arthur"); //CRIAR CAMPO MINADO DIFICIL
		
		System.out.println(c3.getJogador().getNome()); //CHECAR SE JOGADOR 3 FOI PREENCHIDO

	}

}


