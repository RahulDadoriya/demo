package com.citiustech.demo.persistance.repository;

import com.citiustech.demo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
