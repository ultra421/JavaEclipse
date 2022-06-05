package david.elias.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import david.elias.model.Genero;
import david.elias.model.Pelicula;

//TODO: Add movie list to easy add sequel

public class PeliculaController {
	
	Connection conn;
	
	public PeliculaController(Connection conn) {
		
		this.conn = conn;
		
	}
	
	public boolean addMovie(Pelicula movie) { // Add a movie, with or without a Sequel
		
		String title = movie.getTitulo();
		int genreID = movie.getCodigoGenero();
		
		try {
			
			if (movie.getSegundaParte() == null) {
				
				String query = "INSERT INTO pelicula VALUES (?,?,?,null)";
				
				PreparedStatement stmt = conn.prepareStatement(query);
				System.out.println(getLastID());
				stmt.setInt(1, getLastID()+1);
				stmt.setString(2,title);
				stmt.setInt(3, genreID);
				
				stmt.executeUpdate();
				return true;
				
			} else {
				
				String query = "INSERT INTO pelicula VALUES (?,?,?,?)";
				
				int sequelID = movie.getSegundaParte();
				PreparedStatement stmt = conn.prepareStatement(query);
				System.out.println(getLastID());
				stmt.setInt(1, getLastID()+1);
				stmt.setString(2,title);
				stmt.setInt(3, genreID);
				stmt.setInt(4,sequelID);
				
				stmt.executeUpdate();
				return true;
				
			}
			
		} catch(SQLException e) {
			System.out.println("error en addmovie");
			e.printStackTrace();
			return false;
			
		} 
		
		
	}
	
	public int getFirstID() throws SQLException { // for conditions
	
		try {
			String query = "SELECT codigo FROM pelicula ORDER BY codigo ASC LIMIT 1";
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
	
	public int getLastID() throws SQLException { // for conditions
		
		try {
			String query = "SELECT codigo FROM pelicula ORDER BY codigo DESC LIMIT 1";
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
	
	public ResultSet getInfo(int id) throws SQLException { //Get resultSet of matching ID
		
		String query = "SELECT * FROM pelicula WHERE codigo = " + id;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next() == false ) {
			throw new SQLException();
		} else {
			return rs;
		}
		
	}
	
	public boolean updateMovie (int id, String titulo, int idGenero, Integer sequel) throws SQLException { // update movie with values
		
		String query = "UPDATE pelicula SET titulo = ?, codigoGenero = ?, segundaParte = ? WHERE codigo = ?";
		
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1,titulo);
		stmt.setInt(2, idGenero);
		
		if (sequel == null) {
			stmt.setNull(3, Types.INTEGER);
		} else {
			stmt.setInt(3, sequel);
		}
		
		stmt.setInt(4, id);
		System.out.println(stmt.toString());
		stmt.executeUpdate();
		return true;
		
	}

	public Pelicula[] getAllMovies() throws SQLException { // Get all the movies (unused)
		
		String query = "SELECT * FROM pelicula";
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		ArrayList<Pelicula> resultList = new ArrayList<Pelicula>();
		
		int count = 0;
		
		while (rs.next()) {
			
			int id = rs.getInt("codigo");
			String title = rs.getString("titulo");
			int genre = rs.getInt("codigoGenero");
			int sequel = rs.getInt("segundaParte");
			
			resultList.add(new Pelicula(id,title,genre,sequel));
			count++;
			
		}
		
		Pelicula[] result = resultList.toArray(new Pelicula[resultList.size()]);
		return result;
		
	}
	
	public Pelicula[] getMoviesByTitle (String title) throws SQLException{ // Get movie by title
		
		String query = "SELECT * FROM pelicula WHERE titulo LIKE '%" + title + "%'" ;
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		ArrayList<Pelicula> resultList = new ArrayList<Pelicula>();
		
		while (rs.next()) {
			
			int id = rs.getInt("codigo");
			String tempTitle = rs.getString("titulo");
			int genre = rs.getInt("codigoGenero");
			int sequel = rs.getInt("segundaParte");
			
			resultList.add(new Pelicula(id,tempTitle,genre,sequel));
			
		}
		
		Pelicula[] result = resultList.toArray(new Pelicula[resultList.size()]);
		return result;
		
	}
	
	public void deleteMovie (int id) throws SQLException { // Delete a movie
		
		//Set all sequel fields to null that are related
		
		String query = "UPDATE pelicula SET segundaParte = ? WHERE segundaParte = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setNull(1, Types.INTEGER);
		pstmt.setInt(2,id);
		pstmt.executeUpdate();
		
		//Delete the movie
		
		query = "DELETE FROM pelicula WHERE codigo = " + id;
		
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(query);
		
	}

}
