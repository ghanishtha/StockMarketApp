package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Sector {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false,unique=true)
	private String sectorName;
	
	@Column(nullable=false)
	private String brief;
	
	@OneToMany(mappedBy="sector", fetch=FetchType.LAZY)
	private List<Company> companies = new ArrayList<>();

	public Sector() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sector(String sectorName, String brief) {
		super();
		this.sectorName = sectorName;
		this.brief = brief;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	@JsonManagedReference(value="company-sector")
	public List<Company> getCompanies() {
		return companies;
	}

	public void addCompany(Company company) {
		this.companies.add(company);
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Sector [id=" + id + ", sectorName=" + sectorName + ", brief=" + brief + "]";
	}
	

}
