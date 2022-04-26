package david.elias;

import david.elias.Armas.*;
import david.elias.Humanoides.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Random;

/* Este es el .java principal del Zombicide, aqui se encuentran la mayoria de metodos utilziados en la partida */

public class Zombicide {

	ArrayList<Arma> armasLoot; // Armas posibles que se podran encontrar
	ArrayList<Arma> armasJugador; // Armas que se podran equipar
	ArrayList<Jugador> personajes; // personajes que estaran en combate
	ArrayList<Jugador> personajesDisponibles; // personajes creados antes de la partida
	ArrayList<Zombie> zombies; // Los zombis que estan vivos

	public Zombicide() {
		
		armasLoot = new ArrayList<Arma>();
		armasJugador = new ArrayList<Arma>();
		personajesDisponibles = new ArrayList<Jugador>();
		personajes = new ArrayList<Jugador>();
		zombies = new ArrayList<Zombie>();
		initPersonajes();
		initObjetos();

	}
	
	void resetZombicide() {
		
		armasLoot = new ArrayList<Arma>();
		armasJugador = new ArrayList<Arma>();
		personajes = new ArrayList<Jugador>();
		zombies = new ArrayList<Zombie>();
		
	}

	void initPersonajes() {
		
		//Añadir 3 personajes predeterminados, uno con arma y estadisitcas especiales
		
		// Arma especial
		Arma armaEspecial = new Arma("Daga","Mandoble", 2, 1, 4);
		personajesDisponibles.add(new Jugador("James", armaEspecial, 7));
		personajesDisponibles.get(0).getArma().setCanSpecial(false); // La arma de James no puede hacer especial
		personajesDisponibles.add(new Jugador("Marie"));
		personajesDisponibles.add(new Jugador("Jaci"));
	}

	void initObjetos() { // OBjetos: Nombre, daño, alcance, acierto

		// Armas que son posibles encontrar
		armasLoot.add(new Espada("Espada corta", 1, 1, 4));
		armasLoot.add(new Arco("Arco largo", 1, 2, 3));
		armasLoot.add(new Hechizo("Bola de fuego", 1, 3, 4));
		armasLoot.add(new Hacha("Hacha doble", 2, 1, 3));
	}

	String mostrarPersonajes(ArrayList<Jugador> personajes) { // Metodo "toString" para las array de personajes

		String result = "|----------------------------------------------------------------------------------------------------------------|\n";

		for (int i = 0; i < personajes.size(); i++) {
			result += (i+1) + " - " + personajes.get(i).toString() + "\n";
		}

		result += "|----------------------------------------------------------------------------------------------------------------|\n";

		return result;
	}

	String mostrarZombies()  {
		
		// Metodo que mostrara los contenidos de la array de Zombis, si son mas de 10 en fila se bajara hacia abajo

		String result = "";

		for (int i = 0; i < zombies.size(); i++) {

			result += zombies.get(i).getTipo() + " | ";

			if (i % 10 == 0 && i != 0) {
				result += "\n";
			}

		}

		return result;

	}

	void genZombies(int nivel) { // Generar tantos zombies como nivel

		Random rng = new Random();

		for (int i = 0; i < nivel; i++) {

			int currentRandom = rng.nextInt(3);
			
			// Aleatorio, todos los zombis tienen un 33% de aparaecer, siempre saldra uno

			if (currentRandom == 0) {
				zombies.add(new Corredor());
			} else if (currentRandom == 1) {
				zombies.add(new Caminante());
			} else if (currentRandom == 2) {
				zombies.add(new Gordo());
			}

		}

	}
	
	
	boolean checkVivos() { // Comprobar si queda alguien vivo

		for (int i = 0; i < personajes.size(); i++) {
			
			if (personajes.get(i).isVivo()) {
				return true;
			}
			
		}

		return false;

	}

	Zombie getRandomZombie() { // conseguir un zombie aleatorio de la array

		Random rng = new Random();
		Zombie currentZomb = zombies.get(rng.nextInt(zombies.size())); // Zombie aleatorio de todos
		return currentZomb;

	}
	
	Zombie getZombie(Zombie originZombie) { // conseugir zombie mismo tipo que el insertado y no sea el mismo
		
		// Para zombies tipo gordo
		
		for (int i = 0; i < zombies.size(); i++) {
			
			if (zombies.get(i).getTipo().equals(originZombie.getTipo()) && zombies.get(i) != originZombie) {
				// Si zombie mismo tipo y no es el del origen
				
				return zombies.get(i);
				
			}
			
		}
		
		return new Gordo(); // Nunca llegara aqui, ya que el metodo no se llama si no existen multiples gordos,
							// pero si no esta esto da error
		
	}
	
