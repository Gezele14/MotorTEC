package com.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import com.connection.DataConnection;

public class dataDB {
	
	static DataConnection con = new DataConnection("MotorTEC", "root", "gera1234");
	
	
	public static DefaultTableModel Autos() {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs = DataConnection.getData("select idauto, Matricula, Marca.Nombre as Marca, modelo.Nombre as Modelo, Color\r\n" + 
											  "From Auto\r\n" + 
											  "inner join modelo on modelo.idModelo = auto.idModelo\r\n" + 
											  "inner join marca on marca.idMarca = modelo.idMarca ; ");
		
		model.setColumnIdentifiers(new Object[] {"ID","Matricula", "Marca","Modelo", "Color"});
		
		try {
			while(rs.next()) {
				model.addRow(new Object[] {rs.getString("idAuto"), 
											rs.getString("Matricula"), 
											rs.getString("Marca"), 
											rs.getString("Modelo"), 
											rs.getString("Color")});}} 
		
		catch (SQLException e) {System.out.print(e.toString());}
		return model;
		
	}

	public static DefaultTableModel AutoUsado() {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs = DataConnection.getData("select idauto, Matricula, Marca.Nombre as Marca, modelo.Nombre as Modelo, Color, Kilometraje\r\n" + 
				  "From Auto\r\n" + 
				  "inner join modelo on modelo.idModelo = auto.idModelo\r\n" + 
				  "inner join marca on marca.idMarca = modelo.idMarca  "+
				  "where Estado = 'Usado';");
		
		model.setColumnIdentifiers(new Object[] {"ID","Matricula", "Marca","Modelo", "Color", "Kilometraje"});
		
		try {
			while(rs.next()) {
				model.addRow(new Object[] {rs.getString("idAuto"), 
											rs.getString("Matricula"), 
											rs.getString("Marca"), 
											rs.getString("Modelo"), 
											rs.getString("Color"),
											rs.getString("Kilometraje")});}} 
		
		catch (SQLException e) {System.out.print(e.toString());}
		return model;
		
	}
	
	public static DefaultTableModel AutoNuevo() {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs = DataConnection.getData("select idauto, Matricula, Marca.Nombre as Marca, modelo.Nombre as Modelo, Color\r\n" + 
				  "From Auto\r\n" + 
				  "inner join modelo on modelo.idModelo = auto.idModelo\r\n" + 
				  "inner join marca on marca.idMarca = modelo.idMarca  "+
				  "where Estado = 'Nuevo';");
		
		model.setColumnIdentifiers(new Object[] {"ID","Matricula", "Marca","Modelo", "Color"});
		
		try {
			while(rs.next()) {
				model.addRow(new Object[] {rs.getString("idAuto"), 
											rs.getString("Matricula"), 
											rs.getString("Marca"), 
											rs.getString("Modelo"), 
											rs.getString("Color")});}} 
		
		catch (SQLException e) {System.out.print(e.toString());}
		return model;
		
	}
	
