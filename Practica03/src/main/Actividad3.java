package main;

import java.util.Scanner;

public class Actividad3 {

	public static void main(String[] args) {
		Scanner scannerInput = new Scanner(System.in);
		System.out.println("Introduce 5 notas y dire cuales estan aprobadas, suspendidas o acondicionadas");
		float nota1 = scannerInput.nextFloat();
		float nota2 = scannerInput.nextFloat();
		float nota3 = scannerInput.nextFloat();
		float nota4 = scannerInput.nextFloat();
		float nota5 = scannerInput.nextFloat();
		
		int aprobados = 0;
		int suspendidos = 0;
		int acondicionados = 0;
		
		//Nota1
		if (nota1 >= 5) {
			aprobados+= 1;
		} else if (nota1 < 5  && nota1 >= 4) {
			acondicionados += 1;
		} else if (nota1 < 4) {
			suspendidos += 1;
		}
		//Nota2
		if (nota2 >= 5) {
			aprobados+= 1;
		} else if (nota2 < 5 && nota2 >= 4) {
			acondicionados += 1;
		} else if (nota2 < 4) {
			suspendidos += 1;
		}
		//Nota3
		if (nota3 >= 5) {
			aprobados+= 1;
		} else if (nota3 < 5  && nota3 >= 4) {
			acondicionados += 1;
		} else if (nota3 < 4) {
			suspendidos += 1;
		}
		//Nota4
		if (nota4 >= 5) {
			aprobados+= 1;
		} else if (nota4 < 5  && nota4 >= 4) {
			acondicionados += 1;
		} else if (nota4 < 4) {
			suspendidos += 1;
		}
		//Nota5
		if (nota5 >= 5) {
			aprobados+= 1;
		} else if (nota5 < 5  && nota5 <= 4) {
			acondicionados += 1;
		} else if (nota5 < 4) {
			suspendidos += 1;
		}
		System.out.println("Hay " + aprobados + " aprobados | Hay " + acondicionados + " condicionados | Hay " + suspendidos + " suspendidos.");
	}

}
