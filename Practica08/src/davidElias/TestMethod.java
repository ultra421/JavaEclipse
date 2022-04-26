package davidElias;
import java.util.Scanner;

public class TestMethod {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String coords = traducirCoordenadas(input.next());
		
		System.out.println(coords);
		System.out.println(Character.getNumericValue(coords.charAt(0)));
		System.out.println(Character.getNumericValue(coords.charAt(1)));
		

	}
	
	public static String traducirCoordenadas (String input) { // Metodo que devuelve una String con los dos numeros de coordenadas equivalentes
		
		String result = "";
		
		result += (input.charAt(0)) + String.valueOf((int)(input.charAt(1))-64) ;
		
		return result;
		
	}

}
