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

public class AuthorController {
	
	ArrayList<Author> authors;
	File file;
	PrintWriter filePrint;
	FileReader fileRead;
	
	public AuthorController () {
		
		authors = new ArrayList<Author>();
		file = new File("authors.txt");
		checkExistFile();
		initWriterReader();
		readAuthors();
		
	}
	
	private void initWriterReader() {
		
		try {
			filePrint = new PrintWriter(new FileWriter(file,true));
			fileRead = new FileReader(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void checkExistFile() {
		
		if (!file.exists()) {
			
			try {
				file.createNewFile();
			} catch (IOException e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void addAuthor(Author input) throws AuthorException {
		
		if (checkExistAuthor(input)) {
			throw new AuthorException();
		}
		
		System.out.println("Recieved!: " + input.toString());
		filePrint.println(input.toString());
		filePrint.flush();
		
	}
	
	private boolean checkExistAuthor (Author input) {
		
		for (int i = 0; i < authors.size(); i++) {
			
			Author currentAuthor = authors.get(i);
			
			if (currentAuthor.getName().equals(input.getName()) &&
				currentAuthor.getSurname().equals(input.getSurname()) &&
				currentAuthor.getSurname2().equals(input.getSurname2())) {
				
			 return true;
				
			}
			
		}
		
		return false;
	}
	
	public void readAuthors () {
		
		Scanner scanFile;
		
		try {
			
			scanFile = new Scanner(file);
			
			while (scanFile.hasNextLine()) {
				
				String tempString = scanFile.nextLine();
				System.out.println("SCANNER INCREILE WOW:" + tempString); //TODO: Debug delet this
				String params[] = tempString.split("\\.");
				authors.add(new Author(params[0],params[1],params[2],params[3]));
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//TODO: debug delet this
		System.out.print(printAuthors());
		
	}

	public ArrayList<Author> getAuthors() {
		return authors;
	}
	
	//DEBUG
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
			
			if (tempAuthor.getName() == nombre &&
				tempAuthor.getSurname() == surname1 &&
				tempAuthor.getSurname2() == surname2) {
				
				return tempAuthor;
				
			}
			
		}
		
		return new Author();
		
	}
	
	public Author getAuthorById(int id) {
		
		return authors.get(id);
		
	}
	
	public String [] getAuthorList() throws AuthorException {
		
		String combo [] = new String [authors.size()];
		
		for (int i = 0; i < authors.size(); i++) {
			
			combo[i] = (authors.get(i).getName() + " " + authors.get(i).getSurname() + " " + authors.get(i).getSurname2());
			
		}
		
		if (combo.length == 0) {
			System.out.println("No authors"); //TODO: <- Delet dbug
			throw new AuthorException();
		} else {
			System.out.println("Yes autors");
			return combo;
		}
		
	}

}
