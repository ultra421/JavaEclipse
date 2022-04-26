package david.elias;

public class Paciente {
	
	String codigo;
	String nombre;
	int edad;
	String enfermedad;
	String gravedad;
	String observacion;
	
	// Dos constructores: En el documento hay pacientes los cuales no tienen un Codigo de paciente, yo entendi que eran casos especiales
	// asi que cree dos constructores para hacer posible la creacion de estos pacientes dentro del codigo, los dos constructores aceptan
	// los mismos parametros excepto el codigo, el cual existe en uno y en otro no
	
	Paciente (String codigo, String nombre, int edad, String enfermedad,String gravedad,String observacion) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.edad = edad;
		this.enfermedad = enfermedad;
		this.gravedad = gravedad;
		this.observacion = observacion;
		
	}
	
	Paciente (String nombre, int edad, String enfermedad, String gravedad, String observacion) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.enfermedad = enfermedad;
		this.gravedad = gravedad;
		this.observacion = observacion;
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public String getGravedad() {
		return gravedad;
	}

	public void setGravedad(String gravedad) {
		this.gravedad = gravedad;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public String toString () {
		
		// Por la razon de tener dos constructores necesito establecer aqui una condicion para comprovar si existe el codigo o no
		
		// toString que devuelve la informacion del objeto en formato igual que el documento de ejemplo
		
		String result = "";
		
		if (codigo != null) {
			result += "Codigo Paciente: " + codigo + "\n";
		}
		
		result += "Nombre: " + nombre + "\nEdad: " + edad + "\nEnfermedad:" + enfermedad + "\nGravedad:" + gravedad + "\nObservacion:" + observacion + "\n";
		
		return result;
		
	}

}
