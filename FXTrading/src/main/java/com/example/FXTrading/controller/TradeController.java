package com.example.FXTrading.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.FXTrading.model.Trades;
import com.example.FXTrading.service.TradeService;

@RestController
@RequestMapping("/trade")
public class TradeController {
	@Autowired
	TradeService tradeservice; 
	
	@PostMapping("/book")
	public Object book(@RequestBody Trades trade) {
		String resultOfBookTrade = tradeservice.bookTrade(trade);
		return resultOfBookTrade;
	}
	
	@GetMapping("/list")
	public List<Trades> getAllTrade() {
		return tradeservice.list;
	}

	@GetMapping("/res/{tradeNumber}")
	public Trades getTradeByNo(@PathVariable int tradeNumber) {
		return tradeservice.getByTradeNo(tradeNumber);
		
	}
	@DeleteMapping("/del/{tradeNumber}")
	public String deleteTradeByNo(@PathVariable("tradeNumber") int tradeNumber) {
		if(tradeservice.deleteByTradeNo(tradeNumber)) {
			return ("Deleted.");
		}
		return ("Not Found.");
	}
	@PostMapping("/exit")
	public void exitApplication() {
		System.exit(0);
	}
}
