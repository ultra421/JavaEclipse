package main;

import java.util.Scanner;

public class Actividad5 {

	public static void main(String[] args) {
		Scanner scannerInput = new Scanner(System.in);
		
		System.out.println("Escribe 3 numeros y los ordenare de mas grande a mas pequeño");
		int x = scannerInput.nextInt();
		int y = scannerInput.nextInt();
		int z = scannerInput.nextInt();
		int numMemoria = 0;
		
		/* Las variables solo canviaran sus valores en 2 de los 3 ifs, ya que al saltarse por uno ya
		da suficente información para al siguiente. */
		
		if (x < y) { 
			numMemoria = x;
			x = y;
			y = numMemoria;
			System.out.println("Debug");
		}
		if (x < z) { 
			numMemoria = x;
			x = z;
			z = y;
			y = numMemoria;
			System.out.println("Debug");
		}
		if (z > y) { 
			numMemoria = y;
			y = z;
			z = numMemoria;
			System.out.println("Debug");
		
			
		} System.out.println("El orden es : " + x + " " + y + " " + z);

	}

}