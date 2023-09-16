package com.finzly.fxTrading.ForexTrading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxTrading.ForexTrading.dao.CurrencyPairDao;
import com.finzly.fxTrading.ForexTrading.model.CurrencyPair;

@Service
public class CurrencyPairService {

	@Autowired
	CurrencyPairDao currencyPairDao;

	public String addingCurrencyPairsWithRates(CurrencyPair currencyPair) {
		return currencyPairDao.addingCurrencyPairsWithRates(currencyPair);
	}

	public List<CurrencyPair> getAllCurrencyPairs() {
		return currencyPairDao.getAllCurrencyPairs();
	}
}
