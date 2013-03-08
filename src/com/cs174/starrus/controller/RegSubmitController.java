package com.cs174.starrus.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.cs174.starrus.model.Customer;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.RegView;

public class RegSubmitController implements IController{
	private Connection conn;
	private Customer c = Customer.getCustomer();
	private RegView rV = RegView.getView();
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(String model) {
		conn = DBconnector.getConnection();
		Statement stmt;
		try {
			float balance = 0;
			stmt = conn.createStatement();
			String username = rV.getTxtUsername().getText();
			String cname = rV.getTxtName().getText();
			String password = rV.getTxtPassword().getText();
			String password = rV.getTxtPassword().getText();
			String password = rV.getTxtPassword().getText();
			String password = rV.getTxtPassword().getText();
			String password = rV.getTxtPassword().getText();
			String password = rV.getTxtPassword().getText();
			String password = rV.getTxtPassword().getText();
			
			
			
			
			
			
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
