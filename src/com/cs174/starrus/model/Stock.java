package com.cs174.starrus.model;

import java.lang.String;

public class Stock{
	private String stockSymbol;
	private double currentPrice;
	
	public Stock(String ticker, double currPrice) {
		this.stockSymbol	= ticker;
		this.currentPrice	= currPrice;	
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbo(String ticker){
		this.stockSymbol	= ticker;	
	}
	
	public void setCurrentPrice(double currPrice){
		this.currentPrice 	= currPrice;
	}

	@Override
	public String toString() {
		return "Stock[stockSymbol=" + stockSymbol + "]";
	}
	
	
}
