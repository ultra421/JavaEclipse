package main;

import java.util.Scanner;

public class Actividad04 {

	public static void main(String[] args) {
		int numeros = 0; int mayus = 0; int minis = 0; int simbolos = 0;
		
		Scanner scan = new Scanner(System.in);
		
		String secuencia = scan.nextLine();
		
		Scanner secuenciaScan = new Scanner(secuencia);
		
		while (secuenciaScan.hasNext()) {
			
			int num = secuenciaScan.nextInt();
			
			if (num >= 48 && num <= 57) {
				++numeros;
			}
			else if (num >= 65 && num <= 90) {
				++mayus;
			}
			else if (num >= 97 && num <= 122) {
				++minis;
			}
			else {
				++simbolos;
			}
		
		} System.out.println("Numeros: " + numeros + " Mayus: " + mayus + " Minisculas: " + minis + " Simbolos: " + simbolos); 
		

	}

}
