package gui.test1;

import javax.swing.*;

public class main {

	public static void main(String[] args) {
		
		/*JFrame f = new JFrame("Titulo");
		f.setSize(300,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		JDialog g = new JDialog(f,true);
		g.add(new JTextField("AAAAAAAAAAAAa"));
		g.setSize(100,100);
		g.setVisible(true);
		
		for (int i = 0; i < 1000; i++) {
			f.setSize(i, i);
			
			if (i == 999) {
				
				i = 0;
				
			}
			
		} */
		
		
		
		
		/*JButton botones [] = new JButton [10];

		 * 
		 * for (int i = 0; i < botones.length; i++) {
			
			botones[i] = new JButton (Integer.toString(i));
			botones[i].setSize(20,20);
			frameMain.add(botones[i]);
			
			
		} */
		
		JFrame frameMain = new JFrame("java moment");
		
				
		frameMain.setSize(300,300);
		JButton boton = new JButton("AAAAAAAAAAAA");
		
		frameMain.add(boton);
		boton.setSize(20,20);
		frameMain.setVisible(true);

	}

}
