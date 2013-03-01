package com.cs174.starrus.controller;

import java.sql.SQLException;

import com.cs174.starrus.view.View;

public class RunApp {
	public static void main(String[] args){
		
		//test DB connection
		DBconnector db = new DBconnector();
		try {
			db.connect();
			db.test();
			db.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//test GUI
		//View view = View.getWindow();
		//view.loadMainView();
		//view.loadLoginView();
	}
}
