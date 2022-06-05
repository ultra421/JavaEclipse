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

public class UpdateGenre extends Main implements ActionListener {
	
	JDialog searchGenre;
	JTextField id, description, updateID, updateDesc;
	JButton next, prev, cancel, submit;
	int currentID, maxID, minID;
	
	public UpdateGenre() {
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
		
		searchGenre = new JDialog(main, "Update genre");
		searchGenre.setLayout(new GridLayout(4,1,10,10));
		searchGenre.setSize(500,600);
		
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
		
		/////////////////
		
		next = new JButton("Next");
		next.addActionListener(this);
		prev = new JButton("Previous");
		prev.addActionListener(this);
		
		JPanel buttonsSearch = new JPanel(new GridLayout (1,2,10,10));
		
		buttonsSearch.add(prev);		
		buttonsSearch.add(next);
		
		searchGenre.add(buttonsSearch);
		
		/////////////////
		
		JPanel modify = new JPanel(new GridLayout(1,4,10,10));
		
		updateID = new JTextField();
		updateID.setEditable(false); // maybe add this later? would require to check if ID exists (da palo)
		updateDesc = new JTextField();
		
		modify.add(new JLabel("New ID"));
		modify.add(updateID);
		modify.add(new JLabel("New description"));
		modify.add(updateDesc);
		
		searchGenre.add(modify);
		
		//////////////
		
		JPanel buttonsSubmit = new JPanel(new GridLayout (1,2,10,10));
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		
		buttonsSubmit.add(submit);
		buttonsSubmit.add(cancel);
		
		searchGenre.add(buttonsSubmit);
		
		////////////////////////
		
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
		} else if (e.getSource() == submit) {
			updateGenre();
			updateFieldsWithId(currentID);
		}
		
	}
	
	private void updateGenre() {
		
		try {
			generoControl.updateGenre(currentID, updateDesc.getText());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	void updateFieldsWithId (int id) {
		
		try {
			
			System.out.println("asking for generos with ID =" + id);
			ResultSet rs = generoControl.getInfo(id);
			String descript = rs.getString("descripcion");
			
			this.id.setText(String.valueOf(rs.getInt("codigo")));
			description.setText(descript);
			next.setEnabled(true);
			prev.setEnabled(true);
			submit.setEnabled(true);
			
			updateID.setText(String.valueOf(rs.getInt("codigo")));
			updateDesc.setText(descript);
			
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
				submit.setEnabled(false);
			}
	
			e.printStackTrace();
			
		}
		
	}

}