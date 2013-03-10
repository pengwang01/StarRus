package com.cs174.starrus.view;

import javax.swing.JFrame;

import com.cs174.starrus.model.Customer;

import java.awt.Point;
import java.awt.Dimension;


@SuppressWarnings("serial")
public class MainView extends JFrame implements IView{
	
	private static MainView view = null;
	
	/*
	 *  set main window properties
	 */
	private MainView(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("StarRus");
		this.setSize(new Dimension(800, 620));
		this.setLocation(new Point(150, 100));
		this.getContentPane().setLayout(null);
	}

	/*
	 *  get instance of the main window
	 */
	public static MainView getView() {
		if(view == null)
			view = new MainView();
		return view;
	}
	
	/*
	 *  set main window to be visible
	 */
	public void displayView() {this.setVisible(true);}
	
	/*
	 * load login view to the main window
	 */
	public void loadLoginView(){
		this.removeAll();
		this.frameInit();							// initialize window
		this.repaint();
		LoginView loginView = LoginView.getView();	// get an instance of login view
		loginView.setView();						// set the default login view
		this.getContentPane().add(loginView);		// add loginView to the main window
		this.displayView();
		
	}
	
	/*
	 * load customer view to the main window
	 */
	public void loadCustomerView(Customer c) {
		this.frameInit();
		CustomerView customerView = CustomerView.getView();
		customerView.setView(c);
		this.getContentPane().add(customerView);
		this.displayView();
	}
	
	/*
	 * load customer view to the main window
	 */
	public void loadManagerView(Customer c) {
		this.frameInit();
		ManagerView managerView = ManagerView.getView();
		managerView.setView(c);
		this.getContentPane().add(managerView);
		this.displayView();
	}
	
	@Override
	public void present(String model) {
		// TODO Auto-generated method stub
		
	}
}
