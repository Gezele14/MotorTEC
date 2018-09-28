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

public class addrepar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField text_matricula;
	private JTextField text_cedula;
	private JTextField textField_5;
	private JTextField text_idMecanico;
	
	@SuppressWarnings("unchecked")
	public addrepar() {
		setTitle("Nueva Reparaci\u00F3n");
		setBounds(100, 100, 368, 220);
		setModal(true);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new CompoundBorder());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCdulaCliente = new JLabel("Matricula Auto:");
		lblCdulaCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdulaCliente.setBounds(22, 17, 126, 14);
		contentPanel.add(lblCdulaCliente);
		
		text_matricula = new JTextField();
		text_matricula.setBounds(158, 11, 157, 20);
		contentPanel.add(text_matricula);
		text_matricula.setColumns(10);
		
		JLabel lblDetalles = new JLabel("Detalles:");
		lblDetalles.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDetalles.setBounds(22, 310, 57, 14);
		contentPanel.add(lblDetalles);
		
		JLabel lblNombre = new JLabel("C\u00E9dula Cliente:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(22, 49, 126, 14);
		contentPanel.add(lblNombre);
		
		text_cedula = new JTextField();
		text_cedula.setBounds(158, 46, 157, 21);
		contentPanel.add(text_cedula);
		text_cedula.setColumns(10);
		
		JLabel lblPrimerApellido = new JLabel("Taller:");
		lblPrimerApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrimerApellido.setBounds(22, 85, 126, 14);
		contentPanel.add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Mec\u00E1nicos:");
		lblSegundoApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSegundoApellido.setBounds(22, 118, 126, 14);
		contentPanel.add(lblSegundoApellido);
		
		textField_5 = new JTextField();
		textField_5.setBounds(84, 307, 181, 21);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		
		@SuppressWarnings("rawtypes")
		JComboBox Box_Taller = new JComboBox();
		ArrayList<String> Lista_taller = new ArrayList<String>();
		Lista_taller = com.data.dataDB.llenar_combo("Taller", "Nombre");
		for (int i = 0; i < Lista_taller.size(); i++) {
			Box_Taller.addItem(Lista_taller.get(i));
		}
		Box_Taller.setBounds(158, 82, 157, 21);
		contentPanel.add(Box_Taller);
		
		text_idMecanico = new JTextField();
		text_idMecanico.setBounds(158, 118, 157, 20);
		contentPanel.add(text_idMecanico);
		text_idMecanico.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							
							if (!text_matricula.getText().equals("") && 
								!text_cedula.getText().equals("") &&
								!text_idMecanico.getText().equals("") &&
								!Box_Taller.getSelectedItem().toString().equals("")) {
								
								int select = JOptionPane.showConfirmDialog(getContentPane(), "¿Desea guardar esta reparacion?","Agregar reparacion", JOptionPane.YES_NO_OPTION);
								
								if (select == 0) {
									com.data.dataDB.insertarreparaciones(text_matricula.getText(),
											 text_cedula.getText(),
											 Box_Taller.getSelectedItem().toString(),
											 text_idMecanico.getText());
								}
									
								setVisible(false);
								dispose();
								
							}
							else {
								JOptionPane.showMessageDialog(getContentPane(), "Por favor llenar todos los campos", "Campo vacío", JOptionPane.WARNING_MESSAGE);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
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
