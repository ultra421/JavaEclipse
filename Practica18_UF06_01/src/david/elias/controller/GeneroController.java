package david.elias.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import david.elias.model.Genero;

public class GeneroController {
	
	ArrayList<Genero> generos;
	Connection conn;

	public GeneroController (Connection conn,ArrayList<Genero> generos) {
		
		this.conn = conn;
		this.generos = generos;
		readGenero();
		
	}
	
	private void readGenero() {

		String query = "SELECT * FROM genero";
		
		
	}
	
	public boolean addGenero(String desc) {
		
		String query = "INSERT INTO genero VALUES (?,?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			System.out.println(getLastID());
			stmt.setInt(1, getLastID()+1);
			stmt.setString(2,desc);
			stmt.executeUpdate();
			return true;
			
		} catch(SQLException e) {
			System.out.println("error en addgenero");
			e.printStackTrace();
			return false;
			
		} 
		
		
	}
	
	public int getLastID() throws SQLException {
		
		try {
			String query = "SELECT codigo FROM genero ORDER BY codigo DESC LIMIT 1";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next() == false) { // Si no hay ninguno (la primera vez) devolver 0;
				return 0;
			} else {
				return rs.getInt("codigo");
			}
		} catch (SQLException e) {
			throw e;
		}
		
	}
	
}
