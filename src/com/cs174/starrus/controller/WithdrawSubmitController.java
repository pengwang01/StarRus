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

			balance = c.getBalance() - Float.parseFloat(wdView.getTxtWithdraw().getText());  
			c.setBalance(balance);
			stmt.executeQuery("UPDATE Customer set balance = " + balance + 
								"WHERE username = '" + c.getUsername() + "'");
			cView.getBalancefiled().setText(Float.toString(balance));
			wdView.getTxtWithdraw().setText(null);
			wdView.setVisible(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Specify the SQL Query to run
		
	}

}
