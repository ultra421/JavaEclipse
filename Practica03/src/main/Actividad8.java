package main;

import java.util.Random;
import java.util.Scanner;

public class Actividad8 {

	public static void main(String[] args) {
		
		Scanner scannerInput = new Scanner(System.in);
		Random randomNumber = new Random();
		int random = randomNumber.nextInt((6)+3);
		
		int respuesta = 0;
		System.out.println("Puedes adivinar un numero entre el 3 y el 8?");
		
		while (random!=respuesta) {
			respuesta = scannerInput.nextInt();
			System.out.println("No has acertado vuelve a intentarlo");
		} System.out.println("Has acertado! El numero era " + random);
		
		 
	}

}
