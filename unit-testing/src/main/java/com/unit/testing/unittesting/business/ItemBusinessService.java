package com.unit.testing.unittesting.business;

import com.unit.testing.unittesting.data.ItemRepository;
import com.unit.testing.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item getHardCodedData(){
        return new Item(1,"Book", 100, 75);
    }

    public List<Item> retrieveAllItems(){
        List<Item> items = repository.findAll();
        for(Item item:items){
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }

}
