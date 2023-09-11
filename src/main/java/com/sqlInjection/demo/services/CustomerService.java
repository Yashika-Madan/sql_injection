package com.sqlInjection.demo.services;

import com.sqlInjection.demo.entities.Customer;
import com.sqlInjection.demo.repositiories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public Customer login(String uname, String password) {
        Customer customer = customerRepository.getCustomer(uname, password);
        return customer;
    }
}
