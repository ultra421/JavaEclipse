package davidEliasUF2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class WriteTest {

	public static void main(String[] args) {
		
		Alumno alumno = new Alumno("Juan","Pepe");
		
		File archivo = new File("src/txt/Testing");
		
		Properties props = new Properties();
		
		System.out.println(archivo.getAbsolutePath());
		System.out.println(archivo.isFile());
		System.out.println();

	}

}
