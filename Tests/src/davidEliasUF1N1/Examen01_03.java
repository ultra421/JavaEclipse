package davidEliasUF1N1;
import java.util.Random;

public class Examen01_03 {

	public static void main(String[] args) {
		
		Random rng = new Random();
		int numero = rng.nextInt(900)+100;
		String numeroString = Integer.toString(numero);
		
		System.out.println("Numero: " + numero);
		
		System.out.println("Primera cifra: " + numeroString.charAt(0));
		System.out.println("Segunda cifra: " + numeroString.charAt(1));
		System.out.println("Tercera cifra: " + numeroString.charAt(2));

	}

}
