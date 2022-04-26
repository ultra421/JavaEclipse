package main;

import java.util.Scanner;

public class Actividad04_Switch {

	public static void main(String[] args) {

		boolean invalido = false;
		Scanner input = new Scanner(System.in);
		String eleccion;
		
		/*El programa esta en multiples bucles en cada paso, estos bucles son do y solo se repiten si
		 * la respuesta del usuario es invalida, entones invalido = true, cuando es una respuesta valida
		 * entonces invalido = false. El programa no solo acepta la letra inicial de la pal, tambien la
		 * palabra en si. */

		do {
			invalido = false;
			do {

				invalido = false;
				System.out.println("Inserta el modelo de coche (A o B)");
				eleccion = input.next().toUpperCase();

				switch (eleccion) {

				case "A":

					invalido = false;
					do {
						System.out.println("Electrico (E) o Gasolina (G)?");
						eleccion = input.next().toUpperCase();

						switch (eleccion) {

						case "E":
						case "ELECTRICO":
						case "ELÉCTRICO":
							invalido = false;

							do {
								System.out.println("Color blanco (B) o otro (O)?");
								eleccion = input.next().toUpperCase();

								switch (eleccion) {

								case "B":
								case "BLANCO":
									invalido = false;
									System.out.println("El precio es 233.24€");

									break;
								case "O":
								case "OTRO":

									System.out.println("El precio es 235.50€");
									invalido = false;

									break;

								default:
									System.out.println("Respuesta no valida");
									invalido = true;
									break;

								} // Electrico color
							} while (invalido == true);

							break; // caso E

						case "G":
						case "GASOLINA":
							invalido = false;
							do {
								System.out.println("Color gris (G) o otro (O)?");
								eleccion = input.next().toUpperCase();

								switch (eleccion) {

								case "G":
								case "GRIS":
									invalido = false;
									System.out.println("El precio es 340.10€");

									break;
								case "O":
								case "OTRO":
									invalido = false;
									System.out.println("El precio es 253.38€");

									break;

								default:
									System.out.println("Respuesta no valida");
									invalido = true;
									break;

								} // Gasolina color
							} while (invalido == true);

							break; // Caso G

						default:
							System.out.println("Respuesta no valida");
							invalido = true;

							break; // default caso E o G del A

						} // A Electrico o Gas

					} while (invalido == true);

					break;

				case "B":
					invalido = false;
					do {
						System.out.println("Electrico (E) o Gasolina (G)?");
						eleccion = input.next().toUpperCase();

						switch (eleccion) {

						case "E":
						case "ELECTRICO":
						case "ELÉCTRICO":

							invalido = false;
							do {
								System.out.println("Color blanco (B) o otro (O)?");
								eleccion = input.next().toUpperCase();

								switch (eleccion) {

								case "B":
								case "BLANCO":
									invalido = false;
									System.out.println("El precio es 251.32€");

									break;
								case "O":
								case "OTRO":
									invalido = false;
									System.out.println("El precio es 272.20€");

									break;

								default:
									System.out.println("Respuesta no valida");
									invalido = true;
									break;

								} // Electrico color
							} while (invalido == true);

							break;

						case "G":
						case "GASOLINA":
							invalido = false;
							do {
								System.out.println("Color gris (G) o otro (O)?");
								eleccion = input.next().toUpperCase();

								switch (eleccion) {

								case "G":
								case "GRIS":
									invalido = false;
									System.out.println("El precio es 351.14€");

									break;
								case "O":
								case "OTRO":
									invalido = false;
									System.out.println("El precio es 279.10€");

									break;

								default:
									System.out.println("Respuesta no valida");
									invalido = true;
									break;

								} // Gasolina color
							} while (invalido == true);

							break;

						default:
							System.out.println("Respuesta no valida");
							invalido = true;

							break;

						} // B Electrico o gas
					} while (invalido == true);

					break; // Caso B

				default:
					System.out.println("Respuesta no valida");
					invalido = true;

					break; // Caso default
				}

			} while (invalido == true);

		} while (invalido == true);

	}

}