	String printArmas () { // metodo "toString" para la array de armas, que llama a los metodos toString de cada arma
		
		String result = "";
		
		if (armasJugador.size() == 0) {
			return "No tienes armas";
		} else {
			result += "Armas en tu inventario: \n";
			for (int i = 0; i < armasJugador.size(); i++) {
				result += (i+1) + "- " + armasJugador.get(i).toString() + "\n"; 
			}
		}
		
		return result;
		
	}
	
	void atacar(Jugador currentPlayer) { // Metodo de atacar, recibe jugador que atacara
		
		for (int y = 0; y < currentPlayer.getArma().getAlcance(); y++) {

			Zombie currentZomb = getRandomZombie();
			
			if (currentPlayer.atacar(currentZomb)) { // Atacar zombie aleatorio devuelve true si esta ha muerto, para comprovar especial
						
				if (checkSpecial(currentZomb)) { // Devuelve true si se ha cumplido la condicion para el especial
					
					// Especial exito
					System.out.println(currentZomb.getTipo() + " eliminado!");
					
				} else {
					
					System.out.println(currentZomb.getTipo() + " eliminado!");
					zombies.remove(currentZomb);
					
				}

			} 

		}
		
	}
	
	boolean checkSpecial(Zombie zombie) {
		
		int randomGend = (int) (Math.random() * 100);
		System.out.println("Random = " + randomGend);
		
		if (randomGend > 95) { // 5% de que se active la habilidad especial al morir
			
			switch (zombie.getTipo()) {
			
			case "Caminante":
				
				int caminantes = cantidadZombies("Caminante");
				System.out.println("Se escucha un horripilante grito del fallecido caminante... ¡Se acercan " + caminantes + " caminantes!");
				
				for (int i = 0; i < caminantes; i++) { // Añade cantidad de caminantes
					
					zombies.add(new Corredor());
					
				}
				
				break;
			
			case "Gordo":
				
				if (cantidadZombies("Gordo") > 1) {
					
					Zombie delZombie = getZombie(zombie); // zombie = gordo origen, delZombie = zombie a eliminar
					System.out.println("Gordo ha explotado y ha eliminado a otro Gordo!");
					zombies.remove(zombie); // ELimina al zombi y volver a comprovar si explota (Reaccion en cadena)
					
					if (cantidadZombies("Gordo") > 1) { // Llama al mismo metodo con el zombi que va a morir
						
						checkSpecial(delZombie);
						
					}
					
				}
				
				break;
				
			case "Corredor":
				
				if (cantidadZombies("Corredor") > 1) {
					
					int totalElims = 0;
					
					for (int i = 0; i < zombies.size(); i++) {
						
						if (zombies.get(i).getTipo().equals("Corredor")) {
							
							totalElims++;
							zombies.remove(i);
							i--; // Tirar para atras el bucle porque se ha eliminado un zombi, porque arrayList se reorganiza
							
						}
						
					}
					
					System.out.println("Se han eliminado " + totalElims + " corredores!");
					
				}
				
				break;
			
			}
			
			return true;
			
		} else {
		
			return false;
		
		}
		
	}
	
	int cantidadZombies (String zombie) { // Devuelve todos los zombis que estan vivos
		
		int totalZombs = 0;
		
		for (int i = 0; i < zombies.size(); i++) {
			
			if (zombies.get(i).getTipo().equals(zombie)) {
				
				totalZombs++;
				
			}
			
		}
		
		return totalZombs;
		
	}
	
	void encontrarArma() { // Encontrar arma 30% -> si se cumple, clonar arma a inventario, si no, añadir daga
		
		Random rng = new Random();
		Arma foundArma;
		int numRandom = rng.nextInt(100)+1; //Random 1-100
		
		if (numRandom > 0 && numRandom < 30) {
			
			foundArma = armasLoot.get(rng.nextInt(armasLoot.size()));
			armasJugador.add(new Arma(foundArma)); // Crear nuevo Objeto arma con la informacion de arma aleatoria y añadir a inventario
			
		} else {
			
			foundArma = new Arma(); // <- Daga
			armasJugador.add(foundArma);
			
		}
		
		System.out.println("Has encontrado la siguiente arma: " + foundArma.getNombre());
	}
	
	void matarZombis(String tipo, int cantidad) { // Matar x zombis de tipo
		
		if (tipo.equalsIgnoreCase("aleatorio")) { // caso especial aleatorios
			
			for (int i = 0; i < cantidad; i++) {
				
				Zombie currentZomb = getRandomZombie();
				System.out.println(currentZomb.getTipo() + " eliminado!");
				zombies.remove(currentZomb);
				
			}
			
		} else {
		
			for (int i = 0; i < cantidad; i++) { // veces que se matar
				
				for (int k = 0; k < zombies.size(); k++) { // recorrer array zombis, buscar del tipo adecuado
					
					if (zombies.get(k).getTipo().equalsIgnoreCase(tipo)) {
						
						Zombie currentZomb = zombies.get(k);
						System.out.println(currentZomb.getTipo() + " eliminado!");
						zombies.remove(currentZomb);
						
					}
					
				}
				
			}
		
		}
		
	}
	
