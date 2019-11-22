package br.com.poli.campoMinado;

public class Jogador {
	
	//ATRIBUTOS
	
	private String nome;
	
	private int tempo;
	
	//CONSTRUTOR
	
	public Jogador(String nome) {
		this.nome = nome;
	}
	
	//MÉTODOS

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	

}
