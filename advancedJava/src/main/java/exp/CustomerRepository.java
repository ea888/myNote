package com.chandler.exp;


import org.springframework.data.mongodb.repository.MongoRepository;


public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByName(String name);

}
