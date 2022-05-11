package david.elias.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import david.elias.controller.AuthorController;
import david.elias.exception.AuthorException;
import david.elias.model.Author;

public class NewAuthor extends Ventana implements ActionListener {
	
	JTextField nombreAutor;
	JTextField apellido1Autor;
	JTextField apellido2Autor;
	JTextField pais;
	JButton submit;
	JButton cancel;
	
	public NewAuthor () {
		
		super();
		setSize(400,150);
		
	}
	
	public void buildVentana () {
		
		this.setLayout(new GridLayout(5,2,4,4));
		nombreAutor = new JTextField();
		apellido1Autor = new JTextField();
		apellido2Autor = new JTextField();
		pais = new JTextField();
		submit = new JButton("Submit");
		cancel = new JButton("Cancel");
		submit.setPreferredSize(new Dimension(75,40));
		submit.addActionListener(this);
		cancel.setPreferredSize(new Dimension(75,40));
		cancel.addActionListener(this);
		
		add(new JLabel("Nombre Autor"));
		add(nombreAutor);
		add(new JLabel("Apellido autor"));
		add(apellido1Autor);
		add(new JLabel("2ndo apellido autor"));
		add(apellido2Autor);
		add(new JLabel("Pais"));
		add(pais);
		add(submit);
		add(cancel);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == submit) {
			System.out.print("Autor send:" + nombreAutor.getText() + apellido1Autor.getText() + apellido2Autor.getText() + pais.getText());
			AuthorController control = new AuthorController();
			try {
				control.addAuthor(new Author(nombreAutor.getText(),apellido1Autor.getText(),apellido2Autor.getText(),pais.getText()));
			} catch (AuthorException e1) {
				
				JOptionPane.showMessageDialog(this, "No pueden haber dos autores con el mismo nombre y apellidos");
				
			}
		} else if (e.getSource() == cancel) {
			dispose();
		}
		
	}

}
