package com.masai.Bean;




public class Transaction {

	private static String TId;

	private static String com_Id;

	private static String Customer_Id; 
	
	private static String Buy_Date;
	private static int Buy_Qty;
	private static int Buy_Amount; 
	private static String sell_Date;
	private static int sell_Qty;
	private static int sell_Amount;
	

	public Transaction(String tId, String com_Id, String customer_Id, String buy_Date, int buy_Qty, int buy_Amount, String sell_Date, int sell_Amount, int sell_Qty) {
		super();
		TId = tId;
		Transaction.com_Id = com_Id;
		Customer_Id = customer_Id;
		Buy_Date = buy_Date;
		Buy_Qty = buy_Qty;
		Buy_Amount = buy_Amount;
		Transaction.sell_Date = sell_Date;
		Transaction.sell_Qty = sell_Qty;
		Transaction.sell_Amount = sell_Amount;
	}
	
	
	@Override
	public String toString() {
		return "Transaction [TId=" + TId + ", com_Id=" + com_Id + ", Customer_Id="
				+ Customer_Id + ", Buy_Date=" + Buy_Date + ", Buy_Qty=" + Buy_Qty
				+ ", Buy_Amount=" + Buy_Amount + ", sell_Date=" + sell_Date + ", sell_Qty=" + sell_Qty
				+ ", sell_Amount=" + sell_Amount + "]";
	}





	public static String getTId() {
		return TId;
	}





	public void setTId(String tId) {
		TId = tId;
	}





	public static  String getCom_Id() {
		return com_Id;
	}





	public void setCom_Id(String com_Id) {
		Transaction.com_Id = com_Id;
	}




	public static String getCustomer_Id() {
		return Customer_Id;
	}





	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}






	public static String getBuy_Date() {
		return Buy_Date;
	}





	public void setBuy_Date(String buy_Date) {
		Buy_Date = buy_Date;
	}





	public static int getBuy_Qty() {
		return Buy_Qty;
	}





	public void setBuy_Qty(int buy_Qty) {
		Buy_Qty = buy_Qty;
	}





	public static int getBuy_Amount() {
		return Buy_Amount;
	}





	public void setBuy_Amount(int buy_Amount) {
		Buy_Amount = buy_Amount;
	}





	public static String getSell_Date() {
		return sell_Date;
	}





	public void setSell_Date(String sell_Date) {
		Transaction.sell_Date = sell_Date;
	}





	public static int getSell_Qty() {
		return sell_Qty;
	}





	public void setSell_Qty(int sell_Qty) {
		Transaction.sell_Qty = sell_Qty;
	}





	public static int getSell_Amount() {
		return sell_Amount;
	}





	public void setSell_Amount(int sell_Amount) {
		Transaction.sell_Amount = sell_Amount;
	}


	
	
}
