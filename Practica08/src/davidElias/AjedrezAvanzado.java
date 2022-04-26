package verify;

import java.util.Scanner;

public class AjedrezAvanzado {

	public static void main(String[] args) {

		String ajedrez[][] =   {{"[T]","[C]","[A]","[K]","[Q]","[A]","[C]","[T]"},
								{"[P]","[P]","[P]","[P]","[P]","[P]","[P]","[P]"},
								{" . "," . "," . "," . "," . "," . "," . ", " . "},
								{" . "," . "," . "," . "," . "," . "," . ", " . "},
								{" . "," . "," . "," . "," . "," . "," . ", " . "},
								{" . "," . "," . "," . "," . "," . "," . ", " . "},
								{"(P)","(P)","(P)","(P)","(P)","(P)","(P)","(P)"},
								{"(T)","(C)","(A)","(K)","(Q)","(A)","(C)","(T)"}};

		int reyMuerto = 0;
		int jugador = 1;
		String coordenada;
		int coordenadaX;
		int coordenadaY;
		int moverX;
		int moverY;
		Scanner input = new Scanner(System.in);
		boolean correcto = false;
		String pieza;
		String eliminadas = "";

		while (reyMuerto == 0) { // Paso 1 Imprimir tablero
			
			System.out.println("   1  2  3  4  5  6  7  8");

			for (int i = 0; i < ajedrez.length; i++) {
				
				System.out.print((char)(i+65) + " ");

				for (int k = 0; k < ajedrez.length; k++) {

					System.out.print(ajedrez[i][k]);

				}

				System.out.println();

			}

			do { //Paso 2 Input de coords
				
				// la variable coordenada es una String que contiene un numero y una letra esta la pasare por un metodo que he llamado traducirCoordenadas el cual explico en el metodo.

				System.out.println("Jugador actual: " + jugador);
				System.out.println("Introduce la coordenada de la pieza que desees mover");

				coordenada = traducirCoordenadas();
				
				coordenadaX = Character.getNumericValue(coordenada.charAt(0));
				coordenadaY = Character.getNumericValue(coordenada.charAt(1));

				if (coordenadaX > 0 && coordenadaX < 9) { // Comprovar que esten en el margen del tablero de ajedrez

					correcto = true;

				} else {

					correcto = false;
					System.out.println("Introduce unas coordenadas las cuales esten dentro del margen de 8x8");
					continue;

				}
				
				if (coordenadaY > 0 && coordenadaY < 9) { // Comprovar que esten en el margen del tablero de ajedrez

					correcto = true;

				} else {

					correcto = false;
					System.out.println("Introduce unas coordenadas las cuales esten dentro del margen de 8x8");
					continue;

				}
				
				coordenadaX -= 1; // Pasar las coords para que no se salgan del limite de matriz
				coordenadaY -= 1;
				
				//Piezas validas (Si no son validas de aqui no pasan)
				
				//Blanco = jugador 1
				//Negro = jugador 2
				
				if (jugador == 1 && ajedrez[coordenadaY][coordenadaX].contains("[")) {
					//Comprovar que la pieza sea equivocada, si equivocada continue (
					System.out.println("Esa pieza no es tuya!");
					continue;
					
				} else if (jugador == 2 && ajedrez[coordenadaY][coordenadaX].contains("(")){
				
					System.out.println("Esa pieza no es tuya!");
					continue;
				
				} else if (ajedrez[coordenadaY][coordenadaX].contains(".")) {
					
					System.out.println("Espacio vacio");
					continue;
					
				} System.out.println(ajedrez[coordenadaY][coordenadaX]);			
			
				
				do { // Paso 3 donde mover y si es valido el movimineto
					
					System.out.println("Introduce la coordenada hacia donde deseas moverte");

					coordenada = traducirCoordenadas();

					moverX = Character.getNumericValue(coordenada.charAt(0));
					moverY = Character.getNumericValue(coordenada.charAt(1));
					
					moverX -= 1; // Que no se salgan de los limites
					moverY -= 1;

					if ((moverX >= 0 && moverX <= 8) && (moverY >= 0 && moverY <= 8)) { // Comprovar que este dentro d limites

						correcto = true;

					} else {

						correcto = false;
						System.out.println("Introduce unas coordenadas las cuales esten dentro del margen de 8x8.");

					}
					
					} while (correcto == false);
				
					// Piezas logica (Paso 4)
					
					boolean moveValido = false;
					boolean eliminar = false;
					String mover = ajedrez[moverY][moverX]; // Ficha en la posicion a donde se movera la ficha
					int veces = 0;
					
					pieza = ajedrez[coordenadaY][coordenadaX];
					
					int diferenciaX = moverX - coordenadaX; //Diferencia necesaria para comprovaciones
					int diferenciaY = moverY - coordenadaY;
					
					switch (ajedrez[coordenadaY][coordenadaX].charAt(1)) { 
					// Coje el char de la pieza que da informacion sobre que tipo es y cambia el case segun cual sea
					
					case 'P': //Peon tiene que eliminar piezas en diagonal
						
						//Dos condiciones diferentes depende si es blanca o negra la ficha, al empezar el peon tiene que poder moverse
						//dos casillas, estas son diferentes para cada lado, la primera condicion de cada comprueva esto.
						//La segunda comprueva el movimineto vertical de 1 casilla
						//La Tercera comprueva que el movimiento sea valido para eliminar.
						
						if (pieza.contains("(")) { //Blanca
							
							if (coordenadaY == 6 && diferenciaY == -2 && ajedrez[moverY][moverX].contains(".")) { 
								
								moveValido = true;
								eliminar = false;
								
							} else  if (diferenciaY == -1 && ajedrez[moverY][moverX].contains(".") && diferenciaX == 0) {
								
								moveValido = true;
								eliminar = false;
								
							} else if (Math.abs(diferenciaY) == Math.abs(diferenciaX) && ajedrez[moverY][moverX].contains("[")){
								
								moveValido = true;
								eliminar = true;
								
							} else {
								
								moveValido = false;
								
							}
							
						} else if (pieza.contains("[")) { //Negra
							
							if (coordenadaY == 1 && diferenciaY == 2 && ajedrez[moverY][moverX].contains(".")) {
								
								moveValido = true;
								eliminar = false;
								
							} else  if (diferenciaY == 1 && ajedrez[moverY][moverX].contains(".") && diferenciaX == 0) {
								
								moveValido = true;
								eliminar = false;
								
							} else if (Math.abs(diferenciaY) == Math.abs(diferenciaX) && ajedrez[moverY][moverX].contains("[")){
								
								moveValido = true;
								eliminar = true;
								
							} else {
								
								moveValido = false;
							}
							
						} else {
							
							System.out.println("Movimiento invalido!");
							break;
							
						}
						
						break;
						
					case 'T':
						
						/* La torre se puede mover verticalmente y horizontalmente, hay que comprovar que no haya ninguna pieza
						 * en medio, para hacer esto se recorre un bucle depende si es vertical o horizontal y la direccion, el bucle
						 * recorrera todas las casillas por donde pasara la ficha y si en estas hay algo el movimento sera invalido.
						 * No comprueva la final en el bucle ya que esta se comprovara despues de este, para saber si es posible eliminar. */
						
						if (coordenadaX == moverX) { // Vertical
							
							for (int i = 1; i < Math.abs(diferenciaY); i++) {
								
								if (diferenciaY > 0) { //Abajo
									
									if (!(ajedrez[coordenadaY + i][coordenadaX].contains("."))) {
										
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
									
								} else  if (diferenciaY < 0) { // Arriba
									
									if (!(ajedrez[coordenadaY - i][coordenadaX].contains("."))) {
										
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
									
								} else {
									
									moveValido = false;
									break;
									
								}
								
							}
							
						} else if (coordenadaY == moverY) { // Horizontal
							
							for (int i = 1; i < Math.abs(diferenciaX); i++) {
								
								if (diferenciaX < 0) { // Izquierda
									
									if (!(ajedrez[coordenadaY][coordenadaX - i].contains("."))) {
										
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
									
								} else  if (diferenciaX > 0) { // Derecha
									
									if (!(ajedrez[coordenadaY][coordenadaX + i].contains("."))) {
										
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
									
								} else {
									
									moveValido = false;
									break;
									
								}
								
							}
							
						}
						
						if (Math.abs(diferenciaX) == 1 || Math.abs(diferenciaY) == 1) {
							
							if (ajedrez[moverY][moverX].contains("[") && jugador == 1) {
								
								moveValido = true;
								eliminar = true;
								
							} else if (ajedrez[moverY][moverX].contains("(") && jugador == 2) {
								
								moveValido = true;
								eliminar = true;
								
							}
							
						}
						
						if (ajedrez[moverY][moverX].contains("[") && jugador == 1 && moveValido == true) {
							
							eliminar = true;
							
						} else if (ajedrez[moverY][moverX].contains("(") && jugador == 2 && moveValido == true) {
							
							eliminar = true;
							
						}
						
						break;
						
					case 'A':
						
						/* El valor de un recorrido diagonal siempre cumplira la siguiente condicion: La diferencia entre las coordenadas
						 * de origen y las del final siempre seran las mismas. La unica diferencia sera las coordenadas restantes, tendran
						 * cuatro posibles combinaciones; (+-), (-+), (++) y (--). El bucle recorrera el camino de la posibilidad resultante
						 * comprovando que no haya nada en medio, al final se comprueva si la jugada eliminara una pieza.  */
						
						for (int i = 1 ; i < Math.abs(diferenciaX) ; i++) {
						
							if (diferenciaX == diferenciaY) { //Arriba izquierda y Abajo derecha
								
								if (diferenciaX > 0) { //Abajo derecha
									
									if (ajedrez[coordenadaY + i][coordenadaX + i].contains("(") || ajedrez[coordenadaY + i][coordenadaX + i].contains("[") ) {
										
										System.out.println("Hay una pieza en medio!");
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
									
								} else { // Arriba izquierda
									
									if (ajedrez[coordenadaY - i][coordenadaX - i].contains("(") || ajedrez[coordenadaY - i][coordenadaX - i].contains("[") ) {
										
										System.out.println("Hay una pieza en medio!");
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
									
								}
								
							} else if (-(diferenciaX) == (diferenciaY)) { // Abajo izquierda y Arriba derecha
								
								if (diferenciaX > 0) { // Abajo izquierda
									
									if (ajedrez[coordenadaY - i][coordenadaX + i].contains("(") || ajedrez[coordenadaY - i][coordenadaX + i].contains("[") ) {
										
										System.out.println("Hay una pieza en medio!");
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
									
								} else { // Arriba derecha
								
									if (ajedrez[coordenadaY + i][coordenadaX - i].contains("(") || ajedrez[coordenadaY + i][coordenadaX - i].contains("[") ) {
										
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
								
								}
								
							}
							
						}
						
						if (Math.abs(diferenciaX) == 1 || Math.abs(diferenciaY) == 1) {
							
							if (ajedrez[moverY][moverX].contains("[") && jugador == 1) {
								
								moveValido = true;
								eliminar = true;
								
							} else if (ajedrez[moverY][moverX].contains("(") && jugador == 2) {
								
								moveValido = true;
								eliminar = true;
								
							}
							
						}
						
						if (moveValido == true && (ajedrez[moverY][moverX].contains("[") && jugador == 1) || (ajedrez[moverY][moverX].contains("(") && jugador == 2)) {
							
							eliminar = true;
							break;
							
						} else {
							
							eliminar = false;
							break;
							
						}
						
						
					case 'C':
						
						/* El caballo siempre cumplira la siguiente condicion: El valor de las diferencias al hacer el movimiento nunca sera igual
						 * y estara en un rango maximo de 2. Asi que con el valor absoluto de las diferencias se puede ver si el movimiento
						 * ha sido valido o no.*/
						
						diferenciaX = (Math.abs(moverX-coordenadaX));
						diferenciaY = (Math.abs(moverY-coordenadaY));
						
						if (diferenciaX == 1 && diferenciaY == 2) {
						
							moveValido = true;
							
						} else if (diferenciaX == 2 && diferenciaY == 1) {
							
							moveValido = true;
							
						} else {
							
							moveValido = false;
							
						}
						
						if (ajedrez[moverY][moverX].contains("[") && jugador == 1 && moveValido == true) {
							
							eliminar = true;
							
						} else if (ajedrez[moverY][moverX].contains("(") && jugador == 2 && moveValido == true) {
							
							eliminar = true;
							
						}
						
						break;
					
					case 'Q': // La reina junta las comprovaciones de la torre y del alfil
						
						for (int i = 1 ; i < Math.abs(diferenciaX) ; i++) {
							
							if (diferenciaX == diferenciaY) { //Arriba izquierda y Abajo derecha
								
								if (diferenciaX > 0) { //Abajo derecha
									
									if (ajedrez[coordenadaY + i][coordenadaX + i].contains("(") || ajedrez[coordenadaY + i][coordenadaX + i].contains("[") ) {
										
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
									
								} else { // Arriba izquierda
									
									if (ajedrez[coordenadaY - i][coordenadaX - i].contains("(") || ajedrez[coordenadaY - i][coordenadaX - i].contains("[") ) {
										
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
									
								}
								
							} else if (-(diferenciaX) == (diferenciaY)) { // Abajo izquierda y Arriba derecha
								
								if (diferenciaX > 0) { // Abajo izquierda
									
									if (ajedrez[coordenadaY - i][coordenadaX + i].contains("(") || ajedrez[coordenadaY - i][coordenadaX + i].contains("[") ) {
										
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
									
								} else { // Arriba derecha
								
									if (ajedrez[coordenadaY + i][coordenadaX - i].contains("(") || ajedrez[coordenadaY + i][coordenadaX - i].contains("[") ) {
										
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
								
								}
								
							} 
							
						} // Fin bucle diagonal
						
						
						if (coordenadaX == moverX) { // Vertical (=torre)
							
							for (int i = 1; i < Math.abs(diferenciaY); i++) {
								
								if (diferenciaY > 0) { //Abajo
									
									if (!(ajedrez[coordenadaY + i][coordenadaX].contains("."))) {
										
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
									
								} else  if (diferenciaY < 0) { // Arriba
									
									if (!(ajedrez[coordenadaY - i][coordenadaX].contains("."))) {
										
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
									
								} else {
									
									moveValido = false;
									break;
									
								}
								
							}
							
						} else if (coordenadaY == moverY) { // Horizontal
							
							for (int i = 1; i < Math.abs(diferenciaX); i++) {
								
								if (diferenciaX < 0) { // Izquierda
									
									if (!(ajedrez[coordenadaY][coordenadaX - i].contains("."))) {
										
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
									
								} else  if (diferenciaX > 0) { // Derecha
									
									if (!(ajedrez[coordenadaY][coordenadaX + i].contains("."))) {
										
										moveValido = false;
										break;
										
									} else {
										
										moveValido = true;
										
									}
									
								} else {
									
									moveValido = false;
									break;
									
								}
								
							}
							
						}
						
						if (Math.abs(diferenciaX) == 1 || Math.abs(diferenciaY) == 1) {
							
							if (ajedrez[moverY][moverX].contains("[") && jugador == 1) {
								
								moveValido = true;
								eliminar = true;
								
							} else if (ajedrez[moverY][moverX].contains("(") && jugador == 2) {
								
								moveValido = true;
								eliminar = true;
								
							}
							
						}
						
						if (moveValido == true && (ajedrez[moverY][moverX].contains("[") && jugador == 1) || (ajedrez[moverY][moverX].contains("(") && jugador == 2)) {
							
							eliminar = true;
							break;
							
						} else {
							
							eliminar = false;
							break;
							
						}
						
						
					case 'K': // El rey se puede mover en un radio max de 1, eso signfica que la diferencia sera menor a 2 si el movimiento es valido.
						
						if (diferenciaX < 2 && diferenciaX > -2 && diferenciaY > -2 && diferenciaY < 2) { // Que este en un rango maximo de 1 de radio
							
							if (ajedrez[moverY][moverX].contains("[") && jugador == 1) {
								
								moveValido = true;
								eliminar = true;
								break;
								
							} else {
								
								moveValido = false;
								eliminar = false;
								
							} if (ajedrez[moverY][moverX].contains("(") && jugador == 2) {
								
								moveValido = true;
								eliminar = true;
								break;
								
							} else {
								
								moveValido = false;
								eliminar = false;
								
							}
							
							if ((ajedrez[moverY][moverX].contains("."))) {
								
								moveValido = true;
								eliminar = false;
								
							}
							
						}
						
						break;
					
					}
					
					//Mover y Eliminar (Paso 5)
					
					if (moveValido) {
						
						if (eliminar) {
							
							eliminadas += ajedrez[moverY][moverX] + " "; 
							ajedrez[moverY][moverX] = pieza;
							ajedrez[coordenadaY][coordenadaX] = " . ";
							
						} else {
							
							ajedrez[moverY][moverX] = pieza; //Mover
							ajedrez[coordenadaY][coordenadaX] = " . "; //Remplazar	
							
						}
						
						System.out.println("Eliminadas: " + eliminadas);
						
					}
					
					if (eliminadas.contains("K")) {
						
						reyMuerto = 1;
						
					}
					
					if (jugador == 1 && moveValido == true && reyMuerto == 0) {
						
						jugador = 2;
						
					} else if (jugador == 2 && moveValido == true && reyMuerto == 0){
						
						jugador = 1;
						
					}
					

			} while (correcto == false); // Paso 2 (Posicion a mover)

		}
		
		System.out.println("La partida se acabo, uno de los reyes ha muerto. \nEl ganador es: el jugador: " + jugador + "!");

	}
	
	public static String traducirCoordenadas () { // Metodo que devuelve una String con los dos numeros de coordenadas equivalentes
		
		/* Cuando el metodo se llama, este esperara a un input, que se pasara a mayusculas, mientras la longitud de
		 la string que se introduce no sea igual a 2, el bucle se mantendra. Cuando se introduce una string de 2 caracteres
		 pasa al siguiente paso. Primero comprueba si el primer caracter es una letra. Cuando tiene identificada la letra 
		 se pasa a int y se le resta 64 asi se consigue la coordenada equivalente, al final devuelve las coordenadas resultantes
		 como una String de numeros.*/
		
		String result = "";
		String input;
		
		Scanner scan = new Scanner(System.in);
		
		do {
			
			System.out.print("Coordenadas: ");
			
			input = scan.next().toUpperCase();
			
		} while (input.length() != 2);
		
		if (input.charAt(0) >= 65 && input.charAt(0) <= 90) {
			
			result += (input.charAt(1)) + String.valueOf((int)(input.charAt(0))-64);
		
		} else if (!(input.charAt(0) >= 65 && input.charAt(0) <= 90)) {
			
			result += (input.charAt(0)) + String.valueOf((int)(input.charAt(1))-64);
			
		} else {
			
			result = input;
		}
		
		return result;
		
	}

}
