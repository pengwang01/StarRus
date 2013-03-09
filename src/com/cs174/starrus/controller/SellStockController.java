package com.cs174.starrus.controller;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.SellStockView;


public class SellStockController implements IController{

	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
	}
	@Override
	public void process(String model) {
		//System.out.println("do some shit after clicking");
		SellStockView ssV= SellStockView.getView();
		//depo.setView();
		ssV.setVisible(true);
	}
}

