package connection;

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
	private String url;
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String user = "root";
	private String pass = "";
	
	//clase para conectar con la base de datos
	public Connection conexion() {
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
