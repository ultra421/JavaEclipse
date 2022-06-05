package david.elias.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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

public class UpdateMovie extends Main implements ActionListener {
	
	JDialog updateMovie;
	JTextField titleSearch, movieID, title, genre, sequelID;
	JComboBox<Pelicula> movieList;
	JComboBox<Genero> genreList;
	JButton submit, search, cancel, isSequel;
	Pelicula [] moviesArray;
	Genero [] genreArray;
	JPanel resultBox;
	boolean sequel;
	
	public UpdateMovie() {
		
		super();
		sequel = false;
	}
	
	void buildWindow() {
		
		updateMovie = new JDialog(main);
		updateMovie.setTitle("Update movie");
		updateMovie.setSize(800,450);
		updateMovie.setLayout(new GridLayout(4,1,10,10));
		
		///
		
		JPanel searchBox = new JPanel(new GridLayout(1,2));
		
		titleSearch = new JTextField();
		titleSearch.setSize(300, 50);
		
		searchBox.add(new JLabel("Movie title"));
		searchBox.add(titleSearch);
		updateMovie.add(searchBox);
		
		//
		
		resultBox = new JPanel(new GridLayout (1,2));
		
		moviesArray = new Pelicula[0];
		movieList = new JComboBox<Pelicula>(moviesArray);
		movieList.addActionListener(this);
		
		resultBox.add(new JLabel("Matching movies"));
		resultBox.add(movieList);
		
		updateMovie.add(resultBox);
		
		//
		
		JPanel infoBox = new JPanel(new GridLayout(1,9));
		
		movieID = new JTextField();
		movieID.setEditable(false);
		title = new JTextField();
		genre = new JTextField();
		
		try {
			genreArray = generoControl.getAllGenres();
			genreList = new JComboBox<Genero>(genreArray);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sequelID = new JTextField();
		
		isSequel = new JButton("Is sequel");
		isSequel.addActionListener(this);
		
		infoBox.add(new JLabel("ID"));
		infoBox.add(movieID);
		infoBox.add(new JLabel("Title"));
		infoBox.add(title);
		infoBox.add(new JLabel("Genre"));
		infoBox.add(genreList);
		infoBox.add(new JLabel("Sequel"));
		infoBox.add(sequelID);
		infoBox.add(isSequel);
		
		updateMovie.add(infoBox);
		
		//
		
		JPanel buttonBox = new JPanel(new GridLayout(1,3));
		
		search = new JButton("Search");
		search.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		submit = new JButton("Submit");
		submit.addActionListener(this);
		submit.setEnabled(false);
		
		buttonBox.add(submit);
		buttonBox.add(search);
		buttonBox.add(cancel);
		
		updateMovie.add(buttonBox);
		
		//
		
		updateMovie.setVisible(true);
		
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
					JOptionPane.showMessageDialog(updateMovie, "No movies that contain " + titleResult);
					submit.setEnabled(false);
					
				}	
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else if (e.getSource() == movieList) {
			
			updateFields();
			
		} else if (e.getSource() == submit) { 
			
			try {
				
				int idUpdate = Integer.parseInt(movieID.getText());
				String titleUpdate = title.getText();
				
				Genero tempGenre = (Genero)genreList.getSelectedItem();
				int genreUpdate = tempGenre.getCodigo();
				
				if (sequel) {
					
					Integer sequelUpdate = Integer.parseInt(sequelID.getText());
					peliControl.updateMovie(idUpdate, titleUpdate, genreUpdate, sequelUpdate);
					
				} else {
					
					peliControl.updateMovie(idUpdate, titleUpdate, genreUpdate, null);
					
				}
				
				//int id, String titulo, int idGenero, Integer sequel
				
			} catch (InputMismatchException e2) {
				e2.printStackTrace();
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
			
		} else if (e.getSource() == cancel) {
			
			updateMovie.dispose();
			
		} else if (e.getSource() == isSequel) {
			
			if (sequel) {
				sequel = false;
				isSequel.setText("Is not sequel");
				sequelID.setEnabled(sequel);
			} else {
				sequel = true;
				isSequel.setText("Is sequel");
				sequelID.setEnabled(sequel);
			}
			
		}
		
	}
	
	private void updateFields() {
		
		Pelicula tempMovie = (Pelicula)movieList.getSelectedItem();
		
		movieID.setText(String.valueOf(tempMovie.getCodigo()));
		title.setText(tempMovie.getTitulo());
		
		int genreID = tempMovie.getCodigoGenero();
		genreList.setSelectedItem(matchGenre(genreID));
		
		sequelID.setText(String.valueOf(tempMovie.getSegundaParte()));
		submit.setEnabled(true);
		
	}
	
	private Genero matchGenre(int input) {
		
		for (int i = 0; i < genreArray.length; i++) {
			
			Genero currentGen = genreArray[i];
			
			if (currentGen.getCodigo() == input) {
				
				return genreArray[i];
				
			}
			
		}
		
		return new Genero(input, null);
		
	}

}