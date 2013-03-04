package com.cs174.starrus.view;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.cs174.starrus.controller.SubmitController;

public class RegView extends JDialog implements IView{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblUsername;
	private JTextField txtUsername;
	private JLabel lblPassword;
	private JTextField txtPassword;
	private JLabel lblName;
	private JTextField txtName;
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
	
	private RegView(){
	}

	public static RegView getView() {
		if(regView == null)
			regView = new RegView();
		return regView;
	}
	public void setView(){
		setLocation(new Point(350, 200));
		this.setSize(new Dimension(280, 280));
		this.setPreferredSize(new Dimension(280, 280));
	    getContentPane().setLayout(null);
	    
	    this.lblUsername = new JLabel("Username:");
	    this.lblUsername.setBounds(22, 6, 89, 16);
	    this.getContentPane().add(this.lblUsername);
	    
	    this.txtUsername = new JTextField();
	    this.txtUsername.setBounds(123, 0, 134, 28);
	    //this.txtUsername.setText("username");
	    this.getContentPane().add(this.txtUsername);
	    this.txtUsername.setColumns(10);
	    
	    this.lblPassword = new JLabel("Password:");
	    this.lblPassword.setBounds(22, 34, 89, 16);
	    this.getContentPane().add(this.lblPassword);
	    
	    this.txtPassword = new JTextField();
	    this.txtPassword.setBounds(123, 28, 134, 28);
	    //this.txtPassword.setText("password");
	    this.getContentPane().add(this.txtPassword);
	    this.txtPassword.setColumns(10);
	    
	    this.lblName = new JLabel("Name: ");
	    this.lblName.setBounds(22, 62, 89, 16);
	    this.getContentPane().add(this.lblName);
	    
	    this.txtName = new JTextField();
	    this.txtName.setBounds(123, 56, 134, 28);
	    //this.txtName.setText("name");
	    this.getContentPane().add(this.txtName);
	    this.txtName.setColumns(10);
	    
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
	    this.btnSubmit.setBounds(79, 212, 117, 29);
	    listeners.associate(this.btnSubmit, new SubmitController());
	    getContentPane().add(this.btnSubmit);
	    this.setVisible(true);
	}
	@Override
	public void present(String model) {
		// TODO Auto-generated method stub
		
	}
}
