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
import javax.swing.JTextField;
import david.elias.exception.AuthorException;
import david.elias.exception.BookException;
import david.elias.model.Author;
import david.elias.model.Book;

public class ModifyLibro extends Principal implements ActionListener{
	
	JDialog modifyBook;
	JComboBox<Author> authorList;
	JComboBox<Book> bookList;
	JButton submit, cancel;
	JTextField isbn,titulo,paginas,genero;
	
	public ModifyLibro() {
		super(); // Llamar a buildVentana
	}
	
	void buildVentana() {
		
		modifyBook = new JDialog(mainFrame,"Modify Book");
		modifyBook.setSize(400,400);
		modifyBook.setLayout(new GridLayout(7,2,4,4));
		
		try {
			
			Author tempAuthors[] = authors.toArray(new Author [authors.size()]);
			Book tempBooks[] = books.toArray(new Book[books.size()]);
			
			if (tempAuthors.length == 0) {
				throw new AuthorException();
			} else if (tempBooks.length == 0) {
				throw new BookException();
			}
			
			authorList = new JComboBox<Author>(tempAuthors);
			bookList = new JComboBox<Book>(tempBooks);
			bookList.addActionListener(this);
			isbn = new JTextField();
			titulo = new JTextField();
			paginas = new JTextField();
			genero = new JTextField();
			submit = new JButton("Submit");
			submit.addActionListener(this);
			cancel = new JButton("Cancel");
			cancel.addActionListener(this);
			
			modifyBook.add(new JLabel("Libro"));
			modifyBook.add(bookList);
			modifyBook.add(new JLabel("ISBN"));
			modifyBook.add(isbn);
			modifyBook.add(new JLabel("Titulo"));
			modifyBook.add(titulo);
			modifyBook.add(new JLabel("Paginas"));
			modifyBook.add(paginas);
			modifyBook.add(new JLabel("Genero"));
			modifyBook.add(genero);
			modifyBook.add(new JLabel("Autor"));
			modifyBook.add(authorList);
			modifyBook.add(submit);
			modifyBook.add(cancel);
			
			updateFields();
			
			modifyBook.setVisible(true);
			
		} catch (AuthorException e) {
			JOptionPane.showMessageDialog(modifyAuthor, "No hay ningun autor");
			modifyBook.dispose();
		} catch (BookException e) {
			JOptionPane.showMessageDialog(modifyAuthor, "No hay ningun libro");
			modifyBook.dispose();
		}
		
	}
	
	void updateFields () {
		
		Book tempBook = (Book)bookList.getSelectedItem();
		authorList.setSelectedItem(tempBook.getAutor());
		isbn.setText(Integer.toString(tempBook.getIsbn()));
		titulo.setText(tempBook.getTitulo());
		paginas.setText(Integer.toString(tempBook.getPaginas()));
		genero.setText(tempBook.getGenero());
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == bookList) {
			
			updateFields();
			
		} else if (e.getSource() == submit) {
			
			Book currentBook = (Book)bookList.getSelectedItem();
			currentBook.setAutor((Author)authorList.getSelectedItem());
			currentBook.setIsbn(Integer.parseInt(isbn.getText()));
			currentBook.setTitulo(titulo.getText());
			currentBook.setPaginas(Integer.parseInt(paginas.getText()));
			currentBook.setGenero(genero.getText());
			
		} else if (e.getSource() == cancel) {
			
			modifyBook.dispose();
			
		}
		
	}

}


