package davidElias;

public class Contador {
	
	int contador;
	
	Contador (int cantidad) {
		
		contador = cantidad;
		
	}
	
	Contador () {
		
		contador = 0;
		
	}
	
	Contador (Contador input) {
		
		contador = input.contador;
		
	}
	
	void aumentar() {
		
		contador++;
		
	}

	void aumentar(int in) {
		
		contador += in;
		
	}
	
	void reducir() {
		
		contador--;
		
	}
	
	void reducir(int in) {
		
		contador -= in;
		
	}
	
	int getContador () {
		
		return contador;
		
	}
	
	void setContador (int in) {
		
		contador = in;
		
	}
	
}
