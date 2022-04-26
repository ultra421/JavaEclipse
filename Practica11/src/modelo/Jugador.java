package modelo;

public class Jugador {
	
	String nombre;
	public String [] cartas;
	public Ciudad [] ciudades;
	int puntos;
	int cantidad;
	
	public Jugador (String nombre) {
		
		this.nombre = nombre;
		cartas = new String [10];
		ciudades = new Ciudad[10];
		puntos = 0;
		ciudades[0] = new Ciudad(this.getRandom2_12(),"madera");
		ciudades[1] = new Ciudad(this.getRandom2_12(),"piedra");
		cantidad = 2; //cantidad de ciudades ya que no se puede restar ciudades
		
	}
	
	public int getRandom2_12() {
		
		return (int)(Math.random()*(12-2) + 2);
		
	}
	
	public int contarCarta (String carta) { // Cuenta cuantas cartas tiene el jugador y deuvelve el numero
		
		int veces = 0;
		
		for (int i = 0; i < cartas.length && cartas[i] != null ; i++) {
			
			if (cartas[i].equals(carta)) {
				
				veces++;
				
			}
			
		}
		
		return veces;
		
	}
	
	public int getCantidadCartas () { // Develve la cantidad espacios que no son null en la array
		
		int veces = 0;
		
		for (int i = 0; i < cartas.length; i++) {
			
			if (cartas[i] != null) {
				
				veces++;
				
			}
			
		}
		
		return veces;
		
	}
	
	public int getCantidadCiudades () { // Develve la cantidad espacios que no son null en la array
		
		int veces = 0;
		
		for (int i = 0; i < ciudades.length; i++) {
			
			if (ciudades[i] != null) {
				
				veces++;
				
			}
			
		}
		
		return veces;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String [] getCartas() {
		return cartas;
	}
	
	public Ciudad [] getCiudades() {
		return ciudades;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void removeCarta (String carta, int cantidad) { // Escoge el primer espacio que no sea null y tenga el mismo nombre que el enviado y elimina esa carta y reduce la cantidad;
		
		for (int i = 0; i < cartas.length; i++) {
			
			if (cartas[i] != null) {
			
				if (cartas[i].equals(carta) && cantidad != 0) {
					
					cartas[i] = null;
					cantidad--;
					
				}
				
			}
			
		}
		
	}
	
	public boolean removeCarta (int key) { // Elimina la carta en la clave especificada
		
		if (key >= 1 && key < cartas.length && cartas[key] != null) {
		
			cartas[key] = null;
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public boolean addCarta (String carta) { // Añade la carta en el primer espacio vacio disponible
		
		for (int i = 0; i < cartas.length; i++) { // Devolver true si se ha añadido carta false si no
			
			if (cartas[i] == null) {
				
				cartas[i] = carta;
				return true;
				
			} else if (i == cartas.length-1) {
				
				return false;
				
			}
			
		}
		
		return false;
		
	}
	
	void addCiudad() {
		
		ciudades[cantidad] = new Ciudad();
		cantidad++;
		
	}
	void addCiudad(int num, String input) {
		
		ciudades[cantidad] = new Ciudad(num, input);
		cantidad++;
		
	}
}
