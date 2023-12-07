package com.maindao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Customers;
import com.entity.Menu;
import com.jdbc_config.JdbcConnection;

public class RestDao {

	static JdbcConnection connect = new JdbcConnection();

	public void createTable(String tableName) throws SQLException {
		String query = "create table " + tableName + "" + "(iId int primary key," + "iName varchar(55),"
				+ "iPrice Double," + "iCategory varchar(55))";

		
		// 2 get connection from singleton class jdbcConnection
		Connection con = connect.getConnection();
		// 3 Step Create Statement

		PreparedStatement ptm = con.prepareStatement(query);
		// 4 Execute Statement
		ptm.execute();

		System.out.println("Table created " + tableName);
		// 5 close connection
		ptm.close();

	}

	public void insertItem(int iId, String iName, double iPrice, String iCategory) throws SQLException {

		String query = "insert into menu Values ( " + iId + ",'" + iName + "'," + iPrice + ",'" + iCategory + "')";

		// 2 get connection from singleton class jdbcConnection
		Connection con = connect.getConnection();
		// 3 Step Create Statement

		PreparedStatement ptm = con.prepareStatement(query);
		// 4 Execute Statement
		ptm.execute();

		System.out.println("Inserted Values Successfully ");
		// 5 close connection
		ptm.close();

	}

	public ArrayList<Menu> FetchMenu(String tableName) throws SQLException {

		String query = "select * from " + tableName;

		// 2 get connection from singleton class jdbcConnection
		Connection con = connect.getConnection();
		
		// 3 Step Create Statement

		PreparedStatement ptm = con.prepareStatement(query);
		// 4 Execute Statement
		ResultSet result = ptm.executeQuery();
		
		
		ArrayList<Menu> mlist = new ArrayList<>();
		
		while(result.next()) {
			int iId = result.getInt(1);
			String iName = result.getString(2);
			double iPrice = result.getDouble(3);
			String iCategory = result.getString(4);
		
			Menu menu = new Menu(iId, iName, iPrice, iCategory);
			mlist.add(menu);
		}
		
		
		
		// 5 close connection
		ptm.close();

		return mlist;

	}
	
	
	public void fetchById(int iId) throws SQLException {
		
		String query = "select * from menu  " + " where iId = " + iId;
		
		// 2 get connection from singleton class jdbcConnection
				Connection con = connect.getConnection();
				// 3 Step Create Statement

				PreparedStatement ptm = con.prepareStatement(query);
				// 4 Execute Statement
				ResultSet result = ptm.executeQuery();
				
				while(result.next()) {
					int iId1 = result.getInt(1);
					String iName = result.getString(2);
					double iPrice = result.getDouble(3);
					String iCategory = result.getString(4);
				
					Menu menu = new Menu(iId1, iName, iPrice, iCategory);
					System.out.println(menu);
				}
				

				System.out.println("Successfully fetch values of only id = " + iId);
				// 5 close connection
				ptm.close();

		
	}
	
	
	
	
	public void updateNameById(String newName, int iId) throws SQLException{
		String query = "Update menu set iName = '" + newName   + "' where iId = " + iId;
		
		// 2 get connection from singleton class jdbcConnection
				Connection con = connect.getConnection();
				// 3 Step Create Statement

				PreparedStatement ptm = con.prepareStatement(query);
				// 4 Execute Statement
				ptm.executeUpdate();

				System.out.println("Updated Values Successfully as " + newName);
				// 5 close connection
				ptm.close();

	}
	
	public void updatePriceById(int iPrice, int iId) throws SQLException{
		String query = "Update menu set iPrice = " + iPrice   + " where iId = " + iId;
		
		// 2 get connection from singleton class jdbcConnection
				Connection con = connect.getConnection();
				// 3 Step Create Statement

				PreparedStatement ptm = con.prepareStatement(query);
				// 4 Execute Statement
				ptm.executeUpdate();

				System.out.println("Updated Values Successfully as " + iPrice);
				// 5 close connection
				ptm.close();

	}
	
	public void updateCategoryById(String categoryName, int iId) throws SQLException {
		// TODO Auto-generated method stub
String query = "Update menu set iCategory = '" + categoryName  + "' where iId = " + iId;
		
		// 2 get connection from singleton class jdbcConnection
				Connection con = connect.getConnection();
				// 3 Step Create Statement

				PreparedStatement ptm = con.prepareStatement(query);
				// 4 Execute Statement
				ptm.executeUpdate();

				System.out.println("Updated Values Successfully as " + categoryName);
				// 5 close connection
				ptm.close();

	}
	
	
	
	
	
	public void DeleteById(int iId) throws SQLException {
		String query = "delete from menu " + " where iId = ? " ;
		
		
		// 2 get connection from singleton class jdbcConnection
				Connection con = connect.getConnection();
				// 3 Step Create Statement

				PreparedStatement ptm = con.prepareStatement(query);
				
				ptm.setInt(1, iId);
				
				// 4 Execute Statement
				int rowsAffected = ptm.executeUpdate();

		        if (rowsAffected > 0) {
		            System.out.println("Deleted Row of id :  " + iId);
		        } else {
		            System.out.println("No records deleted. Please check if iId exists.");
		        }
				
		 
				// 5 close connection
				ptm.close();
		
			
	}

	
	


	

}
