package com.citiustech.demo.service.impl;

import com.citiustech.demo.model.CartDetail;
import com.citiustech.demo.model.Item;
import com.citiustech.demo.persistance.repository.ItemRepository;
import com.citiustech.demo.persistance.repository.ShoppingRepository;
import com.citiustech.demo.service.ShoppingService;
import com.citiustech.demo.model.Cart;
import com.citiustech.demo.utilities.CalculateTax;
import com.citiustech.demo.model.CartDetail.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    private ShoppingRepository shoppingRepository;
    @Autowired
    private ItemRepository itemRepository;


    /*
    * For adding items to the cart the flow is like
    * checking item from item table based on itemId fetch that item ->
    * checking available quantity -> based on available quantity we have added it to cart
    * */
    @Override
    public String addItem(int itemId, long itemQuantity) {
        Cart cart = new Cart(); // Creating new object of cart
        Item item = itemRepository.getById(itemId); // getting item from inventory/table with itemId

        if (item.getItemAvailableQuantity() > 0) { // checking available quantity of item
            cart.setTotalItems(itemQuantity); // updating cart fields
            cart.setItemId(itemId);
            cart.setTotalPrice(item.getItemPrice());
            long temp = item.getItemAvailableQuantity() - itemQuantity; // updating available item's in inventory/table based on itemQunatity
            item.setItemAvailableQuantity(temp); // updating quantity
            shoppingRepository.save(cart); // updating table
            return "Saved";
        }
        return "Item not available";
    }

    /*
    * Deleting item from cart with itemId
    * */
    @Override
    public String removeItem(int itemId) {
        shoppingRepository.deleteByItemId(itemId);
        return "Item Removed";
    }

    /*
    * Getting cart details and updating price with tax of each
    * purchased item in cart with quantity it's flow is like
    * getting all purchased item from cart -> iterating cart
    * and getting itemId -> based on itemId we're fetching item ->
    * calculating total price with tax -> updating cartdetails with total item price and purchased quantity ->
    * returning cart details with updated values.
    * */
    @Override
    public CartDetail getCartItems() {
        List<Cart> carts = shoppingRepository.findAll(); // getting all items present in cart
        CartDetail cartDetail = new CartDetail();
        List<Items> itemList = new ArrayList<>();
        // For each cart item we're updating price with tax value
        carts.forEach(item -> {
            int itemId = item.getItemId();
            Item tempItem = itemRepository.getById(itemId);
            itemList.add(new Items(tempItem.getItemName(), CalculateTax.calculateTaxAmount(tempItem.getItemPrice() * item.getTotalItems()), item.getTotalItems(), tempItem.getItemDiscription()));
        });
        // updating total items and adding them
        cartDetail.setTotalItems(itemList.stream().mapToLong(Items::getPurchasedQuantity).sum());
        // streaming and adding price of item to total
        double sum = itemList.stream().mapToDouble(Items::getItemPrice).sum();
        cartDetail.setTotalPrice(sum);
        cartDetail.setItemList(itemList);
        return cartDetail;
    }

    /*
    * Checkout flow is like
    * getting cart with total price and total items in it ->
    * setting them to a msg and returing it
    * */
    @Override
    public String checkout() {
        List<Cart> checkout = shoppingRepository.findAll();
        String msg = "Your cart is empty";
        if (!checkout.isEmpty()) {
            double totalPrice = checkout.stream().mapToDouble(Cart::getTotalPrice).sum();
            long totalItem = checkout.stream().mapToLong(Cart::getTotalItems).sum();
            msg = "Total items in cart purchased: " + totalItem + "\n"
                    + "Total price with tax: $ " + CalculateTax.calculateTaxAmount(totalPrice*totalItem) + "\n"
                    + "Thank you for Shopping with us";
            shoppingRepository.deleteAll();
            return msg;
        }
        return msg;
    }

    /*
    * Getting item based on itemId
    * */
    @Override
    public Cart getItemById(int itemId) {
        return shoppingRepository.getById(itemId);
    }


}
