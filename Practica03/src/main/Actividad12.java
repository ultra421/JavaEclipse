package main;

import java.util.Scanner;

public class Actividad12 {

	public static void main(String[] args) {
		String palabra;
		Scanner scanner = new Scanner(System.in);
		StringBuilder builder = new StringBuilder();
		String palabraFinal = null;
		
		System.out.println("Selecciona la funcion: \n 1- Invetir una palabra \n 2- Comparar dos palabras");
		switch (scanner.nextInt()) {
		
		case 1:  // Invertir 
			palabra = scanner.next();
			palabraFinal = inverser(palabra); 
			
			System.out.println("La palabra invertida es " + palabraFinal);
			break; 
			
		case 2: // Comparar
			palabra = scanner.next();
			String palabra2 = scanner.next();
			palabraFinal = inverser(palabra);
			
			if (palabra2.equals(palabraFinal)) {
					System.out.println("la palabra 1 es la inversa de la palabra 2");
			} else {
					System.out.println("La palabra 1 no es la inversa de la palabra 2");
			} break;
			
		default:
			System.out.println("No has escrito 1 ni 2, porfavor selecciona una opción valida");
		}

	} public static String inverser(String x) { // x = Palabra
		StringBuilder builder = new StringBuilder();
		String palabraFinal = null;
		
		int palabraLongitud = x.length();
		
		while (palabraLongitud > 0) {
		 palabraFinal = builder.append(x.charAt(palabraLongitud-1)).toString();
		 palabraLongitud += (-1);
		 
		 }
		return palabraFinal;
	}
	

}
