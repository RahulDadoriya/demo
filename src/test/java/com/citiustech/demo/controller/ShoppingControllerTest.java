package com.citiustech.demo.controller;

import com.citiustech.demo.service.ShoppingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class ShoppingControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ShoppingService shoppingService;
    @InjectMocks
    private ShoppingController shoppingController;

    @Before
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(shoppingController)
                .build();
    }

    @Test
    public void getCartInfoTest() throws Exception {
        mockMvc.perform(get("/api/cart/getCart"))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void checkoutTest() throws Exception {
        mockMvc.perform(get("/api/cart/checkout"))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void removeItemFromCartTest() throws Exception {
        mockMvc.perform(get("/api/cart/remove/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void addItemToCartTest() throws Exception {
        mockMvc.perform(get("/api/cart/add/1/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }


}
