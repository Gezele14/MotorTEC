package com.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.CompoundBorder;


import javax.swing.SwingConstants;

public class addclient extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField text_cedula;
	private JTextField textNombre;
	private JTextField textPrApellido;
	private JTextField textSegApellido;
	private JTextField textTelefono;
	private JTextField textdetalles;
	ArrayList<String> lista_pais =  new ArrayList<String>();
	ArrayList<String> lista_provincia =  new ArrayList<String>();
	ArrayList<String> lista_canton =  new ArrayList<String>();
	String pais,provincia;


	@SuppressWarnings("unchecked")
	public addclient(String idcliente) {
		setTitle("Nuevo Cliente");
		setBounds(100, 100, 312, 417);
		setModal(true);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new CompoundBorder());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCdulaCliente = new JLabel("C\u00E9dula Cliente:");
		lblCdulaCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdulaCliente.setBounds(22, 17, 126, 14);
		contentPanel.add(lblCdulaCliente);
		
		text_cedula = new JTextField();
		text_cedula.setText(idcliente);
		text_cedula.setBounds(158, 11, 107, 20);
		contentPanel.add(text_cedula);
		text_cedula.setColumns(10);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPais.setBounds(22, 187, 126, 14);
		contentPanel.add(lblPais);
		
		@SuppressWarnings("rawtypes")
		JComboBox BoxCanton = new JComboBox();
		BoxCanton.insertItemAt("Seleccione un cantón", 0);
		BoxCanton.setSelectedIndex(0);
		BoxCanton.setSelectedIndex(0);
		lista_provincia = com.data.dataDB.llenar_combo("canton", "Nombre");
		for (int i = 0; i < lista_provincia.size(); i++) {
			BoxCanton.addItem(lista_provincia.get(i));
		}
		BoxCanton.setBounds(158, 262, 107, 20);
		contentPanel.add(BoxCanton);
		
		@SuppressWarnings("rawtypes")
		JComboBox BoxProvincia = new JComboBox();
		BoxProvincia.insertItemAt("Seleccione una Provincia", 0);
		BoxProvincia.setSelectedIndex(0);
		lista_provincia = com.data.dataDB.llenar_combo("Provincia", "Nombre");
		for (int i = 0; i < lista_provincia.size(); i++) {
			BoxProvincia.addItem(lista_provincia.get(i));
		}
		BoxProvincia.setBounds(158, 220, 107, 20);
		contentPanel.add(BoxProvincia);
		
		@SuppressWarnings("rawtypes")
		JComboBox BoxPais = new JComboBox();
		BoxPais.insertItemAt("Seleccione un pais", 0);
		lista_pais = com.data.dataDB.llenar_combo("pais", "Nombre");
		for (int i = 0; i < lista_pais.size(); i++) {
			BoxPais.addItem(lista_pais.get(i));
		}
		BoxPais.setSelectedIndex(0);
		
		BoxPais.setBounds(158, 186, 107, 17);
		contentPanel.add(BoxPais);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProvincia.setBounds(22, 223, 126, 14);
		contentPanel.add(lblProvincia);
		
		JLabel lblCantn = new JLabel("Cant\u00F3n: ");
		lblCantn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantn.setBounds(22, 265, 126, 14);
		contentPanel.add(lblCantn);
				
		JLabel lblDetalles = new JLabel("Detalles:");
		lblDetalles.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDetalles.setBounds(22, 310, 57, 14);
		contentPanel.add(lblDetalles);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(22, 49, 126, 14);
		contentPanel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(158, 46, 107, 21);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido:");
		lblPrimerApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrimerApellido.setBounds(22, 85, 126, 14);
		contentPanel.add(lblPrimerApellido);
		
		textPrApellido = new JTextField();
		textPrApellido.setBounds(158, 82, 107, 20);
		contentPanel.add(textPrApellido);
		textPrApellido.setColumns(10);
		
		textSegApellido = new JTextField();
		textSegApellido.setBounds(158, 115, 107, 20);
		contentPanel.add(textSegApellido);
		textSegApellido.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido:");
		lblSegundoApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSegundoApellido.setBounds(22, 118, 126, 14);
		contentPanel.add(lblSegundoApellido);
		
		JLabel lblNmeroDeTel = new JLabel("N\u00FAmero de Tel\u00E9fono :");
		lblNmeroDeTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmeroDeTel.setBounds(22, 153, 126, 14);
		contentPanel.add(lblNmeroDeTel);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(158, 150, 107, 20);
		contentPanel.add(textTelefono);
		textTelefono.setColumns(10);
		
		textdetalles = new JTextField();
		textdetalles.setBounds(84, 307, 181, 21);
		contentPanel.add(textdetalles);
		textdetalles.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!textNombre.getText().equals("") &&
							!textPrApellido.getText().equals("") &&
							!textSegApellido.getText().equals("") &&
							!textTelefono.getText().equals("") &&
							!textdetalles.getText().equals("")) {
							int selec = JOptionPane.showConfirmDialog(getContentPane(),	"¿Agregar cliente?", "Agregar", JOptionPane.YES_NO_OPTION);
							if (selec == 0) {
								try {
									//Agrega la dirección a la base de datos
									com.data.dataDB.insertdireccion(BoxPais.getSelectedItem().toString(),
																	BoxProvincia.getSelectedItem().toString(),
																	BoxCanton.getSelectedItem().toString(), 
																	textdetalles.getText());
									//
									com.data.dataDB.insertCliente(text_cedula.getText(), 
																  textNombre.getText(), 
																  textPrApellido.getText(), 
																  textSegApellido.getText(), 
																  textTelefono.getText(),
																  BoxPais.getSelectedItem().toString(),
																  BoxProvincia.getSelectedItem().toString(),
																  BoxCanton.getSelectedItem().toString(), 
																  textdetalles.getText());
																  
									JOptionPane.showMessageDialog(getContentPane(), "Cliente agregado correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
									setVisible(false);
									dispose();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
						else {
							JOptionPane.showMessageDialog(getContentPane(), "Todos los campos deben estar llenos", "Campo vacío", JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
