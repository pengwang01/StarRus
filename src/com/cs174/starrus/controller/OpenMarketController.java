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
			Date newDate	= sD.getSysDate().getDateObject().plusDays(1);
			sD.setDateStr(newDate);
									
		}catch (Exception e){
			System.out.println("SQLException in OpenMarketController");
			e.printStackTrace();
		}
	}
}

