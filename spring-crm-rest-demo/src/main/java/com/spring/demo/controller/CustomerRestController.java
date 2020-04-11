/**
 * Gagandeep
 * 1:11:51 am
 * 11-Apr-2020
 */
package com.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.entity.Customer;
import com.spring.demo.exception.CustomerNotFoundException;
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
	 * Request URL: http://localhost:8083/spring-crm-rest/api/customers
	 * @return List<Customer>  returns a list of Customer
	 */
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return service.getCustomers();
	}
	
	/**
	 * Request URL: http://localhost:8083/spring-crm-rest/api/customers/{id}
	 * Retunrs a customer based on ID
	 * @return Customer
	 */
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		Customer customer = service.getCustomer(id);
		if(customer == null) 
			throw new CustomerNotFoundException("Customer not found with ID " + id);
		return customer;
	}
	
	/**
	 * Request URL: http://localhost:8083/spring-crm-rest/api/customers
	 * {
	 * 	"firstName": "Gagan",
	 *  "lastName" : "Singh",
	 *  "email" : test@mail.com
	 * }
	 * Post method to save custoer
	 * @return Customer
	 */
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		service.saveCustomer(customer);
		// Here the customer will have an Updated ID
		return customer;
	}
}
