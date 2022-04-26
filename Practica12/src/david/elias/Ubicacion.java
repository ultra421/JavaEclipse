package david.elias;

import java.util.ArrayList;
import java.util.Random;

public class Ubicacion {
	
	ArrayList<Objeto> objetos = new ArrayList<Objeto>();
	int peligrosidad;
	int nivel;
	
	Ubicacion () {
		
		Random random = new Random();
		nivel = 1;
		peligrosidad = random.nextInt(nivel)+1;
		objetos = generarObjetos();
		
	}
	
	public ArrayList<Objeto> generarObjetos () {
		
		ArrayList<Objeto> arrayObjetos = new ArrayList<Objeto>();
		Random random = new Random();
		
		int cantidadObjetos = random.nextInt()+1-nivel;
		
		for (int i = 0; i < cantidadObjetos; i++) {
			
			int numeroRandom = random.nextInt(101); // Genrar 0-100
			
			if (numeroRandom <= 10) { //Armas : 10%
				
				arrayObjetos.add(new Objeto("Armas",1));
				
			} else if (numeroRandom > 10 && numeroRandom <= 40) { //Comida : 30% rango de geeneracion 11-30
				
				arrayObjetos.add(new Objeto("Comida",1));
				
			} else if (numeroRandom > 40 && numeroRandom <= 55) { //Medicamentos: 15% rango de geeneracion 41-55
				
				arrayObjetos.add(new Objeto("Medicamentos",1));
				
			} else if (numeroRandom > 55 && numeroRandom <= 100 ){ //Componentes: 45% rango de generacion 56-100
			
				arrayObjetos.add(new Objeto("Componentes",1));
				
			}
			
		}
		
		return arrayObjetos;
		
	}
	
	public void incrementarNivel () {
		
		nivel++;
		
	}

}
