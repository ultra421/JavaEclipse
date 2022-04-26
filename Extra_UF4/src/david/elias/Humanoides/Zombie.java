package david.elias.Humanoides;

public class Zombie extends Humanoide {
	
	int movimiento;
	int damage;
	String tipo;
	
	Zombie (int damage, int movimiento, int salud, String tipo) {
		super("Zombie",salud);
		this.damage = damage;
		this.movimiento = movimiento;
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString () {
		return "Zombie tipo: " + tipo + " salud: " + salud + " daño: " + damage;
	}
	
	public int getDamage() {
		return this.damage;
	}

}
