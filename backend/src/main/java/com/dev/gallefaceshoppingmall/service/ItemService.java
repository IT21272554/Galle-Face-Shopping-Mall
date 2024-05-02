package com.dev.gallefaceshoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.gallefaceshoppingmall.entity.Item;
import com.dev.gallefaceshoppingmall.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired(required = true)
    ItemRepository itemRepository;

    public void saveOrUpdate(Item item) {

        itemRepository.save(item);
    }

    public List<Item> allItems() {

        List<Item> items = itemRepository.findAll();

        return items;
    }

    public List<Item> getPopular() {
        List<Item> items = itemRepository.findByViewCountGreaterThan(10);

        return items;
    }

}
