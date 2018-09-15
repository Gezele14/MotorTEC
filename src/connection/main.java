package connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {

	public static void main(String[] args) {
		DataConnection conexion = new DataConnection("world","root","gera1234");
	
		try {
			Statement st = conexion.conexion().createStatement();
			ResultSet rs = st.executeQuery("Select * From city");
			
			while (rs.next()) {
				System.out.println(rs.getString("Name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		try {
			conexion.conexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
