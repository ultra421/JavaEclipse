package david.elias.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import david.elias.exception.AuthorException;
import david.elias.exception.BookException;
import david.elias.model.Author;
import david.elias.model.Book;

public class NewBook extends Main implements ActionListener {
	
	JDialog newLibro;
	JTextField isbn, titulo, paginas, genero;
	JComboBox<Author> authorList;
	JButton submit, cancel;
	
	public NewBook () { // calls buildWindow
		
	}
	
	@Override
	void buildWindow() {
		
		try {
			
			Author tempAuthors [] = authors.toArray(new Author [authors.size()]);
			authorList = new JComboBox<Author>(tempAuthors);
			authorList.addActionListener(this);
			
			if (tempAuthors.length == 0) {
				throw new AuthorException();
			}
			
		} catch (AuthorException e) {
			
			JOptionPane.showMessageDialog(modifyAuthor, "No authors");
			newLibro.dispose();
			
		}
		
		newLibro = new JDialog(mainFrame,"Create new book");
		newLibro.setSize(500,400);
		newLibro.setLayout(new GridLayout(6,2,4,4));
		
		isbn = new JTextField();
		titulo = new JTextField();
		paginas = new JTextField();
		genero = new JTextField();
		//authorList ya generado en trycatch
		submit = new JButton("Submit");
		submit.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		
		newLibro.add(new JLabel("ISBN"));
		newLibro.add(isbn);
		newLibro.add(new JLabel("Title"));
		newLibro.add(titulo);
		newLibro.add(new JLabel("Pages"));
		newLibro.add(paginas);
		newLibro.add(new JLabel("Gender"));
		newLibro.add(genero);
		newLibro.add(new JLabel("Author"));
		newLibro.add(authorList);
		newLibro.add(submit);
		newLibro.add(cancel);
		
		newLibro.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == submit) {
			
			try {
				
				int newIsbn = Integer.parseInt(isbn.getText());
				String newTitulo = titulo.getText();
				int newPaginas = Integer.parseInt(paginas.getText());
				String newGenero = genero.getText();
				Author authorToAdd = (Author)authorList.getSelectedItem();
				
				Book bookToAdd = new Book(newIsbn,newTitulo,newPaginas,newGenero,authorToAdd);
				bookControl.addBook(bookToAdd);
				isbn.setText(Integer.toString(newIsbn++));
				
			} catch (BookException e1) {
				JOptionPane.showMessageDialog(newLibro, "There can't be two books with the same ISBN");
			} catch (java.lang.NumberFormatException e1) {
				JOptionPane.showMessageDialog(newLibro, "Couldn't create, fields maybe invalid");
			}
			
		} else if (e.getSource() == cancel) {
			
			newLibro.dispose();
			
		}
		
	}

}
