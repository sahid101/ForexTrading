package com.finzly.fxTrading.ForexTrading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.finzly.fxTrading.ForexTrading.model.Trades;
import com.finzly.fxTrading.ForexTrading.service.TradeService;

@RestController
@RequestMapping("/forexchange")
public class TradeController {
	
	@Autowired
	TradeService tradeService;
	
	// End point for booking a trade using paying. The trade information to be passed.
	@PostMapping("/book-trade-by-payment")
	public String paymentTransaction(@RequestBody Trades trade) {
		return tradeService.paymentTransaction(trade);
	}
	
	//End point to book a trade by amount needed. The trade information to be passed.
	@PostMapping("/book-trade-by-receiving")
	public String receiveTransaction(@RequestBody Trades trade) {
		return tradeService.receiveTransaction(trade);
	}
	
	//End points to get all the transaction executed.
	@GetMapping("/all-trades")
	public List<Trades> getAllTrades() {
		return tradeService.getAllTrades();
	}
		
}
