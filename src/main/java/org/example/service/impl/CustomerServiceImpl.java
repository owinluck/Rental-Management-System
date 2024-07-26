package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.entity.CustomerEntity;
import org.example.repository.CustomerRepository;
import org.example.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository repository;
    @Override
    public void addCustomer(Customer customer) {

        repository.save(new ObjectMapper().convertValue(customer, CustomerEntity.class));
    }

    @Override
    public List getAllCustomer() {
        List<Customer> customerList=new ArrayList<>();

        List<CustomerEntity> allCustomerList = repository.findAll();

        allCustomerList.forEach(entity ->{

            customerList.add(new ObjectMapper().convertValue(entity, Customer.class));
        });
        return customerList;
    }

    @Override
    public void updateCustomer(Customer customer) {
        repository.save(new ObjectMapper().convertValue(customer, CustomerEntity.class));
    }

    @Override
    public Customer findById(Long id) {

        if(repository.findById(id).isPresent()){
            Optional<CustomerEntity> byId = repository.findById(id);
            return new ObjectMapper().convertValue(byId.get(), Customer.class);
        }
        return new Customer();
    }
}
