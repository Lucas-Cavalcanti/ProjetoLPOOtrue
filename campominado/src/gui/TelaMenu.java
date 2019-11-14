package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import br.com.poli.campoMinado.*;
import br.com.poli.campoMinado.mapa.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaMenu extends JFrame {

	private JPanel contentPane;
	
	private TelaJogo tela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"F\u00E1cil", "M\u00E9dio", "Dif\u00EDcil"}));
		comboBox.setBounds(280, 174, 83, 63);
		contentPane.add(comboBox);
		
		
		JLabel lblCampoMinado = new JLabel("Campo Minado");
		lblCampoMinado.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblCampoMinado.setBounds(213, 13, 198, 83);
		contentPane.add(lblCampoMinado);
		
		JButton btnNewButton = new JButton("JOGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				switch(comboBox.getSelectedIndex()) {
				
					case 0 : 
						tela = new TelaJogo(Dificuldade.FACIL);
						tela.setVisible(true);
						dispose();
						break;
						
					case 1 : 
						tela = new TelaJogo(Dificuldade.MEDIO);
						tela.setVisible(true);
						dispose();
						break;
						
					case 2 : 
						tela = new TelaJogo(Dificuldade.DIFICIL);
						tela.setVisible(true);
						dispose();
						break;
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(259, 319, 128, 50);
		contentPane.add(btnNewButton);
		
		
		
			
	}

}