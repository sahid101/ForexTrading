package com.example.FXTrading.model;


public class Trades {
    private  int tradeNo;
    private final double rate = 66;
    private String name;
    private String currencyPair;
    private double amount;
 


    public Trades() {}
    
    public Trades(String name, String currencyPair, double amount) {
    	this.name = name;
        this.currencyPair = currencyPair;
        this.amount = amount;
     
    }
    
    public int getTradeNo() {
        return tradeNo;
    }
    
    public double getRate() {
        return rate;
    }
   
    public String getName() {
        return name;
    }
    
    public String getCurrencyPair() {
        return currencyPair;
    }
    
    public double getAmount() {
        return amount;
    }

	public void setTradeNo(int tradeNo) {
		this.tradeNo = tradeNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}	
	
	
}
