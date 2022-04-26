package davidElias;

import java.util.Scanner;

public class Ajedrez2 {

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
		float coordenada;
		int coordenadaX;
		int coordenadaY;
		int moverX;
		int moverY;
		Scanner input = new Scanner(System.in);
		boolean correcto = false;
		String pieza;
		String eliminadas = "";

		while (reyMuerto == 0) { // Paso 1
			
			System.out.println("   1  2  3  4  5  6  7  8");

			for (int i = 0; i < ajedrez.length; i++) {
				
				System.out.print(i+1 + " ");

				for (int k = 0; k < ajedrez.length; k++) {

					System.out.print(ajedrez[i][k]);

				}

				System.out.println();

			}

			do { //Paso 2 Input de coords

				System.out.println("Jugador actual: " + jugador);
				System.out.println("Introduce la coordenada de la pieza que desees mover");
				System.out.println("Utiliza el siguiente formato: (X,Y)");

				coordenada = input.nextFloat();

				coordenadaX = (int) coordenada;

				coordenadaY = Math.round((coordenada - (int) coordenada) * 10);

				if (coordenadaX > 0 && coordenadaX < 9) {

					correcto = true;

				} else {

					correcto = false;
					System.out.println("Introduce unas coordenadas las cuales esten dentro del margen de 8x8");
					continue;

				}
				
				if (coordenadaY > 0 && coordenadaY < 9) {

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
					
				/*} else if (jugador == 2 && ajedrez[coordenadaY][coordenadaX].contains(".")) {
					
					System.out.println("Espacio vacio");
					continue; */ 								//Eliminar si no es necesario
					
				
				//Mover donde? y si es valido
				
				do { // Paso 3
					
					System.out.println("Introduce la coordenada hacia donde deseas moverte");
					System.out.println("Utiliza el siguiente formato: (X,Y)");

					coordenada = input.nextFloat();

					moverX = (int) coordenada; // Coord X

					moverY = Math.round((coordenada - (int) coordenada) * 10); // Cord Y 
					
					moverX -= 1; // Que no se salgan de los limites
					moverY -= 1;

					if ((moverX >= 0 && moverX <= 8) && (moverY >= 0 && moverY <= 8)) { // Comprovar que este dentro d limites

						if (jugador == 1 && ajedrez[moverY][moverX].contains("(")) {
							
							correcto = false;
							System.out.println("Esas coordenadas estan en tu propia ficha!");
							
						} else if ((jugador == 2 && ajedrez[moverY][moverX].contains("{"))) {
							
							correcto = false;
							System.out.println("Esas coordenadas estan en tu propia ficha!");
							
						} else {
							
							correcto = true;
							
						}
						

					} else {

						correcto = false;
						System.out.println("Introduce unas coordenadas las cuales esten dentro del margen de 8x8.");

					}
					
					} while (correcto == false);
				
					// Piezas logica (Paso 4) //moverX y coordenadaX
					
					boolean moveValido = false;
					boolean eliminar = false;
					String mover = ajedrez[moverY][moverX]; // Parte de la tabla a donde se movera
					int veces = 0;
					
					pieza = ajedrez[coordenadaY][coordenadaX];
					
					int diferenciaX = moverX - coordenadaX;
					int diferenciaY = moverY - coordenadaY;
					
					switch (ajedrez[coordenadaY][coordenadaX].charAt(1)) { 
					// Coje el char de la pieza que da informacion sobre que tipo es y cambia el case segun cual sea
					
					case 'P': //Peon tiene que eliminar piezas en diagonal
						
						if (pieza.contains("(")) { //Blanca
							
							if (coordenadaY == 6 && coordenadaY-moverY == 2 && coordenadaX-moverX == 0 && mover.contains(".") && (ajedrez[coordenadaY-1][coordenadaX].contains("."))) { 
								//Esta en origen? Si cumple mover 2
								
								moveValido = true;
								break;
								
							} else if (coordenadaY - moverY == 1 && coordenadaX-moverX == 0 && mover.contains(".") ) {
								//Mover vertical si casilla movimiento no contiene nada
								
								moveValido = true;
								break;
								
							} else if (coordenadaY - moverY == 1 && (coordenadaX-moverX == 1 || coordenadaX-moverX == -1) && (!mover.contains(".")) ) {
								//Comprovar si Y es valida, X es valida y si hay alguna ficha
								
								eliminar = true;
								moveValido = true;
								break;
								
							}
							
						} else if (pieza.contains("[")) { //Negra
							
							if (coordenadaY == 1 && coordenadaY-moverY == -2 && coordenadaX-moverX == 0 && mover.contains(".") && (ajedrez[coordenadaY+1][coordenadaX].contains("."))) { 
								//Esta en origen? Si cumple mover 2
								
								moveValido = true;
								break;
								
							} else if (coordenadaY - moverY == -1 && coordenadaX-moverX == 0 && mover.contains(".")) {
								//Mover vertical si casilla movimiento no contiene nada
								
								moveValido = true;
								break;
								
							} else if (coordenadaY - moverY == -1 && (coordenadaX-moverX == 1 || coordenadaX-moverX == -1) && !(mover.contains(".")) ) {
								//Comprovar si Y es valida, X es valida y si hay alguna ficha
								
								eliminar = true;
								moveValido = true;
								break;
								
							}
							
						} else {
							
							System.out.println("Movimiento invalido!");
							break;
							
						}
						
					case 'T':
						
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
						
						if (ajedrez[moverY][moverX].contains("[") && jugador == 1 && moveValido == true) {
							
							eliminar = true;
							
						} else if (ajedrez[moverY][moverX].contains("(") && jugador == 2 && moveValido == true) {
							
							eliminar = true;
							
						}
						
						break;
						
					case 'A':
						
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
						
						if (moveValido == true && (ajedrez[moverY][moverX].contains("[") && jugador == 1) || (ajedrez[moverY][moverX].contains("(") && jugador == 2)) {
							
							eliminar = true;
							break;
							
						} else {
							
							eliminar = false;
							break;
							
						}
						
						
					case 'C':
						
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
					
					case 'Q':
						
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
						
						
						if (moveValido == true && (ajedrez[moverY][moverX].contains("[") && jugador == 1) || (ajedrez[moverY][moverX].contains("(") && jugador == 2)) {
							
							eliminar = true;
							break;
							
						} else {
							
							eliminar = false;
							break;
							
						}
						
						
					case 'K':
						
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
							
						} else {
							
							System.out.println("Rey no");
							
						}
						
						break;
					
					}
					
					//Mover y Eliminar (Paso 5)
					
					//System.out.println("Mover debug1 = " + moverX + " " + moverY);  
					
					//System.out.println("Move valido = " + moveValido );
					
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
					
					if (jugador == 1 && moveValido == true && reyMuerto == 0) {
						
						jugador = 2;
						
					} else if (jugador == 2 && moveValido == true && reyMuerto == 0){
						
						jugador = 1;
						
					}
					
					if (eliminadas.contains("K")) {
						
						reyMuerto = 1;
						
					}
					

			} while (correcto == false); // Paso 2 (Posicion a mover)

		}
		
		System.out.println("La partida se acabo, uno de los reyes ha muerto. \nEl ganador es: el jugador: " + jugador + "!");

	}

}
