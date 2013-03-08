package com.cs174.starrus.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.cs174.starrus.model.Customer;
import com.cs174.starrus.view.CustomerView;
import com.cs174.starrus.view.DepositView;
import com.cs174.starrus.view.IView;

public class DepositSubmitController implements IController{
	private Connection conn = null;
	private Customer c = Customer.getCustomer();
	private DepositView depoV = DepositView.getView();
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
			System.out.println("testing " + depoV.getTxtDeposit().getText());
			if(depoV.getTxtDeposit().getText() == "")
				System.out.println("empty string");
			if(depoV.getTxtDeposit().getText() == null)
				System.out.println("null");
			if(depoV.getTxtDeposit().getText() == " ")
				System.out.println("string with 1 space");
			
			if(depoV.getTxtDeposit().getText() != ""){
				System.out.println(depoV.getTxtDeposit().getText());
				balance = Float.parseFloat(depoV.getTxtDeposit().getText()) + c.getBalance();
				c.setBalance(balance);
				stmt.executeQuery("UPDATE Customer set balance = " + balance + 
									"WHERE username = '" + c.getUsername() + "'");
				cView.getBalancefiled().setText(Float.toString(balance));
				depoV.getTxtDeposit().setText(null);
				depoV.getLblWarning().setText(null);
				depoV.setVisible(false);
			}
			else{
				depoV.getLblWarning().setText("No input or negative #");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in Deposite submit controller");
		} // Specify the SQL Query to run
		
	}

}
