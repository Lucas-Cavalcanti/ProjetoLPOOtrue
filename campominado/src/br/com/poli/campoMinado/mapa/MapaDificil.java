package br.com.poli.campoMinado.mapa;

import br.com.poli.campoMinado.Dificuldade;

public class MapaDificil extends Mapa {

	private static Dificuldade dificuldade = Dificuldade.DIFICIL;
	private static int bombas = 99;
	
	public MapaDificil() {
		super(dificuldade,bombas);
		
	}

}
