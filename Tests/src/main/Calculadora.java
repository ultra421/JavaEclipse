package main;

import java.util.Scanner;


public class Calculadora {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int on = 1;
		int resultado = 0;
		do {
			System.out.println("Calculadora\n1-Sumar\n2-Restar\n3-Multiplicar\n4-Dividir\noff-Apagar");
			
			switch(scanner.next()) {
			
			case "1":
				resultado = sumar(resultado);
				break;
			case "2":
				resultado = restar(resultado);
				break;
			case "3":
				resultado = multiplicar(resultado);
				break;
			case "4":
				break;
			case "off":
				on = 0;
				break;
			default:
				on = 0;
				break;
			} 
		} while (on == 1);
		
	}	public static int sumar(int a) {
		System.out.println("Escribe los numeros que quieras sumar, escribe + para seguir sumando");
		boolean calculating = true;
		int x = 0;
		while (calculating = true) {
			a += x;
			System.out.println(a);
			String input = scanner.next();
			if (input.contains("+")) {	
			} else { 
				calculating = false;
				break;
			} 
			input = input.replace("+","");
			x = Integer.parseInt(input);
		}
		System.out.println("Volviendo a menu / Numero guardado");
		return (a);
	
	}	public static int restar(int a) {
		System.out.println("Escribe los numeros que quieras restar, escribe - para seguir restar");
		boolean calculating = true;
		int x = 0;
		while (calculating = true) {
			a -= x;
			System.out.println(a);
			String input = scanner.next();
			if (input.contains("-")) {	
			} else { 
				calculating = false;
				break;
			} 
			input = input.replace("-","");
			x = Integer.parseInt(input);
		}
		System.out.println("Volviendo a menu / Numero guardado");
		return (a);
	
	}	public static int multiplicar(int a) {
		System.out.println("Escribe los numeros que quieras multiplicar, escribe * para seguir restar");
		boolean calculating = true;
		int x = 1;
		a = 1;
		while (calculating = true) {
			a= a * x;
			System.out.println(a);
			String input = scanner.next();
			if (input.contains("*")) {	
			} else { 
				calculating = false;
				break;
			} 
			input = input.replace("*","");
			x = Integer.parseInt(input);
		}
		System.out.println("Volviendo a menu / Numero guardado");
		return (a);
	}

} 
