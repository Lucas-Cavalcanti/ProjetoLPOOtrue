package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;

import br.com.poli.campoMinado.*;
import br.com.poli.campoMinado.mapa.*;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.util.*;

public class TelaJogo extends JFrame {

	private JPanel contentPane;
	
	private JButton matrizBotao[][];
	
	private Mapa mapa;

	/**
	 * Create the frame.
	 */
	
	JPanel panel = new JPanel();
	
	public TelaJogo(Dificuldade dificuldade) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 1100);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel.setBounds(12, 75, 500, 500);
		contentPane.add(panel);
		
		
		if (dificuldade == Dificuldade.FACIL) {
			mapa = new MapaFacil();
		}
		else if(dificuldade == Dificuldade.MEDIO) {
			mapa = new MapaMedio();
		}
		else if (dificuldade == Dificuldade.DIFICIL) {
			mapa = new MapaDificil();
		}
		
		panel.setLayout(new GridLayout(this.mapa.getDificuldade().getValor(),this.mapa.getDificuldade().getValor()));
		
		//*****************************************************************
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		btnNewButton.setIcon(new ImageIcon(".\\images\\Botaosair.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(12, 13, 215, 44);
		contentPane.add(btnNewButton);
		//****************************************************************
		
		criarBotoes();
		
		}
	
	public void criarBotoes() {
		
		this.matrizBotao = new JButton[this.mapa.getDificuldade().getValor()][this.mapa.getDificuldade().getValor()];
		
		for (int i = 0; i < this.matrizBotao.length; i++) {
			for (int j = 0; j < this.matrizBotao.length; j++) {
				
				// ACTION LISTENER DA MATRIZ
				matrizBotao[i][j] = new JButton();
				matrizBotao[i][j].setBackground(Color.YELLOW);
				
				
				escolherPosicaoInterface(i,j);
				// ACTION LISTENER DA MATRIZ
				
				
				panel.add(matrizBotao[i][j]);
				
			}
			
		}
	}
	
	public void escolherPosicaoInterface(int i,int j) {
		matrizBotao[i][j].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				getMapa().escolherPosicao(i, j);	
				
				revelarEspacosInterface();
				
				if (getMapa().getCelula(i, j).isEmBranco() && getMapa().getCelula(i, j).isVisivel()) {
					matrizBotao[i][j].setBackground(Color.BLACK);
					
				}
				else if(getMapa().getCelula(i, j).getQtdBombasVizinhas()>0 && getMapa().getCelula(i, j).isVisivel()) {
					matrizBotao[i][j].setText(Integer.toString(getMapa().getCelula(i, j).getQtdBombasVizinhas()));
					
				}
				
				else {
					matrizBotao[i][j].setText("B");
					matrizBotao[i][j].setBackground(Color.RED);
					
					TelaLoser loser = new TelaLoser();
					
					loser.setVisible(true);
					
				}
				
				ajustarLetra(i,j);
				
				if(getMapa().verificarGanhouJogo() == true) {
					TelaVencedor winner = new TelaVencedor();
					
					winner.setVisible(true);
				

				}
			}
			
		});
		
	}
	
	public void revelarEspacosInterface() {
		
		for (int i = 0; i < matrizBotao.length; i++) {
			for (int j = 0; j < matrizBotao.length; j++) {
				
				if(getMapa().getCelula(i, j).isEmBranco() && getMapa().getCelula(i, j).isVisivel() ) {
					matrizBotao[i][j].setBackground(Color.BLACK);
				}
				else if(getMapa().getCelula(i, j).getQtdBombasVizinhas() > 0 && getMapa().getCelula(i, j).isVisivel()) {
					matrizBotao[i][j].setText( Integer.toString(getMapa().getCelula(i, j).getQtdBombasVizinhas()));
				}
				else if(getMapa().getCelula(i, j).getQtdBombasVizinhas() < 0 && getMapa().getCelula(i, j).isVisivel()) {
					matrizBotao[i][j].setText("B");				
				}
				
				ajustarLetra(i,j);
				
			}
		}
		
	}
	
	
	public void ajustarLetra(int i, int j) {
		if(this.mapa.getDificuldade() == Dificuldade.FACIL) {
			matrizBotao[i][j].setFont(new Font("Tahoma", Font.BOLD, 30));
		}
		else if(this.mapa.getDificuldade() == Dificuldade.MEDIO) {
			matrizBotao[i][j].setFont(new Font("Tahoma", Font.BOLD, 20));
		}
		else {
			matrizBotao[i][j].setFont(new Font("Tahoma", Font.BOLD, 3));
		}
	}
	
	
	public Mapa getMapa() {
		return mapa;
	}
	
	public JButton[][] getMatrizBotao(){
		return matrizBotao;
	}
}



