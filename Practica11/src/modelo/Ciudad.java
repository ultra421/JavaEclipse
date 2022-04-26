package modelo;
import java.util.Scanner;

public class Ciudad {
	
	int numero;
	String recurso;
	Scanner scan = new Scanner(System.in);
	
	public Ciudad (int numero, String input) {
		
		this.numero = numero;
		recurso = input;
		
	}
	
	public Ciudad () { //Constructor predeterminado del objeto, pide si quiere que el material sea madera o piedra y el numero de la ciudad
		
		generarRecursos ();
		generarNumero ();
		
	}
	
	public void generarRecursos () {
		
		String recurso;
		
		while (true) {
			
			System.out.println("Que recurso quieres? Madera o piedra?");
			recurso = scan.next().toLowerCase();
			if (recurso.equals("madera") || recurso.equals("piedra")) {
				
				break;
				
			} else {
				
				System.out.println("Introduce un recurso valido");
				
			}
		}
		
		this.recurso = recurso;
		
	}
	
	public void generarNumero () {
		
		int numero;
		
		while (true) {
			
			System.out.println("Que numero quieres asignarle a la ciduad? Max: 2 min: 12");
			numero = scan.nextInt();
			if (numero >= 2 && numero <= 12) {
				this.numero = numero;
				break;
			} else {
				System.out.println("Introduce un numero que este entre los limites");
			}
			
		}
		
	}
	
	public String toString () { // Devuelve los valores del objeto en una string que se puede imprimir
		
		return "Recurso: " + recurso + " Numero: " + numero;
		
	}
	
	public int getNumero () {
		return this.numero;
	}
	
	public String getRecurso() {
		return this.recurso;
	}

}
