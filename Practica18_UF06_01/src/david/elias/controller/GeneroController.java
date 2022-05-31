package david.elias.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import david.elias.model.Genero;

public class GeneroController {
	
	ArrayList<Genero> generos;
	Connection conn;

	public GeneroController (Connection conn,ArrayList<Genero> generos) {
		
		this.conn = conn;
		this.generos = generos;
		readAuthors();
		
	}
	
	private void readAuthors() {

		String query = "SELECT * FROM genero";
		
		
	}
	
}
