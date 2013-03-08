package com.cs174.starrus.controller;

import com.cs174.starrus.view.IView;

public class RunApp implements IController{
	
	public RunApp(){
		super();
	}
	public static void main(String[] args){
		view.loadLoginView();
	}

	@Override
	public void setView(IView view) {
	}

	@Override
	public void process(String model) {
	}
}
