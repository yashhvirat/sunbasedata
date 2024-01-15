package com.w3technologies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.w3technologies.model.Customer;
import com.w3technologies.repository.CustomerRepository;

@Controller
public class SignUpController {
	
	@Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new Customer());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("customer") Customer customer) {
        customerRepository.save(customer); // Save user to the database
        return "redirect:/signin"; // Redirect to sign-in page after successful sign-up
    }
}
