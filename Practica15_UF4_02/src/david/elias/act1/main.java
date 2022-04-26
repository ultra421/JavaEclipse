package david.elias.act1;

import java.util.Scanner;

public class main {
	
public static void main (String [] args) {
		
		// Scanner para nombre del cliente
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el nombre del cliente:");
		String nombreCliente = scan.next();
		
		// Nueva cuenta con el nombre del cliente
		
		Banca banca = new Banca(new Cuenta(nombreCliente)); // Crear Banca con nueva cuenta creada con el nombre del cliente
		boolean on = true;
		
		while (on) { // Boolean variable para bucle para poder desactivar en opcion de salir
			
			System.out.println("1- Crear nueva cuenta \n2- Añadir dinero \n3- Retirar dinero \n4- Consultar \n0-Salir ");
			
			switch (scan.nextInt()) {
			
				case 0: // opcion de salir
					
					System.out.println("Gracias por su visita");
					on = false;
					break;
					
				case 1: // Creara nuevo objeto cuenta con el nombre que se introduzca
					
					System.out.println("Introduce el nombre de la nueva cuenta");
					String nuevaCuenta = scan.next();
					banca.setCuenta(new Cuenta(nuevaCuenta));
					break;
					
				case 2: // Añadira dinero a la cuenta
					
					System.out.println("Cuanto dinero quieres añadir?");
					banca.getCuenta().addDinero(scan.nextFloat());
					System.out.println("Dinero añadido");
					System.out.println(banca.getCuenta().toString());	
					
					break;
					
				case 3: // Retira dinero del a cuenta
					
					System.out.println("Cuanto dinero quieres retirar?");
					banca.getCuenta().delDinero(scan.nextFloat());
					System.out.println("Dinero retirado");
					System.out.println(banca.getCuenta().toString());	
					
					break;
					
				case 4: // Devuelve el nombre y el saldo de la cuenta
					
					System.out.println(banca.getCuenta().toString());	
					
					break;
			
			}
			
		}
		
	}


}
