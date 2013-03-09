package com.cs174.starrus.model;

import java.lang.String;
import java.util.Set;

public class StockAcc {
	private int 	account_id;
	//private ArrayList<String> stockList;
	
	public StockAcc(int id) {
		account_id = id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	
/*	
	public boolean exists(String ticker){
		if (stockList.contains(ticker)){
			return true;
		}
			return false;
	}
*/

	@Override
	public String toString() {
		return "StockAcc [account_id=" + account_id + "]";
	}
	
	
}
