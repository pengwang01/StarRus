package com.cs174.starrus.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import javax.swing.*;
import javax.swing.border.LineBorder;

import com.cs174.starrus.controller.CustomerReportController;
import com.cs174.starrus.controller.LogoutController;
import com.cs174.starrus.controller.AddInterestController;
import com.cs174.starrus.controller.MonthlyStatementController;
import com.cs174.starrus.model.Customer;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerView extends JPanel implements IView{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//-------------main window components--------------
	private JPanel left;
	private JPanel right;
	private JLabel lblWelcom;
	private JPanel mainDisp;
	private JLabel lblUsername;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JLabel lblUsername_1;
	private JLabel lblUsfield;
	private JLabel lblMyAccountInfo;
	private JLabel lblAge;
	private JLabel lblAgefield;
	private JLabel lblPassword;
	private static ManagerView mView = null;	
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
	private JButton btnLogout;
	private JLabel lblControlPanel;
	private JPanel panel;
	private JButton btnAddInterest;
	private JButton btnCustomerReport;
	private JButton btnDeleteTransactions;
	private JPanel ActiveCustomer_panel;
	private JPanel monthly_panel;
	private JLabel lblUsername_2;
	private JTextField txtInputUsername;
	private JButton btnGenerateMonthlyStatement;
	private JPanel DrugNtax_panel;
	private JButton btnOpenMarket;
	private JButton btnCloseMarket;
	private JButton btnSetNewPrice;
	private JButton btnSetnewdate;
	private JLabel lblMarketOperation;
	private JLabel lblAccountOperateion;
		
	private ManagerView(){
		this.setSize(new Dimension(800, 600));
		this.setPreferredSize(new Dimension(800, 600));
		setLayout(null);
		//setView(new Customer());
	}
	
	public static ManagerView getView(){
		if(mView == null)
			mView = new ManagerView();
		return mView;
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

		
		this.mainDisp = new JPanel();
		this.mainDisp.setBorder(null);
		this.mainDisp.setBounds(0, 31, 588, 517);
		this.right.add(this.mainDisp);
		this.mainDisp.setLayout(null);
		
		this.lblControlPanel = new JLabel("Control Panel");
		this.lblControlPanel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		this.lblControlPanel.setBounds(6, 6, 151, 29);
		this.mainDisp.add(this.lblControlPanel);
		
		this.panel = new JPanel();
		this.panel.setBounds(16, 35, 551, 476);
		this.panel.setBackground(new Color(204, 153, 153));
		this.mainDisp.add(this.panel);
		this.panel.setLayout(null);
		
		this.btnDeleteTransactions = new JButton("Delete Transactions");
		this.btnDeleteTransactions.setBounds(173, 126, 208, 29);
		this.panel.add(this.btnDeleteTransactions);
		
		this.monthly_panel = new JPanel();
		this.monthly_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.monthly_panel.setBounds(6, 214, 539, 109);
		this.monthly_panel.setBackground(new Color(204, 153, 153));
		this.panel.add(this.monthly_panel);
		this.monthly_panel.setLayout(null);
		
		this.lblUsername_2 = new JLabel("Username:");
		this.lblUsername_2.setBounds(34, 17, 92, 16);
		this.monthly_panel.add(this.lblUsername_2);
		
		this.txtInputUsername = new JTextField();
		this.txtInputUsername.setBounds(138, 11, 378, 28);
		this.monthly_panel.add(this.txtInputUsername);
		this.txtInputUsername.setColumns(10);
		
		this.btnCustomerReport = new JButton("Generate Customer Report");
		listeners.associate(this.btnCustomerReport, new CustomerReportController());
		this.btnCustomerReport.setBounds(6, 51, 255, 28);
		this.monthly_panel.add(this.btnCustomerReport);
		
		this.btnGenerateMonthlyStatement = new JButton("Generate Monthly Statement");
		listeners.associate(this.btnGenerateMonthlyStatement, new MonthlyStatementController());
		this.btnGenerateMonthlyStatement.setBounds(278, 51, 255, 28);
		this.monthly_panel.add(this.btnGenerateMonthlyStatement);
		
		this.btnAddInterest = new JButton("Add Interest");
		this.btnAddInterest.setBounds(173, 173, 208, 29);
		this.panel.add(this.btnAddInterest);
		listeners.associate(this.btnAddInterest, new AddInterestController());

		// Tabbed Pages
		
		this.btnOpenMarket = new JButton("Open Market");
		this.btnOpenMarket.setBounds(173, 16, 136, 29);
		this.panel.add(this.btnOpenMarket);
		
		this.btnCloseMarket = new JButton("Close Market");
		this.btnCloseMarket.setBounds(321, 16, 136, 29);
		this.panel.add(this.btnCloseMarket);
		
		this.btnSetNewPrice = new JButton("Set New Price");

		this.btnSetNewPrice.setBounds(173, 57, 136, 29);
		this.panel.add(this.btnSetNewPrice);
		
		this.btnSetnewdate = new JButton("Set New Date");
		this.btnSetnewdate.setBounds(321, 57, 136, 29);
		this.panel.add(this.btnSetnewdate);
		
		this.lblMarketOperation = new JLabel("Market Operation:");
		this.lblMarketOperation.setBounds(6, 21, 155, 16);
		this.panel.add(this.lblMarketOperation);
		
		this.lblAccountOperateion = new JLabel("Account Operateion: ");
		this.lblAccountOperateion.setBounds(6, 131, 155, 16);
		this.panel.add(this.lblAccountOperateion);
		
		this.ActiveCustomer_panel = new JPanel();
		tabbedPane.addTab("Active Customers", null, this.ActiveCustomer_panel, "List of Active Customers");
	
	//
		this.DrugNtax_panel = new JPanel();
		tabbedPane.addTab("DTER", null, this.DrugNtax_panel, "Drg & tax Evasion Report");

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

	public JTextField getTxtInputUsername() {
		return txtInputUsername;
	}

	public void setTxtInputUsername(JTextField txtInputUsername) {
		this.txtInputUsername = txtInputUsername;
	}
}
