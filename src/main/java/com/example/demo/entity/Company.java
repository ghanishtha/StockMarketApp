package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Company {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	@Column(nullable=false)
	private float turnover;
	
	@Column(nullable=false)
	private String ceo;
	
	@Column(nullable=false)
	private String boardOfDirectors;
	
	@Column(nullable=false)
	private String writeUp;
	
	@OneToOne
	private IPO ipo;
	
	@JsonIgnore
	@ManyToMany
	private List<StockExchange> stockExchanges = new ArrayList<>();
	
	@ManyToOne
	private Sector sector;
	
	@OneToMany(mappedBy = "company", fetch=FetchType.LAZY)
	private List<CompanyCode> codes = new ArrayList<>();

	public Company(String name, float turnover, String ceo, String boardOfDirectors, String writeUp, IPO ipo,
			List<StockExchange> stockExchanges, Sector sector) {
		super();
		this.name = name;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.writeUp = writeUp;
		this.ipo = ipo;
		this.stockExchanges = stockExchanges;
		this.sector = sector;
	}

	public Company(String name, float turnover, String ceo, String boardOfDirectors, String writeUp) {
		super();
		this.name = name;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.writeUp = writeUp;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getTurnover() {
		return turnover;
	}

	public void setTurnover(float turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public String getWriteUp() {
		return writeUp;
	}

	public void setWriteUp(String writeUp) {
		this.writeUp = writeUp;
	}
	
	@JsonBackReference(value="company-ipo")
	public IPO getIpo() {
		return ipo;
	}

	public void setIpo(IPO ipo) {
		this.ipo = ipo;
	}

	public List<StockExchange> getStockExchanges() {
		return stockExchanges;
	}

	public void addStockExchange(StockExchange stockExchange) {
		this.stockExchanges.add(stockExchange);
	}

	@JsonBackReference(value="company-sector")
	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	@JsonManagedReference(value="code-company")
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
		return "Company [id=" + id + ", name=" + name + ", turnover=" + turnover + ", ceo=" + ceo
				+ ", boardOfDirectors=" + boardOfDirectors + ", writeUp=" + writeUp + ", ipo=" + ipo
				+ ", stockExchanges=" + stockExchanges + ", sector=" + sector + "]";
	}
	
	
	

}
