package david.elias;

import java.util.ArrayList;
import java.util.Scanner;

public class TestAlumno {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList <Alumno> alumnos = new ArrayList <Alumno>();
		System.out.println("Bienvenido a la administracion de alumnos");
		String nombre;
		String apellido;
		boolean on = true;
	
		while (on) {
			
			
			System.out.print("Escoge una opcion: \n1-Crear Alumno		2-Mostrar Alumno\n3-Modificar Nota	4-Modificar datos personales\n5-Salir\n Opcion: ");
			
			int opcion = scan.nextInt();
			
			switch (opcion) {
			
			case 1:
				
				System.out.println("| Creacion de alumno |  \n¿Quieres crear un alumno con todos los datos o sin estos?"
									+ "\n1- Alumno con todos los datos	2- Alumno sin todos los datos");
				
				switch (scan.nextInt()) { // Guardar toda la informacio en variables y despues enviar al constructor al añadir en la array
				
				case 1:
					
					System.out.println("Introduce el nombre del alumno");
					nombre = scan.next();
					
					System.out.println("Introduce el apellido del alumno");
					apellido = scan.next();
					
					System.out.println("Introduce la edad del alumno");
					int edad = scan.nextInt();
					
					System.out.println("Introduce las notas solicitadas:"); // Buclels do while para comprovar que este dentro del rango 
						double [] notas = new double [4];
						
						do {
						System.out.println("La nota del modulo 1: Programacion");
						notas[0] = scan.nextDouble();
						} while (notas[0] < 0 && notas[0] > 10);
						
						do {
						System.out.println("La nota del modulo 2: Transversal");
						notas[1] = scan.nextDouble();
						} while (notas[1] < 0 && notas[1] > 10);
								
						do {
						System.out.println("La nota del modulo 3: BaseDatos");
						notas[2] = scan.nextDouble();
						} while (notas[2] < 0 && notas[2] > 10);
								
						do {
						System.out.println("La nota del modulo 4: Javascript");
						notas[3] = scan.nextDouble();
						} while (notas[3] < 0 && notas[3] > 10);
							
					
					System.out.println("Es alumno de ultimo curso? true/false");
					boolean ultimoCurso = scan.nextBoolean();
					
					if (alumnos.add(new Alumno(nombre,apellido,edad,notas,ultimoCurso))) {
						
						System.out.println("Alumno añadido con exito");
						
					}
					
					break;
				case 2:
					
					if (alumnos.add(new Alumno())) {
						
						System.out.println("Alumno añadido con exito");
						
					}
					
					break;
					
				default:
					System.out.println("Opcion no valida");
					continue;
				
				}
				
				break;
				
			case 2:
				
				System.out.println("Que alumno quieres mostrar? Introduce el nombre");
				nombre = scan.next();
				System.out.println("Y el apellido");
				apellido = scan.next();
				
				for (int i = 0; i < alumnos.size(); i++) { // Recorrer array de alumnos encontrar == nombre y apellido imprimir toString
					
					Alumno currentAlumno = alumnos.get(i);
					
					if (currentAlumno.getNombre().equalsIgnoreCase(nombre) && currentAlumno.getApellido().equalsIgnoreCase(apellido)) {
						
						System.out.println(alumnos.get(i).toString());
						break;
						
					} else if (i == alumnos.size()-1) {
						
						System.out.println("Alumno no existe");
						
					}
					
				}
				
				break;
				
			case 3:
				
				// Buscar alumno que editar, editar la nota, devovler la nota editada
				
				System.out.println("Que alumno quieres editar? Introduce el nombre");
				nombre = scan.next();
				System.out.println("Y el apellido");
				apellido = scan.next();
				
				Alumno currentAlumno = new Alumno();
				
				for (int i = 0; i < alumnos.size(); i++) { // Recorrer array de alumnos encontrar == nombre y apellido imprimir toString
					
					currentAlumno = alumnos.get(i);
					
					if (currentAlumno.getNombre().equalsIgnoreCase(nombre) && currentAlumno.getApellido().equalsIgnoreCase(apellido)) {
						
						System.out.println(currentAlumno.toString());
						
						System.out.println("Que nota quieres editar?");
						
						int notaEditar;
						
						do {
							notaEditar = scan.nextInt()-1; // Mantener dentro de rango de arrays
						} while (notaEditar < 0 && notaEditar > currentAlumno.notas.length); //Rango de array
						
						System.out.println("Cual sera la nueva nota?" );
						
						while (true) { // notaSet sera la nueva nota y notaEditar la clave
							
							double notaSet = scan.nextDouble();
							
							if (notaSet < 0 && notaSet > 10) {
								
								System.out.println("Introduce una nota valida");
								
							} else {
								
								currentAlumno.setNota(notaSet, notaEditar);
								break;
								
							}
							
						}
						
						alumnos.set(i, currentAlumno);
						
						System.out.println("Nota editada");
						
						break;
						
					} else if (i == alumnos.size()-1) {
						
						System.out.println("Alumno no existe");
						
					}
					
				}
				
				break;
				
			case 4:
				
				System.out.println("Que alumno quieres editar? Introduce el nombre");
				nombre = scan.next();
				System.out.println("Y el apellido");
				apellido = scan.next();
				
				for (int i = 0; i < alumnos.size(); i++) { // Recorrer array de alumnos encontrar == nombre y apellido imprimir menu opciones
					
					Alumno currentAlumnoEditar = alumnos.get(i);
					
					if (currentAlumnoEditar.getNombre().equalsIgnoreCase(nombre) && currentAlumnoEditar.getApellido().equalsIgnoreCase(apellido)) {
						
						System.out.println(alumnos.get(i).toString());
						
						System.out.println("Que datos quieres modificar? apellido o edad?"); 
						
						switch (scan.next().toLowerCase()) {
							
							case "apellido":
								System.out.println("Que apellido quieres que tenga?");
								currentAlumnoEditar.setApellido(scan.next());
								System.out.println("Apellido editado");
								break;
							case "edad":
								System.out.println("Que edad quieres que tenga?");
								currentAlumnoEditar.setEdad(scan.nextInt());
								System.out.println("Edad editada");
								break;
								
						}
						
						alumnos.set(i, currentAlumnoEditar);
						
						break;
						
					} else if (i == alumnos.size()-1) {
						
						System.out.println("Alumno no existe");
						
					}
					
				}
				
				break;
				
			case 5:
				
				System.out.println("Cerrando sistema...");
				on = false;
				break;
				
			default:
				System.out.println("Opcion no valida");
				continue;
			
			
			}
			
		}

	}

}
