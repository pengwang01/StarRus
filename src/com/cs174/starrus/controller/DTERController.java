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



public class DTERController implements IController{
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
			DateFormat format   = new SimpleDateFormat("dd-MMM-yy");
			Date today          = new Date();
			String dateString   = format.format(today);



		}catch (SQLException e){
			System.out.println("SQLException in DTERController ");
			e.printStackTrace();
		}
		
	}
}

