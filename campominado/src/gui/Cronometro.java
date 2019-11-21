package gui;

import java.util.Timer;
import java.util.TimerTask;

public class Cronometro {
	
	int segundosPassados = 0;
	public Cronometro() {
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				segundosPassados++;
				System.out.println(segundosPassados);
			}
		};
		
		timer.scheduleAtFixedRate(task, 1000, 1000);
	}
}
