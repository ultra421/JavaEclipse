package david.elias.program2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
	
	/* La version del programa que pide el 3 tiene varios errores:
	 * 1- Scanner nunca tirara IOException o NumberFormatException, asi que es imposible capturar estas,
	 * aun asi por si acaso he añadido un catch final para capturar Exception general
	 * 2- El metodo pedirNumero nunca tirara una excepcion por defecto asi que es inutil que
	 * el metodo main capture excepciones, por esto, he hecho que el metodo pedirNumero tire
	 * una excepcion tipo NumberFormatException, esta sera capturada por el main y este parara el bucle
	 * 3- No podemos mostrar el resultado en el bloque finally ya que este tambien se ejecutara cuando
	 * se capture el error, asi que lo muestro dentro del try y elimino el finally
	 * */

	static int pedirNumero() throws NumberFormatException {

		while (true) {

			try {

				System.out.print("Escribe un numero:");
				Scanner scan = new Scanner(System.in);
				return scan.nextInt();

			} catch (InputMismatchException e) {
				throw new NumberFormatException();
			} catch (Exception e) {
				throw new NumberFormatException();
			}
		}

	}

	public static void main(String args[]) {

		int suma = 0;
		
		for (int i = 0; i < 5; i++) {
	
			try {
	
				suma += pedirNumero();
				System.out.println("La suma es = " + suma);
	
			} catch (NumberFormatException e) {
	
				System.out.println("Programa detenido. Resultado final = " + suma);
				break;
	
			}
			
		}

	}

}
