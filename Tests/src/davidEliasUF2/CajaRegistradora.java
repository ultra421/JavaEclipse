package davidEliasUF2;

public class CajaRegistradora {
	
	String nombre = "El antonio";
	String localizacion = "Calle antonio";
	float precio [];
	int cantidad [];
	
	public CajaRegistradora (int [] cantidad, float [] precio) {
		
		this.cantidad = cantidad;
		this.precio = precio;
		
	}
	
	float devolverPrecioTotal() {
		
		float total = 0;
		
		for (int i = 0; i < cantidad.length ; i++) {
			
			total += cantidad[i]*precio[i];
			
		}
		
		return total;
	}
	
}

