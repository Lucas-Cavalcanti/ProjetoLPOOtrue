package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poli.campoMinado.Dificuldade;
import br.com.poli.campoMinado.Jogador;

import javax.swing.JLabel;
import java.awt.Font;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

import br.com.poli.campoMinado.*;
import br.com.poli.campoMinado.mapa.*;


public class TelaRanking extends JFrame {

	private JPanel contentPane;
	
	private JLabel[] jl;
	
	private Ranking ranking;
	
	
	public TelaRanking(Dificuldade dificuldade) {
		
		this.ranking = new Ranking(false,dificuldade);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblRanking = new JLabel("Ranking");
		lblRanking.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblRanking.setBounds(27, 11, 350, 101);
		contentPane.add(lblRanking);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(27, 188, 619, 101);
		contentPane.add(lblNewLabel);
		
		
		
		criarLabels();
		
	}
	
	public void criarLabels() {
		jl = new JLabel[this.ranking.getListaJogNova().size()];
		for (int i = 0; i < ranking.getListaJogNova().size(); i++) {
			if( i<5 ) {
				jl[i] = new JLabel(Integer.toString(i+1) + ") Nome :" + ranking.getListaJogNova().get(i).getNome() + "   Tempo : " + Integer.toString(ranking.getListaJogNova().get(i).getTempo()) + " Segundos  ");
				jl[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
				jl[i].setBounds(27, (180 + (50*i+1)), 700, 100);
				contentPane.add(jl[i]);
			}
			
		}
	}

}
