package davidelias;

public class Actividad06 {

	public static void main(String[] args) {
		
		int numero = 4; int asteriscos = 1; int columnas = numero*2-1; /* A1 */ boolean bucle = false;
		
		for (int i = 0; i < numero; i++) {
			
			asteriscos = 1 + (i*2); /* A2 */
			
			for (int x = 0; x <= 1; x++) {
				
				for (int k = (columnas-asteriscos)/2; k > 0; k-- ) {  /* A3 */
					
					System.out.print(" ");
				
				}
				
				for (int k = asteriscos; k > 0 && bucle == false ; k-- ) { /* A4 */
					
					System.out.print("*");
					
				}
				
				bucle = true;
			
			
			}
			
			bucle = false;	
			
			System.out.print("\n");
			
		}
		

	}

} /* Las columnas de la piramide seran = al numero de (filas * 2)-1 (A1), ya que es la relacion que cumple
 * una piramde asi. El numero de asteriscos aumenta 2 veces cada bucle (A2). El for (A3) escribe los
 * espacios vacios, que sera igual a (columnas-asteriscos)/2 ya que hay que escribir la misma
 * cantidad de espacios en los dos lados. Cuando el bucle (A3) acaba el bucle (A4) empieza para empezar
 * se tiene que cumplir que bucle == false, este boolean se hace true cuando el bucle se ha cumplido,
 * para no repetirse cuando se haga el bucle (A3). Cuando se acaba de escribir la fila de la
 * piramide, el boolean bucle vuelve a false*/ 	
