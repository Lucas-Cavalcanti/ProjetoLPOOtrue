package gui;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

import br.com.poli.campoMinado.*;
import br.com.poli.campoMinado.mapa.*;

import gui.*;

public class RankingOrdenado {
	
	private List<Jogador> listaJogadoresOrdenada = new ArrayList<Jogador>();
	
	private int contador = 0;
	
	private int cont2 = 0;
	
	private File file;
	
	private FileReader ler1;
	
	private LineNumberReader linhas;
	
	private int tamanho;
	
	private FileReader file3;
	
	private BufferedReader bfac;
	
	public RankingOrdenado(Dificuldade difi) {
		try {
			
			
			tamanhoArquivo();
			//registrarJogadores();
			
			if(difi == Dificuldade.FACIL) {
				file3 = new FileReader("RankingFacil.txt");
				
				bfac =new BufferedReader(file3);
				
				
				//file3.close();
			}
			
			else if(difi == Dificuldade.MEDIO) {
				
				file3 = new FileReader("RankingMedio.txt");
				
				bfac =new BufferedReader(file3);
				
				file3.close();
			}
			else {
				file3 = new FileReader("RankingFacil.txt");
				
				bfac = new BufferedReader(file3);
				
				file3.close();
			}
			
		}
		 catch(IOException e) {
				e.printStackTrace();
			}
		
	}
	
	public Jogador[] registrarJogadores() {
		
		tamanhoArquivo();
		Jogador[] arrayj = new Jogador[(tamanho)/2];
		String linha = "";
		
		for(int i = 0; i < arrayj.length; i++) {
			arrayj[i] = new Jogador();
		}
		
		try {
		
			do {
				
				linha = bfac.readLine();
				
				
				if(contador % 2 == 0) {
					
					arrayj[cont2].setNome(linha);
					
				} else {
					arrayj[cont2].setTempo(Integer.parseInt(linha));
				}
				
				contador++;
				if(contador % 2 == 0) {
					cont2++;
				}
				
			}while(linha != null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return	arrayj;
		
	}
	
public void tamanhoArquivo() {
		
		try {
			ler1 = new FileReader("RankingFacil.txt");
			linhas = new LineNumberReader(ler1);
			linhas.skip("RankingFacil.txt".length());
			this.tamanho = linhas.getLineNumber();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void ordenarArrayList() {
		Collections.sort(listaJogadoresOrdenada, new Comparator<Jogador>() {
			@Override
			public int compare(Jogador j1, Jogador j2) {
				return Integer.valueOf(j1.getTempo()).compareTo(j2.getTempo());
			}
		});
	}
	
}
