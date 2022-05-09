package david.elias.model;

public class Book {
	
	int isbn;
	String titulo;
	int paginas;
	String genero;
	String autor;
	
	public Book(int isbn, String titulo, int paginas, String genero, String autor) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.paginas = paginas;
		this.genero = genero;
		this.autor = autor;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
