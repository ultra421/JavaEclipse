package david.elias.act3;
import java.util.Scanner;

public class main {

	public static void main (String[] args) { // Imprimir menu
		
		Compania compTel = new Compania(); // Crear nueva compañia
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Elige tu numero de telefono");
		System.out.print(compTel.printTelefonos()); // print de todos los telefonos en la compañia
		int numero = scan.nextInt();
		Telefono currentTel = compTel.getTelefono(numero); // Numero de telefono elegido para operar
		
		while (true) {
			
			System.out.println("Numero de telefono actual: " + currentTel.getNumero());
			
			System.out.print("Elige una operacion:\n1- Enviar mensaje a otro telefono\n2- Aumentar saldo en 10\n3- Aumentar caracteres en 1"
					+ "\n4- Cambiar numero\n5- Añadir telefono\n0- Salir\nOperacion:");
			
			int eleccion = scan.nextInt();
			
			if (eleccion == 1) { // Send
				compTel.enviarMensaje(currentTel);
				
			} else if (eleccion == 2) { // Aumentar Sald
				currentTel.setSaldo(currentTel.getSaldo()+10);
				System.out.println("Saldo aumentado");
				
			} else if (eleccion == 3) { // Aumentar Car
				currentTel.setCaracteres(currentTel.getCaracteres()+1);
				System.out.println("Caracter aumentado");
				
			} else if (eleccion == 4) { // Cambiar numero
				System.out.println("A que numero quieres cambiar?");
				System.out.println(compTel.printTelefonos());
				currentTel = compTel.getTelefono(scan.nextInt()); // Da error outofbounds porque no comprueva, devuelve -1 si no existe
				System.out.println("Numero cambiado");
				
			} else  if (eleccion == 5) { // Añadir un telefono a la compañia
				System.out.println("Introduce el numero");
				compTel.addNum(scan.nextInt());
				
			} else {
				break;
			}
			
		}

	}

}
