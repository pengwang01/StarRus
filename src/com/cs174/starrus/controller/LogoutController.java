package com.cs174.starrus.controller;

import com.cs174.starrus.view.IView;

public class LogoutController implements IController{
	
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(String model) {
		view.loadLoginView();
	}

}
