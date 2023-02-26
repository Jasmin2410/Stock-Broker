package com.masai.Bean;

public class SellStock {

	private String Customer_Id;
	private String Com_Id;
	private String Sell_date;
	private int Sell_Qty;
	private int Sell_Amount;
	public SellStock(String customer_Id, String Com_Id, String sell_date, int sell_Qty, int sell_Amount) {
		super();
		Customer_Id = customer_Id;
		this.Com_Id = Com_Id;
		Sell_date = sell_date;
		Sell_Qty = sell_Qty;
		Sell_Amount = sell_Amount;
	}
	public String getCustomer_Id() {
		return Customer_Id;
	}
	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}
	public String getCom_Id() {
		return Com_Id;
	}
	public void setCom_Id(String com_Id) {
		this.Com_Id = com_Id;
	}
	public String getSell_date() {
		return Sell_date;
	}
	public void setSell_date(String sell_date) {
		Sell_date = sell_date;
	}
	public int getSell_Qty() {
		return Sell_Qty;
	}
	public void setSell_Qty(int sell_Qty) {
		Sell_Qty = sell_Qty;
	}
	public int getSell_Amount() {
		return Sell_Amount;
	}
	public void setSell_Amount(int sell_Amount) {
		Sell_Amount = sell_Amount;
	}
	@Override
	public String toString() {
		return "SellStock [Customer_Id=" + Customer_Id + ", com_Id=" + Com_Id + ", Sell_date=" + Sell_date
				+ ", Sell_Qty=" + Sell_Qty + ", Sell_Amount=" + Sell_Amount + "]";
	}
	
	
}
