package com.cs174.starrus.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import javax.swing.*;
import javax.swing.border.LineBorder;
import com.cs174.starrus.controller.DepositController;
import com.cs174.starrus.controller.LogoutController;
import com.cs174.starrus.controller.MTransactionController;
import com.cs174.starrus.controller.STransactionController;
import com.cs174.starrus.controller.WithdrawController;
import com.cs174.starrus.controller.BuyStockController;
import com.cs174.starrus.controller.SellStockController;
import com.cs174.starrus.model.Customer;
import java.awt.ComponentOrientation;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerView extends JPanel implements IView{
	
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
	private static CustomerView cView = null;	
	private JLabel lblPhone;
	private JLabel lblState;
	private JLabel lblTaxId;
	private JLabel lblEmail;
	private JLabel lblPsdfield;
	private JLabel lblPhonefiled;
	private JLabel lblStatefield;
	private JLabel lblTaxfield;
	private JLabel lblEmailfield;
	private JLabel lblUserLevel;
	private JLabel lblLevelfield;
	private JLabel lblMAccountId;
	private JLabel balancefiled;
	private JLabel lblSAccountId;
	private JButton btnLogout;
		
	private CustomerView(){
		this.setSize(new Dimension(800, 600));
		this.setPreferredSize(new Dimension(800, 600));
		setLayout(null);
		//setView(new Customer());
	}
	
	public static CustomerView getView(){
		if(cView == null)
			cView = new CustomerView();
		return cView;
	}
	
	public void setView(Customer c){
		this.removeAll();
		System.out.println("in customer's setview: " + c.getCname());
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
		this.lblWelcom.setBounds(6, 23, 81, 16);
		this.left.add(this.lblWelcom);
		
		this.lblUsername = new JLabel("name");
		this.lblUsername.setBounds(87, 23, 107, 16);
		this.lblUsername.setText(c.getCname());
		this.left.add(this.lblUsername);
		this.left.setPreferredSize(new Dimension(400, 600));
		
		this.lblUsername_1 = new JLabel("Username: ");
		this.lblUsername_1.setBounds(6, 79, 84, 16);
		this.left.add(this.lblUsername_1);
		
		this.lblUsfield = new JLabel("pengwang");
		this.lblUsfield.setText(c.getUsername());
		this.lblUsfield.setBounds(87, 79, 107, 16);
		this.left.add(this.lblUsfield);
		
		this.lblMyAccountInfo = new JLabel("My Account Infomation : ");
		this.lblMyAccountInfo.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		this.lblMyAccountInfo.setBounds(6, 51, 178, 16);
		this.left.add(this.lblMyAccountInfo);
		
		this.lblAge = new JLabel("Age:");
		this.lblAge.setBounds(6, 107, 84, 16);
		this.left.add(this.lblAge);
		
		this.lblAgefield = new JLabel("100");
		this.lblAgefield.setText(Integer.toString(c.getAge()));
		this.lblAgefield.setBounds(87, 107, 107, 16);
		this.left.add(this.lblAgefield);
		
		this.lblPassword = new JLabel("Password:");
		this.lblPassword.setBounds(6, 135, 84, 16);
		this.left.add(this.lblPassword);
		
		this.lblPhone = new JLabel("Phone #:");
		this.lblPhone.setBounds(6, 163, 84, 16);
		this.left.add(this.lblPhone);
		
		this.lblState = new JLabel("State:");
		this.lblState.setBounds(6, 191, 84, 16);
		this.left.add(this.lblState);
		
		this.lblTaxId = new JLabel("Tax ID:");
		this.lblTaxId.setBounds(6, 219, 84, 16);
		this.left.add(this.lblTaxId);
		
		this.lblEmail = new JLabel("Email:");
		this.lblEmail.setBounds(6, 247, 84, 16);
		this.left.add(this.lblEmail);
		
		this.lblPsdfield = new JLabel("psdfield");
		this.lblPsdfield.setText(c.getPsd());
		this.lblPsdfield.setBounds(87, 135, 107, 16);
		this.left.add(this.lblPsdfield);
		
		this.lblPhonefiled = new JLabel("phonefiled");
		this.lblPhonefiled.setText(c.getPhone_num());
		this.lblPhonefiled.setBounds(87, 163, 107, 16);
		this.left.add(this.lblPhonefiled);
		
		this.lblStatefield = new JLabel("statefield");
		this.lblStatefield.setText(c.getState());
		this.lblStatefield.setBounds(87, 191, 107, 16);
		this.left.add(this.lblStatefield);
		
		this.lblTaxfield = new JLabel("taxfield");
		this.lblTaxfield.setText(Integer.toString(c.getTax_id()));
		this.lblTaxfield.setBounds(87, 219, 107, 16);
		this.left.add(this.lblTaxfield);
		
		this.lblEmailfield = new JLabel("emailfield");
		this.lblEmailfield.setText(c.getEmail());
		this.lblEmailfield.setBounds(16, 275, 178, 16);
		this.left.add(this.lblEmailfield);
		
		this.lblUserLevel = new JLabel("User Level:");
		this.lblUserLevel.setBounds(6, 303, 81, 16);
		this.left.add(this.lblUserLevel);
		
		this.lblLevelfield = new JLabel("levelfield");
		this.lblLevelfield.setText(Integer.toString(c.getClevel()));
		this.lblLevelfield.setBounds(87, 303, 107, 16);
		this.left.add(this.lblLevelfield);
		
		this.btnLogout = new JButton("Logout");
		listeners.associate(this.btnLogout, new LogoutController());
		this.btnLogout.setBounds(16, 545, 168, 29);
		this.left.add(this.btnLogout);
		//------------------------------- end of left panel --------------------------------
		
		//------------------------------ tabbed pane -------------------------------------
		this.tabbedPane.removeAll();
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
		
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
		this.lblTime = new JLabel();
		this.lblTime.setText(strDate);
		this.lblTime.setBounds(408, 6, 165, 16);
		this.right.add(this.lblTime);
		
		this.lblCurrentTime = new JLabel("Current Time:");
		this.lblCurrentTime.setBounds(282, 6, 99, 16);
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
		listeners.associate(this.btnDeposit, new DepositController());
		this.Maccount.add(this.btnDeposit);
		
		this.btnWithdraw = new JButton("Withdraw");
		listeners.associate(this.btnWithdraw, new WithdrawController());
		this.btnWithdraw.setBounds(144, 34, 112, 29);
		this.Maccount.add(this.btnWithdraw);
		
		this.btnViewTransactions = new JButton("View Transactions");
		listeners.associate(this.btnViewTransactions, new MTransactionController());
		this.btnViewTransactions.setBounds(268, 34, 155, 29);
		this.Maccount.add(this.btnViewTransactions);
		
		this.lblMAccountId = new JLabel("accountIDfiled");
		this.lblMAccountId.setText(Integer.toString(c.getM_account_id()));
		System.out.println(c.getM_account_id());
		this.lblMAccountId.setBounds(119, 6, 117, 16);
		this.Maccount.add(this.lblMAccountId);
		
		this.balancefiled = new JLabel("New label");
		this.balancefiled.setText(Float.toString(c.getBalance()));
		System.out.println(c.getBalance());
		this.balancefiled.setBounds(392, 6, 132, 16);
		this.Maccount.add(this.balancefiled);
		
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
		listeners.associate(this.btnSellStocks, new SellStockController());
		this.Saccount.add(this.btnSellStocks);
		
		this.btnBuyStocks = new JButton("Buy Stocks");
		this.btnBuyStocks.setBounds(144, 334, 112, 29);
		listeners.associate(this.btnBuyStocks, new BuyStockController());
		this.Saccount.add(this.btnBuyStocks);
		
		this.btnViewTransactionsS = new JButton("View Transactions");
		listeners.associate(this.btnViewTransactionsS, new STransactionController());
		this.btnViewTransactionsS.setBounds(268, 334, 155, 29);
		this.Saccount.add(this.btnViewTransactionsS);
		
		this.dtrpnListOfStocks = new JEditorPane();
		this.dtrpnListOfStocks.setText("List of stocks that I currently have");
		this.dtrpnListOfStocks.setBounds(30, 34, 505, 288);
		this.Saccount.add(this.dtrpnListOfStocks);
		
		this.lblSAccountId = new JLabel("New label");
		this.lblSAccountId.setText(Integer.toString(c.getS_account_id()));
		this.lblSAccountId.setBounds(119, 6, 61, 16);
		this.Saccount.add(this.lblSAccountId);
		
		
		this.stockPanel = new JPanel();
		tabbedPane.addTab("View Stocks", null, this.stockPanel, "View All Available Stocks");
		
		
		this.moviePanel = new JPanel();
		tabbedPane.addTab("View Movies", null, this.moviePanel, "View All Available Movies");
	}

	@Override
	public void present(String model) {
		// TODO Auto-generated method stub
	}

	public JLabel getLblAgefield() {
		return lblAgefield;
	}

	public void setLblAgefield(JLabel lblAgefield) {
		this.lblAgefield = lblAgefield;
	}

	public JLabel getLblPsdfield() {
		return lblPsdfield;
	}

	public void setLblPsdfield(JLabel lblPsdfield) {
		this.lblPsdfield = lblPsdfield;
	}

	public JLabel getLblPhonefiled() {
		return lblPhonefiled;
	}

	public void setLblPhonefiled(JLabel lblPhonefiled) {
		this.lblPhonefiled = lblPhonefiled;
	}

	public JLabel getLblStatefield() {
		return lblStatefield;
	}

	public void setLblStatefield(JLabel lblStatefield) {
		this.lblStatefield = lblStatefield;
	}

	public JLabel getLblEmailfield() {
		return lblEmailfield;
	}

	public void setLblEmailfield(JLabel lblEmailfield) {
		this.lblEmailfield = lblEmailfield;
	}

	public JLabel getLblLevelfield() {
		return lblLevelfield;
	}

	public void setLblLevelfield(JLabel lblLevelfield) {
		this.lblLevelfield = lblLevelfield;
	}

	public JLabel getBalancefiled() {
		return balancefiled;
	}

	public void setBalancefiled(JLabel balancefiled) {
		this.balancefiled = balancefiled;
	}
	
}
