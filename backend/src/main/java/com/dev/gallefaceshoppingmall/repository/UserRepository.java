package com.dev.gallefaceshoppingmall.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.gallefaceshoppingmall.entity.Role;
import com.dev.gallefaceshoppingmall.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    Optional<User> findByEmail(String email);

    User findByRole(Role role);
}

/*package com.dev.gallefaceshoppingmall.repository;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.dev.gallefaceshoppingmall.entity.Role;
import com.dev.gallefaceshoppingmall.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long>{

    Optional<User> findbyEmail(String email);

    User findbyRole(Role role);
}*/
