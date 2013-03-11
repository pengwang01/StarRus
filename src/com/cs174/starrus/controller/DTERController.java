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
/*
		Vector<String>	userList	= new Vector<String>();
		Vector<double>	sTransProf	= new Vector<double>();
		Vector<double>	intProf		= new Vector<double>();
		Vector<double>	sGrowProf	= new Vector<double>();

		try{
			conn 	= DBconnector.getConnection();
			stmt	= conn.createStatement();
			DateFormat format   = new SimpleDateFormat("dd-MMM-yy");
			Date today          = new Date();
			String dateString   = format.format(today);
		
		// Calculate stock transaction profit
			if( DEBUG == true ){
				System.out.println(	"SELECT SUSERNAME,SUM(PRICE)AS PRICE "	+
									"FROM STOCK_TRANS "						+
									"GROUP BY SUSERNAME "					+
									"ORDER BY SUSERNAME ASC"
								);
			}
			rs 		= stmt.executeQuery("SELECT SUSERNAME,SUM(PRICE)AS PRICE "	+
										"FROM STOCK_TRANS "						+
										"GROUP BY SUSERNAME "					+
										"ORDER BY SUSERNAME ASC"
										);

			while( rs.next() ){
				userList.add(rs.getString("SUSERNAME"));
				sTransProf.addd(rs.getString("PRICE"));
			}
		// Calculate interest profit
			if( DEBUG ==  true){
				System.out.println(	"SELECT * FROM MONEY_TRANS "			+
									"WHERE TTYPE = 3 "						+
									"ORDER BY TUSERNAME ASC"
									);
			}
			rs 		= stmt.executeQuery("SELECT * FROM MONEY_TRANS "			+
										"WHERE TTYPE = 3 "						+
										"ORDER BY TUSERNAME ASC"
										);

			while( rs.next() ){
				intProf.add(rs.getFloat("AMOUNT"));		
			}

		// Calculate growth of stock
		// ASSUME LIFO

		}catch (SQLException e){
			System.out.println("SQLException in DTERController ");
			e.printStackTrace();
		}
*/	
	}
}

