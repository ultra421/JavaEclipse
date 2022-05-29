package david.elias.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import david.elias.exception.AuthorException;
import david.elias.model.Author;

public class ModifyAuthor extends Main implements ActionListener {
	
	JDialog modifyAuthor;
	JComboBox<Author> authorList;
	JButton submit;
	JPanel panelFields;
	JTextField authorName,surname1Author,surname2Author,country;
	
	public ModifyAuthor () {
		
		super(); // calls buildWindow
		
	}
	
	@Override
	void buildWindow() {
		
		modifyAuthor = new JDialog(mainFrame,"Modify author");
		modifyAuthor.setSize(400,400);
		modifyAuthor.setLayout(new GridLayout(3,1,4,4));
		
		try {
		
			Author tempAuthors [] = authors.toArray(new Author [authors.size()]);
			authorList = new JComboBox<Author>(tempAuthors);
			
			if (tempAuthors.length == 0) {
				throw new AuthorException();
			}
			
			panelFields = new JPanel();
			panelFields.setLayout(new GridLayout (2,2,3,3));
			modifyAuthor.add(authorList);
			modifyAuthor.add(panelFields);
			
			authorName = new JTextField();
			surname1Author = new JTextField();
			surname2Author = new JTextField();
			country = new JTextField();
			submit = new JButton("Submit");
			submit.setPreferredSize(new Dimension(75,40));
			submit.addActionListener(this);
			
			panelFields.add(new JLabel("Author name"));
			panelFields.add(authorName);
			panelFields.add(new JLabel("Author surname"));
			panelFields.add(surname1Author);
			panelFields.add(new JLabel("Second author surname"));
			panelFields.add(surname2Author);
			panelFields.add(new JLabel("Country"));
			panelFields.add(country);
			
			submit = new JButton("Submit");
			submit.addActionListener(this);
			authorList.addActionListener(this);
			modifyAuthor.setVisible(true);
			
			modifyAuthor.add(submit);
			
		} catch (AuthorException e) { // Exception if there isn't any author
			JOptionPane.showMessageDialog(modifyAuthor, "There's not authors registered");
			modifyAuthor.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(modifyAuthor, "Unknown Error");
			modifyAuthor.dispose();
		}
		
	}
	
	private void updateFields(Author input) {
		
		authorName.setText(input.getName());
		surname1Author.setText(input.getSurname());
		surname2Author.setText(input.getSurname2());
		country.setText(input.getCountry());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == authorList) {
			
			updateFields((Author)authorList.getSelectedItem());
			
		} else if (e.getSource() == submit) {
			
			Author clickedAuthor = (Author)authorList.getSelectedItem();
			String name = authorName.getText();
			String surname1 = surname1Author.getText();
			String surname2 = surname2Author.getText();
			String country = this.country.getText();
			
			authorControl.updateAuthor(clickedAuthor, name, surname1, surname2, country);
			
		}
		
	}

}
