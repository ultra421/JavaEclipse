package main;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		System.out.println(10+(-2));
		
		Scanner scanner = new Scanner(System.in);
		float num1 = scanner.nextFloat();
		float num2 = scanner.nextFloat();
		
		System.out.println("Suma= " +(num1+num2));
		System.out.println("Resta= " +(num1-num2));
		System.out.println("Multiplicacion= " +(num1*num2));
		System.out.println("Division= " +(num1/num2));
		System.out.println("%= " +(num1%num2));
		
		

	}

}
