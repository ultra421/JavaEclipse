package david.elias;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		ArrayList<SuperHeroe> heroes = new ArrayList<SuperHeroe>();
		
		heroes.add(new Hulk());
		heroes.add(new Spiderman());
		Scanner scan = new Scanner(System.in);
		boolean on = true;
		
		System.out.println(heroes.get(0).toString());
		
		while (on) {
			
			System.out.println("|| Bienvenido a la Liga de Superheroes ||");
			System.out.println(" -- Elige una opcion -- ");
			System.out.print(" 1- Consultar Heroe \n 2- Modificar datos personales \n 3- Salir \nOpcion:");
			
			int seleccion = scan.nextInt();
			
			switch (seleccion) {
			
			case 1:
				
				// He intentado hacer un sistema modular donde se pueden añadir mas heroes
				// pero como el ejercicio pide que las variablesde SuperHeroe sean privadas,
				// como por ejemplo, la del nombre, se hace dificil.
				
				System.out.println("Hay " + heroes.size() + " heroes en la liga, cual quieres consultar?");
				
				for (int i = 0; i < heroes.size(); i++) {
					System.out.println("Heroe " + (i+1));
				}
				
				int seleccionHeroe = scan.nextInt()-1;
				
				if (seleccionHeroe >= 0 && seleccionHeroe < heroes.size()) {
					
					System.out.println(heroes.get(seleccionHeroe).toString());
					System.out.println("Su potencial es de: " + heroes.get(seleccionHeroe).calcularPotencial());
					
				}
				
				break;
			
			case 2: 
				
				// Aqui ya he visto complicado seguir con el sistema modular, asi que lo he dejado atras
				// Nose si habra alguna manera de devovler los valores unicos de un hijo
				
				// He entendido que con canviar las caracteristicas personales deberiamos canviar sus caracteristicas unicas
				// ya que no podemos acceder al nombre o edad ya que son privadas
				
				System.out.println("Quieres modificar los datos de Hulk o Spiderman?");
				
				String selecHeroe = scan.next();
				
				if (selecHeroe.equalsIgnoreCase("hulk")) {
					
					System.out.println("El dato personal de Hulk es su peso");
					
					System.out.println("Quieres canviarlo (1 = si / 0 = no)");
					
					if (scan.nextInt() == 1) {
						
						Hulk tempHulk = (Hulk) heroes.get(0);
						
						System.out.println("Peso actual: " + tempHulk.getPeso());
						
						System.out.println("A cuanto quieres canviar el peso?");
						
						tempHulk.setPeso(scan.nextInt());
						
					}
					
				} else if (selecHeroe.equalsIgnoreCase("spiderman")) {
					
					System.out.println("El dato personal de Spiderman es su poder aracanido");
					
					System.out.println("Quieres canviarlo? (1 = si / 0 = no)");
					
					if (scan.nextInt() == 1) {
						Spiderman tempSpider = (Spiderman) heroes.get(1);
						
						if (tempSpider.isPoderAracnido()) {
							tempSpider.setPoderAracnido(false);
						} else {
							tempSpider.setPoderAracnido(true);
						}
						
					}
					
				} else {
					System.out.println("Heroe inexistente");
				}
				
				break;
			
			case 3:
				System.out.println("Cerrando programa...");
				on = false;
				break;
			
			default:
				continue;
			
			}
			
		}

	}

}
