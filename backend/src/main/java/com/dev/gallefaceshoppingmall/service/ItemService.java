package com.dev.Gallefaceshoppingmall.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.Gallefaceshoppingmall.entity.Item;
import com.dev.Gallefaceshoppingmall.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired(required = true)
    ItemRepository itemRepository;

    public void saveOrUpdate(Item item){

        itemRepository.save(item);
    }
    
}
