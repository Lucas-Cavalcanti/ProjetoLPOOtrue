package gui;

import java.awt.BorderLayout;
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

public class TelaJogo extends JFrame {

	private JPanel contentPane;
	
	private Botao matrizBotao[][];
	
	private Mapa mapa;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	
	JPanel panel = new JPanel();
	
	public TelaJogo(Dificuldade dificuldade) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel.setBounds(100, 100, 600, 600);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(9,9));
		
		
		if (dificuldade == Dificuldade.FACIL) {
			mapa = new MapaFacil();
		}
		else if(dificuldade == Dificuldade.MEDIO) {
			mapa = new MapaMedio();
		}
		else if (dificuldade == Dificuldade.DIFICIL) {
			mapa = new MapaDificil();
		}
		mapa.setDificuldade(dificuldade);
		criarBotoes();
		
		}
	
	public void criarBotoes() {
		
		this.matrizBotao = new Botao[this.mapa.getDificuldade().getValor()][this.mapa.getDificuldade().getValor()];
		
		for (int i = 0; i < this.matrizBotao.length; i++) {
			for (int j = 0; j < this.matrizBotao.length; j++) {
				
				matrizBotao[i][j] = new Botao(); 
				panel.add(matrizBotao[i][j]);
				(matrizBotao[i][j].getBotao()).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						matrizBotao[i][j].setNumDica( mapa.getCelula(i, j).getQtdBombasVizinhas());
						
						
						
						
						
					}
				});
				
				
			}
			
		}
	}
	
	
}
