package com.cs174.starrus.controller;

import com.cs174.starrus.view.IView;

public interface IController {
	public void setView(IView view);
	public void process(String model);
}
