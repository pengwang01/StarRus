package com.cs174.starrus.controller;
import com.cs174.starrus.view.IView;
import com.cs174.starrus.model.SysDate;
import com.cs174.starrus.view.SetNewPriceView;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Calendar;



public class OpenMarketController implements IController{
	private boolean 	DEBUG		= true;
	private SysDate		sD			= SysDate.getSysDate();
	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
	}
	@Override
	public void process(String model) {
		try{
			Calendar c = Calendar.getInstance();
			c.setTime(sD.getSysDate().getDateObject());
			c.add(Calendar.DATE,1);
			Date newDate	= c.getTime();
			if(DEBUG == true){
				SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yy");
				System.out.println("OPENNING NEW MARKET");
				System.out.println("TODAY IS: " + format.format(newDate));
				
			}
			sD.setDate(newDate);
									
		}catch (Exception e){
			System.out.println("SQLException in OpenMarketController");
			e.printStackTrace();
		}
	}
}

