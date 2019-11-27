package gui;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import br.com.poli.campoMinado.*;
import br.com.poli.campoMinado.mapa.*;

import gui.*;

public class Ranking {
	
	private List<Jogador> listaJogadores = new ArrayList<Jogador>();
	
	public Ranking(Jogador jogador, Dificuldade difi) {
		
		try {
			
			listaJogadores.add(jogador);
			
			FileWriter fac = new FileWriter("RankingFacil.txt", true);
			FileWriter med = new FileWriter("RankingMedio.txt", true);
			FileWriter dif = new FileWriter("RankingDificil.txt", true);

			
			
			if (difi == Dificuldade.FACIL) {
				
				PrintWriter pr = new PrintWriter(fac);
				
				pr.write("\n" + jogador.getNome() + "  :  " + jogador.getTempo());
				
				pr.close();
				
			}
			
			else if (difi == Dificuldade.MEDIO) {
				
				PrintWriter pr = new PrintWriter(med);
				
				pr.write(jogador.getNome() + "  :  " + jogador.getTempo());
				
				pr.close();
				
			}
			
			else if (difi == Dificuldade.DIFICIL) {

				PrintWriter pr = new PrintWriter(dif);
				
				pr.write(jogador.getNome() + "  :  " + jogador.getTempo());
				
				pr.close();
				
			}
			
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
