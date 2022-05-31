package david.elias.model;

public class Genero {
	
	int codigo;
	String descripcion;
	
	public Genero (int codigo, String descripcion) {
		
		this.codigo = codigo;
		this.descripcion = descripcion;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toStringFile() {
		
		return codigo + "$" + descripcion;
		
	}
	
	public String toString() {
		
		return descripcion;
		
	}
	
}
