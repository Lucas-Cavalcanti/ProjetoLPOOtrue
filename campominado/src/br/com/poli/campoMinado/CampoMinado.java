package br.com.poli.campoMinado;

public class CampoMinado {
	
	//ATRIBUTOS
	
	private Mapa mapa;
	
	private Jogador jogador;
	
	private Dificuldade dificuldade;
	
	//CONSTRUTOR
	
	public CampoMinado(Dificuldade dificuldade , String jogador){
		this.dificuldade = dificuldade;
		
		this.mapa = new Mapa(this.dificuldade);
		
		this.jogador = new Jogador(jogador);
		
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
