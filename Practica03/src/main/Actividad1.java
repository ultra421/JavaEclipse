package main;

import java.util.Scanner;

public class Actividad1 {

	public static void main(String[] args) {
		Scanner scannerInput = new Scanner(System.in);
		System.out.println("Introduce dos numeros y te dire cual es el mas grande");
		int num1 = scannerInput.nextInt();
		int num2 = scannerInput.nextInt();
		
		if (num1 > num2) {
			System.out.println("El numero " + num1 + " es mas grande que el " + num2);
		} else if (num1 < num2) {
			System.out.println("El numero " + num2 + " es mas grande que el " + num1);
		} else if (num1 == num2) {
			System.out.println("Los dos numeros son iguales");
		}

	}

}
