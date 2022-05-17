package david.elias.exception;

public class BookException extends Throwable {
	
	public String toString () {
		
		return "No pueden haber dos autores con el mism nombre";
		
	}

}
