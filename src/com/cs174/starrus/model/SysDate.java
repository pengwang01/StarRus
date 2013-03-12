package com.cs174.starrus.model;

import java.lang.String;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SysDate{
	private static SysDate	SysDate = null;
	private 		Date	today	= null;
	private 		String 	dateStr = "";
	private			DateFormat format = null;

	public SysDate(String date){
		this.dateStr=date;
	}

	public String getDateStr(){
		return this.dateStr;
	}

	public void setDateStr(String date){
		this.dateStr	= date;
	}

	public void setDateStr(Date date){
		this.dateStr	= format.format(date);
	}

	public static SysDate getSysDate(){
		if(SysDate == null){
			format	= new SimpleDateFormat("dd-MMM-yy");
			today	= new Date();
			dateStr	= format.format(today);
			
			SysDate = new SysDate(dateStr);
		}
		return SysDate;
	}
	public static void setSysDate(SysDate date){
		SysDate	= date;
	}
	
	public Date getDateObject(){
		return this.today;
	}
}
