package testnewpackage.boundary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Record {
	private String name;
	private ArrayList<Searchterm> listofsterm;
	private Connection con;
	
	public String getName() {
		//Statement preparedStatement = null;
		String name = null;
		

		try {
			con = DriverManager.getConnection("jdbc:sqlite:sample.de");
			Statement preparedStatement = con.createStatement();
			ResultSet selectAllRecords = preparedStatement.executeQuery("SELECT Recordname FROM record WHERE Recordname='"+this.name+"'");
			while(selectAllRecords.next()){
				name = (selectAllRecords.getString("Recordname"));
			
			
			}
		

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

		
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
		return name;
	}
	public void setName(String name) {
		//INSERT INTO RECORD DATABASE
		
		
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT OR REPLACE INTO record"
				+ "(Recordname) VALUES"
				+ "(?)";

		try {
			con = DriverManager.getConnection("jdbc:sqlite:sample.de");
			preparedStatement = con.prepareStatement(insertTableSQL);

			
			preparedStatement.setString(1, name);

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
	public ArrayList<Searchterm> getListofsterm() {
		return listofsterm;
	}
	public void setListofsterm(ArrayList<Searchterm> listofsterm) {
		this.listofsterm = listofsterm;
	}
	

}
