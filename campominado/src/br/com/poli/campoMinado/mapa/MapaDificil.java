package br.com.poli.campoMinado.mapa;

import br.com.poli.campoMinado.Dificuldade;

public class MapaDificil extends Mapa {

	private static Dificuldade TAMANHO = Dificuldade.DIFICIL;
	private static int BOMBAS = 99;
	
	public MapaDificil() {
		super(TAMANHO,BOMBAS);
		
	}

}
