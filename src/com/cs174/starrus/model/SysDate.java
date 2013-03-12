package com.cs174.starrus.model;

import java.lang.String;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SysDate{
	private static SysDate	SysDate = null;
	private String 			dateStr = "";

	public SysDate(String date){
		this.dateStr=date;
	}

	public String getDateStr(){
		return this.dateStr;
	}

	public void setDateStr(String date){
		this.dateStr=date;
	}

	public static SysDate getSysDate(){
		if(SysDate == null){
			DateFormat 	format	= new SimpleDateFormat("dd-MMM-yy");
			Date 		today	= new Date();
			String 		dateStr	= format.format(today);
			
			SysDate = new SysDate(dateStr);
		}
		return SysDate;
	}
	public static void setSysDate(SysDate date){
		SysDate	= date;
	}
}
