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
import javax.swing.JTextField;


public class TelaMenu extends JFrame {

	private JPanel contentPane;
	
	private Jogador jogador;
	
	protected TelaJogo tela;
	
	private JTextField text;
	
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
//		chamaJanelaAbertura();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		text = new JTextField();
		
		text.setBounds(267,338,134,63);
		text.setColumns(10);
		contentPane.add(text);
		
		jogador = new Jogador(text.getText());
		
		System.out.print(jogador.getNome());

		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"F\u00E1cil", "M\u00E9dio", "Dif\u00EDcil"}));
		comboBox.setBounds(247, 179, 168, 84);
		contentPane.add(comboBox);
		
		
		JLabel lblCampoMinado = new JLabel("Campo Minado");
		lblCampoMinado.setFont(new Font("Tahoma", Font.ITALIC, 36));
		lblCampoMinado.setBounds(213, 13, 350, 175);
		contentPane.add(lblCampoMinado);
		
		JButton btnNewButton = new JButton("JOGAR");
		
		gerarMapas(comboBox,btnNewButton);
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(267, 423, 134, 63);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RANKING");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(267, 529, 134, 63);
		contentPane.add(btnNewButton_1);
		
		
		JLabel lblDigiteSeuNome = new JLabel("Digite seu nome");
		lblDigiteSeuNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDigiteSeuNome.setBounds(267, 301, 134, 31);
		contentPane.add(lblDigiteSeuNome);
		
	}
	
	public void gerarMapas(JComboBox cmb, JButton botao) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				switch(cmb.getSelectedIndex()) {
				
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
	}
	
	public static void chamaJanelaAbertura() {
		SplashScreen ja = new SplashScreen();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		ja.setVisible(false);
	}

	public TelaJogo getTela() {
		return tela;
	}
}


