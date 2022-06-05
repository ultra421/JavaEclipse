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

public class DeleteGenre extends Main implements ActionListener {
	
	JDialog deleteGenre;
	JTextField id, description;
	JButton next, prev, cancel, delete;
	int currentID, maxID, minID;
	
	public DeleteGenre() {
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
		
		deleteGenre = new JDialog(main, "Delete genre");
		deleteGenre.setLayout(new GridLayout(3,1,10,10));
		deleteGenre.setSize(500,300);
		
		JLabel warning = new JLabel("Deleting genre will set all movies with that genre to have a NULL genre!");
		deleteGenre.add(warning);
		
		id = new JTextField();
		id.setEditable(false);
		description = new JTextField();
		description.setEditable(false);
		
		JPanel info = new JPanel(new GridLayout (1,4,10,10));
		
		info.add(new JLabel("ID"));
		info.add(id);
		info.add(new JLabel("description"));
		info.add(description);
		
		deleteGenre.add(info);
		
		next = new JButton("Next");
		next.addActionListener(this);
		prev = new JButton("Previous");
		prev.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		delete = new JButton("Delete");
		delete.addActionListener(this);
		
		JPanel buttons = new JPanel(new GridLayout (1,3,10,10));
		
		buttons.add(prev);		
		buttons.add(next);
		buttons.add(delete);
		buttons.add(cancel);
		
		deleteGenre.add(buttons);
		
		deleteGenre.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == next) {
			currentID++;
			updateFieldsWithId(currentID);
		} else if (e.getSource() == prev) {
			currentID--;
			updateFieldsWithId(currentID);
		} else if (e.getSource() == cancel) {
			deleteGenre.dispose();
		} else if (e.getSource() == delete) {
			
			try {
				
				generoControl.deleteGenre(currentID);
				JOptionPane.showMessageDialog(deleteGenre, "Deleted genre, movies with this genre have been set to have a NULL genre!");
				
			} catch (SQLException e1) {
				
				JOptionPane.showMessageDialog(deleteMovie, "Couldn't delete because of sequel relations... :/");
				e1.printStackTrace();
			}
			
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
				JOptionPane.showMessageDialog(deleteGenre, "There are no more genres");
				next.setEnabled(false);
				currentID--;
			} else if (id < minID) {
				JOptionPane.showMessageDialog(deleteGenre, "There are no more genres with lower ID");
				prev.setEnabled(false);
				currentID++;
			} else {
				JOptionPane.showMessageDialog(deleteGenre, "There is no genre assigned to this ID = " + id);
			}
	
			e.printStackTrace();
			
		}
		
	}

}
