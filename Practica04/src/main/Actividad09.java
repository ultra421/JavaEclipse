package main;

import java.util.Scanner;

public class Actividad09 {

	public static void main(String[] args) {
		
		Scanner inputScanner = new Scanner(System.in);
		char input; int mayus = 0; int minus = 0; String stringInput;	
		
		
		do {	
		
			stringInput = inputScanner.next();
	
			if ((int)stringInput.charAt(0) >= 65 && (int)stringInput.charAt(0) <= 90) {
				mayus++;
			} else if ((int)stringInput.charAt(0) >= 97 && (int)stringInput.charAt(0) <= 122) {
				minus++;
			} else if (Integer.parseInt(stringInput) >= 65 && Integer.parseInt(stringInput) <= 90 ) {
				mayus++;
			} else if (Integer.parseInt(stringInput) >= 97 && Integer.parseInt(stringInput) <= 122 ) {
				minus++;
			}
		
		} while (mayus == 0);
		
		System.out.println("Has escrito " + minus + " minisculas antes de encontrar una mayuscula.");

	} 

}
