package com.maindao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Customers;
import com.jdbc_config.JdbcConnection;

public class CustDao {

	static JdbcConnection connect = new JdbcConnection();

	public void createTable(String tableName) throws SQLException {

		String query2 = "create table " + tableName + "" + "(customerId int primary key," + "firstName varchar(55) ,"
				+ "lastName varchar(55) ," + "phoneNumber varchar(55), " + "email varchar(55), bill double )";

		// 2 get connection from singleton class jdbcConnection
		Connection con = connect.getConnection();
		// 3 Step Create Statement

		PreparedStatement ptm = con.prepareStatement(query2);
		// 4 Execute Statement
		ptm.execute();

		System.out.println("Table created " + tableName);
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

		while (result.next()) {
			int customerId = result.getInt(1);
			String firstName = result.getString(2);
			String lastName = result.getString(3);
			String phoneNumber = result.getString(4);
			String email = result.getString(5);
			double bill = result.getDouble(6);

			Customers customer = new Customers(customerId, firstName, lastName, phoneNumber, email, bill);
			clist.add(customer);
		}

		// 5 close connection
		ptm.close();

		return clist;

	}

	public void createBill(int customerId, String firstName, String lastName, String phoneNumber, String email,
			double bill) throws SQLException {

		String query = "insert into customers Values ( " + customerId + ",'" + firstName + "', '" + lastName + "' ,'"
				+ phoneNumber + "' , '" + email + "'," + bill + ") ";

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

	public void DeleteById(int iId) throws SQLException {
		String query = "delete from customers " + " where customerId = ? ";

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

	public void updateCusNameById(String newName, int iId) throws SQLException {
		String query = "Update customers set firstName = '" + newName + "' where customerId = " + iId;

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

}
