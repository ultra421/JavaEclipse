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

import david.elias.model.Pelicula;

public class DeleteMovie extends Main implements ActionListener {
	
	JDialog searchMovie;
	JTextField titleSearch, movieID, title, genre, sequelID;
	JComboBox<Pelicula> movieList; 
	JButton search, cancel, delete;
	Pelicula [] moviesArray;
	JPanel resultBox;
	
	public DeleteMovie() {
		
	}
	
	void buildWindow() {
		
		searchMovie = new JDialog(main);
		searchMovie.setTitle("Delete movie");
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
		genre = new JTextField();
		genre.setEditable(false);
		sequelID = new JTextField();
		sequelID.setEditable(false);
		
		infoBox.add(new JLabel("ID"));
		infoBox.add(movieID);
		infoBox.add(new JLabel("Title"));
		infoBox.add(title);
		infoBox.add(new JLabel("Genre"));
		infoBox.add(genre);
		infoBox.add(new JLabel("Sequel"));
		infoBox.add(sequelID);
		
		searchMovie.add(infoBox);
		
		//
		
		JPanel buttonBox = new JPanel(new GridLayout(1,3));
		
		search = new JButton("Search");
		search.addActionListener(this);
		delete = new JButton("Delete");
		delete.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		
		buttonBox.add(search);
		buttonBox.add(delete);
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
					JOptionPane.showMessageDialog(searchMovie, "No movies that contain " + titleResult);
					
				}	
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else if (e.getSource() == movieList) {
			
			updateFields();
			
		} else if (e.getSource() == delete) {
			
			try {
				peliControl.deleteMovie(Integer.parseInt(movieID.getText()));
				JOptionPane.showMessageDialog(deleteMovie, "Sucesfully deleted");
				searchMovie.dispose();
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
			
		} else if (e.getSource() == cancel) {
			searchMovie.dispose();
		} 
		
	}
	
	private void updateFields() {
		
		Pelicula tempMovie = (Pelicula)movieList.getSelectedItem();
		
		movieID.setText(String.valueOf(tempMovie.getCodigo()));
		title.setText(tempMovie.getTitulo());
		genre.setText(String.valueOf(tempMovie.getCodigoGenero()));
		sequelID.setText(String.valueOf(tempMovie.getSegundaParte()));
		
	}

}