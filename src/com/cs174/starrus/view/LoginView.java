package com.cs174.starrus.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import com.cs174.starrus.controller.ButtonListener;
import com.cs174.starrus.controller.IController;
import com.cs174.starrus.controller.LoginController;

import java.awt.FlowLayout;

public class LoginView extends JPanel implements IView{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//------------login window components-------------
	private JLabel lblUserLogin;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtEnterUsername;
	private JTextField txtEnterPassword;
	private JButton btnLogin;
	private JButton btnRegister;
	private JPanel panel;

	public LoginView(){
		this.setSize(new Dimension(800, 600));
		this.setPreferredSize(new Dimension(800, 600));
		setLayout(null);
		this.setView();
	}
	
	@Override
	public void present(String model) {
		// TODO Auto-generated method stub
	}
	
	public void setView(){
		this.panel = new JPanel();
		this.panel.setBackground(new Color(204, 153, 153));
		this.panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.panel.setLocation(new Point(200, 150));
		this.panel.setLocation(200, 150);
		this.panel.setSize(new Dimension(400, 300));
		this.panel.setPreferredSize(new Dimension(400, 300));
		this.add(panel);
		this.panel.setLayout(null);
		
		this.lblUserLogin = new JLabel("User Login");
		this.lblUserLogin.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		this.lblUserLogin.setBounds(120, 31, 150, 31);
		this.panel.add(this.lblUserLogin);
		
		this.lblUsername = new JLabel("Username:");
		this.lblUsername.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		this.lblUsername.setBounds(52, 91, 116, 22);
		this.panel.add(this.lblUsername);
		
		this.lblPassword = new JLabel("Password:");
		this.lblPassword.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		this.lblPassword.setBounds(52, 155, 116, 22);
		this.panel.add(this.lblPassword);
		
		this.txtEnterUsername = new JTextField();
		this.txtEnterUsername.setBounds(201, 90, 145, 28);
		this.panel.add(this.txtEnterUsername);
		this.txtEnterUsername.setColumns(10);
		
		this.txtEnterPassword = new JTextField();
		this.txtEnterPassword.setBounds(201, 154, 145, 28);
		this.panel.add(this.txtEnterPassword);
		this.txtEnterPassword.setColumns(10);
		
		this.btnLogin = new JButton("Login");
		this.btnLogin.setRequestFocusEnabled(false);
		this.btnLogin.setBounds(208, 233, 105, 29);
		
		//associate a login listener with the login button
		IController loginCon = new LoginController();
		listeners.associate(this.btnLogin, loginCon);
		
		this.panel.add(this.btnLogin);
		
		this.btnRegister = new JButton("Register");
		this.btnRegister.setRequestFocusEnabled(false);
		this.btnRegister.setBounds(88, 233, 105, 29);
		this.panel.add(this.btnRegister);
	}

}
