package davidelias;

public class Actividad04 {

	public static void main(String[] args) {
		
		int numero = 4;
		
		for (int i = 0; i <= numero; i++) {
			
			for (int k = 1; k <= i; k++ ) { 
				
				System.out.print(k);
				
				if (k == i) {
					
					System.out.println();
					
				}
				
			}
			
		}

	}

}
