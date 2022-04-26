
/* Esta es la version original del programa que hice, esta hecho a fuerza bruta, mira todas las posiblidades
comparando cada una de las variables y entonces las mueve a la posicion que deberian estar.*/

package main;

import java.util.Scanner;

public class Actividad5_Old {

	public static void main(String[] args) {
		
		Scanner scannerInput = new Scanner(System.in);
		
		
		int numPos1;
		int numPos2;
		int numPos3;
		int numMemoria;
		
		numPos1 = scannerInput.nextInt();
		numPos2 = scannerInput.nextInt();
		numPos3 = scannerInput.nextInt();
		
		//Pos1 = grande Pos3 = pequeño
		
		if (numPos1<numPos2) {
			if (numPos2>numPos3) {
				if (numPos3 > numPos1) {
					numMemoria = numPos1;
					numPos1 = numPos2;
					numPos2 = numPos3;
					numPos3 = numMemoria;
				} else {
					numMemoria=numPos1;
					numPos1= numPos2;
					numPos2= numMemoria;
				}
			} else {
				if (numPos2 > numPos1) {
					numMemoria = numPos1;
					numPos1 = numPos3;
					numPos3 = numPos1;
				} else {
					numMemoria = numPos2;
					numPos1 = numPos3;
					numPos2 = numPos1;
					numPos3 = numMemoria;
				}
			}
		} else {
			if (numPos1 > numPos3) {
				if (numPos2 > numPos3) {
					
				} else {
					numMemoria = numPos2;
					numPos2 = numPos3;
					numPos3 = numMemoria;
				}
					
			} else {
				if (numPos1 > numPos2) {
					numMemoria = numPos1;
					numPos1 = numPos3;
					numPos3 = numPos2;
					numPos2 = numMemoria;
					
				} else {
					numMemoria = numPos1;
					numPos1 = numPos3;
					numPos3 = numMemoria;
				}
			}
		
			} System.out.println("El orden es: " + numPos1 + " " + numPos2 + " " + numPos3);
		}
		
	

}
