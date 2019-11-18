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
		setBounds(100, 100, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel.setBounds(100, 100, 750, 750);
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
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\lucas\\Downloads\\Botaosair.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(12, 13, 135, 60);
		contentPane.add(btnNewButton);
		//****************************************************************
		
		criarBotoes();
		
		}
	
	public void criarBotoes() {
		
		this.matrizBotao = new JButton[this.mapa.getDificuldade().getValor()][this.mapa.getDificuldade().getValor()];
		
		for (int i = 0; i < this.matrizBotao.length; i++) {
			for (int j = 0; j < this.matrizBotao.length; j++) {
				
				// ACTION LISTENER DA MATRIZ
				JButton but = new JButton();
				but.setBackground(Color.YELLOW);
				
				
				selecionarCelula(but,i,j);
				// ACTION LISTENER DA MATRIZ
				
				matrizBotao[i][j] = but;
				
				panel.add(but);
								
			}
			
		}
	}
	
	public void selecionarCelula(JButton botao,int linha,int coluna) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				getMapa().escolherPosicao(linha, coluna);
				
				for (int i2 = 0; i2 < getMatrizBotao().length; i2++) {
					for (int j2 = 0; j2 < getMatrizBotao().length; j2++) {
						if (getMapa().getCelula(linha, coluna).isEmBranco() && getMapa().getCelula(linha, coluna).isVisivel()) {
							botao.setBackground(Color.BLACK);
						}
						else if(getMapa().getCelula(linha, coluna).getQtdBombasVizinhas()>0 && getMapa().getCelula(linha, coluna).isVisivel()) {
							botao.setText( Integer.toString(getMapa().getCelula(linha, coluna).getQtdBombasVizinhas()));
							botao.setFont(new Font("Tahoma", Font.BOLD, 30));
						}
					}
				}
				
				
				
				for(int i = linha-1; i <= linha+1;i++) {
					for(int j = coluna-1; j<=coluna+1 ; j++) {
						
					}
				}
				
				
				
			}
			
		});
		
	}
	
	public Mapa getMapa() {
		return mapa;
	}
	
	public JButton[][] getMatrizBotao(){
		return matrizBotao;
	}
}



