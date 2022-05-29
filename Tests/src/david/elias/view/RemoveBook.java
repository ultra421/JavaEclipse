package david.elias.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import david.elias.exception.BookException;
import david.elias.model.Book;

public class RemoveBook extends Main {

	JDialog removeBook;
	JComboBox<Book>bookList;
	JButton submit, cancel;
	JPanel panelButtons;

	public RemoveBook() {

	}

	@Override
	public void buildWindow() {

		removeBook = new JDialog(mainFrame, "Delete author");
		removeBook.setSize(400, 250);
		removeBook.setLayout(new GridLayout(2, 1));

		try {

			Book tempBooks[] = books.toArray(new Book[books.size()]);
			bookList = new JComboBox<Book>(tempBooks);
			bookList.addActionListener(this);

			if (tempBooks.length == 0) {
				throw new BookException();
			}

			panelButtons = new JPanel();
			submit = new JButton("Delete");
			cancel = new JButton("Cancel");
			submit.addActionListener(this);
			cancel.addActionListener(this);
			panelButtons.add(submit);
			panelButtons.add(cancel);
			submit.setSize(50, 20);
			submit.setSize(50, 20);
			bookList.setSize(200, 100);

			removeBook.add(bookList);
			removeBook.add(panelButtons);

			removeBook.setVisible(true);

		} catch (BookException e) { // Exception si no hay ningun libro
			JOptionPane.showMessageDialog(removeBook, "No books");
			removeBook.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(removeBook, "Unknown Error");
			removeBook.dispose();
		}

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {

			books.remove(bookList.getSelectedItem());
		
			if (books.size() == 0) {

				JOptionPane.showMessageDialog(removeBook, "No books left");
				removeBook.dispose();

			} 

		} else if (e.getSource() == cancel) {

			removeBook.dispose();

		}

	}

}
