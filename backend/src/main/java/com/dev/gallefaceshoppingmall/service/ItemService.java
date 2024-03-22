package com.dev.gallefaceshoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.gallefaceshoppingmall.entity.Item;
import com.dev.gallefaceshoppingmall.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void saveOrUpdate(Item items){

        itemRepository.save(items);
    }

    public Iterable<Item> listAll() {
       
        return this.itemRepository.findAll();
    }

    public void deleteItem(String _id) {
        
        itemRepository.deleteById(_id);
    }

    public Item getItemById(String _id) {
        
        return itemRepository.findById(_id).get();
    }

}
