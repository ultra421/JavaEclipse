package david.elias;

public class Spiderman extends SuperHeroe{
	
	private boolean poderAracnido;
	
	Spiderman () {
		
		super("Spiderman","Aracnido",25);
		poderAracnido = false;
		this.setPoder("agil", 0);
		this.setPoder("elastico", 1);
		this.setPoder("fuerte", 2);
		this.setPoder("inteligente", 3);
		
	}
	
	public int calcularPoderAracnido () {
		
		if (poderAracnido) {
			return 20;
		} else {
			return 2;
		}
	}
	
	@Override
	public int calcularPotencial () {
		return super.calcularPotencial() * calcularPoderAracnido();
	}
	
	public String toString () {
		
		String result = super.toString();
		
		result += " | Poder Aracnido: " + this.poderAracnido;
		
		return result;
		
	}

	public boolean isPoderAracnido() {
		return poderAracnido;
	}

	public void setPoderAracnido(boolean poderAracnido) {
		this.poderAracnido = poderAracnido;
	}

}
