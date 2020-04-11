/**
 * Gagandeep
 * 1:11:51 am
 * 11-Apr-2020
 */
package com.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.entity.Customer;
import com.spring.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	/**
	 * Field Injection
	 */
	@Autowired
	private CustomerService service;

	/**
	 * @return List<Customer>  returns a list of Customer
	 */
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return service.getCustomers();
	}
	
	/**
	 * Retunrs a customer based on ID
	 * @return Customer
	 */
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(int id) {
		return service.getCustomer(id);
	}
}
