package com.cs174.starrus.view;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.cs174.starrus.controller.SetNewDateSubmitController;

public class SetNewDateView extends JDialog implements IView{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblDate;
	private JTextField txtDate;
	private JButton btnSetDate;
	private static SetNewDateView sndView = null;
	private JLabel lblWarning;
	
	private SetNewDateView(){
		this.setLocation(new Point(350, 200));
		this.setSize(new Dimension(280, 160));
		this.setPreferredSize(new Dimension(280, 160));
	    getContentPane().setLayout(null);
		//setView();
	}

	public static SetNewDateView getView() {
		if(sndView == null){
			sndView = new SetNewDateView();
			sndView.setView();
		}
		return sndView;
	}
	public void setView(){
	    this.lblDate = new JLabel("New Date: ");
	    this.lblDate.setBounds(21, 12, 92, 16);
	    this.getContentPane().add(this.lblDate);
	    
	    this.txtDate = new JTextField();
	    this.txtDate.setBounds(118, 6, 140, 28);
	    this.getContentPane().add(this.txtDate);
	    this.txtDate.setColumns(10);
	    
	    this.btnSetDate = new JButton("Set New Date");
	    this.btnSetDate.setBounds(42, 86, 196, 29);
	    listeners.associate(this.btnSetDate, new SetNewDateSubmitController());
	    getContentPane().add(this.btnSetDate);
	    
	    this.lblWarning = new JLabel("");
	    this.lblWarning.setBounds(6, 46, 268, 16);
	    getContentPane().add(this.lblWarning);

	}
	@Override
	public void present(String model) {
		// TODO Auto-generated method stub
		
	}

	public JTextField getTxtDate() {
		return txtDate;
	}

	public void setTxtDate(JTextField txtDate) {
		this.txtDate = txtDate;
	}

	public JLabel getLblWarning() {
		return lblWarning;
	}

	public void setLblWarning(String text) {
		lblWarning.setText(text);
	}
	
}
