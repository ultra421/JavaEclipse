package main;

import java.util.Scanner;

public class Actividad6 {

	public static void main(String[] args) {
		Scanner scannerInput = new Scanner(System.in);
		int numFinal = 0;
		System.out.println("Escribe 5 numeros y dire cuanto es la suma de los que son multiples de 3");
		for ( int i = 1; i <= 5; i++) {
			int num = scannerInput.nextInt();
			if ((num%3) == 0) {
				numFinal += num;
			}
		}
		
		System.out.println("La suma de los numeros es = " + numFinal );

	}

}
