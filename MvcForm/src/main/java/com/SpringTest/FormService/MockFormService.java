/*
  file name:MockFormService.java
  Created by:Bhushan Ranjane
  Create Date:-29-09-2016
  Purpose:Contains the data of the countries
*/
package com.SpringTest.FormService;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.SpringTest.CountryForm.CountryForm;

public class MockFormService implements FormService
{
	//Map to store the countries data
	private static Map<Integer, CountryForm> countries = new HashMap<Integer, CountryForm>();
	private static int nextCountryFormId = 200;
	 //Enter the Static data into map
	static {
		try{
	countries.put(14,new CountryForm(14,"Germany",137847,82046000L,parseDate("30-nov-2008"),"Euro"));
	countries.put(48,new CountryForm(48,"Ghana",  92098, 23837000L,null,"Cedi"));
	countries.put(53,new CountryForm(53,"Australia",2966200,21884000L,parseDate("04-sep-2009"),"Australian Dollar"));
	countries.put(73,new CountryForm(73,"Greece", 50949,11257285L,parseDate("1-jan-2009"),"Euro"));
	countries.put(122,new CountryForm(122,"Georgia",26900,4382100L,parseDate("1-jan-2009"),"Lari"));
	countries.put(123,new CountryForm(123,"New Zealand",104454,4320300L,parseDate("4-sep-2009"),"New Zealand Dollar"));
	countries.put(147,new CountryForm(147,"Gambia",4361,1705000L,null,"Dalasi"));
	countries.put(149,new CountryForm(149,"Gabon",103347,1475000L,null,"CFA franc"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	 
	//Parse the date into the given format
	private static Date parseDate(String textDate) {
	try {
	return new SimpleDateFormat("dd-MMM-yyyy").parse(textDate);
	} catch (Exception e) {
	e.printStackTrace();
	throw new RuntimeException(e);
	}
	}
	 
	//Shows the list of countries
	public Collection<CountryForm> getAllCountries() {
	return countries.values();
	}
	 
	//method to get country by Id
	public CountryForm getCountryById(int CountryId) {
	// Returns a new object and not just a reference
	// to an object in the collection.
	CountryForm CountryForm = countries.get(CountryId);
	return new CountryForm(CountryForm.getId(),
	CountryForm.getName(),
	CountryForm.getArea(),
	CountryForm.getPopulation(),
	CountryForm.getPopulationLastUpdated(),
	CountryForm.getCurrency());
	}
	 
	//returns the Country by name
	public CountryForm getCountryByName(String countryName) {
	for (CountryForm CountryForm : countries.values()) {
	if (CountryForm.getName().toLowerCase().equals(countryName.toLowerCase())) {
	return CountryForm;
	}
	}
	return null;
	}
	 
	//method to save  new added country
	public void saveCountry(CountryForm CountryForm) {
	if (CountryForm.isNew()) {
	nextCountryFormId++;
	CountryForm.setId(nextCountryFormId);
	countries.put(nextCountryFormId, CountryForm);
	} else {
	countries.put(CountryForm.getId(), CountryForm);
	}
	}
	 
	//method to delete the country
	public void deleteCountry(CountryForm CountryForm) {
	countries.remove(CountryForm.getId());
	}
}
