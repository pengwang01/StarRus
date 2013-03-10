package com.cs174.starrus.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cs174.starrus.model.Customer;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.LoginView;

import com.cs174.starrus.view.CustomerView;

import java.util.Vector;

public class LoginController implements IController{
	private boolean DEBUG		= true;
	private Connection conn 	= null;
	private LoginView loginView = LoginView.getView();
	private CustomerView cV		= CustomerView.getView();
	
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(String model) {
		String username = loginView.getTxtEnterUsername().getText();
		String password = loginView.getTxtEnterPassword().getText();
		Customer c;
		System.out.println("username is: " + username + " password is: " + password);

		try{
			conn = DBconnector.getConnection();
			Statement stmt = conn.createStatement(); // Specify the SQL Query to run
			if(DEBUG == true){
				System.out.println("SELECT * FROM CUSTOMER WHERE " + 
											"USERNAME= '" + username + "' AND " +
											"PSD = '" + password + "'"
									);

			}
			ResultSet rs = stmt.executeQuery ("SELECT * FROM CUSTOMER WHERE "	+
											"USERNAME= '" + username + "' AND " +
											"PSD= '" + password + "'");
			if(rs.next()){
				c = Customer.getCustomer();
				c.setUsername(username);
				c.setPsd(password);
				c.setCname(rs.getString("cname"));
				c.setPhone_num(rs.getString("phone_num"));
				c.setState(rs.getString("state"));
				c.setTax_id(rs.getInt("tax_id"));
				c.setEmail(rs.getString("email"));
				c.setM_account_id(rs.getInt("m_account_id"));
				c.setS_account_id(rs.getInt("s_account_id"));
				c.setClevel(rs.getInt("clevel"));
				c.setAge(rs.getInt("age"));
				c.setBalance(rs.getFloat("balance"));

				if( DEBUG == true ){
					System.out.println("SELECT * FROM STOCK_TRANS WHERE SUSERNAME = '" 	+
										c.getUsername()	+ "'"
										);

				}
				rs = stmt.executeQuery(	"SELECT * FROM STOCK_TRANS WHERE SUSERNAME = '" 	+
										c.getUsername()	+ "'"
										);
				while( rs.next() ){
					if(DEBUG == true){
						System.out.println("Inserting into Stock table");
					}
					Vector<String> newRow = new Vector<String>();
					int type 	= rs.getInt("STYPE");
					int shares	= rs.getInt("SHARES");
					float price	= rs.getFloat("PRICE");
					String tkr	= rs.getString("SYMBOL");
					if( type == 0){
						newRow.add("Buy");
					}else if( type == 1){
						newRow.add("Sell");	
					}

					newRow.add(tkr);
					newRow.add(Float.toString(price));
					newRow.add(Integer.toString(shares));
					cV.getRow_myStock().add(newRow);
				}
				cV.updateView(c);

				if(c.getClevel() == 1){
					view.loadManagerView(c);	// load c view when login is checked
				}
				else if(c.getClevel() == 2){
					view.loadCustomerView(c);	// load c view when login is checked
				}
			}
			else{
				loginView.getLblMismatch().setText("Username and password do not match, please try again.");
			}

			
		} catch (SQLException e){
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("SQL exception in LoginController");
		}
	}
}
