package com.masai.Run;


import java.util.List;
import java.util.Scanner;

import com.masai.Bean.Broker;

import com.masai.Bean.Consolidated;
import com.masai.Bean.Customer;

import com.masai.Bean.Stock;
import com.masai.Bean.Transaction;
import com.masai.Dao.BrokerDao;
import com.masai.Dao.CustomerDao;
import com.masai.DaoImplementation.BrokerDaoImplement;
import com.masai.DaoImplementation.CustomerDaoImplement;
import com.masai.Exception.BrokerException;

import com.masai.Exception.ConsolidatedException;
import com.masai.Exception.CustomerException;
import com.masai.Exception.StockException;
import com.masai.Exception.TransactionException;



public class Run {

	

	@SuppressWarnings("resource")
	public static void main(String[] args) throws StockException {
		
		BrokerDao broker_dao = new BrokerDaoImplement() ;

		CustomerDao customer_dao = new CustomerDaoImplement();

	

		boolean run = true;

		Scanner scanner = new Scanner(System.in);

		while (run) {

			System.out.println();

			System.out.println("Please Enter Your Choice");

			System.out.println("");

			System.out.println("1. Admin Login");
			System.out.println("2. User Login");
			System.out.println("3. Exit");

			int choice = scanner.nextInt();
	

			switch (choice) {
			case 1:

				System.out.println("");

				System.out.println("Broker Login");

				System.out.println("");

				scanner.nextLine();

				System.out.println("Enter Your Username");
				String broker_username = scanner.nextLine();

				System.out.println("Enter Your Password");
				String broker_password = scanner.nextLine();

				try {
					Broker broker = broker_dao.loginAdmin( broker_username, broker_password) ;
					
					
					
					if (broker != null) {

						Boolean broker_run = true;

						while (broker_run) {

							System.out.println("");

							System.out.println("Welcome to Admin Dashboard");

							System.out.println("");

							System.out.println("Please Enter Your Choice");

							System.out.println("");

							System.out.println("1. CUSTOMER");
							System.out.println("2. STOCKS");
							System.out.println("3. VIEW CONSOLIDATED STATEMENT");							
							System.out.println("4. EXIT ADMIN DASHBOARD ");
							System.out.println("5. EXIT APPLICATION ");
							

							int broker_choice = scanner.nextInt();
							switch (broker_choice) {
							case 1:

								Boolean Customer_run = true;

								while (Customer_run) {

									System.out.println("");

									System.out.println("Welcome to Customer Dashboard");

									System.out.println("");

									System.out.println("Please Enter Your Choice");

									System.out.println("");

									System.out.println("1. Add New Customer");
									System.out.println("2. Delete Customer");
									System.out.println("3. View All Customers");
									System.out.println("4. Exit Customer Dashboard");
									System.out.println("5. Exit Admin Dashboard");
									System.out.println("6. Exit Application");

									int customer_choice = scanner.nextInt();

									switch (customer_choice) {

									case 1:
										System.out.println("");

										System.out.println("Please Enter Customer Details");

										System.out.println("");

										System.out.println("Please Enter Customer_Id :");
										String Customer_Id = scanner.next();

										System.out.println("Please Enter Customer_Name :");
										String Customer_Name = scanner.next();
										
										System.out.println("Please Enter Customer_Password :");
										String Customer_Password = scanner.next();
										
										System.out.println("Please Enter Customer_Contact :");
										String Customer_Contact = scanner.next();
										
							
										System.out.println("Please Enter Customer_Email :");
										String Customer_Email = scanner.next();

										System.out.println("Please Enter wallet :");
										int wallet = scanner.nextInt();

										
										Customer customer = new Customer(Customer_Id,Customer_Password, Customer_Name, Customer_Contact, Customer_Email,wallet);

										String result = broker_dao.create_Customer(customer);

										System.out.println(result);

										System.out.println();

										break;
									case 2:

										System.out.println("");

										System.out.println("Please Enter Customer Details You Wish To Delete");

										System.out.println("");

										System.out.println("Please Enter Customer_ID :");
										String Customer_ID = scanner.next();

										String result_1 = broker_dao.delete_Customer(Customer_ID);
   
										System.out.println(result_1);


										break;
									case 3:            

										System.out.println("");

										System.out.println("Customer Details");

										System.out.println("");

										;

										try {
											List<Customer> list_of_buses = broker_dao.view_All_Customer();

											list_of_buses.forEach(c -> {

												System.out.println("Customer ID :" +c.getCustomer_Id());
												System.out.println("Customer Name :" + c.getCustomer_Name());
												System.out.println("Customer Contact :" +c.getCustomer_Contact());
												System.out.println("Customer Email :" + c.getCustomer_Email());
												System.out.println("Customer Password:" +c.getCustomer_Password());
												System.out.println("Customer Wallet :" + c.getWallet());

												System.out.println();
											});
										} catch (CustomerException e) {

											System.out.println(e.getMessage());
										}

										break;
									case 4:

										Customer_run = false;
										break;
									case 5:
										Customer_run = false;
										broker_run = false;
										break;
									case 6:
										System.out.println("Thank You For Using The Appilcation ! ");
										Customer_run = false;
										broker_run = false;
										run = false;
										break;
									default:
										System.out.println("Please Enter A Valid Choice !");

									}
								}

								break;
							case 2:
								
								Boolean Stock_run = true;

								while (Stock_run) {

									System.out.println("");

									System.out.println("Welcome to Stock Dashboard");

									System.out.println("");

									System.out.println("Please Enter Your Choice");

									System.out.println("");

									System.out.println("1. Add New Stock");
									System.out.println("2. Delete Stock");
									System.out.println("3. View All Stocks");
									System.out.println("4. Exit Stock Dashboard");
									System.out.println("5. Exit Admin Dashboard");
									System.out.println("6. Exit Application");

									int customer_choice = scanner.nextInt();

									switch (customer_choice) {

									case 1:
										System.out.println("");

										System.out.println("Please Enter Stock Details");

										System.out.println("");

										System.out.println("Please Enter com_Id :");
										String com_Id = scanner.next();

										System.out.println("Please Enter com_Name :");
										String com_Name = scanner.next();

										System.out.println("Please Enter stock_Quantity :");
										int stock_Quantity = scanner.nextInt();
										
										System.out.println("Please Enter stock_Type :");
										String stock_Type = scanner.next();
										
										System.out.println("Please Enter per_stock_price :");
										int per_stock_price = scanner.nextInt();

										System.out.println("Please Enter Total_stock_price :");
										int Total_stock_price = scanner.nextInt();

						  				Stock stock = new Stock(com_Id, com_Name, stock_Quantity, stock_Type,per_stock_price,Total_stock_price);

										String result = broker_dao.create_Stock(stock);

										System.out.println(result);

										System.out.println();

										break;
									case 2:

										System.out.println("");

										System.out.println("Please Enter Stock Details You Wish To Delete");

										System.out.println("");

										System.out.println("Please Enter com_Id :");
										String Customer_ID = scanner.next();

										String result_1 = broker_dao.delete_Stock(Customer_ID);
   
										System.out.println(result_1);

										System.out.println();

										break;
									case 3:            

										System.out.println("");

										System.out.println("Stock Details");

										System.out.println("");

										;

										try {
											List<Stock> list_of_stock = broker_dao.view_All_Stock();

											list_of_stock.forEach(s -> {

												System.out.println("company ID :" +s.getCom_Id());
												System.out.println("company Name :" + s.getCom_Name());
												System.out.println("company Contact :" +s.getStock_Quantity());
												System.out.println("company Email :" + s.getStock_Type());
												System.out.println("company Password:" +s.getPer_stock_price());
												System.out.println("company Wallet :" + s.getTotal_stock_price());

												System.out.println();
											});
										} catch (StockException e) {

											System.out.println(e.getMessage());
										}

										break;
									case 4:

										Stock_run = false;
										break;
									case 5:
										Stock_run = false;
										broker_run = false;
										break;
									case 6:
										System.out.println("Thank You For Using The Appilcation ! ");
										Stock_run = false;
										broker_run = false;
										run = false;
										break;
									default:
										System.out.println("Please Enter A Valid Choice !");

									}
								}
								
								
						
								break;
//---------------------------------------------------------------------------------------------------------------------------								
							case 3:
								System.out.println("");

								System.out.println("Consolidated Report");

								System.out.println("");

								try {

									List<Consolidated> consolidated = broker_dao.view_Consolidated();

									consolidated.forEach(t -> {

										System.out.println("com_Id :" + t.getCom_id());
										System.out.println("com_Name :" + t.getCustomer_id());
										System.out.println("Total Stock :" + t.getTotal());
										System.out.println("Sold stocks:" + t.getSold());
										System.out.println("Pending stocks:" + t.getPending());
										
										System.out.println();
									});
								} catch (ConsolidatedException e) {

									System.out.println(e.getMessage());
								}

								break;

							case 4:
								System.out.println("");

								System.out.println("Transaction Report");

								System.out.println("");

								try {

									List<Transaction> transaction = broker_dao.view_Transaction();
										
									transaction.forEach(u -> {
									

										System.out.println("TId :" + Transaction.getTId());
										System.out.println("com_Id :" + Transaction.getCom_Id());
										System.out.println("Customer_Id :" + Transaction.getCustomer_Id());
										System.out.println("Buy_Date :" + Transaction.getBuy_Date());
										System.out.println("Buy_Qty  :" + Transaction.getBuy_Qty());
										System.out.println("Buy_Amount :" + Transaction.getSell_Amount());
										System.out.println("sell_Date :" + Transaction.getSell_Date());
										System.out.println("sell_Qty  :" + Transaction.getSell_Qty());
										System.out.println("sell_Amount :" + Transaction.getSell_Amount());
										
									});
								} catch (TransactionException e) {

									System.out.println(e.getMessage());
								}

								break;
								
							case 5:
								broker_run = false;
								break;
							case 6:
								System.out.println("Thank You For Using The Appilcation ! ");
								broker_run = false;
								run = false;
								break;
							default:
								System.out.println("Please Enter A Valid Choice !");

							}
						}
					}

				} catch (BrokerException | CustomerException | StockException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 2:

				System.out.println("");

				System.out.println("Customer Login");

				System.out.println("");

				scanner.nextLine();

				System.out.println("Enter Your Customer_ID");
				String customer_username = scanner.nextLine();

				System.out.println("Enter Your Customer_Password");
				String customer_password = scanner.nextLine();

				try {
					Customer customer = customer_dao.loginUser(customer_username, customer_password);

					if (customer != null) {

						@SuppressWarnings("unused")
						String Customer_id = customer.getCustomer_Id();

						Boolean user_run = true;

						while (user_run) {

							System.out.println("");

							System.out.println("Welcome to Customer Dashboard");

							System.out.println("");

							System.out.println("Please Enter Your Choice");

							System.out.println("");

							System.out.println("1. View All Stock");
							System.out.println("2. Buy Stock");
							System.out.println("3. Sell Stock");
							System.out.println("4. Add Fund");
							System.out.println("5. Withdraw Fund");
							System.out.println("6. VIEW All TRANSACTION HISTORY ");
							System.out.println("7. EXIT Customer DASHBOARD ");
							System.out.println("8. EXIT APPLICATION ");
							
							
							int Customer_choice = scanner.nextInt();

							switch (Customer_choice) {

							case 1:
								System.out.println("");

								System.out.println("Stock Details");

								System.out.println("");

								;

								try {
									List<Stock> list_of_stock = broker_dao.view_All_Stock();

									list_of_stock.forEach(s -> {

										System.out.println("Customer ID :" +s.getCom_Id());
										System.out.println("Customer Name :" + s.getCom_Name());
										System.out.println("Customer Contact :" +s.getStock_Quantity());
										System.out.println("Customer Email :" + s.getStock_Type());
										System.out.println("Customer Password:" +s.getPer_stock_price());
										System.out.println("Customer Wallet :" + s.getTotal_stock_price());

										System.out.println();
									});
								} catch (StockException e) {

									System.out.println(e.getMessage());
								}

								break;
							case 2:
								System.out.println("");

								System.out.println("Please Enter Company Details You Wish To Buy");

								System.out.println("");

								System.out.println("Please Enter Com_ID :");
								String Com_ID = scanner.next();

								String result_1 = customer_dao.Buy_Stock(Com_ID);

								System.out.println(result_1);
								break;
								
							case 3:
								
								System.out.println("");

								System.out.println("Please Enter Company Details You Wish To Sell");

								System.out.println("");

								System.out.println("Please Enter Com_ID :");
								String Com_Id = scanner.next();

								String result_3 = customer_dao.Sell_Stock(Com_Id);

								System.out.println(result_3);
								
								break;
								
							case 4:
								System.out.println("");

								System.out.println("Please Add Fund");

								System.out.println("");

								System.out.println("Please Enter Amount :");
								int Amount = scanner.nextInt();

								String Result= customer_dao.Add_Fund(Amount);

								System.out.println(Result);
								
								break;
								
							case 5:
								System.out.println("");

								System.out.println("");

								System.out.println("");

								System.out.println("Please Enter Amount to Widtdraw");
								int Amount1 = scanner.nextInt();

								String Results= customer_dao.WithDraw_Fund(Amount1);

								System.out.println(Results);
								
								break;
							case 6:
								
								
								break;

							case 7:
							
								user_run = false;
								break;

							case 8:
								user_run = false;
								run = false;
								break;
							}

						}

					}

				} catch (CustomerException   e) {
					System.out.println(e.getMessage());
				}

				break;
		
			case 3:
				System.out.println("Thank You For Using The Appilcation ! ");
				run = false;
				break;
			default:
				System.out.println("Please Enter A Valid Choice !");
			}
		}

	}

}