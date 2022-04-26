package david.elias;
import java.util.Scanner;

/* El funcionamento de cada metodo esta comentado en el propio metodo */ 

public class Tienda {
	
	float dinero;
	Producto[] productos;
	
	Tienda () {
		this.dinero = 0;
		this.productos = new Producto[100];
	}
	
	Tienda (float dinero) {
		this.dinero = dinero;
		this.productos = new Producto[100];
	}
	
	Tienda (float dinero, int espacio) {
		this.dinero = dinero;
		this.productos = new Producto[espacio];
	}
	
	public void initTienda () {
		
		//Producto es un objeto que recibe un nombre, la cantidad, el precio mayorista y un int aleatorio que es el codigo de barra
			
		productos[0] = new Producto("Manzana", 10, 10, (int)(Math.random()*100000));
		productos[1] = new Producto("Pera", 10, 10, (int)(Math.random()*100000));
		productos[2] = new Producto("Salchica", 100, 5, (int)(Math.random()*100000));
		productos[3] = new Producto("Fresa", 5, 2, (int)(Math.random()*100000));
		
	}
	
	public float getDinero() {
		return dinero;
	}
	
	public int getProductosLenght() {
		return productos.length;
	}
	
	public boolean addProducto(Producto in, int pos) { // Recibe el tipo de producto que quiere añadir y la posicion
		
		if (checkExist(in.getNombre())[0] == 0) {
			
			productos[pos] = in;
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public boolean addProducto(Producto in) { //Comprueva que no exista el producto antes de añadir, si no existe lo añade y devuelve true si no false
		
		if (checkExist(in.getNombre())[0] == 0) {
			
			int pos = this.getFirstEmpty();
			productos[pos] = in;
			return true;
			
		} else {
			
			return false;
			
		}
		
		
	}
	
	public boolean addStock(String producto,int cantidad) {
		
		int [] exist = checkExist(producto); // Metodo para llamar al addStock del objeto producto, con la cantidad. Este comprueva que exista el producto antes
		
		if (exist[0] == 1 && cantidad > 0) {
			
			productos[exist[1]].addStock(cantidad);
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public int[] checkExist (String nombre) { 
		
		/* Este metodo devuelve una array de 2 posiciones, una dice si el producto existe y la otra dice en que posicion esta.
		 * Recorre la array de productos y busca la String que sea igual, coje la clave y devuelve la informacion. 
		 * Posicion 0: 0 si no existe, 1 si existe / Posicion 1: la posicion del producto.*/
		
		int [] result = new int[2];
		
		for (int i = 0; i < productos.length; i++) {
			
			if (productos[i] != null) {
			
				if (productos[i].getNombre().equals(nombre)) {
					
					result = new int[] {1,i};
					return result;
					
				}
			
			} else {
				
				result = new int[] {0,0};
				return result;
				
			}
			
		}
		
		result = new int[] {0,0};
		return result;
		
	}
	
	public void vender () {
		
		// Este metodo inciara un bucle infinito que pedira el nombre del objeto a vender, buscara si existe con checkExist y entonces
		// reducira el stock de ese producto y añadira su precio publico al precio total. El precio total se añade al total de la tienda.
		
		Scanner scan = new Scanner(System.in);
		int [] id = new int [2];
		float precio = 0;
		
		do {
			
			System.out.println("Introduce el material que quieres vender, introduce 0 para completar la venta");
			
			String nombre = scan.next();
			
			if (nombre.equals("0")) {
				break;
			}
			
			id = this.checkExist(nombre);
			
			if (id[0] == 1) { // en pos 0 true o false (0 or 1) || Pos 1 = posicion del producto
				
				if (productos[id[1]].getStock() > 0) {
					
					precio += productos[id[1]].getPrecioPublico();
					productos[id[1]].reduceStock(); // stock--
					System.out.println("Precio actual: " + precio + "€ , quedan " + this.productos[id[1]].getStock() + " en stock");
					
				} else {
					
					System.out.println("No hay stock de este producto");
					
				}			
				
			} else {
				
				System.out.println("Producto no existe");
				
			}
			
		} while (true);
		
		System.out.println("Precio total: " + precio + "€");
		this.dinero += precio;
		
	}
	
	public int getFirstEmpty () { // Devuelve una longitud mas grande que la array si ni se encuentra ninguna posicion null
		
		for (int i = 0; i < productos.length; i++) {
			
			if (productos[i] == null) {
				
				return i;
				
			}
			
		}
		
		return productos.length+1;
		
	}

	public Producto[] getProductos() {
		return productos;
	}

	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}

	public void setDinero(float dinero) {
		this.dinero = dinero;
	}

	public static void main(String[] args) {
		
		Tienda tienda = new Tienda();
		Scanner scan = new Scanner(System.in);
		tienda.initTienda();
		int pos = tienda.getFirstEmpty();  // Por si la tienda ya tiene productos registrados, recibe el primer espacio null de la array
		String nombre;
		int stock;
		float precio;
		boolean open = true; // open se inicializa a true, para que el bucle no pare, cuando se cierra tienda se establece false
		
		/* Tienda sera el objeto tienda 
		 * Pos se inicia a la posicion vacia mas cercana, se le sumara 1 cada producto que se añada, ya que no se pueden eliminar productos
		 *  */
		
		while (open) {
			
			System.out.println("1- Contar caja		2- Añadir producto \n3- Añadir stock		4- Venta\n5- Ver tienda		6- Cierre");
			
			switch (scan.nextInt()) {
			
			case 1:
				
				System.out.println("La caja tiene: " + tienda.getDinero() + "€");
				break;
			
			case 2:
				
				System.out.println("Introduce el nombre del producto:");
				nombre = scan.next();
				System.out.println("Introduce el stock del producto:");
				stock = scan.nextInt();
				System.out.println("Introduce el precio por el que se ha adquirido el producto");
				precio = scan.nextFloat();
				
				Producto productoTemp = new Producto(nombre,precio,stock,(int)(Math.random()*100000));
				
				/* Se crea un nuevo producto con todos sus requisitos y se envia al metodo addProducto, que tambien necesitara la posicion,
				 * cuando se añade el producto la posicion aumenta por 1 para el siguiente producto */
				
				if (tienda.addProducto(productoTemp, pos)) {
					
					System.out.println("Producto añadido con exito");
					pos++;
					
				} else {
					
					System.out.println("Ya existe ese producto");
					
				}
				
				break;
			
			case 3:
				
				System.out.println("Introduce el nombre del producto");
				nombre = scan.next();
				System.out.println("Introduce la cantidad que quieres añadir");
				stock = scan.nextInt();
				
				if (tienda.checkExist(nombre)[0] == 1) {
					
					tienda.addStock(nombre, stock);
					System.out.println("Se han añadido " + stock + " unidades");
					
				} else {
					
					System.out.println("No existe ese producto");
					
				}
				
				break;
				
			case 4:
				
				tienda.vender();
				break;
			
			case 5:
				
				for (int i = 0; i < tienda.getProductosLenght(); i++ ) {
					
					if (tienda.getProductos()[i] != null) {
					
						System.out.println(tienda.getProductos()[i].toString());
				
					} else {
						
						break;
						
					}
					
				}
				
				break;
				
			case 6:
				
				System.out.println("Cerrando tienda...");
				
				open = false;
				
				break;
				
			}
				
		} // fin bucle open
		

	}

}
