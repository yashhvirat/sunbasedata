package com.w3technologies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.w3technologies.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/delete/{email}")
	public String delete(@PathVariable String email) {
		customerService.delete(email);
		return "redirect:/mainPage/1?sortField=id&sortDir=asc";
	}
}
