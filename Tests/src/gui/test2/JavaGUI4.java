package gui.test2;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class JavaGUI4 {

	public static void main(String[] args) {
		
		int horizontal = 60;
		int vertical = 60;
		
		GridLayout layout = new GridLayout(horizontal,vertical,0,0);
		
		JFrame mainFrame = new JFrame ("aaaaaaaa");
		mainFrame.setSize(horizontal*5,vertical*5);
		mainFrame.setLayout(layout);
		JPanel panels[][] = new JPanel[horizontal][vertical];
		
		for (int i = 0; i < vertical; i++) {
			
			for (int k = 0; k < horizontal; k++) {
				
				panels[i][k] = new JPanel();
				panels[i][k].setBackground(new Color(0,0,0));
				mainFrame.add(panels[i][k]);
				
			}
			
		}
		
		mainFrame.setVisible(true);
		
		ArrayList<Gota> gotas = new ArrayList<Gota>();
		Random rng = new Random();
		int frecuenciaGotas = rng.nextInt(8)+3;
		int tick = 0;
		
		while (true) {
			
			try {
				TimeUnit.MILLISECONDS.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Add gotas
			
			if (tick % frecuenciaGotas == 0) {
				
				Gota newGota = new Gota(rng.nextInt(horizontal),0);
				gotas.add(newGota);
				System.out.println("New gota! X = " + newGota.getX());
				
			}
			
			// Mover gotas y print
			
			for (int i = 0; i < gotas.size(); i++) {
				
				Gota gota = gotas.get(i);
				int gotaX = gota.getX();
				int gotaY = gota.getY();
				
				if (gotaY < vertical) {
					
					gota.setY(gotaY+1);
					
					JPanel currentPan = panels[gotaY][gotaX];
					
					currentPan.setBackground(new Color (255,255,255));
					
					if (gotaY > 0) { // Eliminar anterior
						
						panels[gotaY-1][gotaX].setBackground(new Color(0,0,0));
						
					}
					
				} else { // SI abajo eliminar
					panels[gotaY-1][gotaX].setBackground(new Color(0,0,0));
					gotas.remove(gota);
				}
				
			}
			
			tick++;
			
		}

	}

}
