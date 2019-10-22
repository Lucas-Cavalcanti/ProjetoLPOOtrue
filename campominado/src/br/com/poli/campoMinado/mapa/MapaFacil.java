package br.com.poli.campoMinado.mapa;

import br.com.poli.campoMinado.Dificuldade;

public class MapaFacil extends Mapa {
	
	private static Dificuldade TAMANHO = Dificuldade.FACIL;
	private static int BOMBAS = 10;
	
	public MapaFacil() {
		super(TAMANHO,BOMBAS);	
	}
	
	
}
