package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cus-controller")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {


    final CustomerService customerService;
    @PostMapping("/add-customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @GetMapping("/get-all")
    public List getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @PutMapping("/update-customer")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete-customer/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }
    @GetMapping("/find-by-id/{id}")
    public Customer findById(@PathVariable Long id){
        return customerService.findById(id);
    }
}
