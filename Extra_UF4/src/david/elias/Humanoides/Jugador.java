package david.elias.Humanoides;

import java.util.Random;

import david.elias.Armas.*;

public class Jugador extends Humanoide {
	
	Arma arma;
	
	public Jugador (String nombre) {
		super(nombre); // Super default -> 5 vida
		this.arma = new Arma(); // Arma default dagas 
	}
	
	public Jugador (String nombre, Arma armaEspecial, int vidaEspecial) { // Constructor para personajes especiales
		super(nombre,vidaEspecial);
		this.arma = armaEspecial;
	}
	
	public Jugador (Jugador jugador) {
		super(jugador.nombre);
		this.nombre = jugador.nombre;
		this.salud = jugador.salud;
		this.vivo = jugador.vivo;
		this.saludMaxima = jugador.saludMaxima;
		this.arma = jugador.arma;
	}
	
	public String toString() {
		return this.nombre + ": Salud: " + this.salud + " Arma equipada: " + arma.toString();
	}
	
	public boolean atacar (Zombie zombie) { // Devolver true si ataque es un exito, si no false
		
		Random rng = new Random();
		// Comprobacion de daño y acierto
		int attackNum = rng.nextInt(rng.nextInt(6)+1);
		if (zombie.getSalud() <= this.arma.getDamage() && this.arma.getAcierto() >= attackNum) {  // TODO: Añadir check movimientos (da palo)
			return true;
		} else {
			System.out.println("Has fallado con un " + attackNum);
			return false;
		}
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	
	/**
	 * @param damage
	 * @return true si muere false si no
	 */
	public boolean dealDamage (int damage) { 
		
		this.salud -= damage;
		if (salud < 1) {
			return true;
		} else {
			return false;
		}
		
	}

}
