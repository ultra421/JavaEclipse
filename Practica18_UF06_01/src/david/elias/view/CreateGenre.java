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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateGenre extends Main implements ActionListener {
	
	JDialog createGenre;
	JTextField description;
	JButton submit, cancel;
	
	public CreateGenre() {
		super();
	}
	
	@Override
	void buildWindow() {
		
		createGenre = new JDialog(main);
		createGenre.setTitle("Create genre");
		createGenre.setSize(300,450);
		createGenre.setLayout(new GridLayout(3,1));
		
		description = new JTextField();
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);

		createGenre.add(new JLabel("Genre description/Name"));
		createGenre.add(description);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1,2));
		buttons.add(submit);
		buttons.add(cancel);
		createGenre.add(buttons);
		
		createGenre.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == submit) {
			
		} else if (e.getSource() == cancel) {
			
		}
		
	}

}
