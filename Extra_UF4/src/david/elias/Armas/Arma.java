package david.elias.Armas;

public class Arma {
	
	String nombre;
	int damage;
	int alcance;
	int acierto;
	boolean canSpecial;
	String tipo;
	
	public Arma () { // Arma default 1/1/4 (daga)
		
		this.nombre = "Daga";
		this.damage = 1;
		this.alcance = 1;
		this.acierto = 4;
		this.tipo = "Daga";
		canSpecial = false;
	}
	
	public Arma(String tipo,String nombre, int damage, int alcance, int acierto) { // Para arma especial tipo dagas y armas normales
		
		this.nombre = nombre;
		this.damage = damage;
		this.alcance = alcance;
		this.acierto = acierto;
		canSpecial = true;
		this.tipo = tipo;
		
	}
	
	public Arma(Arma input) { // Duplicar
		
		this.nombre = input.nombre;
		this.damage = input.damage;
		this.alcance = input.alcance;
		this.acierto = input.acierto;
		this.canSpecial = input.canSpecial;
		this.tipo = input.tipo;
		
	}
	
	public String toString() {
		
		if (canSpecial && !tipo.equals("Daga")) {
		
			return "[ Nombre: " + nombre + " / Daño: " + damage + " / Alcance: " + alcance + " / Acierto: " + acierto + " / ¡Especial Listo!]";
		
		} else {
			
			return "[ Nombre: " + nombre + " / Daño: " + damage + " / Alcance: " + alcance + " / Acierto: " + acierto + " ]";
			
		}
		
	}

	public boolean toggleSpecial() {
		
		if (canSpecial) {
			canSpecial = false;
			return true;
		} else {
			return false;
		}
		
	}

	public void setCanSpecial(boolean canSpecial) {
		this.canSpecial = canSpecial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getAlcance() {
		return alcance;
	}

	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}

	public int getAcierto() {
		return acierto;
	}

	public void setAcierto(int acierto) {
		this.acierto = acierto;
	}
	
	public String getTipo() {
		return this.tipo;
	}

}
