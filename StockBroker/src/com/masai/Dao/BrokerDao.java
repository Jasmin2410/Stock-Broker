package com.masai.Dao;

import java.util.List;

import com.masai.Bean.Broker;
import com.masai.Bean.Consolidated;
import com.masai.Bean.Customer;
import com.masai.Bean.Stock;
import com.masai.Bean.Transaction;
import com.masai.Exception.BrokerException;
import com.masai.Exception.ConsolidatedException;
import com.masai.Exception.CustomerException;
import com.masai.Exception.StockException;
import com.masai.Exception.TransactionException;

public interface BrokerDao {

	public Broker loginAdmin(String Broker_id, String Broker_password) throws  BrokerException ;  

	public String create_Stock(Stock stock)throws StockException;

	public String delete_Stock(String com_Id)throws StockException;

	public String create_Customer(Customer Customer)throws CustomerException;
	
	public String delete_Customer(String Customer_Id)throws CustomerException;

	
	public List<Stock> view_All_Stock() throws StockException;
	
	public List<Customer> view_All_Customer() throws CustomerException;
	
	public List<Consolidated> view_Consolidated()throws ConsolidatedException;
	
	public List<Transaction> view_Transaction()throws TransactionException;

}


