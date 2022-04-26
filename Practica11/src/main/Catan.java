package main;
import java.util.Scanner;

import modelo.Jugador;
import modelo.Ciudad;

/* Documentare lo que hace cada metodo en el propio metodo */

// Hay una parte de la practica donde pide reiniciar la array de cartas materiales a todo null, he decidido eliminar las cartas necesarias envez de reinciar toda la array

public class Catan {
	
	Scanner scan = new Scanner(System.in);
	Jugador[] jugadores;
	
	public Catan () { 
		
		jugadores = new Jugador[4];
		
	}
	
	public void inicializarJugadores() { // Recorre la array de jugadores y crea uno nuevo con el nombre que se introduce
		
		System.out.println("Iniciando partida... Introduce 4 jugadores");
		
		for (int i = 0; i < 4; i++) {
			
			System.out.print("Introduce el nombre del jugador " + (i+1) + ": ");
			jugadores[i] = new Jugador(scan.next());
			System.out.println(jugadores[i].getNombre() + " registrado");
			
		}
		
	}
	
	void inicializarJugadores (int cantidad) { // Lo mismo que el anterior pero por si quieres introducir una cantidad de jugadores personalizada
		
		jugadores = new Jugador[cantidad];
		
		for (int i = 0; i < cantidad; i++) {
			
			System.out.print("Introduce el nombre del jugador " + (i+1) + ": ");
			jugadores[i] = new Jugador(scan.next());
			System.out.println(jugadores[i].getNombre() + " registrado");
			
		}
		
	}
	
	void nuevaPartida () { // Bucle de la partida, parara cuando un jugador llegue a las 10 ciudades y imprmira quien ha ganado
		
		inicializarJugadores();
		
		boolean partidaOn = true;
		int jugador = 0;
		
		while (partidaOn) {
				
			if (jugadores[jugador].getCantidadCiudades() == 10) {
					
				partidaOn = false;
				break;
					
			}
				
			turnoJugador(jugador);
				
			if (jugador == 3) {
				
					jugador = -1;	
			}
			
			jugador++;
			
		}
		
		System.out.println("Ha ganado: " + jugadores[jugador].getNombre());
		
	}
	
	void turnoJugador (int num) { // El menu de opciones del jugador, he decidido añadir opciones para ver tus ciudades con detalle y la cantidad de ciudades de los demas
		
		while (true) { // El bucle no parara mientras no se eliga una opcion valida o se tiren los dados
			
			System.out.println("Turno del jugador: " + (num+1) + " nombre: " + jugadores[num].getNombre());
		
			System.out.print("Escoge una opcion: \n1-Mostrar cartas \n2-Comprar ciudades \n3-Tirar dados\n4-Mostrar Ciudades\n5-Mostrar Jugadores");
			
			Jugador jugador = this.jugadores[num];
			
			switch (scan.nextInt()) {
			
			case 1:
				mostrarCartas(jugador);
				continue;
				
			case 2:
				comprarCiudades(jugador);
				continue;
			
			case 3:
				tirarDados(jugadores);
				break;
				
			case 4:
				mostrarCiudades(jugador);
				continue;
				
			case 5:
				mostrarJugadores(jugadores);
				continue;
				
			default:
				
				System.out.println("Introduce una opcion valida");
				continue;
				
			}
			
			this.jugadores[num] = jugador; // ya que creo una variable para que sea mas entendible el codigo tengo que devovler el valor al objeto original
			
			break;
		
		}
		
	}
	
	void mostrarJugadores (Jugador [] jugadores) { // Mostrar los nombres de los jugadores con sus ciudades, bucle que recorre la array
		
		for (int i = 0; i < jugadores.length; i++) {
			
			System.out.println("Jugador: " + jugadores[i].getNombre() + " id: " + (i+1) + " ciudades: " + jugadores[i].getCantidad());
			
		}
		
	}
	
	void mostrarCartas (Jugador jugador) { // Mostrar las cartas de los jugadores, dos fors para imprimir las IDs de las cartas y despues las cartas
		
		System.out.print("//	");
		
		for (int i = 0; i < jugador.cartas.length; i++) {
			
			if (jugador.cartas[i] != null) {
			
				System.out.print((i+1) + "	//	" );
			
			}
			
		}
		
		System.out.print("\n//	");
		
		for (int i = 0; i < jugador.cartas.length; i++) {
			
			if (jugador.cartas[i] != null) {
			
				System.out.print(jugador.cartas[i] + "	//	");
			
			}
			
		}
		
		System.out.println("\n");
		
	}
	
	void mostrarCiudades (Jugador jugador) { // Imprime le toString de cada ciudad
		
		for (int i = 0; i < jugador.getCiudades().length && jugador.getCiudades()[i] != null ; i++){
		
			System.out.println("Ciudad: " + (i+1) + " " + jugador.getCiudades()[i].toString());
			
		}
		
	}
	
	void comprarCiudades (Jugador jugador) { // Comprar una ciudad despues de comprovar que cumplan los requisitos
		
		if (jugador.contarCarta("madera") >= 2 && jugador.contarCarta("piedra") >= 2) {
			
			jugador.getCiudades()[jugador.getCantidad()] = new Ciudad();
												// POSICION
			jugador.removeCarta("madera", 2);
			jugador.removeCarta("piedra", 2);
			
		} else { 
			
			System.out.println("No tienes material suficiente para crear una ciudad");
			
		}
		
	}
	
