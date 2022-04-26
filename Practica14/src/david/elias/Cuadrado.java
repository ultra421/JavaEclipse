package david.elias;

public class Cuadrado extends Figura {

	Punto p1;
	Punto p2;

	public Cuadrado() {
		
		//Cada punto sera un extremo del cuadrado

		p1 = new Punto(rnd.nextInt(10), rnd.nextInt(10));
		int randomDelta = rnd.nextInt(10) + 1;
		// randomDelta = la distancia a la que estara el primer punto del segundo
		p2 = new Punto(p1.getX() + randomDelta, p1.getY() + randomDelta); // Obtener valores del primer punto y sumar delta

	}

	public float getArea() {

		float deltaX = Math.abs(p1.getX() - p2.getX()); // Abs siempre dara diferencia
		float deltaY = Math.abs(p1.getY() - p2.getY()); // Abs siempre dara diferencia

		// Rango Entre X * Rango entre Y = superficie

		return deltaX * deltaY; // Area (superficie)
	}
	
	public String toString() { // devovler string caracteristicas del objeto
		return " " + p1.toString() + " " + p2.toString();
	}

}
