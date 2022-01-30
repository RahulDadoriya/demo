package com.citiustech.demo.controller;

import com.citiustech.demo.model.Item;
import com.citiustech.demo.persistance.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/item")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItem() {
        // returning all items stored in inventory/item table
        return new ResponseEntity<>(itemRepository.findAll(), HttpStatus.OK);
    }
}
