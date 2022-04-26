package main;
import java.util.Scanner;
import java.util.Random;

public class Actividad05 {

	public static void main(String[] args) {
		
		Random randomNumber = new Random();
		int sumaRandom = 0;
		
		for (int i = 0; i <=10 ; i++) {
			sumaRandom += randomNumber.nextInt(11);
		}
		
		System.out.println("La suma de los 10 numeros aleatorios es = " + sumaRandom);

	}

}
