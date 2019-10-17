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
			
		distribuirBombas(bombas);
		
		contarBombas();
		
		imprimeTela(true);
		
	}
	
	//M�TODOS
	
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
			//SE NA POSI��O SORTEADA J� HOUVER UM A BOMBA (-1), O PROCESSO SERA REPETIDO PARA GARANTIR QUE HAJA 10 BOMBAS
			
			campo[linha][coluna].setBomba(true);
			
			
		}
	}
	
	
	public void imprimeTela(boolean teste) {
		if(teste == true) {
			for (int i = 0; i < campo.length; i++) {
				System.out.println();
				System.out.println();
				for (int j = 0; j < campo.length; j++) {
					if(campo[i][j].isBomba() == false)
						System.out.print(" " + campo[i][j].getQtdBombasVizinhas());
					else
						System.out.print("-1");
					System.out.print("  ");
			
				} 
			}
		}
		
		else {
			for (int i = 0; i < campo.length; i++) {
				char var=20;
				System.out.println();
				System.out.println();
				for (int j = 0; j < campo.length; j++) {
					if(campo[i][j].isBomba() == false && campo[i][j].isVisivel() == true)
						System.out.print(" " + campo[i][j].getQtdBombasVizinhas());
					else if (campo[i][j].isBomba() == true && campo[i][j].isVisivel() == true)
						System.out.print("-1");
					else if (campo[i][j].isVisivel() == false)
						System.out.print(var);
						
					System.out.print("  ");
			
				} 
			}
		}
	}
	
	public void contarBombas() {
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				if (campo[i][j].isBomba()==false) {
					for (int i2 = (i-1); i2 <= (i+1); i2++) {
						for (int j2 = (j-1); j2 <= (j+1); j2++) {
							if (i2>=0 && j2>=0 && i2<campo.length && j2<campo.length) {
								if(campo[i2][j2].isBomba() == true) {
									campo[i][j].setQtdBombasVizinhas(campo[i][j].getQtdBombasVizinhas() + 1);
								}
							}
							
						}
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


