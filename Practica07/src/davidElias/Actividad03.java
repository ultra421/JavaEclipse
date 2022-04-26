package davidElias;

import java.util.Random;
import java.util.Scanner;

public class Actividad03 {

	public static void main(String[] args) {
		
		System.out.println("Introduce la longitud de la cadena de numeros.");
		
		Scanner input = new Scanner(System.in);
		int longitud = input.nextInt();
		
		Random rng = new Random();
		int array[] = new int[longitud];
		int mem = 0; int k = 0; int error = 0;
		
		for (int i = 0; i < array.length; i++) { // Genera array con numeros aleatorios entre 0 y 9
			
			array[i] = rng.nextInt(10);
			System.out.print(array[i] + " ");
		
		} System.out.println("<- Array original");
		
		do {
			
			error = 0; /* Esta variable cuenta los "errores" que hay en el orden de la array, 
						si no esta ordenada siempre sera mas de 1*/
			
			while (k < array.length-1) { /* Este bucle sigue mientras "k" sea mas pequeña que la longitud de la array -1
											ya que sino se saldria de los limites */
			
					if (array[k] > array [k+1]) { /* Para comprovar por parejas comparo la posicion actual con la
					 								 Posicion +1, si el numero en la posicion original es mas grande
					 								 cambio uno con el otro.*/
	
							mem = array[k+1];
							array[k+1] = array[k];
							array [k] = mem;
							
					}
					
				k += 2; // Para pasar a la siguiente pareja, sumo +2 a k (este bucle podria ser un for).
	
			
			} 
			
			for (int z = 0; z < array.length; z++) { // Comprovar que la array este ordenada
				
				if (z < array.length-1) {	
				
					if (array[z] > array[z+1]) {
							
							error++;
							
					}
						
				} System.out.print(array[z] + " ");
				
			} System.out.println();
			
			
			if (k%2 == 0) { // Asigno el valor de "k" a 0 o 1 depende de como haya estado anteriormente para cambiar
							// Entre parejas par e impar.
					
					k = 1;
					
			} else {
					
					k = 0;
				
			}
			
			
			
		} while (error > 0); // Si error es mas grande que 1 , la array no esta ordenada.
		
		input.close();

	}

}
