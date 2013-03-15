package com.cs174.starrus.controller;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.model.SysDate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;



public class CloseMarketController implements IController{
	private boolean 	DEBUG		= true;
	private Connection 	conn		= null;
	private SysDate		sD			= SysDate.getSysDate();
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
	}
	@Override
	public void process(String model) {
		Statement 	stmt;
		ResultSet	rs;
		Vector<String> stocks 	= new Vector<String>();
		Vector<Float> prices	= new Vector<Float>();

		try{
			conn 	= DBconnector.getConnection();
			stmt	= conn.createStatement();

			if( DEBUG == true){
				System.out.println(	"SELECT * FROM STOCK");	

			}

			rs		= stmt.executeQuery("SELECT * FROM STOCK");	
			while(rs.next()){
				// STORE CURRENT PRICE INTO THE PRICES TABLE FOR FUTURE LOOKUP
				stocks.add(rs.getString("SYMBOL"));
				prices.add(rs.getFloat("CUR_PRICE"));

			}
			
			for( int i = 0 ; i < stocks.size(); i ++){
				if(DEBUG == true){
					System.out.println(	"INSERT INTO PRICES VALUES ('"			+
										sD.getDateStr()	+ "',"					+
										Float.toString(prices.get(i))	+ ",'"					+
										stocks.get(i)	+ "')"
										);
				}
				stmt.executeQuery(	"INSERT INTO PRICES VALUES ('"			+
										sD.getDateStr()	+ "',"					+
										Float.toString(prices.get(i))	+ ",'"					+
										stocks.get(i)	+ "')"
										);

				}

			// Insert every customer's balance into the balance tbale
			rs		= stmt.executeQuery("SELECT * FROM CUSTOMER");
			ArrayList<String>	userList	= new ArrayList<String>();
			float	balance = 0;
			while(rs.next()){
				userList.add(rs.getString("USERNAME"));
			}
			
			for( int i =0;i<userList.size();i++){
				if(DEBUG == true){
					System.out.println("SELECT * FROM CUSTOMER WHERE USERNAME ='" + userList.get(i) +"'");
				}
				rs	= stmt.executeQuery("SELECT * FROM CUSTOMER WHERE USERNAME ='" + userList.get(i) +"'");
				if(rs.next()){
					balance = rs.getFloat("BALANCE");
				}
				if(DEBUG == true){
					System.out.println("INSERT INTO BALANCE(USERNAME,BALANCE,BDATE) VALUES ('"
									+ userList.get(i)	+ "',"
									+ balance			+ ",'"
									+ sD.getDateStr()	+ "')"
									);

				}
				stmt.executeQuery(	"INSERT INTO BALANCE(USERNAME,BALANCE,BDATE) VALUES ('"
									+ userList.get(i)	+ "',"
									+ balance			+ ",'"
									+ sD.getDateStr()	+ "')"
									);
			}

									
		}catch (SQLException e){
			System.out.println("SQLException in SetPriceController");
			e.printStackTrace();
		}
	}
}

