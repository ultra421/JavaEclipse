package main;

import java.util.Scanner;

public class Actividad6 {

	public static void main(String[] args) {
		
		Scanner scannerInput = new Scanner(System.in);
		
		System.out.println("Dime tu nombre: ");
		String nombre = scannerInput.next();
		System.out.println("Dime tu edad: ");
		int edad = scannerInput.nextInt();
		System.out.println("Hola " + nombre + " de edad " + edad);
		

	}

}
