package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class Main {

	private JFrame frame;
	private JScrollBar scrollBar;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 811, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel Inicio = new JPanel();
		Inicio.setBackground(Color.WHITE);
		Inicio.setBounds(0, 0, 795, 514);
		frame.getContentPane().add(Inicio);
		Inicio.setLayout(null);
		
		JPanel ventas = new JPanel();
		ventas.setBounds(0, 0, 795, 514);
		ventas.setVisible(false);
		frame.getContentPane().add(ventas);
		ventas.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 775, 355);
		ventas.add(scrollPane);
		
		table = new JTable();
		table.setModel(com.data.dataDB.getEstudiantes());
		scrollPane.setViewportView(table);
		
		JLabel lblAuntosDisponibles = new JLabel("Auntos Disponibles:");
		lblAuntosDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAuntosDisponibles.setBounds(10, 11, 174, 14);
		ventas.add(lblAuntosDisponibles);
		
		JLabel lblmarca = new JLabel("Marca:");
		lblmarca.setBounds(10, 36, 46, 14);
		ventas.add(lblmarca);
		
		JComboBox comboBox_marca = new JComboBox();
		comboBox_marca.setBounds(10, 61, 109, 20);
		ventas.add(comboBox_marca);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio.setVisible(true);
				ventas.setVisible(false);
			}
		});
		btnInicio.setBounds(696, 480, 89, 23);
		ventas.add(btnInicio);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(140, 36, 46, 14);
		ventas.add(lblModelo);
		
		JComboBox comboBox_modelo = new JComboBox();
		comboBox_modelo.setBounds(140, 61, 109, 20);
		ventas.add(comboBox_modelo);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(278, 36, 46, 14);
		ventas.add(lblEstado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(278, 61, 109, 20);
		ventas.add(comboBox);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(423, 60, 89, 23);
		ventas.add(btnFiltrar);
		
		
		JButton Autos = new JButton("Ventas");
		Autos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Autos.setBackground(new Color(204, 153, 153));
		Autos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio.setVisible(false);
				ventas.setVisible(true);
			}
		});
		Autos.setBounds(183, 340, 164, 63);
		Inicio.add(Autos);
		
		JLabel logo = new JLabel("New label");
		logo.setBackground(new Color(255, 102, 102));
		logo.setForeground(new Color(255, 102, 102));
		logo.setIcon(new ImageIcon("C:\\Users\\gezel\\Documents\\GitHub\\MotorTEC\\img\\MotorTEC_Logo.PNG"));
		logo.setBounds(152, 73, 503, 219);
		Inicio.add(logo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 795, 21);
		Inicio.add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setHorizontalAlignment(SwingConstants.LEFT);
		mnArchivo.add(mntmSalir);
		
		JButton button = new JButton("Reparaciones");
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBackground(new Color(204, 153, 153));
		button.setBounds(447, 340, 164, 63);
		Inicio.add(button);
		
		JLabel fondo = new JLabel("New label");
		fondo.setIcon(new ImageIcon("C:\\Users\\gezel\\Documents\\GitHub\\MotorTEC\\img\\textura1.jpg"));
		fondo.setBounds(0, 23, 795, 491);
		Inicio.add(fondo);
		
		JPanel reparaciones = new JPanel();
		reparaciones.setBounds(0, 0, 795, 514);
		frame.getContentPane().add(reparaciones);
		
	}
}
