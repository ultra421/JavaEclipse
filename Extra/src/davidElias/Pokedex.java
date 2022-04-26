package davidElias;

import java.util.Scanner;

public class Pokedex {
	
public static int[] pokemonExist (String [] pokedex, String pokemon) { 
	
		// Esta funcion comprueva que exista el pokemon introducido en la pokedex introducida, recorre la array y
		// si existe se guarda la posicion en una array = Pos 0: Existe Si (1) o no (0)? / Pos1: Posicion del pokemon
		
		int [] resultado = {0,0};
		
		for (int i = 0; i < pokedex.length-1; i++) {
			
			if (pokedex [i] != null) {
			
				if (pokedex [i].equals(pokemon)) {
					
					resultado = new int[] {1,i};
					
					break;
					
				}
				
			}
			
		}
		
		return resultado;
		
	}
	
	public static String firstMayus (String input) { //Funcion para pasar la String introducida una frase que empieze si o si por mayuscula y las demas sean minisculas.
		
		input = Character.toString(input.charAt(0)).toUpperCase() + input.substring(1).toLowerCase();
		
		return input;
		
	}
	
	public static String [] modifyArraySize (String input[], int by) { // Crea una array con los mismos valores que la introducida con el tamaño especificado.
		
		String [] output = new String [input.length+by];
		
		for (int i = 0; i < input.length; i++) {
				
			output [i] = input[i];
				
		}
		
		return output;
		
	}
	
	public static int posicionDisponible (String [] input) { // Comprueva donde se encuentra el primer null de la array
		
		int posicion = 0;
		
		for (int i = 0; i < input.length; i++) {
			
			if (input[i] == null) {
				
				posicion = i;
				
				break;
				
			} else {
				
				posicion = input.length-1;
				
			}
			
		}
		
		return posicion;
		
	}
	
	public static String [] addPokemon (String [] input, String pokemon, int posicion) { 
		/* Añade un pokemon a una posicion depnde si hay una posicion libre o no,
		 * a esta funcion le llega la variable posicion, esta se consigue llamando al metodo posicionDisponible al llamar este*/
		
		int [] pokemonStatus = pokemonExist(input,pokemon);
		
		if (pokemonStatus[0] == 0) {
		
			if (posicion == (input.length-1)) {	//Si la posicion disponible es la ultima se hace mas grande la array de la pokedex
				
				input = modifyArraySize(input,1);
				
				input [posicion] = pokemon;
				
				System.out.println(pokemon + " registrado en la posicion " + (posicion+1));
				
			} else { // Si la posicion disponible no es la ultima se añade el pokemon
				
				input [posicion] = pokemon;
				
				System.out.println(pokemon + " registrado en la posicion " + (posicion+1));
				
			}
			
		} else {
			
			System.out.println(pokemon + " ya existe en la posicion " + (pokemonStatus[1]+1));
			
		}
		
		return input;
		
	}
	
	public static String [] removePokemon (String [] input, String pokemon, Integer posicion) { //Elimina un pokemon de una posicion
		
		int [] pokemonStatus = pokemonExist(input,pokemon);
		
		if (posicion == null) {
			
			posicion = pokemonStatus[1];			
		}
		
		if (pokemonStatus[0] == 1) { // Si existe
			
			input [posicion] = null;
			
			System.out.println(pokemon + " Eliminado en la posicion " + (posicion+1));
			
			return input;
			
		} else {
			
			System.out.println("No se ha encontrado el pokemon en la pokedex");
			
			return input;
			
		}
		
	}

