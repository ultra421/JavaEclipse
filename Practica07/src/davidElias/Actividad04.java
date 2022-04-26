package davidElias;

import java.util.Random;

public class Actividad04 {

	public static void main(String[] args) {
		
		Random rng = new Random();
		float suma = 0;
		
		float caja[][] = new float[2][12]; // Creacion de la array de la caja
		caja[0] = new float[] {50,20,10,5,2,1,0.50f,0.20f,0.10f,0.05f,0.02f,0.01f}; // Asignacion del valor de las monedas
		
		for (int i = 0; i < caja[0].length; i++) { // Imprimir valor billetes
			
			System.out.print(+ caja[0][i] + " ");
				
		} System.out.println();
		
		for (int i = 0; i < caja[0].length; i++) { // Generacion de los numeros aleatorios y imprmir cantidad
			
			caja[1][i] = rng.nextInt(21);
			System.out.print (caja[1][i] + " ");
			suma += (caja [1][i]*caja[0][i]); // El valor del billete se multiplica por la cantidad y se suma a "suma".
				
		} System.out.println();
	
		System.out.println("El resultado es = " + (Math.round(suma * 100.0f) / 100.0f) + "€"); 

	}

}
