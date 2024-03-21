package com.dev.gallefaceshoppingmall.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.gallefaceshoppingmall.entity.ParkingDetails;

@Repository
public interface ParkingDetailsRepository extends MongoRepository<ParkingDetails, String> {
}
