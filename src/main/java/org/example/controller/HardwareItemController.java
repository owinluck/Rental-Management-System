package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Item;
import org.example.dto.Rent;
import org.example.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-Controller")
@CrossOrigin
@RequiredArgsConstructor
public class HardwareItemController {

    final ItemService itemService;
    @PostMapping("/add-item")
    public void addItem(@RequestBody Item item){

        itemService.addItem(item);
    }
    @GetMapping("/all-item")
    public List allItem(){

        return itemService.allItem();
    }

    @PutMapping("/update-item")
    public void updateRent(@RequestBody Item item){
        itemService.updateItem(item);
    }

    @DeleteMapping("/delete-item/{id}")
    public void deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
    }
    @GetMapping("/find-by-id/{id}")
    public Item findById(@PathVariable Long id){
        return itemService.findById(id);
    }
}
