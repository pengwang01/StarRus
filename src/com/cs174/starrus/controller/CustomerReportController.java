package com.cs174.starrus.controller;
import com.cs174.starrus.view.CustomerReportView;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.ManagerView;

import java.util.Vector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CustomerReportController implements IController{
	private CustomerReportView crV = CustomerReportView.getView();
	private ManagerView mV = ManagerView.getView();
	private Connection conn = null;
	boolean DEBUG = true;
	private ResultSet	rs			= null;
	private int sid, mid;
	
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
	}
	@Override
	public void process(String model) {
		String username = mV.getTxtInputUsername().getText();
		
		
		try{
			conn			= DBconnector.getConnection();
			Statement stmt	= conn.createStatement();
			
			if(DEBUG == true){
				System.out.println("SELECT * FROM CUTOMER WHERE USERNAME = '"	+
										username			+ "'"
									);

			}
			
			// get final balance and account ids
			rs 		= stmt.executeQuery("SELECT * FROM CUSTOMER WHERE USERNAME = '"	+
										username			+ "'"
										);
			
			crV.getRow_mAccount().clear();
			while( rs.next() ){
				if(DEBUG == true){
					System.out.println("Getting Row");
				}
				Vector<String> newRow = new Vector<String>();
				mid	= rs.getInt("M_ACCOUNT_ID");
				sid = rs.getInt("S_ACCOUNT_ID");
				float balance = rs.getFloat("BALANCE");
				
				newRow.add(Integer.toString(mid));
				newRow.add(Float.toString(balance));
				crV.getRow_mAccount().add(newRow);
			}
			crV.getLblStockaccountidfield().setText(Integer.toString(sid));
			
			if(DEBUG == true){
				System.out.println("SELECT * FROM MANAGE_STOCK WHERE MUSERNAME = '"	+
										username			+ "'"
									);

			}
			rs 		= stmt.executeQuery("SELECT * FROM MANAGE_STOCK WHERE MUSERNAME = '"	+
										username			+ "'"
										);
			
			crV.getRow_sAccount().clear();
			while( rs.next() ){
				if(DEBUG == true){
					System.out.println("Getting Row");
				}
				Vector<String> newRow = new Vector<String>();
				String symbol	= rs.getString("SYMBOL");
				int shares = rs.getInt("TOTAL_SHARE");
				newRow.add(symbol);
				newRow.add(Float.toString(shares));
				crV.getRow_sAccount().add(newRow);
			}
		
			crV.updateView();

		}catch (SQLException e){
			System.out.println("Exception in CustomerReportController");
		}

		crV.setVisible(true);
	}
		
}

