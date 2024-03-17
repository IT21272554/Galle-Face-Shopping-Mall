package com.dev.gallefaceshoppingmall.Service.ShopAndItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.gallefaceshoppingmall.Entity.ShopAndItemEntity.Item;
import com.dev.gallefaceshoppingmall.Repo.ShopAndItemRepo.ItemRepository;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public void saveOrUpdate(Item item){

        itemRepository.save(item);
    }
    
}
