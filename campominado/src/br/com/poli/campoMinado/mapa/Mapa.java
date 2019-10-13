package br.com.poli.campoMinado.mapa;

import br.com.poli.campoMinado.*;

import java.util.Random;

public abstract class Mapa {
	
	//ATRIBUTOS
	
	private Celula[][] campo;
	
	private Dificuldade dificuldade;
	
	//CONSTRUTOR
	
	public Mapa(Dificuldade dificuldade) {
		
		if(dificuldade == Dificuldade.FACIL) {
			this.dificuldade = Dificuldade.FACIL;
		}
		else if(dificuldade == Dificuldade.MEDIO) {
			this.dificuldade = Dificuldade.MEDIO;
		}
		else {
			this.dificuldade = Dificuldade.DIFICIL;
		}
		
		this.campo = new Celula[this.dificuldade.getValor()][this.dificuldade.getValor()]; //DEFININDO TAMANHO DO ARRAY CAMPO
		
		inicializaCelulas();
		
		distribuirBombas(10);
		
		imprimeTela();
	
	}
	
	//MÉTODOS
	
	public void inicializaCelulas() {
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				campo[i][j].setBandeira(false);
			}
		}
	}
	
	public void distribuirBombas(int bombas) {
		Random geraBomba = new Random();
		int linha = 0;
		int coluna = 0;
		
		for (int i = 0; i < bombas ; i++) {
			
			do {
				
				linha = geraBomba.nextInt(campo.length);
				coluna = geraBomba.nextInt(campo.length);
				
			}
			while(campo[linha][coluna].isBandeira() == true ); 
			//SE NA POSIÇÃO SORTEADA JÁ HOUVER UM -1, O PROCESSO SERA REPETIDO PARA GARANTIR QUE HAJA 10 BOMBAS
			
			campo[linha][coluna].setBandeira(true);
			
			
		}
	}
	
	
	
	public void imprimeTela() {
		
		for (int i = 0; i < campo.length; i++) {
			System.out.println();
			System.out.println();
			for (int j = 0; j < campo.length; j++) {
				if(campo[i][j].isBandeira() == false)
					System.out.print(" 0");
				else
					System.out.print("-1");
				System.out.print("  ");
		
			} 
			
		}
	}

	public Celula[][] getCampo() {
		return campo;
	}

	public void setCampo(Celula[][] campo) {
		this.campo = campo;
	}

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}

	
}


