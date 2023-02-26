package com.masai.Bean;

public class Customer {
	private  String Customer_Id;
	private String Customer_Name;
	private String Customer_Password;
	private String Customer_Contact;
	private String Customer_Email;
	private  int Wallet;
	
	public Customer() {}

	public Customer(String customer_Id, String customer_Name, String customer_Password, String customer_Contact,
			String customer_Email, int wallet) {
		super();
		Customer_Id = customer_Id;
		Customer_Name = customer_Name;
		Customer_Password = customer_Password;
		Customer_Contact = customer_Contact;
		Customer_Email = customer_Email;
		Wallet = wallet;
	}

	@Override
	public String toString() {
		return "Customer [Customer_Id=" + Customer_Id + ", Customer_Name=" + Customer_Name + ", Customer_Password="
				+ Customer_Password + ", Customer_Contact=" + Customer_Contact + ", Customer_Email=" + Customer_Email
				+ ", Wallet=" + Wallet + "]";
	}

	public String getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}

	public String getCustomer_Name() {
		return Customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}

	public String getCustomer_Password() {
		return Customer_Password;
	}

	public void setCustomer_Password(String customer_Password) {
		Customer_Password = customer_Password;
	}

	public String getCustomer_Contact() {
		return Customer_Contact;
	}

	public void setCustomer_Contact(String customer_Contact) {
		Customer_Contact = customer_Contact;
	}

	public String getCustomer_Email() {
		return Customer_Email;
	}

	public void setCustomer_Email(String customer_Email) {
		Customer_Email = customer_Email;
	}

	public int getWallet() {
		return Wallet;
	}

	public void setWallet(int wallet) {
		Wallet = wallet;
	}

	
	
}
