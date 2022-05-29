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

public class ModifyBook extends Main implements ActionListener {

	JDialog modifyBook;
	JComboBox<Author> authorList;
	JComboBox<Book> bookList;
	JButton submit, cancel;
	JTextField isbn, title, pages, gender;

	public ModifyBook() {
		super(); // calls buildWindow
	}

	void buildWindow() {

		modifyBook = new JDialog(mainFrame, "Modify Book");
		modifyBook.setSize(400, 400);
		modifyBook.setLayout(new GridLayout(7, 2, 4, 4));

		try {

			Author tempAuthors[] = authors.toArray(new Author[authors.size()]);
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
			title = new JTextField();
			pages = new JTextField();
			gender = new JTextField();
			submit = new JButton("Submit");
			submit.addActionListener(this);
			cancel = new JButton("Cancel");
			cancel.addActionListener(this);

			modifyBook.add(new JLabel("Book"));
			modifyBook.add(bookList);
			modifyBook.add(new JLabel("ISBN"));
			modifyBook.add(isbn);
			modifyBook.add(new JLabel("Title"));
			modifyBook.add(title);
			modifyBook.add(new JLabel("Pages"));
			modifyBook.add(pages);
			modifyBook.add(new JLabel("Gender"));
			modifyBook.add(gender);
			modifyBook.add(new JLabel("Author"));
			modifyBook.add(authorList);
			modifyBook.add(submit);
			modifyBook.add(cancel);

			updateFields();

			modifyBook.setVisible(true);

		} catch (AuthorException e) {
			JOptionPane.showMessageDialog(modifyAuthor, "No authors");
			modifyBook.dispose();
		} catch (BookException e) {
			JOptionPane.showMessageDialog(modifyAuthor, "No books");
			modifyBook.dispose();
		}

	}

	void updateFields() {

		Book tempBook = (Book) bookList.getSelectedItem();
		authorList.setSelectedItem(tempBook.getAutor());
		isbn.setText(Integer.toString(tempBook.getIsbn()));
		title.setText(tempBook.getTitulo());
		pages.setText(Integer.toString(tempBook.getPaginas()));
		gender.setText(tempBook.getGenero());

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bookList) {

			updateFields();

		} else if (e.getSource() == submit) {

			try {

				Book currentBook = (Book) bookList.getSelectedItem();
				currentBook.setAutor((Author) authorList.getSelectedItem());
				currentBook.setIsbn(Integer.parseInt(isbn.getText()));
				currentBook.setTitulo(title.getText());
				currentBook.setPaginas(Integer.parseInt(pages.getText()));
				currentBook.setGenero(gender.getText());

			} catch (java.lang.NumberFormatException e1) {
				JOptionPane.showMessageDialog(modifyBook, "Couldn't modify, fields maybe invalid");
			}

		} else if (e.getSource() == cancel) {

			modifyBook.dispose();

		}

	}

}
