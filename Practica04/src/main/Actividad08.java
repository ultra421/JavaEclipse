package main;

import java.util.Scanner;
import java.util.Random;

public class Actividad08 {

	public static void main(String[] args) {
	
		Random rng = new Random();
		Scanner input = new Scanner(System.in);
		int aciertos = 0;
		int numeroAdivinar;
		
		System.out.println("Bingo: se han generado 3 numeros del 1 al 99, intenta adivinarlos ");
		
		int random[] = new int[3];
		
		for (int i = 0; i <= 2; i++) {
			
			random[i] = rng.nextInt((100)+1);
			
		}
		
		for (int i = 0; i <= 10; i++) {
			System.out.println("Escribe el numero " + (i+1));
			numeroAdivinar = input.nextInt();
			
			if (numeroAdivinar == random[0] || numeroAdivinar == random[1] || numeroAdivinar == random[2] ) {
				
				aciertos++;
			}
		}
		
		if (aciertos >= 1) {
			System.out.println("Bingo! Has acertado " + aciertos + " de los numeros");
		} else {
			System.out.println("Mala suerte, no has acertado ninguno de los numeros");
		}

	}

}
