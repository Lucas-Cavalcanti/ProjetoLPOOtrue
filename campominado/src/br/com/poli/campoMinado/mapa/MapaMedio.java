package br.com.poli.campoMinado.mapa;

import br.com.poli.campoMinado.Dificuldade;

public class MapaMedio extends Mapa {

	private static final Dificuldade TAMANHO = Dificuldade.MEDIO;
	private static final int BOMBAS = 40;
	
	public MapaMedio() {
		super(TAMANHO,BOMBAS);
		
	}

}
