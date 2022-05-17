package david.elias.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import david.elias.controller.AuthorController;
import david.elias.exception.AuthorException;
import david.elias.model.Author;

public class NewAuthor extends Principal implements ActionListener {
	
	JDialog newAuthor;
	JTextField nombreAutor, apellido1Autor, apellido2Autor, pais;
	JButton submit;
	JButton cancel;
	
	public NewAuthor () {
		
	}
	
	@Override
	public void buildVentana () {
		
		newAuthor = new JDialog(super.mainFrame, "Add author");
		newAuthor.setLayout(new GridLayout(5,2,4,4));
		newAuthor.setSize(400,400);
		
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
		
		newAuthor.add(new JLabel("Nombre Autor"));
		newAuthor.add(nombreAutor);
		newAuthor.add(new JLabel("Apellido autor"));
		newAuthor.add(apellido1Autor);
		newAuthor.add(new JLabel("2ndo apellido autor"));
		newAuthor.add(apellido2Autor);
		newAuthor.add(new JLabel("Pais"));
		newAuthor.add(pais);
		newAuthor.add(submit);
		newAuthor.add(cancel);
		
		newAuthor.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == submit) {
			System.out.println("Autor send:" + nombreAutor.getText() + apellido1Autor.getText() + apellido2Autor.getText() + pais.getText());
			try {
				authorControl.addAuthor(new Author(nombreAutor.getText(),apellido1Autor.getText(),apellido2Autor.getText(),pais.getText()));
			} catch (AuthorException e1) {
				JOptionPane.showMessageDialog(newAuthor, "No pueden haber dos autores con el mismo nombre y apellidos");
				System.out.println("Author alredy exist");
			}
			
		} else if (e.getSource() == cancel) {
			newAuthor.dispose();
		}
		
	}

}