	public static void main(String[] args) {
		
		boolean on = true;
		int opcion = 0;
		Scanner scan = new Scanner(System.in);
		String pokemon = "";
		String [] pokedex = new String [1];
		int cantidadPoke = 0;
		int [] pokemonStatus;
		int posicion = 0;
		
		while (on) {
			
			do {
			
			System.out.println("Escoge una de las siguientes opciones:");
			
			System.out.println("1- Fill pokedex auto		7- Show all Pokemon \n"
							+ "2- Add pokemon			8- Get Pokemon at Position \n"
							+ "3- Add Pokemon at Position 	9- Count Pokemon \n"
							+ "4- Delete Pokemon		10- Hack Pokedex \n"
							+ "5- Delete Pokemon at Position	11- Erase Pokedex info \n"
							+ "6- Find Pokemon			12- Exit");
			
			System.out.print("Opcion: ");
			
			opcion = scan.nextInt();
			
			} while (!(opcion < 13 && opcion > 0));
			
			switch (opcion) {
			
			case 1: //Autofill
				
				System.out.println("Llenando 5 espacios con pokemons automaticamente");
				
				String [] predeterminados = new String [] {"Pikachu","Charmander","Squirtle","Bulbasur","Ditto"};
				
				for (int i = 0; i < 5; i++) {
					
					pokedex = addPokemon(pokedex,predeterminados[i],posicionDisponible(pokedex));
					
				}
				
				break;
			case 2: // Add pokemon
				
				System.out.println("Nombre del pokemon:");
				
				pokedex = addPokemon(pokedex,firstMayus(scan.next()),posicionDisponible(pokedex));
				
				break;
				
			case 3: // Add pokemon at
				
				boolean pokeExist;
				
				do {
					
					System.out.println("Introduce el nombre del pokemon que quieres añadir:");
					
					pokemon = firstMayus(scan.next());
					
					pokeExist = (pokemonExist(pokedex, pokemon)[0] == 1);
					
					if (!pokeExist) {
						
						System.out.println("Introduce la posicion");
						
						posicion = scan.nextInt()-1;
						
						if (posicion > pokedex.length-1) {
							
							pokedex = modifyArraySize(pokedex, posicion-pokedex.length+1);
							
							pokedex = addPokemon(pokedex, pokemon, posicion);
							
							break;
							
						} else if (posicion > 0 && posicion < pokedex.length) {
							
							pokedex = addPokemon (pokedex, pokemon, posicion);
							
							break;
							
						}
						
					}
					
				} while (pokeExist);
				
				break;
			case 4: // Remove poke
				
				System.out.println("Que pokemon quieres eliminar?");
				
				pokemon = firstMayus(scan.next());
				
				pokedex = removePokemon(pokedex, pokemon, posicion);
				
				break;
				
			case 5: // Remove poke at pos
				
				System.out.println("Que posicion quieres eliminar");
				
				posicion = scan.nextInt()-1;
				
				if (posicion < pokedex.length && pokedex[posicion] != null ) {
					
					pokedex = removePokemon(pokedex, pokemon, posicion);
					
				} else {
					
					System.out.println("Esa posicion esta vacia");
					
				}
				
				break;
				
			case 6:
				
				System.out.println("Que pokemon quieres encontrar?");
				
				pokemon = firstMayus(scan.next());
				
				pokemonStatus = pokemonExist(pokedex, pokemon);
				
				if (pokemonStatus[0] == 1) {
					
					System.out.println(pokemon + " encontrado en la posicion " + (pokemonStatus[1]+1));
					
				} else {
					
					System.out.println("Pokemon no encontrado");
					
				}
				
				break;
			case 7:
				
				if (pokedex.length > 1) {
					
					System.out.println("Pokemons registrados:");
					
					for (int i = 0; i < pokedex.length-1; i++) {
						
						if (!(pokedex[i] == null)) { 
						
							System.out.println("-" + pokedex [i] + " | posicion: " + (i+1));
						
						}	
						
					}
					
				} else {
					
					System.out.println("Pokedex vacia");
					
				}
				
				break;
			case 8:
				
				posicion = scan.nextInt();
				
				if (posicion < pokedex.length) {
					
					System.out.println("El pokemon " + pokedex[posicion] + " se encuentra en esa posicion");
					
				}
				
				break;
			case 9: 
				
				int cantidad = 0;
				
				for (int i = 0; i < pokedex.length; i++) {
					
					if (!(pokedex [i] == null) ) {
						
						cantidad++;
						
					}
					
				}
				
				System.out.println("Hay " + cantidad + " pokemons registrados en la pokedex");
				
				break;
				
			case 10: 
				
				if (pokedex.length > 0) {
				
					for (int i = 0; i < pokedex.length; i++) {
						
						if (pokedex [i] != null) {
						
							pokedex[i] = "Ditto";
						
						}
						
					}
					
					System.out.println("Pokedex hackeada");
				
				} else {
					
					System.out.println("No hay ningun pokemon para hackear");
					
				}
					
				break;
			case 11:
				
				String confirm = scan.next().toUpperCase();
				
				System.out.println("Seguro? \n Introduce 'Y' para confirmar ");
				
				if (confirm.equals("Y")) {
					
					pokedex = new String [1];
					
					System.out.println("Pokedex eliminada");
					
				}
				
				
				break;
			case 12: 
				
				System.out.println("Cerrando pokedex...");
				
				on = false;
				
				break;
			
			}
			
		}	

	}

}
