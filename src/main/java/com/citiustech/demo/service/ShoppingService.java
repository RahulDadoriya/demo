package com.citiustech.demo.service;

import com.citiustech.demo.model.Cart;
import com.citiustech.demo.model.CartDetail;

/*
* Adding method to this services will be
* the part of public APIs
* */
public interface ShoppingService {
    String addItem(int itemId, long itemQuantity);
    String removeItem(int itemId);
    String checkout();
    CartDetail getCartItems();
    Cart getItemById(int itemId);
}
