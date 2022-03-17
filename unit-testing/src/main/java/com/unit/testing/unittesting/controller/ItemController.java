package com.unit.testing.unittesting.controller;


import com.unit.testing.unittesting.business.ItemBusinessService;
import com.unit.testing.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;


    @GetMapping("/dummy-item")
    public Item viewItem(){
        return new Item(1,"Book", 100, 75);
    }

    @GetMapping("/item-from-business-service")
    public Item viewItemFromBusinessService(){
        return businessService.getHardCodedData();
    }

}
