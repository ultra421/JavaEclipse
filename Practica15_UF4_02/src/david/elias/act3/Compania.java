package david.elias.act3;
import java.util.ArrayList;
import java.util.Scanner;

public class Compania { 
	
	// Compañia estara compuesta por una arrayList de Telefonos
	// Dos constructores, predeterminado (vacio) tendra 2 numeros, otro constructor para cantidad personalziada
	
	ArrayList<Telefono> telefonos;
	
	Compania() {
		
		telefonos = new ArrayList<Telefono>();
		genTelefonos(2);
		
	}
	
	Compania(int cantidad) {
		
		telefonos = new ArrayList<Telefono>();
		genTelefonos(cantidad);
		
	}
	
	void genTelefonos (int cantidad) { // Bucle para generar telefonos segun la cantidad, añade nuevo telefono a arrayList
		
		System.out.println("Introduce los numeros:");
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce " + cantidad + " numeros");
		
		for (int i = 0; i < cantidad; i++) {
			
			System.out.print((i+1) + " - ");
			telefonos.add(new Telefono(scan.nextInt()));
			System.out.println("Registrado " + (telefonos.get(i).getNumero()));
			
		}
		
	}
	
	void enviarMensaje (Telefono telOrigen) { 
		
		// Enviar mensaje de telOrigen a currentTel, se le envia el telefono de origen
		// y solicitara el numero al que se le queire enviar el mensaje
		
		Scanner scan = new Scanner(System.in);
		System.out.println("A quien quieres enviar el mensaje?");
		System.out.print(printTelefonos());
		
		int eleccion = scan.nextInt();
		// Devuelve el telefono de la array de telefonos segun el numero
		Telefono currentTel = getTelefono(eleccion);
		
		System.out.println("Que quieres enviar?");
		scan.nextLine(); // Necesario para que funcione
		String mensaje = scan.nextLine();
		
		if (currentTel.sendMensaje(mensaje) && telOrigen.sendMensaje(mensaje)) { // sendMenasje devuelve true si se cumplen las condiciones de saldo y caracteres
			
			telOrigen.setSaldo(telOrigen.getSaldo()-5); // Reducir saldo a ambos
			currentTel.setSaldo(currentTel.getSaldo()-5);
			
			System.out.println("Mensaje enviado: " + mensaje + " de " + telOrigen.getNumero() + " a " + currentTel.getNumero());
			
		}
		
		/* TODO: sendMensaje imprime error en el propio metodo, cambiar esto? devolver mensaje envez de imprimir? habria que
		 * cambiar el return a String y comprovar la condicion con .equals de String */
		
	}
	
	Telefono getTelefono (int numero) {
		
		int numeroTel = -1;
		
		for (int i = 0; i < telefonos.size(); i++) {
			if (telefonos.get(i).getNumero() == numero) {
				numeroTel = i;
			}
		}
		
		if (numeroTel == -1 ) { // Si no existe crear nuevo numero y añadir a ArrayList, despues llamar a metodo y devolver otra vez numero
			addNum(numero);
			return getTelefono(numero);
		} else {
			return telefonos.get(numeroTel);
		}
		
	}
	
	String printTelefonos () { // Bucle para al final imprimir los telefonos que existen dentro de la array
		
		String result = "";
		for (int i = 0; i < telefonos.size(); i++) {
			
			result += "Telefono " + (i+1) + " " + telefonos.get(i).toString() + "\n";
			
		}
		
		return result;
		
	}
	
	void addNum(int numero) { // Añadir un numero
		telefonos.add(new Telefono(numero));
	}

}
