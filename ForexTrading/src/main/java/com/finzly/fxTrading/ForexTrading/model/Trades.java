package com.finzly.fxTrading.ForexTrading.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trades {

    
    private int tradeId;
    private String customerName;
    private String currencyPair;
    private double amount;
    private double finalAmount;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCurrencyPair() {
		return currencyPair;
	}
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}
	@Override
	public String toString() {
		return "Trades [tradeId=" + tradeId + ", customerName=" + customerName + ", currencyPair=" + currencyPair
				+ ", amount=" + amount + ", finalAmount=" + finalAmount + "]";
	}
	public Trades(int tradeId, String customerName, String currencyPair, double amount, double finalAmount) {
		super();
		this.tradeId = tradeId;
		this.customerName = customerName;
		this.currencyPair = currencyPair;
		this.amount = amount;
		this.finalAmount = finalAmount;
	}
	public Trades() {
		super();
	}
	

	
    
    
    
}
