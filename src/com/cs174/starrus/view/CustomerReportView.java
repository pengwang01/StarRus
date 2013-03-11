package com.cs174.starrus.view;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;


public class CustomerReportView extends JDialog implements IView{
	/**
	 * 
	 */
	private static final long serialVersionUID 	= 1L;
	private static CustomerReportView crView 	= null;
	private	Vector<Vector<String>> row_mAccount			= new Vector<Vector<String>>();
	private	Vector<Vector<String>> row_sAccount			= new Vector<Vector<String>>();
	private JLabel lblUsername;
	private JLabel lblUsernameField;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblStockAccountId;
	private JLabel lblStockaccountidfield;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	
	private CustomerReportView(){
		this.setLocation(new Point(350, 200));
		this.setSize(new Dimension(800, 462));
		this.setPreferredSize(new Dimension(800, 400));
	    getContentPane().setLayout(null);
	    
	    this.lblUsername = new JLabel("Username:");
	    this.lblUsername.setBounds(6, 6, 89, 16);
	    getContentPane().add(this.lblUsername);
	    
	    this.lblUsernameField = new JLabel("");
	    this.lblUsernameField.setBounds(107, 6, 188, 16);
	    getContentPane().add(this.lblUsernameField);
	    
	    this.scrollPane = new JScrollPane();
	    this.scrollPane.setBounds(16, 34, 778, 77);
	    getContentPane().add(this.scrollPane);
	    
	    // ------------------ market account table--------------------------
	    Vector<String> col_mAccount = new Vector<String>();
	    col_mAccount.add("Market Account ID");
	    col_mAccount.add("Balance");
	    this.table = new JTable(row_mAccount, col_mAccount);
	    this.table.setPreferredSize(new Dimension(800, 50));
	    this.scrollPane.setViewportView(this.table);
	    
	    this.lblStockAccountId = new JLabel("Stock Account ID: ");
	    this.lblStockAccountId.setBounds(6, 134, 134, 16);
	    getContentPane().add(this.lblStockAccountId);
	    
	    
	    // -----------------stock accunt table------------------------------
	    this.lblStockaccountidfield = new JLabel("StockAccountIDField");
	    this.lblStockaccountidfield.setBounds(170, 134, 171, 16);
	    getContentPane().add(this.lblStockaccountidfield);
	    
	    this.scrollPane_1 = new JScrollPane();
	    this.scrollPane_1.setBounds(16, 162, 778, 256);
	    getContentPane().add(this.scrollPane_1);
	    
	    Vector<String> col_sAccount = new Vector<String>();
	    col_sAccount.add("Symbol");
	    col_sAccount.add("Total Shares");
	    this.table_1 = new JTable(row_sAccount, col_sAccount);
	    this.table_1.setPreferredSize(new Dimension(800, 500));
	    this.scrollPane_1.setViewportView(this.table_1);
	    
	   
	    setView();
	}

	public static CustomerReportView getView() {
		if(crView  == null){
			crView  = new CustomerReportView();
			crView .setView();
		}
		return crView;
	}
	public void setView(){
	   
	}
	@Override
	public void present(String model) {
		// TODO Auto-generated method stub
		
	}

	public Vector<Vector<String>> getRow_mAccount(){
		return row_mAccount;
	}
	
	public Vector<Vector<String>> getRow_sAccount(){
		return row_sAccount;
	}

	
	public JLabel getLblStockaccountidfield() {
		return lblStockaccountidfield;
	}

	public void setLblStockaccountidfield(JLabel lblStockaccountidfield) {
		this.lblStockaccountidfield = lblStockaccountidfield;
	}

	public void updateView(){
		this.setView();
	}
	
}
