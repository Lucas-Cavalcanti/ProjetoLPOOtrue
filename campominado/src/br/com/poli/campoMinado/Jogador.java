package br.com.poli.campoMinado;

import java.util.*;

public class Jogador {
	
	//ATRIBUTOS
	
	private String nome;
	
	private int tempo;
	
	//CONSTRUTOR
	
	
	public Jogador(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
	}
	
	public Jogador(String nome) {
		this.nome = nome;
		
	}
	
	public Jogador() {
		
	}
	
	//M�TODOS
	
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
