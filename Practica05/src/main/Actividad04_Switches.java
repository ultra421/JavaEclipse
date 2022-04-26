package main;

import java.util.Scanner;

public class Actividad04_Switches {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		boolean valido = true; char inputChar; String model = "";
		
		do {
		System.out.println("Introduce el modelo del coche (A) o (B)");
			inputChar = input.next().toUpperCase().charAt(0);	
		
				if (inputChar != 'A' && inputChar != 'B') {
					valido = false;
					System.out.println("Introduce una letra valida");
				} else {
					model += String.valueOf(inputChar);
					valido = true;
				}
		
		} while (valido == false);
		
		do {
		System.out.println("Introduce el modelo del motor Electrico o Gasolina");	
			inputChar = input.next().toUpperCase().charAt(0);	
			
				if (inputChar != 'E' && inputChar != 'G') {
					valido = false;
					System.out.println("Introduce una letra valida");
				} else {
					model += String.valueOf(inputChar);
					valido = true;
				}
			
			} while (valido == false);
		do {
			
			if (model.charAt(1) == 'E') {
			
				System.out.println("Introduce el color del vehiculo Blanco o Otro");
				inputChar = input.next().toUpperCase().charAt(0);	 
				
				if (inputChar != 'B' && inputChar != 'O') {
					valido = false;
					System.out.println("Introduce una letra valida");
				} else {
					model += String.valueOf(inputChar);
					valido = true;
				}

					
			} else {
				System.out.println("Introduce el color del vehiculo Gris o Otro");
				
				inputChar = input.next().toUpperCase().charAt(0);
				
				if (inputChar != 'G' && inputChar != 'O') {
					valido = false;
					System.out.println("Introduce una letra valida");
				} else {
					model += String.valueOf(inputChar);
					valido = true;
				}
			}
					
			} while (valido == false);
	
		System.out.println(model);
		
		switch (model) {
		
		case "AEB":
			System.out.println("El precio es 233.24 €");
			break;
		case "AEO":
			System.out.println("El precio es 235.50 €");
			break;
		case "AGG":
			System.out.println("El precio es 340.10 €");
			break;
		case "AGO":
			System.out.println("El precio es 253.38 €");
			break;
		case "BEB":
			System.out.println("El precio es 251.32 €");
			break;
		case "BEO":
			System.out.println("El precio es 272.20 €");
			break;
		case "BGG":
			System.out.println("El precio es 351.14 €");
			break;
		case "BGO":
			System.out.println("El precio es 279.10 €");
			break;
		
		}
		
	}

}
