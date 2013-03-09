package com.cs174.starrus.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Integer;

import com.cs174.starrus.model.Customer;
import com.cs174.starrus.view.CustomerView;
import com.cs174.starrus.view.SellStockView;
import com.cs174.starrus.view.IView;

public class SellStockSubmitController implements IController{
	private boolean DEBUG 		= true;
	private Connection conn 	= null;
	private Customer c 			= Customer.getCustomer();
	private SellStockView ssV	= SellStockView.getView();
	private CustomerView  cV	= CustomerView.getView();

	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(String model) {
		int numStocksAvailable 	= 0;
		double currentPrice		= 0;
		Statement stmt;

		if( DEBUG == true){
			System.out.println("In SellStockSubmitController.process()");
		}

		// TODO Auto-generated method stub
		try {
			conn	= DBconnector.getConnection();
			stmt	= conn.createStatement();

			String ticker	= ssV.getTxtTicker().getText().toUpperCase();
			DateFormat format   = new SimpleDateFormat("dd-MMM-yy");
			Date today          = new Date();
			String dateString   = format.format(today);


			// Query is case sensitive
			if ( DEBUG == true ){
	            System.out.println( "SELECT * FROM MANAGE WHERE MUSERNAME = "	+ 
				                   	"'" + c.getUsername() + "'"					+
									" AND SYMBOL = "							+
									"'"	+ ticker	+ "'"			
									);
			}
			
			// Check how many shares this person has of the stock
			ResultSet rs = stmt.executeQuery(	"SELECT * FROM MANAGE WHERE MUSERNAME = "	+
			                                    "'" + c.getUsername() + "'"					+   
												" AND SYMBOL = "							+
												"'"	+ ticker	+	"'"			
											);    
			

			if( rs.next()){
				numStocksAvailable	= rs.getInt("TOTAL_SHARE");
				if( DEBUG == true){
					System.out.println("NumStocks Available:\t" + numStocksAvailable);
				}
			}

			// While the client is trying to sell more shares than he posses, 
			// The system should loop waiting until he puts in a valid number
			int numStocksToSell	= Integer.parseInt(ssV.getTxtQuantityField().getText());
			if( numStocksAvailable < numStocksToSell){
				ssV.getLblWarning().setText("You do not have enough shares");
				
			}
			else{
				ssV.getLblWarning().setText("");
				// Update manage to reflect the change in stock
					stmt.executeQuery( 	"UPDATE MANAGE SET TOTAL_SHARE = TOTAL_SHARE - '"	+
										numStocksToSell	+ "' "								+
										"WHERE MUSERNAME = '"	+ c.getUsername()	+ "'"	+
										"AND SYMBOL = '"		+ ticker			+ "'"	
										);

				// Pull price from stock table
					rs	= stmt.executeQuery( "SELECT CUR_PRICE FROM STOCK WHERE SYMBOl ='"	+
												ticker	+ "'"
											);
					if(rs.next()){
						currentPrice = rs.getFloat("CUR_PRICE");
					}

				// Update stock_trans table to capture change in stock
				// STYPE: 	0 for buy
				//			1 for sell
					if(DEBUG == true){
					System.out.println("INSERT INTO STOCK_TRANS (TDATE,SUSERNAME,SYMBOL,STYPE,SHARES,PRICE) "	+
										"VALUES( '"	+ dateString	+ "','"		+ c.getUsername()	+ "','"		+ 
										ticker		+ "'," 			+  1		+ ","				+ 
										numStocksToSell				+ ","		+ currentPrice		+ ")" 
										);

					}
					stmt.executeQuery(	"INSERT INTO STOCK_TRANS (TDATE,SUSERNAME,SYMBOL,STYPE,SHARES,PRICE) "	+
										"VALUES( '"	+ dateString	+ "','"		+ c.getUsername()	+ "','"		+ 
										ticker		+ "'," 			+  1		+ ","				+ 
										numStocksToSell				+ ","		+ currentPrice		+ ")" 
									);
				
				// Update users balance to reflect the sales
					if(DEBUG == true){
						System.out.println("UPDATE CUSTOMER SET BALANCE = BALANCE + "	+
											currentPrice*numStocksToSell				+
											"WHERE USERNAME = '"						+
											c.getUsername()								+
											"'"
											);
					}
					stmt.executeQuery( "UPDATE CUSTOMER SET BALANCE = BALANCE + "	+
										currentPrice*numStocksToSell				+
										"WHERE USERNAME = '"						+
										c.getUsername()								+
										"'"
									);


				// Update balance in customer view
					    rs = stmt.executeQuery (	"SELECT * FROM customer where " +
															"username = '" + c.getUsername() +"'");
						if( rs.next()){
								cV.setBalancefield(Float.toString(rs.getFloat("BALANCE")));
						}


			}			

		}	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in SellStockSubmitController");
		} // Specify the SQL Query to run
		
	}

}
