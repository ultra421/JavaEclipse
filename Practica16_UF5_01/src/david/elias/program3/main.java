package david.elias.program3;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	public static void main (String [] args) {
		
		ArrayList <Alumno> alumnos = new ArrayList<Alumno>();
		
		while (true) {
			
			Scanner scan = new Scanner(System.in);
			
			try {
				
				System.out.println("Escribe el nombre del alumno");
				String nombre = scan.next();
				
				System.out.println("Escribe su edad");
				int edad = scan.nextInt();
				
				if (alumnos.size() > 5) {
					throw new DemasiadosObjetos(alumnos.size());
				} else {
					alumnos.add(new Alumno(nombre,edad));
				}
				
			} catch (DemasiadosObjetos e) {
				
				System.out.println(e.toString());
				
			}
			
		}
		
	}

}
