package main;

import java.util.Scanner;
public class Actividad4 {

	public static void main(String[] args) {
		Scanner scannerInput = new Scanner(System.in);
		int pares = 0;
		int impares = 0;
		int numero = 0;
		
		//Extra: mantengo el valor de la suma de los numeros en la variable impares, al final asigno el valor
		//de la variable impares a la de numero, entonces calculo cuantos impares hay restandole a 4 la cantidad de pares
		
		System.out.println("Escribe cuatro numeros y dire cuales son pares o impares, tambien dare el resultado de la suma de los numeros");
		
		numero = scannerInput.nextInt();
		if (numero%2 == 0) {
		    pares++;
		} impares += numero;
		numero = scannerInput.nextInt();
		if (numero%2 == 0) {
		    pares++;
		} impares += numero;
		numero = scannerInput.nextInt();
		if (numero%2 == 0) {
		    pares++;
		} impares += numero;
		numero = scannerInput.nextInt();
		if (numero%2 == 0) {
		    pares++;
		} impares += numero;
		
		numero = impares;
		impares = (4 - pares);
		
		
		System.out.println("La suma total es " + numero + ". Hay " + pares + " numeros pares y " + impares + " numeros impares");
		
		
	}

}
