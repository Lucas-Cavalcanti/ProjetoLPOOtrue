package br.com.poli.campoMinado.mapa;

import br.com.poli.campoMinado.Dificuldade;

public class MapaMedio extends Mapa {

	private static Dificuldade dificuldade = Dificuldade.MEDIO;
	private static int bombas = 40;
	
	public MapaMedio() {
		super(dificuldade,bombas);
		
	}

}
