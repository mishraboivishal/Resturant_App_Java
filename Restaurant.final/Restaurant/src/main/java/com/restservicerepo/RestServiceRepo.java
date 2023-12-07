package com.restservicerepo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Customers;
import com.entity.Menu;

public interface RestServiceRepo {

	public void createTable(String tableName) throws SQLException;

	public void insertItem(int iId, String iName, double iPrice, String iCategory) throws SQLException;

	public void FetchMenu(String tableName) throws SQLException;
	
	public void fetchById(int iId) throws SQLException;

	public void DeleteById(int iId) throws SQLException;
	
	public void updateNameById(String newName, int iId) throws SQLException;
	
	public void updatePriceById(int iPrice, int iId) throws SQLException;
	
	public void updateCategoryById(String categoryName, int iId) throws SQLException;
	
}
