package davidelias;

import java.util.Scanner;

public class Actividad01 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		char letra = ' '; String letrasJuntas = "";
		
		while (letra != 's' && letra != 'S') {
			
			System.out.print("Letra:");
			
			letra = input.next().charAt(0);

			letrasJuntas += letra;
			
		} System.out.println(letrasJuntas);

	}

}
