package david.elias.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchGenre extends Main implements ActionListener {
	
	JDialog searchGenre;
	JTextField id, description;
	JButton next, prev, cancel;
	int currentID, maxID, minID;
	
	public SearchGenre() {
		super();
		try {
			maxID = generoControl.getLastID();
			minID = generoControl.getFirstID();
			currentID = minID;
			updateFieldsWithId(currentID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	void buildWindow() {
		
		searchGenre = new JDialog(main, "Search genres");
		searchGenre.setLayout(new GridLayout(2,1,10,10));
		searchGenre.setSize(500,300);
		
		id = new JTextField();
		id.setEditable(false);
		description = new JTextField();
		description.setEditable(false);
		
		JPanel info = new JPanel(new GridLayout (1,4,10,10));
		
		info.add(new JLabel("ID"));
		info.add(id);
		info.add(new JLabel("description"));
		info.add(description);
		
		searchGenre.add(info);
		
		next = new JButton("Next");
		next.addActionListener(this);
		prev = new JButton("Previous");
		prev.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		
		JPanel buttons = new JPanel(new GridLayout (1,3,10,10));
		
		buttons.add(prev);		
		buttons.add(next);
		buttons.add(cancel);
		
		searchGenre.add(buttons);
		
		searchGenre.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == next) {
			currentID++;
			updateFieldsWithId(currentID);
		} else if (e.getSource() == prev) {
			currentID--;
			updateFieldsWithId(currentID);
		} else if (e.getSource() == cancel) {
			searchGenre.dispose();
		}
		
	}
	
	void updateFieldsWithId (int id) {
		
		try {
			
			System.out.println("asking for generos with ID =" + id);
			ResultSet rs = generoControl.getInfo(id);
			
			this.id.setText(String.valueOf(rs.getInt("codigo")));
			description.setText(rs.getString("descripcion"));
			next.setEnabled(true);
			prev.setEnabled(true);
			
			if (currentID == minID) {
				prev.setEnabled(false);
			} else if (currentID == maxID) {
				next.setEnabled(false);
			}
			
		} catch (SQLException e) {
			
			if (id > maxID) {
				JOptionPane.showMessageDialog(searchGenre, "There are no more genres");
				next.setEnabled(false);
				currentID--;
			} else if (id < minID) {
				JOptionPane.showMessageDialog(searchGenre, "There are no more genres with lower ID");
				prev.setEnabled(false);
				currentID++;
			} else {
				JOptionPane.showMessageDialog(searchGenre, "There is no genre assigned to this ID = " + id);
			}
	
			e.printStackTrace();
			
		}
		
	}

}
