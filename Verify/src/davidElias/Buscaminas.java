package davidElias;
import java.util.Scanner;
import java.util.Random;

public class Buscaminas {
	
public static String[][][] abrirCampo (String[][][] input, int coordY, int coordX) { // Pos 0 campo / Pos 1 CampoMinas
		
		/* Esta funcion hace dos cosas, primero comprueva cuantas minas hay alrededor para marcar el numero en la casilla. Para ver todas las 8 casillas que hay
		 * alrededor del punto seleccionado utilizo dos bucles con un rango de valores de -1 hasta 1. Resto estos valores a las coordenadas de la casilla
		 * seleccionada para llegar a las casillas que hay alrededor. */
		
		int veces = 0;
		
		for (int i = -1; i < 2; i++  ) {
			
			for (int k = -1; k < 2; k++) {
				
				if (coordY-k >= 0 && coordX-i >= 0 && coordY-k <= input[0].length-1 && coordX-i <= input[0][0].length-1) {
				
					if (input[1][coordY-k][coordX-i].contains("X")) {
						
						veces++;
						
					}
				}
			}
			
		}
		
		/* Mientras la variable veces sea mas grande que 0 se imprimiran en la casilla las minas que hay alrededor. */
			
		input[0][coordY][coordX] = (" " +Integer.toString(veces) + " ");
			
		if (veces == 0) { // No hay ninguna alrededor */
			
			/* Esta es la parte que se encarga de abrir el campo alrededor en el caso que no haya ninguna mina al lado. Marca la casilla actual con un 0 y mira
			 * las casillas que hay alrededor suyo en forma de cruz, sin mirar las diagonales. Para hacer esto utilizo el mismo bucle que el de analizar las
			 * de alrededor pero con varias condiciones. Si la casilla en la que se esta ejecutando el metodo no esta rodeada por ninguna mina, se ejecuta asi mismo
			 * en esas. Una vez abierto esa parte del campo se marca con una O en el campominas, asi no se volvera a ejecutar en el mismo punto, con esto se evita
			 * un erorr de recursividad infinita. */
			
			input[0][coordY][coordX] = " 0 ";
			
			for (int i = -1; i < 2; i++  ) {
				
				for (int k = -1; k < 2; k++) {
					
					if (coordY-k >= 0 && coordX-i >= 0 && coordY-k <= input[0].length-1 && coordX-i <= input[0][0].length-1) { // Comprovar que la coordenada este dentro los limites
						
						if (!(input[1][coordY-k][coordX-i].contains("O")) && !(input[1][coordY-k][coordX-i].contains("X"))) {
						
							input[1][coordY-k][coordX-i] = " O "; // En el campoMinas marcar si ha sido comprovado
							
							input = abrirCampo(input, coordY-k, coordX-i);
					
						}
							
					}
						
				}
				
			}
			
		}
		
		return input;
		
	} 

