package com.cs174.starrus.controller;

import java.sql.SQLException;

import com.cs174.starrus.view.Window;

public class RunApp {
	public static void main(String[] args){
		
		DBconnector db = new DBconnector();
		try {
			db.connect();
			db.test();
			db.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Window app = new Window();
		//app.launchLoginWindow();
		
		Window app2 = new Window();
		//app2.launchMainWindow();
	}
}
