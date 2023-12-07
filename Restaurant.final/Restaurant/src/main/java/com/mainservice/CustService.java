package com.mainservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.entity.Customers;
import com.maindao.CustDao;
import com.maindao.RestDao;

public class CustService {

	static CustDao cd = new CustDao();

	public void createTable(String tableName) throws SQLException {

		if (tableName != null) {
			cd.createTable(tableName);
		} else {
			System.out.println("Enter table name correctly");
		}

	}

	public void fetchCustomers(String tableName) throws SQLException {
		ArrayList<Customers> clist = cd.fetchCustomers(tableName);
		clist.stream().forEach(System.out::println);

	}

	public void createBill(int customerId, String firstName, String lastName, String phoneNumber, String email,
			int bill) throws SQLException {

		ArrayList<Customers> clist = cd.fetchCustomers("customers");

		if (customerId != 0 && firstName != null && lastName != null && phoneNumber != null && email != null) {

			long phoneNumberOccurrences = clist.stream().filter(x -> x.getPhoneNumber().equals(phoneNumber)).count();
			System.out.println(phoneNumberOccurrences);

			if (phoneNumberOccurrences >= 2) {
				System.out.println("Hurrah! You are our loyal customer. You get 10% Discount on bill ");

				double discount = bill * 0.10;
				double discountedBill = bill - discount;
				System.out.println("Your final total with discount is: " + discountedBill);
				cd.createBill(customerId, firstName, lastName, phoneNumber, email, discountedBill);
			} else {
				cd.createBill(customerId, firstName, lastName, phoneNumber, email, bill);
			}
		} else {
			System.out.println("Data of the customer not added properly");
		}
	}

	public void DeleteById(int iId) throws SQLException {
		if (iId != 0) {
			cd.DeleteById(iId);
		} else {
			System.out.println("Enter id correctly");
		}
	}
	
	
	public void updateCusNameById(String newName, int iId) throws SQLException {
		if (iId != 0 && newName != null) {
			cd.updateCusNameById(newName, iId);
		} else {
			System.out.println("Enter update values correctly");
		}
	}
	
}
