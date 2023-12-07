package com.maincontroller;

import java.sql.SQLException;
import java.util.Scanner;

import com.mainservice.CustService;
import com.mainservice.RestService;

public class MainController {

	static RestService rs = new RestService();
	static CustService cs = new CustService();

	public static void OpenRestaurant() throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println();

		System.out.println("What do you want to do in Menu?");
		System.out.println();
		System.out.println("Create Table : Press 1");
		System.out.println("Add Menu Item : Press 2");
		System.out.println("Display all items of menu: Press 3");
		System.out.println("Display item of menu by id : Press 4");
		System.out.println("Delete Menu Item by id : Press 5");
		System.out.println("update Item name by Id : Press 6");
		System.out.println("update Item price by Id : Press 7");
		System.out.println("update Item Category by Id : Press 8");

		System.out.println();

		System.out.println("What do you want to do in Customers?");
		System.out.println();
		System.out.println("create Customer table : Press 9");
		System.out.println("Create bill of customers : 10");
		System.out.println("Display all Previous Customer : Press 11");
		System.out.println("Delete Customer by id : Press 12");
		System.out.println("update Customers name by Id : Press 13");
		System.out.println();

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

			System.out.println("Insert Items Please : ");
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

		case 3:
			System.out.println("Menu Items are : ");
			System.out.println();
			rs.FetchMenu("menu");

			OpenRestaurant();

			break;

		case 4:
			rs.fetchById(1);
			OpenRestaurant();
			break;

		case 5:

			System.out.println("Enter id of row you want to delete : ");
			int iId = sc.nextInt();
			sc.nextLine();

			rs.DeleteById(iId);
			OpenRestaurant();
			break;

		case 6:

			rs.updateNameById("Pikach", 2);
			OpenRestaurant();
			break;

		case 7:
			rs.updatePriceById(501, 1);
			OpenRestaurant();
			break;

		case 8:
			rs.updateCategoryById("veg", 1);
			OpenRestaurant();
			break;

		case 9:

			cs.createTable("Customers");
			OpenRestaurant();
			break;
		case 10:

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

			cs.createBill(cid, firstName, lastName, phoneNumber, email, bill);
			OpenRestaurant();

			break;

		case 11:

			cs.fetchCustomers("customers");
			OpenRestaurant();
			break;

		case 12:
			System.out.println("Enter id of customer to be deleted : ");
			int cId = sc.nextInt();
			sc.nextLine();
			cs.DeleteById(cId);
			break;

		case 13:
			cs.updateCusNameById("Hero", 2);
			OpenRestaurant();
			break;

		default:
			break;
		}

	}

	public static void main(String[] args) throws SQLException {

		OpenRestaurant();

	}
}
