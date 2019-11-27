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

	private List<Jogador> listaJogadores = new ArrayList<Jogador>();

	private FileWriter fileF;

	private File file;

	private FileReader ler1;

	private int tamanho;
	
	private RankingOrdenado ro; 

	public Ranking() {

		try {
			
			ro = new RankingOrdenado(Dificuldade.FACIL);
			
			ro.tamanhoArquivo();
			
			for(Jogador i: ro.registrarJogadores()) {
				listaJogadores.add(i);
			}

			listaJogadores.add(new Jogador("lucas"));

			fileF = new FileWriter("RankingFacil.txt", true);

			PrintWriter pr = new PrintWriter(fileF);

			for (int i = 0; i < listaJogadores.size(); i++) {
				pr.println(listaJogadores.get(i).getNome() + "\n" + listaJogadores.get(i).getTempo());

			}

			fileF.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Ranking(Jogador jogador, Dificuldade difi) {

		try {

			listaJogadores.add(new Jogador("lucas"));

			if (difi == Dificuldade.FACIL) {

				fileF = new FileWriter("RankingFacil.txt", true);

				PrintWriter pr = new PrintWriter(fileF);

				for (int i = 0; i < listaJogadores.size(); i++) {
					pr.println(listaJogadores.get(i).getNome() + "\n" + listaJogadores.get(i).getTempo());

				}

				fileF.close();

			}

			else if (difi == Dificuldade.MEDIO) {

				fileF = new FileWriter("RankingMedio.txt", true);

				PrintWriter pr = new PrintWriter(fileF);

				pr.close();

			}

			else if (difi == Dificuldade.DIFICIL) {

				fileF = new FileWriter("RankingDificil.txt", true);

				PrintWriter pr = new PrintWriter(fileF);

				pr.close();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ordenarArrayList() {
		Collections.sort(listaJogadores, new Comparator<Jogador>() {
			@Override
			public int compare(Jogador j1, Jogador j2) {
				return Integer.valueOf(j1.getTempo()).compareTo(j2.getTempo());
			}
		});
	}

}
