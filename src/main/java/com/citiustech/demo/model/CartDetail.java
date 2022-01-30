package com.citiustech.demo.model;

import java.util.List;

/*
* Simple pojo class used for mapping with
* the fields of item and cart
* */
public class CartDetail {
    private double totalPrice;
    private long totalItems;
    private List<Items> itemList;

    public static class Items {
        private String itemName;
        private double itemPrice;
        private long purchasedQuantity;
        private String itemDiscription;

        public Items() {
        }

        public Items(String itemName, double itemPrice, long purchasedQuantity, String itemDiscription) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.purchasedQuantity = purchasedQuantity;
            this.itemDiscription = itemDiscription;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public double getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(double itemPrice) {
            this.itemPrice = itemPrice;
        }

        public long getPurchasedQuantity() {
            return purchasedQuantity;
        }

        public void setPurchasedQuantity(long purchasedQuantity) {
            this.purchasedQuantity = purchasedQuantity;
        }

        public String getItemDiscription() {
            return itemDiscription;
        }

        public void setItemDiscription(String itemDiscription) {
            this.itemDiscription = itemDiscription;
        }
    }

    public CartDetail() {
    }

    public CartDetail(double totalPrice, long totalItems, List<Items> itemList) {
        this.totalPrice = totalPrice;
        this.totalItems = totalItems;
        this.itemList = itemList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public List<Items> getItemList() {
        return itemList;
    }

    public void setItemList(List<Items> itemList) {
        this.itemList = itemList;
    }
}

