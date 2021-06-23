package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class CompanyCode {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false)
	private int code;
	
	@ManyToOne
	private Company company;
	
	@ManyToOne
	private StockExchange stockExchange;
	
	@OneToMany(mappedBy="code", fetch=FetchType.LAZY)
	private List<StockPrice> stockPrices;

	public CompanyCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyCode(int code) {
		super();
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	@JsonBackReference(value="code-company")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	@JsonBackReference(value="code-stockExchange")
	public StockExchange getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	@JsonManagedReference(value="stockPrice-code")
	public List<StockPrice> getStockPrices() {
		return stockPrices;
	}

	public void addStockPrice(StockPrice stockPrice) {
		this.stockPrices.add(stockPrice);
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CompanyCode [id=" + id + ", code=" + code + ", company=" + company + ", stockExchange=" + stockExchange
				+ "]";
	}
	
	
	
	

}
