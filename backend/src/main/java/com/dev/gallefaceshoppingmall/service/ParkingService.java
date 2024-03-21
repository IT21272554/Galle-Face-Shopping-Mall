package com.dev.gallefaceshoppingmall.service;

import com.dev.gallefaceshoppingmall.entity.ParkingSlot;
import com.dev.gallefaceshoppingmall.entity.VehicleType;
import com.dev.gallefaceshoppingmall.repository.ParkingSlotRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParkingService {

    private final ParkingSlotRepository parkingSlotRepository;

    public ParkingService(ParkingSlotRepository parkingSlotRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
    }

    public ParkingSlot parkVehicle(String vehicleNumber, VehicleType vehicleType) {
        List<ParkingSlot> availableSlots = parkingSlotRepository.findByOccupied(false);
        if (!availableSlots.isEmpty()) {
            ParkingSlot slot = availableSlots.get(0);
            slot.setOccupied(true);
            slot.setVehicleNumber(vehicleNumber);
            slot.setVehicleType(vehicleType);
            return parkingSlotRepository.save(slot);
        }
        return null; // No available slots
    }

    public boolean freeParkingSlot(String vehicleNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'freeParkingSlot'");
    }

    public void addParkingSlots(int numberOfSlots) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addParkingSlots'");
    }

    public int getTotalParkingSlots() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTotalParkingSlots'");
    }

    public int getOccupiedParkingSlots() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOccupiedParkingSlots'");
    }
}
