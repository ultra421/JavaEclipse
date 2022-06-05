package david.elias.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import david.elias.model.Genero;
import david.elias.model.Pelicula;

public class SearchMovie extends Main implements ActionListener {
	
	JDialog searchMovie;
	JTextField titleSearch, movieID, title, genre, sequelID;
	JComboBox<Pelicula> movieList;
	JComboBox<Genero> genreList;
	JButton search, cancel;
	Genero [] genreArray;
	Pelicula [] moviesArray;
	JPanel resultBox;
	
	public SearchMovie() {
		
	}
	
	void buildWindow() {
		
		searchMovie = new JDialog(main);
		searchMovie.setTitle("Search movie");
		searchMovie.setSize(800,450);
		searchMovie.setLayout(new GridLayout(4,1,10,10));
		
		///
		
		JPanel searchBox = new JPanel(new GridLayout(1,2));
		
		titleSearch = new JTextField();
		titleSearch.setSize(300, 50);
		
		searchBox.add(new JLabel("Movie title"));
		searchBox.add(titleSearch);
		searchMovie.add(searchBox);
		
		//
		
		resultBox = new JPanel(new GridLayout (1,2));
		
		moviesArray = new Pelicula[0];
		movieList = new JComboBox<Pelicula>(moviesArray);
		movieList.addActionListener(this);
		
		resultBox.add(new JLabel("Matching movies"));
		resultBox.add(movieList);
		
		searchMovie.add(resultBox);
		
		//
		
		JPanel infoBox = new JPanel(new GridLayout(1,8));
		
		movieID = new JTextField();
		movieID.setEditable(false);
		title = new JTextField();
		title.setEditable(false);
		
		try {
			genreArray = generoControl.getAllGenres();
			genreList = new JComboBox<Genero>(genreArray);
			genreList.setEnabled(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sequelID = new JTextField();
		sequelID.setEditable(false);
		
		infoBox.add(new JLabel("ID"));
		infoBox.add(movieID);
		infoBox.add(new JLabel("Title"));
		infoBox.add(title);
		infoBox.add(new JLabel("Genre"));
		infoBox.add(genreList);
		infoBox.add(new JLabel("Sequel"));
		infoBox.add(sequelID);
		
		searchMovie.add(infoBox);
		
		//
		
		JPanel buttonBox = new JPanel(new GridLayout(1,2));
		
		search = new JButton("Search");
		search.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		
		buttonBox.add(search);
		buttonBox.add(cancel);
		
		searchMovie.add(buttonBox);
		
		//
		
		searchMovie.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == search) {
			
			try {
				
				String titleResult = titleSearch.getText();
				Pelicula[] matchingMovies = peliControl.getMoviesByTitle(titleResult);
				
				if (matchingMovies.length > 0) {
					
					resultBox.remove(movieList);
					moviesArray = matchingMovies;
					
					movieList = new JComboBox<Pelicula>(moviesArray);
					movieList.addActionListener(this);
					movieList.setEnabled(true);
					
					resultBox.add(movieList);
					//Refresh the component
					movieList.setVisible(false);
					movieList.setVisible(true);
					movieList.setSelectedIndex(0);
					updateFields();
					
				} else {
					
					movieList.setEnabled(false);
					JOptionPane.showMessageDialog(searchMovie, "No movies that contain '" + titleResult + "'");
					
				}	
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else if (e.getSource() == movieList) {
			
			updateFields();
			
		} else if (e.getSource() == cancel) {
			searchMovie.dispose();
		}
		
	}
	
	private void updateFields() {
		
		Pelicula tempMovie = (Pelicula)movieList.getSelectedItem();
		
		movieID.setText(String.valueOf(tempMovie.getCodigo()));
		title.setText(tempMovie.getTitulo());
		
		int genreID = tempMovie.getCodigoGenero();
		genreList.setSelectedItem(matchGenre(genreID));
		
		sequelID.setText(String.valueOf(tempMovie.getSegundaParte()));
		
	}
	
	private Genero matchGenre(int input) {
		
		for (int i = 0; i < genreArray.length; i++) {
			
			Genero currentGen = genreArray[i];
			
			if (currentGen.getCodigo() == input) {
				
				System.out.println("Matching" + currentGen.toString() + " input " + input);
				return currentGen;
				
			}
			
		}
		
		return new Genero(input, null);
		
	}

}