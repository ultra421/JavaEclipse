package david.elias;

public class Objeto {
	
	String tipo;
	int cantidad;
	
	Objeto (String tipo, int cantidad) {
		
		this.tipo = tipo;
		this.cantidad = cantidad;
		
	}
	
	public String toString () {
		
		return "Objeto -> " + this.tipo + " (Cantidad: " + cantidad + " )"; 
		
	}

}
