package david.elias.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import david.elias.exception.MatchingException;

public class SearchLibro extends Principal implements ActionListener{
	
	JComboBox <String> genreList;
	JComboBox <Author> authorList;
	ArrayList <Book> matchBooks;
	JTextField isbn, title , pages, genre, authorName;
	JButton search,back,forward,cancel;
	JDialog searchBook;
	int arrayPos;
	
	SearchLibro () {
		
	}
	
	void buildVentana() {
		
		//Estructura principal
		
		searchBook = new JDialog(mainFrame, "Search book");
		searchBook.setSize(400,600);
		searchBook.setResizable(false);
		searchBook.setLayout(new GridLayout(3,2));
		JPanel searchPanel = new JPanel (new GridLayout(3,2));
		searchPanel.setSize(400,150);
		JPanel resultPanel = new JPanel (new GridLayout(5,2));
		resultPanel.setSize(400,350);
		JPanel movePanel = new JPanel (new FlowLayout());
		movePanel.setSize(400,100);
		
		//Establecer componentes
		//autores
		
		try {
			
			Author tempAuthors[] = authors.toArray(new Author [authors.size()]);
			
			if (tempAuthors.length == 0) {
				throw new AuthorException();
			}
			
			authorList = new JComboBox<Author>(tempAuthors);
			authorList.addActionListener(this);
			
			//establecer listas de genero
			
			ArrayList<String> tempGeneresList = new ArrayList<String>();
			for (int i = 0; i < books.size(); i++) {
				
				Book currentBook = books.get(i);
				
				if (!tempGeneresList.contains(currentBook.getGenero())) {
					
					tempGeneresList.add(currentBook.getGenero());
					
				}
				
			}
			
			// nueva JComboBox con la array de String de tamañao el maximo del arrayList
			genreList = new JComboBox<String>(tempGeneresList.toArray(new String[tempGeneresList.size()]));
			genreList.addActionListener(this);
			
			// Botones
			search = new JButton("Search");
			search.addActionListener(this);
			search.setSize(75,40);
			back = new JButton("Backward");
			back.addActionListener(this);
			back.setSize(75,40);
			forward = new JButton("Forward");
			forward.addActionListener(this);
			forward.setSize(75,40);
			cancel = new JButton("Cancel");
			cancel.addActionListener(this);
			cancel.setSize(75,40);
			back.setEnabled(false);
			forward.setEnabled(false);
			
			//Establecer valores de Jtexts
			
			isbn = new JTextField();
			isbn.setEditable(false);
			authorName = new JTextField();
			authorName.setEditable(false);
			title = new JTextField();
			title.setEditable(false);
			pages = new JTextField();
			pages.setEditable(false);
			genre = new JTextField();
			genre.setEditable(false);
			
			// Añadir todo
			
			searchPanel.add(new JLabel("Author:"));
			searchPanel.add(authorList);
			searchPanel.add(new JLabel("Genre:"));
			searchPanel.add(genreList);
			searchPanel.add(search);

			resultPanel.add(new JLabel("Title:"));
			resultPanel.add(title);
			resultPanel.add(new JLabel("Author:"));
			resultPanel.add(authorName);
			resultPanel.add(new JLabel("ISBN:"));
			resultPanel.add(isbn);
			resultPanel.add(new JLabel("Pages:"));
			resultPanel.add(pages);
			resultPanel.add(new JLabel("Genre:"));
			resultPanel.add(genre);
			
			movePanel.add(back);
			movePanel.add(forward);
			movePanel.add(cancel);
			
			searchBook.add(searchPanel);
			searchBook.add(resultPanel);
			searchBook.add(movePanel);
			
			arrayPos = 0;
			
			searchBook.setVisible(true);
			
			
		} catch (AuthorException e) {
			JOptionPane.showMessageDialog(modifyAuthor, "No hay ningun autor");
			searchBook.dispose();
		}
		
		
	}
	
	private void getMatchingBooks() {
		
		// Devovler array segun genero y autor
		arrayPos = 0;
		matchBooks = bookControl.getBookArray((Author)authorList.getSelectedItem(), (String)genreList.getSelectedItem());
		back.setEnabled(false);
		forward.setEnabled(false);
		
	}
	
	//TODO: add custom exception
	private void updateFields() throws MatchingException {
		
		if (arrayPos == 0 && matchBooks.size() < 2) {
			back.setEnabled(false);
			forward.setEnabled(false);
		} else if (arrayPos >= matchBooks.size()-1) {
			forward.setEnabled(false);
			back.setEnabled(true);
		} else if (arrayPos == 0) {
			back.setEnabled(false);
			forward.setEnabled(true);
		} else {
			back.setEnabled(true);
			forward.setEnabled(true);
		}
		
		if (matchBooks.size() == 0) {
			throw new MatchingException((Author)authorList.getSelectedItem(),(String)genreList.getSelectedItem());
		}
		
		Book currentBook = matchBooks.get(arrayPos);
		
		title.setText(currentBook.getTitulo());
		authorName.setText(currentBook.getAutor().getName());
		isbn.setText(Integer.toString(currentBook.getIsbn()));
		pages.setText(Integer.toString(currentBook.getPaginas()));
		genre.setText(currentBook.getGenero());
		
	}
	
	private void setEmptyFields() {
		
		title.setText("");
		authorName.setText("");
		isbn.setText("");
		pages.setText("");
		genre.setText("");
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		try {
		
			if (e.getSource() == search) {
				
				getMatchingBooks();
				updateFields();
				
			} else if (e.getSource() == back) {
			
				arrayPos--;
				updateFields();
				
			} else if (e.getSource() == forward) {
				
				arrayPos++;
				updateFields();
				
			} else if (e.getSource() == cancel) {
				
				searchBook.dispose();
				
			}
		//Custom exception
		} catch (MatchingException e1) {
			e1.toString();
			JOptionPane.showMessageDialog(searchBook, "No hay ningun libro de esta combinacion");
			setEmptyFields();
		}
		
	}

}
