package com.citiustech.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/*
* Simple entity with minimal amount of fields
* that represent a single item.
* */

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String itemName;
    @Column(nullable = false)
    private String itemType;
    @Column(nullable = false)
    private String itemCode;
    @Column(nullable = false)
    private double itemPrice;
    @Column(nullable = false)
    private long itemAvailableQuantity;
    private String itemDiscription;

    public Item() {
    }

    public Item(String itemName, String itemType, String itemCode, double itemPrice, long itemAvailableQuantity, String itemDiscription) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemCode = itemCode;
        this.itemPrice = itemPrice;
        this.itemAvailableQuantity = itemAvailableQuantity;
        this.itemDiscription = itemDiscription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public long getItemAvailableQuantity() {
        return itemAvailableQuantity;
    }

    public void setItemAvailableQuantity(long itemAvailableQuantity) {
        this.itemAvailableQuantity = itemAvailableQuantity;
    }

    public String getItemDiscription() {
        return itemDiscription;
    }

    public void setItemDiscription(String itemDiscription) {
        this.itemDiscription = itemDiscription;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemAvailableQuantity=" + itemAvailableQuantity +
                ", itemDiscription='" + itemDiscription + '\'' +
                '}';
    }
}
