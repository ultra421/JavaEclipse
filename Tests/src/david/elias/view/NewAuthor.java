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
import david.elias.exception.AuthorException;
import david.elias.model.Author;

public class NewAuthor extends Main implements ActionListener {
	
	JDialog newAuthor;
	JTextField nombreAutor, apellido1Autor, apellido2Autor, pais;
	JButton submit;
	JButton cancel;
	
	public NewAuthor () {
		
	}
	
	@Override
	public void buildWindow () {
		
		newAuthor = new JDialog(mainFrame, "Add author");
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
		
		newAuthor.add(new JLabel("Author name"));
		newAuthor.add(nombreAutor);
		newAuthor.add(new JLabel("1st Author surname"));
		newAuthor.add(apellido1Autor);
		newAuthor.add(new JLabel("2nd Author surname"));
		newAuthor.add(apellido2Autor);
		newAuthor.add(new JLabel("Country"));
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
				JOptionPane.showMessageDialog(newAuthor, "There can't be two authors with the same name and surnames");
				System.out.println("Author alredy exists");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(newAuthor, "Couldn't create, fields maybe invalid");
				System.out.println("Author alredy exists");
			}
			
		} else if (e.getSource() == cancel) {
			newAuthor.dispose();
		}
		
	}

}
