package com.cs174.starrus.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.cs174.starrus.model.Customer;
import com.cs174.starrus.view.CustomerView;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.WithdrawView;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class WithdrawSubmitController implements IController{
	private boolean DEBUG = true;
	private Connection conn = null;
	private Customer c = Customer.getCustomer();
	private WithdrawView wdView = WithdrawView.getView();
	private CustomerView cView = CustomerView.getView();
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
			float balance = 0;
			stmt = conn.createStatement();
			
			if(c.getBalance() - Float.parseFloat(wdView.getTxtWithdraw().getText()) < 0)
				wdView.getLblWarning().setText("not enough money");
			
			balance = c.getBalance() - Float.parseFloat(wdView.getTxtWithdraw().getText());  
			c.setBalance(balance);
				
			// Insert into transacation table
			DateFormat format 	= new SimpleDateFormat("dd-MMM-yy");
			Date today 			= new Date();
			String dateString	= format.format(today);

			// FOR DEBUGGING PURPOSES
			if( DEBUG == true ){
				System.out.println( "Username: "+ c.getUsername()   +" \n" +
									"Date: "    + dateString        +" \n" +
									"Balance: " + c.getBalance()
									);
				System.out.println("INSERT INTO MONEY_TRANS (TDATE,TUSERNAME,TTYPE,AMOUNT) VALUES ("
									+ "'"	+ dateString        + "'"	+ ","
									+ "'" 	+ c.getUsername()   + "'"	+ ","
									+ 2                 + ","
									+ c.getBalance()    + ")"
									);
			}

			String mtStr		= "INSERT INTO MONEY_TRANS (TDATE,TUSERNAME,TTYPE,AMOUNT) VALUES (" 
								+ "'"	+ dateString        + "'"	+ ","
								+ "'" 	+ c.getUsername()   + "'"	+ ","
								+ 2					+ "," 
								+ c.getBalance()	+ ")";
									
			stmt.executeQuery(mtStr);
					
			stmt.executeQuery("UPDATE Customer set balance = " 	+ balance + 
								"WHERE username = '" 			+ c.getUsername() + "'");

			cView.getBalancefiled().setText(Float.toString(balance));
			wdView.getTxtWithdraw().setText(null);
			wdView.setVisible(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Specify the SQL Query to run
		
	}

}
