package david.elias;

public class Rectangulo extends Figura {
	
	Punto p1;
	Punto p2;
	
	public Rectangulo () {
		
		do {
		
			p1 = new Punto(rnd.nextInt(10),rnd.nextInt(10));
			p2 = new Punto(rnd.nextInt(10),rnd.nextInt(10));
		
		} while (p1.getX() == p2.getX() || p1.getY() == p2.getY()); // Asignar nuevos numeros hasta que no sean iguales ninguno
		
	}
	
	public float getArea() {
		
		// Los dos puntos seran cada uno un extremo
		
		float deltaX = Math.abs(p1.getX()-p2.getX()); // Abs siempre dara diferencia
		float deltaY = Math.abs(p1.getY()-p2.getY()); // Abs siempre dara diferencia
		
		return deltaX * deltaY; // Area (superficie)
	}

	public Punto getP1() {
		return p1;
	}

	public void setP1(Punto p1) {
		this.p1 = p1;
	}

	public Punto getP2() {
		return p2;
	}

	public void setP2(Punto p2) {
		this.p2 = p2;
	}
	
	public String toString() { // devovler string caracteristicas del objeto
		return " " + p1.toString() + " " + p2.toString();
	}

}
