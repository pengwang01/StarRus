package com.cs174.starrus.model;

public class MarketAcc {
	private int account_id;
	private double balance;
	//private ArrayList<Transaction> trans;
	
	public MarketAcc(int id) {
		account_id = id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
