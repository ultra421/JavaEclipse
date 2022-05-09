package gui.test2;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.math.*;
import java.util.concurrent.TimeUnit;

public class JavaGUI5 {
	
	public static void main (String args []) {
		
		int horizontal = 120;
		int vertical = 120;
		int radius = 20;
		
		GridLayout layout = new GridLayout(horizontal,vertical,0,0);
		
		JFrame mainFrame = new JFrame ("aaaaaaaa");
		mainFrame.setSize(horizontal*5,vertical*5);
		mainFrame.setLayout(layout);
		JPanel panels[][] = new JPanel[horizontal][vertical];
		
		mainFrame.setVisible(true);
		
		for (int i = 0; i < vertical; i++) {
			
			for (int k = 0; k < horizontal; k++) {
					
				panels[i][k] = new JPanel();
				panels[i][k].setBackground(new Color(0,0,0));
				mainFrame.add(panels[i][k]);
				
				
			}
			
		}
		
		int centerX = (int)horizontal/2 - 1 ; // para arrays
		int centerY = (int)vertical/2 -1; // para rrays
		
		for (int k = radius; k > 0; k--) {
		
			for (int i = 0; i < 360; i++) {
				
				int x = (int)(k * Math.cos(i));
				int y = (int)(k * Math.sin(i));
				
				panels[centerY+y][centerX+x].setBackground(new Color(255,255,255));
				try {
					
					TimeUnit.MILLISECONDS.sleep(4);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		}
		
	}

}