	public static void main(String[] args) {
		
		System.out.println("Escoge un nivel de dificultad: (Porfavor introduce el numero)");
		System.out.println("Nivel 1: Campo de 5x5, pocas minas \nNivel 2: Campo de 7x7, minas frequentes \nNivel 3: Campo de 9x9, minas mas frequentes\nNivel 4: Personalizado");
		
		Scanner scan = new Scanner(System.in);
		
		int x = 1; // las variables x,y iniciadas a 1 para evitar errores en el caso que se introduzca un numero de dificultad invalido (genera un campo 1x1)
		int y = 1; 
		int frequenciaMinas = 0; 
		Random rng = new Random();
		int coordX = 0;
		int coordY = 0;
		String tipo = "X";
		int cantidadMinas = 0;
		
		boolean debug = true; // <- Debug (true para ver el campo de minas / false para esconderlo)
		
		switch (scan.nextInt()) {
		
		case 1:
			
			x = 5;
			y = 5;
			frequenciaMinas = 9;
			
			break;
		case 2:
			
			x = 7;
			y = 7;
			frequenciaMinas = 6;
			
			break;
		case 3:
			
			x = 9;
			y = 9;
			frequenciaMinas = 5;
			
			break;
		case 4: // Dimensiones personalizadas, dimensiones que esten por encima de 10 no funcionan bien (el campo no es visualmente agradable)
			
			System.out.println("Introduce las dimensiones horizontales");
			x = scan.nextInt();
			System.out.println("Introduce las dimensiones verticales");
			y = scan.nextInt();
			
			System.out.println("Introduce la media de celdas entre minas (Cuanto mas bajo mas minas)");
			frequenciaMinas = scan.nextInt();
			
			break;
			
		default:
			System.out.println("Has introducido un numero invalido");
			break;
		
		
		}
		
		String campo[][] = new String[x][y]; // El campo que ve el usuario, donde marcara donde hay minas y comprovara
		String campoMinas[][] = new String[x][y]; //EL campo de donde estan las minas.
		
		for (int i = 0; i < y; i++ ) {     // Bucle que consigue llenar el campo de minas, genera numero aleatorio con maximo de frequenciaMinas,
			for (int j = 0; j < x; j++ ) { // si es == 1 planta mina. El bucle tambien aprovecha para llenar el campo normal.
				
				if (rng.nextInt(frequenciaMinas) == 1) {
					
					campoMinas[i][j] = " X ";
					cantidadMinas++;
					
				} else {
					
					campoMinas[i][j] = " . ";
					
				}
				
				campo[i][j] = " · ";
				
			}
			
			
		}
		
		boolean partida = true;
		
		while (partida == true) { // Impresion del campo de minas con los numeros 
			
			System.out.print("   ");
			
			for (int i = 1; i <= x; i++) {
				
				System.out.print(" " + i + " ");
				
			} System.out.print("\n");
			
			for (int i = 0; i < y ; i++) {
				
				System.out.print(i + 1 + " |");
				
				for (int k = 0; k < x; k++) {
					
					System.out.print(campo[i][k]);
					
				} System.out.println();
				
			} 
			
			 if (debug = true) { System.out.println("Minas");  // Debug <- Ver campo minas
				
				for (int i = 0; i < y ; i++) {
					
					for (int k = 0; k < x; k++) {
						
						System.out.print(campoMinas[i][k]);
						
					} System.out.println();
					
				}
				
			} 
			
			System.out.println("Introduce la coordenada que quieras comprovar");
			
			do { //Bucle que seguria hasta que las coordenadas introducidas y el tipo introducido sea valido
			
			System.out.print("\nCoordenada horizontal: ");
			coordX = scan.nextInt();
			coordX--;
			System.out.print("\nCoordenada vertical: ");
			coordY = scan.nextInt();
			coordY--;
			System.out.print("Tipo de movimiento (X = marcar | O = comprovar): ");
			tipo = Character.toString(scan.next().toUpperCase().charAt(0)); //Siempre cojera un caracter que sera el primero que se introduzca en mayusculas.
			
			} while (!(coordX < x && coordX >= 0 && coordY < y && coordY >= 0 && (tipo.contains("X") || tipo.contains("O"))));
			
			if (tipo.contains("X")) { // X = marcar / O = comprovar
				
				campo[coordY][coordX] = " X ";
				
			} else if (campoMinas[coordY][coordX].contains("X") && tipo.contains("O")){ // Si las coordenadas del campoMinas contienen la X y el tipo es O (comprovar) Game Over
				
				partida = false;
				System.out.println("Has explotado una mina! GAME OVER");
				
			} else { //Esto se cumplira cuando la casilla seleccionada este vacia
				
				/*Cuando en el buscaminas seleccionas una casilla y las de alrededor estan libres de bombas, estas tambien se vacian y asi se abre un campo de casillas */
				
				String[][][] campos = {campo,campoMinas};  // Esta array de matrizes guarda ambos campos en la posicion 0 (campo normal) y posicion 1 (campoMinas)
				campos = abrirCampo(campos,coordY,coordX); // Para poder introducirlos y devovlerlos en este metodo. (Un metodo solo devuelve 1 variable).
				
				campo = campos[0]; 						   // Extraccion del valor final de los campos de la array campos
				campoMinas = campos[1];
				
			}
			
			int cantidadMinasScan = 0; // Comprovacion de que todas las minas esten marcadas como tal, si estan marcadas la partida acaba con un mensaje de victoria
			
			for (int i = 0; i < y; i++) {
				
				for (int k = 0; k < x; k++) {
					
					if (campo[i][k].contains("X")) {
						
						if (campo[i][k].equals(campoMinas[i][k])) {
							
							cantidadMinasScan++;
							
						} else {
							
							break;
							
						}
						
					}
					
				}
			}
			
			if (cantidadMinasScan == cantidadMinas) {
				
				partida = false;
				System.out.println("Has ganado! Todas las minas han sido marcadas.");
				
			}
			
		} // Fin de bucle partida

	} 
	
}
