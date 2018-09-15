package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataConnection {
	//Constructor
	public DataConnection(String nombreBD, String user, String pass) {
		this.nombreBD = nombreBD;
		this.user = user;
		this.pass = pass;
		this.url = "jdbc:mysql://localhost:3306/"+nombreBD
				+"?useTimezone=true&serverTimezone=UTC";
	}
	
	//Constructor vacio
	public DataConnection() {}
	
	private String nombreBD ;
	private static String url;
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	private static String user = "root";
	private static String pass = "";
	
	//metodo para conectar con la base de datos
	public static Connection conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	//metodo para solicitar un query
	public static ResultSet getData(String query) {
		Connection cn = conexion();
		Statement st;
		ResultSet data = null;
		try {
			st = cn.createStatement();
			data = st.executeQuery(query);
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return data;
		
	}
	
	
	public String getNombreBD() {
		return nombreBD;
	}

	public void setNombreBD(String nombreBD) {
		this.nombreBD = nombreBD;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Statement getSt() {
		return st;
	}

	public void setSt(Statement st) {
		this.st = st;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	
}
