package com.cs174.starrus.controller;

import java.sql.Connection;
import java.sql.ResultSet;
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
		conn 		= DBconnector.getConnection();
		Statement 	stmt;
		ResultSet	rs;
		try {
			float balance	= 0;
			float toWithdraw= 0;
			float fBalance	= 0;
			stmt = conn.createStatement();

			toWithdraw = Float.parseFloat(wdView.getTxtWithdraw().getText());
			
			if(c.getBalance() - Float.parseFloat(wdView.getTxtWithdraw().getText()) < 0){
				wdView.getLblWarning().setText("not enough money");
				throw new SQLException();
			}
			
			balance = c.getBalance() - Float.parseFloat(wdView.getTxtWithdraw().getText());  
			c.setBalance(balance);
				
			// Insert into transacation table
				DateFormat format 	= new SimpleDateFormat("dd-MMM-yy");
				Date today 			= new Date();
				String dateString	= format.format(today);

				stmt.executeQuery("UPDATE Customer set balance = " 	+ balance + 
									"WHERE username = '" 			+ c.getUsername() + "'");

			//	Pulling new balance from 
				rs = stmt.executeQuery(	"SELECT BALANCE FROM CUSTOMER WHERE USERNAME = '"	+
										c.getUsername()	+ "'"
										);
				if(rs.next()){
					fBalance = rs.getFloat("BALANCE");	
				}

			// FOR DEBUGGING PURPOSES
			// TTYPE: 	1 for deposit
			//			2 for withdrawals
				if( DEBUG == true ){
					System.out.println( "Username: "+ c.getUsername()   +" \n" +
										"Date: "    + dateString        +" \n" +
										"Balance: " + c.getBalance()
										);
					System.out.println("INSERT INTO MONEY_TRANS (TDATE,TUSERNAME,TTYPE,AMOUNT) VALUES ("
										+ "'"	+ dateString        + "'"	+ ","
										+ "'" 	+ c.getUsername()   + "'"	+ ","
										+ 2                 + ","
										+ toWithdraw		+ ","
										+ fBalance			+ ")"
										);
				}

				stmt.executeQuery( "INSERT INTO MONEY_TRANS (TDATE,TUSERNAME,TTYPE,AMOUNT,BALANCE) VALUES (" 
									+ "'"	+ dateString        + "',"	
									+"'" 	+ c.getUsername()   + "',"
									+ 2							+ "," 
									+ toWithdraw				+ ","
									+ fBalance					+ ")"
								);

				cView.getBalancefield().setText(Float.toString(balance));
				wdView.getTxtWithdraw().setText(null);
				wdView.setVisible(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Specify the SQL Query to run
		
	}

}
