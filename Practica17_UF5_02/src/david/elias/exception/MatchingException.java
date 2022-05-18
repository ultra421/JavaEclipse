package david.elias.exception;

import david.elias.model.Author;

public class MatchingException extends Throwable{

	Author author;
	String genero;
	
	public MatchingException(Author author, String genero) {
		
		this.author = author;
		this.genero = genero;
		
	}
	
	public String toString() {
		return "No hay ninguna combinacion que cumpla con los siguientes requisitos:";
	}
	
}
