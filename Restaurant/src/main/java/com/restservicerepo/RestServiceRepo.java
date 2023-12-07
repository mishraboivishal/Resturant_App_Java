package com.restservicerepo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Customers;
import com.entity.Menu;

public interface RestServiceRepo {

	public void createTable(String tableName) throws SQLException;

	public void insertItem(int iId, String iName, double iPrice, String iCategory) throws SQLException;

	public void FetchMenu(String tableName) throws SQLException;
	
	public ArrayList<Customers> fetchCustomers(String tableName) throws SQLException;

	public void updateStrValues(String tableName, String colName, String newStr, int iId) throws SQLException;

	public void updateNumValues(String tableName, String colName, int newNum, int iId) throws SQLException;

	public void DeleteById(int iId, String tableName) throws SQLException;

	public void createBill(int customerId, String firstName, String lastName, String phoneNumber, String email)
			throws SQLException;
}
