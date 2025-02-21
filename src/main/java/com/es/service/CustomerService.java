package com.es.service;

import com.es.model.Customer;
import com.es.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    public Iterable<Customer> getCustomer() {
        return customerRepo.findAll();
    }

    public Customer insertCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

}
