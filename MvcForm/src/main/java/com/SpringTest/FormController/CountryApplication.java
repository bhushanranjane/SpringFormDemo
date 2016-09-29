package com.SpringTest.FormController;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.SpringTest.CountryForm.CountryForm;
import com.SpringTest.FormService.FormService;
import com.SpringTest.FormService.MockFormService;
import com.SpringTest.Validator.FormValidator;
@Controller
@RequestMapping("/countryForm")
@SessionAttributes("countryForm")
public class CountryApplication {
	private FormService formService = new MockFormService();
	 
	private FormValidator countryValidator = new FormValidator();
	 
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
	 
	dataBinder.setDisallowedFields(new String[] {"id"});
	dataBinder.setRequiredFields(new String[] {"name", "area", "population", "currency"});
	dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	 
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	dateFormat.setLenient(false);
	dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	 
	@RequestMapping(method = RequestMethod.GET)
	public CountryForm setUpForm(@RequestParam(value="id", required = false) Integer countryId) {
	System.out.println("Call to create");
		if (countryId == null) {
	return new CountryForm();
	} else {
	return formService.getCountryById(countryId);
	}
	}
	 
	@RequestMapping(params = "create",method = RequestMethod.POST)
	public String create(CountryForm countryform, BindingResult result, SessionStatus status) {
	return update(countryform, result, status);
	}
	 
	@RequestMapping(params = "update",method = RequestMethod.POST)
	public String update(CountryForm country, BindingResult result, SessionStatus status) {
	countryValidator.validate(country, result);
	if (result.hasErrors()) {
	return "countryForm";
	} else {
	formService.saveCountry(country);
	status.setComplete();
	return "redirect:countryList.html";
	}
	}
	 
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public String delete(CountryForm country, BindingResult result, SessionStatus status) {
	formService.deleteCountry(country);
	status.setComplete();
	return "redirect:countryList.html";
	}
	 

}
