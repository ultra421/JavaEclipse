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
import david.elias.exception.AuthorException;
import david.elias.model.Author;
import david.elias.model.Book;
import java.util.ArrayList;

public class Principal implements ActionListener, WindowListener {
	
	JButton newAuthor,modifyAuthor,removeAuthor,newBook,modifyBook,removeBook,searchBook;
	//author y book == a una array de los controladores <- Comparten referencia
	public static ArrayList<Book> books;
	public static ArrayList<Author> authors;
	public static AuthorController authorControl;
	public static BookController bookControl;
	public static JFrame mainFrame;
	
	public Principal () {
		
		buildVentana();
		
	}
	
	void buildVentana() {
		
		
		authors = new ArrayList<Author>();
		books = new ArrayList<Book>();
		//Añadira los autores existentes a la array
		authorControl = new AuthorController();
		//authorControl llena la array de Autores, entonces enviar a bookControl
		//Añadira los libros existentes a la array
		bookControl = new BookController(authors);	
		mainFrame = new JFrame("Biblioteca");
		mainFrame.setLayout(new FlowLayout());
		mainFrame.setSize(500,500);
		mainFrame.addWindowListener(this);
		setButtons();
		mainFrame.setVisible(true);
		System.out.println("----Done!----");
		
	}
	
	public void setButtons () {
		
		//TODO: Cambiar nombre final cuando este ordenado
		//Autor
		newAuthor = new JButton("Añadir Autor");
		modifyAuthor = new JButton("Editar Autor");
		removeAuthor = new JButton("Eliminar Autor");
		//Libro
		newBook = new JButton("Añadir libro");
		modifyBook = new JButton("Editar libro");
		removeBook = new JButton("Eliminar libro");
		searchBook = new JButton("Buscar libro");
		//Debug
		
		
		JButton botones [] = new JButton [7];
		
		botones[0] = newAuthor;
		botones[1] = modifyAuthor;
		botones[2] = removeAuthor;
		botones[3] = newBook;
		botones[4] = modifyBook;
		botones[5] = removeBook;
		botones[6] = searchBook;
		
		for (int i = 0; i < botones.length; i++) {
			
			botones[i].setSize(75,40);
			botones[i].addActionListener(this);
			mainFrame.add(botones[i]);
			
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
			
			new NewLibro();
			
		} else if (e.getSource() == modifyBook) {
			
			new ModifyLibro();
			
		} else if (e.getSource() == removeBook) {
			
			new RemoveLibro();
			
		} else if (e.getSource() == searchBook) {
			
			new SearchLibro();
			
		}
		
	}
	
	public static void main (String args[]) {
		
		Principal principal = new Principal();
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
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
