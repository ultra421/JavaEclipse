package davidElias;

import java.util.Random;

public class Actividad05 {

	public static void main(String[] args) {
		
		int valores[] = new int[20]; int posPar = 0; int posImpar = 0; int numRandom; int suma = 0;
		Random rng = new Random();
		
		while (posPar < valores.length && posImpar < valores.length) {
			
			numRandom = rng.nextInt(9)+1;
			System.out.print(numRandom + " "); // Generacion de los numeros entre 1 y 9
			
			/*Las variables posImpar y posPar ya no tienen sentido ya que son de una version anterior del ejercicio
			  Los ifs compruevan si el numero generado es par o impar, cada vez que se entra a uno de ellos comprueva
			  que el otro sea 0, si este es 0 se le asigna el valor de 1, para que tenga todas las posiciones impares.
			  
			  El bucle while seguira mientras los 2 sean mas pequeños que la longitud de la array, cuando no se cumpla
			  una de estas condiciones el bucle para.*/
			
			if (numRandom % 2 == 0 && posImpar < valores.length) {
				
				valores[posImpar] = numRandom;
				if (posPar == 0) {
					posPar = 1;
				}
				posImpar += 2;
				suma += numRandom;
				
			} else  if (numRandom % 2 == 1 && posPar < valores.length) {
				
				valores[posPar] = numRandom;
				if (posImpar == 0) {
					posImpar = 1;
				}
				posPar += 2;
				suma += numRandom;
				
			}
			
		} System.out.println(" <- Numeros generados");
		
		//Print de la array de numeros ordneados.
		
		for (int i = 0; i < valores.length; i++) {
			
			if (valores[valores.length-1] == 0 && i == 19) {
			
				break;
				
			} else {
				
				System.out.print(valores[i] + " ");
				
			}
			
		} System.out.println("\nLa suma es = " + suma);

	}

}
