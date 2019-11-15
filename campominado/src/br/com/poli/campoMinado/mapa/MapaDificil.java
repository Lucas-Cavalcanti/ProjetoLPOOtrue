package br.com.poli.campoMinado.mapa;

import br.com.poli.campoMinado.Dificuldade;

public class MapaDificil extends Mapa {

	private static final Dificuldade TAMANHO = Dificuldade.DIFICIL;
	private static final int BOMBAS = 99;
	
	public MapaDificil() {
		super(TAMANHO,BOMBAS);
		
	}

}
