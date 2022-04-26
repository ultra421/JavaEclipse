package main;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


public class Test1 {

	public static void main(String[] args) {
		Scanner scannerInput = new Scanner(System.in);
		System.out.println("Introduce tu año de nacimiento, mes y dia en ese orden");
		LocalDate fechaNacimiento = LocalDate.of(scannerInput.nextInt(), scannerInput.nextInt(), scannerInput.nextInt());
		LocalDate fechaCumple = LocalDate.of(2021, fechaNacimiento.getMonth(), fechaNacimiento.getDayOfYear());
		System.out.println("Quedan " + ChronoUnit.DAYS.between(fechaCumple, LocalDate.now()) + "Dias hasta tu cumpleaños");
		
		
	}

}
