package com.w3technologies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.w3technologies.model.Customer;
import com.w3technologies.service.CustomerService;

@Controller
public class MainController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/mainPage/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {

		int pageSize = 5;

		Page<Customer> page = customerService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Customer> listCustomers = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listCustomers", listCustomers);
		return "mainPage";
	}
}
