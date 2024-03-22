package com.dev.gallefaceshoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.gallefaceshoppingmall.entity.Item;
import com.dev.gallefaceshoppingmall.service.ItemService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(value = "/save")
    private String saveItem(@RequestBody Item items)
    {

        itemService.saveOrUpdate(items);
        return items.get_id();
    }

    @GetMapping(value = "/getAll")
    private Iterable<Item>getItems()
    {
        return itemService.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Item update(@RequestBody Item item,@PathVariable(name = "id")String _id)
    {
        item.set_id(_id);
        itemService.saveOrUpdate(item);
        return item;
    }

    @DeleteMapping("/delete/{id}")
    private void deleteItem(@PathVariable("id")String _id)
    {
        itemService.deleteItem(_id);
    }

    @RequestMapping("/search/{id}")
    private Item getItemById(@PathVariable("id")String _id)
    {
        return itemService.getItemById(_id);
    }

}
