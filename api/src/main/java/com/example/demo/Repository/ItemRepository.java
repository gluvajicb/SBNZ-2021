package com.example.demo.Repository;

import com.example.demo.Model.Enums.ItemSlot;
import com.example.demo.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByName(String name);

    List<Item> findAllByItemSlot(ItemSlot itemSlot);
}
