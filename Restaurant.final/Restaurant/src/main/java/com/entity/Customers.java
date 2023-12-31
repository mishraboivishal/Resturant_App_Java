package com.entity;

public class Customers {
	  private int customerId;
	    private String firstName;
	    private String lastName;
	    private String phoneNumber;
	    private String email;
	    private double bill;
	    
		public Customers() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Customers(int customerId, String firstName, String lastName, String phoneNumber, String email, double bill) {
			super();
			this.customerId = customerId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
			this.email = email;
			this.bill = bill;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@Override
		public String toString() {
			return "Customers [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", bill=" + bill + "]";
		}
		public double getBill() {
			return bill;
		}
		public void setBill(double bill) {
			this.bill = bill;
		}
	    
		
	    
}
