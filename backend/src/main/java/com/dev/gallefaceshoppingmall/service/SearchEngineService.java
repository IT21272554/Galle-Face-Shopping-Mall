package com.dev.gallefaceshoppingmall.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

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

        // Create a regex pattern to match items where name or description starts with
        // the query string
        Pattern pattern = Pattern.compile("^" + query, Pattern.CASE_INSENSITIVE);

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                // Match documents where name or description matches the regex pattern
                new Document("$match", new Document("$or", Arrays.asList(
                        new Document("name", new Document("$regex", pattern)),
                        new Document("description", new Document("$regex", pattern)))))));
        System.out.println("RESULT" + result.first().toString());
        result.forEach(doc -> items.add(mongoConverter.read(Item.class, doc)));
        System.out.println("RESULT VARIABLE" + result);
        return items;
    }

    @Override
    public List<Item> searchItemsInCategory(String query, String category) {

        List<Item> items = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("ShoppingMall");
        MongoCollection<Document> collection = database.getCollection("items");

        // Create a regex pattern to match items where name or description starts with
        // the query string
        Pattern pattern = Pattern.compile("^" + query, Pattern.CASE_INSENSITIVE);
        //Document categoryFilter = new Document("category", category);

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                // Match documents where name or description matches the regex pattern
                new Document("$match", new Document("$or", Arrays.asList(
                        new Document("name", new Document("$regex", pattern)),
                        new Document("description", new Document("$regex", pattern))
                        ))),
                        new Document("$match", new Document("category", category))
                        ));
        System.out.println("RESULT" + result.first().toString());
        result.forEach(doc -> items.add(mongoConverter.read(Item.class, doc)));
        System.out.println("RESULT VARIABLE" + result);
        return items;
    }

    @Override
    public List<Item> searchItemsByCategory(String category) {

        MongoDatabase database = mongoClient.getDatabase("ShoppingMall");
        MongoCollection<Document> collection = database.getCollection("items");

        List<Item> items = new ArrayList<>();
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "category").append("text",
                        new Document("query", category).append("path", "category")))));

        result.forEach(doc -> items.add(mongoConverter.read(Item.class, doc)));

        return items;
    }

}
