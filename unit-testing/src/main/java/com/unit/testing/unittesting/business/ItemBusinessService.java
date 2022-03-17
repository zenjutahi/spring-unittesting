package com.unit.testing.unittesting.business;

import com.unit.testing.unittesting.model.Item;
import org.springframework.stereotype.Component;


@Component
public class ItemBusinessService {

    public Item getHardCodedData(){
        return new Item(1,"Book", 100, 75);
    }

}
