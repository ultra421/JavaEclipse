package david.elias.program3;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	public static void main (String [] args) {
		
		ArrayList <Alumno> alumnos = new ArrayList<Alumno>();
		
		while (true) {
			
			Scanner scan = new Scanner(System.in);
			
			try {
				
				if (alumnos.size() > 5) { // Si alumnos > 5 tirar error, enviar info de cantidad a error
					throw new DemasiadosObjetos(alumnos.size());
				}
				
				System.out.println("Escribe el nombre del alumno");
				String nombre = scan.next();
				
				System.out.println("Escribe su edad");
				int edad = scan.nextInt();
				
				alumnos.add(new Alumno(nombre,edad)); // Si no se tira el error se añade un alumnno
				
			} catch (DemasiadosObjetos e) { // Print del error
				
				System.out.println(e.toString());
				
			}
			
		}
		
	}

}
