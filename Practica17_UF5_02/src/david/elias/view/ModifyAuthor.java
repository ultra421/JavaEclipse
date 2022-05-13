package david.elias.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import david.elias.controller.AuthorController;
import david.elias.exception.AuthorException;

public class ModifyAuthor extends JDialog implements ActionListener {
	
	JComboBox authorList;
	AuthorController control;
	String[] authors;
	JButton submit;
	JPanel panelFields;
	JTextField nombreAutor;
	JTextField apellido1Autor;
	JTextField apellido2Autor;
	JTextField pais;
	
	public ModifyAuthor () {
		
		control = new AuthorController();
		setSize(400,400);
		
		try {
			authors = control.getAuthorList();
			authorList = new JComboBox(authors);
		} catch (AuthorException e) { // Exception si no hay ningun autor
			JOptionPane.showMessageDialog(this, "No hay ningun autor");
			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "ERROR");
			dispose();
		}
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		authorList.addActionListener(this);
		buildVentana();
		setVisible(true);
		
	}
	
	void buildVentana() {
		
		setLayout(new GridLayout(3,1,4,4));
		panelFields = new JPanel();
		panelFields.setLayout(new GridLayout (2,2,3,3));
		add(authorList);
		add(panelFields);
		
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
		
		add(submit);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == authorList.getSelectedItem()) {
			
			System.out.println(authorList.getSelectedItem());
			
		}
		
	}

}
