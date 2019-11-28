package br.com.poli.campoMinado;

import java.util.*;

public class Jogador {
	
	//ATRIBUTOS
	
	private String nome;
	
	private int tempo;
	
	//CONSTRUTOR
	public Jogador() {
		
	}
	
	public Jogador (String nome) {
		this.nome = nome;
	}
	public Jogador(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
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
