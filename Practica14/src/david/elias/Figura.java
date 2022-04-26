package david.elias;
import java.util.Random;
import java.util.ArrayList;

public class Figura {
	
	Random rnd = new Random();
	
	public float getArea() { // Devuelve 0 porque es necesario que devuelva algo, se heredara a sus hijos y ahi sera sobreescrito
		return 0;
	}
	
	public String getTipoFigura() { // Devuelve el nombre de la clase
		return this.getClass().getSimpleName();
	}
	
	public static void main (String [] args) {
		
		Random rnd = new Random();
		
		ArrayList <Figura> list = new ArrayList <Figura>(); // Array de figuras
		
		for (int i = 0; i < 5; i++) {
			
			// rnd 33/33/33
			
			switch (rnd.nextInt(3)) {
			
			case 0:
				list.add(new Rectangulo());
				break;
			case 1:
				list.add(new Circunferencia());
				break;
			case 2:
				list.add(new Cuadrado());
				break;
			
			}
			
		}
		
		for (int i = 0; i < list.size(); i++) { // Recorrer array i imprimir la figura, su area, y sus caracteristicas
			
			System.out.println("Figura " + (i+1) + " = " + list.get(i).getTipoFigura() + " su area es = " + list.get(i).getArea() + "" + list.get(i).toString());
			 
			
		}
		
	}

}
