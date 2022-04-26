package david.elias.program2;
import java.io.IOException;
import java.util.Scanner;

public class main {
	
	int pedirNumero() {
		
		System.out.println("Escribe un numero");
		
		while (true) {
			
			try {
				
				Scanner scan = new Scanner(System.in);
				return scan.nextInt();
				
			} catch (IOException e) {
				System.out.print("Escribe un numero correcto\nNumero:");
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		

	}

}
