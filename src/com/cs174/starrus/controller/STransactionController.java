package com.cs174.starrus.controller;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.STransactionView;


public class STransactionController implements IController{

	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
	}
	@Override
	public void process(String model) {
		//System.out.println("do some shit after clicking");
		STransactionView stsV = STransactionView.getView();
		//depo.setView();
		stsV.setVisible(true);
	}
}

