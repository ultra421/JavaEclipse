package davidElias;

public class Fraccion {
	
	int num;
	int den;
	
	public Fraccion (int a, int b) {
		
		this.num = a;
		this.den = b;
		
	}
	
	public Fraccion () {
		
		this.num = 0;
		this.den = 1;
		
	}
	
	public int mcd (Fraccion in) {
		
		int mcd = 0;
		
		int a = this.den;
		int b = in.den;
		
		do {
			
			mcd = b;
			b = a%b;
			a = mcd;
			
		} while (b != 0);
		
		return mcd;
		
	}
	
	public int mcm (Fraccion in) {
		
		int mcm = (this.den*in.den)/(this.mcd(in));
		
		return mcm;
		
	}
	
	public Fraccion suma(Fraccion in) {
		
		Fraccion temp = new Fraccion();
		
		int mcm = this.mcm(in);
		
		temp.num = (this.num*(mcm/this.den)) + (in.num*(mcm/in.den));
		temp.den = mcm;
		
		return temp;
		
	}

	public Fraccion suma(int in) {
		
		Fraccion temp = new Fraccion();
		
		temp.num = this.num + in*this.den;
		temp.den = this.den;
		
		return temp;
		
	}
	
	public Fraccion resta (Fraccion in) {
		
		Fraccion temp = new Fraccion();
		
		int mcm = this.mcm(in);
		
		temp.num = (this.num*(mcm/this.den)) - (in.num*(mcm/in.den));
		temp.den = mcm;
		
		return temp;
		
	}
	
	public Fraccion resta(int in) {
		
		Fraccion temp = new Fraccion();
		
		temp.num = this.num - in*this.den;
		temp.den = this.den;
		
		return temp;
		
	}
	
	public Fraccion multiplicar (Fraccion in) {
		
		Fraccion temp = new Fraccion();
		
		temp.num = this.num*in.num;
		temp.den = this.den*in.den;
		
		return temp;
		
	}
	
	public Fraccion multiplicar (int in) {
		
		Fraccion temp = new Fraccion();
		
		temp.num = this.num*in;
		temp.den = this.den;
		
		return temp;
		
	}
	
	public Fraccion dividir (Fraccion in) {
		
		Fraccion temp = new Fraccion();
		
		temp.num = this.num * in.den;
		temp.den = this.den * in.num;
		
		return temp;
	}
	
	public Fraccion dividir (int in) {
		
		Fraccion temp = new Fraccion();
		
		temp.num = this.num / in;
		temp.den = this.den;
		
		return temp;
	}
	
	public String getPrint () {
		
		return this.num + "/" + this.den;
		
	}
	
	public void print() {
		
		System.out.println(this.num + "/" + this.den);
		
	}
	
	public static void main(String [] args) {
		
		Fraccion frac1 = new Fraccion(2,16);
		Fraccion frac2 = new Fraccion(8,32);
		
		System.out.println("mcd: " + frac1.mcd(frac2) + " mcm: " + frac1.mcm(frac2));
		Fraccion operacion = new Fraccion();
		
		operacion = frac1.suma(frac2); operacion.print();
		operacion = frac1.suma(2); operacion.print();
		operacion = frac1.resta(frac2); operacion.print();
		operacion = frac1.resta(2); operacion.print();
		operacion = frac1.multiplicar(frac2); operacion.print();
		operacion = frac1.multiplicar(2); operacion.print();
		operacion = frac1.dividir(frac2); operacion.print();
		operacion = frac1.dividir(2); operacion.print();
		
	}

}
