package david.elias;

public class Producto {
	
	private String nombre;
	private float precioMayor;
	private float precioPublico;
	private int barras;
	private int stock;
	
	/** (String nombre, float precioMayor, int barras, int stock)
	 * @author David */
	public Producto (String nombre, float precioMayor, int stock, int barras) {
		
		this.nombre = nombre;
		this.precioMayor = precioMayor;
		this.precioPublico = precioMayor*2;
		this.barras = barras;
		this.stock = stock;
		
	}
	
	public String getNombre() {		
		return nombre;
	}
	
	public float getPrecioPublico() {
		return precioPublico;	
	}
	
	public float getPrecioMayor() {
		return precioMayor;
	}
	
	public int getStock () {
		return stock;
	}
	
	public int getBarras() {
		return barras;
	}
	
	public void reduceStock () {
		stock--; 
	}
	
	public void addStock(int stock) {
		this.stock += stock;
	}
	public String toString () { // Devuelve el objeto como una string
		
		return "Producto: " + this.nombre + " | stock: " + this.stock + " | coste: " + 
							this.precioPublico + "€ | Codigo: " + this.barras;

	}

}
