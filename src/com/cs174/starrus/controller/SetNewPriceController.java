package com.cs174.starrus.controller;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.SetNewPriceView;


public class SetNewPriceController implements IController{

	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
	}
	@Override
	public void process(String model) {
		//System.out.println("do some shit after clicking");
		SetNewPriceView snpV= SetNewPriceView.getView();
		//depo.setView();
		snpV.setVisible(true);
	}
}

