package main;

import java.util.Scanner;

public class Actividad03 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		float precio = 0;
		precio = 30;
			
		System.out.println("Introduce los kilometros: ");
		int km = scanner.nextInt();
			
		for (int i = (km-300); i > 0; i--) {
			if (i > 700) {
				precio += 0.18f;
				precio = Math.round(precio * 100)/100f;
			} else if (i <= 700) {
				precio += 0.2;
				precio = Math.round(precio * 100)/100f;
			} 

		}
		
		System.out.println("Precio: " + precio + "€");
		
	}

}
