package main;

import java.util.Scanner;

public class Calculadora {
	
	public static void main(String[] args) {
		try (Scanner scannerInput = new Scanner(System.in)) {
			boolean on = true;
			
			while (on == true) {
			System.out.println("Calculadora\nSelecciona operacion");
			System.out.print("Sumar = 1\nResta = 2\nMultiplicar = 3\nDividir = 4\nOperacion seleccionada= ");
			int seleccion = scannerInput.nextInt(); // Suma
			
			
			if (seleccion == 1) {
				System.out.print("Suma: Escribe un numero para sumar = ");
				float numero1 = scannerInput.nextFloat();
				System.out.print("Suma: Escribe el siguiente numero para sumar =");
				float numero2 = scannerInput.nextFloat();
				float numeroResultado = numero1+numero2;
				System.out.print("El resultado es= " + numeroResultado);
			
			
			} else if (seleccion == 2)  { // Resta
				System.out.print("Resta: Escribe un numero para restar = ");
				float numero1 = scannerInput.nextFloat();
				System.out.print("Resta: Escribe el siguiente numero para restar =");
				float numero2 = scannerInput.nextFloat();
				float numeroResultado = numero1-numero2;
				System.out.print("El resultado es= " + numeroResultado);
			
			
			} else if (seleccion == 3) { // Multiplicar
				System.out.print("Multiplicar: Escribe un numero para multiplicar = ");
				float numero1 = scannerInput.nextFloat();
				System.out.print("Multiplicar: Escribe el siguiente numero para multiplicar =");
				float numero2 = scannerInput.nextFloat();
				float numeroResultado = numero1*numero2;
				System.out.print("El resultado es= " + numeroResultado);
			
			
			} else if (seleccion == 4) { // Dividir
				System.out.print("Dividir: Escribe un numero para dividir = ");
				float numero1 = scannerInput.nextFloat();
				System.out.print("Dividir: Escribe el siguiente numero para dividir =");
				float numero2 = scannerInput.nextFloat();
				float numeroResultado = numero1/numero2;
				System.out.print("El resultado es= " + numeroResultado);
			
			
			} else if (seleccion >= 5) {
				System.out.println("Porfavor introduce un numero valido");
			} else if (seleccion <= 0) {
				System.out.println("Porfavor introduce un numero valido");
			}
			System.out.println(" Apagar calculadora? Si = 1 | No = 0");
			int apagar = scannerInput.nextInt();
			if (apagar == 1) {
				on = false;	
			} else if (apagar == 0);{
				on = true; }
			}
		}
		}
		
	}

