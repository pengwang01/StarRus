package com.cs174.starrus.controller;

import com.cs174.starrus.view.IView;
import com.cs174.starrus.view.MainView;

public interface IController {
	
	MainView view = MainView.getView();
	public void setView(IView view);
	public void process(String model);
}
