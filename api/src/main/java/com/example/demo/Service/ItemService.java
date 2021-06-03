package com.example.demo.Service;

import com.example.demo.Model.Enums.ItemSlot;
import com.example.demo.Model.Item;
import com.example.demo.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAllItemsByItemSlot(ItemSlot itemSlot) {
        return this.itemRepository.findAllByItemSlot(itemSlot);
    }

    public Item findByName(String name) {
        return this.itemRepository.findByName(name);
    }

}
