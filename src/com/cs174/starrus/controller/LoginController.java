package com.cs174.starrus.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cs174.starrus.model.Customer;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.LoginView;

public class LoginController implements IController{
	private Connection conn = null;
	private LoginView loginView = LoginView.getView();
	
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(String model) {
		String username = loginView.getTxtEnterUsername().getText();
		String password = loginView.getTxtEnterPassword().getText();
		System.out.println("username is: " + username + " password is: " + password);

		try{
			conn = DBconnector.getConnection();
			Statement stmt = conn.createStatement(); // Specify the SQL Query to run
			ResultSet rs = stmt.executeQuery ("SELECT * FROM customer where " + 
											"username = '" + username + "' AND " +
											"psd = '" + password + "'");
			if(rs.next()){
				Customer customer = Customer.getCustomer();
				customer.setUsername(username);
				customer.setPsd(password);
				customer.setCname(rs.getString("cname"));
				customer.setPhone_num(rs.getString("phone_num"));
				customer.setState(rs.getString("state"));
				customer.setTax_id(rs.getInt("tax_id"));
				customer.setEmail(rs.getString("email"));
				customer.setM_account_id(rs.getInt("m_account_id"));
				customer.setS_account_id(rs.getInt("s_account_id"));
				customer.setClevel(rs.getInt("clevel"));
				customer.setAge(rs.getInt("age"));
				customer.setBalance(rs.getFloat("balance"));
				if(customer.getClevel() == 1){
					view.loadManagerView(customer);	// load customer view when login is checked
				}
				else if(customer.getClevel() == 2){
					view.loadCustomerView(customer);	// load customer view when login is checked
				}
			}
			else{
				loginView.getLblMismatch().setText("Username and password do not match, please try again.");
			}
			
		} catch (SQLException e){
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("SQL exception happends");
		}
	}
}
