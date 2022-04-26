package main;

import java.util.Scanner;

public class Actividad05 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		char vehiculo; int km; int anyos; char socio; float precio = 0; float descuento = 0; int cuota = 0;
		
		/* Los bucles estan para comprovar que la respuestas son validas, mientras sean invalidas el bucles seguiran. */
		
		
		do {
		
			System.out.print("Kilometros: ");
			km = input.nextInt();
			
		}  while ( km <= 0);
		
		do {
			System.out.print("Vehiculo (C/M)");
			vehiculo = input.next().toUpperCase().charAt(0);
			
		} while (vehiculo != 'C' && vehiculo != 'M');
		
		
		do {
			System.out.print("Años Carnet:");
			anyos = input.nextInt();
		
		} while (anyos <= 0);
		
		do {
			System.out.print("Socio (S/N)");
			socio = input.next().toUpperCase().charAt(0);
		
		} while (socio != 'S' && socio != 'N');
		
		//Descuento socio
		
		if (socio == 'S' && anyos >= 10) {
			descuento = 0.85f;
		} else if (socio == 'S' && anyos < 10) {
			descuento = 0.95f;
		} else {
			descuento = 1;
		}
		
		//Descuento años carnet
	
		if (anyos <5) {
			cuota = 45;
		} else {
			cuota = 30;
		}
		
		//Calculos
		
		if (vehiculo == 'C') { // Coche
			
			if ((km - 1000) > 0) {
				precio += (cuota + ((700*0.2) + ((km-1000)*0.18)))*descuento;
			} else if (km < 300) {
				precio = cuota;
			} else {
				precio += (cuota + ((km-300)*0.2))*descuento;
			}
		} else { // Moto
			
			if ((km - 1000) > 0) {
				precio += (cuota + (700*0.1) + ((km-1000)*0.08))*descuento;
			} else if (km < 300) {
				precio = cuota;
			} else {
				precio += (cuota + ((km-300)*0.1))*descuento;
			}
		}
		System.out.print("Precio: " + precio + "€");

	}

}
