package david.elias.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JComboBox;
import david.elias.exception.AuthorException;
import david.elias.model.Author;
import david.elias.view.Principal;

public class AuthorController {

	ArrayList<Author> authors;
	File file;
	PrintWriter filePrint;
	FileReader fileRead;

	public AuthorController() {

		System.out.println("------Authors------");
		this.authors = Principal.authors;
		file = new File("authors.txt");
		System.out.println("Checking existing file...");
		checkExistFile();
		System.out.println("Reading authors...");
		readAuthors();
		System.out.println("Initiating printer");
		initWriterReader();
		System.out.println("Trying to send bookControl the authors...");

	}

	private void initWriterReader() {

		// Plan: FileWriter en false elimina todo el contenido en true agrega
		// Al escribir, crear uno FileWriter a false para eliminar contenido entonces
		// Escribir con el actual
		
		try {
			filePrint = new PrintWriter(new FileWriter(file, true));
			fileRead = new FileReader(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

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

	public void addAuthor(Author input) throws AuthorException {

		if (checkExistAuthor(input)) {
			throw new AuthorException();
		}

		System.out.println("Recieved!: " + input.toStringFile());
		authors.add(input);

	}

	// Print on end
	public void printToFile() {
		
		//Borrara T O D O el contenido del archivo (por alguna razon) pero es util
		// Primero borrar todo entonces escribir con el filePrint que no borra todo
		try {
			new FileWriter(file,false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < authors.size(); i++) {

			Author currentAuthor = authors.get(i);
			filePrint.println(currentAuthor.toStringFile());

		}
		
		filePrint.flush();

	}

	private boolean checkExistAuthor(Author input) {

		for (int i = 0; i < authors.size(); i++) {

			Author currentAuthor = authors.get(i);

			if (currentAuthor.getName().equals(input.getName()) && currentAuthor.getSurname().equals(input.getSurname())
					&& currentAuthor.getSurname2().equals(input.getSurname2())) {

				return true;

			}

		}

		return false;
	}

	public void readAuthors() {

		Scanner scanFile;

		try {

			scanFile = new Scanner(file);

			while (scanFile.hasNextLine()) {
				
				String tempString = scanFile.nextLine();
				String params[] = tempString.split("\\.");
				authors.add(new Author(params[0], params[1], params[2], params[3]));

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// TODO: debug delet this
		System.out.print(printAuthors());

	}

	// DEBUG
	public String printAuthors() {

		String output = "";

		for (int i = 0; i < authors.size(); i++) {

			output += authors.get(i).toString() + "\n";

		}

		return output;

	}

	public Author getAuthor(String nombre, String surname1, String surname2) {

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

	public Author getAuthorById(int id) {

		return authors.get(id);

	}

	public void updateAuthor(Author input, String name, String surname, String surname2, String pais) {
		
		for (int i = 0; i < authors.size(); i++) {
			
			if (authors.get(i) == input) {
				
				Author tempAuthor = authors.get(i);
				
				tempAuthor.setName(name);
				tempAuthor.setSurname(surname);
				tempAuthor.setSurname(surname2);
				tempAuthor.setCountry(pais);
				break;
				
			}
			
		}
		
	}
	
	public void deleteAuthor(Author input) {
		
		if(authors.remove(input)) {
			
			System.out.println("Deleted succesfully");
			
		}
 		
	}

	public String[] getAuthorList() throws AuthorException { // TODO: maybe delet this

		String combo[] = new String[authors.size()];

		for (int i = 0; i < authors.size(); i++) {

			combo[i] = (authors.get(i).getName() + " " + authors.get(i).getSurname() + " "
					+ authors.get(i).getSurname2());

		}

		if (combo.length == 0) {
			System.out.println("No authors"); // TODO: <- Delet dbug
			throw new AuthorException();
		} else {
			System.out.println("Yes autors");
			return combo;
		}

	}

}
