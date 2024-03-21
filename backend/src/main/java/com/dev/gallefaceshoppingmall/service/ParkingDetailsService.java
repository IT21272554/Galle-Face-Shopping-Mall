package com.dev.gallefaceshoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.gallefaceshoppingmall.entity.ParkingDetails;
import com.dev.gallefaceshoppingmall.repository.ParkingDetailsRepository;

import java.util.List;

@Service
public class ParkingDetailsService {

    private final ParkingDetailsRepository repository;

    @Autowired
    public ParkingDetailsService(ParkingDetailsRepository repository) {
        this.repository = repository;
    }

    public List<ParkingDetails> getAllParkingDetails() {
        return repository.findAll();
    }

    public ParkingDetails saveParkingDetails(ParkingDetails parkingDetails) {
        return repository.save(parkingDetails);
    }

}
