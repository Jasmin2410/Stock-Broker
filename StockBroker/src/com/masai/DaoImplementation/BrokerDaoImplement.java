package com.masai.DaoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Bean.Broker;
import com.masai.Bean.Consolidated;
import com.masai.Bean.Customer;
import com.masai.Bean.Stock;
import com.masai.Bean.Transaction;
import com.masai.Dao.BrokerDao;
import com.masai.Exception.BrokerException;
import com.masai.Exception.ConsolidatedException;
import com.masai.Exception.CustomerException;
import com.masai.Exception.StockException;
import com.masai.Exception.TransactionException;
import com.masai.Utility.DataBaseUtility;

public   class BrokerDaoImplement implements BrokerDao{
   
	
	
	@Override
	public Broker loginAdmin(String Broker_id, String Broker_password) throws BrokerException {
		
		Broker admin = null;
		
		try (Connection connection = DataBaseUtility.provideConnection()) {

			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Broker WHERE Broker_id = ? AND Broker_password = ?");

			statement.setString(1, Broker_id);
			statement.setString(2, Broker_password);

			ResultSet result = statement.executeQuery();

			if (result.next()) {

				String id = result.getString("Broker_id");
				String password = result.getString("Broker_password");

				admin = new Broker(id, password);
			} else {
				throw new BrokerException("Invalid Admin Id & Password");
				
			}

		} catch (SQLException e) {

			throw new BrokerException(e.getMessage());

		}

		return admin;
	}

	@Override
	public String create_Stock(Stock Stock) {
		// TODO Auto-generated method stub
		
		String Result = null;
		
		try (Connection connection = DataBaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement("INSERT INTO Stock VALUES(?,?,?,?,?,?)");

			statement.setString(1, Stock.getCom_Id());
			statement.setString(2, Stock.getCom_Name());
			statement.setInt(3, Stock.getStock_Quantity());
			statement.setString(4, Stock.getStock_Type());
			statement.setInt(5, Stock.getPer_stock_price());
			statement.setInt(6, Stock.getTotal_stock_price());
			
		
			
			int response = statement.executeUpdate();

			if (response > 0) {
				Result = "Stock Add Sucessfully !";
			}

		} catch (SQLException e) {
			Result = e.getMessage();
		}

		return Result;
		
	}

	@Override
	public String delete_Stock(String com_Id) {
		String Result = null;
		
		try (Connection connection = DataBaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement("Delete FROM Stock WHERE com_Id = ?");

			statement.setString(1, com_Id);

			int response = statement.executeUpdate();

			if (response > 0) {
				Result = "Stock Deleted Sucessfully !";
			}

		} catch (SQLException e) {

			Result = e.getMessage();
		}

		return Result;
	}

	@Override
	public String create_Customer(Customer Customer) {
		// TODO Auto-generated method stub
		String result = null;

		try (Connection connection = DataBaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement("INSERT INTO Customer VALUES(?,?,?,?,?,?)");

			statement.setString(1, Customer.getCustomer_Id());
			statement.setString(2, Customer.getCustomer_Name());
			statement.setString(5, Customer.getCustomer_Password());
			statement.setString(4, Customer.getCustomer_Contact());
			statement.setString(3, Customer.getCustomer_Email());
			statement.setInt(6,Customer.getWallet());
			int response = statement.executeUpdate();

			if (response > 0) {
				result = "Customer Registered Sucessfully !";
			}

		} catch (SQLException e) {
			result = e.getMessage();
		}

		return result;
	}
	
	public String delete_Customer(String Customer_Id) {
		String Result = null;
		
		try (Connection connection = DataBaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement("Delete From Customer where Customer_Id= ?");

			statement.setString(1, Customer_Id);

			int response = statement.executeUpdate();

			if (response > 0) {
				Result = "Customer Deleted Sucessfully !";
			}

		} catch (SQLException e) {

			Result = e.getMessage();
		}

		return Result;
	}



