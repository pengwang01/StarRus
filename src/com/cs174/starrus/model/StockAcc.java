package com.cs174.starrus.model;

public class StockAcc {
	private int account_id;
	
	//private ArrayList<Transaction> trans;
	
	public StockAcc(int id) {
		account_id = id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	@Override
	public String toString() {
		return "StockAcc [account_id=" + account_id + "]";
	}
	
	
}
