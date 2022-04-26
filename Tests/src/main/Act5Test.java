package main;

import java.util.Scanner;

public class Act5Test {

	public static void main(String[] args) {
		Scanner scannerInput = new Scanner(System.in);
		
		System.out.println("Escribe 3 numeros y los ordenare de mas grande a mas pequeño");
		int x = scannerInput.nextInt();
		int y = scannerInput.nextInt();
		int z = scannerInput.nextInt();
		int numMemoria = 0;
		
		if (x < y) { // x(y) y(x) z(z)
			numMemoria = x;
			x = y;
			y = numMemoria;
		}
		if (x < z) { // x(z) y(y) z(x)
			numMemoria = x;
			x = z;
			z = y;
			y = numMemoria;
		}
		if (z > y) { // x(y) y(z) z(x)
			numMemoria = y;
			y = z;
			z = numMemoria;
		
			
		} System.out.println("El orden es : " + x + " " + y + " " + z);

	}

}
