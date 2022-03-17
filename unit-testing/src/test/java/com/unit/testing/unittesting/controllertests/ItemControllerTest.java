package com.unit.testing.unittesting.controllertests;


import com.unit.testing.unittesting.business.ItemBusinessService;
import com.unit.testing.unittesting.controller.ItemController;
import com.unit.testing.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void returnItemTest() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Book\",\"quantity\":100,\"price\":75}"))
                .andReturn();
    }

    @Test
    public void returnItemFromBusinessTest() throws Exception {

        when(businessService.getHardCodedData()).thenReturn(
                new Item(2,"item", 10,57));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2,name:item,quantity:10}"))
                .andReturn();
    }

    @Test
    public void getAllItemsFromDatabaseTest() throws Exception {

        when(businessService.retrieveAllItems()).thenReturn(
                Arrays.asList(
                        new Item(2,"item", 10,57),
                        new Item(3,"item3", 12,55))
                );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:2,name:item,quantity:10}, {id:3,name:item3,quantity:12}]"))
                .andReturn();
    }

}
