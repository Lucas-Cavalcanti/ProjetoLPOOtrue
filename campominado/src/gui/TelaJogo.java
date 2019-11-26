package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import br.com.poli.campoMinado.Dificuldade;
import br.com.poli.campoMinado.Jogador;
import br.com.poli.campoMinado.mapa.Mapa;
import br.com.poli.campoMinado.mapa.MapaDificil;
import br.com.poli.campoMinado.mapa.MapaFacil;
import br.com.poli.campoMinado.mapa.MapaMedio;

public class TelaJogo extends JFrame {

	private JPanel contentPane;
	
	private Ranking ranking;

	private JButton matrizBotao[][];

	private Mapa mapa;

	private JLabel lblTempo;

	private JLabel contagemTempo;

	private Timer timer;
	
	private Jogador jogador;

	private int count = 0;
	

	JPanel panel = new JPanel();

	public TelaJogo(Dificuldade dificuldade, String nome) {

		setBounds(280, 0, 800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel.setBounds(10, 75, 600, 600);
		contentPane.add(panel);
		
		if (dificuldade == Dificuldade.FACIL) {
			mapa = new MapaFacil();
		} else if (dificuldade == Dificuldade.MEDIO) {
			mapa = new MapaMedio();
		} else if (dificuldade == Dificuldade.DIFICIL) {
			mapa = new MapaDificil();
		}
		
		jogador = new Jogador(nome);
		
		System.out.println(jogador.getNome());

		panel.setLayout(new GridLayout(this.mapa.getDificuldade().getValor(), this.mapa.getDificuldade().getValor()));
		
		// *****************************************************************

		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);
			}
		});
		btnNewButton.setIcon(new ImageIcon(".\\images\\Botaosair.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(12, 13, 170, 44);
		contentPane.add(btnNewButton);

		this.lblTempo = new JLabel("Bombas: " + (Integer.toString(mapa.getBombas())));
		lblTempo.setFont(new Font("LCDMono2", Font.BOLD, 18));
		lblTempo.setBounds(389, 12, 121, 44);
		contentPane.add(lblTempo);

		fazerCronometro();

		contagemTempo.setText("Tempo: 00:00:00");
		contagemTempo.setFont(new Font("LCDMono2", Font.BOLD, 18));
		contagemTempo.setBounds(220, 11, 159, 44);
		contentPane.add(contagemTempo);
		
		
		// ****************************************************************

		criarBotoes();
		
		
	}

	public void criarBotoes() {

        this.matrizBotao = new JButton[this.mapa.getDificuldade().getValor()][this.mapa.getDificuldade().getValor()];

        for (int i = 0; i < this.matrizBotao.length; i++) {
            for (int j = 0; j < this.matrizBotao.length; j++) {

         
            	
                matrizBotao[i][j] = new JButton();
                matrizBotao[i][j].setBackground(Color.YELLOW);

                escolherPosicaoInterface(i, j, jogador);
                
       


                panel.add(matrizBotao[i][j]);
                mouseListener(i, j);

            }

        }
    }

	public void escolherPosicaoInterface(int i, int j, Jogador jogador) {
		matrizBotao[i][j].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				getMapa().escolherPosicao(i, j);
				

				if (getMapa().getCelulasVisiveis() == 1) { 
					if (getMapa().getDificuldade() == Dificuldade.FACIL) {
						TelaJogo t = new TelaJogo(Dificuldade.FACIL, jogador.getNome());
						t.setVisible(true);
						dispose();
						return;
					}
					else if(getMapa().getDificuldade()  == Dificuldade.MEDIO) {
						TelaJogo t = new TelaJogo(Dificuldade.MEDIO, jogador.getNome());
						t.setVisible(true);
						dispose();
						return;
					}
					else {
						TelaJogo t = new TelaJogo(Dificuldade.DIFICIL, jogador.getNome());
						t.setVisible(true);
						dispose();
						return;
					}

				}
				
				if (getMapa().getCelula(i, j).isEmBranco() && getMapa().getCelula(i, j).isVisivel()) {
					matrizBotao[i][j].setBackground(Color.BLACK);
					
					revelarEspacosInterface(false);
					
				} else if (getMapa().getCelula(i, j).getQtdBombasVizinhas() > 0
						&& getMapa().getCelula(i, j).isVisivel()) {
					matrizBotao[i][j].setText(Integer.toString(getMapa().getCelula(i, j).getQtdBombasVizinhas()));

				}

				else {
					matrizBotao[i][j].setIcon(new ImageIcon(".\\images\\Icone_bomba.png"));
					matrizBotao[i][j].setBackground(Color.RED);
					revelarEspacosInterface(true);
					timer.cancel();
					
					JOptionPane.showMessageDialog(null, jogador.getNome() +  ", Você perdeu !! ");
					
					dispose();
					TelaMenu menu = new TelaMenu();
					menu.setVisible(true);
					
				}
				
				ajustarLetra(i, j);

				if (getMapa().verificarGanhouJogo() == true) {
					timer.cancel();
					
					ranking = new Ranking(jogador, mapa.getDificuldade());
					
					JOptionPane.showMessageDialog(null, jogador.getNome() + ", Parabéns, você ganhou !! ");
					dispose();
					TelaMenu menu2 = new TelaMenu();
					menu2.setVisible(true);
					
					
				}
				
			}

		});
	}

	public void revelarEspacosInterface(boolean teste) {

		for (int i = 0; i < matrizBotao.length; i++) {
			for (int j = 0; j < matrizBotao.length; j++) {

				if (teste == false) {
					if (mapa.getCelula(i, j).isEmBranco() && getMapa().getCelula(i, j).isVisivel()) {
						matrizBotao[i][j].setBackground(Color.BLACK);
					} else if (mapa.getCelula(i, j).getQtdBombasVizinhas() > 0
							&& getMapa().getCelula(i, j).isVisivel()) {
						matrizBotao[i][j].setText(Integer.toString(getMapa().getCelula(i, j).getQtdBombasVizinhas()));
					}
					
					
					
					ajustarLetra(i, j);
				} else {
					if (mapa.getCelula(i, j).isEmBranco() && !mapa.getCelula(i, j).isBomba()) {
						matrizBotao[i][j].setBackground(Color.BLACK);
					} else if (mapa.getCelula(i, j).getQtdBombasVizinhas() > 0) {
						matrizBotao[i][j].setIcon(new ImageIcon(""));
						matrizBotao[i][j].setText(Integer.toString(getMapa().getCelula(i, j).getQtdBombasVizinhas()));
					} else if (mapa.getCelula(i, j).isBomba()) {
						matrizBotao[i][j].setIcon(new ImageIcon(".\\images\\Icone_bomba.png"));
					}

					ajustarLetra(i, j);

					
				}

			}
		}
		
		
		
	}

	public void mouseListener(int i, int j) {
		matrizBotao[i][j].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e) == true) {
					setarBandeira(i,j);
				}
			}
		});
	}
	
	public void setarBandeira(int i, int j){
		if (mapa.getCelula(i, j).isVisivel() == false) {
			if (mapa.getCelula(i, j).isBandeira() == false) {
				mapa.getCelula(i, j).setBandeira(true);
				getMatrizBotao(i, j).setIcon(new ImageIcon(".\\images\\Bandeira_luffy.png"));
				getMatrizBotao(i, j).setEnabled(false);
				lblTempo.setText("Bombas: " + Integer.toString(contadorBandeiras()));
			} else {
				mapa.getCelula(i, j).setBandeira(false);
				getMatrizBotao(i, j).setIcon(new ImageIcon(""));
				getMatrizBotao(i, j).setEnabled(true);
				lblTempo.setText("Bombas: " + Integer.toString(contadorBandeiras()));
			}
		}
	}
	
	public int contadorBandeiras() {
		int numCelBandeiras = 0;
		for (int i = 0; i < matrizBotao.length; i++) {
			for (int j = 0; j < matrizBotao.length; j++) {
				if (mapa.getCelula(i, j).isBandeira()) {
					if (numCelBandeiras < mapa.getBombas()) {
						numCelBandeiras++;
					}
				}
			}
		}
		return (mapa.getBombas() - numCelBandeiras);
	}
	
	public void fazerCronometro() {
		contagemTempo = new JLabel();
		this.timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				int seg, min, hora;
				count++;
				seg = count % 60;
				min = count / 60;
				hora = min / 60;
				min %= 60;
				contagemTempo.setText("Tempo: " + String.format("%02d:%02d:%02d", hora, min, seg));
				jogador.setTempo(count);
			}
		}, 1000, 1000);
		try {
			Thread.sleep(1400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ajustarLetra(int i, int j) {
		matrizBotao[i][j].setMargin(new Insets(0,0,0,0));
		if (this.mapa.getDificuldade() == Dificuldade.FACIL) {
			matrizBotao[i][j].setFont(new Font("Comic Sans", Font.BOLD, 30));
		} else if (this.mapa.getDificuldade() == Dificuldade.MEDIO) {
			matrizBotao[i][j].setFont(new Font("Comic Sans", Font.BOLD, 20));
		} else {
			matrizBotao[i][j].setFont(new Font("Comic Sans", Font.BOLD, 10));
		}
	}

	// MÉTODOS DA IA
	public void colocarBandeirasAuto() {
		for (int i = 0; i < matrizBotao.length; i++) {
			for (int j = 0; j < matrizBotao.length; j++) {
				for (int i2 = (i - 1); i2 <= (i + 1); i2++) { // LOOP PARA VARRER OS ARREDORES DA CASA A SER ANALISADA
					for (int j2 = (j - 1); j2 <= (j + 1); j2++) {
						if(i2 >= 0 && j2 >= 0 && i2 < matrizBotao.length && j2 < matrizBotao.length) {
							
							if( (mapa.getCelula(i, j).getQtdBombasVizinhas() == mapa.getCelula(i, j).getNumCelulasVizinhasInviziveis()) 
									&& mapa.getCelula(i2, j2).isBandeira() == false  
									&& mapa.getCelula(i2, j2).isVisivel() == false 
									&& mapa.getCelula(i, j).isVisivel()) {
								
								getMapa().getCelula(i2, j2).setBandeira(true);
								getMatrizBotao(i2, j2).setIcon(new ImageIcon(".\\images\\Bandeira_luffy.png"));
								getMatrizBotao(i2, j2).setEnabled(false);
								lblTempo.setText("Bombas: " + Integer.toString(contadorBandeiras()));
							
							}
						}
					}
				}
			}
		}
		revelarEspacosInterface(false);
		
	}
	
	public void selecionarCelulasAuto() {
		
		for (int i = 0; i < matrizBotao.length; i++) {
			for (int j = 0; j < matrizBotao.length; j++) {
				for (int i2 = (i - 1); i2 <= (i + 1); i2++) { // LOOP PARA VARRER OS ARREDORES DA CASA A SER ANALISADA
					for (int j2 = (j - 1); j2 <= (j + 1); j2++) {
						if(i2 >= 0 && j2 >= 0 && i2 < matrizBotao.length && j2 < matrizBotao.length) {
							if(mapa.getCelula(i, j).getQtdBombasVizinhas() == mapa.getCelula(i, j).getNumCelulasVizinhasComBandeira()) {
								
								if(mapa.getCelula(i2, j2).isBandeira() == false && mapa.getCelula(i2, j2).isVisivel() == false  && mapa.getCelula(i2, j2).isBomba() == false) {
									
									mapa.escolherPosicao(i2,j2);
									
									if (mapa.getCelula(i2, j2).isEmBranco()) {
										matrizBotao[i2][j2].setBackground(Color.BLACK);
									} 
									
									else if (mapa.getCelula(i2, j2).getQtdBombasVizinhas() > 0) {
										matrizBotao[i2][j2].setText(Integer.toString(getMapa().getCelula(i2, j2).getQtdBombasVizinhas()));
									}
									
									revelarEspacosInterface(false);
								}
							}
						}
					}
				}
			}
		}
	}
	
	public Mapa getMapa() {
		return mapa;
	}

	public JButton getMatrizBotao(int i, int j) {
		return matrizBotao[i][j];
	}
}
