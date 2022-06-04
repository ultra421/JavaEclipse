package david.elias.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import david.elias.controller.GeneroController;
import david.elias.controller.PeliculaController;
import david.elias.model.Genero;
import david.elias.model.Pelicula;

public class Main implements ActionListener, WindowListener {

	public PeliculaController peliControl;
	public GeneroController generoControl;
	public Connection conn;
	public ArrayList<Genero> generos;
	public ArrayList<Pelicula> peliculas;
	File file;
	Scanner scan;
	public JFrame main;
	JButton createGenre, searchGenre, updateGenre, deleteGenre;
	JButton createMovie, searchMovie, updateMovie, deleteMovie;

	public Main() {

		conectar(); // Establece conn
		scan = new Scanner(System.in);
		generos = new ArrayList<Genero>();
		peliculas = new ArrayList<Pelicula>();
		generoControl = new GeneroController(conn, generos);
		peliControl = new PeliculaController(conn, peliculas);
		buildWindow();

	}

	void buildWindow() {

		main = new JFrame("Peliculas");
		main.setSize(500, 500);
		main.setLayout(new FlowLayout());

		createGenre = new JButton("Create genre");
		searchGenre = new JButton("Search genre");
		updateGenre = new JButton("Update genre");
		deleteGenre = new JButton("Delete genre");

		createMovie = new JButton("Create movie");
		searchMovie = new JButton("Search movie");
		updateMovie = new JButton("Update movie");
		deleteMovie = new JButton("Delete movie");

		JButton[] buttons = new JButton[] { createGenre, searchGenre, updateGenre, deleteGenre, createMovie,
				searchMovie, updateMovie, deleteMovie };

		for (int i = 0; i < buttons.length; i++) {
			JButton tempButton = buttons[i];
			tempButton.addActionListener(this);
			tempButton.setSize(50, 100);
			// tempButton.setVisible(true);
			main.add(tempButton);
		}

		main.setVisible(true);

	}

	public void conectar() {

		final String url = "jdbc:mysql://localhost:3306/";
		final String nameDB = "filmout";
		final String driver = "com.mysql.cj.jdbc.Driver";
		final String userName = "root";
		final String pwd = "";
		try {
			conn = DriverManager.getConnection(url + nameDB, userName, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new Main();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == createGenre) {

			new CreateGenre();

		} else if (e.getSource() == searchGenre) {

			new SearchGenre();

		} else if (e.getSource() == updateGenre) {
			
			new UpdateGenre();
			
		} else if (e.getSource() == deleteGenre) {
			
			new DeleteGenre();
			
		} else if (e.getSource() == createMovie) {
			
			new CreateMovie();
			
		} else if (e.getSource() == searchMovie) {
			
			new SearchMovie();
			
		} else if (e.getSource() == updateMovie) {
			
			new UpdateMovie();
			
		} else if (e.getSource() == deleteMovie) {
			
			new DeleteMovie();
		}

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(1);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
