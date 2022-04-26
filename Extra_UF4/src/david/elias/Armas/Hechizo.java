package david.elias.Armas;

public class Hechizo extends Arma{

	public Hechizo (String nombre,int damage,int alcance, int acierto) {
		
		super("Hechizo",nombre,damage,alcance,acierto);
		
	}

	public Hechizo (Arma input) {
		super(input);
	}
	
}
