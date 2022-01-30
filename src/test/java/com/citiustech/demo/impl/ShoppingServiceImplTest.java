package com.citiustech.demo.impl;

import com.citiustech.demo.model.Cart;
import com.citiustech.demo.model.Item;
import com.citiustech.demo.service.impl.ShoppingServiceImpl;
import com.citiustech.demo.persistance.repository.ItemRepository;
import com.citiustech.demo.persistance.repository.ShoppingRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ShoppingServiceImplTest {
    MockMvc mockMvc;

    @Mock
    private ShoppingRepository shoppingRepository;
    @Mock
    private ItemRepository itemRepository;
    @InjectMocks
    private ShoppingServiceImpl shoppingService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(shoppingService).build();
    }

    @Test
    public void addItemTest() {
        Item item = new Item();
        item.setId(1);
        item.setItemPrice(123.2);
        item.setItemCode("ASC123");
        item.setItemName("Mango Drink");
        item.setItemAvailableQuantity(4);
        item.setItemDiscription("Mango flavoured drink");
        when(itemRepository.getById(any())).thenReturn(item);
        assertNotEquals(item.getItemAvailableQuantity(), 0);
        Cart cart = new Cart();
        cart.setItemId(1);
        cart.setTotalItems(1);
        cart.setTotalPrice(123.2);
        when(shoppingRepository.save(any())).thenReturn("Saved");
    }
}
