package br.com.poli.campoMinado;

public class CampoMinado {
	
	//ATRIBUTOS
	
	private Mapa mapa;
	
	private Jogador jogador;
	
	private Dificuldade dificuldade;
	
	//CONSTRUTOR
	
	public CampoMinado(Dificuldade dif , String jogador){
		this.dificuldade = dif;
		
		this.mapa = new Mapa(this.dificuldade);
		
		this.jogador = new Jogador(jogador);
		
	}
	
	public Jogador getJogador() {
		
		return this.jogador;
	}
	
	

}
