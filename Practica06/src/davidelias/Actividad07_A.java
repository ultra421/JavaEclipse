
/*El dia de la entrega de la practica fui comprovando cada uno de los ejercicios, despues de leer el enunciado de este no estaba seguro de si lo que 
 * pedia era lo que yo habia hecho, asi que lo he separado en 2 versiones. Esta, la A, es la version original, mientras que la B es la modificada*/

//Esta version del ejercicio pide una contraseña de 4 caracteres, y entonces comprueva

package davidelias;

import java.util.Scanner;

public class Actividad07_A {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); String pass = ""; boolean passValida = false;
		char check = ' '; int numeros = 0; int letras = 0;
		
		
		do {
			
		System.out.println("Introduce una constraseña que cumpla las siguientes condiciones: \n -Tiene que tener 4 digitos \n -Debe tener letras y numeros \n -No puede tener caracteres que no sean letras o numeros");
		
		pass = input.next();

		
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
		
		if ((numeros >= 1 && letras >= 1) && (numeros+letras) == pass.length() ) {
			passValida = true;
		} else {
			passValida = false;
			System.out.println("Contraseña invalida, no combina suficientes numeros y letras");
		}
		
		
		} while (passValida != true);
		
		System.out.println("Contraseña valida, has introducido: " + pass);
		
	}

}
