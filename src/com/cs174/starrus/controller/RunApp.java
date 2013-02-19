package com.cs174.starrus.controller;

import com.cs174.starrus.view.Window;

public class RunApp {
	public static void main(String[] args){
		Window app = new Window();
		app.launchLoginWindow();
		
		Window app2 = new Window();
		app2.launchMainWindow();
	}
}
