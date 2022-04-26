package david.elias;

import david.elias.Armas.*;
import david.elias.Humanoides.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Random;

public class Zombicide {

	ArrayList<Arma> armasLoot;
	ArrayList<Arma> armasJugador;
	ArrayList<Jugador> personajes;
	ArrayList<Zombie> zombies;

	public Zombicide() {
		
		initZombicide();

	}
	
	void initZombicide() { // Guardar el initZombicide en otra para poder llamar en otro momento para reinicar toddos valores
		
		armasLoot = new ArrayList<Arma>();
		armasJugador = new ArrayList<Arma>();
		personajes = new ArrayList<Jugador>();
		zombies = new ArrayList<Zombie>();
		InitPersonajes();
		InitObjetos();
		
	}

	void InitPersonajes() {
		// Arma especial
		Arma armaEspecial = new Arma("Daga","Mandoble", 2, 1, 4);
		personajes.add(new Jugador("James", armaEspecial, 7));
		personajes.add(new Jugador("Marie"));
		personajes.add(new Jugador("Jaci"));
	}

	void InitObjetos() { // OBjetos: Nombre, daño, alcance, acierto

		// Armas que son posibles encontrar
		armasLoot.add(new Espada("Espada corta", 1, 1, 4));
		armasLoot.add(new Arco("Arco largo", 1, 2, 3));
		armasLoot.add(new Hechizo("Bola de fuego", 1, 3, 4));
		armasLoot.add(new Hacha("Hacha doble", 2, 1, 3));
	}

	String mostrarPersonajes() {

		String result = "|----------------------------------------------------------------------------------------------------------------|\n\n";

		for (int i = 0; i < personajes.size(); i++) {
			result += personajes.get(i).toString() + "\n";
		}

		result += "\n|----------------------------------------------------------------------------------------------------------------|\n";

		return result;
	}

