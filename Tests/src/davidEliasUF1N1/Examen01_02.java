package davidEliasUF1N1;

import java.util.Random;

public class Examen01_02 {

	public static void main(String[] args) {
		
		Random rng = new Random();
		float dinero = rng.nextInt((490)+10)*0.01f;
		int moneda2Euro = 0;
		int moneda1Euro = 0;
		int moneda50Cent = 0;
		int moneda20Cent = 0;
		int moneda10Cent = 0;
		int moneda5Cent = 0;
		int moneda2Cent = 0;
		int moneda1Cent = 0;
		
		System.out.println("Dinero: " + dinero);
		
		while (dinero >= 2) {
			
			dinero -= 2;
			moneda2Euro++;
			
		}
		
		while (dinero >= 1) {
			
			dinero -= 1;
			moneda1Euro++;
		}
		
		while (dinero >= 0.5) {
			
			dinero -= 0.5;
			moneda50Cent++;
			
		}
		
		while (dinero >= 0.2) {
			
			dinero -= 0.2;
			moneda20Cent++;
			
		}
		
		while (dinero >= 0.1) {
			
			dinero -= 0.1;
			moneda10Cent++;
			
		}
		
		while (dinero >= 0.048) { // No escribo el numero exacto ya que pierde decimales
			
			dinero -= 0.05;
			moneda5Cent++;
			
		}
		
		while (dinero >= 0.018) { // No escribo el numero exacto ya que pierde decimales
			
			dinero -= 0.02;
			moneda2Cent++;
			
		}
		
		while (dinero >= 0.009) { // No escribo el numero exacto ya que pierde decimales
			
			dinero -= 0.01;
			moneda1Cent++;
			
		}
		
		
		System.out.println("Monedas necesarias: " + moneda2Euro + " de 2€ - " + moneda1Euro + " de 1€ - \n "  
				+ moneda50Cent + " de 0.5€ - " + moneda20Cent + " de 0.2€ - " + moneda10Cent + " de 0.10 € - \n "
				+ moneda5Cent + " de 0.05€ - " + moneda2Cent + " de 0.02€ - " + moneda1Cent + " de 0.01€");
 		

	}

}
