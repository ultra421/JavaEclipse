package davidEliasUF2;

public class Colegio {

	public static void main (String[] args) {
		
		Profesor profesor = new Profesor();
		Alumno alumno1 = new Alumno("Antonio","aaaa");
		/*Alumno alumno2 = new Alumno();
		Alumno alumno3 = new Alumno();*/
		
		System.out.println(alumno1.verNombreAlumno());
		System.out.println(alumno1.test());
		
		
		
	}
	
}
