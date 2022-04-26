package davidelias;

public class Actividad05 {

	public static void main(String[] args) {
		
		int numero = 4;
		
		for (int i = 1; i <= 4; i++) {
			
			for (int k = numero-i ; k > 0; k-- ) {
				
			System.out.print(" ");	
			
			}
			
			for (int k = i; k > 0; k-- ) {
				
				System.out.print("*");
				
			}
			
			System.out.println();
			
		}
		

	}

}
