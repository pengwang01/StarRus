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
import com.cs174.starrus.controller.DeleteTransactionController;
import com.cs174.starrus.controller.SetNewDateController;
import com.cs174.starrus.controller.SetNewPriceController;
import com.cs174.starrus.controller.CloseMarketController;
import com.cs174.starrus.controller.OpenMarketController;
import com.cs174.starrus.model.Customer;
import java.awt.ComponentOrientation;
import java.util.Vector;

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
	private JScrollPane scrollPane_active;
	private JScrollPane scrollPane_dter;
	Vector<Vector<String>> row_active = new Vector<Vector<String>>();
	Vector<Vector<String>> row_dter = new Vector<Vector<String>>();
	private JTable table_active;
	private JTable table_dter;
	
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
		this.lblUsername.setBounds(75, 23, 125, 16);
		this.lblUsername.setText(c.getCname());
		this.left.add(this.lblUsername);
		this.left.setPreferredSize(new Dimension(400, 600));
		
		this.lblUsername_1 = new JLabel("Username: ");
		this.lblUsername_1.setBounds(6, 79, 84, 16);
		this.left.add(this.lblUsername_1);
		
		this.lblUsfield = new JLabel("pengwang");
		this.lblUsfield.setText(c.getUsername());
		this.lblUsfield.setBounds(16, 107, 168, 16);
		this.left.add(this.lblUsfield);
		
		this.lblMyAccountInfo = new JLabel("My Account Infomation : ");
		this.lblMyAccountInfo.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		this.lblMyAccountInfo.setBounds(6, 51, 263, 16);
		this.left.add(this.lblMyAccountInfo);
		
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
		this.lblPhonefiled.setBounds(87, 163, 168, 16);
		this.left.add(this.lblPhonefiled);
		
		this.lblStatefield = new JLabel("statefield");
		this.lblStatefield.setText(c.getState());
		this.lblStatefield.setBounds(87, 191, 107, 16);
		this.left.add(this.lblStatefield);
		
		this.lblTaxfield = new JLabel("taxfield");
		this.lblTaxfield.setText(c.getTax_id());
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
		listeners.associate(this.btnDeleteTransactions, new DeleteTransactionController());
		
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
		listeners.associate(this.btnOpenMarket, new OpenMarketController());

		
		this.btnCloseMarket = new JButton("Close Market");
		this.btnCloseMarket.setBounds(321, 16, 136, 29);
		listeners.associate(this.btnCloseMarket, new CloseMarketController());
		this.panel.add(this.btnCloseMarket);
		
		this.btnSetNewPrice = new JButton("Set New Price");
		this.btnSetNewPrice.setBounds(173, 57, 136, 29);
		listeners.associate(this.btnSetNewPrice, new SetNewPriceController());
		this.panel.add(this.btnSetNewPrice);
		
		this.btnSetnewdate = new JButton("Set New Date");
		this.btnSetnewdate.setBounds(321, 57, 136, 29);
		listeners.associate(this.btnSetnewdate, new SetNewDateController());
		this.panel.add(this.btnSetnewdate);
		
		this.lblMarketOperation = new JLabel("Market Operation:");
		this.lblMarketOperation.setBounds(6, 21, 155, 16);
		this.panel.add(this.lblMarketOperation);
		
		this.lblAccountOperateion = new JLabel("Account Operation: ");
		this.lblAccountOperateion.setBounds(6, 131, 155, 16);
		this.panel.add(this.lblAccountOperateion);
		
		this.ActiveCustomer_panel = new JPanel();
		this.scrollPane_active = new JScrollPane();
		tabbedPane.addTab("Active Customers", null, this.ActiveCustomer_panel, "List of Active Customers");
		this.ActiveCustomer_panel.setLayout(null);
		this.scrollPane_active.setBounds(6, 6, 567, 542);
		
		
		//making table col and row
		Vector<String> col_active = new Vector<String>();
		col_active.add("Username");
		this.ActiveCustomer_panel.add(this.scrollPane_active);
		this.table_active = new JTable(row_active, col_active){
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int col){
				return false;
			}

		};
		this.scrollPane_active.setViewportView(this.table_active);
		this.table_active.setPreferredSize(new Dimension(800, 500));
		
		//-----------------DTER ---------------------------------------------
		this.DrugNtax_panel = new JPanel();
		this.scrollPane_dter = new JScrollPane();
		tabbedPane.addTab("DTER", null, this.DrugNtax_panel, "Drg & tax Evasion Report");
		this.DrugNtax_panel.setLayout(null);
		this.scrollPane_dter.setBounds(6, 6, 567, 542);
		Vector<String> col_dter = new Vector<String>();
		col_dter.add("Username");
		col_dter.add("Name");
		col_dter.add("State");
		this.DrugNtax_panel.add(this.scrollPane_dter);
		this.table_dter = new JTable(row_dter, col_dter){
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int col){
				return false;
			}

		};
		this.scrollPane_dter.setViewportView(this.table_dter);
		this.table_dter.setPreferredSize(new Dimension(800, 500));
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

	public Vector<Vector<String>> getRow_active() {
		return row_active;
	}

	public void setRow_active(Vector<Vector<String>> row_active) {
		this.row_active = row_active;
	}

	public Vector<Vector<String>> getRow_Dter() {
		return this.row_dter;
	}

}
