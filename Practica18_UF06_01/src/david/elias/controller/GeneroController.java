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
import java.sql.Types;
import java.util.ArrayList;
import java.util.Scanner;

import david.elias.model.Genero;

public class GeneroController {
	
	Connection conn;

	public GeneroController (Connection conn) {
		
		this.conn = conn;
		
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
	
	public int getFirstID() throws SQLException { //Get first ID in table for conditions
	
		try {
			String query = "SELECT codigo FROM genero ORDER BY codigo ASC LIMIT 1";
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
	
	public int getLastID() throws SQLException { //Get last ID in table for conditions
		
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
	
	public ResultSet getInfo(int id) throws SQLException { // get ResultSet of a genre
		
		String query = "SELECT * FROM genero WHERE codigo = " + id;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next() == false ) {
			throw new SQLException();
		} else {
			return rs;
		}
		
	}
	
	public boolean updateGenre (int id, String desc) throws SQLException { // Update with values
		
		String query = "UPDATE genero SET descripcion = ? WHERE codigo = ?";
		
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1,desc);
		stmt.setInt(2, id);
		System.out.println(stmt.toString());
		stmt.executeUpdate();
		return true;
		
	}
	
	public Genero[] getAllGenres() throws SQLException { // Get all Gengres in Array for JComboBox
		
		String query = "SELECT * FROM genero";
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		ArrayList<Genero> resultList = new ArrayList<Genero>();
		
		int count = 0;
		
		while (rs.next()) {
			
			int id = rs.getInt("codigo");
			String desc = rs.getString("descripcion");
			
			resultList.add(new Genero(id,desc));
			count++;
			
		}
		
		Genero[] result = resultList.toArray(new Genero[resultList.size()]);
		return result;
		
	}
	
	public void deleteGenre (int id) throws SQLException { // Delete a genrre
		
		//Set genero in movies to null when deleting
		
		String query = "UPDATE pelicula SET codigoGenero = ? WHERE codigoGenero = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setNull(1, Types.INTEGER);
		pstmt.setInt(2,id);
		pstmt.executeUpdate();
		
		query = "DELETE FROM genero WHERE codigo = " + id;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(query);
		
	}
	
}
