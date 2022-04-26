package main;

import java.util.Scanner;

public class Actividad02 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		float nota = 0;
		float notaInput;
		String notaLetra =null;
		
		System.out.println("Cuantos alumnos hay en la clase?");
		int alumnos = scanner.nextInt();
		for (int i = alumnos; i > 0; i--) {
			
			System.out.println("Introduce la nota del alumno " + ((alumnos+1)-i));
			notaInput = scanner.nextFloat();
			if (notaInput <= 10) {
				nota += notaInput;
			} else {
				System.out.println("Porfavor introduce una nota valida");
				i++;
			}
		} 
		
		float notaMedia = (nota/alumnos);
		System.out.println("La nota media de la clase es = " + notaMedia);
		
		if (notaMedia >= 0 && notaMedia < 3) {
			notaLetra = "E";
			
		} else if (notaMedia >= 3 && notaMedia < 5) {
			notaLetra = "D";
			
		} else if (notaMedia >= 5 && notaMedia < 6.5) {
			notaLetra = "C";
			
		} else if (notaMedia >= 6.5 && notaMedia < 9) {
			notaLetra = "B";
			
		} else if (notaMedia >= 9 && notaMedia <= 10) {
			notaLetra = "A";

			
		} System.out.println("La nota media de la classe en formato alfabetico es = " + notaLetra);
	}

}
