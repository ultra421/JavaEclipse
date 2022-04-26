package davidElias;

import java.util.Scanner;
import java.util.Random;

public class Extra {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		int alumnos[] = new int[27];
		int profesores[] = new int[10];
		boolean debug = false; int memoria[] = new int[2];
		float mediaProf = 0; float mediaAlum = 0; int veces [] = new int[3];
		
		System.out.println("Hay 27 alumnos");
		System.out.println("Hay 10 profesores");
		
		System.out.println("Debug? (Llenar array de numeros) true || false?");
		debug = input.nextBoolean();
		
		if (debug != false) {
			
			System.out.println("DEBUG TRUE");

			Random rng = new Random();
			
			System.out.println("alumnos:");
			
			for (int  i = 0; i <= alumnos.length-1; i++) {
				
				alumnos[i] = rng.nextInt(10)+18;
				System.out.print(alumnos[i] + " ");
				
			}
			System.out.println();
			System.out.println("profesores:");
			
			for (int  i = 0; i <= profesores.length-1; i++) {
				
				profesores[i] = rng.nextInt(30)+24;
				System.out.print(profesores[i] + " ");
				
			}
			
			System.out.println();
			
		}
		
		//Input edades
		
		for (int i = alumnos.length; i != 0  && debug != true; i--) {
			
			System.out.println("Introduce la edad del alumno numero " + ((alumnos.length+1)-i));
			
			 alumnos[alumnos.length-i] = input.nextInt(); 
			
		}
		
		for (int i = profesores.length; i != 0 && debug != true; i--) {
			
			System.out.println("Introduce la edad del profesor numero " + ((profesores.length+1)-i));
			
			profesores[profesores.length-i] = input.nextInt();
			
		}
		
		//Ordenar edades (No sabia que habia una funcion para ordenar arrays)
		
		//Profes
		
		for (int i = 0; i != profesores.length-1; i++) {
			
			memoria[0] = profesores[i];
				
			if (i > 0) {
			
				if (profesores [i] > profesores [i+1]) {
					
					memoria [1] = profesores [i+1];
					
					profesores [i+1] = memoria [0];
					
					profesores [i] = memoria [1];
					
					if (profesores [i] < profesores [i-1]) {
						
						i -= 2;
						
					}
				}
				
			} else if ( i == 0) {
				
				if (profesores [i] > profesores [i+1]) {
					
					memoria [1] = profesores [i+1];
					
					profesores [i+1] = memoria [0];
					
					profesores [i] = memoria [1];
					
				}
				
			}
		}
		
		//Alumnos
		
		for (int i = 0; i != alumnos.length-1; i++) {
			
			memoria[0] = alumnos[i];
				
			if (i > 0) {
			
				if (alumnos [i] > alumnos [i+1]) {
					
					memoria [1] = alumnos [i+1];
					
					alumnos [i+1] = memoria [0];
					
					alumnos [i] = memoria [1];
					
					if (alumnos [i] < alumnos [i-1]) {
						
						i -= 2;
						
					}
				}
				
			} else if ( i == 0) {
				
				if (alumnos [i] > alumnos [i+1]) {
					
					memoria [1] = alumnos [i+1];
					
					alumnos [i+1] = memoria [0];
					
					alumnos [i] = memoria [1];
					
				}
				
			}
		}

		//Media de edades
		
		for (int i = 0; i != profesores.length; i++) {
			
			//System.out.print(profesores[i]  + " ");
			mediaProf += profesores[i];
			
			
		} 
		mediaProf = (mediaProf/profesores.length);
		System.out.println("La media de los profesores es = " + mediaProf);
		
		for (int i = 0; i != alumnos.length; i++) {
			
			//System.out.print(alumnos[i] + " ");
			mediaAlum += alumnos[i];
			
		} 
		mediaAlum = (mediaAlum/alumnos.length);
		System.out.println("La media de los alumnos es = " + mediaAlum);
		
		//Edad grandes/pequenyas profesores
		
		System.out.println("La edad mas pequeña de de los profesores es = " + profesores[0]);
		System.out.println("La edad mas grande de los profesores es = " + profesores[profesores.length-1]);
		
		//Edad grandes/pequenyas alumnos
		
		System.out.println("La edad mas pequeña de de los alumnos es = " + alumnos[0]);
		System.out.println("La edad mas grande de los alumnos es = " + alumnos[alumnos.length-1]);
		
		//Moda (alumn) veces [0] = veces repetidas // veces [1] = veces repetidas MAX // veces[2] = num repetido MAX
		
		veces [0] = 0;
		
		for (int i = 0; i < profesores[profesores.length-1]; i++) {
			
			for (int k = 0; k < profesores.length-1; k++) {
				
				if (profesores[k] == i) {
					
					veces[0] += 1;
					
				}
				
				if (veces[0] > veces[1]) {
					
					veces[1] = veces[0];
					veces[2] = i; 
					
				}
				
				if (veces[0] == veces[1]) {
					
					
				}
				
			} veces [0] = 0;
			
		}
		
		System.out.println("La moda de la edad de los profesores = " + veces[2]);
		veces[0] = 0;
		veces[1] = 0;
		veces[2] = 0;
		
		//Moda (alum) veces [0] = veces repetidas // veces [1] = veces repetidas MAX // veces[2] = num repetido MAX
		
		for (int i = 0; i < alumnos[alumnos.length-1]; i++) {
			
			for (int k = 0; k < alumnos.length-1; k++) {
				
				if (alumnos[k] == i) {
					
					veces[0] += 1;
					
				}
				
				if (veces[0] > veces[1]) {
					
					veces[1] = veces[0];
					veces[2] = i; 
					
				}
				
			} veces [0] = 0;
			
		}
		
		System.out.println("La moda de la edad de los alumnos = " + veces[2]);
		
		//Mediana
		
		float mediana;
		
		if (alumnos.length % 2 == 0) {
			
			mediana = (alumnos[alumnos.length/2] + alumnos[(alumnos.length/2)+1]) / 2;
			System.out.println("La mediana de los alumnos = " + mediana);
			
		} else {
			
			mediana = (alumnos[(alumnos.length)/2+1]);
			System.out.println("La mediana de los alumnos = " + mediana );
			
		}
		
		if (profesores.length % 2 == 0) {
			
			mediana = (profesores[profesores.length/2] + profesores[(profesores.length/2)-1]) / 2;
			System.out.println("La mediana de los profesores = " + mediana);
			
		} else {
			
			mediana = (profesores[(profesores.length-1)/2]);
			System.out.println("La mediana de los profesores = " + mediana );
			
		}
		
		
		
		// Desviacion tipica Alum
		
		double desviacionTipica = 0;
		
		for (int i = 0; i < alumnos.length; i++) {
			
			desviacionTipica += Math.pow((alumnos[i]-mediaAlum), 2);
			
		}
		
		desviacionTipica = Math.sqrt(desviacionTipica/alumnos.length);
		
		System.out.println("La desviacion tipica de los alumnos = " + desviacionTipica);
		
		// Desviacion tipica Prof
		
		desviacionTipica = 0;
		
		for (int i = 0; i < profesores.length; i++) {
			
			desviacionTipica += Math.pow((profesores[i]-mediaProf), 2);
			
		}
		
		desviacionTipica = Math.sqrt(desviacionTipica/profesores.length);
		
		System.out.println("La desviacion tipica de los profesores = " + desviacionTipica);
		
		
		
	}

}
