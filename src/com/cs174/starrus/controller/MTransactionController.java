package com.cs174.starrus.controller;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.MTransactionView;


public class MTransactionController implements IController{

	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
	}
	@Override
	public void process(String model) {
		//System.out.println("do some shit after clicking");
		MTransactionView mtsV = MTransactionView.getView();
		//depo.setView();
		mtsV.setVisible(true);
	}
}

