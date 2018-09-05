package com.chandler.exp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
/**
 * Service for initializing MongoDB with sample data using {@link MongoTemplate}
 */
public class InitMongoService {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public void init() {
		// Drop existing collections
//		mongoTemplate.dropCollection("customer");

		// Create new records
//		Customer customer = new Customer("Admin","M");		
//		this.mongoTemplate.ex
		// Insert to db
//		mongoTemplate.insert(customer, "customer");
	}
}
