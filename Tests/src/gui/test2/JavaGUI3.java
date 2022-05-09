package gui.test2;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class JavaGUI3 {
	
	public static void main (String args []) {
		
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
		
		while (true) {
		
			for (int k = 0; k < horizontal; k++) {
				
				panels[15][k].setBackground(new Color(255,255,255));
			
				if (k > 1) {
					
					panels[15][k-1].setBackground(new Color(100,100,100));
					panels[15][k-2].setBackground(new Color(0,0,0));
					try {
						TimeUnit.MILLISECONDS.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
			
			for (int k = horizontal-1; k > 0; k--) {
				
				panels[15][k].setBackground(new Color(255,255,255));
			
				if (k < horizontal-2) {
					
					panels[15][k+1].setBackground(new Color(100,100,100));
					panels[15][k+2].setBackground(new Color(0,0,0));
					try {
						TimeUnit.MILLISECONDS.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
			
		}
		
	}

}
