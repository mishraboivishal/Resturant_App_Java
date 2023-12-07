package com.entity;

public class Menu {
	// item details to store in menu
	private int iId;
	private String iName;
	private double iPrice;
	private String iCategory;

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(int iId, String iName, double iPrice, String iCategory) {
		super();
		this.iId = iId;
		this.iName = iName;
		this.iPrice = iPrice;
		this.iCategory = iCategory;
	}

	public int getiId() {
		return iId;
	}

	public void setiId(int iId) {
		this.iId = iId;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public double getPrice() {
		return iPrice;
	}

	public void setPrice(double price) {
		this.iPrice = price;
	}

	public String getCategory() {
		return iCategory;
	}

	public void setCategory(String category) {
		this.iCategory = category;
	}

	@Override
	public String toString() {
		return "item id: " + iId + ", item name: " + iName + ", item price: " + iPrice + ", item category: "
				+ iCategory;
	}

}
