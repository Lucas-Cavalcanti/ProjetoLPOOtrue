package gui;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

import br.com.poli.campoMinado.*;
import br.com.poli.campoMinado.mapa.*;



public class Ranking {

	private List<Jogador> listaJogadores = new ArrayList<Jogador>();
	
	private List<Jogador> listaJogNova = new ArrayList<Jogador>();

	private File file;
	
	private FileWriter fileF;
	
	private FileReader fileR2;
	
	private PrintWriter pr;
	
	private LineNumberReader linhas;

	private FileReader fileR;
	
	private BufferedReader bfac;	
	
	private Jogador jogador;
	
	private int tamanho;
	
	private int contador = 0;
	
	private int contador2 = 0;
	
	private Dificuldade dificuldade;
	
	private Jogador[] arrayj;
	
	private boolean flag;
	
	public Ranking(boolean flag, Dificuldade dificuldade) {
		this.flag = flag;
		this.dificuldade = dificuldade;
		
		adicionarJogadorNoRanking();
		
		lerArquivo();
		
		ordenarArrayList();
		
		for (int i = 0; i < listaJogNova.size(); i++) {
			System.out.println(listaJogNova.get(i).getNome() + " : " + listaJogNova.get(i).getTempo());
		}
	}
	
	public Ranking(Jogador jogador, Dificuldade dificuldade) {
		this.jogador = jogador;
		this.dificuldade = dificuldade;
		
		adicionarJogadorNoRanking();
		
		lerArquivo();
		
		ordenarArrayList();
		
		for (int i = 0; i < listaJogNova.size(); i++) {
			System.out.println(listaJogNova.get(i).getNome() + " : " + listaJogNova.get(i).getTempo());
		}
	}
	
	public void adicionarJogadorNoRanking() {
		try {
			
			if(flag == true) {
				listaJogadores.add(jogador);
			}
			

			if (dificuldade == Dificuldade.FACIL) {
				file = new File("RankingFacil.txt");
				
				file.createNewFile();
				
				fileR = new FileReader(file);
				
				fileR2 =new FileReader(file);
				
				fileF = new FileWriter(file.getAbsoluteFile(), true);
				
				pr = new PrintWriter(fileF);

				for (int i = 0; i < listaJogadores.size(); i++) {
					pr.println(listaJogadores.get(i).getNome() + "\n" + listaJogadores.get(i).getTempo());
				}
				
				fileF.close();

			}

			else if (dificuldade == Dificuldade.MEDIO) {
				file = new File("RankingMedio.txt");
				
				fileR = new FileReader(file);
				
				fileR2 =new FileReader(file);
				
				fileF = new FileWriter(file.getAbsoluteFile(), true);
				
				pr = new PrintWriter(fileF);

				for (int i = 0; i < listaJogadores.size(); i++) {
					pr.println(listaJogadores.get(i).getNome() + "\n" + listaJogadores.get(i).getTempo());
				}
				
				fileF.close();
			}

			else if (dificuldade == Dificuldade.DIFICIL) {
				file = new File("RankingDificil.txt");
				
				file.createNewFile();
				
				fileR = new FileReader(file);
				
				fileR2 =new FileReader(file);
				
				fileF = new FileWriter(file.getAbsoluteFile(), true);
				
				pr = new PrintWriter(fileF);

				for (int i = 0; i < listaJogadores.size(); i++) {
					pr.println(listaJogadores.get(i).getNome() + "\n" + listaJogadores.get(i).getTempo());
				}
				fileF.close();
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void lerArquivo() {
		
		medirTamanhoArquivo();
		arrayj = new Jogador[(this.tamanho)/2];
		String linha;
		
		bfac = new BufferedReader(fileR2);
		
		for(int i = 0; i < arrayj.length; i++) {
			arrayj[i] = new Jogador();
		}
		
		try {
			do {
				linha = this.bfac.readLine();
				
				if (contador2 < arrayj.length) {
					if(contador % 2 == 0) {
						arrayj[contador2].setNome(linha);
					}
					else if(contador % 2 != 0) {
						arrayj[contador2].setTempo(Integer.parseInt(linha));
						this.contador2++;
					}
					
					this.contador++;
				}
				
				
				
			}while(linha != null);
			
			for (int i = 0; i < arrayj.length; i++) {
				this.listaJogNova.add(arrayj[i]);
			}
			
		}
		 catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void medirTamanhoArquivo() {
		try {
			linhas = new LineNumberReader(fileR);
			linhas.skip(file.length());
			this.tamanho = linhas.getLineNumber();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

	public void ordenarArrayList() {
		Collections.sort(listaJogNova, new Comparator<Jogador>() {
			@Override
			public int compare(Jogador j1, Jogador j2) {
				return Integer.valueOf(j1.getTempo()).compareTo(j2.getTempo());
			}
		});
	}

	public List<Jogador> getListaJogNova() {
		return listaJogNova;
	}

	public void setListaJogNova(List<Jogador> listaJogNova) {
		this.listaJogNova = listaJogNova;
	}

	
	
}
