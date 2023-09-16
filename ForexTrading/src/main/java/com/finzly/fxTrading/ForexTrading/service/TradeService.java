package com.finzly.fxTrading.ForexTrading.service;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxTrading.ForexTrading.dao.CurrencyPairDao;
import com.finzly.fxTrading.ForexTrading.dao.TradeDao;
import com.finzly.fxTrading.ForexTrading.exception.CurrencyPairNotFoundException;
import com.finzly.fxTrading.ForexTrading.exception.InvalidTradeInputException;
import com.finzly.fxTrading.ForexTrading.model.CurrencyPair;
import com.finzly.fxTrading.ForexTrading.model.Trades;

@Service
public class TradeService {

	@Autowired
	TradeDao tradeDao;
	CurrencyPair currencyPair;
	CurrencyPairDao currencyPairDao;
	
	public String paymentTransaction(Trades trade) throws InvalidTradeInputException {
		double rateOfCurrencyPair = 0;
		String pairByUser = trade.getCurrencyPair().toString().toUpperCase();
		
		if (isValidTrade(trade)) {
			rateOfCurrencyPair = getRateOfCurrencyPair(pairByUser);
			trade.setFinalAmount(rateOfCurrencyPair * trade.getAmount());
			trade.setCurrencyPair(pairByUser);
			
			return tradeDao.paymentTransaction(trade);
		} 
		else {
			throw new InvalidTradeInputException("Invalid Input entered! Please give valid input.");
		}
	}

	public String receiveTransaction(Trades trade)  {
		double rateOfCurrencyPair = 0;
		String pairByUser = trade.getCurrencyPair().toString().toUpperCase();
		if (isValidTrade(trade)) {
			rateOfCurrencyPair = getRateOfCurrencyPair(pairByUser);	
				if (rateOfCurrencyPair > 0) {
					trade.setFinalAmount(trade.getAmount() / rateOfCurrencyPair);
				}
				trade.setCustomerName(trade.getCustomerName());
				trade.setCurrencyPair(pairByUser);

				return tradeDao.receiveTransaction(trade);
			} 
		else {
			throw new InvalidTradeInputException("Invalid Input entered! Please give valid input.");
		} 
	}
	
	
	public double getRateOfCurrencyPair(String pairByUser) throws CurrencyPairNotFoundException {
		double rateOfCurrencyPair = 0.0;
		List<CurrencyPair> listOfSpecificPair = tradeDao.getParticularPair(pairByUser);
		if (!listOfSpecificPair.isEmpty()) {
			for (CurrencyPair currencyPair : listOfSpecificPair) {
				rateOfCurrencyPair = currencyPair.getRate();
				break;
			}
			return rateOfCurrencyPair;
		}
		else {
			throw new CurrencyPairNotFoundException("Curreny Pair Not Found.");
		}
		
	}

	public List<Trades> getAllTrades() {
		return tradeDao.getAllTrades();
	}
	
	
	public boolean isValidTrade(Trades trade) {
		if (isValidName(trade.getCustomerName()) && isValidAmount(trade.getAmount())) {
			return true;
		}
		return false;
	}


	public boolean isValidName(String name) {
		return !name.isEmpty() && name.matches("[a-zA-Z. ]+$");
	}

	
	public boolean isValidAmount(double amount) {
		if (amount < 0.0) {
			return false;
		}
		return true;
	}

}
