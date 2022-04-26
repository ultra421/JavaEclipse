package davidElias;

import java.util.Scanner;

public class Actividad07 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Cuantas columnas?");
		int columnas = input.nextInt();
		System.out.println("Cuantas filas?");
		int filas = input.nextInt();
		
		System.out.println("Filas = " + filas + "     Columnas = " + columnas);
		
		String matriz[][] = new String[filas][columnas];
		
		for (int i = 0; i < filas; i++) { // Este bucle tiene los valores "k" y "i", que seran filas y columnas
			
			for (int k = 0; k < columnas; k++) { // El bucle llena la matriz de "x" y lo imprime
				
				matriz[i][k] = "x";
				
				System.out.print(matriz[i][k] + " ");
				
			}
			
			System.out.println();
			
		}
		
		input.close(); // Cerrar scanner

	}

}
