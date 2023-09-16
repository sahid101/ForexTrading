package com.finzly.fxTrading.ForexTrading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxTrading.ForexTrading.model.CurrencyPair;
import com.finzly.fxTrading.ForexTrading.service.CurrencyPairService;

@RestController
@RequestMapping("/currencies-and-pairs")
public class CurrencyPairController {
	
	@Autowired
	CurrencyPairService currencyPairService;
	
	//POST mapping for inserting currency pairs and rates
	@PostMapping("/insert-currencypair-and-rates")
	public String addingCurrencyPairsWithRates(@RequestBody CurrencyPair currencyPair) {
		return currencyPairService.addingCurrencyPairsWithRates(currencyPair);
	}
	
	// This end point retrieves details for all currency pairs
	@GetMapping("/get-all-currencypair-details")
	public List<CurrencyPair> getAllCurrencyPairs() {
		return currencyPairService.getAllCurrencyPairs();
	}
	
	
	
}
