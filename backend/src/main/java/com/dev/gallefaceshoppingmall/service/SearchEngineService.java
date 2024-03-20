package com.dev.gallefaceshoppingmall.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document; // Import only from org.bson
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import com.dev.gallefaceshoppingmall.entity.Item;
import com.dev.gallefaceshoppingmall.repository.SearchEngineRepository;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class SearchEngineService implements SearchEngineRepository {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<Item> searchItems(String query) {

        List<Item> items = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("ShoppingMall");
        MongoCollection<Document> collection = database.getCollection("items");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "default").append("text",
                        new Document("query", query).append("path", Arrays.asList("name", "description"))))));

        result.forEach(doc -> items.add(mongoConverter.read(Item.class, doc)));

        return items;
    }
}
