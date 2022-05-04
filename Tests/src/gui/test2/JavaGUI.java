package gui.test2;

import java.awt.GridLayout;

import javax.swing.*;


public class JavaGUI {
	
	public static void main (String args []) {
		
		JFrame frame = new JFrame("AAAAA");
		frame.setLayout(new GridLayout(10,10));
		frame.setResizable(false);
		frame.setSize(600,600);
		frame.setVisible(true);
		
		for (int i = 0; i < 10; i++) {
			
			for (int k = 0; k < 10; k++) {
				
				frame.add(new JButton("AAA"));
				
			}
			
		}
		
	}

}
