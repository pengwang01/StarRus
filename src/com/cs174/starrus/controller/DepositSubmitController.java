package com.cs174.starrus.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cs174.starrus.model.Customer;
import com.cs174.starrus.view.CustomerView;
import com.cs174.starrus.view.DepositView;
import com.cs174.starrus.view.IView;

public class DepositSubmitController implements IController{
	private boolean DEBUG = true;
	private Connection conn = null;
	private Customer c = Customer.getCustomer();
	private DepositView depoV = DepositView.getView();
	private CustomerView cView = CustomerView.getView();
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(String model) {
		// TODO Auto-generated method stub
		conn 			= DBconnector.getConnection();
		Statement 		stmt;
		ResultSet		rs;
		float fBalance 	= 0;
		try {
			float toDeposit	= 0;
			float balance 	= 0;
			stmt		= conn.createStatement();
			toDeposit	= Float.parseFloat(depoV.getTxtDeposit().getText());


			// deposit cannot be negative number
			if(Float.parseFloat(depoV.getTxtDeposit().getText()) >= 0){
				System.out.println(depoV.getTxtDeposit().getText());
				balance = Float.parseFloat(depoV.getTxtDeposit().getText()) + c.getBalance();
				c.setBalance(balance);

				// Insert into Money_trans Table	
				// execute query for add row to money transaction table
				DateFormat format   = new SimpleDateFormat("dd-MMM-yy");
				Date today          = new Date();
				String dateString   = format.format(today);
			
				// execute query for deposit
				stmt.executeQuery("UPDATE Customer set balance = " 	+ balance + 
									"WHERE username = '" 			+ c.getUsername() + "'");

				// Pull balance from Customer table
				rs = stmt.executeQuery(	"SELECT BALANCE FROM CUSTOMER WHERE USERNAME = '"	+
										c.getUsername()	+ "'"
										);
					
				if( rs.next()){
					fBalance= rs.getFloat("BALANCE");
				}

				// FOR DEBUGGING PURPOSES
				if( DEBUG == true ){
					System.out.println( "Username: "+ c.getUsername()   +" \n" +
										"Date: "    + dateString        +" \n" +
										"Balance: " + c.getBalance()
									);
					System.out.println("INSERT INTO MONEY_TRANS (TDATE,TUSERNAME,TTYPE,AMOUNT) VALUES ("
										+ "'"   + c.getUsername()   + "'"   + ","
										+ 1                 		+ ","		// 1 for deposit
										+ toDeposit			   		+ ","
										+ fBalance					+ ")"
									);
				}

				stmt.executeQuery( "INSERT INTO MONEY_TRANS (TDATE,TUSERNAME,TTYPE,AMOUNT) VALUES ("
									+ "'"   + dateString        + "'"   + ","
									+ "'"   + c.getUsername()   + "'"   + ","
									+ 1                 		+ ","			// 1 fore deposit
									+ toDeposit		    		+ "," 
									+ fBalance					+ ")"
								);



				cView.getBalancefield().setText(Float.toString(balance));
				depoV.getTxtDeposit().setText(null);
				depoV.getLblWarning().setText(null);
				depoV.setVisible(false);
				

			}
			else{
				depoV.getLblWarning().setText("No input or negative #");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in Deposite submit controller");
		} // Specify the SQL Query to run
		
	}

}
