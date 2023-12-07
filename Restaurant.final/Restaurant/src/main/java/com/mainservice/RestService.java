package com.mainservice;

import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Customers;
import com.entity.Menu;
import com.maindao.CustDao;
import com.maindao.RestDao;
import com.restservicerepo.RestServiceRepo;

public class RestService implements RestServiceRepo {

	static RestDao rd = new RestDao();

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

	public void fetchById(int iId) throws SQLException {
		if (iId != 0) {
			rd.fetchById(iId);
		} else {
			System.out.println("Enter id correctly");
		}
	}

	

	public void updateNameById(String newName, int iId) throws SQLException {
		if (iId != 0 && newName != null) {
			rd.updateNameById(newName, iId);
		} else {
			System.out.println("Enter update values correctly");
		}
	}

	public void updatePriceById(int iPrice, int iId) throws SQLException {
		if (iId != 0 && iPrice != 0) {
			rd.updatePriceById(iPrice, iId);
		} else {
			System.out.println("Enter update values correctly");
		}
	}

	public void updateCategoryById(String categoryName, int iId) throws SQLException {
		// TODO Auto-generated method stub
		if (iId != 0 && categoryName != null) {
			rd.updateCategoryById(categoryName, iId);
		} else {
			System.out.println("Enter update values correctly");
		}
	}
	
	public void DeleteById(int iId) throws SQLException {
		if (iId != 0) {
			rd.DeleteById(iId);
		} else {
			System.out.println("Enter id correctly");
		}
	}
	

}
