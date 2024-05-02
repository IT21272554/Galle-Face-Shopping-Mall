package com.dev.gallefaceshoppingmall.repository;

import com.dev.gallefaceshoppingmall.entity.Slot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends MongoRepository<Slot, String> {
}