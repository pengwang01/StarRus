package com.cs174.starrus.view;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;


public class MTransactionView extends JDialog implements IView{
	/**
	 * 
	 */
	private static final long serialVersionUID 	= 1L;
	private static MTransactionView mtsView 	= null;
	private JScrollPane scrollPane;
	private JTable table;
	private	Vector<Vector<String>> row			= new Vector<Vector<String>>();
	
	private MTransactionView(){
		this.setLocation(new Point(350, 200));
		this.setSize(new Dimension(500, 500));
		this.setPreferredSize(new Dimension(500, 500));
	    getContentPane().setLayout(null);
	    setView();
	}

	public static MTransactionView getView() {
		if(mtsView  == null){
			mtsView  = new MTransactionView();
			mtsView .setView();
		}
		return mtsView;
	}
	public void setView(){
	    Vector<String> col = new Vector<String>();
	    col.add("ID");
	    col.add("Date");
	    col.add("Type");
	    col.add("Amount");
	    col.add("Balance");
	    this.scrollPane = new JScrollPane();
	    this.scrollPane.setBounds(6, 6, 488, 466);
	    getContentPane().add(this.scrollPane);
	    
	    this.table = new JTable(row, col){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
	    this.table.setPreferredSize(new Dimension(500, 1000));
	    this.scrollPane.setViewportView(this.table);
	    //this.setVisible(true);
	}
	@Override
	public void present(String model) {
		// TODO Auto-generated method stub
		
	}

	public Vector<Vector<String>> getRow(){
		return row;
	}

	public void updateView(){
		this.setView();
	}
}
