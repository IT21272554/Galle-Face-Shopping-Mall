package com.dev.gallefaceshoppingmall.repository;

import com.dev.gallefaceshoppingmall.entity.SlotHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotHistoryRepository extends MongoRepository<SlotHistory, String> {
}