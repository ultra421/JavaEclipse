package main;

import java.util.Scanner;

public class Actividad10 {

	public static void main(String[] args) {
		
		System.out.println("Escribe 5 numeros, los que son positivos te dare su media, los negativos te dare su suma");
		Scanner scannerInput = new Scanner(System.in);
		
		int numInput = 0;
		int numPos = 0;
		float numMedia = 0;
		int numNega = 0;
		
		for ( int i = 0; i <= 4; i++) {
			numInput = scannerInput.nextInt();
			
			if (numInput >= 0) {
				numPos++;
				numMedia += numInput;
			
			} else {
				numNega += numInput;
			
			} if (numPos != 0) {
				System.out.println("Hay " + numPos + " numeros positivos, su media es: " + (numMedia/numPos) + ". La suma de los negativos es = " + numNega );
			} else {
				System.out.println("Hay" + numPos + "numeros positivos, no puedo hacer la media. La suma de los negativos es = " + numNega);
			}
		}
	}
		

}
