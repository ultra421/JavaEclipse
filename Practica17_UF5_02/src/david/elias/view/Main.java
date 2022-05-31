package david.elias.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		mainFrame.setSize(550,500);
		mainFrame.addWindowListener(this);
		mainFrame.setResizable(false);
		System.out.println("----Done!----");
		
		//Button set
		
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
		
		JPanel title = new JPanel();
		title.setSize(500,100);
		mainFrame.add(title);
		
		JLabel titleText = new JLabel("Library");
		titleText.setFont(new Font(Font.SANS_SERIF,Font.BOLD,22));
		title.add(titleText);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(500,400));
		buttonPanel.setOpaque(true);
		mainFrame.add(buttonPanel);
		
		buttonPanel.setLayout(new GridLayout(1,2,50,0));
		
		JPanel buttonsLeft = new JPanel();
		buttonsLeft.setSize(200,400);
		buttonsLeft.setLayout(new GridLayout(4,1,40,20));
		
		JPanel buttonsRight = new JPanel();
		buttonsRight.setSize(200,400);
		buttonsRight.setLayout(new GridLayout(4,1,40,20));
		
		buttonPanel.add(buttonsLeft);
		buttonPanel.add(buttonsRight);
		
		buttonsLeft.add(newAuthor);
		buttonsLeft.add(modifyAuthor);
		buttonsLeft.add(removeAuthor);
		
		buttonsRight.add(newBook);
		buttonsRight.add(modifyBook);
		buttonsRight.add(removeBook);
		buttonsRight.add(searchBook);
		
		mainFrame.setVisible(true);
		
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
