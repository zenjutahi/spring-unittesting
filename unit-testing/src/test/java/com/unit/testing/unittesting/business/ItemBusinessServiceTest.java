package com.unit.testing.unittesting.business;

import com.unit.testing.unittesting.data.ItemRepository;
import com.unit.testing.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {


    @InjectMocks
    private ItemBusinessService business;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void retrieveAllItemsTest() {
        when(itemRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Item(2,"item", 10,57),
                        new Item(3,"item3", 10,55))
        );
        List<Item> items = business.retrieveAllItems();
        assertEquals(570, items.get(0).getValue());
        assertEquals(550, items.get(1).getValue());
    }
}
