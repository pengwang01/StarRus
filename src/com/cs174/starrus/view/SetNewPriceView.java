package com.cs174.starrus.view;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.cs174.starrus.controller.BuyStockSubmitController;

public class SetNewPriceView extends JDialog implements IView{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTicker;
	private JTextField txtTicker;
	private JButton btnTicker;
	private static SetNewPriceView snpView = null;
	private JLabel lblWarning;
	private JLabel lblPrice;
	private JTextField txtPrice;
	
	private SetNewPriceView(){
		this.setLocation(new Point(350, 200));
		this.setSize(new Dimension(280, 170));
		this.setPreferredSize(new Dimension(280, 170));
	    getContentPane().setLayout(null);
		//setView();
	}

	public static SetNewPriceView getView() {
		if(snpView == null){
			snpView = new SetNewPriceView();
			snpView.setView();
		}
		return snpView;
	}
	public void setView(){
	    this.lblTicker = new JLabel("Ticker: ");
	    this.lblTicker.setBounds(21, 12, 92, 16);
	    this.getContentPane().add(this.lblTicker);
	    
	    this.txtTicker = new JTextField();
	    this.txtTicker.setBounds(118, 6, 140, 28);
	    this.getContentPane().add(this.txtTicker);
	    this.txtTicker.setColumns(10);
	    
	    this.btnTicker = new JButton("Set New Price");
	    this.btnTicker.setBounds(75, 99, 117, 29);
	    listeners.associate(this.btnTicker, new BuyStockSubmitController());
	    getContentPane().add(this.btnTicker);
	    
	    this.lblWarning = new JLabel("");
	    this.lblWarning.setBounds(6, 71, 268, 16);
	    getContentPane().add(this.lblWarning);
	    
	    this.lblPrice = new JLabel("Price:");
	    this.lblPrice.setBounds(21, 40, 92, 16);
	    getContentPane().add(this.lblPrice);
	    
	    this.txtPrice = new JTextField();
	    this.txtPrice.setBounds(118, 34, 140, 28);
	    getContentPane().add(this.txtPrice);
	    this.txtPrice.setColumns(10);
	    //this.setVisible(true);
	}
	@Override
	public void present(String model) {
		// TODO Auto-generated method stub
		
	}

	public JTextField getTxtTicker() {
		return txtTicker;
	}

	public void setTxtTicker(JTextField txtTicker) {
		this.txtTicker = txtTicker;
	}

	public JLabel getLblWarning() {
		return lblWarning;
	}

	public void setLblWarning(String text) {
		lblWarning.setText(text);
	}

	public JTextField getTxtQuantity(){
		return txtPrice;
	}

	
}
