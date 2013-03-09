package com.cs174.starrus.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.cs174.starrus.model.Customer;
import com.cs174.starrus.view.CustomerView;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.WithdrawView;

public class WithdrawSubmitController implements IController{
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
			
			// checking for if enough money to withdraw
			if(c.getBalance() - Float.parseFloat(wdView.getTxtWithdraw().getText()) < 0){
				wdView.getLblWarning().setText("not enough money");
				wdView.getTxtWithdraw().setText(null);
			}
			else{
				balance = c.getBalance() - Float.parseFloat(wdView.getTxtWithdraw().getText());  
				c.setBalance(balance);
				
				// execute query for withdrawing money from balance
				stmt.executeQuery("UPDATE Customer set balance = " + balance + 
									"WHERE username = '" + c.getUsername() + "'");
				cView.getBalancefiled().setText(Float.toString(balance));
				wdView.getTxtWithdraw().setText(null);
				wdView.setVisible(false);
				
				// execute query for creating money transaction row in the transaction table
				// add code here
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Specify the SQL Query to run
		
	}

}
