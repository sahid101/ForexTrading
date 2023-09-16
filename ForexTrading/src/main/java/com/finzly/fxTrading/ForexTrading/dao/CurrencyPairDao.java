package com.finzly.fxTrading.ForexTrading.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.fxTrading.ForexTrading.model.CurrencyPair;

@Repository
public class CurrencyPairDao {
	 @Autowired
	 SessionFactory factory;

	public String addingCurrencyPairsWithRates(CurrencyPair currencyPair) {
		Session session = factory.openSession();
		session.save(currencyPair);
		session.beginTransaction().commit();
		return "Currency Pair Added in DataBase.";
	}

	public List<CurrencyPair> getAllCurrencyPairs() {
		Session session = factory.openSession();
		Criteria criteria =  session.createCriteria(CurrencyPair.class);
		return criteria.list();
	}
	
}
