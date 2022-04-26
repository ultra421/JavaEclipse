package david.elias;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class EscribirPaciente {

	public static void main(String[] args) {
		
		File fichero = new File("src/david/elias/pacientes.txt");
		
		// El documento deberia crearse al lado de los .java
		
		System.out.println(fichero.getAbsolutePath());
		FileWriter ficheroWrite = null;
		PrintWriter ficheroWritePrint = null;
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

		// Codigo, Nombre, edad, enfermedad, gravedad, observacion
		
		// Es necesario rodear cualquier Objeto que sea de Input/Output con un try/catch, si no da error.

		if (!fichero.exists()) { // Si no existe el fichero crear uno, en ambos se inicializan los FileWriter PrintWriter

			System.out.println("Archivo no existe / Creando archivo...");
			
			try {
				fichero.createNewFile();
				ficheroWrite = new FileWriter(fichero, true);
				ficheroWritePrint = new PrintWriter(ficheroWrite);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			
			try {
				ficheroWrite = new FileWriter(fichero, true);
				ficheroWritePrint = new PrintWriter(ficheroWrite);
			} catch (IOException e) {
				e.printStackTrace();
			}		
			
		}
		
		// Añadir pacientes

		pacientes.add(new Paciente("Pac1", "Kaido", 59, "Depresion", "Media", "Necesita ayuda de un psicologo"));
		pacientes.add(new Paciente("Pac2", "Linlin", 68, "Covid", "Media", "Reposo y confinamiento"));
		pacientes.add(new Paciente("Torao", 28, "Envenenamiento", "Media", "Necesita ser drenado con suero"));
		pacientes.add(new Paciente("Hiruluk", 68, "Cirrosis", "Leve", "Debe de hidratarse con agua mineral"));
		
		// Buscar LinLin cambiar gravedad

		for (int i = 0; i < pacientes.size(); i++) {
			
			if (pacientes.get(i).getNombre().equals("Linlin")) {
				
				pacientes.get(i).setGravedad("Moderada");
				System.out.println("Gravedad canviada!");
				break;
				
			}

		}
		
		for (int i = 0; i < pacientes.size(); i++ ) { // Canviar Reposo por Descanso = Buscar "Reposo y confinamiento y reemplazar"
			
			String observacionPaciente = pacientes.get(i).getObservacion();
			
			if (observacionPaciente.contains("Reposo y confinamiento")) {
				
				pacientes.get(i).setObservacion(observacionPaciente.replace("Reposo","Descanso")); // Set observacion al resultado del replace
				System.out.println("Observacion canviada!");
				break;
				
			}
			
		}
		
		Object [] pacientesArray = pacientes.toArray(); // Hay que pasar la array a una array de objetos para que funcione el toString de Arrays
		
		System.out.println(Arrays.toString(pacientesArray)); //Imprmir el Arrays.toString
		
		String print = ""; // Variable donde se guardara todo el texto que se imprimira en el documento

		for (int i = 0; i < 4; i++) { 
			
			// Utilizar el metodo toString de paciente para tener una variable que contiene todo el texto para imprimir al documento
			
			// Mi idea original era imprimir en el documento el toString de cada paciente, pero habia veces que funcionava y veces que no
			// asi que decidi imprimirlo con una variable
			
			print += pacientes.get(i).toString();
			
		}
		
		//Exam
		
		FileReader fileReaderA;
		try {
			fileReaderA = new FileReader(fichero);
			BufferedReader reader = new BufferedReader(fileReaderA);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		ficheroWritePrint.write("AAAAAAC");
		ficheroWritePrint.println("AAAAAAAB");
		
		try {
			ficheroWrite.write("CCCCCCCC");
			ficheroWrite.append("37122");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Exam
		
		ficheroWritePrint.append(print); // Añadir contenido al archivo
		ficheroWritePrint.close(); // Cerrar el print
		
	}

}