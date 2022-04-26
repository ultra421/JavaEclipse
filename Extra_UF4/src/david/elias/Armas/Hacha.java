package david.elias.Armas;

public class Hacha extends Arma {
	
	public Hacha (String nombre,int damage,int alcance, int acierto) {
		
		super("Hacha",nombre,damage,alcance,acierto);
		
	}
	
	public Hacha (Arma input) {
		super(input);
	}

}
