package br.com.poli.campoMinado;

import java.util.Random;

public class Mapa {
	
	//ATRIBUTOS
	
	private int[][] mapa;
	
	private Dificuldade dificuldade;
	
	//CONSTRUTOR
	
	public Mapa(Dificuldade dificuldade) {
		
		if(dificuldade == Dificuldade.FACIL) {
			this.dificuldade = Dificuldade.FACIL;
		}
		else {
			this.dificuldade = Dificuldade.DIFICIL;
		}
		
		this.mapa = new int[this.dificuldade.getValor()][this.dificuldade.getValor()];
		
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
				
				linha = geraBomba.nextInt(mapa.length);
				coluna = geraBomba.nextInt(mapa.length);
				
			}
			
			while( mapa[linha][coluna] == -1 );
			
			mapa[linha][coluna] = -1;
		}
		}
		
	
	public void imprimeTela() {
		
		for (int i = 0; i < mapa.length; i++) {
			System.out.println();
			System.out.println();
			for (int j = 0; j < mapa.length; j++) {
				if(mapa[i][j] == 0)
					System.out.print(" " + mapa[i][j]);
				else
					System.out.print(mapa[i][j]);
				System.out.print("  ");
		
			} 
			
		}
	}

	public int[][] getMapa() {
		return mapa;
	}

	public void setMapa(int[][] mapa) {
		this.mapa = mapa;
	}

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}
	
	
}


