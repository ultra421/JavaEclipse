package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WritingTest {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		File file = new File("Test.txt");
		System.out.println(file.getAbsolutePath());
		
		if (!file.exists()) {
			
			System.out.println("Crear archivo");
			
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Error con la creacion del archivo");
				e.printStackTrace();
			}
			
		} else {
			System.out.println("Archivo ya existe");
		}
		
		if (file.canWrite()) { // Escirbir en el archivo
			
			try {
				
				FileWriter fileWrite = new FileWriter(file,true);
				
				for (int i = 0; i < 5; i++) {
					
					System.out.println("Linea " + i);
				
					fileWrite.write(scan.nextLine() + "\n");
					
				}
				
				fileWrite.close();
				
			} catch (IOException e) {
				System.out.println("Error en creacion del filewriter");
				e.printStackTrace();
			}
			
		} else {
			
			System.out.println("File write:" + file.canWrite());
			
		}

	}

}
