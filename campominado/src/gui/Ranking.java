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
			
			if (difi == Dificuldade.FACIL) {
				
				FileWriter fr = new FileWriter("RankingFacil.txt");
				PrintWriter pr = new PrintWriter(fr);
				
				pr.write(jogador.getNome() + "  :  " + jogador.getTempo());
				
				pr.close();
				
			}
			
			else if (difi == Dificuldade.MEDIO) {
				
				FileWriter fr = new FileWriter("RankingMedio.txt");
				PrintWriter pr = new PrintWriter(fr);
				
				pr.write(jogador.getNome() + "  :  " + jogador.getTempo());
				
				pr.close();
				
			}
			
			else if (difi == Dificuldade.DIFICIL) {
				
				FileWriter fr = new FileWriter("RankingDificil.txt");
				PrintWriter pr = new PrintWriter(fr);
				
				pr.write(jogador.getNome() + "  :  " + jogador.getTempo());
				
				pr.close();
				
			}
			
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
