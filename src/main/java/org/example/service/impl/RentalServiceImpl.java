package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.dto.Rent;
import org.example.entity.CustomerEntity;
import org.example.entity.RentEntity;
import org.example.repository.RentRepository;
import org.example.service.RentalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {


    final RentRepository repository;
    @Override
    public void addRent(Rent rent) {
        repository.save(new ObjectMapper().convertValue(rent, RentEntity.class));
    }

    @Override
    public List allRental() {
        List<Rent> rentList=new ArrayList<>();

        List<RentEntity> allRentList = repository.findAll();

        allRentList.forEach(entity ->{

            rentList.add(new ObjectMapper().convertValue(entity, Rent.class));
        });
        return rentList;
    }

    @Override
    public void updateRent(Rent rent) {
        repository.save(new ObjectMapper().convertValue(rent, RentEntity.class));
    }

    @Override
    public void deleteRent(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public Rent findById(Long id) {
        if(repository.findById(id).isPresent()){
            Optional<RentEntity> byId = repository.findById(id);
            return new ObjectMapper().convertValue(byId.get(), Rent.class);
        }
        return new Rent();
    }
}
