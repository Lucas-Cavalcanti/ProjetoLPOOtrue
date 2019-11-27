package br.com.poli.campoMinado;

import java.util.*;

public class Jogador {
	
	//ATRIBUTOS
	
	private String nome;
	
	private int tempo;
	
	private List<Jogador> listaJogadores = new ArrayList<Jogador>();
	
	//CONSTRUTOR
	
	
	public Jogador(String nome) {
		this.nome = nome;
	}
	
	//MÉTODOS
	
	public void ordenarArrayList() {
		Collections.sort(listaJogadores, new Comparator<Jogador>() {
			@Override
			public int compare(Jogador j1, Jogador j2) {
				return Integer.valueOf(j1.tempo).compareTo(j2.tempo);
			}
		});
	}
	
	
	public List<Jogador> getListaJogadores() {
		return listaJogadores;
	}
	
	public void setListaJogadores(List<Jogador> listaJogadores) {
		this.listaJogadores = listaJogadores;
	}
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
