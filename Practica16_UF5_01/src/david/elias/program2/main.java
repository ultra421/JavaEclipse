package david.elias.program2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static int pedirNumero() throws NumberFormatException {

		while (true) {

			try {

				System.out.print("Escribe un numero:");
				Scanner scan = new Scanner(System.in);
				return scan.nextInt();

			} catch (NumberFormatException e) {
				throw new NumberFormatException();
			} catch (InputMismatchException e) {
				throw new NumberFormatException();
			}
		}

	}

	public static void main(String args[]) {

		int suma = 0;
		
		for (int i = 0; i < 5; i++) {
	
			try {
	
				suma += pedirNumero();
	
			} catch (NumberFormatException e) {
	
				System.out.println("Resultado final = ");
				break;
	
			} finally {
				System.out.println("La suma es = " + suma);
			}
			
		}

	}

}
