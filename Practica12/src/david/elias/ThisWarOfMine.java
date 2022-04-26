package david.elias;

import java.util.ArrayList;

public class ThisWarOfMine {
	
	Casa casa = new Casa();
	ArrayList<Personaje> roles = new ArrayList<Personaje>();
	ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	
	public void generateCharacters() {
			
		personajes.add(new Personaje("Arica","Sigilo"));
		personajes.add(new Personaje("Bruno","Sigilo"));
		personajes.add(new Personaje("Katia","Sigilo"));
		personajes.add(new Personaje("Pavel","Sigilo"));
			
	}
	
	public String getCharacters() {
		
		String personajesString = "";
		
		for (int i = 0; i < personajes.size(); i++) {
			
			personajesString += "Personaje " + (i+1) + "  :" + personajes.get(i).getNombre() + " / Habilidad: " + personajes.get(i).getNombre() + "\n" ;
			
		}
		
	}
	
	public void turno () {
		
		System.out.println("Selecciona quien cumplira cada rol"); //Seleccion de roles
		
		
		
		
	}
	
	public String getRoles () {
		
		String rolesString = "";
		
		if (this.roles.get(0) == null) { // Durmiendo
			rolesString += "1) Rol jugador en casa durmiendo \n";
		} else {
			rolesString += "";
		}
		
		if (this.roles.get(1) == null) { // Durmiendo
			rolesString += "2) Rol jugador en casa vigilando \n";
		} else {
			rolesString += "";
		}
		
		if (this.roles.get(2) == null) { // Durmiendo
			rolesString += "3) Rol jugador en casa explorando \n";
		} else {
			rolesString += "";
		}
		
	}
	
	public static void main(String[] args) {
		
		ThisWarOfMine game = new ThisWarOfMine();
		
		
		//Turno de cada personaje y despues fin del dia?

	}

}
