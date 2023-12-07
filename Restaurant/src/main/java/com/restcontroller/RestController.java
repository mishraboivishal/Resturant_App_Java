package com.restcontroller;

import java.sql.SQLException;
import java.util.Scanner;

import com.restservice.RestService;

public class RestController {
	
	static RestService rs = new RestService();
	
	
	public static void updateStrValues() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter TableName : ");
		String tb1 = sc.nextLine();
		
		System.out.println("Enter colName where change to be done : ");
		String colName = sc.nextLine();

		System.out.println("Enter newValue to be set : ");
		String newStr = sc.nextLine();
		
		
		System.out.println("Enter iId : ");
		int iId = sc.nextInt();
		sc.nextLine();

		System.out.println();
		
		rs.updateStrValues(tb1, colName, newStr, iId);
		OpenRestaurant();
	}
	
	
	public static void updateNumValues() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter TableName : ");
		String tb1 = sc.nextLine();
		
		System.out.println("Enter colName where change to be done : ");
		String colName = sc.nextLine();

		System.out.println("Enter newValue to be set : ");
		int newNum = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter iId : ");
		int iId = sc.nextInt();
		sc.nextLine();

		System.out.println();
		
		rs.updateNumValues(tb1, colName, newNum, iId);
		OpenRestaurant();
	}
	
	
	public static void OpenRestaurant() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("What do you want to do ?");
		System.out.println("Create Table : Press 1");
		System.out.println("Display all items of menu: Press 2");
		System.out.println("Add Menu Item : Press 3");
		System.out.println("Update Menu Item : Press 4");
		System.out.println("Delete Menu Item : Press 5");
		System.out.println("Create bill of customers : 6");
		System.out.println("");
		System.out.println("");
		
		
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice) {
		case 1:
			System.out.println();
			System.out.println("Enter table name to be created : ");
			String tableName = sc.nextLine();
			rs.createTable(tableName);
			OpenRestaurant();
			break;
			
		case 2:
			System.out.println("Menu Items are : ");
			System.out.println();
			rs.FetchMenu("menu");
			
			OpenRestaurant();
			break;	
			
		
		case 3 :
			System.out.println("Enter item Id : ");
			int id = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter item name : ");
			String iName = sc.nextLine();
			
			System.out.println("Enter item price : ");
			int iPrice = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter item category name : ");
			String iCategory = sc.nextLine();
			System.out.println();
			
			rs.insertItem(id, iName, iPrice, iCategory);
			OpenRestaurant();
			
			break;
			
		case 4:
			System.out.println("Update Values of String : Press 1");
			System.out.println("Update Values of Numericals : Press 2");
			
			int choice2 = sc.nextInt();
			sc.nextLine();
			
			switch (choice2) {
			case 1:
				updateStrValues();
				break;
			
			case 2:
				updateNumValues();
				break;
		
			default:
				break;
			}
			
			break;
		
		case 5 : 
			System.out.println("Enter TableName : ");
			String tb2 = sc.nextLine();
			
			System.out.println("Enter iId : ");
			int iId = sc.nextInt();
			sc.nextLine();
			
			rs.DeleteById(iId, tb2);
			break;
			
		case 6 :
			
			System.out.println("Enter customer  Id : ");
			int cid = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter firstName : ");
			String firstName = sc.nextLine();
			
			System.out.println("Enter lastName : ");
			String lastName = sc.nextLine();
			
			System.out.println("Enter phoneNumber : ");
			String phoneNumber = sc.nextLine();
			
			System.out.println("Enter email : ");
			String email = sc.nextLine();
			
			System.out.println("Enter bill amount : ");
			int bill = sc.nextInt();
			sc.nextLine();
			
			rs.createBill(cid, firstName, lastName, phoneNumber, email);
			OpenRestaurant();
			
			break;
		default:
			break;
		}
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) throws SQLException {
//		1. Display Menu Items  DONE
//		2. Add New Item to Menu DONE
//		3. Update Menu  DONE
//		4. Delete Item from Menu 
//		5. Search Item+
//		6. Customer Details
//      7. bill if recurring customer then discount of 10 %
//		0. Exit
		
		OpenRestaurant();
		
	}
}
