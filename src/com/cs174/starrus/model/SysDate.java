package com.cs174.starrus.model;

import java.lang.String;

public class SysDate{
	public String Date	= "";
	private static SysDate sysDate = null;
	
	private SysDate(){}

	public static SysDate getSysDate(){
		if(sysDate == null) 
			sysDate = new SysDate();
		return sysDate;
	}

	public String getDateStr(){
		return this.Date;
	}

	public void setDateStr(String date){
		this.Date=date;
	}
}
