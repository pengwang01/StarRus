package com.cs174.starrus.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cs174.starrus.model.Customer;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.LoginView;
import com.cs174.starrus.view.ManagerView;

import com.cs174.starrus.view.CustomerView;

import java.util.Vector;

import javax.swing.*;

public class LoginController implements IController{
	private boolean DEBUG		= true;
	private Connection conn 	= null;
	private LoginView loginView = LoginView.getView();
	private CustomerView cV		= CustomerView.getView();
	private ManagerView mV      = ManagerView.getView();

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
				c.setCname(rs.getString("cname"));
				c.setPhone_num(rs.getString("phone_num"));
				c.setState(rs.getString("state"));
				c.setTax_id(rs.getString("tax_id"));
				c.setPsd(password);
				c.setEmail(rs.getString("email"));
				c.setClevel(rs.getInt("clevel"));
				c.setBalance(rs.getFloat("balance"));
				c.setM_account_id(rs.getInt("M_ACCOUNT_ID"));
				c.setS_account_id(rs.getInt("S_ACCOUNT_ID"));


//=========================STOCK TABLE CALCULATIONS===============================
				if( DEBUG == true ){
					System.out.println("SELECT * FROM MANAGE_STOCK WHERE MUSERNAME = '" 	+
										c.getUsername()	+ "'"
										);
				}
				rs = stmt.executeQuery(	"SELECT * FROM MANAGE_STOCK WHERE MUSERNAME = '" 	+
										c.getUsername()	+ "'"
										);
				cV.getRow_myStock().clear();
				while( rs.next() ){
					if(DEBUG == true){
						System.out.println("Inserting into Stock table");
					}
					Vector<String> newRow = new Vector<String>();
					int 	shares	= rs.getInt("TOTAL_SHARE");
					String 	tkr		= rs.getString("SYMBOL");
					Float	price	= rs.getFloat("PRICE");
					
					if(DEBUG == true){
						System.out.println("Updating total shares, symbol, price");
						System.out.println("shares: " + shares);
						System.out.println("Symbol: " + tkr);
						System.out.println("Price: " + price);
					}
					newRow.add(tkr);
					newRow.add(Integer.toString(shares));
					newRow.add(Float.toString(price));
					cV.getRow_myStock().add(newRow);
				}
				cV.updateView(c);
				
				
//=========================STOCK LIST TAB ( TAB 2)===============================
				if( DEBUG == true ){
					System.out.println("SELECT * FROM STOCK");
				}
				rs = stmt.executeQuery(	"SELECT * FROM STOCK");
				cV.getRow_listStock().clear();
				while( rs.next() ){
					if(DEBUG == true){
						System.out.println("Inserting into Stock table");
					}
					Vector<String> newRow = new Vector<String>();
					float price	= rs.getFloat("CUR_PRICE");
					String tkr	= rs.getString("SYMBOL");
				
					newRow.add(tkr);
					newRow.add(Float.toString(price));
					cV.getRow_listStock().add(newRow);
				}
				cV.updateView(c);		

//=========================MOVIE LIST TAB ( TAB 3)===============================
				rs = stmt.executeQuery(	"SELECT * FROM MOVIES");
				cV.getRow_listMovie().clear();
				while( rs.next() ){
					Vector<String> newRow 	= new Vector<String>();
					String 	title			= rs.getString("TITLE");
					int		production		= rs.getInt("PRODUCTION");
					String 	organization	= rs.getString("ORGANIZATION");
					String	rating			= Float.toString(rs.getFloat("RATING"));
					if(DEBUG == true){
						System.out.println("Inserting into Movies table");
						System.out.println("Title: " + title);		
						System.out.println("Production: " + production);
						System.out.println("Organization: " + organization);
						System.out.println("Rating: " + rating);
					}
			
					newRow.add(title);
					newRow.add(Integer.toString(production));
					newRow.add(organization);
					newRow.add(rating);
					cV.getRow_listMovie().add(newRow);
				}
				cV.updateView(c);

//=========================ACTOR LIST TAB ( TAB 3)===============================
				rs = stmt.executeQuery(	"SELECT * FROM ACTOR");
				cV.getRow_Actor().clear();
				while( rs.next() ){
					Vector<String> newRow 	= new Vector<String>();
					String 	name	= rs.getString("NAME");
					String 	role	= rs.getString("ROLE");
					String 	symbol	= rs.getString("SYMBOL");
					String 	year	= Integer.toString(rs.getInt("YEAR"));
					String 	birthday	= rs.getString("BIRTHDAY");
					String 	totalvalue	= Float.toString(rs.getFloat("TOTAL_VALUE"));
					String 	title	= rs.getString("TITLE");
					if(DEBUG == true){
						System.out.println("Inserting into Actors table");
					System.out.println("Name: "		+ name);
					System.out.println("Role: " 	+ role);
					System.out.println("Year: "		+ year);
					System.out.println("Birthday: "	+ birthday);
					System.out.println("Totalvalue: "	+ totalvalue);
					System.out.println("Movie_title: "	+ title);
					}
			
					newRow.add(name);
					newRow.add(symbol);
					newRow.add(birthday);
					newRow.add(totalvalue);
					newRow.add(title);
					newRow.add(role);
					newRow.add(year);
					
					
					cV.getRow_Actor().add(newRow);
				}
				cV.updateView(c);


