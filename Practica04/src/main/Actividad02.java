package main;

public class Actividad02 {

	public static void main(String[] args) {
		
		int num1 = 1;
		int num2 = 0;
		int numMemoria = 0;
		for (int count = 10; count != 1; count--) {
			
			numMemoria = num1;
			num1 += num2;
			num2 = numMemoria;
			System.out.println(num1+ " ");
		}

	}

}
