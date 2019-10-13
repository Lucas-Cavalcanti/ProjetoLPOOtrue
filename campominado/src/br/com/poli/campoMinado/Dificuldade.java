package br.com.poli.campoMinado;

public enum Dificuldade {
	
	//ENUM
	
	FACIL(9),MEDIO(16),DIFICIL(32);
	
	//ATRIBUTO
	
	private int valor;
	
	//CONSTRUTOR
	
	Dificuldade(int valor){
		this.valor = valor;
	}
	
	//MÉTODOS
	
	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
}
