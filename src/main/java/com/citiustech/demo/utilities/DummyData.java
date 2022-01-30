package com.citiustech.demo.utilities;

import com.citiustech.demo.model.Item;
import com.citiustech.demo.persistance.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
* Command line runner for pre-populating data into inventory/table
* of item for testing purpose
*
* */
@Component
public class DummyData implements CommandLineRunner {
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Mango drink", "Drinks", "ABC123", 120.2, 10, "Mango Flavoured non-alcoholic drink"));
        itemList.add(new Item("Coke", "Drinks", "213BCA", 150.2, 10, "Coke non-alcoholic drink"));
        itemList.add(new Item("Apple drink", "Drinks", "321EFG", 199.2, 10, "Real apple Flavoured non-alcoholic drink"));
        itemList.add(new Item("Pepsi", "Drinks", "123WER", 165, 10, "Soda water with non-alcoholic drink"));
        itemList.add(new Item("Lecchi drink", "Drinks", "231REE", 60, 10, "Lecchies Flavoured non-alcoholic drink"));
        itemList.add(new Item("Real fruit drink", "Drinks", "KML123", 125.5, 10, "Real mixed fruits Flavoured non-alcoholic drink"));
        itemList.add(new Item("iPhone 11 mini", "Electronics ", "434KLYE", 399.9, 5, "New Apple iPhone 11 mini with lots of new features"));
        itemList.add(new Item("iPhone 13 Pro", "Electronics ", "334KLYE", 899.9, 6, "New Apple iPhone 13 Pro with lots of new features"));
        itemList.add(new Item("iPhone 13 Pro max", "Electronics ", "674KLYE", 999.9, 9, "New Apple iPhone 13 Pro max with lots of new features"));
        itemList.add(new Item("iPhone 12 mini", "Electronics ", "884KLYE", 299.9, 7, "New Apple iPhone 12 mini with lots of new features"));

        itemRepository.saveAll(itemList);
    }
}
