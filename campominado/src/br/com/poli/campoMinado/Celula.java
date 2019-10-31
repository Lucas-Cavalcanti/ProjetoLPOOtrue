package br.com.poli.campoMinado;
import java.util.*; 

public class Celula {
	
	//ATRIVUTOS
	
	private boolean bandeira;
	private boolean bomba;
	private int qtdBombasVizinhas;
	private boolean visivel;
	private int linha; //inicializado pelo construtor
	private int coluna; //inicializado pelo construtor
	private List<Celula> vizinhos = new ArrayList<Celula>();
	
	//CONSTRUTOR
	
	public Celula(int linha, int coluna) {
		this.linha=linha;
		this.coluna=coluna;
	}
	
	//MÉTODOS
	
	public void buscarVizinhos(Celula[][] campo) {
		for(int i = linha-1; i <= linha+1; i++) {
			for(int j = coluna-1; j <= coluna+1; j++) {
				if(i>=0 && j>=0 && i<campo.length && j<campo.length) {
					vizinhos.add(campo[i][j]);
				}
			}
		}
	}
	
	public boolean isEmBranco() {
		if(this.qtdBombasVizinhas == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isBandeira() {
		return bandeira;
	}
	public void setBandeira(boolean bandeira) {
		this.bandeira = bandeira;
	}
	public boolean isBomba() {
		return bomba;
	}
	public void setBomba(boolean bomba) {
		this.bomba = bomba;
	}
	public int getQtdBombasVizinhas() {
		return qtdBombasVizinhas;
	}
	public void setQtdBombasVizinhas(int qtdBombasVizinhas) {
		this.qtdBombasVizinhas = qtdBombasVizinhas;
	}
	public boolean isVisivel() {
		return visivel;
	}
	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}
	
}
