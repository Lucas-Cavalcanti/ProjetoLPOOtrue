package gui;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import br.com.poli.campoMinado.*;
import br.com.poli.campoMinado.mapa.*;

import gui.*;

public class Ranking {
	private List<Jogador> listaJogadores = new ArrayList<Jogador>();
	
	public Ranking() {
		try {
			FileWriter fr = new FileWriter("teste.txt");
			PrintWriter pr = new PrintWriter(fr);
			
			
			pr.write("dale");
			
			pr.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
