package david.elias.act1;

public class Cuenta {
	
	//Cuenta tendra un constructor donde recibira el nombre y establecera el saldo a 0
	
	String nombre;
	float saldo;
	
	Cuenta (String nombre) {
		this.nombre = nombre;
		saldo = 0;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	// Metodos de añadir/retirar dinero
	
	void addDinero (float saldo) {
		this.saldo += saldo;
	}
	
	void delDinero (float saldo) {
		this.saldo -= saldo;
	}
	
	//Metodo toString que devuelve el nombre y el saldo de la cuenta
	
	public String toString() {
		return "La cuenta " + nombre + " tiene " + saldo + " euros";
	}

}
