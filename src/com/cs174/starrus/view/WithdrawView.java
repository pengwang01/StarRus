package com.cs174.starrus.view;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.cs174.starrus.controller.WithdrawSubmitController;

public class WithdrawView extends JDialog implements IView{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblWithdraw;
	private JTextField txtWithdraw;
	private JButton btnWithdraw;
	private static WithdrawView wdView = null;
	private JLabel lblWarning;
	
	private WithdrawView(){
		this.setLocation(new Point(350, 200));
		this.setSize(new Dimension(280, 140));
		this.setPreferredSize(new Dimension(280, 140));
	    getContentPane().setLayout(null);
		//setView();
	}

	public static WithdrawView getView() {
		if(wdView == null){
			wdView = new WithdrawView();
			wdView.setView();
		}
		return wdView;
	}
	public void setView(){
	    this.lblWithdraw = new JLabel("Amount: ");
	    this.lblWithdraw.setBounds(21, 12, 92, 16);
	    this.getContentPane().add(this.lblWithdraw);
	    
	    this.txtWithdraw = new JTextField();
	    this.txtWithdraw.setBounds(118, 6, 140, 28);
	    //this.txtUsername.setText("username");
	    this.getContentPane().add(this.txtWithdraw);
	    this.txtWithdraw.setColumns(10);
	    
	    this.btnWithdraw= new JButton("Withdraw");
	    this.btnWithdraw.setBounds(76, 83, 117, 29);
	    listeners.associate(this.btnWithdraw, new WithdrawSubmitController());
	    getContentPane().add(this.btnWithdraw);
	    
	    this.lblWarning = new JLabel("");
	    this.lblWarning.setBounds(31, 40, 227, 16);
	    getContentPane().add(this.lblWarning);
	    //this.setVisible(true);
	}
	@Override
	public void present(String model) {
		// TODO Auto-generated method stub
		
	}

	public JTextField getTxtWithdraw() {
		return txtWithdraw;
	}

	public void setTxtDeposit(JTextField txtWithdraw) {
		this.txtWithdraw = txtWithdraw;
	}

	public JLabel getLblWarning() {
		return lblWarning;
	}

	public void setLblWarning(JLabel lblWarning) {
		this.lblWarning = lblWarning;
	}
	
}
