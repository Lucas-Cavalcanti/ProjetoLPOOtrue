package br.com.poli.campoMinado;

public class CampoMinado {
	
	//ATRIBUTOS
	
	private Mapa mapa;
	
	private Jogador jogador;
	
	private Dificuldade dificuldade;
	
	//CONSTRUTOR
	
	public CampoMinado(Dificuldade difi , String jogador){
		this.dificuldade = difi;
		
		this.mapa = new Mapa(this.dificuldade);
		
		this.jogador = new Jogador(jogador);
		
	}
	
	public Jogador getJogador() {
		
		return this.jogador;
	}
	
	

}
