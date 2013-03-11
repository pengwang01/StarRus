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
		Vector<String>	userList	= new Vector<String>();
		Vector<double>	profit		= new Vector<double>();
		Vector<double>	intProf		= new Vector<double>();
		Vector<double>	sGrowProf	= new Vector<double>();

		try{
			conn 	= DBconnector.getConnection();
			stmt	= conn.createStatement();
			DateFormat format   = new SimpleDateFormat("dd-MMM-yy");
			Date today          = new Date();
			String dateString   = format.format(today);

		// Calculate the list of users
			if( DEBUG == true ){
				System.out.println("SELECT USERNAME FROM CUSTOMER");
			}

			rs		= stmt.executeQuery("SELECT USERNAME FROM CUSTOMER");
			while(rs.next()){
				userList.add(rs.getString("USERNAME"));
			}
		
		// Calculate stock transaction profit
			int stockTransProfit	= 0;
			for( int i = 0 ; i < userList.size(); i++){
				if( DEBUG == true ){
					System.out.println(	"SELECT SUM(PROFIT) AS PROFIT FROM STOCK_TRANS WHERE SUSERNAME = '"	+
										userList.get(i)	+ "'"			
									);
				}
				rs 		= stmt.executeQuery("SELECT SUM(PROFIT) AS PROFIT FROM STOCK_TRANS WHERE SUSERNAME = '"	+
											userList.get(i)	+ '""
											);
				// TODO:May not be logically correct
				while( rs.next() ){
					profit.set(i,profit.get(i)+rs.getFloat("PROFIT"));
				}
			// Calculate interest profit
				if( DEBUG ==  true){
					System.out.println(	"SELECT * FROM MONEY_TRANS "			+
										"WHERE TTYPE = 3 "						+
										"AND TUSERNAME = '"						+
										userList.get(i)	+ "'"					+
										);
				}
				rs 		= stmt.executeQuery("SELECT * FROM MONEY_TRANS "		+
											"WHERE TTYPE = 3 "					+
											"AND TUSERNAME = '"					+
											userList.get(i)	+ "'"				+
											);

				while( rs.next() ){
					profit.set(i,profit.get(i)+rs.getFloat("AMOUNT"));
				}
			// Calculate growth of stock
			// ASSUMING LIFO
				if( DEBUG == true){
					System.out.println("SELECT * FROM STOCK_TRANS WHERE SUSERNAME = '"	+
											userList.get(i)									+
											"STYPE = 0"
										);

				}
				rs		= stmt.executeQuery("SELECT * FROM STOCK_TRANS WHERE SUSERNAME = '"	+
											userList.get(i)									+
											"STYPE = 0"
											);
				while( rs.next() ){
				}
			// 
				
				
			}

		}catch (SQLException e){
			System.out.println("SQLException in DTERController ");
			e.printStackTrace();
		}
*/	
	}
}

