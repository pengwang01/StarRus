package com.cs174.starrus.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import javax.swing.*;
import javax.swing.border.LineBorder;

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
	private JButton btnChangePassword;
	private JButton btnChangePhone;
	private JLabel lblManageAccount;
	private JButton btnChangeEmail;
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
		
		
	public MainView(){
		this.setSize(new Dimension(800, 600));
		this.setPreferredSize(new Dimension(800, 600));
		setLayout(null);
		this.setView();
	}
	
	public void setView(){
		this.left = new JPanel();
		this.left.setBounds(0, 0, 200, 600);
		this.left.setBackground(new Color(204, 153, 153));
		this.left.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.left.setPreferredSize(new Dimension(200, 600));
		this.add(left);
		this.left.setLayout(null);
		
		this.lblWelcom = new JLabel("Welcome");
		this.lblWelcom.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.lblWelcom.setBounds(19, 48, 70, 16);
		this.left.add(this.lblWelcom);
		
		this.lblUsername = new JLabel("name");
		this.lblUsername.setBounds(103, 48, 70, 16);
		this.left.add(this.lblUsername);
		
		this.btnChangePassword = new JButton("Edit Password");
		this.btnChangePassword.setBounds(19, 104, 154, 29);
		this.left.add(this.btnChangePassword);
		
		this.btnChangePhone = new JButton("Edit Phone #");
		this.btnChangePhone.setBounds(19, 145, 154, 29);
		this.left.add(this.btnChangePhone);
		
		this.lblManageAccount = new JLabel("Manage Account");
		this.lblManageAccount.setBounds(19, 76, 154, 16);
		this.left.add(this.lblManageAccount);
		
		this.btnChangeEmail = new JButton("Edit Email");
		this.btnChangeEmail.setBounds(19, 186, 154, 29);
		this.left.add(this.btnChangeEmail);
		
		this.right = new JPanel();
		this.right.setBounds(200, 0, 600, 600);
		this.right.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.left.setPreferredSize(new Dimension(400, 600));
		this.add(right);
		this.right.setLayout(null);
		
		this.lblTime = new JLabel("02/16/13 8:55 pm");
		this.lblTime.setBounds(459, 6, 135, 16);
		this.right.add(this.lblTime);
		
		this.lblCurrentTime = new JLabel("Current Time:");
		this.lblCurrentTime.setBounds(348, 6, 99, 16);
		this.right.add(this.lblCurrentTime);
		
		this.mainDisp = new JPanel();
		this.mainDisp.setBorder(null);
		this.mainDisp.setBounds(6, 34, 588, 538);
		this.right.add(this.mainDisp);
		this.mainDisp.setLayout(null);
		
		this.lblMarketAccount = new JLabel("Market Account Summary");
		this.lblMarketAccount.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.lblMarketAccount.setBounds(6, 6, 213, 16);
		this.mainDisp.add(this.lblMarketAccount);
		
		this.lblStockAccount = new JLabel("Stock Account Summary");
		this.lblStockAccount.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.lblStockAccount.setBounds(6, 270, 168, 16);
		this.mainDisp.add(this.lblStockAccount);
		
		this.Maccount = new JPanel();
		this.Maccount.setBackground(new Color(204, 153, 153));
		this.Maccount.setBounds(16, 32, 555, 226);
		this.mainDisp.add(this.Maccount);
		this.Maccount.setLayout(null);
		
		this.lblAccount = new JLabel("Account #:");
		this.lblAccount.setBounds(20, 6, 87, 16);
		this.Maccount.add(this.lblAccount);
		
		this.lblAccountBalance = new JLabel("Account Balance:");
		this.lblAccountBalance.setBounds(248, 6, 132, 16);
		this.Maccount.add(this.lblAccountBalance);
		
		this.btnDeposit = new JButton("Deposit");
		this.btnDeposit.setBounds(20, 178, 112, 29);
		this.Maccount.add(this.btnDeposit);
		
		this.btnWithdraw = new JButton("Withdraw");
		
		this.btnWithdraw.setBounds(144, 178, 112, 29);
		this.Maccount.add(this.btnWithdraw);
		
		this.btnViewTransactions = new JButton("View Transactions");
		this.btnViewTransactions.setBounds(268, 178, 155, 29);
		this.Maccount.add(this.btnViewTransactions);
		
		this.Saccount = new JPanel();
		this.Saccount.setLayout(null);
		this.Saccount.setBackground(new Color(204, 153, 153));
		this.Saccount.setBounds(16, 298, 555, 221);
		this.mainDisp.add(this.Saccount);
		
		this.lblAccountS = new JLabel("Account #:");
		this.lblAccountS.setBounds(20, 6, 87, 16);
		this.Saccount.add(this.lblAccountS);
		
		this.btnSellStocks = new JButton("Sell Stocks");
		this.btnSellStocks.setBounds(20, 172, 112, 29);
		this.Saccount.add(this.btnSellStocks);
		
		this.btnBuyStocks = new JButton("Buy Stocks");
		this.btnBuyStocks.setBounds(145, 172, 112, 29);
		this.Saccount.add(this.btnBuyStocks);
	
		this.btnViewTransactionsS = new JButton("View Transactions");
		this.btnViewTransactionsS.setBounds(269, 172, 155, 29);
		this.Saccount.add(this.btnViewTransactionsS);
	}
}
