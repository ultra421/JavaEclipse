package davidElias;

import java.util.Random;

public class Actividad02 {

	public static void main(String[] args) {
		
		Random rng = new Random();
		
		int[] array = new int[8]; int decimal = 0; int multiplicar = 128;
		
		for (int i = 0; i < array.length; i++) { // Array de 8 posiciones con numeros aleatorios entre el 0 y 1
			
			array[i] = rng.nextInt(2);
			System.out.print(array[i] + " ");
			
		}System.out.println(" | Array");
		
		for (int i = 0; i < array.length; i++) { 
			
			//La variable multiplicar es = 128 y se va dividiendo entre 2 cada bucle, asi que el primer numero sera
			//multiplicado por 128 y el segundo por 64 y asi continuamente
			
			decimal += array[i] * multiplicar;
			multiplicar /= 2;
			
		}
		
		System.out.println("Numero decimal: " + decimal);

	}

}