	void tirarDados (Jugador[] jugadores) { // Tira numero random entre 2 y 12, dice cual sale y llama al metodo de recogerRecurso
		
		int randomNum = jugadores[0].getRandom2_12();
		System.out.println("Ha salido el: " + randomNum);
		
		System.out.println();
		
		for (int i = 0; i < jugadores.length; i++) {
			
			recogerRecurso(jugadores[i],randomNum);
			
		}
		
	}
	
	void recogerRecurso (Jugador jugador,int random) { // Recibe el jugador y el numero aleatorio para comprovar si este recibe materiales o puede robar
		
		if (random == 7) {
			
			robar(jugador); // Robar una carta a un jugador
			descartarMitad(jugador); // Descartar cartas de todos por la mitad si mas de 7
			
		}
		
		//Se pueden recoger multiples recursos cada turno, este for recorre todas las ciudades y comprueva que tenga el mismo numero para dar el material
		
		for (int i = 0; i < jugador.ciudades.length && jugador.ciudades[i] != null; i++) {
			
			if (jugador.ciudades[i].getNumero() == random) {
				
				if (jugador.addCarta(jugador.ciudades[i].getRecurso())) { // Si se ha añadido = true si no = false
					
					System.out.println("El jugador " + jugador.getNombre() + " Ha conseguido el siguiente material: " 
										+ jugador.ciudades[i].getRecurso());
					
				} else { //Solo devuelve false si esta llena la mano del jugador, llama al metodo removeCarta y despues llama a getRecurso en la posicion que se ha 
					
					System.out.println("El jugador " + jugador.getNombre() + " no puede conseguir mas cartas, elige una carta que descartar");
					
					this.mostrarCartas(jugador);
					
					while (!jugador.removeCarta(scan.nextInt()-1)) { // Devuelve true si se ha eliminado false si no
						
						System.out.println("Introduce un valor valido");
						
					} System.out.println("Carta eliminada");
					
						jugador.addCarta(jugador.ciudades[i].getRecurso()); // Añadir carta
						
						System.out.println("El jugador " + jugador.getNombre() + " Ha conseguido el siguiente material: " 
											+ jugador.ciudades[i].getRecurso());
					
					break;
				}
				
			}
		
		}
		
	}
	
	void robar(Jugador jugador) { // Muestra la lista de jugadores y deja elegir a quien robar, mientras la eleccion no sea a ti mismo
		
		while (true) {
			
			System.out.println("Jugador: " + jugador.getNombre() + "  | Elige a quien quieres robar"); //Robar 1 carta a alguien
			
			mostrarJugadores(jugadores);
			
			int eleccion = scan.nextInt();
			
			if (eleccion >= 1 && eleccion <= jugadores.length && !(jugadores[eleccion-1].getNombre().equals(jugador.getNombre())) && jugadores[eleccion-1].getCantidadCartas() > 0) {
				// Mientras la eleccion este entre 1 y el maximo de la array, la eleccion no tenga el mismo nombre que el jugador que roba y tenga cartas
				// Dos jugadores pueden tener el mismo nombre asi que deberia asignar una id unica a cada jugador con una variable static que se sumase en el constructor
				// del objeto.
				
				eleccion--; // no se salga de los limites de la array
				
				System.out.println("Cartas del jugador: " + jugadores[eleccion].getNombre());
				
				mostrarCartas(jugadores[eleccion]);
				
				while (true) {
					
					int eleccionCarta = scan.nextInt()-1;
					
					if (eleccion >= 0 && eleccion <= 9 && jugadores[eleccion].cartas[eleccionCarta] != null) { // que la eleccion este entre el limtie de cartas y no sea null
						
						jugador.addCarta(jugadores[eleccion].cartas[eleccionCarta]);
						System.out.println("Carta robada del jugador: " + jugadores[eleccion].getNombre() + 
											" | Carta robada: " + jugadores[eleccion].cartas[eleccionCarta]);
						jugadores[eleccion].removeCarta(eleccionCarta);
						
						break;
						
					} else {
						
						continue;
						
					}
					
				}
				
				break;
				
			} else if (eleccion == 0) { // Salir por si no se quiere robar
				
				break;
				
			} else {
				
				continue;
			
			}
			
		}
		
	}
	
	void descartarMitad (Jugador jugador) { // si un jugador tiene mas de o 7 cartas consigue la mitad de sus cartas/2 y elimina las cartas aleatoriamente
		
		for (int i = 0; i < this.jugadores.length; i++) {
			
			if (jugadores[i].getCantidadCartas() >= 7) {
				
				int veces = 0;
				int cartasToDelete = jugadores[i].getCantidadCartas()/2;
				
				while (veces < cartasToDelete) {
					
					int randomcard = (int)(Math.random()*9);
					
					System.out.println("Jugador:" + (i+1) + " | Se ha eliminado " + jugadores[i].cartas[randomcard]);
					
					jugadores[i].removeCarta(randomcard);
					
					veces++;
					
				}
				
			}
			
		}
		
	}
	

	public static void main(String[] args) {
		
		Catan partida = new Catan();
		
		partida.nuevaPartida();
		
	}
	

}
