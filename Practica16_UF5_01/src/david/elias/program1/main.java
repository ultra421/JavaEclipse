package david.elias.program1;

import java.util.Scanner;

public class main {
	
	// Para comprovar que la String introducida para el nombre no contenga nombres he creado este metodo
	// Pasa caracter por caracter y utiliza el metodo isDigit de Character que devuelve true si es un numero

	static boolean hasNumber(String input) {

		for (int i = 0; i < input.length(); i++) {

			if (Character.isDigit(input.charAt(0))) {

				return true;

			}

		}

		return false;

	}

	public static void main(String[] args) {
		
		//Todos los bucles de introduccion estan true mientras haya menos de cinco errores
		
		int errores = 0;
		Alumno alumnos[] = new Alumno[2];
		System.out.println("Introduce los siguientes datos para dos alumnos");

		for (int i = 0; i < 2; i++) { // Bucle datos

			String nombre = "";
			int edad = 0;
			double altura = 0;

			while (errores < 5) { // Check nombre

				Scanner scan = new Scanner(System.in);
				System.out.println("Introduce el nombre");
				nombre = scan.next();

				if (!hasNumber(nombre)) { // si no tiene numero romper bucle
					break;
				} else {
					errores++;
					System.out.println("Introduce un nombre sin digitos");
				}

			}

			while (errores < 5) { // Check edad

				Scanner scan = new Scanner(System.in);
				System.out.println("Introduce la edad");

				// Scanner tira error si lo introducido no cumple con el formato de la variable
				
				try {
					
					edad = scan.nextInt();
					break;
					
				} catch (java.util.InputMismatchException e) {
					//Catchear error y sumar a la cantidad total
					errores++;
					System.out.println("Introduce una edad valida");
				}

			}

			while (errores < 5) { // Check altura
				
				// Lo mismo que edad

				Scanner scan = new Scanner(System.in);
				System.out.println("Introduce la altura");

				try {
					
					altura = scan.nextDouble();
					break;
					
				} catch (java.util.InputMismatchException e) {
					errores++;
					System.out.println("Introduce una altura valida");
				}

			}

			if (errores < 5) {
				alumnos[i] = new Alumno(nombre, edad, altura);
			} else {
				System.out.println("Te has equivocado 5 veces, cerrando programa...");
				break;
			}

		} // Fin bucle datos

	}

}
