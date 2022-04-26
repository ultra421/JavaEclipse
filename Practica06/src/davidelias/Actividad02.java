package davidelias;

import java.util.Scanner;

public class Actividad02 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String letra = " "; String lastLetra = " "; boolean dosLetras = false;
		
		do {
			
			System.out.print("LETRA:");
			
			letra = input.next();
			
			if (letra.equals(lastLetra)) {
				
				dosLetras = true;
				
			}
			
			lastLetra = letra;
			
		} while ((int)letra.charAt(0) >= 65 && (int)letra.charAt(0) <= 90 );
		
		System.out.println(dosLetras);

	}

}
