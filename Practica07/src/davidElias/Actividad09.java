package davidElias;

import java.util.Arrays;
import java.util.Scanner;

public class Actividad09 {

	public static void main(String[] args) {
		
		//Este ejercicio pensaba que iva a repetir muchas lineas de codigo. Asi que todas las partes que pensaba
		//que se ivan a reptir las meti dentro de una funcion, al final solo tenia sentido utilizar una de estas funciones
		//mas de una vez (la de print), he documentado lo que hace cada funcion en la funcion y no cuando se usan.

		Scanner input = new Scanner(System.in);
		String matriz[][] = new String[3][3];
		String introducir = "";
		int turno = 0;
		String coordenadaNoSplit = "";
		int repeticiones;
		int enRaya = 0;
		String coordenada[];

		for (int i = 0; i < matriz.length; i++) {

			Arrays.fill(matriz[i], "·"); //Llenar array de "."

		}

		do {

			repeticiones = (espacioVacio(matriz, "·")); //Repeticiones de .

			if (repeticiones > 0) {

				Print(matriz); 

				if (turno == 1) { // Cambiar char a introducir
					introducir = "O";

				} else {
					introducir = "X";

				}

				// Coordenada[0] = filas | Coordenada [1] = columnas |
				
				boolean correcta = false;

				do {

					System.out.println("Se introducira: " + introducir);
					System.out.println("Introduce las coordenadas en el siguiente formato: (X.Y)");
					coordenadaNoSplit = input.next();

					coordenada = coordenadaNoSplit.split("\\."); // Separa la coordenada introducida entre el .
				
				if (coordenadaNoSplit.contains(".")) {	 // Comprovar que no se salga del limtie
					
					if (Integer.parseInt(coordenada[0]) < 1 || (Integer.parseInt(coordenada[0]) > 3)) {
						
						System.out.println("Coordenada [X] fuera del limite");
						correcta = false;
						
					} else if (Integer.parseInt(coordenada[1]) < 1 || (Integer.parseInt(coordenada[1]) > 3)) {
						
						System.out.println("Coordenada [Y] fuera del limite");
						correcta = false;
						
					} else {
						
						correcta = true;
						
					}
					
				} else { // Comprovar si tiene la coordenada tiene un .
					
					System.out.println("Porfavor, inserta las coordenadas el formato indicado");
					
				}
					
				} while (correcta == false); // Separar coords para input con x.y

				if (matriz[Integer.parseInt(coordenada[1]) - 1][Integer.parseInt(coordenada[0]) - 1].equals("·")) {

					matriz[Integer.parseInt(coordenada[1]) - 1][Integer.parseInt(coordenada[0]) - 1] = introducir;

					if (turno == 1) { // Cambiar turno jugador

						turno = 0;

					} else {

						turno = 1;

					}

				}

				else {

					System.out.println("Esas coordenadas se encuentran en uso");

				}

				enRaya = Comprovar(matriz, introducir);

			} else if (repeticiones == 0 && enRaya != 3) {

				Print(matriz);
				System.out.println("Empate!");
				break;

			}

		} while (enRaya != 3); // mientras no haya 3 numeros en raya la partida sigue

		if (enRaya == 3)

		{
			Print(matriz);
			System.out.println("El ganador es: " + introducir);
		}
		
		input.close();

	}

	public static void Print(String a[][]) { // Print de el tablero con las coordenadas
		
		System.out.println("  1 2 3");

		for (int i = 0; i < a.length; i++) {
			
			System.out.print(i+1+ " ");

			for (int k = 0; k < a[0].length; k++) {

				System.out.print(a[i][k] + " ");

			}
			System.out.println();

		}

	}

	public static int Comprovar(String a[][], String input) { // Comprueva si estan en raya...

		int repeticionesLinea = 0;

		for (int i = 0; i < a.length; i++) { // Columnas (Vertical)

			repeticionesLinea = 0;

			for (int k = 0; k < a[0].length; k++) {

				if (a[i][k].equals(input)) {

					repeticionesLinea += 1;

					// System.out.println("Repeticiones 1 = " + repeticionesLinea);

				}

				if (repeticionesLinea > 2) {

					return repeticionesLinea;

				}

			}

		}

		for (int i = 0; i < a.length; i++) { // Filas (Horizontal)

			repeticionesLinea = 0;

			for (int k = 0; k < a[0].length; k++) {

				if (a[k][i].equals(input)) {

					repeticionesLinea += 1;

					// System.out.println("Repeticiones 2 = " + repeticionesLinea);

				}

				if (repeticionesLinea > 2) {

					return repeticionesLinea;

				}

			}

		}
		repeticionesLinea = 0; // Diagonal arriba izquierda -> abajo derecha

		int k = 0;
		int i = 0;

		for (int x = 0; x < 3; x++) {

			if (a[k][i].equals(input)) {

				repeticionesLinea++;

				// System.out.println("Repeticiones 3 = " + repeticionesLinea);

			}

			k++;
			i++;

			if (repeticionesLinea == 3) {

				return repeticionesLinea;

			}

		}

		// Diagonal arriba derecha -> abajo izquierda

		k = 0;
		i = 2;
		repeticionesLinea = 0;

		for (int x = 0; x < 3; x++) {

			if (a[k][i].equals(input)) {

				repeticionesLinea++;

				// System.out.println("Repeticiones 4 = " + repeticionesLinea);

			}

			k++;
			i--;

			if (repeticionesLinea == 3) {

				return repeticionesLinea;

			}

		}

		return 1;

	}

	public static int espacioVacio(String a[][], String b) { // a = Matriz , b = Caracter a comprovar repeticioens

		int repeticiones = 0;

		for (int i = 0; i < a.length; i++) {

			for (int k = 0; k < a[0].length; k++) {

				if (a[i][k].equals(b)) {

					repeticiones += 1;

				}

			}

		}
		return repeticiones;

	}

}
