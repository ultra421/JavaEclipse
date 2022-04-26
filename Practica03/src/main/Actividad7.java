package main;

import java.util.Scanner;

public class Actividad7 {

	public static void main(String[] args) {
		Scanner scannerInput = new Scanner(System.in);
		System.out.println("Escribe dos palabras y dire si son iguales");
		
		String string1 = scannerInput.next();
		String string2 = scannerInput.next();
		
		string1 = string1.toLowerCase();
		string2 = string2.toLowerCase();
		
		System.out.println(string1 + "\n" + string2);
		
		if (string1.equals(string2)) {
			System.out.println("Las dos palabras son iguales");
		} else {
			System.out.println("Las dos palabras no son iguales");
		}
		
		

	}

}