	void transferJugadores() { // menu para pasar jugadores de los creados, a los que estan en partida
		
		Scanner scan = new Scanner(System.in);
		boolean on = true;
		
		while (on) {
			
			int seleccion;
			
			System.out.println("¿Que personajes estaran en tu grupo?");
			
			System.out.println("Personajes en tu grupo:");
			System.out.println(mostrarPersonajes(personajes));
			
			System.out.println("1 - Añadir un personaje al grupo");
			System.out.println("2 - Eliminar un personaje del grupo");
			System.out.println("3 - Empezar aventura");
			System.out.println("4 - Volver a menu principal");
			
			System.out.print("Seleccion: ");
			seleccion = scan.nextInt();
			
			switch (seleccion) {
			
			case 1:
				
				// Clonar Jugador de array a array, comprovar si existe
				
				int seleccionJugador;
				
				System.out.println("Personajes creados:");
				System.out.println(mostrarPersonajes(personajesDisponibles));
				System.out.print("Seleccion:");
				
				seleccionJugador = scan.nextInt()-1;
				
				if (seleccionJugador >= 0 && seleccionJugador < personajesDisponibles.size()) {
					
					boolean alreadyExist = false;
					Jugador personajeActual = personajesDisponibles.get(seleccionJugador);
					
					for (int i = 0; i < personajes.size(); i++) {
						
						if (personajes.get(i).getNombre().equals(personajeActual.getNombre())) {
							
							alreadyExist = true;
							break;
							
						}
						
					}
					
					if (alreadyExist) {
						System.out.println("Ya existe ese personaje!");
					} else {
						System.out.println("Añadiendo personaje...");
						personajes.add(new Jugador(personajeActual)); // Añadir clon del personaje Seleccionado
						
					}
					
				} else {
					System.out.println("Introduce un numero valdio");
				}
				
				break;
				
			case 2:
				
				// Eliminar jugador de array de que jugaran por ID
				
				System.out.println(mostrarPersonajes(personajes));
				
				System.out.println("A quien quieres eliminar? (0 = nadie)");
				int seleccionEliminar = scan.nextInt()-1;
				
				if (seleccionEliminar == 0) {
					break;
				} else if (seleccionEliminar > 0 && seleccionEliminar < personajes.size()) {
					System.out.println(personajes.get(seleccionEliminar).getNombre() + " eliminado"); 
					personajes.remove(seleccionEliminar);
					break;
				}
				
				break;
			case 3:
				
				// Empezar partida, comrpovar que equipo este entre
				
				if (personajes.size() >= 3 && personajes.size() <= 6) {
					
					partida(); //empezar la partida
					
					break;
				} else {
					
					System.out.println("Tienen que haber entre 3 y 6 personajes");
					
					if (personajes.size() < 3) { // Si hay menos de 3 jugadores, ofrecer opcion de empezar con predeterminados
						
						System.out.println("Quieres empezar la aventura con los 3 personajes predeterminados? (0 = no / 1 = si)");
						
						switch (scan.nextInt()) {
						
						case 1:
							
							personajes = new ArrayList<Jugador>();
							
							personajes.add(personajesDisponibles.get(0));
							personajes.add(personajesDisponibles.get(1));
							personajes.add(personajesDisponibles.get(2));
							partida(); // empezar la partida
							
							break;
							
						default:
							
							break;
						
						}
						
					}
					
					
					
					continue;
				}
				
			case 4:
				
				// acabar bucle, vovler a menu principal
				on = false;
				break;
			
			}
			
		}
		
	}
	
	void recargarEspeciales() { // Al final del turno reinciar especial a todas armas
		
		for (int i = 0; i < personajes.size(); i++) { // Recorrer armas jugadores
			
			if (!personajes.get(i).getArma().getNombre().equals("Daga")) {// si no igual a daga 
			
				personajes.get(i).getArma().setCanSpecial(true);
			
			}
		}
	}
	
