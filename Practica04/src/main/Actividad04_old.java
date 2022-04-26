package main;

import java.util.Scanner;

//Esta version del codigo es antes de que explicases como usar el Scanner para leer Strings
public class Actividad04_old {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Escribe una sequencia");
		
		String secuencia = scanner.nextLine();
		String [] separados = secuencia.split(" ");
		int [] separadosInt = new int [10];
		int numeros = 0;
		int mayus = 0;
		int minis = 0;
		int simbolos = 0;
		
		
		for (int x = 0; x <= 3; x++) {
			separadosInt[x] = Integer.parseInt(separados[x]);
		}
		
		for (int i = 0; i <= separados.length; i++) {
			System.out.println(separadosInt[i]);
			
			if (separadosInt[i] >= 48 && separadosInt[i] <= 57) {
				++numeros;
			}
			if (separadosInt[i] >= 65 && separadosInt[i] <= 90) {
				++mayus;
			}
			if (separadosInt[i] >= 97 && separadosInt[i] <= 122) {
				++minis;
			}
			else {
				++simbolos;
			}
		} System.out.println(" Numeros: " + numeros + " Mayus: " + mayus + " Minisculas: " + minis + " Simbolos: " + simbolos);

	}

}
