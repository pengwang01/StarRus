package com.cs174.starrus.controller;
import com.cs174.starrus.view.IView;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteTransactionController implements IController{
	private boolean 	DEBUG		= true;
	private Connection 	conn		= null;
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
	}

	@Override
	public void process(String model) {
		Statement 	stmt;

		try{
			conn 	= DBconnector.getConnection();
			stmt	= conn.createStatement();
			if( DEBUG == true){
				System.out.println("TRUNCATE TABLE MONEY_TRANS");
				System.out.println("TRUNCATE TABLE STOCK_TRANS");

			}
			stmt.executeQuery("TRUNCATE TABLE MONEY_TRANS");
			stmt.executeQuery("TRUNCATE TABLE STOCK_TRANS");

		}catch (SQLException e){
			System.out.println("SQLException in DTERController ");
			e.printStackTrace();
		}
		
	}
}

