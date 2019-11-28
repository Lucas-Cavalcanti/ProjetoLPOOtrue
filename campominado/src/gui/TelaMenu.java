package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.poli.campoMinado.Dificuldade;
import br.com.poli.campoMinado.Jogador;


public class TelaMenu extends JFrame {

	private JPanel contentPane;
	
	private TelaRanking telaRanking;
	
	protected TelaJogo tela;
	
	private JTextField text;
	
	private JLabel lblDigiteSeuNome;
	
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
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
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
		btnNewButton.setBounds(267, 300, 134, 63);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RANKING");
		
		gerarRanking(comboBox,btnNewButton_1);
		btnNewButton_1.setMargin(new Insets(0,0,0,0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(267, 400, 134, 63);
		contentPane.add(btnNewButton_1);
		
		
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
	
	public void gerarRanking(JComboBox cmb, JButton botao) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				switch(cmb.getSelectedIndex()) {
				
					case 0 : 
						telaRanking = new TelaRanking(Dificuldade.FACIL);
						telaRanking.setVisible(true);
						dispose();
						return;
					case 1 : 
						telaRanking = new TelaRanking(Dificuldade.MEDIO);
						telaRanking.setVisible(true);
						dispose();
						return;
						
					case 2 : 
						telaRanking = new TelaRanking(Dificuldade.DIFICIL);
						telaRanking.setVisible(true);
						dispose();
						return;
				}
			}
		});
	}
	
	
	public TelaJogo getTela() {
		return tela;
	}

	public JLabel getLblDigiteSeuNome() {
		return lblDigiteSeuNome;
	}

	public void setLblDigiteSeuNome(JLabel lblDigiteSeuNome) {
		this.lblDigiteSeuNome = lblDigiteSeuNome;
	}
	
	
}


