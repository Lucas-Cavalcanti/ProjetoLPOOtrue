package gui;

import java.awt.BorderLayout;
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
	
	
	public TelaRanking(Dificuldade dificuldade) {
		@SuppressWarnings("unused")
		Ranking ranking = new Ranking(false,dificuldade);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRanking = new JLabel("Ranking");
		lblRanking.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel.add(lblRanking, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		
		lblNewLabel.setText("1) Nome :" + ranking.getListaJogNova().get(0).getNome() + "   Tempo : " + Integer.toString(ranking.getListaJogNova().get(0).getTempo()) + " Segundos  "
						 	+ "2) Nome :" + ranking.getListaJogNova().get(1).getNome() + "   Tempo : " + Integer.toString(ranking.getListaJogNova().get(1).getTempo()) + " Segundos  \n"
						 	+ "3) Nome :" + ranking.getListaJogNova().get(2).getNome() + "   Tempo : " + Integer.toString(ranking.getListaJogNova().get(2).getTempo()) + " Segundos  \n"
						 	+ "4) Nome :" + ranking.getListaJogNova().get(3).getNome() + "   Tempo : " + Integer.toString(ranking.getListaJogNova().get(3).getTempo()) + " Segundos  \n"
						 	+ "5) Nome :" + ranking.getListaJogNova().get(4).getNome() + "   Tempo : " + Integer.toString(ranking.getListaJogNova().get(4).getTempo()) + " Segundos\n");
		
		
		
	}

}
