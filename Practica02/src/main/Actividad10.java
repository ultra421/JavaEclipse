package main;

import java.util.Random;
import java.util.Scanner;

public class Actividad10 {

	public static void main(String[] args) {
		Random randomNumber = new Random();
		Scanner scannerInput = new Scanner(System.in);		
		System.out.println("Introduce un numero del 0 al 9. El programa elegiria un numero aleatorio, buena suerte.");
		
		int numeroRandom = randomNumber.nextInt(10);
		int userRandom = scannerInput.nextInt();
		
		if (numeroRandom == userRandom) {
			System.out.println("El numero aleatorio era = " + numeroRandom + " Felicidades, has acertado!");
		} else {
			System.out.println("El numero aleatorio era = " + numeroRandom + " No has acertado");
		}

	}

}
