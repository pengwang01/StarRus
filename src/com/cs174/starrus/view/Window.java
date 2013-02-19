package com.cs174.starrus.view;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Window extends JFrame{
	//------------login window components-------------
	private JPanel panel;
	private JLabel lblUserLogin;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtEnterUsername;
	private JTextField txtEnterPassword;
	private JButton btnLogin;
	private JButton btnReset;
	
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
	
	public Window() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("StarRus");
		setSize(new Dimension(800, 600));
		setLocation(new Point(100, 100));
		getContentPane().setLayout(null);
	}
	
	public void launchLoginWindow(){
		this.panel = new JPanel();
		this.panel.setBackground(new Color(204, 153, 153));
		this.panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.panel.setLocation(new Point(200, 150));
		this.panel.setLocation(200, 150);
		this.panel.setSize(new Dimension(400, 300));
		this.panel.setPreferredSize(new Dimension(400, 300));
		getContentPane().add(this.panel);
		this.panel.setLayout(null);
		
		this.lblUserLogin = new JLabel("User Login");
		this.lblUserLogin.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		this.lblUserLogin.setBounds(128, 6, 137, 51);
		this.panel.add(this.lblUserLogin);
		
		this.lblUsername = new JLabel("Username:");
		this.lblUsername.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		this.lblUsername.setBounds(59, 106, 108, 22);
		this.panel.add(this.lblUsername);
		
		this.lblPassword = new JLabel("Password:");
		this.lblPassword.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		this.lblPassword.setBounds(59, 150, 108, 22);
		this.panel.add(this.lblPassword);
		
		this.txtEnterUsername = new JTextField();
		this.txtEnterUsername.setBounds(190, 105, 153, 28);
		this.panel.add(this.txtEnterUsername);
		this.txtEnterUsername.setColumns(10);
		
		this.txtEnterPassword = new JTextField();
		this.txtEnterPassword.setBounds(190, 149, 153, 28);
		this.panel.add(this.txtEnterPassword);
		this.txtEnterPassword.setColumns(10);
		
		this.btnLogin = new JButton("Login");
		this.btnLogin.setRequestFocusEnabled(false);
		this.btnLogin.setBounds(70, 203, 117, 29);
		this.panel.add(this.btnLogin);
		
		this.btnReset = new JButton("Reset");
		this.btnReset.setRequestFocusEnabled(false);
		this.btnReset.setBounds(207, 203, 117, 29);
		this.panel.add(this.btnReset);
		
		setVisible(true);
	}
	
	public void launchMainWindow(){
		this.frameInit();
		this.left = new JPanel();
		this.left.setBackground(new Color(204, 153, 153));
		this.left.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.left.setPreferredSize(new Dimension(200, 600));
		getContentPane().add(this.left, BorderLayout.WEST);
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
		this.right.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(this.right, BorderLayout.CENTER);
		this.right.setLayout(null);
		
		this.lblTime = new JLabel("02/16/13 8:55 pm");
		this.lblTime.setBounds(459, 6, 135, 16);
		this.right.add(this.lblTime);
		
		this.lblCurrentTime = new JLabel("Current Time:");
		this.lblCurrentTime.setBounds(348, 6, 86, 16);
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
		this.lblAccount.setBounds(20, 6, 68, 16);
		this.Maccount.add(this.lblAccount);
		
		this.lblAccountBalance = new JLabel("Account Balance:");
		this.lblAccountBalance.setBounds(248, 6, 112, 16);
		this.Maccount.add(this.lblAccountBalance);
		
		this.btnDeposit = new JButton("Deposit");
		this.btnDeposit.setBounds(20, 178, 112, 29);
		this.Maccount.add(this.btnDeposit);
		
		this.btnWithdraw = new JButton("Withdraw");

		this.btnWithdraw.setBounds(144, 178, 112, 29);
		this.Maccount.add(this.btnWithdraw);
		
		this.btnViewTransactions = new JButton("View Transactions");
		this.btnViewTransactions.setBounds(268, 178, 150, 29);
		this.Maccount.add(this.btnViewTransactions);
		
		this.Saccount = new JPanel();
		this.Saccount.setLayout(null);
		this.Saccount.setBackground(new Color(204, 153, 153));
		this.Saccount.setBounds(16, 298, 555, 221);
		this.mainDisp.add(this.Saccount);
		
		this.lblAccountS = new JLabel("Account #:");
		this.lblAccountS.setBounds(20, 6, 68, 16);
		this.Saccount.add(this.lblAccountS);
		
		this.btnSellStocks = new JButton("Sell Stocks");
		this.btnSellStocks.setBounds(20, 172, 112, 29);
		this.Saccount.add(this.btnSellStocks);
		
		this.btnBuyStocks = new JButton("Buy Stocks");
		this.btnBuyStocks.setBounds(145, 172, 112, 29);
		this.Saccount.add(this.btnBuyStocks);
		
		this.btnViewTransactionsS = new JButton("View Transactions");
		this.btnViewTransactionsS.setBounds(269, 172, 150, 29);
		this.Saccount.add(this.btnViewTransactionsS);
		
		this.setVisible(true);
	}
}
