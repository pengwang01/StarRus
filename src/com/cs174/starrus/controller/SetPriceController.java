package com.cs174.starrus.controller;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.SetNewPriceView;

import java.sql.Connection;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SetPriceController implements IController{
	private boolean 	DEBUG		= true;
	private Connection 	conn		= null;
	private SetNewPriceView snpView  = SetNewPriceView.getView();
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
	}
	@Override
	public void process(String model) {
		SetNewPriceView snpV	= SetNewPriceView.getView();
		Statement 	stmt;

		try{
			conn 	= DBconnector.getConnection();
			stmt	= conn.createStatement();

			if( DEBUG == true){
				System.out.println(	"SELECT * FROM STOCK " 			+
									"WHERE SYMBOL = '"				+
									snpV.getTxtTicker().getText().toUpperCase()	+ "'"			
									);	

			}

			/*ResultSet	rs		= stmt.executeQuery(	"SELECT * FROM STOCK " 			+
											"WHERE SYMBOL = '"				+
											snpV.getTxtTicker().getText().toUpperCase()	+ "'"			
											);	*/
/*
			if(rs.next()){
				// STORE CURRENT PRICE INTO THE PRICES TABLE FOR FUTURE LOOKUP
				if(DEBUG == true){
				System.out.println(	"INSERT INTO PRICES VALUES ('"			+
									sD.getDateStr()	+ "',"					+
									rs.getString("CUR_PRICE")	+ ",'"		+
									rs.getString("SYMBOL")		+ "')"
									);
				}

				stmt.executeQuery(	"INSERT INTO PRICES VALUES ('"			+
									sD.getDateStr()	+ "',"					+
									rs.getString("CUR_PRICE")	+ ",'"		+
									rs.getString("SYMBOL")		+ "')"
									);
			}
*/

			// UPDATE THE PRICE IN THE STOCK TABLE
			if(DEBUG == true){
			System.out.println(		"UPDATE STOCK SET CUR_PRICE = "			+
									snpV.getTxtPrice().getText()	+" "	+
									"WHERE SYMBOL = '"						+
									snpV.getTxtTicker().getText().toUpperCase()	+"'"	
								);
			}
			stmt.executeQuery(		"UPDATE STOCK SET CUR_PRICE = "			+
									snpV.getTxtPrice().getText()	+" "	+
									"WHERE SYMBOL = '"						+
									snpV.getTxtTicker().getText().toUpperCase()	+ "'"	
								);
			//TODO May need to increment the date 
			// MOST LIKELY NOT
			snpView.dispose();
				
		}catch (SQLException e){
			System.out.println("SQLException in SetPriceController");
			e.printStackTrace();
		}
	}
}

