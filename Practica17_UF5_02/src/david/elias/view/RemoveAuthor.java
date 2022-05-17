package david.elias.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import david.elias.exception.AuthorException;
import david.elias.model.Author;

public class RemoveAuthor extends Principal implements ActionListener{
	
	JDialog removeAuthor;
	JComboBox authorList;
	JButton submit, cancel;
	JPanel panelButtons;
	
	public RemoveAuthor () {
		
		
		
	}
		
	@Override
	public void buildVentana () {
			
		removeAuthor = new JDialog(super.mainFrame, "Delete author");
		removeAuthor.setSize(400,250);
		removeAuthor.setLayout(new GridLayout(2,1));
		
		try {
		
			Author tempAuthors [] = authors.toArray(new Author [authors.size()]);
			authorList = new JComboBox(tempAuthors);
			authorList.addActionListener(this);
			
			if (tempAuthors.length == 0) {
				throw new AuthorException();
			}
			
			panelButtons = new JPanel();
			submit = new JButton("Delete");
			cancel = new JButton("Cancel");
			submit.addActionListener(this);
			cancel.addActionListener(this);
			panelButtons.add(submit);
			panelButtons.add(cancel);
			submit.setSize(50,20);
			submit.setSize(50,20);
			authorList.setSize(200,100);
			
			removeAuthor.add(authorList);
			removeAuthor.add(panelButtons);
			
			removeAuthor.setVisible(true);
		
		} catch (AuthorException e) { // Exception si no hay ningun autor
			JOptionPane.showMessageDialog(removeAuthor, "No hay ningun autor");
			removeAuthor.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(removeAuthor, "Unknown Error");
			removeAuthor.dispose();
		}
			
	}
	
	private void updateFields() {
		
		if (authors.size() == 0) {
			
			JOptionPane.showMessageDialog(removeAuthor, "No queda ningun autor");
			removeAuthor.dispose();
			
		} else {
			
			Author tempAuthors [] = authors.toArray(new Author [authors.size()]);
			authorList = new JComboBox(tempAuthors);
			authorList.updateUI();
			
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == submit) {
			
			authorControl.deleteAuthor((Author)authorList.getSelectedItem());
			updateFields();
			
		} else if (e.getSource() == cancel) {
			
			removeAuthor.dispose();
			
		}
		
	}
	
}
