package david.elias;

public class Hulk extends SuperHeroe {

	private int peso;
	
	Hulk () {
		
		super("Hulk","Verdecito",25);
		this.peso = 450;
		this.setPoder("fuerte", 0);
		this.setPoder("alto", 1);
		this.setPoder("resistente", 2);
		this.setPoder("irascible", 3);
		
	}
	@Override
	public int calcularPotencial () {
		return super.calcularPotencial() * peso;
	}
	
	public String toString () {
		
		String result = super.toString();
		
		result += " | Peso: " + this.peso;
		
		return result;
		
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	
}