				if(c.getClevel() == 1){

//=========================ACTIVE CALCULATIONS===============================
					if( DEBUG == true ){
						System.out.println("SELECT SUSERNAME FROM " +
								"( SELECT SUSERNAME, SUM(SHARES) AS MYSUM " +
								"FROM STOCK_TRANS " +
								"GROUP BY SUSERNAME ) " +
								"WHERE MYSUM >= 1000" );

					}
					rs 		= stmt.executeQuery("SELECT SUSERNAME FROM " +
							"( SELECT SUSERNAME, SUM(SHARES) AS MYSUM " +
							"FROM STOCK_TRANS " +
							"GROUP BY SUSERNAME) " +
							"WHERE MYSUM >= 1000" );
					mV.getRow_active().clear();
					while( rs.next() ){
						
						if(DEBUG == true){
							System.out.println("Getting Row");
						}
						Vector<String> newRow = new Vector<String>();
						String n	= rs.getString("SUSERNAME");
						newRow.add(n);
						mV.getRow_active().add(newRow);
					}

//=========================DTER CALCULATIONS===============================
					Vector<String>	userList= new Vector<String>();
					Vector<String>	name	= new Vector<String>();
					Vector<String>	state	= new Vector<String>();
					//Vector<Double>	profit	= new Vector<Double>();

					mV.getRow_Dter().clear();
					// Calculate the list of users
						if( DEBUG == true ){
							System.out.println("SELECT * FROM CUSTOMER");
						}

						rs		= stmt.executeQuery("SELECT * FROM CUSTOMER");
						while(rs.next()){
							userList.add(rs.getString("USERNAME"));
							name.add(rs.getString("CNAME"));
							state.add(rs.getString("STATE"));

						}
					
					// Calculate stock transaction profit
						for( int i = 0 ; i < userList.size(); i++){
							double profit			= 0;
							Vector<String> input	= new Vector<String>();
							if( DEBUG == true ){
								System.out.println(	"SELECT SUM(PROFIT) AS PROFIT FROM STOCK_TRANS WHERE SUSERNAME = '"	+
													userList.get(i)	+ "'"			
												);
							}
							rs 		= stmt.executeQuery("SELECT SUM(PROFIT) AS PROFIT FROM STOCK_TRANS WHERE SUSERNAME = '"	+
														userList.get(i)	+ "'"
														);
							// TODO:May not be logically correct
							while( rs.next() ){
								profit += rs.getFloat("PROFIT");
							}
						// Calculate interest profit
							if( DEBUG ==  true){
								System.out.println(	"SELECT * FROM MONEY_TRANS "			+
													"WHERE TTYPE = 3 "						+
													"AND TUSERNAME = '"						+
													userList.get(i)	+ "'"					
													);
							}
							rs 		= stmt.executeQuery("SELECT * FROM MONEY_TRANS "		+
														"WHERE TTYPE = 3 "					+
														"AND TUSERNAME = '"					+
														userList.get(i)	+ "'"				
														);

							while( rs.next() ){
								profit += rs.getFloat("AMOUNT");
							}
						// Calculate growth of stock
						// ASSUMING LIFO
							if( DEBUG == true){
								System.out.println("SELECT * FROM STOCK_TRANS WHERE SUSERNAME = '"	+
														userList.get(i)	+ "' AND "					+
														"STYPE = 0"
													);

							}
							rs		= stmt.executeQuery("SELECT * FROM STOCK_TRANS WHERE SUSERNAME = '"	+
														userList.get(i)	+ "' AND "						+
														"STYPE = 0"
														);
							while( rs.next() ){
							}

							if( DEBUG == true){
								System.out.println("USERNAME: " + userList.get(i));
								System.out.println("NAME: " + name.get(i));
								System.out.println("STATE: " + state.get(i));
								System.out.println("PROFIT: " + profit);
							}
							if( profit > 10000.0){
								input.add(userList.get(i));
								input.add(name.get(i));
								input.add(state.get(i));
								mV.getRow_Dter().add(input);
							}

							
					}

					Customer customer = Customer.getCustomer();
					mV.setView(customer);
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
			e.printStackTrace();
			System.out.println("SQL exception in LoginController");
		}
	}

	public static void showReviews(String title){
		try{
			boolean DEBUG = true;
			Connection	con = DBconnector.getConnection();
			Statement 	stmt = con.createStatement(); // Specify the SQL Query to run

			if( DEBUG == true ){
				System.out.println(	"SELECT * FROM REVIEWS WHERE MOVIE = '"	+
									title	+ "'"
								);

			}

			ResultSet rs = stmt.executeQuery(	"SELECT * FROM REVIEWS WHERE MOVIE = '"	+
												title 	+ "'"
											);
			String toDisplay = "";
			while(rs.next()){
				String author	= rs.getString("AUTHOR").trim();
				String comment 	= rs.getString("MESSAGE");
				toDisplay = toDisplay + "####################" + author + "####################\n";
				toDisplay = toDisplay +  "Commment:\t"	+ comment +"\n";
				toDisplay = toDisplay + "########################################\n\n";
			}
			JOptionPane.showMessageDialog(null,toDisplay);
		}
		catch ( SQLException e){
			System.out.println("SQL Exception in LoginController.ShowReview");
		}
	}
}


