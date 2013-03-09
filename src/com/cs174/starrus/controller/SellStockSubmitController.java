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
import com.cs174.starrus.view.SellStockView;
import com.cs174.starrus.view.IView;

public class SellStockSubmitController implements IController{
	private boolean DEBUG 		= true;
	private Connection conn 	= null;
	private Customer c 			= Customer.getCustomer();
	private SellStockView ssV	= SellStockView.getView();

	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(String model) {
		int numStocksAvailable = 0;
		Statement stmt;

		if( DEBUG == true){
			System.out.println("In SellStockSubmitController.process()");
		}

		// TODO Auto-generated method stub
		try {
			conn	= DBconnector.getConnection();
			stmt	= conn.createStatement();

			// Query is case sensitive
			if ( DEBUG == true ){
	            System.out.println( "SELECT * FROM MANAGE WHERE MUSERNAME = "	+ 
				                   	"'" + c.getUsername() + "'"					+
									" AND SYMBOL = "							+
									"'" 										+ 
									ssV.getTxtTicker().getText().toUpperCase()	+
									"'"			
									);
			}
			
			// Check how many shares this person has of the stock
			ResultSet rs = stmt.executeQuery(	"SELECT * FROM MANAGE WHERE MUSERNAME = "	+
			                                    "'" + c.getUsername() + "'"					+   
												" AND SYMBOL = "							+
												"'" 										+ 
												ssV.getTxtTicker().getText().toUpperCase()	+
												"'"			
											);    
			

			if( rs.next()){
				numStocksAvailable	= rs.getInt("TOTAL_SHARE");
				if( DEBUG == true){
					System.out.println("NumStocks Available:\t" + numStocksAvailable);
				}
			}

			if( numStocksAvailable < 100){// TODO: replace 100 with the value in text field
				

			}

		}	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in SellStockSubmitController");
		} // Specify the SQL Query to run
		
	}

}
