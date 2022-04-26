package david.elias.Armas;

public class Arco extends Arma{
	
	public Arco (String nombre,int damage,int alcance, int acierto) {
		
		super("Arco",nombre,damage,alcance,acierto);
		
	}
	
	public Arco (Arma input) {
		super(input);
	}

}
