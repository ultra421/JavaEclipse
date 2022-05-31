package david.elias.controller;

import java.sql.Connection;
import java.util.ArrayList;

import david.elias.model.Pelicula;

public class PeliculaController {
	
	ArrayList <Pelicula> peliculas;
	Connection conn;
	
	public PeliculaController(Connection conn,ArrayList<Pelicula> peliculas) {
		
		this.conn = conn;
		this.peliculas = peliculas;
		
	}

}
