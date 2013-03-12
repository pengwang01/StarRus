package com.cs174.starrus.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import com.cs174.starrus.model.Customer;
import com.cs174.starrus.model.SysDate;
import com.cs174.starrus.view.CustomerView;
import com.cs174.starrus.view.DepositView;
import com.cs174.starrus.view.IView;

public class DepositSubmitController implements IController{
	private boolean DEBUG = true;
	private Connection conn = null;
	private Customer c = Customer.getCustomer();
	private DepositView depoV = DepositView.getView();
	private CustomerView cView = CustomerView.getView();
	private SysDate		sD = SysDate.getSysDate();
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
				
				// update balance
				balance = Float.parseFloat(depoV.getTxtDeposit().getText()) + c.getBalance();
				c.setBalance(balance);
				
				// if account balance > 1000, then set up stock account
				if(c.getBalance() >= 1000){
					stmt.executeQuery("UPDATE customer set s_account_id = " + c.getM_account_id() +
						"where username = '" + c.getUsername() + "'");
				}
				
				// Insert into Money_trans Table	
				// execute query for add row to money transaction table
			
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
										"Date: "    + sD.getDateStr()        +" \n" +
										"Balance: " + c.getBalance()
									);
					System.out.println("INSERT INTO MONEY_TRANS (TDATE,TUSERNAME,TTYPE,AMOUNT) VALUES ("
										+ "'"   + c.getUsername()   + "'"   + ","
										+ 1                 		+ ","		// 1 for deposit
										+ toDeposit			   		+ ","
										+ fBalance					+ ")"
									);
				}

				stmt.executeQuery( "INSERT INTO MONEY_TRANS (TDATE,TUSERNAME,TTYPE,AMOUNT,BALANCE) VALUES ("
									+ "'"   + sD.getDateStr()        + "'"   + ","
									+ "'"   + c.getUsername()   + "'"   + ","
									+ 1                 		+ ","			// 1 fore deposit
									+ toDeposit		    		+ "," 
									+ fBalance					+ ")"
								);


				cView.getLblSAccountId().setText(Integer.toString(c.getS_account_id()));
				cView.getBalancefield().setText(Float.toString(balance));
				depoV.getTxtDeposit().setText(null);
				depoV.getLblWarning().setText(null);
				depoV.setVisible(false);
				

			}
			else{
				depoV.getLblWarning().setText("No input or negative #");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			System.out.println("Exception in Deposite submit controller");
		} // Specify the SQL Query to run
		
	}

}
