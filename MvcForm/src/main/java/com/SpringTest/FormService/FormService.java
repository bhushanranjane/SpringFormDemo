/*
  file name:FormService.java
  Created by:Bhushan Ranjane
  Create Date:-29-09-2016
  Purpose:InterFace between CountryForm and MockFormService
*/
package com.SpringTest.FormService;

import java.util.Collection;

import com.SpringTest.CountryForm.CountryForm;

//Create interface FormService
public interface FormService {
	//Store list of countries in Collections 
	public Collection<CountryForm> getAllCountries();
	
	//Create abstract method to get country by Id
	public CountryForm getCountryById(int countryId);
	
	//Create abstract method to get country by Name
	public CountryForm getCountryByName(String countryName);
	
	//Create abstract method to get country by Form
	public void saveCountry(CountryForm country);
	
	//Create abstract method to delete country
	public void deleteCountry(CountryForm country);
 
}