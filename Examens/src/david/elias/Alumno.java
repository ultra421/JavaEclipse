package david.elias;

public class Alumno {
	
	String nombre;
	String apellido;
	int edad;
	double [] notas;
	boolean ultimoAnyo;
	
	public Alumno () { // Constructor vacio
		
	}
	
	public Alumno (String nombre, String apellido, int edad, double [] notas, boolean ultimo) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.notas = notas;
		this.ultimoAnyo = ultimo;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public boolean isUltimo () {
		return ultimoAnyo;
	}
	
	public void setUltimo (boolean ultimo) {
		this.ultimoAnyo = ultimo;
	}
	
	public double getNotaMedia () {
		
		double nota = 0;
		
		for (int i = 0; i< notas.length; i++) { // Ira sumando cada nota al valor nota
			
			nota += notas[i];
			
		}
		
		return nota/notas.length; // Devuelve la media aritmetica (todas las notas/cantidad de notas)
		
	}
	
	public void showNotas () {
		
		System.out.println("Las notas de " + nombre + " " + apellido + " son:");
		
		for (int i = 0; i < notas.length; i++) { // Bucle de recorrer array de notas y imprimir
			
			System.out.println("Nota " + i + " = " + notas[i] );
			
		}
		
	}
	
	public void setNota (double nota, int modulo) {
		
		notas[modulo] = nota;
		
	}
	
	public String toString () {
		
		String notas = "";
		
		for (int i = 0; i < this.notas.length; i++) { // Guardar notas en una string
			
			notas += "Modulo " + (i+1) + ": " + this.notas[i] + "\n";
			
		}
		
		return "Nombre: " + nombre + " | Apellido: " + apellido + " | Edad: " + edad + " \n" + notas + "Nota media: " + this.getNotaMedia();
		
	}

}
