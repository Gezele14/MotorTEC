package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class Main {
	
	

	private JFrame frame;
	private JTable table;
	private JPanel Inicio;
	private JPanel ventas;
	private JPanel reparaciones;
	private JTextField text_idcliente;
	private JTextField text_idAuto;
	private JTable tablereparaciones;
	private JTextField textKeyword;
	ArrayList<String> lista_modelo =  new ArrayList<String>();
	String Marca = "''";
	private JTable table_vendidos;
	private JTextField textTipfiltro;
	

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

	public Main(){
		initialize();
	}
	@SuppressWarnings("unchecked")
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 542);
		frame.setTitle("MotorTEC System");
		frame.setMinimumSize(frame.getSize());
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String[] cat = {"Todos","Mecanicos","Autos"};
		String[] estado_car = {"Nuevo","Usado"};
		String[] tipofiltro = {"Todos","Cliente","Concesionario"};
		
		JPanel vendido = new JPanel();
		vendido.setVisible(false);
		
		
		reparaciones = new JPanel();
		reparaciones.setBounds(0, 0, 795, 514);
		reparaciones.setVisible(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 136, 775, 333);
		reparaciones.add(scrollPane_1);
		
		tablereparaciones = new JTable();
		tablereparaciones.setModel(com.data.dataDB.Reparaciones("", ""));
		scrollPane_1.setViewportView(tablereparaciones);
		JButton btnInicio2 = new JButton("Inicio");
		btnInicio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reparaciones.setVisible(false);
				Inicio.setVisible(true);
			}
		});
		
		ventas = new JPanel();
		ventas.setBounds(0, 0, 795, 514);
		frame.getContentPane().add(ventas);
		ventas.setVisible(false); 
		ventas.setLayout(null);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_modelo = new JComboBox();
		comboBox_modelo.insertItemAt("Todos", 0);
		comboBox_modelo.setSelectedIndex(0);
		comboBox_modelo.setBounds(159, 109, 109, 20);
		ventas.add(comboBox_modelo);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 775, 316);
		ventas.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(com.data.dataDB.Autos());
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed (java.awt.event.MouseEvent Mouse_evt) {
				JTable table = (JTable) Mouse_evt.getSource();
				if (Mouse_evt.getClickCount() == 1) {
					text_idAuto.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				}
			}
		});
		scrollPane.setViewportView(table);
		
		@SuppressWarnings("rawtypes")
		JComboBox Box_cons = new JComboBox();
		Box_cons.setBounds(159, 36, 109, 20);
		ventas.add(Box_cons);
		
		@SuppressWarnings("rawtypes")
		JComboBox Box_estado = new JComboBox(estado_car);
		Box_estado.insertItemAt("Todos", 0);
		Box_estado.setSelectedIndex(0);
		Box_estado.setBounds(311, 109, 109, 20);
		ventas.add(Box_estado);
		
		@SuppressWarnings("rawtypes")
		JComboBox Box_marca = new JComboBox();
		Box_marca.insertItemAt("Todos", 0);
		Box_marca.setSelectedIndex(0);
		Box_marca.setBounds(10, 109, 109, 20);
		
		ventas.add(Box_marca);
		
		JLabel lblmarca = new JLabel("Marca:");
		lblmarca.setBounds(10, 84, 46, 14);
		ventas.add(lblmarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(159, 84, 46, 14);
		ventas.add(lblModelo);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(311, 84, 46, 14);
		ventas.add(lblEstado);
		
		JLabel lblCedCliente = new JLabel("Ced. Cliente");
		lblCedCliente.setBounds(10, 11, 68, 14);
		ventas.add(lblCedCliente);
		
		JLabel lblConcesionaria = new JLabel("Concesionaria");
		lblConcesionaria.setBounds(159, 11, 89, 14);
		ventas.add(lblConcesionaria);
		
		JLabel lblIdAuto = new JLabel("Id Auto");
		lblIdAuto.setBounds(311, 11, 46, 14);
		ventas.add(lblIdAuto);
		
		text_idcliente = new JTextField();
		text_idcliente.setBounds(10, 36, 109, 20);
		ventas.add(text_idcliente);
		text_idcliente.setColumns(10);
		
		text_idAuto = new JTextField();
		text_idAuto.setColumns(10);
		text_idAuto.setBounds(311, 36, 109, 20);
		ventas.add(text_idAuto);
		
		JButton btnGenerarVenta = new JButton("Generar Venta");
		btnGenerarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (text_idAuto.getText().equals("")) {
					JOptionPane.showMessageDialog(ventas, "Por favor seleccione un auto", "Sin Auto", JOptionPane.WARNING_MESSAGE);
				}
				else if(!text_idcliente.getText().equals("")) {
					try {
						//verifica si el id del cliente ya existe en la base de datos
						if (com.data.dataDB.ifExists("cliente", "idCliente", text_idcliente.getText())) {
							com.data.dataDB.insertarVenta(Box_cons.getSelectedItem().toString(), text_idcliente.getText(), text_idAuto.getText());
						}
						else {
							int seleccion = JOptionPane.showConfirmDialog(ventas, "El cliente no existe. ¿Desea agregar al cliente: "+text_idcliente.getText()+"?", "Cliente no existe",JOptionPane.YES_NO_OPTION);
							if(seleccion == 0) {
								addclient nCliente = new addclient(text_idcliente.getText());
								nCliente.setVisible(true);
								nCliente.setAlwaysOnTop(false);
							}
							else {
								text_idcliente.setText("");
							}
								
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnGenerarVenta.setBounds(460, 35, 116, 23);
		ventas.add(btnGenerarVenta);
		
		JButton btnregistro_Ventas= new JButton("Ventas");
		btnregistro_Ventas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnregistro_Ventas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vendido.setVisible(true);
				ventas.setVisible(false);
			}
		});
		btnregistro_Ventas.setBounds(633, 35, 109, 94);
		ventas.add(btnregistro_Ventas);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio.setVisible(true);
				ventas.setVisible(false);
			}
		});
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(460, 108, 116, 23);
		ventas.add(btnFiltrar);
		
		btnInicio.setBounds(696, 480, 89, 23);
		ventas.add(btnInicio);
		
		JButton btnMostrarClientes = new JButton("Clientes");
		btnMostrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(com.data.dataDB.clientes());
			}
		});
		btnMostrarClientes.setBounds(460, 69, 116, 29);
		ventas.add(btnMostrarClientes);
		
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Mostrar todos los autos en la tabla
				if (Box_marca.getSelectedItem().toString().equals("Todos") &&
						comboBox_modelo.getSelectedItem().toString().equals("Todos") &&
						Box_estado.getSelectedItem().toString().equals("Todos")) {
					table.setModel(com.data.dataDB.Autos());
				}
				//Mostrar datos de los autos usados
				else if (Box_marca.getSelectedItem().toString().equals("Todos") &&
						comboBox_modelo.getSelectedItem().toString().equals("Todos") &&
						Box_estado.getSelectedItem().toString().equals("Usado")) {
					table.setModel(com.data.dataDB.AutoUsado());
				}
				//Mostrar datos de los autos nuevos
				else if (Box_marca.getSelectedItem().toString().equals("Todos") &&
						comboBox_modelo.getSelectedItem().toString().equals("Todos") &&
						Box_estado.getSelectedItem().toString().equals("Nuevo")) {
					table.setModel(com.data.dataDB.AutoNuevo());
				}
				//Mostrar datos de los autos con filtro
				else {
					table.setModel(com.data.dataDB.AutosFiltro(Box_marca.getSelectedItem().toString(), 
																comboBox_modelo.getSelectedItem().toString(),
																Box_estado.getSelectedItem().toString()));
				}
				
			}
		});
		
		Box_marca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(e.getSource() == Box_marca) {
					 @SuppressWarnings("rawtypes")
					JComboBox box = (JComboBox)e.getSource();
					Marca = "'"+(String)box.getSelectedItem()+"'";
					lista_modelo = com.data.dataDB.llenar_modelo(Marca);
					comboBox_modelo.removeAllItems();
					comboBox_modelo.insertItemAt("Todos", 0);
					comboBox_modelo.setSelectedIndex(0);
					for (int i = 0; i < lista_modelo.size(); i++) {
						comboBox_modelo.addItem(lista_modelo.get(i));
					}
					
				 }
			}
		});
		btnInicio2.setBounds(696, 480, 89, 23);
		reparaciones.add(btnInicio2);
		
		JLabel lblPalabraClave = new JLabel("Palabra clave:");
		lblPalabraClave.setText("");
		lblPalabraClave.setBounds(187, 30, 141, 14);
		reparaciones.add(lblPalabraClave);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por: ");
		lblFiltrarPor.setBounds(27, 30, 71, 14);
		reparaciones.add(lblFiltrarPor);
		frame.getContentPane().add(reparaciones);
		reparaciones.setLayout(null);
		
		@SuppressWarnings({ "rawtypes" })
		JComboBox BoxTipofiltro = new JComboBox(cat);
		BoxTipofiltro.setSelectedIndex(0);
		BoxTipofiltro.setBounds(27, 55, 127, 23);
		reparaciones.add(BoxTipofiltro);
		
		textKeyword = new JTextField();
		textKeyword.setVisible(false);
		textKeyword.setBounds(187, 55, 127, 23);
		reparaciones.add(textKeyword);
		textKeyword.setColumns(10);
		
		JButton btnFiltro = new JButton("Filtrar");
		btnFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablereparaciones.setModel(com.data.dataDB.Reparaciones(BoxTipofiltro.getSelectedItem().toString(),textKeyword.getText()));
			}
		});
		btnFiltro.setBounds(351, 55, 71, 23);
		reparaciones.add(btnFiltro);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addrepar nRepar = new addrepar();
				nRepar.setVisible(true);
			}
		});
		btnAgregar.setBounds(644, 19, 107, 95);
		reparaciones.add(btnAgregar);
		
		BoxTipofiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(e.getSource() == BoxTipofiltro) {
					 @SuppressWarnings("rawtypes")
					JComboBox box = (JComboBox)e.getSource();
					 String msg = (String)box.getSelectedItem();
					 switch (msg) {
					case "Todos":
						lblPalabraClave.setText("");
						textKeyword.setVisible(false);
						break;
					case "Mecanicos":
						textKeyword.setVisible(true);
						lblPalabraClave.setText("Nombre del mecánico");
						break;
					case "Autos":
						textKeyword.setVisible(true);
						lblPalabraClave.setText("Matricula del auto");
						break;
					default:
						break;
					}
				 }
			}
		});
		vendido.setBounds(0, 0, 795, 514);
		frame.getContentPane().add(vendido);
		vendido.setLayout(null);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vendido.setVisible(false);
				ventas.setVisible(true);
			}
		});
		btnAtrs.setBounds(696, 481, 89, 23);
		vendido.add(btnAtrs);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 84, 775, 386);
		vendido.add(scrollPane_2);
	
		table_vendidos = new JTable();
		table_vendidos.setModel(com.data.dataDB.Ventas("Todos",""));
		scrollPane_2.setViewportView(table_vendidos);
		
		JLabel lblFiltrarPor_1 = new JLabel("Filtrar por:");
		lblFiltrarPor_1.setBounds(10, 11, 82, 14);
		vendido.add(lblFiltrarPor_1);
		
		@SuppressWarnings("rawtypes")
		JComboBox Box_selecfiltro = new JComboBox(tipofiltro);
		Box_selecfiltro.setBounds(34, 36, 136, 23);
		vendido.add(Box_selecfiltro);
		
		JLabel lblfiltro = new JLabel(" ");
		lblfiltro.setBounds(213, 11, 200, 14);
		vendido.add(lblfiltro);
		
		textTipfiltro = new JTextField();
		textTipfiltro.setEnabled(false);
		textTipfiltro.setBounds(213, 36, 136, 22);
		vendido.add(textTipfiltro);
		textTipfiltro.setColumns(10);
		
		JButton btnFltro = new JButton("Fltro");
		btnFltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_vendidos.setModel(com.data.dataDB.Ventas(Box_selecfiltro.getSelectedItem().toString(), textTipfiltro.getText()));
			}
		});
		btnFltro.setBounds(399, 36, 89, 23);
		vendido.add(btnFltro);
		
		JButton btnMayor = new JButton("Mayor");
		btnMayor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_vendidos.setModel(com.data.dataDB.MayorMenor("Mayor"));
			}
		});
		btnMayor.setBounds(555, 36, 89, 23);
		vendido.add(btnMayor);
		
		JButton btnMenor = new JButton("Menor");
		btnMenor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_vendidos.setModel(com.data.dataDB.MayorMenor("Menor"));
			}
		});
		btnMenor.setBounds(677, 36, 89, 23);
		vendido.add(btnMenor);
		
		Inicio = new JPanel();
		Inicio.setBackground(Color.WHITE);
		Inicio.setBounds(0, 0, 795, 514);
		frame.getContentPane().add(Inicio);
		Inicio.setLayout(null);
		
		
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
		logo.setIcon(new ImageIcon("img\\MotorTEC_Logo.PNG"));
		logo.setBounds(152, 73, 503, 219);
		Inicio.add(logo);
		
		JButton button = new JButton("Reparaciones");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inicio.setVisible(false);
				lblPalabraClave.setText("");
				textKeyword.setVisible(false);
				reparaciones.setVisible(true);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBackground(new Color(204, 153, 153));
		button.setBounds(447, 340, 164, 63);
		Inicio.add(button);
		
		JLabel fondo = new JLabel("MotorTec System");
		fondo.setIcon(new ImageIcon("img\\textura1.jpg"));
		fondo.setBounds(0, 0, 806, 514);
		Inicio.add(fondo);
		
		ArrayList<String> lista_marca =  new ArrayList<String>();
		lista_marca = com.data.dataDB.llenar_combo("marca", "Nombre");
		for (int i = 0; i < lista_marca.size(); i++) {
			Box_marca.addItem(lista_marca.get(i));
		}
		lista_modelo = com.data.dataDB.llenar_modelo(Marca);
		for (int i = 0; i < lista_modelo.size(); i++) {
			comboBox_modelo.addItem(lista_modelo.get(i));
		}
		ArrayList<String> conces = new ArrayList<String>();
		conces = com.data.dataDB.llenar_combo("concesionario", "NombreConcesionario");
		for (int i = 0; i < conces.size(); i++) {
			Box_cons.addItem(conces.get(i));
		}
		
		Box_selecfiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Box_selecfiltro) {
					@SuppressWarnings("rawtypes")
					JComboBox box = (JComboBox)e.getSource();
					String msg = (String)box.getSelectedItem();
					switch(msg) {
						case "Todos":
							textTipfiltro.setEnabled(true);
							lblfiltro.setText("");
							break;
						case "Cliente":
							textTipfiltro.setEnabled(true);
							lblfiltro.setText("Nombre de Cliente:");
							break;
						case "Concesionario":
							textTipfiltro.setEnabled(true);
							lblfiltro.setText("Nombre del Concesionario:");
							break;
						default:
							break;
					}
				}
			}
		});
	}
}
