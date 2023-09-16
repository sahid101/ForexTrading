package com.finzly.fxTrading.ForexTrading.exception;

public class CurrencyPairNotFoundException extends RuntimeException {
	private String message;

	public CurrencyPairNotFoundException(String message) {
		this.message = message;
	}
}
