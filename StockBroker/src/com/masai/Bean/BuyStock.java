package com.masai.Bean;



public class BuyStock {
	
	private String Customer_Id;
	private String com_Id;
	
	private String Buy_Date;
	private int Buy_Qty;
	private int Buy_Amount;
	
	
	public BuyStock( String customer_Id, String com_Id,  String buy_Date, int buy_Qty,
			int buy_Amount) {
		super();
	
		Customer_Id = customer_Id;
		this.com_Id = com_Id;
		
		Buy_Date = buy_Date;
		Buy_Qty = buy_Qty;
		Buy_Amount = buy_Amount;
	}
	
	
	
	public String getCustomer_Id() {
		return Customer_Id;
	}
	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}
	public String getCom_Id() {
		return com_Id;
	}
	public void setCom_Id(String com_Id) {
		this.com_Id = com_Id;
	}
	
	public String getBuy_Date() {
		return Buy_Date;
	}
	public void setBuy_Date(String buy_Date) {
		Buy_Date = buy_Date;
	}
	public int getBuy_Qty() {
		return Buy_Qty;
	}
	public void setBuy_Qty(int buy_Qty) {
		Buy_Qty = buy_Qty;
	}
	public int getBuy_Amount() {
		return Buy_Amount;
	}
	public void setBuy_Amount(int buy_Amount) {
		Buy_Amount = buy_Amount;
	}
	
	
	@Override
	
	public String toString() {
		return "BuyStock [Customer_Id=" + Customer_Id + ", com_Id=" + com_Id +  ", Buy_Date=" + Buy_Date + ", Buy_Qty=" + Buy_Qty + ", Buy_Amount=" + Buy_Amount + "]";
	}
	
	
	
}

	
