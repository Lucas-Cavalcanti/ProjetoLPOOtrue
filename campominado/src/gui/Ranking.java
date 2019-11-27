package gui;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

import br.com.poli.campoMinado.*;
import br.com.poli.campoMinado.mapa.*;

import gui.*;

public class Ranking {
	
	
	
	public Ranking(Jogador jogador, Dificuldade difi) {
		
		
		try {
			
			FileWriter fac = new FileWriter("RankingFacil.txt", true);
			FileWriter med = new FileWriter("RankingMedio.txt", true);
			FileWriter dif = new FileWriter("RankingDificil.txt", true);
			
			jogador.getListaJogadores().add(jogador);
			
			if(jogador.getListaJogadores().size() > 1 ) {
				jogador.ordenarArrayList();
			}
			
			
			if (difi == Dificuldade.FACIL) {
				
				PrintWriter pr = new PrintWriter(fac);
			
				for (int i = 0; i < jogador.getListaJogadores().size(); i++) {
                    pr.println(jogador.getListaJogadores().get(i).getNome() + "  :  " + jogador.getListaJogadores().get(i).getTempo());
                    
                }
				
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
	
	public void ordenarArrayList() {
		
		
	}

}
