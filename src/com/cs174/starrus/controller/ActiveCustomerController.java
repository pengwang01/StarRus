package com.cs174.starrus.controller;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.ManagerView;
import com.cs174.starrus.model.Customer;

import java.util.Vector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ActiveCustomerController implements IController{
	private boolean 	DEBUG 		= true;
	private Connection 	conn		= null;
	private ManagerView mV	= ManagerView.getView();
	private ResultSet	rs			= null;
		


	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
	}
	@Override
	public void process(String model) {

		try{
			conn			= DBconnector.getConnection();
			Statement stmt	= conn.createStatement();
			
			if(DEBUG == true){
				System.out.println("SELECT SUSERNAME FROM ( +" +
						"( SELECT SUSERNAME, SUM(SHARES) AS MYSUM +" +
						"FROM STOCK_TRANS +" +
						"GROUP BY SUSERNAME ) +" +
						"WHERE MYSUM >= 1000" );

			}
			rs 		= stmt.executeQuery("SELECT SUSERNAME FROM ( +" +
						"( SELECT SUSERNAME, SUM(SHARES) AS MYSUM +" +
						"FROM STOCK_TRANS +" +
						"GROUP BY SUSERNAME ) +" +
						"WHERE MYSUM >= 1000" );
			
			
			mV.getRow_active().clear();
			while( rs.next() ){
				if(DEBUG == true){
					System.out.println("Getting Row");
				}
				Vector<String> newRow = new Vector<String>();
				String username	= rs.getString("SUSERNAME");
				newRow.add(username);
				mV.getRow_active().add(newRow);
			}
			Customer customer = Customer.getCustomer();
			mV.setView(customer);

		}catch (SQLException e){
			System.out.println("Exception in MTransactionController");
		}

	}
}

