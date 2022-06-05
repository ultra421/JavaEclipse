package david.elias.model;

public class Pelicula {
	
	int codigo;
	String titulo;
	int codigoGenero;
	Integer segundaParte;
	
	public Pelicula(int codigo, String titulo, int codigoGenero, int segundaParte) {
		
		this.codigo = codigo;
		this.titulo = titulo;
		this.codigoGenero = codigoGenero;
		this.segundaParte = segundaParte;
		
	}
	
	public Pelicula(int codigo, String titulo, int codigoGenero) {
	
		this.codigo = codigo;
		this.titulo = titulo;
		this.codigoGenero = codigoGenero;
		this.segundaParte = null;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCodigoGenero() {
		return codigoGenero;
	}

	public void setCodigoGenero(int codigoGenero) {
		this.codigoGenero = codigoGenero;
	}

	public Integer getSegundaParte() {
		return segundaParte;
	}

	public void setSegundaParte(int segundaParte) {
		this.segundaParte = segundaParte;
	}
	
	public String toString () {
		return codigo + " - " + titulo;
	}

}
