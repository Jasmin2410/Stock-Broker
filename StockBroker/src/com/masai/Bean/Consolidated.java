package com.masai.Bean;

public class Consolidated {
	private String com_id;
	private String customer_id;
	private int sold;
	private int pending;
	private int total;
	
	
	public Consolidated() {}


	public Consolidated(String com_id, String customer_id, int sold, int pending, int total) {
		super();
		this.com_id = com_id;
		this.customer_id = customer_id;
		this.sold = sold;
		this.pending = pending;
		this.total = total;
	}


	@Override
	public String toString() {
		return "Consolidated [com_id=" + com_id + ", customer_id=" + customer_id + ", sold=" + sold + ", pending="
				+ pending + ", total=" + total + "]";
	}


	public String getCom_id() {
		return com_id;
	}


	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}


	public String getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}


	public int getSold() {
		return sold;
	}


	public void setSold(int sold) {
		this.sold = sold;
	}


	public int getPending() {
		return pending;
	}


	public void setPending(int pending) {
		this.pending = pending;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