	String mostrarZombies() {

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

			if (currentRandom == 0) {
				zombies.add(new Corredor());
			} else if (currentRandom == 1) {
				zombies.add(new Caminante());
			} else if (currentRandom == 2) {
				zombies.add(new Gordo());
			}

		}

	}

	@SuppressWarnings("unused")
	boolean checkVivos() { // Personajes seran jugando

		for (int i = 0; i < personajes.size(); i++) {
			if (personajes.get(i).isVivo()) {
				return true;
			} else {
				return false;
			}
		}

		return false;

	}

	void menu() {

		Scanner scan = new Scanner(System.in);
		boolean on = true;

		while (on) {

			System.out.print(
					"1- Nueva partida\n2- Nuevo personaje\n3- Lista de personajes\n4- Debug \n0- Salir\nOpcion:");

			switch (scan.nextInt()) {

			case 1:
				partida();
				break;
			case 2:
				System.out.println("Introduce el nombre del nuevo personaje");
				personajes.add(new Jugador(scan.next()));
				System.out.println("Personaje añadido con exito");
				break;
			case 3:
				System.out.println(mostrarPersonajes());
				break;
			case 4:
				break;
			case 0:
				on = false;
				break;
			default:
				continue;

			}

		}

	}

	Zombie getRandomZombie() {

		Random rng = new Random();
		Zombie currentZomb = zombies.get(rng.nextInt(zombies.size())); // Zombie aleatorio de todos
		return currentZomb;

	}
	
	Zombie getZombie(Zombie originZombie) {
		
		for (int i = 0; i < zombies.size(); i++) {
			
			if (zombies.get(i).getTipo().equals(originZombie.getTipo()) && zombies.get(i) != originZombie) {
				// Si zombie mismo tipo y no es el del origen
				
				return zombies.get(i);
				
			}
			
		}
		
		return new Gordo(); // Nunca llegara aqui pero si no esta esto da error
		
	}
	
	String printArmas () {
		
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
	
	void atacar(Jugador currentPlayer) {
		
		for (int y = 0; y < currentPlayer.getArma().getAlcance(); y++) {

			Zombie currentZomb = getRandomZombie();
			if (currentPlayer.atacar(currentZomb)) { // Atacar zombie aleatorio devuelve true si muere TODO: Especial al morir

				for (int k = 0; k < zombies.size(); k++) {
					if (zombies.get(k) == currentZomb) {
						
						checkSpecial(currentZomb);
						System.out.println(currentZomb.getTipo() + " eliminado!");
						
						zombies.remove(k);
					}
				}

			} else { // TODO: Se imprime en metodo, hacer que se imprima aqui, hay que cambiar metodo

			}

		}
		
	}
	
	void checkSpecial(Zombie zombie) {
		
		int randomGend = (int) (Math.random() * 100);
		
		if (randomGend > 95) {
			
			switch (zombie.getTipo()) {
			
			case "Caminante":
				
				int caminantes = cantidadZombies("Caminante");
				System.out.println(caminantes); // <-- TODO: ELiminar
				System.out.println("Se acercan " + caminantes + " caminantes!");
				
				for (int i = 0; i < caminantes; i++) { // Añade cantidad de caminantes
					
					zombies.add(new Corredor());
					
				}
				
				break;
			
			case "Gordo":
				
				if (cantidadZombies("Gordo") > 1) {
					
					Zombie delZombie = getZombie(zombie); // zombie = gordo origen, delZombie = zombie a eliminar
					System.out.println("Gordo ha explotado y ha eliminado a otro Gordo!");
					zombies.remove(zombie); // ELimina al zombi y volver a comprovar si explota (Reaccion en cadena)
					
					if (cantidadZombies("Gordo") > 1) {
						
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
							
						}
						
					}
					
					System.out.println("Se han eliminado " + totalElims + " corredores!");
					
				}
				
				break;
			
			}
			
		}
		
	}
	
	int cantidadZombies (String zombie) {
		
		int totalZombs = 0;
		
		for (int i = 0; i < zombies.size(); i++) {
			
			if (zombies.get(i).getTipo().equals(zombie)) {
				
				totalZombs++;
				
			}
			
		}
		
		return totalZombs;
		
	}
	
	void encontrarArma() {
		
		Random rng = new Random();
		Arma foundArma;
		int numRandom = rng.nextInt(100)+1; //Random 1-100
		
		if (numRandom > 0 && numRandom < 30) {
			
			foundArma = armasLoot.get(rng.nextInt(armasLoot.size()));
			armasJugador.add(new Arma(foundArma)); // Crear nuevo Objeto arma con la informacion de arma aleatoria
			
		} else {
			
			foundArma = new Arma(); // <- Daga
			armasJugador.add(foundArma);
			
		}
		
		System.out.println("Has encontrado la siguiente arma: " + foundArma.getNombre());
	}
	
	void matarZombis(String tipo, int cantidad) {
		
		if (tipo.equalsIgnoreCase("aleatorio")) { // caso especial aleatorios
			
			for (int i = 0; i < cantidad; i++) {
				
				Zombie currentZomb = getRandomZombie();
				System.out.println(currentZomb.getTipo() + " eliminado!");
				checkSpecial(currentZomb);
				zombies.remove(currentZomb);
				
			}
		}
		
		for (int i = 0; i < cantidad; i++) {
			
			for (int k = 0; k < zombies.size(); k++) {
				
				if (zombies.get(k).getTipo().equalsIgnoreCase(tipo)) {
					
					Zombie currentZomb = zombies.get(k);
					System.out.println(currentZomb.getTipo() + " eliminado!");
					checkSpecial(currentZomb);
					zombies.remove(currentZomb);
					break;
					
				}
				
			}
			
		}
		
	}
	
	void recargarEspeciales() {
		
		for (int i = 0; i < armasJugador.size(); i++) { // Recorrer inventario
			armasJugador.get(i).setCanSpecial(true);
		}
		
		for (int i = 0; i < personajes.size(); i++) { // Recorrer armas jugadores
			personajes.get(i).getArma().setCanSpecial(true);
		}
	}

	void partida() { // Maybe mover a clase propia???

		int nivel = personajes.size();
		Scanner scan = new Scanner(System.in);

		while (checkVivos()) {

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
						System.out.println("No tienes armas disponibles"); // TODO: Encontrar una manera menos mierda de volver a hacer el bucle
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
			
			for (int i = 0; i < zombies.size(); i++) { // TODO: Si se cambia la array de players cambiar esto tambien!!!!! <- wtf? nivels?
				
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
				
				if (currentPlayer.dealDamage(currentZombie.getDamage())) { // Eliminar jugador de array de jugadores si muere, avisar de su muerte
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
		initZombicide(); // reiniciar valores

		// Final

	}

}