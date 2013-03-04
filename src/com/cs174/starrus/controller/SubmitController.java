package com.cs174.starrus.controller;

import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.RegView;

public class SubmitController implements IController{
	private RegView regView;
	
	public SubmitController(){
		regView = RegView.getView();
	}
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(String model) {
		// TODO Auto-generated method stub
		
	}

}
