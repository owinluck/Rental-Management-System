package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.Item;
import org.example.dto.Rent;
import org.example.entity.ItemEntity;
import org.example.entity.RentEntity;
import org.example.repository.ItemRepository;
import org.example.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    final ItemRepository repository;
    @Override
    public void addItem(Item item) {
        repository.save(new ObjectMapper().convertValue(item, ItemEntity.class));
    }

    @Override
    public List allItem() {
        List<Item> rentItem=new ArrayList<>();

        List<ItemEntity> allItem = repository.findAll();

        allItem.forEach(entity ->{

            rentItem.add(new ObjectMapper().convertValue(entity, Item.class));
        });
        return rentItem;
    }

    @Override
    public void updateItem(Item item) {
        repository.save(new ObjectMapper().convertValue(item, ItemEntity.class));
    }

    @Override
    public void deleteItem(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public Item findById(Long id) {
        if(repository.findById(id).isPresent()){
            Optional<ItemEntity> byId = repository.findById(id);
            return new ObjectMapper().convertValue(byId.get(), Item.class);
        }
        return new Item();
    }
}
