/*
  file name:CountryForm.java
  Created by:Bhushan Ranjane
  Create Date:-29-09-2016
  Purpose:Controll handle all the operations to be performed on web page
*/
package com.SpringTest.FormController;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringTest.CountryForm.CountryForm;
import com.SpringTest.FormService.FormService;
import com.SpringTest.FormService.MockFormService;

@Controller
public class FormController
{
	private FormService formService = new MockFormService();
	
	@RequestMapping(value="/countryList",method=RequestMethod.GET)
	@ModelAttribute("countries")
	public Collection<CountryForm> getAllCountries(){
		return   formService.getAllCountries();
	}
	
	@RequestMapping(value="/countryDetails",method=RequestMethod.GET)
	public CountryForm getCountry(@RequestParam(value="id", required=true) int countryId) {
		return formService.getCountryById(countryId);
}
}
