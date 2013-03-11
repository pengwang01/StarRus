package com.cs174.starrus.controller;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.ManagerView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.Vector;



public class DeleteTransacation implements IController{
	private boolean 	DEBUG		= true;
	private Connection 	conn		= null;
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
	}

	@Override
	public void process(String model) {
		ManagerView mV 			= ManagerView.getView();
		Statement 	stmt;
		ResultSet	rs;


		try{
			conn 	= DBconnector.getConnection();
			stmt	= conn.createStatement();
		
			stmt.executeQuery("TRUNCATE TABLE MONEY_TRANS");
			stmt.executeQuery("TRUNCATE TABLE STOCK_TRANS");

		}catch (SQLException e){
			System.out.println("SQLException in DTERController ");
			e.printStackTrace();
		}
		
	}
}

