package com.citiustech.demo.controller;

import com.citiustech.demo.model.Cart;
import com.citiustech.demo.model.CartDetail;
import com.citiustech.demo.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/cart")
public class ShoppingController {
    @Autowired
    private ShoppingService shoppingService;


    /*@GetMapping(value = "/add/{id}/{itemQuantity}")
    public String addItemToCart(@PathVariable("id") int itemId, @PathVariable("itemQuantity") long itemQuantity) {
        // Based on itemId and itemQuantity we're adding items to the cart
        return shoppingService.addItem(itemId, itemQuantity);
    }*/

    @PostMapping(value = "/add")
    public void addItemToCart(@RequestBody ItemObject addItem) {
        // Based on itemId and itemQuantity we're adding items to the cart
        shoppingService.addItem(addItem.getItemId(), addItem.getItemQuantity());
    }

    @DeleteMapping(value = "/remove")
    public void removeItemFromCart(@RequestBody ItemObject deleteItem) {
        // Based on itemId we are removing items that are present in cart
        shoppingService.removeItem(deleteItem.getItemId());
    }

    @GetMapping(value = "/getCart")
    public ResponseEntity<CartDetail> getCartInfo() {
        // This will return cart details
        return new ResponseEntity<CartDetail>(shoppingService.getCartItems(), HttpStatus.OK);
    }

    @GetMapping(value = "/checkout")
    public String checkout() {
        // After successful purchased of cart items it will be deleted
        return shoppingService.checkout();
    }

    @GetMapping(value = "/item/{itemId}")
    public Cart getItem(@PathVariable("itemId") int itemId) {
        // For checking single item with itemId in cart
        return shoppingService.getItemById(itemId);
    }

    static class ItemObject {
        private int itemId;
        private long itemQuantity;

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public long getItemQuantity() {
            return itemQuantity;
        }

        public void setItemQuantity(long itemQuantity) {
            this.itemQuantity = itemQuantity;
        }
    }
}
