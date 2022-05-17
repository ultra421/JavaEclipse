package david.elias.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import david.elias.controller.AuthorController;
import david.elias.exception.AuthorException;
import david.elias.exception.BookException;
import david.elias.model.Author;
import david.elias.model.Book;

public class NewLibro extends Principal implements ActionListener {
	
	JDialog newLibro;
	JTextField isbn, titulo, paginas, genero;
	JComboBox authorList;
	JButton submit, cancel;
	
	public NewLibro () { //Llama a buildVentana automaticamente por el super
		
	}
	
	@Override
	void buildVentana() {
		
		try {
			
			Author tempAuthors [] = authors.toArray(new Author [authors.size()]);
			authorList = new JComboBox(tempAuthors);
			authorList.addActionListener(this);
			
			if (tempAuthors.length == 0) {
				throw new AuthorException();
			}
			
		} catch (AuthorException e) {
			
			JOptionPane.showMessageDialog(modifyAuthor, "No hay ningun autor");
			newLibro.dispose();
			
		}
		
		newLibro = new JDialog(super.mainFrame,"Crear un nuevo libro");
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
		newLibro.add(new JLabel("Titulo"));
		newLibro.add(titulo);
		newLibro.add(new JLabel("Paginas"));
		newLibro.add(paginas);
		newLibro.add(new JLabel("Genero"));
		newLibro.add(genero);
		newLibro.add(new JLabel("Autor"));
		newLibro.add(authorList);
		newLibro.add(submit);
		newLibro.add(cancel);
		
		newLibro.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == submit) {
			
			int newIsbn = Integer.parseInt(isbn.getText());
			String newTitulo = titulo.getText();
			int newPaginas = Integer.parseInt(paginas.getText());
			String newGenero = genero.getText();
			Author authorToAdd = (Author)authorList.getSelectedItem();
			
			Book bookToAdd = new Book(newIsbn,newTitulo,newPaginas,newGenero,authorToAdd);
			try {
				bookControl.addBook(bookToAdd);
			} catch (BookException e1) {
				JOptionPane.showMessageDialog(newLibro, "No pueden haber dos libros con el mismo ISBN");
				newLibro.dispose();
			}
			
		} else if (e.getSource() == cancel) {
			
			newLibro.dispose();
			
		}
		
	}

}
