package br.com.poli.campoMinado.mapa;

import br.com.poli.campoMinado.Dificuldade;

public class MapaMedio extends Mapa {

	private static Dificuldade TAMANHO = Dificuldade.MEDIO;
	private static int BOMBAS = 40;
	
	public MapaMedio() {
		super(TAMANHO,BOMBAS);
		
	}

}
