package br.com.poli.campoMinado.mapa;

import br.com.poli.campoMinado.Dificuldade;

public class MapaFacil extends Mapa {
	
	private static Dificuldade dificuldade = Dificuldade.FACIL;
	private static int bombas = 10;
	
	public MapaFacil() {
		super(dificuldade,bombas);	
	}
	
	
}
