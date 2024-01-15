package com.w3technologies.service;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;

import com.w3technologies.model.Customer;

public interface CustomerService {

	Page<Customer> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	
	String delete(@PathVariable String email);

}
