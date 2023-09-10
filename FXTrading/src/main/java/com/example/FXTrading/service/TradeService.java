package com.example.FXTrading.service;

import com.example.FXTrading.model.Trades;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
public class TradeService {

	public List<Trades> list = new ArrayList<>();
	static int tempTradeNumber = 0;

	public String bookTrade(Trades trade) {

		if (isValidName(trade.getName()) && (isValidCurrencyPair(trade.getCurrencyPair()))
				&& isValidAmount(trade.getAmount())) {
			confirmBook(trade);

			return "Amount of " + (trade.getAmount() * trade.getRate()) + "" + " INR will be transferred to "
					+ trade.getName() + " within 2 days.";
		} else {
			return "Invalid Input.";
		}
	}

	private void confirmBook(Trades trade) {
		trade.setTradeNo(++tempTradeNumber);
		list.add(trade);

	}

	public boolean isValidName(String name) {
		return !name.isEmpty() && name.matches("[a-zA-Z. ]+$");
	}

	public boolean isValidCurrencyPair(String currencyPair) {
		return (currencyPair.equalsIgnoreCase("usdinr"));
	}

	public boolean isValidAmount(double amount) {
		if (amount < 0.0) {
			return false;
		}
		return true;
	}

	public Trades getByTradeNo(int tradeNumber) {
		ListIterator<Trades> iterator = list.listIterator();

		while (iterator.hasNext()) {
			Trades trade = iterator.next();
			if (trade.getTradeNo() == tradeNumber) {
				return trade;
			}
		}
		return null;
	}

	public boolean deleteByTradeNo(int tradeNumber) {
		boolean isDone = false;
		ListIterator<Trades> iterator = list.listIterator();

		while (iterator.hasNext()) {
			Trades trade = iterator.next();
			if (trade.getTradeNo() == tradeNumber) {
				iterator.remove();
				isDone = true;
			}
		}
		return isDone;
	}
}
