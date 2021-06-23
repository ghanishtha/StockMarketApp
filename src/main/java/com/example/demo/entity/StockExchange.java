package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class StockExchange {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false,unique=true)
	private String stockExchangeName;
	
	@Column(nullable=false)
	private String brief;
	
	@Column(nullable=false)
	private String address;
	
	@Column()
	private String remarks;
	
	@JsonIgnore
	@ManyToMany
	private List<IPO> ipo = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy="stockExchanges", fetch=FetchType.LAZY)
	private List<Company> companies= new ArrayList<>();
	
	@OneToMany(mappedBy="stockExchange", fetch=FetchType.LAZY)
	private List<StockPrice> stockPrices = new ArrayList<>();
	
	@OneToMany(mappedBy="stockExchange")
	private List<CompanyCode> codes;

	public StockExchange() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockExchange(String stockExchangeName, String brief, String address, String remarks) {
		super();
		this.stockExchangeName = stockExchangeName;
		this.brief = brief;
		this.address = address;
		this.remarks = remarks;
	}

	public String getStockExchangeName() {
		return stockExchangeName;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<IPO> getIpo() {
		return ipo;
	}

	public void addIpo(IPO ipo) {
		this.ipo.add(ipo);
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void addCompany(Company company) {
		this.companies.add(company);
	}

	@JsonManagedReference(value="stockPrice-stockExchange")
	public List<StockPrice> getStockPrices() {
		return stockPrices;
	}

	public void addStockPrices(StockPrice stockPrice) {
		this.stockPrices.add(stockPrice);
	}

	@JsonManagedReference(value="code-stockExchange")
	public List<CompanyCode> getCodes() {
		return codes;
	}

	public void addCode(CompanyCode code) {
		this.codes.add(code);
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "StockExchange [id=" + id + ", stockExchangeName=" + stockExchangeName + ", brief=" + brief + ", address=" + address + ", remarks="
				+ remarks + "]";
	}

	
	
}
