package com.cs174.starrus.model;

public class Customer {
	private String username;
	private String psd;
	private String cname;
	private int phone_num;
	private String state;
	private int tax_id;
	private String email;
	private int m_account_id;
	private int s_account_id;

	private MarketAcc m_account;
	private StockAcc s_account;
	
	public Customer(){}
	
	public Customer(String username, String psd){
		this.username = username;
		this.psd = psd;
	}
	
	public void getMarketAccInfo(){
		MarketAcc m_account = new MarketAcc(m_account_id);
	}
	
	public void getStockAccInfo(){
		StockAcc s_account = new StockAcc(s_account_id); 
	}

}
