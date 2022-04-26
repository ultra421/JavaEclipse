package main;

import java.util.Scanner;

public class Actividad01 {

	public static void main(String[] args) {
		
		System.out.println("Escribe una nota, te dire su nota alfabetica equivalente");
		
		Scanner input = new Scanner(System.in);
		boolean notaCorrecta = false;
		String notaLetra = null;
		
		while (notaCorrecta == false) {
			float nota = input.nextFloat();
			if (nota >= 0 && nota < 3) {
				notaLetra = "E";
				notaCorrecta = true;
				
			} else if (nota >= 3 && nota < 5) {
				notaLetra = "D";
				notaCorrecta = true;
				
			} else if (nota >= 5 && nota < 6.5) {
				notaLetra = "C";
				notaCorrecta = true;
				
			} else if (nota >= 6.5 && nota < 9) {
				notaLetra = "B";
				notaCorrecta = true;
				
			} else if (nota >= 9 && nota <= 10) {
				notaLetra = "A";
				notaCorrecta = true;
				
			} else {
				System.out.println("Escribe una nota valdia.");
			}
		} System.out.println("Nota: " + notaLetra);
		

	}

}
