package main;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Actividad11 {

	public static void main(String[] args) {
		Scanner scannerInput = new Scanner(System.in);
		LocalDate cumpleanyos = LocalDate.of(2003, 06, 20);
		
		System.out.println("Tu fecha de nacimiento es: " + cumpleanyos);
		System.out.println("Cuantos a�os le sumo?");
		int anyosSumados = scannerInput.nextInt();
		
		System.out.println("Cuantos dias le sumo?");
		int diasSumados = scannerInput.nextInt();
		
		cumpleanyos = cumpleanyos.plusYears(anyosSumados);
		cumpleanyos = cumpleanyos.plusDays(diasSumados);
		System.out.println("Tu cumplea�os seria el " + cumpleanyos); 

		// Si los dias hacen que pase un mes la fecha cambia correctamente

	}

}
