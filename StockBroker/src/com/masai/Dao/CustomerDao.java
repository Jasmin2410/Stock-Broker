package com.masai.Dao;

import java.util.List;

import com.masai.Bean.Customer;

import com.masai.Bean.Stock;

import com.masai.Exception.CustomerException;

import com.masai.Exception.StockException;



public interface CustomerDao {

	public  Customer loginUser(String Customer_Id, String Customer_Password) throws CustomerException;
	
	public  List<Stock> view_All_Stock() throws StockException;

	public String Buy_Stock(String com_ID );

	public String Sell_Stock(String com_ID );

	public String Add_Fund(int wallet );

	public String WithDraw_Fund(int wallet );


	
	  
}

 

