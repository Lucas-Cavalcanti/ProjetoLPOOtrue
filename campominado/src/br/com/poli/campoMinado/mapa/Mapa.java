package br.com.poli.campoMinado.mapa;

import br.com.poli.campoMinado.*;

import java.util.Random;

public abstract class Mapa {
	
	//ATRIBUTOS
	
	private Celula[][] campo;
	
	private Dificuldade dificuldade;
	
	private int bombas;
	
	//CONSTRUTOR
	
	public Mapa(Dificuldade dificuldade,int bombas) {
		
		this.bombas = bombas;
		this.dificuldade = dificuldade;
		this.campo = new Celula[this.dificuldade.getValor()][this.dificuldade.getValor()]; //DEFININDO TAMANHO DO ARRAY CAMPO
		
		inicializaCelulas();
			
		distribuirBombas(this.bombas);
		
		contarBombas();
		
	}
	
	//MÉTODOS
	
	public void inicializaCelulas() {
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				campo[i][j] = new Celula(false,false,false,0);
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
			while(campo[linha][coluna].isBomba() == true ); 
			//SE NA POSIÇÃO SORTEADA JÁ HOUVER UMA BOMBA (-1), O PROCESSO SERA REPETIDO PARA GARANTIR QUE HAJA 10 BOMBAS
			
			campo[linha][coluna].setBomba(true);
			
			
		}
	}
	
	
	public void imprimeTela(boolean teste) {
		for (int i = 0; i < campo.length; i++) {
			System.out.println();
			for (int j = 0; j < campo.length; j++) {
				if(teste==true) { //CASO PARA MOSTRAR O MAPA ABERTO
					if(campo[i][j].isBomba() == false)
						System.out.print(" " + campo[i][j].getQtdBombasVizinhas());
					else
						System.out.print("-1");
				}
				
				else { //CASO PARA MOSTRAR O MAPA SOMENTE COM AS CASAS VISÍVEIS
					if(campo[i][j].isBomba() == false && campo[i][j].isVisivel() == true)
						System.out.print(" " + campo[i][j].getQtdBombasVizinhas());
					else if (campo[i][j].isBomba() == true && campo[i][j].isVisivel() == true)
						System.out.print("-1");
					else if (campo[i][j].isVisivel() == false)
						System.out.print(" -");
				}
			} 
		}
	}
	
	public void contarBombas() {
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				if (campo[i][j].isBomba()==false) { // CASO ACHE UMA CELULA QUE NÃO SEJA BOMBA, ENTRE 
					for (int i2 = (i-1); i2 <= (i+1); i2++) { //LOOP PARA VARRER OS ARREDORES DA CASA A SER ANALISADA
						for (int j2 = (j-1); j2 <= (j+1); j2++) {
							if (i2>=0 && j2>=0 && i2<campo.length && j2<campo.length) { //IF PARA GARANTIR QUE AS CASAS ANALISADAS ESTÃO DENTRO DA MATRIZ
								if(campo[i2][j2].isBomba() == true) {
									campo[i][j].setQtdBombasVizinhas(campo[i][j].getQtdBombasVizinhas() + 1); //PARA CADA BOMBA ACHADA, SOMA 1 AO ATRIBUTO BOMBAS VIZINHAS DA CÉLULA (i,j)
								}
							}
							
						}
					}
				}
			}
		}
	}
	
	public void escolherPosicao(int linha, int coluna) {
		if(campo[linha][coluna].isBomba()==true) { //CASO A CASA ESCOLHIDA SEJA -1
			System.out.println();
			System.out.println("Fim de jogo! Você perdeu");
		}
		else if (campo[linha][coluna].isBomba()==false && campo[linha][coluna].getQtdBombasVizinhas()>0) { //CASO A CASA NÃO SEJA BOMBA E > 0
			campo[linha][coluna].setVisivel(true);
		}
		else if (campo[linha][coluna].isBomba()==false && campo[linha][coluna].getQtdBombasVizinhas()==0) { // CASO A CASA NÃO SEJA BOMBA E = 0
			checarZero(linha,coluna);  
		}
		imprimeTela(false);
		System.out.println();
		System.out.println();
	}
	
	public void checarZero(int linha, int coluna) { ////USA A RECURSIVIDADE PARA TORNAR VISÍVEL TODOS OS 0s E NÚMEROS INTEIROS ADJASCENTES A ELES
		campo[linha][coluna].setVisivel(true);
		for(int i=linha-1; i<=linha+1; i++) {
			for(int j= coluna-1; j<=coluna+1; j++) {
				if(i>=0 && j>=0 && i<campo.length && j<campo.length) {
					if(campo[i][j].isVisivel() == false && campo[i][j].getQtdBombasVizinhas() > 0) {
						campo[i][j].setVisivel(true);
					}
					else if(campo[i][j].isVisivel() == false && campo[i][j].getQtdBombasVizinhas() == 0) { 
						checarZero(i,j); //ESSA CHAMADA GARANTE A VARREDURA DE TODAS AS CASAS ADJASCENTES AOS 0s 
					}
				}
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


