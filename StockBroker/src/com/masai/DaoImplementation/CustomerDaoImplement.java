package com.masai.DaoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.masai.Bean.Customer;
import com.masai.Bean.Stock;
import com.masai.Dao.CustomerDao;
import com.masai.Exception.CustomerException;
import com.masai.Exception.StockException;
import com.masai.Utility.DataBaseUtility;

public class CustomerDaoImplement implements CustomerDao{

	@Override
	public Customer loginUser(String Customer_Id, String customer_Password ) throws CustomerException {
		

			Customer user = null;

			try (Connection connection = DataBaseUtility.provideConnection()) {

				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM Customer WHERE Customer_Id = ? AND Customer_Password = ?");

				statement.setString(1, Customer_Id);
				statement.setString(2, customer_Password); 

				ResultSet result = statement.executeQuery();

				if (result.next()) {

					String Customer_id = result.getString("Customer_id");
					String Customer_Password = result.getString("Customer_Password"); 
					String Customer_Name = result.getString("Customer_Name");
					String Customer_Contact = result.getString("Customer_Contact");
					String Customer_Email = result.getString("Customer_Email");
				    int Wallet=result.getInt("Wallet");
				    
					user = new Customer(Customer_id,Customer_Password,Customer_Name, Customer_Contact, Customer_Email,Wallet);


				} else {
					throw new CustomerException(" Id & Password");
				}

			} catch (SQLException e) {

				throw new CustomerException(e.getMessage());

			}

			return user;
		
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
public String Buy_Stock(String com_ID){
String Result = null;
		
		try (Connection connection = DataBaseUtility.provideConnection()) {

			PreparedStatement statement = connection.prepareStatement(" update stock,customer set customer.wallet = customer.wallet-total_stock_price,stock.total_stock_price=stock.total_stock_price+customer.wallet where customer.customer_id=1 and stock.com_id=?;");

			statement.setString(1, com_ID);
		
			
			int response = statement.executeUpdate();

			if (response > 0) {
				Result = "Sucessfully Buyed Stock!";
			}

		} catch (SQLException e) {

			Result = e.getMessage();
		}

		return Result;
	}




@Override
public String Sell_Stock(String com_ID) {
	String Result = null;
	
	try (Connection connection = DataBaseUtility.provideConnection()) {

		PreparedStatement statement = connection.prepareStatement(" update stock,customer set customer.wallet = customer.wallet-total_stock_price,stock.total_stock_price=stock.total_stock_price-customer.wallet where customer.customer_id=1 and stock.com_id=?;");

		statement.setString(1, com_ID);
	
		
		int response = statement.executeUpdate();

		if (response > 0) {
			Result = "Sucessfully Buyed Stock!";
		}

	} catch (SQLException e) {

		Result = e.getMessage();
	}

	return Result;
}




@Override
public String Add_Fund(int com_Id) {
	String Result = null;
	
	try (Connection connection = DataBaseUtility.provideConnection()) {

		PreparedStatement statement = connection.prepareStatement(" update customer set wallet=wallet+?;");

		statement.setInt(1, com_Id);
	
		
		int response = statement.executeUpdate();

		if (response > 0) {
			Result = "Sucessfully Buyed Stock!";
		}

	} catch (SQLException e) {

		Result = e.getMessage();
	}

	return Result;
}




@Override
public String WithDraw_Fund(int com_Id) {
	String Result = null;
	
	try (Connection connection = DataBaseUtility.provideConnection()) {

		PreparedStatement statement = connection.prepareStatement(" update customer set wallet=wallet-?;");

		statement.setInt(1, com_Id);
	
		
		int response = statement.executeUpdate();

		if (response > 0) {
			Result = "Sucessfully Sold Stock!";
		}

	} catch (SQLException e) {

		Result = e.getMessage();
	}

	return Result;
}






}
