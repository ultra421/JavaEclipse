package david.elias.exception;

public class AuthorException extends Throwable {

	// Texto que sera imprimido
	@Override
	public String toString () {
		return "No pueden haber dos autores con el mismo nombre y apellidos";
	}
	
}
