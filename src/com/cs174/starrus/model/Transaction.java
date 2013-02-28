package com.cs174.starrus.model;

public class Transaction {
	private int trans_id;
	private String date;
	public Transaction(int trans_id, String date) {
		super();
		this.trans_id = trans_id;
		this.date = date;
	}
	public int getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Transaction [trans_id=" + trans_id + ", date=" + date + "]";
	}
	
}
