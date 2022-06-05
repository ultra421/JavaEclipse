package david.elias.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import david.elias.model.Genero;
import david.elias.model.Pelicula;

public class CreateMovie extends Main implements ActionListener {
	
	JDialog createMovie;
	JTextField title;
	JComboBox <Genero> genres; 
	JComboBox <Pelicula> movies;
	JButton submit, cancel, sequelToggle;
	
	public CreateMovie() {
		super();
	}
	
	void buildWindow() {
		
		createMovie = new JDialog(main,"Create movie");
		createMovie.setSize(700,200);
		createMovie.setLayout(new GridLayout (2,1));
		
		JPanel movieInfo = new JPanel(new GridLayout(1,7));
		
		try {
			
			title = new JTextField();
			genres = new JComboBox<Genero>(generoControl.getAllGenres());
			movies = new JComboBox<Pelicula>(peliControl.getAllMovies());
			sequelToggle = new JButton("Is a sequel");
			sequelToggle.addActionListener(this);
			
			movieInfo.add(new JLabel("Title"));
			movieInfo.add(title);
			movieInfo.add(new JLabel("Genre"));
			movieInfo.add(genres);
			movieInfo.add(new JLabel("Sequel to"));
			movieInfo.add(movies);
			movies.setEnabled(false);
			movieInfo.add(sequelToggle);
			
			createMovie.add(movieInfo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/////
		
		JPanel buttons = new JPanel();
		
		submit = new JButton("Submit");
		submit.setSize(100,60);
		submit.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.setSize(100,60);
		cancel.addActionListener(this);
		
		buttons.setLayout(new FlowLayout());
		buttons.add(submit);
		buttons.add(cancel);
		
		createMovie.add(buttons);
		
		createMovie.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == submit) {
			
			try {
				
				int movieID;
				movieID = peliControl.getLastID() + 1;
				String movieTitle = title.getText();
				Genero tempGenre = (Genero) genres.getSelectedItem();
				int genreID = tempGenre.getCodigo();
				
				if (movies.isEnabled()) {
					
					Pelicula tempMovie = (Pelicula) movies.getSelectedItem();
					int sequelID = tempMovie.getCodigo();
					peliControl.addMovie(new Pelicula(movieID,movieTitle,genreID,sequelID));
					
				} else {
					
					peliControl.addMovie(new Pelicula(movieID,movieTitle,genreID));
					
				}
				
				JOptionPane.showMessageDialog(createMovie, "Created!");
				createMovie.dispose();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			
		} else if (e.getSource() == cancel) {
			createMovie.dispose();
		} else if (e.getSource() == sequelToggle) {
			
			if (movies.isEnabled()) {
				movies.setEnabled(false);
				sequelToggle.setText("Is a sequel");
			} else {
				movies.setEnabled(true);
				sequelToggle.setText("Is not a sequel");
			}
			
		}
		
	}

}