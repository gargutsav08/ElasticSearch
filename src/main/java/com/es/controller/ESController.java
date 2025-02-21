package com.es.controller;

import com.es.model.Customer;
import com.es.service.CustomerService;
import com.es.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ESController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private QueryService queryService;

    @GetMapping("/findAll")
    Iterable<Customer> findAll(){
        return customerService.getCustomer();
    }

    @PostMapping("/insert")
    public Customer insertProduct(@RequestBody Customer customer){
        return customerService.insertCustomer(customer);
    }

    @GetMapping("/find/{firstName}/{age}")
    List<Customer> find(@PathVariable String firstName, @PathVariable int age){
        return queryService.findByFirstNameAndAge(firstName,age);
    }
}
