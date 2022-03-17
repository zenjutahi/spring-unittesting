package com.unit.testing.unittesting.controller;


import com.unit.testing.unittesting.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {


    @GetMapping("/dummy-item")
    public Item viewItem(){
        return new Item(1,"Book", 100, 75);
    }

}
