package com.dev.gallefaceshoppingmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dev.gallefaceshoppingmall.entity.ParkingDetails;
import com.dev.gallefaceshoppingmall.service.ParkingDetailsService;

@RestController
@RequestMapping("/parking")
public class ParkingDetailsController {

    private final ParkingDetailsService service;

    @Autowired
    public ParkingDetailsController(ParkingDetailsService service) {
        this.service = service;
    }

    @GetMapping("/details")
    public ResponseEntity<?> getAllParkingDetails() {
        return ResponseEntity.ok(service.getAllParkingDetails());
    }

    @PostMapping("/details")
    public ResponseEntity<?> saveParkingDetails(@RequestBody ParkingDetails parkingDetails) {
        ParkingDetails savedDetails = service.saveParkingDetails(parkingDetails);
        return new ResponseEntity<>(savedDetails, HttpStatus.CREATED);
    }

}
