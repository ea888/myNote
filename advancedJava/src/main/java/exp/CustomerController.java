package com.chandler.exp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableMongoRepositories
public class CustomerController {
	
	
	@Autowired
	private CustomerRepository repository;

	@RequestMapping(value = "/customers/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Customer getCustomer(@PathVariable String name) {
		return this.repository.findByName(name);
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void saveCustomers(@RequestParam(value="name", defaultValue="John") String name, 
			@RequestParam(value="gender", defaultValue="M") String gender) {
		
		
		this.repository.save(new Customer(name,gender));
	}
	
	@RequestMapping(value = "/customers/{name}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delCustomer(@PathVariable String name) {
		this.repository.delete(this.repository.findByName(name));
	}
}
