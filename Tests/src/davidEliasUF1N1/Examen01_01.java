package davidEliasUF1N1;
import java.util.Random;

public class Examen01_01 {

	public static void main(String[] args) {
		
		Random rng = new Random();
		int tiempo = rng.nextInt(2000001);
		
		System.out.println("Tiempo generado: " + tiempo);
		
		int hora = tiempo / 3600;
		int minutos = tiempo/60;
		int segundos = tiempo;
		
		while (minutos > 60) {
			
			minutos -= 60;
			
		}
		
		
		while (segundos > 60) {
			
			segundos -= 60;
			
		}
		
		
		System.out.println("La hora (H:M:S) equivalente es : " + hora + ":" + minutos + ":" + segundos  );

	}

}
