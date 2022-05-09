package gui.test2;

import java.awt.Color;

import javax.swing.*;

public class JavaGUI2 {
	
	public static void main (String args[]) {
		
		ImageIcon image = new ImageIcon ("momento.jpg");
		
		JFrame frame = new JFrame("AAAAAA");
		
		frame.setSize(300,300);
		frame.setVisible(true);
		
		JLabel label = new JLabel();
		label.setText ("Java moment");
		label.setIcon(image);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		
		
		frame.add(label);
		
	}

}
