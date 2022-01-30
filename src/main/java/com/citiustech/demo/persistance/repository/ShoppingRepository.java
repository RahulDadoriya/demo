package com.citiustech.demo.persistance.repository;

import com.citiustech.demo.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/*
* This repository basically representing service of a
* cart with functionality like adding items
* removing items from cart
*
* */
@Repository
@Transactional
public interface ShoppingRepository extends JpaRepository<Cart, Integer> {
    void deleteByItemId(int itemId);
}
