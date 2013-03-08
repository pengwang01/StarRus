package com.cs174.starrus.view;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.cs174.starrus.controller.DepositSubmitController;

public class DepositView extends JDialog implements IView{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblDeposit;
	private JTextField txtDeposit;
	private JButton btnDeposit;
	private static DepositView depView = null;
	private JLabel lblWarning;
	
	private DepositView(){
		this.setLocation(new Point(350, 200));
		this.setSize(new Dimension(280, 120));
		this.setPreferredSize(new Dimension(280, 120));
	    getContentPane().setLayout(null);
		//setView();
	}

	public static DepositView getView() {
		if(depView == null){
			depView = new DepositView();
			depView.setView();
		}
		return depView;
	}
	public void setView(){
	    this.lblDeposit = new JLabel("Amount: ");
	    this.lblDeposit.setBounds(21, 12, 92, 16);
	    this.getContentPane().add(this.lblDeposit);
	    
	    this.txtDeposit = new JTextField();
	    this.txtDeposit.setBounds(118, 6, 140, 28);
	    this.getContentPane().add(this.txtDeposit);
	    this.txtDeposit.setColumns(10);
	    
	    this.btnDeposit = new JButton("Deposit");
	    this.btnDeposit.setBounds(76, 63, 117, 29);
	    listeners.associate(this.btnDeposit, new DepositSubmitController());
	    getContentPane().add(this.btnDeposit);
	    
	    this.lblWarning = new JLabel("");
	    this.lblWarning.setBounds(6, 40, 268, 16);
	    getContentPane().add(this.lblWarning);
	    //this.setVisible(true);
	}
	@Override
	public void present(String model) {
		// TODO Auto-generated method stub
		
	}

	public JTextField getTxtDeposit() {
		return txtDeposit;
	}

	public void setTxtDeposit(JTextField txtDeposit) {
		this.txtDeposit = txtDeposit;
	}

	public JLabel getLblWarning() {
		return lblWarning;
	}

	public void setLblWarning(JLabel lblWarning) {
		this.lblWarning = lblWarning;
	}
	
}
