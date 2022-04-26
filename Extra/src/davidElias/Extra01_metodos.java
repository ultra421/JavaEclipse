//En esta version utilizo metodos para completar el ejercicio

package davidElias;

import java.util.Scanner;
import java.util.Random;

public class Extra01_metodos {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int alumnos[] = new int[27];
		int profesores[] = new int[10];
		boolean debug = false;

		System.out.println("Hay 27 alumnos");
		System.out.println("Hay 10 profesores");

		System.out.println("Debug? (Llenar array de numeros) true || false?");
		debug = input.nextBoolean();

		if (debug != false) {

			System.out.println("DEBUG TRUE");

			Random rng = new Random();

			System.out.println("alumnos:");

			for (int i = 0; i <= alumnos.length - 1; i++) {

				alumnos[i] = rng.nextInt(10) + 18;
				System.out.print(alumnos[i] + " ");

			}
			System.out.println();
			System.out.println("profesores:");

			for (int i = 0; i <= profesores.length - 1; i++) {

				profesores[i] = rng.nextInt(30) + 24;
				System.out.print(profesores[i] + " ");

			}

			System.out.println();

		}

		// Input edades

		for (int i = alumnos.length; i != 0 && debug != true; i--) {

			System.out.println("Introduce la edad del alumno numero " + ((alumnos.length + 1) - i));

			alumnos[alumnos.length - i] = input.nextInt();

		}

		for (int i = profesores.length; i != 0 && debug != true; i--) {

			System.out.println("Introduce la edad del profesor numero " + ((profesores.length + 1) - i));

			profesores[profesores.length - i] = input.nextInt();

		}

		alumnos = ordenar(alumnos);
		profesores = ordenar(profesores);

		System.out.println("La media de los alumnos = " + media(alumnos));

		// Edad grandes/pequenyas profesores

		System.out.println("La edad mas pequeña de de los profesores es = " + profesores[0]);
		System.out.println("La edad mas grande de los profesores es = " + profesores[profesores.length - 1]);

		// Edad grandes/pequenyas alumnos

		System.out.println("La edad mas pequeña de de los alumnos es = " + alumnos[0]);
		System.out.println("La edad mas grande de los alumnos es = " + alumnos[alumnos.length - 1]);

		// Moda

		System.out.println("La moda de los alumnos es = " + moda(alumnos));
		System.out.println("la moda de los profesores es = " + moda(profesores));

		// Mediana

		System.out.println("La mediana de los alumnos es = " + mediana(alumnos));
		System.out.println("La mediana de los profesores es = " + mediana(profesores));

		// Tipica

		System.out.println("La desviacion tipica de los alumnos es = " + tipica(alumnos, media(alumnos)));
		System.out.println("La desviacion tipica de los profesores es = " + tipica(profesores, media(profesores)));

	}

	public static int[] ordenar(int a[]) {

		int memoria[] = new int[2];

		for (int i = 0; i != a.length - 1; i++) {

			memoria[0] = a[i];

			if (i > 0) {

				if (a[i] > a[i + 1]) {

					memoria[1] = a[i + 1];

					a[i + 1] = memoria[0];

					a[i] = memoria[1];

					if (a[i] < a[i - 1]) {

						i -= 2;

					}
				}

			} else if (i == 0) {

				if (a[i] > a[i + 1]) {

					memoria[1] = a[i + 1];

					a[i + 1] = memoria[0];

					a[i] = memoria[1];

				}

			}
		}

		return a;

	}

	public static float media(int a[]) { // a = matriz edades

		float media = 0;

		for (int i = 0; i != a.length; i++) {

			// System.out.print(profesores[i] + " ");
			media += a[i];

		}

		media /= a.length;

		return media;

	}

	public static int moda(int a[]) { // a = matriz edades

		int veces[] = new int[3];

		veces[0] = 0;

		for (int i = 0; i < a[a.length - 1]; i++) {

			for (int k = 0; k < a.length - 1; k++) {

				if (a[k] == i) {

					veces[0] += 1;

				}

				if (veces[0] > veces[1]) {

					veces[1] = veces[0];
					veces[2] = i;

				}

				if (veces[0] == veces[1]) {

				}

			}
			veces[0] = 0;

		}

		return veces[2];

	}

	public static float mediana(int a[]) { // a = matriz edades

		float mediana;

		if (a.length % 2 == 0) {

			mediana = (a[a.length / 2] + a[(a.length / 2) - 1]) / 2;

		} else {

			mediana = (a[(a.length - 1) / 2]);

		}

		return mediana;

	}

	public static double tipica(int a[], float b) { // a = matriz edades | b = media

		double desviacionTipica = 0;

		for (int i = 0; i < a.length; i++) {

			desviacionTipica += Math.pow((a[i] - b), 2);

		}

		desviacionTipica = Math.sqrt(desviacionTipica / a.length);

		return desviacionTipica;

	}

}
