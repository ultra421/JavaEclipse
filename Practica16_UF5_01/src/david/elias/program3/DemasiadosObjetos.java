package david.elias.program3;

public class DemasiadosObjetos extends Throwable {
	
	int cantidad;
	
	public DemasiadosObjetos(int a) {
		
		this.cantidad = a;
		
	}
	
	// Texto que sera imprimido
	@Override
	public String toString () {
		return "Hay demasiados objetos! Cantidad de objetos: " + cantidad;
	}

}
