package david.elias.exception;

public class MatchingException extends Throwable {
	
	String genero;
	String autor;
	
	public String toString() {
		return "No hay ninguna combinacion entre " + genero.toString() + " y " + autor.toString();
	}

}
