package com.dev.gallefaceshoppingmall.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.gallefaceshoppingmall.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

    User findByEmail(String email);
    
}