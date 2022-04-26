package main;

import java.util.Scanner;

public class Actividad2 {

	public static void main(String[] args) {
		Scanner scannerInput = new Scanner(System.in);
		System.out.println("Escribe tres numeros y dire cual es el mas grande");
		int num1 = scannerInput.nextInt();
		int num2 = scannerInput.nextInt();
		int num3 = scannerInput.nextInt();
		int numeroGrande = 0;
		
		if (num1 >= num2) {				// Numero 1 mas grande que 2 despues comparar si 1 mas grande que 3
			if (num1 >= num3) {
				numeroGrande = num1;
			} else if (num1 <= num3) {
				numeroGrande = num3;
			}
	
		} else if (num1 <= num2) {		// Numero 2 mas grande que 1 despues comparar si 2 es mas grande que 3
			if (num2 >= num3) {
				numeroGrande = num2;
			} else if (num2 <= num3) {
				numeroGrande = num3;
			}
		} System.out.println("El numero mas grande es el " + numeroGrande);
		

	}

}
