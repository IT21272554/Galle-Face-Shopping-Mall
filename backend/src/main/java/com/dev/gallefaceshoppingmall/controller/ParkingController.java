package com.dev.gallefaceshoppingmall.controller;

import com.dev.gallefaceshoppingmall.entity.ParkingSlot;
import com.dev.gallefaceshoppingmall.entity.VehicleType;
import com.dev.gallefaceshoppingmall.service.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @PostMapping("/park")
    public ResponseEntity<String> parkVehicle(@RequestParam String vehicleNumber,
            @RequestParam VehicleType vehicleType) {
        ParkingSlot slot = parkingService.parkVehicle(vehicleNumber, vehicleType);
        if (slot != null) {
            return ResponseEntity.ok("Vehicle parked in slot number: " + slot.getSlotNumber());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parking full");
        }
    }

}
