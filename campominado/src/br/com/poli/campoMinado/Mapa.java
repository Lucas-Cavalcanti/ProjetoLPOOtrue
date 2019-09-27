package br.com.poli.campoMinado;

import java.util.Random;

public class Mapa {
	
	//ATRIBUTOS
	
	private int[][] campo;
	
	private Dificuldade dificuldade;
	
	//CONSTRUTOR
	
	public Mapa(Dificuldade dificuldade) {
		
		if(dificuldade == Dificuldade.FACIL) {
			this.dificuldade = Dificuldade.FACIL;
		}
		else {
			this.dificuldade = Dificuldade.DIFICIL;
		}
		
		this.campo = new int[this.dificuldade.getValor()][this.dificuldade.getValor()]; //DEFININDO TAMANHO DO ARRAY CAMPO
		
		inicializaCampo();
		
		imprimeTela();
	
	}
	
	//MÉTODOS
	
	public void inicializaCampo() {
		Random geraBomba = new Random();
		int linha = 0;
		int coluna = 0;
		int numBombas = 10;
		
		for (int i = 0; i < numBombas ; i++) {
			
			do {
				
				linha = geraBomba.nextInt(campo.length);
				coluna = geraBomba.nextInt(campo.length);
				
			}
			while( campo[linha][coluna] == -1 ); 
			//SE NA POSIÇÃO SORTEADA JÁ HOUVER UM -1, O PROCESSO SERA REPETIDO PARA GARANTIR QUE HAJA 10 BOMBAS
			
			campo[linha][coluna] = -1;
			
			
		}
	}
		
	
	public void imprimeTela() {
		
		for (int i = 0; i < campo.length; i++) {
			System.out.println();
			System.out.println();
			for (int j = 0; j < campo.length; j++) {
				if(campo[i][j] == 0)
					System.out.print(" " + campo[i][j]);
				else
					System.out.print(campo[i][j]);
				System.out.print("  ");
		
			} 
			
		}
	}

	public int[][] getcampo() {
		return campo;
	}

	public void setcampo(int[][] campo) {
		this.campo = campo;
	}

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}
	
	
}


