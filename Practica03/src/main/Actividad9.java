package main;

import java.util.Scanner;

public class Actividad9 {

	public static void main(String[] args) {
		Scanner scannerInput = new Scanner(System.in);
		System.out.println("Dime la edad de una persona y te dire a que curso va");
		int edad = scannerInput.nextInt();
		
		if (edad <= 2) {
			System.out.println("La persona va a guarderia." + " Tiene una edad de " + edad + " a�os");
		
		} else if (edad >= 4 && edad <= 5) {
			System.out.println("La persona va a Educaci�n Infantil." + " Tiene una edad de " + edad + " a�os");
		
		} else if (edad >= 6 && edad <= 11) {
			System.out.println("La persona va a Educaci�n Primaria." + " Tiene una edad de " + edad + " a�os");
		
		} else if (edad >= 12 && edad <= 15) {
			System.out.println("La persona va a Educaci�n Secundaria." + " Tiene una edad de " + edad + " a�os");
		
		} else if (edad >= 16 && edad <= 17) {
			System.out.println("La persona va a Educaci�n Secundaria no obligatoria." + " Tiene una edad de " + edad + " a�os");
		
		} else if (edad >= 18) {
			System.out.println("La persona va a la Universidad/Otros." + " Tiene una edad de " + edad + " a�os");
		
		} else {
			System.out.println("Esta edad no es una edad valida para educaci�n." + " Tiene una edad de " + edad + " a�os");
		}

	} 

}
