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
			String cname = rV.getTxtCName().getText();
			String phone = rV.getTxtPhone().getText();
			String state = rV.getTxtState().getText();
			String taxid = rV.getTxtTaxid().getText();
			String psw = rV.getTxtPassword().getText();
			String email = rV.getTxtEmail().getText();
			String age = rV.getTxtAge().getText();
			
			String query = "insert into customer(username, cname, phone_num, state, tax_id, psd, email, clevel, age) values ("
				+ "'" + username + "' ,"
				+ "'" + cname + "',"
				+ "'" + phone + "',"
				+ "'" + state + "'," 
				+ taxid + ","
				+ "'" + psw + "',"
				+ "'" + email + "',"
				+ 2 + ","
				+ age + ")";	
			stmt.executeQuery(query);
			rV.getTxtAge().setText(null);
			rV.getTxtEmail().setText(null);
			rV.getTxtCName().setText(null);
			rV.getTxtPassword().setText(null);
			rV.getTxtPhone().setText(null);
			rV.getTxtState().setText(null);
			rV.getTxtTaxid().setText(null);
			rV.getTxtUsername().setText(null);
			rV.dispose();
		} catch (SQLException e) {
			rV.getLblWarning().setText("username, password, taxID empty");
			rV.getTxtAge().setText(null);
			rV.getTxtEmail().setText(null);
			rV.getTxtCName().setText(null);
			rV.getTxtPassword().setText(null);
			rV.getTxtPhone().setText(null);
			rV.getTxtState().setText(null);
			rV.getTxtTaxid().setText(null);
			rV.getTxtUsername().setText(null);
		} // Specify the SQL Query to run
	}

}
