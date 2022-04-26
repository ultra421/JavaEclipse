package david.elias.Humanoides;

public class Humanoide {
	
	String nombre;
	int salud;
	int saludMaxima;
	boolean vivo;
	
	Humanoide (String nombre, int saludMaxima) {
		
		this.nombre = nombre;
		this.salud = saludMaxima;
		this.saludMaxima = saludMaxima;
		vivo = true;
		
	}
	
	Humanoide (String nombre) {
		
		this.nombre = nombre;
		this.salud = 5;
		this.saludMaxima = 5;
		vivo = true;
		
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	public String getNombre() {
		return this.nombre;
	}

}
