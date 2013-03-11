package com.cs174.starrus.controller;
import com.cs174.starrus.view.IView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

import java.text.DecimalFormat;

import java.util.ArrayList;



public class AddInterestController implements IController{
	private boolean 	DEBUG		= true;
	private Connection 	conn		= null;
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
	}

	@Override
	public void process(String model) {
		Statement 	stmt;
		ResultSet	rs;
		double		balance		= 0;
		double		interest	= .0025;	// Assume simple interest
											// .00246 if effective interest
		double		accrued		= 0;
		double		newBal		= 0;
//		String 		user;
		ArrayList<String> userList	= new ArrayList<String>();
		ArrayList<Double> aBalList	= new ArrayList<Double>();


		try{
			conn 	= DBconnector.getConnection();
			stmt	= conn.createStatement();
			DateFormat format   = new SimpleDateFormat("dd-MMM-yy");
			Date today          = new Date();
			String dateString   = format.format(today);

			if(DEBUG == true){
				System.out.println(		"SELECT TUSERNAME, AVG(BALANCE) AS BALANCE FROM MONEY_TRANS WHERE "	+
										"(M_TRANS_ID,TUSERNAME) IN "								+
										"(SELECT MAX(M_TRANS_ID),TUSERNAME FROM MONEY_TRANS WHERE "	+
										"TDATE IN "													+
										"(SELECT MAX(TDATE) FROM MONEY_TRANS GROUP BY TDATE) "		+
										"GROUP BY TDATE,TUSERNAME) GROUP BY TUSERNAME"				
									);
			}

			rs 		=stmt.executeQuery(	"SELECT TUSERNAME, AVG(BALANCE) AS BALANCE FROM MONEY_TRANS WHERE "	+
										"(M_TRANS_ID,TUSERNAME) IN "								+
										"(SELECT MAX(M_TRANS_ID),TUSERNAME FROM MONEY_TRANS WHERE "	+
										"TDATE IN "													+
										"(SELECT MAX(TDATE) FROM MONEY_TRANS GROUP BY TDATE) "		+
										"GROUP BY TDATE,TUSERNAME) GROUP BY TUSERNAME"				
										);
			

			while( rs.next()){
//				user		= rs.getString("TUSERNAME");
//				avgBalance 	= rs.getFloat("BALANCE");
				userList.add(rs.getString("TUSERNAME"));
				aBalList.add((double)rs.getFloat("BALANCE"));

			// Get balance for this user
			// The result of doing a new query is that rs is rewritten
			// Therefore, we need to redo the original query again
			}

			for( int i = 0 ; i < userList.size() ; i ++){
				if( DEBUG == true){
					System.out.println("SELECT * FROM CUSTOMER WHERE USERNAME = '"	+ userList.get(i) + "'"	
										);

				}
				rs	= stmt.executeQuery("SELECT * FROM CUSTOMER WHERE USERNAME = '"	+ userList.get(i) + "'"
										);
				if( rs.next() ){									
					balance	= rs.getFloat("BALANCE");
				}

				// Accrue Interest
					accrued	= aBalList.get(i)* interest;
					newBal	= balance + accrued;

					if( DEBUG == true){
						System.out.println("AvgBalance: " 	+ aBalList.get(i));
						System.out.println("Balance: " 		+ balance);
						System.out.println("Accrued: " 		+ accrued);
						System.out.println("User: "			+ userList.get(i));
						System.out.println("UPDATE CUSTOMER SET BALANCE = BALANCE + "					+
											accrued 	+ " WHERE USERNAME = '"	+ userList.get(i)	+ "'"	
											);
					}
					
					stmt.executeQuery("UPDATE CUSTOMER SET BALANCE = BALANCE + "						+
												accrued 	+ " WHERE USERNAME = '"	+ userList.get(i)	+ "'"
												);

					DecimalFormat df = new DecimalFormat("####################.##");
					String newBalStr	= df.format(newBal);
					String accruedStr	= df.format(accrued);

				// Reflect increase in money_trans table
					if(DEBUG == true){
						System.out.println("INSERT INTO MONEY_TRANS(TDATE,TUSERNAME,TTYPE,AMOUNT,BALANCE) VALUES "+
											"('" 		+ dateString	+ "','"	+ userList.get(i)	+ "',"	+ 1	+ ","		+
											accruedStr	+ ","			+ newBalStr		+ ")"
											);

					}

					stmt.executeQuery(	"INSERT INTO MONEY_TRANS(TDATE,TUSERNAME,TTYPE,AMOUNT,BALANCE) VALUES "+
										"('" 		+ dateString	+ "','"	+ userList.get(i)	+ "',"	+ 1	+ ","		+
										accruedStr	+ ","			+ newBalStr		+ ")"
									);


			}

			if( DEBUG == true){
				System.out.println("######################DONE WITH INTEREST###################");
			}

		}catch (SQLException e){
			System.out.println("SQLException in AddInterestController");
			e.printStackTrace();
		}
		
	}
}

