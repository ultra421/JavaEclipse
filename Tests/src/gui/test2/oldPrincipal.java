package gui.test2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class oldPrincipal extends JFrame{
	
	public oldPrincipal() {
		
		setSize(500,300);
		setVisible(true);
		setIconImage(new ImageIcon("momento.jpg").getImage());
		
		FlowLayout mainFlow = new FlowLayout(FlowLayout.CENTER);
		mainFlow.setVgap(0);
		mainFlow.setHgap(0);
		setLayout(mainFlow);
		setResizable(false);
		
		JPanel titlePanel = new JPanel ();
		titlePanel.setBackground(new Color(100,100,100));
		titlePanel.setPreferredSize(new Dimension(500,75));
		FlowLayout titleFlow = new FlowLayout(FlowLayout.CENTER,0,20);
		titlePanel.setLayout(titleFlow);
		
		JLabel titleLabel = new JLabel("Library");
		titleLabel.setFont(new Font("Verdana",Font.BOLD,30));
		titlePanel.add(titleLabel);
		
		JPanel authorButtons = new JPanel ();
		//Botones autor
		authorButtons.setPreferredSize(new Dimension(240,225));
		authorButtons.setBackground(new Color(50,50,50));
		authorButtons.setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
		
		JLabel authorLabel = new JLabel("Autores");
		authorButtons.add(authorLabel);
		authorButtons.add(new JButton("New"));
		authorButtons.add(new JButton("Modify"));
		authorButtons.add(new JButton("Remove"));
		
		JPanel booksButtons = new JPanel ();
		//Botones books
		booksButtons.setPreferredSize(new Dimension(240,225));
		booksButtons.setBackground(new Color(150,150,150));
		
		add(titlePanel);
		add(authorButtons);
		add(booksButtons);
		setVisible(true);
		
	}
	
	public static void main (String args[]) {
		
		oldPrincipal mainFrame = new oldPrincipal();
		
	}

}
