package david.elias.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SearchMovie extends Main implements ActionListener {
	
	JDialog searchMovie;
	
	public SearchMovie() {
		
	}
	
	void buildWindow() {
		
		searchMovie = new JDialog(main);
		searchMovie.setTitle("Search movie");
		searchMovie.setSize(400,450);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}