package com.restservice;

import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Customers;
import com.entity.Menu;
import com.restdao.RestDao;
import com.restservicerepo.RestServiceRepo;

public class RestService implements RestServiceRepo {

	RestDao rd = new RestDao();

	public void createTable(String tableName) throws SQLException {

		if (tableName != null) {
			rd.createTable(tableName);
		} else {
			System.out.println("Enter table name correctly");
		}

	}

	public void insertItem(int iId, String iName, double iPrice, String iCategory) throws SQLException {

		if (iId != 0 && iName != null && iPrice != 0 && iCategory != null) {
			rd.insertItem(iId, iName, iPrice, iCategory);
		} else {
			System.out.println("Enter table name correctly");
		}

	}

	public void FetchMenu(String tableName) throws SQLException {
		ArrayList<Menu> mlist = rd.FetchMenu(tableName);
		mlist.stream().forEach(System.out::println);
	}

	public void updateStrValues(String tableName, String colName, String newStr, int iId) throws SQLException {
		if (iId != 0 && colName != null && newStr != null) {
			rd.updateStrValues(tableName, colName, newStr, iId);
		} else {
			System.out.println("Enter update table name correctly");
		}
	}

	public void updateNumValues(String tableName, String colName, int newNum, int iId) throws SQLException {
		if (iId != 0 && colName != null && newNum > 0 && tableName != null) {
			rd.updateNumValues(tableName, colName, newNum, iId);
		} else {
			System.out.println("Enter update table name correctly");
		}
	}

	public void DeleteById(int iId, String tableName) throws SQLException {
		if (iId != 0 && tableName != null) {
			rd.DeleteById(iId, tableName);
		} else {
			System.out.println("Enter id correctly");
		}
	}
	
	public ArrayList<Customers> fetchCustomers(String tableName) throws SQLException{
		ArrayList<Customers> clist = rd.fetchCustomers(tableName);
		
		return clist;
	}

	public void createBill(int customerId, 
			String firstName, String lastName, String phoneNumber, String email)
			throws SQLException {
		
		ArrayList<Customers> clist = rd.fetchCustomers("customers");
		
		if (customerId != 0 && firstName != null && lastName != null && phoneNumber != null && email != null) {
			
			
			if( clist.stream().anyMatch(x -> x.getFirstName() == firstName) ) {
				System.out.println("Match found");
			}
			
			
			rd.createBill(customerId, firstName, lastName, phoneNumber, email);
		} else {
			System.out.println("Data of customer not added properly");
		}

	}

}
