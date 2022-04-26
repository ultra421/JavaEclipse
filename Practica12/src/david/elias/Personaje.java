package david.elias;
import java.util.ArrayList;

public class Personaje {
	
	String nombre;
	int salud;
	int hambre;
	int suenyo;
	String habilidad;
	ArrayList<Objeto> objetos = new ArrayList<Objeto>();
	
	Personaje (String nombre,String habilidad) {
		
		this.nombre = nombre;
		salud = 10;
		hambre = 1;
		suenyo = 1;
		this.habilidad = habilidad;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getHambre() {
		return hambre;
	}

	public void setHambre(int hambre) {
		this.hambre = hambre;
	}

	public int getSuenyo() {
		return suenyo;
	}

	public void setSuenyo(int suenyo) {
		this.suenyo = suenyo;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

	public ArrayList<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(ArrayList<Objeto> objetos) {
		this.objetos = objetos;
	}
	
	public void addHambre (int cantidad) {
		hambre += cantidad;
	}
	
	public void addSuenyo (int cantidad) {
		suenyo += cantidad;
	}
	
	public void addSalud (int cantidad) {
		salud += cantidad;
	}
	
	

}
