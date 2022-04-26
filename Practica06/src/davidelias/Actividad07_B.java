
//Esta version del ejercicio pide la contraseña letra por letra y te dice los errores actuales cada vez que escribes una.

package davidelias;

import java.util.Scanner;

public class Actividad07_B {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); String pass = ""; boolean passValida = false;
		char check = ' ';
		
		
		do {
			
		System.out.println("Introduce una constraseña que cumpla las siguientes condiciones: \n -Tiene que tener 4 digitos \n -Debe tener letras y numeros \n -No puede tener caracteres que no sean letras o numeros");
		
		//pass = input.next();
		
		System.out.println("Contraseña actual: " + pass);
		
		int numeros = 0; int letras = 0;
		
		pass += input.next().charAt(0);
		
		if (pass.length() < 4) { // Longitud
			
			passValida = false;
			
			System.out.println("Contraseña invalida, no cumple la longitud necesaria.");
			
		}
		
		for (int i = pass.length()-1; i >= 0; i--) {
			
			check = pass.charAt(i);
			
			if ((int)check >= 48 && (int)check <=57 ) {
				numeros++;
				passValida = true;
			} else if ((((int)check >= 65 && (int)check <=90) || (((int)check >= 97 && (int)check <= 122))) ) {
				letras++;
				passValida = true;
			} else {
				passValida = false;
				System.out.println("Contraseña invalida, incluye caracteres no permitidos");
			}
		
		}
		
		if ((numeros >= 1 && letras >= 1) && (numeros+letras) == 4 ) {
			passValida = true;
		} else {
			passValida = false;
			System.out.println("Contraseña invalida, no combina suficientes numeros y letras");
		}
		
		
		} while (passValida != true);
		
		System.out.println("Contraseña valida, has introducido: " + pass);
		
	}

}
