package com.cs174.starrus.controller;

import java.sql.Connection;
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
	private CustomerView cView 	= CustomerView.getView();
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(String model) {
		// TODO Auto-generated method stub
		conn = DBconnector.getConnection();
		Statement stmt;
		try {
			stmt	= conn.createStatement();
			
			//If the person owns this stock:

			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in SellStockSubmitController");
		} // Specify the SQL Query to run
		
	}

}