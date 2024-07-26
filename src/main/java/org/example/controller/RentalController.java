package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.dto.Rent;
import org.example.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rent-controller")
@CrossOrigin
@RequiredArgsConstructor
public class RentalController {

    final RentalService rentalService;
    @PostMapping("/add-rent")
    public void addRent(@RequestBody Rent rent){
        rentalService.addRent(rent);
    }

    @GetMapping("/all-rental")
    public List allRental(){
        return rentalService.allRental();
    }

    @PutMapping("/update-rent")
    public void updateRent(@RequestBody Rent rent){
        rentalService.updateRent(rent);
    }

    @DeleteMapping("/delete-rent/{id}")
    public void deleteCustomer(@PathVariable Long id){
        rentalService.deleteRent(id);
    }
    @GetMapping("/find-by-id/{id}")
    public Rent findById(@PathVariable Long id){
        return rentalService.findById(id);
    }
}
