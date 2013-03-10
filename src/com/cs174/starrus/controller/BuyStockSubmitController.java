package com.cs174.starrus.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cs174.starrus.model.Customer;
import com.cs174.starrus.view.CustomerView;
import com.cs174.starrus.view.BuyStockView;
import com.cs174.starrus.view.IView;

public class BuyStockSubmitController implements IController{
	private boolean DEBUG 		= true;
	private Connection conn 	= null;
	private Customer c 			= Customer.getCustomer();
	private BuyStockView bsV	= BuyStockView.getView();
	private CustomerView cV		= CustomerView.getView();
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(String model) {
		Statement stmt;
		ResultSet rs;
		String ticker;
		int quantity	= 0;
		double balance	= 0;
		double price	= 0;
		double cost		= 0;

		try {
			conn 	= DBconnector.getConnection();
			stmt	= conn.createStatement();

			DateFormat format   = new SimpleDateFormat("dd-MMM-yy");
			Date today          = new Date();
			String dateString   = format.format(today);

			quantity = Integer.parseInt(bsV.getTxtQuantity().getText());
			ticker   = bsV.getTxtTicker().getText().toUpperCase();
	
		// Grabbing balance from customer table to check if the user has enough to buy money to buy the shares
			if (DEBUG == true){
					System.out.println("SELECT BALANCE FROM CUSTOMER WHERE USERNAME = '"	+
											c.getUsername()			+ "'"						
										);
			}
			
			rs = stmt.executeQuery(		"SELECT BALANCE FROM CUSTOMER WHERE USERNAME = '"	+
											c.getUsername()			+ "'"					
									);
			if( rs.next()){
				balance = rs.getFloat("BALANCE");	
			}


		// Grabbing the price of the stock
			if (DEBUG == true){
					System.out.println("SELECT CUR_PRICE FROM STOCK WHERE SYMBOL = '"		+
											ticker					+ "'"					
										);
			}

			rs = stmt.executeQuery(		"SELECT CUR_PRICE FROM STOCK WHERE SYMBOL = '"		+
											ticker					+ "'"					
									);
			if( rs.next()){
				price = rs.getFloat("CUR_PRICE");
			}


		// Checking if client has enough money
			cost = price * quantity;
			if(DEBUG == true){
				System.out.println("COST: " + cost);
			}
			if( balance < cost){
				bsV.getLblWarning().setText("You do not have enough money to complete this transaction");
			}
			else{	
			// Complete and record the transaction
			// Update manage to reflecat the new total shares
				bsV.getLblWarning().setText("");
				if( DEBUG==true ){
					System.out.println(	"UPDATE MANAGE_STOCK SET TOTAL_SHARE = TOTAL_SHARE + "	+
										"100 "												+	
										"WHERE MUSERNAME = '" 	+ c.getUsername() + "'"		+
										"AND SYMBOL = '"		+ 
										bsV.getTxtTicker().getText().toUpperCase()			+
										"'"
										);
				}


					stmt.executeQuery(	"UPDATE MANAGE_STOCK SET TOTAL_SHARE = TOTAL_SHARE + "	+
										"100 "												+
										"WHERE MUSERNAME = '" 	+ c.getUsername() + "'"		+
										"AND SYMBOL = '"		+ 
										bsV.getTxtTicker().getText().toUpperCase()			+
										"'"
										);
				

			// Update Customer's balance
				if(DEBUG == true){
					System.out.println(		"UPDATE CUSTOMER SET BALANCE = BALANCE - "			+
											cost												+
											"WHERE USERNAME = '"								+
											c.getUsername()										+
											"'"
										);
				}
				stmt.executeQuery(			"UPDATE CUSTOMER SET BALANCE = BALANCE - "			+
											cost												+
											"WHERE USERNAME = '"								+
											c.getUsername()										+
											"'"
										);

			// Update balance in customer view
				rs	= stmt.executeQuery( 	"SELECT * FROM CUSTOMER WHERE USERNAME = '"			+
											c.getUsername()										+
											"'"
										);
				if( rs.next() ){
					balance = rs.getFloat("BALANCE");
					System.out.println("Double.toString(balance): " + Double.toString(balance));
					cV.setBalancefield(Double.toString(balance));
				}

			// Record transaction into stock_trans
			// STYPE:	0 for Buy
			// 			1 for Sell
			if( DEBUG == true){
				System.out.println(		"INSERT INTO STOCK_TRANS (TDATE,SUSERNAME, SYMBOL,STYPE,SHARES,PRICE) "	+
										"VALUES( '" + dateString 	+ "','" 	+ c.getUsername()	+ "','"		+
										ticker		+ "',"			+ 0			+ ","				+	
										quantity	+ ","			+ price		+ ")"
							);

			}

			stmt.executeQuery(			"INSERT INTO STOCK_TRANS (TDATE,SUSERNAME, SYMBOL,STYPE,SHARES,PRICE) "	+
										"VALUES( '" + dateString 	+ "','" 	+ c.getUsername()	+ "','"		+
										ticker		+ "',"			+ 0			+ ","				+	
										quantity	+ ","			+ price		+ ")"
							);

			// Record the monetary transaction into money_trans
			// TTYPE: 	1 for deposit
			//			2 for withdrawal
			if( DEBUG == true ){
				System.out.println(		"INSERT INTO MONEY_TRANS (TDATE,TUSERNAME,TTYPE,AMOUNT,BALANCE) VALUES"+
										"('" 		+ dateString	+ "','"		+ c.getUsername()	+ "',"		+
										2			+ ","			+ cost		+ ","				+ balance			+ 
										")"
							);


			}
			stmt.executeQuery(			"INSERT INTO MONEY_TRANS (TDATE,TUSERNAME,TTYPE,AMOUNT,BALANCE) VALUES"+
										"('" 		+ dateString	+ "','"		+ c.getUsername()	+ "',"		+
										2			+ ","			+ cost		+ ","				+ balance			+ 
										")"
							);


		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in BuyStockSubmitController");
		} // Specify the SQL Query to run
		
	}

}
