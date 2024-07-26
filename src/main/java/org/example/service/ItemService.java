package org.example.service;

import org.example.dto.Item;
import org.example.dto.Rent;

import java.util.List;

public interface ItemService {
    void addItem(Item item);

    List allItem();

    void updateItem(Item item);

    void deleteItem(Long id);

    Item findById(Long id);
}
