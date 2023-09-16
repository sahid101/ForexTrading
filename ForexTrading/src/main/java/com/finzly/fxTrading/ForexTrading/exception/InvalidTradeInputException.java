package com.finzly.fxTrading.ForexTrading.exception;

public class InvalidTradeInputException extends RuntimeException {
	private String messsage;

	public InvalidTradeInputException(String message) {
		this.messsage = message;
	}

}
