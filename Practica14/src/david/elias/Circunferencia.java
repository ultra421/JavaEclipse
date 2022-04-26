package david.elias;

public class Circunferencia extends Figura {
	
	Punto p;
	int radio;
	
	public Circunferencia() { // rango radio 1-10
	
		p = new Punto(rnd.nextInt(10),rnd.nextInt(10));
		
		radio = rnd.nextInt(10)+1;
		
	}
	
	public float getArea() { 
		
		return (float)(Math.PI*Math.pow(radio, 2)); // Radio = pi * r^2
		
	}

	public Punto getP() {
		return p;
	}

	public void setP(Punto p) {
		this.p = p;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	public String toString() { // Devovler caracteristicas del objeto
		return " p = " + p.toString() + " radio = " + radio + " ";
	}
}
