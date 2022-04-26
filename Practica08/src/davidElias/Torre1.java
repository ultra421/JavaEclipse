package davidElias;

public class Torre1 {

}

/*case 'T':
						
						if (coordenadaX == moverX) { // Vertical
							
							if (coordenadaY > moverY) { //Arriba
								
								for (int i = coordenadaY-1; i > moverY; i--) { // Comprovar que no haya ninguna en camino
									
									if ((ajedrez[i][coordenadaX].contains("[") || ajedrez[i][coordenadaX].contains("("))) {
										
										moveValido = false;
										System.out.println("Hay una pieza en medio!");
										veces++;
										break;
										
									} 
									
								}
								
								if (veces == 0 && ajedrez[moverY][moverX].contains("[") && jugador == 1) { //Eliminar P1 
									
									moveValido = true;
									eliminar = true;
									
								} else if ((veces == 0 && ajedrez[moverY][moverX].contains("(") && jugador == 2)) {
									
									moveValido = true;
									eliminar = true;
									
								} else if (veces == 0 && ajedrez[moverY][moverX].contains(".")) {
									
									moveValido = true;
									eliminar = false;
									break;
									
								}
								
							} else { //Abajo
								
								for (int i = coordenadaY+1; i < moverY; i++) { // Comprovar que no haya ninguna en camino
									
									if ((ajedrez[i][coordenadaX].contains("[") || ajedrez[i][coordenadaX].contains("("))) {
										
										moveValido = false;
										System.out.println("Hay una pieza en medio!");
										veces++;
										break;
										
									} 
									
								}
								
								if (veces == 0 && ajedrez[moverY][moverX].contains("[") && jugador == 1) { //Eliminar P1 
									
									moveValido = true;
									eliminar = true;
									
								} else if (veces == 0 && ajedrez[moverY][moverX].contains("(") && jugador == 2) {
									
									moveValido = true;
									eliminar = true;
									
								} else if (veces == 0 && ajedrez[moverY][moverX].contains(".")) {
									
									moveValido = true;
									eliminar = false;
									break;
									
								}
								
							}
							
						} else if (coordenadaY == moverY) { //Horizontal
							
							if (coordenadaX > moverX) { //Derecha
								
								for (int i = coordenadaX-1; i > moverX; i--) { // Comprovar que no haya ninguna en camino
									
									if ((ajedrez[coordenadaY][i].contains("[") || ajedrez[coordenadaY][i].contains("("))) {
										
										moveValido = false;
										System.out.println("Hay una pieza en medio!");
										veces++;
										break;
										
									} 
									
								}
								
								if (veces == 0 && ajedrez[moverY][moverX].contains("[") && jugador == 1) { //Eliminar P1 
									
									moveValido = true;
									eliminar = true;
									break;
									
								} else if ((veces == 0 && ajedrez[moverY][moverX].contains("(") && jugador == 2)) {
									
									moveValido = true;
									eliminar = true;
									break;
									
								} else if (veces == 0 && ajedrez[moverY][moverX].contains(".")) {
									
									moveValido = true;
									eliminar = false;
									break;
									
								}
								
							} else { //Izquierda
								
								for (int i = coordenadaX+1; i < moverX; i++) { // Comprovar que no haya ninguna en camino
									
									if ((ajedrez[coordenadaY][i].contains("[") || ajedrez[coordenadaY][i].contains("("))) {
										
										moveValido = false;
										System.out.println("Hay una pieza en medio!");
										veces++;
										
									} 
									
								}
								
								if (veces == 0 && ajedrez[moverY][moverX].contains("[") && jugador == 1) { //Eliminar P1 
									
									moveValido = true;
									eliminar = true;
									break;
									
								} else if (veces == 0 && ajedrez[moverY][moverX].contains("(") && jugador == 2) {
									
									moveValido = true;
									eliminar = true;
									break;
									
								} else if (veces == 0 && ajedrez[moverY][moverX].contains(".")) {
									
									moveValido = true;
									eliminar = false;
									break;
									
								}
								
							}
							
						}
						
						break; */


/*if (coordenadaY == moverY) { // Torre horizontal
	
	if (coordenadaX-moverX > 0) {
		
		for (int i = coordenadaX; i >= moverX; i--) {
			
			if (!(ajedrez[coordenadaY][i].contains("."))) {
				
				moverX = i;
				moveValido = true;
				eliminar = true;
				break;
					
			}
			
			
		} 
		
	} else {
		
		for (int i = coordenadaX; i <= moverX; i++) {
			
			if (!(ajedrez[coordenadaY][i].contains("."))) {
				
				moverX = i;
				moveValido = true;
				eliminar = true;
				break;
					
			}
			
			
		}
		
	}
	
	break;
	
} 

else if (coordenadaX == moverX) { //Torre vertical
	
	if (coordenadaY-moverY > 0) {
		
		for (int i = coordenadaY; i >= moverY; i--) {
			
			if (!(ajedrez[i][coordenadaX].contains(".")) && jugador == 1 && pieza.contains("(")) {
				
				moverY = i;
				moveValido = true;
				eliminar = true;
				break;
					
			} else if (jugador == 1) {
				
				moveValido = false;
				System.out.println("moveValido2 false");
				continue;
				
			}
			
			if (!(ajedrez[i][coordenadaX].contains(".")) && jugador == 2 && pieza.contains("[")) {
				
				moverY = i;
				moveValido = true;
				eliminar = true;
				break;
					
			} else if (jugador == 2) {
				
				moveValido = false;
				System.out.println("moveValido false");
				continue;
				
			}
			
			
		} 
		
	} else {
		
		for (int i = coordenadaY; i <= moverY; i++) {
			
			if (!(ajedrez[i][coordenadaX].contains(".") && jugador == 1 && pieza.contains("("))) {
				
				moverY = i;
				moveValido = true;
				eliminar = true;
				break;
					
			} else if (jugador == 1) {
				
				moveValido = false;
				System.out.println("moveValido2 false");
				break;
				
			}
			
			if (!(ajedrez[i][coordenadaX].contains(".") && jugador == 2 && pieza.contains("["))) {
				
				moverY = i;
				moveValido = true;
				eliminar = true;
				break;
					
			} else if (jugador == 2) {
				
				moveValido = false;
				System.out.println("moveValido2 false");
				break;
				
			}
			
			
			
			
		}
		
	}
	
	break;
	

	
} else {
	
	moveValido = false;
	break;
	
} */

