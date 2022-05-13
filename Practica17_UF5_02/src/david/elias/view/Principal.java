package david.elias.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import david.elias.model.Author;
import david.elias.model.Book;
import java.util.ArrayList;

public class Principal extends JFrame implements ActionListener {
	
	JButton newAuthor;
	JButton modifyAuthor;
	JButton removeAuthor;
	JButton newBook;
	JButton modifyBook;
	JButton removeBook;
	JButton searchBook;
	ArrayList<Book> Books = new ArrayList<Book>();
	
	public Principal () {
		
		setLayout(new FlowLayout());
		setSize(500,500);
		setButtons();
		setVisible(true);
		
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
			add(botones[i]);
			
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == newAuthor) {
			
			new NewAuthor();
			
		} else if (e.getSource() == modifyAuthor) {
			
			new ModifyAuthor();
			
		} else if (e.getSource() == removeAuthor) {
			
		} else if (e.getSource() == newBook) {
			
		} else if (e.getSource() == modifyBook) {
			
		} else if (e.getSource() == removeBook) {
			
		} else if (e.getSource() == searchBook) {
			
		}
		
	}
	
	public static void main (String args[]) {
		
		Principal principal = new Principal();
		
	}

}
