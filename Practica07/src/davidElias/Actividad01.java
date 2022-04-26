package davidElias;

import java.util.Random;

public class Actividad01 {

	public static void main(String[] args) {
		
		int [] array1 = new int [8];
		int [] array2 = new int [8];
		int [] and = new int [8];
		
		Random rng = new Random();
		
		for (int i = 0; i < array1.length; i++) { // Genera 2 arrays de 8 posiciones con numeros aleatorios entre 0 y 1
			
			array1[i] = rng.nextInt(2);
			array2[i] = rng.nextInt(2);
			
		}
		
		
		for (int i = 0; i < array1.length; i++) {
			
			// Si la misma posicion de las dos arrays son un 1, cambia la posicion equivalente de la array and a un 1,
			// sino, es un 0
		
		
			 if (array1[i] == 1 && array2 [i] == 1) { 
				 
				 and[i] = 1;
				 
			 } else {
				 
				 and [i] = 0;
				 
			 }
		
		}
		
		//Imprimir arrays
		
		for (int i = 0; i < and.length; i++) {
			
			System.out.print(array1[i] + " ");
			
		} System.out.println("<- Array1");
		
		for (int i = 0; i < and.length; i++) {
			
			System.out.print(array2[i] + " ");
			
		} System.out.println("<- Array2");
		
		for (int i = 0; i < and.length; i++) {
			
			System.out.print(and[i] + " ");
			
		}
 	}

}
