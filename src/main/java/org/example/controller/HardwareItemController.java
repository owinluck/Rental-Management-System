package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Item;
import org.example.service.ItemService;
import org.springframework.web.bind.annotation.*;

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
}