	@Override
	public List<Stock> view_All_Stock() throws StockException {
		
		List<Stock> list_of_Stocks = new ArrayList<Stock>();

		try (Connection connection = DataBaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Stock");

			

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				
				String com_Id = result.getString("com_Id");
				String com_Name = result.getString("com_Name");
				int stock_Quantity = result.getInt("stock_Quantity");
				String stock_Type = result.getString("stock_Type");
				int per_stock_price = result.getInt("per_stock_price");
				int Total_stock_price = result.getInt("Total_stock_price");
				
				
				Stock stock = new Stock (com_Id,com_Name,stock_Quantity,stock_Type,per_stock_price,Total_stock_price);
				
				
				list_of_Stocks.add(stock);
			}

		} catch (SQLException e) {

			throw new StockException(e.getMessage());
		}
		
		if (list_of_Stocks.size() == 0) {
			throw new StockException("No Stock found");
		}

		return list_of_Stocks;
		
	}

	@Override
	public List<Customer> view_All_Customer() throws CustomerException {
		List<Customer> list_of_Customers = new ArrayList<Customer>();

		try (Connection connection = DataBaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Customer");

			

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				
				String Customer_Id = result.getString("Customer_Id");
				String Customer_Name = result.getString("Customer_Name");
				String Customer_Contact = result.getString("Customer_Contact");
				String Customer_Email = result.getString("Customer_Email");
				String Customer_Password = result.getString("Customer_Password");
				int Wallet=result.getInt("Wallet");
				
				
				Customer customer = new Customer (Customer_Id,Customer_Password, Customer_Name,Customer_Contact,Customer_Email,Wallet);
				
				
				list_of_Customers.add(customer);
			}

		} catch (SQLException e) {

			throw new CustomerException(e.getMessage());
		}
		
		if (list_of_Customers.size() == 0) {
			throw new CustomerException("No Customer found");
		}

		return list_of_Customers;
		
	}

	@Override
	public List<Consolidated> view_Consolidated() throws ConsolidatedException {
		List<Consolidated> list_of_Consolidated = new ArrayList<Consolidated>();

		try (Connection connection = DataBaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement(" select stock.com_id,customer_id,consolidated.total,consolidated.sold,consolidated.pending from stock,customer,consolidated;");

			

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				
				String com_Id = result.getString("com_Id");
				String customer_Id = result.getString("customer_Id");
				int total = result.getInt("total");
				int Sold = result.getInt("Sold");
				int Pending = result.getInt("Pending");
			

				Consolidated consolidated = new Consolidated (com_Id,customer_Id,total,Sold,Pending);
				
				list_of_Consolidated.add(consolidated);
			}

		} catch (SQLException e) {

			throw new ConsolidatedException(e.getMessage());
		}
		
		if (list_of_Consolidated.size() == 0) {
			throw new ConsolidatedException("No Record Found");
		}

		return list_of_Consolidated;
	}

	@Override
	public List<Transaction> view_Transaction() throws TransactionException {
		List<Transaction> list_of_Transaction = new ArrayList<Transaction>();

		try (Connection connection = DataBaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Transaction");

			

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				
				String TId = result.getString("TId");
				
				String com_Id = result.getString("com_Id");
				
				String Customer_Id = result.getString("Customer_Id");
				
				String Buy_Date = result.getString("Buy_Date");
				
				int Buy_Qty = result.getInt("Buy_Qty");
				
				int Buy_Amount =  result.getInt("Buy_Amount");
				
				String sell_Date = result.getString("sell_Date");
				
				int sell_Qty = result.getInt("sell_Qty");
				
				int sell_Amount =  result.getInt("sell_Amount");
				
				Transaction transaction = new Transaction (TId,com_Id,Customer_Id,Buy_Date,
						Buy_Qty,Buy_Amount,sell_Date,sell_Qty,sell_Amount);
				
				
				list_of_Transaction.add(transaction);
			}

		} catch (SQLException e) {

			throw new TransactionException(e.getMessage());
		}
		
		if (list_of_Transaction.size() == 0) {
			throw new TransactionException("No Record Found");
		}

		return list_of_Transaction;
	}

	
}
