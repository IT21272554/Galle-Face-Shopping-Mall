package com.dev.gallefaceshoppingmall.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.gallefaceshoppingmall.entity.Item;
import com.dev.gallefaceshoppingmall.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired(required = true)
    ItemRepository itemRepository;

    public void saveOrUpdate(Item item){

        itemRepository.save(item);
    }
    
}
