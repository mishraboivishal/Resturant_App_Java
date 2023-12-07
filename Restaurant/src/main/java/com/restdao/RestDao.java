package com.restdao;

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

		String query2 = "create table " + tableName + "" + "(customerId int primary key," + "firstName varchar(55) ,"
				+ "lastName varchar(55) ," + "phoneNumber varchar(55), " + "email varchar(55))";

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
	
	
	public void updateStrValues(String tableName, String colName, String newStr ,  int iId) throws SQLException {
		String query = "Update " + tableName  
				+ " set " 
				+ colName +" = '" 
				+ newStr    
				+ "' where iId = " + iId ;
		

		// 2 get connection from singleton class jdbcConnection
		Connection con = connect.getConnection();
		// 3 Step Create Statement

		PreparedStatement ptm = con.prepareStatement(query);
		// 4 Execute Statement
		ptm.execute();

		System.out.println("Updated Values Successfully at column " + colName);
		// 5 close connection
		ptm.close();


	} 
	
	
	public void updateNumValues(String tableName, String colName, int newNum ,  int iId) throws SQLException {
		String query = "Update " + tableName  
				+ " set " 
				+ colName + " =  ? " + " where iId = ? ";
		

		// 2 get connection from singleton class jdbcConnection
		Connection con = connect.getConnection();
		// 3 Step Create Statement

		PreparedStatement ptm = con.prepareStatement(query);
		
		ptm.setInt(1, newNum);
		ptm.setInt(2, iId);
		
		// 4 Execute Statement
		int rowsAffected = ptm.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Updated Values Successfully at column " + colName);
        } else {
            System.out.println("No records updated. Please check if iId exists.");
        }
		
 
		// 5 close connection
		ptm.close();


	}
	
	
	public void DeleteById(int iId,String tableName ) throws SQLException {
		String query = "delete from " + tableName  + " where iId = ? " ;
		
		
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
	
	
	public ArrayList<Customers> fetchCustomers(String tableName) throws SQLException {

		String query = "select * from " + tableName;

		// 2 get connection from singleton class jdbcConnection
		Connection con = connect.getConnection();
		
		// 3 Step Create Statement

		PreparedStatement ptm = con.prepareStatement(query);
		// 4 Execute Statement
		ResultSet result = ptm.executeQuery();
		
		
		ArrayList<Customers> clist = new ArrayList<>();
		
		while(result.next()) {
			int customerId = result.getInt(1);
			String firstName = result.getString(2);
			String lastName = result.getString(3);
			String phoneNumber = result.getString(4);
			String email = result.getString(5);
			
		
			Customers customer = new Customers();
			clist.add(customer);
		}
		
		
		
		// 5 close connection
		ptm.close();

		return clist;

	}
	

	public void createBill( int customerId,
     String firstName,
     String lastName,
     String phoneNumber,
     String email)  throws SQLException {

		String query = "insert into customers Values ( " + customerId + ",'" 
		+ firstName + "', '" + lastName + "' ,'" + phoneNumber + "' , '" + email + "')";
		
		
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
	

}
