package david.elias.program2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	static int pedirNumero() {
		
		while (true) {
		
			try {
				
				System.out.print("Escribe un numero:");
				Scanner scan = new Scanner(System.in);
				return scan.nextInt();
				
			} catch (NumberFormatException e) {
				System.out.println("Tienes que escribir un numero!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		}
		
	}
	
	public static void main (String args[]) {
		
		int suma = 0;
		
		try {
			
			for (int i = 0; i < 5; i++) {
				suma += pedirNumero();
			}
			
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("La suma es = " + suma);
		}
		
	}

}
