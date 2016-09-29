package com.SpringTest.Validator;

import org.springframework.validation.Errors;

import com.SpringTest.CountryForm.CountryForm;
import com.SpringTest.FormService.FormService;
import com.SpringTest.FormService.MockFormService;

public class FormValidator 
{
	private FormService formService = new MockFormService();
	 
	public void validate(CountryForm countryForm, Errors errors) {
	 
	if (countryForm.getArea() != null && countryForm.getArea() <= 0) {
	errors.rejectValue("area", "validation.negative", "must be > 0");
	}
	 
	if (countryForm.getPopulation() != null && countryForm.getPopulation() <= 0) {
	errors.rejectValue("population", "validation.negative", "must be > 0");
	}
	 
	if (!errors.hasFieldErrors("name")) {
	CountryForm existingCountry = formService.getCountryByName(countryForm.getName());
	if (existingCountry != null &&
	(countryForm.isNew() || !countryForm.getId().equals(existingCountry.getId()))) {
	errors.rejectValue("name", "validation.exists", "exists");
	}
	}
	}
}
