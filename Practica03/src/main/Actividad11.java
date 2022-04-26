package main;

import java.util.Scanner;

public class Actividad11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Escribe una palabra, dire si empieza por mayuscula o miniscula");
		String palabra = scanner.next();
		char primeraLetra = palabra.charAt(0);
		int asciiLetra = (int) primeraLetra;
		
		if (asciiLetra >= 65 && asciiLetra <=122) {
			if ((asciiLetra-32) >= 65) {
				System.out.println("Esta palabra empieza por miniscula");
			} else {
				System.out.println("Esta palabra empieza por mayuscula");
		    } 
		} else {
			System.out.println("Porfavor, escribe una palabra.");
		}
	}

}
