package davidElias;

import java.util.Arrays;
import java.util.Random;

public class Actividad06 {

	public static void main(String[] args) {
		
		Random rng = new Random();
		int array[] = new int[10];
		int numPequenyo[] = new int [2]; // numPequenyo[0] = numero | numPequenyo[1] = pos array
		int diferencias;
		for (int i = 0; i < array.length; i++) { // Asignacion array numeros aleatorios
			
			array[i] = rng.nextInt(10);
			System.out.print(array[i] + " ");
			
		} System.out.println("<- Array nums aleatorios");
		
		/* Buscara el numero mas pequeño de la array, y guardara cual es y su posicion en la array numPequenyo, al final
		 * el numero mas pequeño sera intercambiado con el numero que se encuentra en la posicion i */
		
		for (int i = 0; i < array.length; i++) {
			
			numPequenyo[0] = 10;
			diferencias = 0;
			
			for (int k = i; k < array.length; k++) {
			
				if (array[k] < numPequenyo[0]) {
					
					numPequenyo[0] = array[k];
					numPequenyo[1] = k;
					
				}
					
			}
			
			for (int k = 1; k < array.length; k++) { //Check si array ordenada
				
				if (array[k-1] > array[k] ) {
					
					diferencias++;
					
				}
				
			}
			
			if (diferencias == 0) { // Si ordenada -> break, hace que la array haga los bucles necesarios para ordenar y no hagas adicionales
				
				break;
				
			}
			
			array[numPequenyo[1]] = array[i];
			array[i] = numPequenyo[0];
			
			System.out.print(Arrays.toString(array));
			System.out.println(" <- Cambio del indice " + i + " con el numero en posicion " + numPequenyo[1] );
			
		}

	}

}
