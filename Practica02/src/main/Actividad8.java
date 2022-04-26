package main;

import java.util.Scanner;

public class Actividad8 {

	public static void main(String[] args) {
		
		System.out.println("Porfavor introduce cuatro numeros para sumarlos");
		
		Scanner scannerInput = new Scanner(System.in);
		
		System.out.println("Introduce el primer numero:");
		int num1 = scannerInput.nextInt();
		System.out.println("Introduce el segundo numero");
		int num2 = scannerInput.nextInt();
		System.out.println("Introduce el tercer numero");
		int num3 = scannerInput.nextInt();
		System.out.println("Introduce el cuarto numero");
		int num4= scannerInput.nextInt();
		
		System.out.println("El resultado de la suma es = " + (num1+num2+num3+num4));
		
		

	}

}
