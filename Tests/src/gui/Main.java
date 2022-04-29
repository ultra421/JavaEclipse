package gui;

import java.awt.Point;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("Titulo");
		f.setSize(300,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		for (int i = 0; i < 1000; i++) {
			f.setSize(i, i);
			
			if (i == 999) {
				
				i = 0;
				
			}
			
		}

	}

}
