package davidElias;
import java.util.Scanner;

public class Cuenta {
	
	Scanner scan = new Scanner(System.in);
	float dinero;
	String nombre;
	
	public Cuenta(String nombre, float dinero) {
		
		this.dinero = dinero;
		this.nombre = nombre;
		
	}
	
	public Cuenta(Cuenta input) {
		
		nombre = input.nombre;
		dinero = input.dinero;
		
	}
	
	boolean ingreso (float ingreso) {
		
		if (ingreso > 0) {
			
			this.dinero += dinero;
			return true;
			
		} else {
			
			System.out.println("Ingreso es menor que 0");
			return false;
			
		}
		
	}
	
	boolean reintegro (float reintegro) {
		
		if (dinero-reintegro > 0 && reintegro > 0) {
			
			dinero = dinero-reintegro;
			return true;
			
		} else {
			
			System.out.println("No hay suficiente saldo:");
			return false;
			
		}
		
	}
	
	void transferencia (Cuenta destino, float cantidad) {
		
		if (dinero-cantidad > 0 && cantidad > 0) {
			
			dinero = dinero-cantidad;
			destino.setDinero(destino.getDinero()+cantidad);
			
		} else {
			
			System.out.println("No hay dinero suficiente en la cuenta de origen");
			
		}
		
	}
	
	void setDinero (float dinero) {
		
		this.dinero = dinero;
		
	}
	
	void setNombre (String nombre) {
		
		this.nombre = nombre;
		
	}
	
	float getDinero () {
		
		return dinero;
		
	}
	
	String getNombre () {
		
		return nombre;
		
	}

}
