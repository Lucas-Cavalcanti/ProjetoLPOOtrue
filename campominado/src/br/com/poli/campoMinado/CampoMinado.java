package br.com.poli.campoMinado;

import br.com.poli.campoMinado.mapa.*;

import java.util.Scanner;

public class CampoMinado {
	
	//ATRIBUTOS
	
	private Mapa mapa;
	
	private Jogador jogador;
	
	private Dificuldade dificuldade;
	
	//CONSTRUTOR
	
	public CampoMinado(Dificuldade dificuldade , String jogador){
		this.dificuldade = dificuldade;
		
		this.jogador = new Jogador(jogador);
		
		if(dificuldade == Dificuldade.FACIL) { //USANDO UM CONSTRUTOR DIFERENTE PARA CADA DIFICULDADE
			this.mapa = new MapaFacil();
		}
		else if (dificuldade == Dificuldade.MEDIO) {
			this.mapa = new MapaMedio();
		}
		else {
			this.mapa = new MapaDificil();
		}
		
	}

	public void iniciarJogo() {
		Scanner sc = new Scanner(System.in);
		int linha,coluna;
		mapa.imprimeTela(false);
		System.out.println();
		System.out.println();
		do {
			System.out.print("Insira a linha: ");
			linha = sc.nextInt();
			while(linha<0 || linha>mapa.getCampo().length-1) {
				System.out.println("Valor invalido, insira a linha corretamente: ");
				linha = sc.nextInt();
			}
			System.out.print("Insira a coluna: ");
			coluna = sc.nextInt();
			while(coluna<0 || coluna>mapa.getCampo().length-1) {
				System.out.println("Valor invalido, insira a coluna corretamente: ");
				coluna = sc.nextInt();
			}
			mapa.escolherPosicao(linha, coluna);
		} while(mapa.isFimDeJogo() == false && mapa.isGanhouJogo()==false);
	}
	
	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}
	
	
}
