package gui.test2;

import javax.swing.*;

public class JavaGUI7 {

	public static void main(String[] args) {
		
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(400,400);
		
		String list [] = new String[3];
		list[0] = "AAAA";
		list[1] = "BBBB";
		list[2] = "CCCC";
		JComboBox combo = new JComboBox(list);
		mainFrame.add(combo);
		
		mainFrame.setVisible(true);
		
	}

}
