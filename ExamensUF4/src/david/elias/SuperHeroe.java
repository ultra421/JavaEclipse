package david.elias;

public class SuperHeroe {
	
	private String nombre;
	private String apodo;
	private int edad;
	/* El ejercicio pide que no inicialicemos la variable poderes en esta clase, pero si no lo hacemos aqui
	 * deberiamos crear un metodo adicional para inicializar este atributo, lo cual veo inecesario, 
	 * si se inicialzia en esta clase dentro de los constructores, en ambos habria la misma linea de codigo, por esta razon
	 * lo inicializo en los atributos, ya que es una constante entre los dos constructores,
	 * tambien habia pensado en inicializarlo dentro de setPoder(), pero este recibe un solo poder y no multiples, se podria hacer
	 * que setPoder ampliase la array cada vez que se añade un nuevo poder, pero entonces no tiene sentido que sea una Array de 4 fija  */
	
	public String[] poderes = new String[4];
	// Si hacemos que poderes sea publico o default, se puede inicialziar desde fuera de la clase, pero no voy a hacerlo,
	// ya que recuerdo que en clase nos has dicho que deberiamos evitar estabelcer asi las variables
	
	SuperHeroe (String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	SuperHeroe (String nombre, String apodo, int edad) {
		this.nombre = nombre;
		this.apodo = apodo;
		this.edad = edad;
	}
	
	public int calcularPotencial() {
		return edad*10;
	}
	
	void setPoder(String poder, int posicion) {
		
		// Con este codigo tecnicamente tambien estariamos inicializando dentro de la clase
		// lo cual el ejercicio dice que evitemos, pero no veo otra manera de hacerlo, no es
		// el codigo que utilizare, por las razones que he escrito arriba.
		
//		if (poderes == null) {
//			poderes = new String[4];
//		}
		
		poderes[posicion] = poder;
	}
	
	void showPoderes() {
		
		String result = "";
		
		for (int i = 0; i < poderes.length; i++) {
			
			if (poderes[i] != null) {
				result += poderes[i] + " | ";
			}
			
		}
		
		System.out.println(result);
		
	}
	
	public String toString() {
		
		String result = "Nombre: " + nombre + " | Apodo: " + apodo + " | Edad: " + edad;
		
		result += " | Poderes: [";
		
		for (int i = 0; i < poderes.length; i++) {
			
			if (poderes[i] != null) {
				
				result += " " + poderes[i];
				
			}
			
		}
		
		result += "]";
		
		return result;
		
	}

	private String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String getApodo() {
		return apodo;
	}

	private void setApodo(String apodo) {
		this.apodo = apodo;
	}

	private int getEdad() {
		return edad;
	}

	private void setEdad(int edad) {
		this.edad = edad;
	}

	private String[] getPoderes() {
		return poderes;
	}

	private void setPoderes(String[] poderes) {
		this.poderes = poderes;
	}
	

}
