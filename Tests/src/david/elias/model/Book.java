package david.elias.model;

public class Book {
	
	int isbn;
	String title;
	int paginas;
	String genero;
	Author autor;
	
	public Book(int isbn, String titulo, int paginas, String genero, Author autor) {
		this.isbn = isbn;
		this.title = titulo;
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
		return title;
	}

	public void setTitulo(String titulo) {
		this.title = titulo;
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

	public Author getAutor() {
		return autor;
	}

	public void setAutor(Author autor) {
		this.autor = autor;
	}
	
	public String toString() {
		return isbn + " " + title;
	}
	
	public String toStringFile() {
		return isbn + "." + title + "." + paginas + "." + genero + "." + autor.toStringFile();
	}

}
