package com.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.connection.DataConnection;

public class dataDB {
	
	static DataConnection con = new DataConnection("world", "root", "gera1234");
	
	public static DefaultTableModel getEstudiantes() {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs = con.getData("Select * From city");
		model.setColumnIdentifiers(new Object[] {"Ciy","Country"});
		
		try {
			while(rs.next()) {
				model.addRow(new Object[] {rs.getString("ID"), rs.getString("Name")});
			}
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		
		return model;
		
	}
}
