package main;
import java.util.Random;

public class Actividad07 {

	public static void main(String[] args) {
		
		Random rng = new Random();
		
		int num = rng.nextInt(10000);
		int numDividido;
		int multiple = 4;
		numDividido = num;
		System.out.println("El numero aleatorio = " + num);
		
		
		do {
			
			numDividido /= multiple;
			
		} while ((numDividido % multiple) != 0);
		
		System.out.println("El numero es = " + numDividido);

	}

}