	public static DefaultTableModel Ventas(String tipo, String valor) {
		DefaultTableModel model =  new DefaultTableModel();
		ResultSet rs;
		
		if (tipo.equals("Cliente")) {
			rs = DataConnection.getData("SELECT idVenta, concesionario.NombreConcesionario as Concesionario, cliente.Nombre as Cliente, cliente.Primerapellido as Papellido, fechaventa, preciodeventa \r\n" + 
					  "FROM motortec.venta\r\n" + 
					  "INNER JOIN concesionario ON concesionario.idConcesionario = venta.idConcesionario\r\n"+
					  "INNER JOIN cliente ON cliente.idCliente = venta.idCliente "+
					  "WHERE cliente.Nombre = '"+valor+"';");
		}
		
		else if (tipo.equals("Concesionario")) {
			rs = DataConnection.getData("SELECT idVenta, concesionario.NombreConcesionario as Concesionario, cliente.Nombre as Cliente, cliente.Primerapellido as Papellido, fechaventa, preciodeventa \r\n" + 
					  "FROM motortec.venta\r\n" + 
					  "INNER JOIN concesionario ON concesionario.idConcesionario = venta.idConcesionario\r\n"+
					  "INNER JOIN cliente ON cliente.idCliente = venta.idCliente "+
					  "WHERE Concesionario.NombreConcesionario = '"+valor+"';");
		}
		else {
			rs = DataConnection.getData("SELECT idVenta, concesionario.NombreConcesionario as Concesionario, cliente.Nombre as Cliente, cliente.Primerapellido as Papellido, fechaventa, preciodeventa \r\n" + 
					  "FROM motortec.venta\r\n" + 
					  "INNER JOIN concesionario ON concesionario.idConcesionario = venta.idConcesionario\r\n"+
					  "INNER JOIN cliente ON cliente.idCliente = venta.idCliente;");
		}
		model.setColumnIdentifiers(new Object[] {"IDVenta", "Concesionario", "Cliente", "Apellido", "FechaCompra", "Precio"});
		
		try {
			while(rs.next()) {
				model.addRow(new Object[] {rs.getString("idVenta"),
										   rs.getString("Concesionario"),
										   rs.getString("Cliente"),
										   rs.getString("papellido"),
										   rs.getString("fechaventa"),
										   rs.getString("preciodeventa")});
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return model;
	}

	public static DefaultTableModel MayorMenor(String tipo) {
		DefaultTableModel model =  new DefaultTableModel();
		ResultSet rs;
		
		if (tipo.equals("Mayor")) {
			rs = DataConnection.getData("SELECT DISTINCT idVenta, Cliente.Nombre as Cliente, Cliente.PrimerApellido as Papellido, Cliente.SegundoApellido as Sapellido, PreciodeVenta, FechaVenta\r\n" + 
					"FROM Venta\r\n" + 
					"INNER JOIN Cliente ON Venta.idCliente = Cliente.idCliente\r\n" + 
					"WHERE PreciodeVenta LIKE (SELECT MAX(PreciodeVenta) FROM Venta);");
		}
		else {
			rs = DataConnection.getData("SELECT DISTINCT idVenta, Cliente.Nombre as Cliente, Cliente.PrimerApellido as Papellido, Cliente.SegundoApellido as Sapellido, PreciodeVenta, FechaVenta\r\n" + 
					"FROM Venta\r\n" + 
					"INNER JOIN Cliente ON Venta.idCliente = Cliente.idCliente\r\n" + 
					"WHERE PreciodeVenta IN (SELECT MIN(PreciodeVenta) FROM Venta);");
		}
		
		model.setColumnIdentifiers(new Object[] {"IDVenta", "Cliente", "Primer Apellido","Segundo Apellido", "Precio", "Fecha de Compra"});
		
		try {
			while(rs.next()) {
				model.addRow(new Object[] {rs.getString("idVenta"),
										   rs.getString("Cliente"),
										   rs.getString("Papellido"),
										   rs.getString("Sapellido"),
										   rs.getString("preciodeventa"),
										   rs.getString("fechaventa")});
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return model;
	}
	
	public static DefaultTableModel AutosFiltro(String marca, String modelo, String estado) {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs;
		
		if (modelo.equals("Todos") && estado.equals("Todos")) {
			rs = DataConnection.getData("select idAuto, Matricula, Marca.Nombre as Marca, modelo.Nombre as Modelo, Color\r\n" + 
					  					"From Auto\r\n" + 
										"inner join modelo on modelo.idModelo = auto.idModelo\r\n" +
					  					"inner join marca on marca.idMarca = modelo.idMarca \r\n" + 
										"where Marca.Nombre = '"+marca+"';");
			model.setColumnIdentifiers(new Object[] {"ID","Matricula", "Modelo","Marca", "Color"});
		}
		else if (modelo.equals("Todos") && estado.equals("Nuevo") ||
				modelo.equals("Todos") && estado.equals("Usado")) {
			rs = DataConnection.getData("select idAuto, Matricula, Marca.Nombre as Marca, modelo.Nombre as Modelo, Color\r\n" + 
  					"From Auto\r\n" + 
					"inner join modelo on modelo.idModelo = auto.idModelo\r\n" +
  					"inner join marca on marca.idMarca = modelo.idMarca \r\n" + 
					"where Marca.Nombre = '"+marca+"' and Estado = '"+estado+"';");
		model.setColumnIdentifiers(new Object[] {"ID","Matricula", "Modelo","Marca", "Color"});
		}
		else if (estado.equals("Todos")) {
			rs = DataConnection.getData("select idAuto, Matricula, modelo.Nombre as Modelo, Marca.Nombre as Marca, Color\r\n" + 
  					"From Auto\r\n" + 
					"inner join modelo on modelo.idModelo = auto.idModelo\r\n" +
  					"inner join marca on marca.idMarca = modelo.idMarca \r\n" + 
					"where Marca.Nombre = '"+marca+"' and Modelo.Nombre = '"+modelo+"';");
			model.setColumnIdentifiers(new Object[] {"ID","Matricula", "Modelo","Marca", "Color"});
		}
		else if (estado.equals("Usado")){
			rs = DataConnection.getData("select idAuto, Matricula, modelo.Nombre as Modelo, Marca.Nombre as Marca, Color, Kilometraje\r\n" + 
  					"From Auto\r\n" + 
					"inner join modelo on modelo.idModelo = auto.idModelo\r\n" +
  					"inner join marca on marca.idMarca = modelo.idMarca \r\n" + 
					"where Marca.Nombre = '"+marca+"' and Modelo.Nombre = '"+modelo+"' and Estado = '"+estado+"';");
			model.setColumnIdentifiers(new Object[] {"ID","Matricula", "Modelo","Marca", "Color", "Kilometraje"});
		}
		else {
			rs = DataConnection.getData("select idAuto, Matricula, modelo.Nombre as Modelo, Marca.Nombre as Marca, Color\r\n" + 
  					"From Auto\r\n" + 
					"inner join modelo on modelo.idModelo = auto.idModelo\r\n" +
  					"inner join marca on marca.idMarca = modelo.idMarca \r\n" + 
					"where Marca.Nombre = '"+marca+"' and Modelo.Nombre = '"+modelo+"' and Estado = '"+estado+"';");
			model.setColumnIdentifiers(new Object[] {"ID","Matricula", "Modelo","Marca", "Color"});
		}
		
		
		try {
			while(rs.next()) {
				model.addRow(new Object[] {rs.getString("idAuto"), 
											rs.getString("Matricula"), 
											rs.getString("Modelo"), 
											rs.getString("Marca"), 
											rs.getString("Color")});}} 
		
		catch (SQLException e) {System.out.print(e.toString());}
		return model;
		
	}
	
	public static DefaultTableModel Reparaciones(String tipo, String valor) {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs ;
		
		if (tipo.equals("Mecanicos")) {
			rs = DataConnection.getData("SELECT idReparacion, Matricula, Cliente.Nombre AS Cliente, Cliente.PrimerApellido as apellido, Mecanico.Nombre AS Mecanico, Mecanico.PrimerApellido as Mapellido, Taller.Nombre AS Taller, HorasReparando,FechaReparacion\r\n" + 
					"FROM Reparacion\r\n" + 
					"LEFT JOIN Auto ON Reparacion.idAuto = Auto.idAuto\r\n" + 
					"RIGHT JOIN Cliente ON Reparacion.idCliente = Cliente.idCliente\r\n" + 
					"INNER JOIN Mecanico ON Reparacion.idMecanico = Mecanico.idMecanico\r\n" + 
					"INNER JOIN Taller ON Reparacion.idTaller = Taller.idTaller\r\n" + 
					"WHERE Mecanico.Nombre = '"+valor+"' \r\n"+
					"ORDER BY Reparacion.idReparacion;");
		}
		else if (tipo.equals("Autos")) {
			rs = DataConnection.getData("SELECT idReparacion, Matricula, Cliente.Nombre AS Cliente, Cliente.PrimerApellido as apellido, Mecanico.Nombre AS Mecanico, Mecanico.PrimerApellido as Mapellido, Taller.Nombre AS Taller, HorasReparando,FechaReparacion\r\n" + 
					"FROM Reparacion\r\n" + 
					"LEFT JOIN Auto ON Reparacion.idAuto = Auto.idAuto\r\n" + 
					"RIGHT JOIN Cliente ON Reparacion.idCliente = Cliente.idCliente\r\n" + 
					"INNER JOIN Mecanico ON Reparacion.idMecanico = Mecanico.idMecanico\r\n" + 
					"INNER JOIN Taller ON Reparacion.idTaller = Taller.idTaller\r\n" + 
					"WHERE auto.matricula LIKE '%"+valor+"%' \r\n"+
					"ORDER BY Reparacion.idReparacion");
		}
		else {
			rs = DataConnection.getData("SELECT idReparacion, Matricula, Cliente.Nombre AS Cliente, Cliente.PrimerApellido as apellido, Mecanico.Nombre AS Mecanico, Mecanico.PrimerApellido as Mapellido, Taller.Nombre AS Taller, HorasReparando,FechaReparacion\r\n" + 
					"FROM Reparacion\r\n" + 
					"LEFT JOIN Auto ON Reparacion.idAuto = Auto.idAuto\r\n" + 
					"RIGHT JOIN Cliente ON Reparacion.idCliente = Cliente.idCliente\r\n" + 
					"INNER JOIN Mecanico ON Reparacion.idMecanico = Mecanico.idMecanico\r\n" + 
					"INNER JOIN Taller ON Reparacion.idTaller = Taller.idTaller\r\n" + 
					"ORDER BY Reparacion.idReparacion;");
		}
		
		model.setColumnIdentifiers(new Object[] {"ID","Matricula", "Cliente","Apellido Cliente","Mecanico","Apellido Mecánico","Taller", "Horas", "Fecha de ingreso"});
		
		try {
			while(rs.next()) {
				model.addRow(new Object[] {rs.getString("idreparacion"), 
											rs.getString("Matricula"), 
											rs.getString("cliente"), 
											rs.getString("apellido"), 
											rs.getString("Mecanico"),
											rs.getString("Mapellido"),
											rs.getString("Taller"),
											rs.getString("horasReparando"),
											rs.getString("FechaReparacion")});}} 
		
		catch (SQLException e) {System.out.print(e.toString());}
		return model;
	}
	
	public static boolean ifExists(String tabla, String columna, String dato) throws SQLException {
        ResultSet rs = DataConnection.getData("SELECT "+columna+" FROM "+tabla+" WHERE "+columna+" = "+dato);
        if(rs.last()){
        	return true;
        }
        else{
        	return false;
        }
		
	}
	
	public static ArrayList<String> llenar_combo(String tabla, String columna){
		ArrayList<String> lista = new ArrayList<String>();
		ResultSet rs = DataConnection.getData("Select "+columna+" from "+tabla+" order by "+columna);
		try {
			while(rs.next()) {
				lista.add(rs.getString(columna));
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return lista;
	}
	
	public static ArrayList<String> llenar_modelo(String marca){
		ArrayList<String> lista = new ArrayList<String>();
		ResultSet rs = DataConnection.getData("select modelo.Nombre from modelo inner join marca on marca.idMarca = modelo.idMarca where marca.nombre = "+marca);
		try {
			while(rs.next()) {
				lista.add(rs.getString("Nombre"));
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return lista;
	}
	
	public static ArrayList<String> llenar_provincia(String provincia){
		ArrayList<String> lista = new ArrayList<String>();
		ResultSet rs = DataConnection.getData("select provincia.Nombre from provincia inner join pais on pais.idPais = provincia.idPais where pais.Nombre = "+provincia+" order by Nombre");
		try {
			while(rs.next()) {
				lista.add(rs.getString("Nombre"));
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return lista;
	}
	
	public static String getidbyname(String table, String column, String name) throws SQLException {
		String result= "";
		ResultSet rs = DataConnection.getData("Select id"+table+" from "+table+" where "+column+" = '"+name+"';");
		while(rs.next()) {
			result = rs.getString("id"+table);
		}
		return result;
	}
	
	public static String getprecioAuto(String idAuto) throws SQLException {
		String result= "";
		ResultSet rs = DataConnection.getData("Select Precio from auto where idauto = "+idAuto+";");
		while(rs.next()) {
			result = rs.getString("Precio");
		}
		return result;
	}
	
	public static String getid1(String table, String column) throws SQLException{
		String result= "";
		ResultSet rs = DataConnection.getData("Select count("+column+")+1 as Nuevo from "+table+";");
		while(rs.next()) {
			result =  rs.getString("Nuevo");
		}
		return result;
	}

	public static void insertdireccion(String pais, String provincia, String canton, String detalles) throws SQLException {
		PreparedStatement ps = DataConnection.conexion().prepareStatement("insert into direccion values(?,?,?,?,?);");
		ps.setInt(1, Integer.parseInt(getid1("direccion", "idDireccion")));
		ps.setInt(2, Integer.parseInt(getidbyname("Pais", "Nombre", pais)));
		ps.setInt(3, Integer.parseInt(getidbyname("provincia", "Nombre", provincia)));
		ps.setInt(4, Integer.parseInt(getidbyname("canton", "Nombre", canton)));
		ps.setString(5, detalles);
		ps.executeUpdate();
		
		
	}
	
	public static String getidDireccion(String idPais, String  idprovincia, String idCanton, String detalles) throws SQLException {
		String result= "";
		ResultSet rs = DataConnection.getData("Select idDireccion from direccion where "+
											  "idpais = "+idPais+" and "+
											  "idprovincia = "+idprovincia+" and "+
											  "idCanton = "+idCanton+" and "+
											  "detalles = '"+detalles+"';");
		while(rs.next()) {
			result = rs.getString("idDireccion");
		}
		
		return result;
	}
	
	public static void insertCliente(String idcliente, String Nombre, String pApellido, String sApellido, String telefono, String pais, String provincia, String canton, String detalles) throws SQLException {
		PreparedStatement ps = DataConnection.conexion().prepareStatement("insert into cliente values(?,?,?,?,?,?);");
		ps.setInt(1, Integer.parseInt(idcliente));
		ps.setInt(2, Integer.parseInt(getidDireccion(getidbyname("Pais", "Nombre", pais),
													 getidbyname("provincia", "Nombre", provincia),
													 getidbyname("canton", "Nombre", canton),
													 detalles)));
		ps.setString(3, Nombre);
		ps.setString(4, pApellido);
		ps.setString(5, sApellido);
		ps.setInt(6, Integer.parseInt(telefono));
		ps.executeUpdate();
		
	}

	public static void insertarVenta(String Conce, String idCliente, String idauto) throws SQLException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		PreparedStatement ps = DataConnection.conexion().prepareStatement("insert into venta values(?,?,?,?,?,?)");
		ps.setInt(1, Integer.parseInt(getid1("venta", "idVenta")));
		ps.setInt(2, Integer.parseInt(getidbyname("concesionario", "NombreConcesionario", Conce)));
		ps.setInt(3, Integer.parseInt(idCliente));
		ps.setInt(4, Integer.parseInt(idauto));
		ps.setString(5, dateFormat.format(date).toString());
		ps.setInt(6, Integer.parseInt(getprecioAuto(idauto)));
		ps.executeUpdate();
	}

	public static void insertarreparaciones(String matricula, String idcliente, String taller, String mecanico) throws SQLException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		PreparedStatement ps = DataConnection.conexion().prepareStatement("insert into reparacion values(?,?,?,?,?,?,?)");
		ps.setInt(1, Integer.parseInt(getid1("reparacion", "idreparacion")));
		ps.setInt(2, Integer.parseInt(getidbyname("auto", "matricula", matricula)));
		ps.setInt(3, Integer.parseInt(idcliente));
		ps.setInt(4, Integer.parseInt(getidbyname("mecanico", "Nombre", mecanico)));
		ps.setInt(5, Integer.parseInt(getidbyname("taller", "nombre", taller)));
		ps.setInt(6, 0);
		ps.setString(7, dateFormat.format(date));
		ps.executeUpdate();
		
		
	}
}
