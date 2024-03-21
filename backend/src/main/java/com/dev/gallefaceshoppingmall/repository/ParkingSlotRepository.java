package com.dev.gallefaceshoppingmall.repository;

import com.dev.gallefaceshoppingmall.entity.ParkingSlot;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ParkingSlotRepository extends MongoRepository<ParkingSlot, String> {
    List<ParkingSlot> findByOccupied(boolean occupied);
}
