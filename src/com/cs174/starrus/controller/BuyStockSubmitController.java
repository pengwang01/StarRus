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
	private CustomerView cView 	= CustomerView.getView();
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(String model) {
		// TODO Auto-generated method stub
			Statement stmt;
		try {
			conn 	= DBconnector.getConnection();
			stmt	= conn.createStatement();
		if( DEBUG==true ){
			System.out.println(	"UPDATE MANAGE SET TOTAL_SHARE = TOTAL_SHARE + "	+
								"100 "												+	// TODO: change to field value
								"WHERE MUSERNAME = '" 	+ c.getUsername() + "'"		+
								"AND SYMBOL = '"		+ 
								bsV.getTxtTicker().getText().toUpperCase()			+
								"'"
								);
			}


			stmt.executeQuery(	"UPDATE MANAGE SET TOTAL_SHARE = TOTAL_SHARE + "	+
								"100 "												+	// TODO: change to field value
								"WHERE MUSERNAME = '" 	+ c.getUsername() + "'"		+
								"AND SYMBOL = '"		+ 
								bsV.getTxtTicker().getText().toUpperCase()			+
								"'"
								);
			

			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in BuyStockSubmitController");
		} // Specify the SQL Query to run
		
	}

}
