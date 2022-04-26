package main;

import java.util.Scanner;

public class Actividad03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Escribe numeros que sean validos de la tabla ASCII y los convertire a letras. (Consejo: 32 = espacio)");
		
		while (scanner.hasNext()) {
			System.out.print((char) scanner.nextInt());
		}

	}

}
