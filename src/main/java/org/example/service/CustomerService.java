package org.example.service;

import org.example.dto.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);


    List getAllCustomer();

    void updateCustomer(Customer customer);

    Customer findById(Long id);
}
