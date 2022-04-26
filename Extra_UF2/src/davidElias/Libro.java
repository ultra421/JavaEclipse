package davidElias;

public class Libro {
	
	String titulo;
	String autor;
	int ejemplares;
	int prestados;
	
	public Libro () {
		
		this.ejemplares = 0;
		this.prestados = 0;
			
	}
	
	public Libro (String titulo, String autor, int ejemplares, int prestados) {
		
		this.titulo = titulo;
		this.autor = autor;
		this.ejemplares = ejemplares;
		this.prestados = prestados;
		
	}
	
	public boolean prestamo () {
		
		if (prestados < ejemplares) {
			
			prestados++;
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public boolean devolucion () {
		
		if (prestados != 0) {
			
			prestados--;
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public void setAutor (String autor) {
		
		this.autor = autor;	
	}
	
	public void setTitulo (String titulo) {
		
		this.titulo = titulo;	
	}
	
	public void setEjemplares (int ejemplares) {
		
		this.ejemplares = ejemplares;	
	}
	
	public void setPrestados (int prestados) {
		
		this.prestados = prestados;	
	}
	
	public String getTitulo() {
		
		return this.titulo;
	}
	
	public String getAutor () {
		
		return this.autor;
	}
	
	public int getEjemplares() {
		
		return this.ejemplares;
	}
	
	public int getPrestados() {
		
		return this.prestados;
	}
	
	@Override
	public String toString () {
		
		return "Titulo: " + titulo + " | Autor: " + autor + " | Ejemplares: " + ejemplares + " | Prestados: " + prestados;
		
	}

}
