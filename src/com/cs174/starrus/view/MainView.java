package com.cs174.starrus.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;

public class MainView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//-------------main window components--------------
	private JPanel left;
	private JPanel right;
	private JLabel lblWelcom;
	private JLabel lblTime;
	private JLabel lblCurrentTime;
	private JPanel mainDisp;
	private JLabel lblMarketAccount;
	private JLabel lblStockAccount;
	private JLabel lblAccount;
	private JLabel lblAccountBalance;
	private JPanel Maccount;
	private JPanel Saccount;
	private JLabel lblAccountS;
	private JButton btnDeposit;
	private JButton btnWithdraw;
	private JButton btnSellStocks;
	private JButton btnBuyStocks;
	private JButton btnViewTransactions;
	private JButton btnViewTransactionsS;
	private JLabel lblUsername;
	private JEditorPane dtrpnListOfStocks;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JPanel stockPanel;
	private JPanel moviePanel;
	private JLabel lblUsername_1;
	private JLabel lblUsfield;
	private JLabel lblMyAccountInfo;
	private JLabel lblAge;
	private JLabel lblAgefield;
	private JLabel lblPassword;
		
		
	public MainView(){
		this.setSize(new Dimension(800, 600));
		this.setPreferredSize(new Dimension(800, 600));
		setLayout(null);
		this.setView();
	}
	
	public void setView(){
		
		//------------------------------left panel-------------------------------
		this.left = new JPanel();
		this.left.setBounds(0, 0, 200, 600);
		this.left.setBackground(new Color(204, 153, 153));
		this.left.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.left.setPreferredSize(new Dimension(200, 600));
		this.add(left);
		this.left.setLayout(null);
		
		this.lblWelcom = new JLabel("Welcome");
		this.lblWelcom.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.lblWelcom.setBounds(6, 23, 70, 16);
		this.left.add(this.lblWelcom);
		
		this.lblUsername = new JLabel("name");
		this.lblUsername.setBounds(88, 23, 70, 16);
		this.left.add(this.lblUsername);
		this.left.setPreferredSize(new Dimension(400, 600));
		
		this.lblUsername_1 = new JLabel("username: ");
		this.lblUsername_1.setBounds(6, 79, 84, 16);
		this.left.add(this.lblUsername_1);
		
		this.lblUsfield = new JLabel("pengwang");
		this.lblUsfield.setBounds(88, 79, 91, 16);
		this.left.add(this.lblUsfield);
		
		this.lblMyAccountInfo = new JLabel("My Account Info: ");
		this.lblMyAccountInfo.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.lblMyAccountInfo.setBounds(6, 51, 152, 16);
		this.left.add(this.lblMyAccountInfo);
		
		this.lblAge = new JLabel("age:");
		this.lblAge.setBounds(6, 100, 61, 16);
		this.left.add(this.lblAge);
		
		this.lblAgefield = new JLabel("100");
		this.lblAgefield.setBounds(88, 100, 61, 16);
		this.left.add(this.lblAgefield);
		
		this.lblPassword = new JLabel("password:");
		this.lblPassword.setBounds(6, 124, 61, 16);
		this.left.add(this.lblPassword);
		//------------------------------- end of left panel --------------------------------
		
		//------------------------------ tabbed pane --------------------------------------
		this.tabbedPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.tabbedPane.setMinimumSize(new Dimension(600, 600));
		this.tabbedPane.setPreferredSize(new Dimension(600, 600));
		this.tabbedPane.setBounds(200, 0, 600, 600);
		this.add(tabbedPane);
		
		//------------------------- right panel in the tabbed pane ----------------------
		this.right = new JPanel();
		tabbedPane.addTab("My Account", null, this.right, "View Account Information");
		this.right.setBorder(null);
		this.right.setLayout(null);
		
		this.lblTime = new JLabel("02/16/13 8:55 pm");
		this.lblTime.setBounds(459, 6, 135, 16);
		this.right.add(this.lblTime);
		
		this.lblCurrentTime = new JLabel("Current Time:");
		this.lblCurrentTime.setBounds(348, 6, 99, 16);
		this.right.add(this.lblCurrentTime);
		
		this.mainDisp = new JPanel();
		this.mainDisp.setBorder(null);
		this.mainDisp.setBounds(0, 31, 588, 517);
		this.right.add(this.mainDisp);
		this.mainDisp.setLayout(null);
		
		this.lblMarketAccount = new JLabel("Market Account Summary");
		this.lblMarketAccount.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.lblMarketAccount.setBounds(6, 6, 213, 16);
		this.mainDisp.add(this.lblMarketAccount);
		
		this.lblStockAccount = new JLabel("Stock Account Summary");
		this.lblStockAccount.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.lblStockAccount.setBounds(6, 114, 168, 16);
		this.mainDisp.add(this.lblStockAccount);
		
		this.Maccount = new JPanel();
		this.Maccount.setBackground(new Color(204, 153, 153));
		this.Maccount.setBounds(16, 32, 555, 70);
		this.mainDisp.add(this.Maccount);
		this.Maccount.setLayout(null);
		
		this.lblAccount = new JLabel("Account #:");
		this.lblAccount.setBounds(20, 6, 87, 16);
		this.Maccount.add(this.lblAccount);
		
		this.lblAccountBalance = new JLabel("Account Balance:");
		this.lblAccountBalance.setBounds(248, 6, 132, 16);
		this.Maccount.add(this.lblAccountBalance);
		
		this.btnDeposit = new JButton("Deposit");
		this.btnDeposit.setBounds(20, 34, 112, 29);
		this.Maccount.add(this.btnDeposit);
		
		this.btnWithdraw = new JButton("Withdraw");
		
		this.btnWithdraw.setBounds(144, 34, 112, 29);
		this.Maccount.add(this.btnWithdraw);
		
		this.btnViewTransactions = new JButton("View Transactions");
		this.btnViewTransactions.setBounds(268, 34, 155, 29);
		this.Maccount.add(this.btnViewTransactions);
		
		this.Saccount = new JPanel();
		this.Saccount.setLayout(null);
		this.Saccount.setBackground(new Color(204, 153, 153));
		this.Saccount.setBounds(16, 142, 555, 390);
		this.mainDisp.add(this.Saccount);
		
		this.lblAccountS = new JLabel("Account #:");
		this.lblAccountS.setBounds(20, 6, 87, 16);
		this.Saccount.add(this.lblAccountS);
		
		this.btnSellStocks = new JButton("Sell Stocks");
		this.btnSellStocks.setBounds(20, 334, 112, 29);
		this.Saccount.add(this.btnSellStocks);
		
		this.btnBuyStocks = new JButton("Buy Stocks");
		this.btnBuyStocks.setBounds(144, 334, 112, 29);
		this.Saccount.add(this.btnBuyStocks);
		
			this.btnViewTransactionsS = new JButton("View Transactions");
			this.btnViewTransactionsS.setBounds(268, 334, 155, 29);
			this.Saccount.add(this.btnViewTransactionsS);
			
			this.dtrpnListOfStocks = new JEditorPane();
			this.dtrpnListOfStocks.setText("List of stocks that I currently have");
			this.dtrpnListOfStocks.setBounds(30, 34, 505, 288);
			this.Saccount.add(this.dtrpnListOfStocks);
			
			
			this.stockPanel = new JPanel();
			tabbedPane.addTab("View Stocks", null, this.stockPanel, "View All Available Stocks");
			
			
			this.moviePanel = new JPanel();
			tabbedPane.addTab("View Movies", null, this.moviePanel, "View All Available Movies");
	}
}
