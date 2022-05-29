package david.elias.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import david.elias.exception.AuthorException;
import david.elias.model.Author;

public class RemoveAuthor extends Main implements ActionListener{
	
	JDialog removeAuthor;
	JComboBox<Author> authorList;
	JButton submit, cancel;
	JPanel panelButtons;
	
	public RemoveAuthor () {
		
		
		
	}
		
	@Override
	public void buildWindow () {
			
		removeAuthor = new JDialog(mainFrame, "Delete author");
		removeAuthor.setSize(400,250);
		removeAuthor.setLayout(new GridLayout(3,1));
		
		try {
		
			Author tempAuthors [] = authors.toArray(new Author [authors.size()]);
			authorList = new JComboBox <Author>(tempAuthors);
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
			
			removeAuthor.add(new JLabel("WARNING! This will also delete books assigned to this author"));
			JPanel authorPanel = new JPanel(new GridLayout (1,2));
			authorPanel.add(new JLabel("Author:"));
			authorPanel.add(authorList);
			removeAuthor.add(authorPanel);
			removeAuthor.add(panelButtons);
			
			removeAuthor.setVisible(true);
		
		} catch (AuthorException e) { // Exception si no hay ningun autor
			JOptionPane.showMessageDialog(removeAuthor, "No authors");
			removeAuthor.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(removeAuthor, "Unknown Error");
			removeAuthor.dispose();
		}
			
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == submit) {
			
			Author authorToDelete = (Author)authorList.getSelectedItem();
			System.out.println("Because of author deletion = " + authorToDelete.toString() + " Deleting:");
			
			//Deletear relacionados con el autor
			for (int i = 0; i < books.size(); i++) {
				
				if (books.get(i).getAutor() == authorToDelete) {
					
					System.out.println(books.get(i).toString());
					books.remove(i);
					i--;
					
				}
				
			}
			
			System.out.println("---End of book deletion---");
			System.out.println("Deleting" + authorToDelete.toString());
			authors.remove(authorToDelete);
			System.out.println("Removal succesful");
			removeAuthor.dispose();
			
		} else if (e.getSource() == cancel) {
			
			removeAuthor.dispose();
			
		}
		
	}
	
}
