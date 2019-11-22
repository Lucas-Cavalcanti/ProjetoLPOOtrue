package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class SplashScreen extends JWindow {

	private JLabel lbFigura;

	public SplashScreen() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			
				lbFigura = new JLabel();
				getContentPane().add(lbFigura);
				lbFigura.setBounds(0, 0, 660, 450);
				lbFigura.setIcon(new ImageIcon(".\\images\\Botaosair.png"));
			

			// Posicionar centralizado
			this.centralizaJanela();

			getContentPane().setLayout(null);
			pack();
			this.setSize(476, 315);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void centralizaJanela() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int larguraJanela = 476;
		int alturaJanela = 315;
		int larguraTela = d.width;
		int alturaTela = d.height;
		int posHorizontal = (larguraTela - larguraJanela) / 2;
		int posVertical = (alturaTela - alturaJanela) / 2;
		this.setLocation(posHorizontal, posVertical);
	}
}
