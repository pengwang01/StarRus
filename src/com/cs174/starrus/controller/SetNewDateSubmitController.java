package com.cs174.starrus.controller;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.model.SysDate;
import com.cs174.starrus.view.SetNewDateView;

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



public class SetNewDateSubmitController implements IController{
	private boolean 	DEBUG		= true;
	private Connection 	conn		= null;
	private SysDate		sD			= SysDate.getSysDate();
	private SetNewDateView	sndV	= SetNewDateView.getView();
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
	}
	@Override
	public void process(String model) {
		SetNewDateView snpV	= SetNewDateView.getView();
		Statement 	stmt;
		ResultSet	rs;

		try{
			conn 	= DBconnector.getConnection();
			stmt	= conn.createStatement();
			
			if( DEBUG == true){
				System.out.println("SETTING DATE TO: " + sndV.getTxtDate().getText());
			}
			
			SysDate.setSysDate(new SysDate( sndV.getTxtDate().getText()));
			

									
		}catch (SQLException e){
			System.out.println("SQLException in SetPriceController");
			e.printStackTrace();
		}
	}
}

