package com.cs174.starrus.view;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.cs174.starrus.controller.RegSubmitController;

public class RegView extends JDialog implements IView{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblUsername;
	private JTextField txtUsername;
	private JLabel lblPassword;
	private JTextField txtPassword;
	private JLabel lblCName;
	private JTextField txtCName;
	private JLabel lblState;
	private JTextField txtState;
	private JLabel lblPhone;
	private JTextField txtPhone;
	private JLabel lblTaxId;
	private JTextField txtTaxid;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JButton btnSubmit;
	private static RegView regView = null;
//	private JLabel lblAge;
//	private JTextField txtAge;
	private JLabel lblWarning;
	
	private RegView(){
		//setView();
	}

	public static RegView getView() {
		if(regView == null)
			regView = new RegView();
		return regView;
	}
	public void setView(){
		this.getContentPane().removeAll();
		setLocation(new Point(350, 200));
		this.setSize(new Dimension(280, 340));
		this.setPreferredSize(new Dimension(280, 340));
	    getContentPane().setLayout(null);
	    
	    this.lblUsername = new JLabel("Username:");
	    this.lblUsername.setBounds(22, 6, 89, 16);
	    this.getContentPane().add(this.lblUsername);
	    
	    this.txtUsername = new JTextField();
	    this.txtUsername.setBounds(123, 0, 134, 28);
	    //this.txtUsername.setText("username");
	    this.getContentPane().add(this.txtUsername);
	    this.txtUsername.setColumns(10);
	    this.txtUsername = new JTextField();
	    
	    this.lblPassword = new JLabel("Password:");
	    this.lblPassword.setBounds(22, 34, 89, 16);
	    this.getContentPane().add(this.lblPassword);
	    
	    this.txtPassword = new JTextField();
	    this.txtPassword.setBounds(123, 28, 134, 28);
	    //this.txtPassword.setText("password");
	    this.getContentPane().add(this.txtPassword);
	    this.txtPassword.setColumns(10);
	    
	    this.lblCName = new JLabel("Name: ");
	    this.lblCName.setBounds(22, 62, 89, 16);
	    this.getContentPane().add(this.lblCName);
	    
	    this.txtCName = new JTextField();
	    this.txtCName.setBounds(123, 56, 134, 28);
	    //this.txtCName.setText("name");
	    this.getContentPane().add(this.txtCName);
	    this.txtCName.setColumns(10);
	    
	    this.lblState = new JLabel("State: ");
	    this.lblState.setBounds(22, 90, 89, 16);
	    this.getContentPane().add(this.lblState);
	    
	    this.txtState = new JTextField();
	    this.txtState.setBounds(123, 84, 134, 28);
	    //this.txtState.setText("state");
	    this.getContentPane().add(this.txtState);
	    this.txtState.setColumns(10);
	    
	    this.lblPhone = new JLabel("Phone #");
	    this.lblPhone.setBounds(22, 118, 89, 16);
	    this.getContentPane().add(this.lblPhone);
	    
	    this.txtPhone = new JTextField();
	    this.txtPhone.setBounds(123, 112, 134, 28);
	    //this.txtPhone.setText("phone #");
	    this.getContentPane().add(this.txtPhone);
	    this.txtPhone.setColumns(10);
	    
	    this.lblTaxId = new JLabel("Tax ID:");
	    this.lblTaxId.setBounds(22, 146, 89, 16);
	    getContentPane().add(this.lblTaxId);
	    
	    this.txtTaxid = new JTextField();
	    //this.txtTaxid.setText("taxid");
	    this.txtTaxid.setBounds(123, 140, 134, 28);
	    getContentPane().add(this.txtTaxid);
	    this.txtTaxid.setColumns(10);
	    
	    this.lblEmail = new JLabel("Email:");
	    this.lblEmail.setBounds(22, 174, 89, 16);
	    getContentPane().add(this.lblEmail);
	    
	    this.txtEmail = new JTextField();
	    //this.txtEmail.setText("email");
	    this.txtEmail.setBounds(123, 168, 134, 28);
	    getContentPane().add(this.txtEmail);
	    this.txtEmail.setColumns(10);
	    
	    this.btnSubmit = new JButton("Submit");
	    this.btnSubmit.setBounds(77, 264, 117, 29);
	    listeners.associate(this.btnSubmit, new RegSubmitController());
	    getContentPane().add(this.btnSubmit);
	    
/*	    this.lblAge = new JLabel("Age:");
	    this.lblAge.setBounds(22, 202, 61, 16);
	    getContentPane().add(this.lblAge);
	    
	    this.txtAge = new JTextField();
	    this.txtAge.setBounds(123, 196, 134, 28);
	    getContentPane().add(this.txtAge);
	    this.txtAge.setColumns(10);
*/
	    
	    this.lblWarning = new JLabel("");
	    this.lblWarning.setBounds(22, 236, 235, 16);
	    getContentPane().add(this.lblWarning);
	    this.setVisible(true);
	}
	@Override
	public void present(String model) {
		// TODO Auto-generated method stub
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public void setTxtUsername(JTextField txtUsername) {
		this.txtUsername = txtUsername;
	}

	public JTextField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JTextField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JTextField getTxtCName() {
		return txtCName;
	}

	public void setTxtCName(JTextField txtName) {
		this.txtCName = txtName;
	}

	public JTextField getTxtState() {
		return txtState;
	}

	public void setTxtState(JTextField txtState) {
		this.txtState = txtState;
	}

	public JTextField getTxtPhone() {
		return txtPhone;
	}

	public void setTxtPhone(JTextField txtPhone) {
		this.txtPhone = txtPhone;
	}

	public JTextField getTxtTaxid() {
		return txtTaxid;
	}

	public void setTxtTaxid(JTextField txtTaxid) {
		this.txtTaxid = txtTaxid;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}
/*
	public JTextField getTxtAge() {
		return txtAge;
	}

	public void setTxtAge(JTextField txtAge) {
		this.txtAge = txtAge;
	}
*/

	public JLabel getLblWarning() {
		return lblWarning;
	}

	public void setLblWarning(JLabel lblWarning) {
		this.lblWarning = lblWarning;
	}
	
}
