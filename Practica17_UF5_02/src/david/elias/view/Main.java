package david.elias.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import david.elias.controller.AuthorController;
import david.elias.controller.BookController;
import david.elias.model.Author;
import david.elias.model.Book;
import java.util.ArrayList;

public class Main implements ActionListener, WindowListener {
	
	/* Initialize process 
	 * 1- Read authors and add to array
	 * 2- Read books and link to author array
	 * 3- Open window add all buttons */
	
	// Saves when the program closes
	
	JButton newAuthor,modifyAuthor,removeAuthor,newBook,modifyBook,removeBook,searchBook;
	//author & book == controller array (shared reference)
	public static ArrayList<Book> books;
	public static ArrayList<Author> authors;
	public static AuthorController authorControl;
	public static BookController bookControl;
	public static JFrame mainFrame;
	
	public Main () {
		
		buildWindow();
		
	}
	
	void buildWindow() {
		
		
		authors = new ArrayList<Author>();
		books = new ArrayList<Book>();
		//Add existing authors to array
		authorControl = new AuthorController();
		//authorControll fills authors, then send to bookControl
		//Add existing books to array
		bookControl = new BookController(authors);	
		mainFrame = new JFrame("Library");
		mainFrame.setLayout(new FlowLayout());
		mainFrame.setSize(500,500);
		mainFrame.addWindowListener(this);
		setButtons();
		mainFrame.setVisible(true);
		System.out.println("----Done!----");
		
	}
	
	public void setButtons () {
		
		//Author
		newAuthor = new JButton("New author");
		modifyAuthor = new JButton("Edit author");
		removeAuthor = new JButton("Delete author");
		//Book
		newBook = new JButton("Add book");
		modifyBook = new JButton("Modify book");
		removeBook = new JButton("Delete book");
		searchBook = new JButton("Search book");
		
		JButton buttons [] = new JButton [7];
		
		buttons[0] = newAuthor;
		buttons[1] = modifyAuthor;
		buttons[2] = removeAuthor;
		buttons[3] = newBook;
		buttons[4] = modifyBook;
		buttons[5] = removeBook;
		buttons[6] = searchBook;
		
		for (int i = 0; i < buttons.length; i++) {
			
			buttons[i].setSize(75,40);
			buttons[i].addActionListener(this);
			mainFrame.add(buttons[i]);
			
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == newAuthor) {
			
			new NewAuthor();
			
		} else if (e.getSource() == modifyAuthor) {
			
			new ModifyAuthor();
			
		} else if (e.getSource() == removeAuthor) {
			
			new RemoveAuthor();
			
		} else if (e.getSource() == newBook) {
			
			new NewBook();
			
		} else if (e.getSource() == modifyBook) {
			
			new ModifyBook();
			
		} else if (e.getSource() == removeBook) {
			
			new RemoveBook();
			
		} else if (e.getSource() == searchBook) {
			
			new SearchBook();
			
		}
		
	}
	
	@SuppressWarnings("unused")
	public static void main (String args[]) {
		
		Main principal = new Main();
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		//When this windows closes print every array to matching file
		
		System.out.println("Closing the window and trying to Save...");
		System.out.println("------Authors------");
		authorControl.printToFile();
		System.out.println("Authors saved!");
		System.out.println("------Books------");
		bookControl.printToFile();
		System.out.println("Books saved!");
		System.out.println("---------------");
		System.out.println("Everything saved succesfully!");
		
		System.exit(1);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		//No entra aqui
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
