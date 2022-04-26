package david.elias.Armas;

public class Espada extends Arma {
	
	public Espada (String nombre,int damage,int alcance, int acierto) {
		
		super("Espada",nombre,damage,alcance,acierto);
		
	}
	
	public Espada (Arma input) {
		super(input);
	}

}
