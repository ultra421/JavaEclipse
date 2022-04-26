package main;

import java.util.Random;

public class Actividad06 {

	public static void main(String[] args) {
		
		Random rng = new Random();
		int numeroRandom;
		int pares = 0, inpares = 0;
		
		do {
			
			numeroRandom = rng.nextInt((8)+3);
			
			if (numeroRandom % 2 == 0) {
				pares++;
			} else {
				inpares++;
			}
			
		} while (numeroRandom != 10);
		
		System.out.println("pares: " + pares + " inpares: " + inpares);

	}

}
