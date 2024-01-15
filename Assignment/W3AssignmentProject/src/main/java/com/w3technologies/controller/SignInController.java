package com.w3technologies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.w3technologies.model.Customer;

@Controller
public class SignInController {

	@GetMapping("/signin")
	public String showSignInForm(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("error", null);
		return "signin";
	}

	@PostMapping("/signin")
	public String signIn(@RequestParam String email, @RequestParam String password,
			@RequestParam(defaultValue = "0") int pageNo, Model model) {
		
		if (!email.equals("test@sunbasedata.com")) {
			model.addAttribute("error", "Email wrong.");
			model.addAttribute("showSignUpButton", true);
			return "signin";
		} else if (!password.equals("Test@123")) {
			model.addAttribute("error", "Wrong password. Please check it.");
			return "signin";
		} 

		return "redirect:/mainPage/1?sortField=id&sortDir=asc";
	}
}
