package davidEliasUF2;

public class Alumno {

	String nombre;
	String apellido;
	int nota;
	
	public Alumno (String nombre, String apellido){
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	int verNotasAlumno() {
		return nota;
	}
	
	String verNombreAlumno() {
		return nombre + " " + apellido;
	}
	
	boolean test() {
		return true;
	}
}