	void menu() { // menu principal antes de partidad

		Scanner scan = new Scanner(System.in);
		boolean on = true;

		while (on) {

			System.out.print(
					"1- Nueva partida\n2- Nuevo personaje\n3- Lista de personajes\n0- Salir\nOpcion:");

			switch (scan.nextInt()) {

			case 1: //llama al metodo que llamara a partida si se cumplen condiciones
				
				transferJugadores();
				
				break;
			case 2: // crear nuevo personaje con nombre
				System.out.println("Introduce el nombre del nuevo personaje");
				personajesDisponibles.add(new Jugador(scan.next()));
				System.out.println("Personaje añadido con exito");
				break;
			case 3: // mostrar personajes
				System.out.println(mostrarPersonajes(personajesDisponibles));
				break;
			case 0:
				on = false;
				break;
			default:
				continue;

			}

		}

	}

	void partida() {
		
		try {
			
			System.out.print("Comenzado partida");
			TimeUnit.MILLISECONDS.sleep(333);
			System.out.print(".");
			TimeUnit.MILLISECONDS.sleep(333);
			System.out.print(".");
			TimeUnit.MILLISECONDS.sleep(333);
			System.out.println(".");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int nivel = personajes.size();
		Scanner scan = new Scanner(System.in);

		while (checkVivos()) { // mientras hayan jugadores vivo seguir con bucle de turnos

			genZombies(nivel);
			System.out.println("Nivel:" + nivel);

			// Turno jugador

			for (int i = 0; i < personajes.size(); i++) {

				Jugador currentPlayer = personajes.get(i);
				System.out.println("Zombies:");
				System.out.println(mostrarZombies());
				System.out.println("Jugador actual: " + currentPlayer.toString());
				System.out.print("1- Atacar\n2- Especial\n3- Buscar\n4- Cambiar Arma\n0- Pasa\nOpcion:");
				switch (scan.nextInt()) {
				
				case 1: // Atacar

					atacar(currentPlayer); // Envia el jugador que va a atacar

					break;
				case 2: // Especial
					
					Arma currentArma = currentPlayer.getArma();
					String tipoArma = currentArma.getTipo();
					
					if (currentArma.toggleSpecial()) { // Canvia especial a false si true i viceversa, devuelve el estado del bool antes de canviarlo
					
						if (tipoArma.equalsIgnoreCase("espada")) {
							matarZombis("aleatorio", 2);
						} else if (tipoArma.equalsIgnoreCase("hacha")){
							matarZombis("gordo",1);
						} else if (tipoArma.equalsIgnoreCase("hechizo")) {
							matarZombis("caminante",2);
						} else if (tipoArma.equalsIgnoreCase("arco")) {
							matarZombis("corredor",1);
						} else {
							System.err.println("Error: no se ha encontrado especial en armas");
							i--;
						}
						
					} else {
						System.out.println("Ataque especial no esta listo!");
					}
					
					currentArma.setCanSpecial(false);
					
					break;
					
				case 3: // Buscar Arma
					
					encontrarArma();
					
					break;
					
				case 4: // Inventario
					
					if (armasJugador.size() > 0) {
						
						System.out.println("");
						System.out.print(printArmas());
						System.out.print("Seleccion");
						int armaSelec = scan.nextInt()-1; 
						
						if (armaSelec == -1) { // -1 (0) para salir del bucle
							break;
						}
						
						// Guardar arma del jugador, reemplazar por la nueva, guardar previa en inventario
						
						Arma prevArma = currentPlayer.getArma();
						currentPlayer.setArma(armasJugador.get(armaSelec));
						armasJugador.set(armaSelec, prevArma);
						
						System.out.println(currentPlayer.getNombre() + " ahora tiene equipada la siguiente arma:  " + currentPlayer.getArma().getNombre());
						i--;
						continue;
						
					} else {
						System.out.println("No tienes armas disponibles"); //
						i--;
						continue;
					}
					
				default:
					
					break;

				}

			} 
			
			// Turno zombies
			
			System.out.println("¡Los zombies atacan!");
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (int i = 0; i < zombies.size(); i++) { 
				
				Random rng = new Random();
				int randomNum = 0;
				
				if (personajes.size() > 0) {
					randomNum = rng.nextInt(personajes.size());
				} else {
					break;
				}
				
				Jugador currentPlayer = personajes.get(randomNum);
				Zombie currentZombie = zombies.get(i);
				
				// Hacer daño: si muere devovler true, si no false
				
				if (currentPlayer.dealDamage(currentZombie.getDamage())) { // Devuelve true si personaje ha muerto
					if (personajes.remove(currentPlayer)) {
						
						System.out.println(currentPlayer.getNombre() + " ha sido eliminado por " + currentZombie.getTipo());
						currentPlayer = null;
					}
					
				} else {
					System.out.println(currentPlayer.getNombre() + " ha recibido " + currentZombie.getDamage() + 
							" puntos de daño por " + currentZombie.getTipo());
				}
				
				
			}
			
			recargarEspeciales();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		System.out.println("GAME OVER");
		resetZombicide();// reiniciar valores

		// Final

	}

}