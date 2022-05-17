package david.elias.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import david.elias.controller.AuthorController;
import david.elias.exception.AuthorException;
import david.elias.model.Author;

public class ModifyAuthor extends Principal implements ActionListener {
	
	JDialog modifyAuthor;
	JComboBox authorList;
	JButton submit;
	JPanel panelFields;
	JTextField nombreAutor,apellido1Autor,apellido2Autor,pais;
	
	public ModifyAuthor () {
		
		super(); // Lama a buildVentana
		
	}
	
	@Override
	void buildVentana() {
		
		modifyAuthor = new JDialog(super.mainFrame,"Modify author");
		modifyAuthor.setSize(400,400);
		modifyAuthor.setLayout(new GridLayout(3,1,4,4));
		
		try {
		
			Author tempAuthors [] = authors.toArray(new Author [authors.size()]);
			authorList = new JComboBox(tempAuthors);
			
			if (tempAuthors.length == 0) {
				throw new AuthorException();
			}
			
			panelFields = new JPanel();
			panelFields.setLayout(new GridLayout (2,2,3,3));
			modifyAuthor.add(authorList);
			modifyAuthor.add(panelFields);
			
			nombreAutor = new JTextField();
			apellido1Autor = new JTextField();
			apellido2Autor = new JTextField();
			pais = new JTextField();
			submit = new JButton("Submit");
			submit.setPreferredSize(new Dimension(75,40));
			submit.addActionListener(this);
			
			panelFields.add(new JLabel("Nombre Autor"));
			panelFields.add(nombreAutor);
			panelFields.add(new JLabel("Apellido autor"));
			panelFields.add(apellido1Autor);
			panelFields.add(new JLabel("2ndo apellido autor"));
			panelFields.add(apellido2Autor);
			panelFields.add(new JLabel("Pais"));
			panelFields.add(pais);
			
			submit = new JButton("Submit");
			submit.addActionListener(this);
			authorList.addActionListener(this);
			modifyAuthor.setVisible(true);
			
			modifyAuthor.add(submit);
			
		} catch (AuthorException e) { // Exception si no hay ningun autor
			JOptionPane.showMessageDialog(modifyAuthor, "No hay ningun autor");
			modifyAuthor.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(modifyAuthor, "Unknown Error");
			modifyAuthor.dispose();
		}
		
	}
	
	private void updateFields(Author input) {
		
		nombreAutor.setText(input.getName());
		apellido1Autor.setText(input.getSurname());
		apellido2Autor.setText(input.getSurname2());
		pais.setText(input.getCountry());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == authorList) {
			
			updateFields((Author)authorList.getSelectedItem());
			
		} else if (e.getSource() == submit) {
			
			//TODO: wtf es esto, haber usado .set y ya
			
			Author clickedAuthor = (Author)authorList.getSelectedItem();
			String nombre = nombreAutor.getText();
			String apellido = apellido1Autor.getText();
			String apellido2 = apellido2Autor.getText();
			String pais = this.pais.getText();
			
			authorControl.updateAuthor(clickedAuthor, nombre, apellido, apellido2, pais);
			
		}
		
	}

}
