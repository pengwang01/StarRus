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
			String psd		= rV.getTxtPassword().getText();
			String cname 	= rV.getTxtCName().getText();
			String state	= rV.getTxtState().getText();
			String phone	= rV.getTxtPhone().getText();
			String taxid	= rV.getTxtTaxid().getText();
			String email	= rV.getTxtEmail().getText();
			String clevel	= rV.getTxtClevel().getText();
			String age		= rV.getTxtAge().getText();
		

			String query	= "Insert into CUSTOMER (	username,cname,	phone_num,state,tax_id,psd,email,clevel,age)Values(" 
																	+ 
														username 	+ "," +
														phone		+ "," +
														state		+ "," +
														taxid		+ "," +
														psd			+ "," +
														email		+ "," +
														clevel		+ "," +
														age			+ ")";
								

			
			stmt.executeQuery(query);

			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Specify the SQL Query to run
	}

}
