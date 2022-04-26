package davidEliasUF2;

public class Profesor {
	
	int dni;
	int edad;
	String nombre;
	String apellido;
	
	String mostrarNombreCompleto() {
		return nombre + " " + apellido;
	}
	
	int mostrarEdad() {
		return edad;
	}
}
