package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class IPO {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false)
	private float pricerPerShare;
	
	@Column(nullable=false)
	private Long totalShares;
	
	@Column(nullable=false)
	private String openDateTime;
	
	@Column(nullable=false)
	private String remarks;
	
	@OneToOne(mappedBy="ipo", fetch=FetchType.LAZY)
	private Company company;
	
	@JsonIgnore
	@ManyToMany(mappedBy="ipo", fetch=FetchType.LAZY)
	private List<StockExchange> stockExchanges = new ArrayList<>();

	public IPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IPO(float pricerPerShare, Long totalShares, String openDateTime, String remarks, Company company) {
		super();
		this.pricerPerShare = pricerPerShare;
		this.totalShares = totalShares;
		this.openDateTime = openDateTime;
		this.remarks = remarks;
		this.company = company;
	}

	public float getPricerPerShare() {
		return pricerPerShare;
	}

	public void setPricerPerShare(float pricerPerShare) {
		this.pricerPerShare = pricerPerShare;
	}

	public Long getTotalShares() {
		return totalShares;
	}

	public void setTotalShares(Long totalShares) {
		this.totalShares = totalShares;
	}

	public String getOpenDateTime() {
		return openDateTime;
	}

	public void setOpenDateTime(String openDateTime) {
		this.openDateTime = openDateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@JsonManagedReference(value="company-ipo")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<StockExchange> getStockExchanges() {
		return stockExchanges;
	}

	public void addStockExchange(StockExchange stockExchange) {
		this.stockExchanges.add(stockExchange);
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "IPO [id=" + id + ", pricerPerShare=" + pricerPerShare + ", totalShares=" + totalShares
				+ ", openDateTime=" + openDateTime + ", remarks=" + remarks + "]";
	}
	
	
	
}
