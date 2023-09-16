package com.finzly.fxTrading.ForexTrading.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrencyPair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    private String pair;
    private double rate;
    // Constructors, getters, and setters

    public CurrencyPair() {
        // Default constructor
    }
    public CurrencyPair(String pair, double rate) {
        this.pair = pair;
        this.rate = rate;
    }
    // Getters and setters for id, pair, and rate
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPair() {
        return pair;
    }
    public void setPair(String pair) {
        this.pair = pair;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "CurrencyPair [id=" + id + ", pair=" + pair + ", rate=" + rate + "]";
    }
}
