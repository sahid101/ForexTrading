package com.finzly.fxTrading.ForexTrading.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.finzly.fxTrading.ForexTrading.model.CurrencyPair;
import com.finzly.fxTrading.ForexTrading.model.Trades;

@Repository 
public class TradeDao {

	@Autowired
	SessionFactory factory;
	
	public String paymentTransaction(Trades trade) {
		Session session = factory.openSession();
		session.save(trade);
		session.beginTransaction().commit();
		return "Done transfer";
	}

	public String receiveTransaction(Trades trade) {
		Session session = factory.openSession();
		session.save(trade);
		session.beginTransaction().commit();
		return "Done receive";
	}
	
	public List<CurrencyPair> getParticularPair(String pairByUser){
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(CurrencyPair.class);
		criteria.add(Restrictions.eq("pair", pairByUser));
        return criteria.list();
	}

	public List<Trades> getAllTrades() {
		Session session =  factory.openSession();
		Criteria criteria = session.createCriteria(Trades.class);
		return criteria.list();
	}
}
