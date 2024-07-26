package org.example.service;

import org.example.dto.Rent;

import java.util.List;

public interface RentalService {
    void addRent(Rent rent);

    List allRental();

    void updateRent(Rent rent);

    void deleteRent(Long id);

    Rent findById(Long id);
}
