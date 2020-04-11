/**
 * Gagandeep
 * 1:11:51 am
 * 11-Apr-2020
 */
package com.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	 * @return Customer Customer that was added to database
	 */
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		service.saveCustomer(customer);
		// Here the customer will have an Updated ID
		return customer;
	}
	
	/**
	 * Put method to update Data
	 * Request URL: http://localhost:8083/spring-crm-rest/api/customers
	 * {
	 * 	"id" : 11,
	 * 	"firstName": "Gagan",
	 *  "lastName" : "Singh",
	 *  "email" : test@mail.com
	 * }
	 * @return Customer that was updated
	 */
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		service.saveCustomer(customer);
		return customer;
	}
	
	/**
	 * Delete Method to delete customer
	 * Request URL: http://localhost:8083/spring-crm-rest/api/customers/{id}
	 * @return String messagew with ID of deleted customer
	 */
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		Customer customer = service.getCustomer(id);
		if(customer==null)
			throw new CustomerNotFoundException("Customer not found with ID " + id);
		service.deleteCustomer(id);
		return "Deleted Customer with ID " + id;
	}
}
/**
 * **********Important Notes**********
 * Annotations related to Sping REST
 * @Controller Servlet to handle Http requests(get, post, put, delete, etc)
 * @RestController Handlies REST API requests (Extension of COntroller)
 * @RequestMapping("/abc") Specify Url Path
 * @GetMapping("/xyz") Handles Get Requests
 * @PostMapping("/zys") Handles Post requests
 * @PutMapping("/xyz") Handles put requests (updates)
 * @DeleteMapping("/zbx/{id}") Handles delte requests
 * @PathVariables int id Fetches data sepcified in url as {id} eg. @PathVariable int id
 * @RequestBody MEthod parameter To specify request object eg. @RequestBody Customer c
 */
