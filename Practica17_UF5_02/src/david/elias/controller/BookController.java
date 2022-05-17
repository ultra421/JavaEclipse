package david.elias.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import david.elias.exception.BookException;
import david.elias.model.Author;
import david.elias.model.Book;
import david.elias.view.Principal;

public class BookController {
	
	ArrayList <Author> authors;
	ArrayList <Book> books;
	File file;
	PrintWriter filePrint;
	FileReader fileRead;
	
	public BookController(ArrayList<Author> authors) {
		
		System.out.println("------Books------");
		this.authors = authors;
		System.out.println("Recieved authors from authorController!");
		this.books = Principal.books;
		file = new File("books.txt");
		System.out.println("Checking existing file...");
		checkExistFile();
		System.out.println("Reading books...");
		readBooks();
		System.out.println("Initiating printer");
		initWriterReader();
		
	}
	
	private void checkExistFile() {

		if (!file.exists()) {

			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
	
	private void initWriterReader() {

		try {
			filePrint = new PrintWriter(new FileWriter(file, true));
			fileRead = new FileReader(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void readBooks() {
		
		try {
			
			Scanner scanFile = new Scanner(file);
			
			while (scanFile.hasNextLine()) {
				
				String tempString = scanFile.nextLine();
				String params[] = tempString.split("\\.");
				//Pos		0		1		2		3	  	4,5,6,7
				//Campo | ISBN | TITULO | PAGINAS | GENERO | AUTOR
				//Tipo	  int	 String    int       String  Autor
			
				int isbn = Integer.parseInt(params[0]);
				String titulo = params[1];
				int paginas = Integer.parseInt(params[2]);
				String genero = params[3];
				
				Author autor = getAuthor(params[4],params[5],params[6]);
				
				Book bookToAdd = new Book(isbn,titulo,paginas,genero,autor);
				books.add(bookToAdd);
				
				//TODO: Debug
				System.out.println("Book read" + bookToAdd.toStringFile());
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private Author getAuthor(String nombre, String surname1, String surname2) {

		for (int i = 0; i < authors.size(); i++) {

			Author tempAuthor = authors.get(i); // devolver author find

			if (tempAuthor.getName().equals(nombre) && tempAuthor.getSurname().equals(surname1)
					&& tempAuthor.getSurname2().equals(surname2)) {

				return tempAuthor;

			}

		}

		System.out.println("Author couldn't be found with name" + nombre + surname1 + surname2);
		return new Author();

	}
	
	public void printToFile() {
		
		//Borrara T O D O el contenido del archivo (por alguna razon) pero es util
		// Primero borrar todo entonces escribir con el filePrint que no borra todo
		try {
			new FileWriter(file,false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < books.size(); i++) {
			
			Book currentBook = books.get(i);
			filePrint.println(currentBook.toStringFile());
			
		}
		
		filePrint.flush();
		
	}
	
	public void addBook(Book input) throws BookException {
		
		if (checkExistBook(input)) {
			throw new BookException();
		}
		
		System.out.println("Received!:" + input.toStringFile());
		books.add(input);
		
	}
	
	private boolean checkExistBook(Book input) {
		
		for (int i = 0; i < books.size(); i++) {
			
			Book currentBook = books.get(i);
			
			if (currentBook.getIsbn() == input.getIsbn()) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public ArrayList<Book> getBookArray(Author author, String genre) {
		
		ArrayList<Book> returnArray = new ArrayList<Book>();
		
		for (int i = 0; i < books.size(); i++) {
			
			Book currentBook = books.get(i);
			
			if (currentBook.getAutor() == author && currentBook.getGenero().equals(genre)) {
				
				returnArray.add(currentBook);
				
			}
			
		}
		
		return returnArray;
		
	}

}
