/*
  file name:CountryForm.java
  Created by:Bhushan Ranjane
  Create Date:-29-09-2016
  Purpose:POJO class for CountryForm 
*/
package com.SpringTest.CountryForm;

import java.util.Date;

public class CountryForm 
{
	private Integer id;
	private String name;
	private Integer area;
	private Long population;
	private Date populationLastUpdated;
	private String currency;
	 
	//Create constructor countryForm
	public CountryForm () {}
	 
	public CountryForm(Integer id,
	String name,
	Integer area,
	Long population,
	Date populationLastUpdated,
	String currency) {
	setId(id);
	setName(name);
	setArea(area);
	setPopulation(population);
	setPopulationLastUpdated(populationLastUpdated);
	setCurrency(currency);
	}
	 
	public boolean isNew() {
	return id==null;
	}
	 
	//Use getter Setter to get and set value
	public void setId(Integer id) {
	this.id = id;
	}
	 
	public Integer getId() {
	return id;
	}
	 
	public void setName(String name) {
	this.name = name;
	}
	 
	public String getName() {
	return name;
	}
	 
	public void setArea(Integer area) {
	this.area = area;
	}
	 
	public Integer getArea() {
	return area;
	}
	 
	public void setPopulation(Long population) {
	this.population = population;
	}
	 
	public Long getPopulation() {
	return population;
	}
	 
	public void setPopulationLastUpdated(Date populationLastUpdated) {
	this.populationLastUpdated = populationLastUpdated;
	}
	 
	public Date getPopulationLastUpdated() {
	return populationLastUpdated;
	}
	 
	public void setCurrency(String currency) {
	this.currency = currency;
	}
	 
	public String getCurrency() {
	return currency;
	}

}
