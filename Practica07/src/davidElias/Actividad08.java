package davidElias;

import java.util.Random;

public class Actividad08 {

	public static void main(String[] args) {
		
		Random rng = new Random();
		
		int columnas = 5;
		int filas = 5;
		
		int matriz[][] = new int[filas][columnas];
		int matrizTraspuesta[][] = new int[filas][columnas];
		
		System.out.println("Matriz: " + matriz.length);
		
		for (int i = 0; i < matriz.length; i++) {
			
			for (int k = 0; k < matriz[0].length; k++) {
				
				matriz[i][k] = rng.nextInt(10);
				System.out.print(matriz[i][k] + " ");
				
			}
			
			System.out.println();
			
		}
		
		//Una matriz traspuesta intercambia las coordenadas verticales con las horizontales.
		//El programa imprime la array de la misma manera
		
		System.out.println("Matriz traspuesta:");
		
		for (int i = 0; i < matriz.length; i++) {
			
			for (int k = 0; k < matriz[0].length; k++) {
				
				matrizTraspuesta[i][k] = matriz[k][i];
				System.out.print(matrizTraspuesta[i][k] + " ");
				
			}
			
			System.out.println();
			
		}	
	
	}

}
