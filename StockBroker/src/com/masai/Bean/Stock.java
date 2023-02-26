package com.masai.Bean;

public class Stock {

	
	private String com_Id;
	private String com_Name;
	private int stock_Quantity;
	private String stock_Type;
	private int per_stock_price;
	private int Total_stock_price;
	
	
	
	public Stock(String com_Id, String com_Name, int stock_Quantity, String stock_Type, int per_stock_price,
			int total_stock_price) {
		super();
		this.com_Id = com_Id;
		this.com_Name = com_Name;
		this.stock_Quantity = stock_Quantity;
		this.stock_Type = stock_Type;
		this.per_stock_price = per_stock_price;
		Total_stock_price = total_stock_price;
	}

	@Override
	public String toString() {
		return "Stock [com_Id=" + com_Id + ", com_Name=" + com_Name + ", stock_Quantity=" + stock_Quantity
				+ ", stock_Type=" + stock_Type + ", per_stock_price=" + per_stock_price + ", Total_stock_price="
				+ Total_stock_price + "]";
	}

	public String getCom_Id() {
		return com_Id;
	}

	public void setCom_Id(String com_Id) {
		this.com_Id = com_Id;
	}

	public String getCom_Name() {
		return com_Name;
	}

	public void setCom_Name(String com_Name) {
		this.com_Name = com_Name;
	}

	public int getStock_Quantity() {
		return stock_Quantity;
	}

	public void setStock_Quantity(int stock_Quantity) {
		this.stock_Quantity = stock_Quantity;
	}

	public String getStock_Type() {
		return stock_Type;
	}

	public void setStock_Type(String stock_Type) {
		this.stock_Type = stock_Type;
	}

	public int getPer_stock_price() {
		return per_stock_price;
	}

	public void setPer_stock_price(int per_stock_price) {
		this.per_stock_price = per_stock_price;
	}

	public int getTotal_stock_price() {
		return Total_stock_price;
	}

	public void setTotal_stock_price(int total_stock_price) {
		Total_stock_price = total_stock_price;
	}
	public static void main(String[] args) {
		
	}

	
}
