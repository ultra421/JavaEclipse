package david.elias;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	static Connection conn = null;

	public static void conectar() {

		final String url = "jdbc:mysql://localhost:3306/";
		final String nameDB = "biblioteca";
		final String driver = "com.mysql.cj.jdbc.Driver";
		final String userName = "root";
		final String pwd = "";
		try {
			conn = DriverManager.getConnection(url + nameDB, userName, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main (String [] args) {
		
		conectar();
		
		try {
			
			Statement st = conn.createStatement();
			String query = "SELECT * FROM libro";
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				
				int id = rs.getInt("codigo");
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");
				
				System.out.println(id + " " + titulo + " " + autor);
				
			}
			
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			
			
		}
		
	}

}
