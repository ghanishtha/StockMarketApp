package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class StockPrice {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private StockExchange stockExchange;
	
	@Column(nullable=false)
	private float stockPrice;
	
	@Column(nullable=false)
	private Date date;
	
	@ManyToOne
	private CompanyCode code;

	public StockPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockPrice(StockExchange stockExchange, float stockPrice, Date date, CompanyCode code) {
		super();
		this.stockExchange = stockExchange;
		this.stockPrice = stockPrice;
		this.date = date;
		this.code = code;
	}

	@JsonBackReference(value="stockPrice-stockExchange")
	public StockExchange getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	public float getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(float stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@JsonBackReference(value="stockPrice-code")
	public CompanyCode getCode() {
		return code;
	}

	public void setCode(CompanyCode code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "StockPrice [id=" + id + ", stockPrice=" + stockPrice + ", date=" + date + ", code=" + code + "]";
	}
	
}
