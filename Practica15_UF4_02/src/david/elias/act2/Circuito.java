package david.elias.act2;

import java.util.Scanner;
import java.util.ArrayList;

public class Circuito {

	ArrayList<Interruptor> interruptores;
	
	// Lo he hecho en una ArrayList para poder guardar multiples interruptores

	Circuito() {
		interruptores = new ArrayList<Interruptor>();
		interruptores.add(new Interruptor());
		interruptores.add(new Interruptor());
	}

	public ArrayList<Interruptor> getInterruptores() {
		return interruptores;
	}

	public void setInterruptores(ArrayList<Interruptor> interruptores) {
		this.interruptores = interruptores;
	}

	public String printInterruptores() {

		String stringFinal = "";

		for (int i = 0; i < interruptores.size(); i++) {

			stringFinal += "Interruptor " + (i + 1) + "\n";

		}

		return stringFinal;

	}

	public void startMenu() {

		Scanner scan = new Scanner(System.in);
		int eleccion = 0; // Valor de eleccion para la array de interruptores

		do { // Escoger interruptor

			System.out.println("Escoge un interruptor (-1 para añadir un interruptor con su bombilla)");
			System.out.print(printInterruptores());
			eleccion = scan.nextInt();
			int eleccionCircuito; // Valor de eleccion dentro del interruptor
			
			if (eleccion == -1) { // Añadir interruptores
				interruptores.add(new Interruptor());
				System.out.println("Interruptor añadido");
			} 

			if (eleccion > 0 && eleccion <= interruptores.size()) { // Elegir interruptores, que este dentro de los limites
				
				while (true) { // Loop modificar -> Imprimir Status -> Menu -> Cambiar -> Salir/Repeat
					
					Interruptor currentIn = interruptores.get(eleccion-1); // Devuelve interuptor de la arraylist para llamar sus metodos
					System.out.println(currentIn.printBombillaStatus());
					System.out.println("Escoge una opcion\n1-Modificar estado\n0-Salir");
					eleccionCircuito = scan.nextInt(); // eleccion de salir/modificar

					if (eleccionCircuito == 1) { 
	
						currentIn.toggleBombilla();
						continue;
	
					} else if (eleccionCircuito == 0) {
						
						break;
						
					} else {
						continue;
					}
					
				}

			}

		} while (eleccion != 0);

	}

}
